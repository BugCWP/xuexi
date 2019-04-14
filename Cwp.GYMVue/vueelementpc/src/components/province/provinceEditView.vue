<template>
  <div>
    <div>
      <el-row class="listbtnbox">
        <el-col :span="2" class="listtitle">省</el-col>
        <el-col :span="17">&nbsp;</el-col>
        <el-col :span="2">
          <template>
            <el-button type="text" icon="el-icon-tickets" class="listbutton" @click="goAddPage" v-if="isEditOrCreate()">保存</el-button>
            <el-button type="text" icon="el-icon-tickets" class="listbutton" @click="goEdit" v-else>修改</el-button>
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
            <el-form-item label="省名称" prop="name">
              <el-input v-model="formData.name" clearable></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "provinceEdit",
  data() {
    return {
      routerData: {
        router: "provinceList",
        id: ""
      },
      formData: {
        name: ""
      },
      rules: {
        name: [{ required: true, message: "请输入省名称", trigger: "change" }]
      },
      editId: ""
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
        .catch(err=>{
          this.$message.error("添加失败");
        });
    },
    goEdit(){
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
        .catch(err=>{
          this.$message.error("修改失败");
        });
    },
    goback() {
      this.$emit("listionRouter", this.routerData);
    },
    isEdit() {
      if (this.editId != null && this.editId != "") {
        var url = "/api/province/GetData?id="+this.editId;
        this.$axios
          .get(url)
          .then(resp => {
            this.formData=resp.data;
          })
          .catch();
      }
    },
    isEditOrCreate(){
       if (this.editId != null && this.editId != ""){
         return false;
       }else{
         return true;
       }
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
.row_padding {
  padding-bottom: 40px;
  padding-top: 20px;
}
</style>
