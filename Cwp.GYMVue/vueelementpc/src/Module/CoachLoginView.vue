<template>
  <div class="mainbody">
    <el-row>
      <el-col :span="24">
        <img src="/static/img/loginimg.jpg" width="100%" class="loginimg">
      </el-col>
    </el-row>
    <el-row style="padding-top:50px">
      <el-col :span="4">&nbsp;</el-col>
      <el-col :span="16">
        <el-row style="padding-bottom:15px">
          <el-col :span="24" style="text-align:centre">教练登陆</el-col>
        </el-row>
        <el-row style="padding-bottom:15px">
          <el-col :span="6" style="padding-top:10px">用户名:</el-col>
          <el-col :span="16">
            <el-input v-model="form.account" placeholder="请输入账号"></el-input>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6" style="padding-top:10px">密码:</el-col>
          <el-col :span="16">
            <el-input type="password" v-model="form.password" placeholder="请输入密码"></el-input>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-button type="primary" style="width:100%;margin-top:60px" @click="loginbtn">登陆</el-button>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-button style="width:100%;margin-top:10px" @click="registerbtn">注册</el-button>
          </el-col>
        </el-row>
      </el-col>
      <el-col :span="4"></el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        account: "",
        password: ""
      }
    };
  },
  mounted() {},
  methods: {
    loginbtn() {
      let url = "http://localhost:50379/api/Login/coachLogin";
      var that = this;
      this.$axios
        .post(url, this.form)
        .then(function(response) {
          if (response.data == "success") {
            that.$router.push({
              name: "coachHome",
              query: {
                id: that.form.account
              }
            });
          } else {
            that.$message.error("登陆失败，请输入正确的账号与密码");
          }
        })
        .catch(function(error) {
          that.$message.error("登陆失败，请输入正确的账号与密码");
        });
    },
    registerbtn() {
      this.$router.push("/coachRegister");
    }
  }
};
</script>

<style>
.mainbody {
  width: 100%;
}
.loginimg {
  filter: blur(2px);
}
</style>
