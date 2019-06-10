<template>
  <div>
    <div class="headbox">
      <i class="el-icon-arrow-left" style="font-size:30px;color:white;" @click="goback"></i>
    </div>
    <div style="width:100%;height:60px;"></div>
    <el-row>
      <el-col :span="4">&nbsp;</el-col>
      <el-col :span="16">
        <el-row style="margin-top:15px">
          <el-col :span="6" style="padding-top:10px">输入密码:</el-col>
          <el-col :span="16">
            <el-input v-model="password1" clearable type="password"></el-input>
          </el-col>
        </el-row>
        <el-row style="margin-top:15px">
          <el-col :span="6" style="padding-top:10px">再次输入:</el-col>
          <el-col :span="16">
            <el-input v-model="password2" clearable type="password"></el-input>
          </el-col>
        </el-row>
        <el-row style="margin-top:25px">
          <el-col :span="2">&nbsp;</el-col>
          <el-col :span="20">
            <el-button type="primary" style="width:100%" @click="changepassword">确认</el-button>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      account: "",
      customerdata: {},
      password1: "",
      password2: ""
    };
  },
  mounted() {
    if (this.$route.query.id != undefined) {
      this.account = this.$route.query.id;
      this.getLoad();
    }
  },
  methods: {
    getLoad() {
      if (this.account != "") {
        var url = "/api/customer/GetData";
        var formData = {
          accountnumber: this.account
        };
        var that = this;
        this.$axios
          .post(url, formData)
          .then(resp => {
            that.customerdata = resp.data;
          })
          .catch(err => {});
      }
    },
    goback() {
      this.$router.push({
        path: "customermyself",
        query: {
          id: this.account
        }
      });
    },
    changepassword() {
      if (this.password1 == "") {
        this.$message.error("请输入密码");
      } else if (this.password2 == "") {
        this.$message.error("请在次输入密码");
      } else if (this.password1 != this.password2) {
        this.$message.error("两次密码输入不同，请重新输入");
        this.password1 = "";
        this.password2 = "";
      } else {
        this.customerdata.password=this.password1;
        var url = "/api/customer/UpdateData";
        this.$axios
          .post(url, this.customerdata)
          .then(resp => {
            this.$message({
              message: "修改成功",
              type: "success"
            });
            this.$router.push({
              path: "/customermyself",
              query: {
                id: this.account
              }
            });
          })
          .catch(err => {
            this.$message.error("修改失败");
          });
      }
    }
  }
};
</script>

<style>
.headbox {
  background-color: slategray;
  text-align: left;
  height: 35px;
  padding-top: 10px;
}
</style>
