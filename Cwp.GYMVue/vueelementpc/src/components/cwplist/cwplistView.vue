<template>
  <div>
    <div>
      <el-row class="listbtnbox">
        <el-col :span="3" class="listtitle" v-if="titledisabled">{{title}}</el-col>
        <el-col :span="11">&nbsp;</el-col>
        <el-col :span="2">
          <template>
            <el-button
              type="text"
              icon="el-icon-plus"
              class="listbutton"
              @click="goAddPage"
              v-if="this.createrbtn"
            >新建</el-button>
          </template>
        </el-col>
        <el-col :span="2">
          <template>
            <el-button
              type="text"
              icon="el-icon-delete"
              class="listbutton"
              @click="deletebtnclick"
              v-if="this.deletebtn"
            >删除</el-button>
          </template>
        </el-col>
        <el-col :span="5">
          <el-input placeholder="请输入内容" v-model="search" size="medium" v-if="this.searchbtn">
            <el-button slot="append" icon="el-icon-search" @click="loadData"></el-button>
          </el-input>
        </el-col>
      </el-row>
    </div>
    <div class="listbox">
      <el-row>
        <el-col :span="24">
          <el-table
            ref="multipleTable"
            :data="tableData"
            tooltip-effect="dark"
            style="width: 100%"
            @selection-change="handleSelectionChange"
            :stripe="isstripe"
            v-loading="loading"
            @row-dblclick="goEdit"
          >
            <el-table-column type="selection" width="80"></el-table-column>
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
            <el-table-column fixed="right" label="操作" width="150" v-if="btnagree">
              <template slot-scope="scope">
                <div style="display:inline-block">
                  <el-button
                    type="success"
                    @click="handleClickagree(scope.row)"
                    v-if="scope.row['status']=='待审核'"
                    size="mini"
                  >同意</el-button>
                </div>
                <div style="display:inline-block">
                  <el-button
                    type="danger"
                    @click="handleClicknotagree(scope.row)"
                    v-if="scope.row['status']=='待审核'"
                    size="mini"
                  >不同意</el-button>
                </div>
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
    createrbtn: {
      type: Boolean,
      default: true
    },
    deletebtn: {
      type: Boolean,
      default: true
    },
    searchbtn: {
      type: Boolean,
      default: true
    },
    columns: {
      type: Array,
      required: true,
      validator: value => value && value.length >= 1
    },
    title: {
      type: String
    },
    routerData: {
      type: Object
    },
    readOnly: {
      type: Boolean,
      default: false
    },
    titledisabled: {
      type: Boolean,
      default: true
    },
    paramList: {
      type: Object,
      default: () => null
    },
    btnagree: {
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
      search: "",
      isstripe: true,
      multipleSelection: [],
      loading: false
    };
  },
  mounted() {
    this.loadData();
  },
  methods: {
    handleSelectionChange(data) {
      this.multipleSelection = data;
    },
    handleCurrentChange(data) {
      this.pageIndex = data;
      this.loadData();
    },
    goAddPage() {
      this.routerData.id = "";
      this.$emit("listionRouter", this.routerData);
    },
    goEdit(data) {
      if (this.readOnly) {
        this.routerData.router = this.controllerName + "ReadOnly";
        this.routerData.id = data.id;
        this.$emit("listionRouter", this.routerData);
      } else {
        this.routerData.id = data.id;
        this.$emit("listionRouter", this.routerData);
      }
    },
    loadData() {
      this.loading = true;
      var url =
        "/api/" +
        this.controllerName +
        "/GetDataList?pageIndex=" +
        this.pageIndex +
        "&pageSize=" +
        this.pageSize +
        "&search=" +
        this.search;
      if (this.paramList != null) {
        url = url + "&paramList=" + JSON.stringify(this.paramList);
      }
      this.$axios
        .get(url)
        .then(resp => {
          this.tableData = resp.data.list;
          this.total = parseInt(resp.data.Count);
          this.loading = false;
        })
        .catch(err => {
          this.loading = false;
        });
    },
    deletebtnclick() {
      var url = "/api/" + this.controllerName + "/DeleteData";
      this.$axios
        .post(url, this.multipleSelection)
        .then(resp => {
          this.loadData();
          this.$message({
            message: "成功删除" + resp.data + "条省记录信息",
            type: "success"
          });
        })
        .catch(err => {
          this.$message.error("删除失败");
        });
    },
    handleClickagree(value) {
      value.status="通过";
      var url = "/api/" + this.controllerName + "/UpdateData";
      this.$axios
        .post(url, value)
        .then(resp => {
          this.loadData();
          this.$message({
            message: "审核成功",
            type: "success"
          });
        })
        .catch(err => {
          this.$message.error("审核失败");
        });
    },
    handleClicknotagree(value) {
      value.status="驳回";
      var url = "/api/" + this.controllerName + "/UpdateData";
      this.$axios
        .post(url, value)
        .then(resp => {
          this.loadData();
          this.$message({
            message: "审核成功",
            type: "success"
          });
        })
        .catch(err => {
          this.$message.error("审核失败");
        });
    }
  }
};
</script>

<style>
.listbtnbox {
  width: 100%;
  height: 60px;
  padding-top: 10px;
  background-color: white;
}
.listbox {
  background-color: white;
  height: 350px;
  width: 96%;
  margin: 20px;
}
.listtitle {
  line-height: 40px;
}
.listbutton {
  color: #6c6c6c;
}
</style>

