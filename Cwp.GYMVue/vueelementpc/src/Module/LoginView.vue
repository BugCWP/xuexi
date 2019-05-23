<template>
  <div class="loginbody">
    <el-row></el-row>
    <el-col class="loginleft">
      <img src="/static/img/loginimg.jpg" class="loginimg">
      <div class="imgcover"></div>
    </el-col>
    <el-col class="loginright">
      <el-form class="body_form" ref="form" :model="form" :rules="rules" label-width="100px">
        <el-row class="form_section">
          <el-col class="section_title">GYM CRM</el-col>
        </el-row>
        <el-row>
          <el-col :span="18">
            <el-form-item label="账号" prop="account">
              <el-input placeholder="Please input Username" v-model="form.account"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="18">
            <el-form-item label="密码" prop="password">
              <el-input
                type="password"
                placeholder="Please enter your password"
                v-model="form.password"
              ></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col>
            <el-form-item>
              <el-checkbox v-model="remumberPass">记住密码</el-checkbox>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="14">
            <div>&nbsp;</div>
          </el-col>
          <el-col :span="6">
            <el-button type="primary" @click="userLogin">登陆</el-button>
          </el-col>
        </el-row>
      </el-form>
    </el-col>
  </div>
</template>
<script>
// const axios = require("axios");
// const qs = require("qs");
export default {
  name: "Login",
  data() {
    return {
      form: {
        account: "",
        password: ""
      },
      remumberPass: false,
      rules: {
        account: [{ required: true, message: "账号不能为空", trigger: "blur" }],
        password: [{ required: true, message: "密码不能为空", trigger: "blur" }]
      }
    };
  },
  methods: {
    userLogin() {
      let url = "http://localhost:50379/api/Login/personLogin";
      var that = this;
      this.$axios
        .post(url, this.form)
        .then(function(response) {
          if (response.data == "success") {
            that.$router.push({
              name: "gymHome",
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
    goRegistered() {
      this.$router.push("/Register");
    }
  }
};
</script>
<style>
.loginbody {
  display: flex;
  width: 100%;
  height: 100%;
}
.loginleft {
  width: 65%;
  height: 100%;
}
.loginright {
  width: 35%;
  height: 100%;
}
.loginimg {
  width: 100%;
  height: 100%;
}
.loginform {
  height: 70%;
  width: 70%;
  position: relative;
  top: 13%;
  left: 15%;
  background-color: aqua;
}
.logininput {
  position: relative;
  left: 15%;
  top: 10%;
}
.body_form {
  position: relative;
  top: 15%;
}
.form_section {
  margin-bottom: 20%;
  font-size: 24px;
  font-weight: 800;
  position: relative;
  left: -5%;
}
.imgcover {
  width: 64.2%;
  height: 96%;
  position: absolute;
  top: 1%;
  background-color: black;
  opacity: 0.5;
  z-index: 1000;
}
</style>

