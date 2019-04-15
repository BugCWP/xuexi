<template>
  <div>
    <el-input :placeholder="placeholder" v-model="inputdata" clearable :disabled="disabled">
      <el-button slot="append" icon="el-icon-search" @click="showProvince" :disabled="disabled"></el-button>
    </el-input>
    <el-dialog :title="title" :visible.sync="dialogVisible" :width="width">
      <div>
        <div>
          <el-row>
            <el-col :span="14">&nbsp;</el-col>
            <el-col :span="10">
              <el-input placeholder="请输入内容" v-model="search" size="medium">
                <el-button slot="append" icon="el-icon-search" @click="loadData"></el-button>
              </el-input>
            </el-col>
          </el-row>
        </div>
        <div class="listDialogbox">
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
              >
                <el-table-column type="selection" width="80"></el-table-column>
                <el-table-column
                  v-for="(column, index) in columns"
                  :key="index"
                  :prop="column.prop"
                  :label="column.label"
                  :width="column.width?column.width:''"
                  :sortable="column.sortable ? 'custom' : false"
                ></el-table-column>
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
          <span slot="footer" class="dialog-footer">
            <el-col :span="16">&nbsp;</el-col>
            <el-col :span="4">
              <el-button type="primary" @click="chancebtn">确定</el-button>
            </el-col>
            <el-col :span="4">
              <el-button @click="closedialog">取消</el-button>
            </el-col>
          </span>
        </div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "cwplookup",
  props: {
    title: {
      type: String,
      default: ""
    },
    width: {
      type: String,
      default: "50%"
    },
    controllerName: {
      type: String,
      required: true
    },
    placeholder: {
      type: String,
      default: "请选择"
    },
    inputdata: {
      type: String
    },
    columns: {
      type: Array,
      required: true,
      validator: value => value && value.length >= 1
    },
    disabled: {
      type: Boolean,
      default: false
    },
    params: {
      type: Object,
      default: () => null
    }
  },
  data() {
    return {
      dialogVisible: false,
      tableData: [],
      pageSize: 5,
      pageIndex: 1,
      total: 0,
      currentPage: 1,
      search: "",
      loading: false,
      isstripe: true,
      multipleSelection: []
    };
  },
  mounted() {},
  methods: {
    loadData() {
      this.loading = true;
      var url =
        "/api/" +
        this.controllerName +
        "/GetDataList?pageIndex=" +
        this.pageIndex +
        "&pageSize=" +
        this.pageSize;
      if (this.search != null&&this.search!="") {
        url = url + "&search=" + this.search;
      }
      if (this.params != null) {
        url = url + "&paramList=" + JSON.stringify(this.params);
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
    showProvince() {
      this.dialogVisible = true;
      this.loadData();
    },
    handleCurrentChange(data) {
      this.pageIndex = data;
      this.loadData();
    },
    handleSelectionChange(data) {
      this.multipleSelection = data;
    },
    closedialog() {
      this.dialogVisible = false;
    },
    chancebtn() {
      if (this.multipleSelection.length == 0) {
        this.$message.error("请选择一个选项");
      } else if (this.multipleSelection.length > 1) {
        this.$message.error("只可选择一项");
      } else {
        this.dialogVisible = false;
        this.inputdata = this.multipleSelection[0].name;
        this.$emit("lookdata", this.multipleSelection[0]);
      }
    }
  }
};
</script>

<style>
</style>
