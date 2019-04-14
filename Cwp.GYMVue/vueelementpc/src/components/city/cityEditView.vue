<template>
  <div>
    <div>
      <el-row class="listbtnbox">
        <el-col :span="2" class="listtitle">市</el-col>
        <el-col :span="17">&nbsp;</el-col>
        <el-col :span="2">
          <template>
            <el-button
              type="text"
              icon="el-icon-tickets"
              class="listbutton"
              @click="goAddPage"
              v-if="isEditOrCreate()"
            >保存</el-button>
            <el-button
              type="text"
              icon="el-icon-tickets"
              class="listbutton"
              @click="goEdit"
              v-else
            >修改</el-button>
          </template>
        </el-col>
        <el-col :span="2">
          <template>
            <el-button type="text" icon="el-icon-back" class="listbutton" @click="goback">返回</el-button>
          </template>
        </el-col>
      </el-row>
    </div>
    <div class="listbox">
      <el-form :model="formData" ref="form" :rules="rules" label-width="120px">
        <el-row class="row_padding">
          <el-col class="section_title" :span="3">基本信息</el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="市名称" prop="name">
              <el-input v-model="formData.name" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="上级省" prop="name">
              <el-input placeholder="请选择上级市" v-model="formData.provincename" clearable>
                <el-button slot="append" icon="el-icon-search" @click="showProvince"></el-button>
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </div>
    <el-dialog title="省" :visible.sync="dialogVisible" width="50%">
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
                <el-table-column prop="name" label="名称" width="450"></el-table-column>
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
          <el-row style="padding-top:30px">
              <el-col :span="16">&nbsp;</el-col>
              <el-col :span="4">
                  <el-button type="primary">确定</el-button>
              </el-col>
              <el-col :span="4">
                  <el-button>取消</el-button>
              </el-col>
          </el-row>
        </div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "cityEdit",
  data() {
    return {
      routerData: {
        router: "cityList",
        id: ""
      },
      formData: {
        id: "",
        name: "",
        prvinceid: "",
        provincename: ""
      },
      rules: {
        name: [{ required: true, message: "请输入省名称", trigger: "change" }]
      },
      editId: "",
      dialogVisible: false,
      tableData: [],
      pageSize: 5,
      pageIndex: 1,
      total: 0,
      currentPage: 1,
      search: "",
      loading:false,
      isstripe:true,
      multipleSelection: [],
    };
  },
  props: {
    editId: String,
    required: true
  },
  mounted() {
    this.isEdit();
  },
  methods: {
    goAddPage() {
      var url = "/api/province/CreateData";
      this.$axios
        .post(url, this.formData)
        .then(resp => {
          this.$message({
            message: "添加成功",
            type: "success"
          });
          this.goback();
        })
        .catch(err => {
          this.$message.error("添加失败");
        });
    },
    goEdit() {
      var url = "/api/province/UpdateData";
      this.$axios
        .post(url, this.formData)
        .then(resp => {
          this.$message({
            message: "修改成功",
            type: "success"
          });
          this.goback();
        })
        .catch(err => {
          this.$message.error("修改失败");
        });
    },
    goback() {
      this.$emit("listionRouter", this.routerData);
    },
    isEdit() {
      if (this.editId != null && this.editId != "") {
        var url = "/api/province/GetData?id=" + this.editId;
        this.$axios
          .get(url)
          .then(resp => {
            this.formData = resp.data;
          })
          .catch();
      }
    },
    isEditOrCreate() {
      if (this.editId != null && this.editId != "") {
        return false;
      } else {
        return true;
      }
    },
    loadData() {
      this.loading = true;
      var url =
        "/api/province/GetDataList?pageIndex=" +
        this.pageIndex +
        "&pageSize=" +
        this.pageSize +
        "&search="+this.search;
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
    showProvince(){
        this.dialogVisible=true;
        this.loadData();
    },
    handleCurrentChange(data){
        this.pageIndex = data;
        this.loadData();
    },
    handleSelectionChange(data){
        console.log(data[0]);
        this.multipleSelection=data[0];
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
.listDialogbox{
  background-color: white;
  height: 350px;
  width: 90%;
  margin: 20px;
}
.listtitle {
  line-height: 40px;
}
.listbutton {
  color: #6c6c6c;
}
.row_padding {
  padding-bottom: 40px;
  padding-top: 10px;
  margin-bottom: 20px;
}
</style>
