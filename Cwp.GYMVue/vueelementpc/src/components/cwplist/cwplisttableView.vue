<template>
  <div>
    <div class="listboxtable">
      <el-row>
        <el-col :span="24">
          <el-table
            ref="multipleTable"
            :data="tableData"
            tooltip-effect="dark"
            style="width: 100%"
            :stripe="isstripe"
            v-loading="loading"
            @row-dblclick="goEdit"
          >
            <el-table-column
              v-for="(column, index) in columns"
              :key="index"
              :prop="column.prop"
              :label="column.label"
              :width="column.width?column.width:''"
              :sortable="column.sortable ? 'custom' : false"
            >
              <template slot-scope="scope">
                <template
                  v-if="column.type==='datetime'"
                >{{scope.row[column.prop]|moment('YYYY-MM-DD HH:mm')}}</template>
                <template v-else>{{scope.row[column.prop]}}</template>
              </template>
            </el-table-column>
          </el-table>
        </el-col>
      </el-row>
      <el-row>
        <el-col>
          <div class="block">
            <el-pagination
              @current-change="handleCurrentChange"
              :current-page="currentPage"
              :page-size="pageSize"
              layout="total, prev, pager, next, jumper"
              :total="total"
            ></el-pagination>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "cwpList",
  props: {
    controllerName: {
      type: String,
      required: true
    },
    columns: {
      type: Array,
      required: true,
      validator: value => value && value.length >= 1
    },
    paramList: {
      type: Object,
      default: () => null
    },
    loaddata: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      tableData: [],
      pageSize: 5,
      pageIndex: 1,
      total: 0,
      currentPage: 1,
      isstripe: true,
      loading: false
    };
  },
  methods: {
    handleCurrentChange(data) {
      this.pageIndex = data;
      this.loadData();
    },
    async loadData() {
      this.loading = true;
      var url =
        "/api/" +
        this.controllerName +
        "/GetDataList?pageIndex=" +
        this.pageIndex +
        "&pageSize=" +
        this.pageSize;
      if (this.paramList != null) {
        url = url + "&paramList=" + JSON.stringify(this.paramList);
      }
      if (this.loaddata) {
        await this.$axios
          .get(url)
          .then(resp => {
            this.tableData = resp.data.list;
            this.total = parseInt(resp.data.Count);
            this.loading = false;
          })
          .catch(err => {
            this.loading = false;
          });
      }
    }
  },
  watch:{
      'loaddata':'loadData',
  }
};
</script>

<style>
.listboxtable {
  background-color: white;
  width: 100%;
  padding: 0;
}
.listtitle {
  line-height: 40px;
}
.listbutton {
  color: #6c6c6c;
}
</style>

