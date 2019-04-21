<template>
  <el-container>
    <el-header height="80px">
      <el-row>
        <el-col :span="3" class="registerLogo">GYM</el-col>
        <el-col :span="19">&nbsp;</el-col>
        <el-col :span="2">
          <el-button type="text" icon="el-icon-back" class="listbutton" @click="goback">登陆</el-button>
        </el-col>
      </el-row>
    </el-header>
    <el-main>
      <el-container>
        <el-aside>
          <el-steps :active="active" align-center finish-status="success" direction="vertical">
            <el-step title="步骤1"></el-step>
            <el-step title="步骤2"></el-step>
            <el-step title="步骤3"></el-step>
            <el-step title="步骤4"></el-step>
          </el-steps>
        </el-aside>
        <el-main class="joinmain">
          <el-scrollbar style="height:100%">
            <component :is="demo" @listionRouter="changedemo" :editId="editId" :lastdata="lastdata"></component>
          </el-scrollbar>
        </el-main>
      </el-container>
    </el-main>
    <el-footer></el-footer>
  </el-container>
</template>

<script>
import gymregisterstaff from "@/components/gymregister/gymregisterstaffView";
import gymregistergym from "@/components/gymregister/gymregistergymView";
import gymregisterpicture from "@/components/gymregister/gymregisterpictureView";
import gymregisteraccountnumber from "@/components/gymregister/gymregisteraccountnumber";
import gymregistersuccess from "@/components/gymregister/gymregistersuccessView";

export default {
  name: "Register",
  components: {
    gymregisterstaff,
    gymregistergym,
    gymregisterpicture,
    gymregisteraccountnumber,
    gymregistersuccess
  },
  data() {
    return {
      formData: {
        Gym: {},
        Staff: {}
      },
      lastdata: {},
      rules: {
        accountNumber: [
          { required: true, message: "账号不能为空", trigger: "blur" }
        ],
        password: [{ required: true, message: "密码不能为空", trigger: "blur" }]
      },
      active: "0",
      demo: "gymregistergym"
    };
  },
  methods: {
    goback() {
      this.$router.push("/Login");
    },
    changedemo(data) {
      if (data.count == "1") {
        this.active = "1";
        this.formData.Gym = data.data;
        this.demo = "gymregisterstaff";
      } else if (data.count == "2") {
        if (data.last) {
          this.active = "0";
          this.lastdata = this.formData.Gym;
           this.formData.Staff = data.data;
          this.demo = "gymregistergym";
        } else {
          this.active = "2";
          this.formData.Staff = data.data;
          this.demo = "gymregisteraccountnumber";
        }
      } else if (data.count == "3") {
        if (data.last) {
          this.active="1";
          this.lastdata=this.formData.Staff;
          this.demo = "gymregisterstaff";
        } else {
          this.active = "3";
          this.formData.Staff.accountNumber = data.data.accountNumber;
          this.formData.Staff.password = data.data.password;
          this.demo = "gymregisterpicture";
        }
      } else if (data.count == "4") {
        this.active = "4";
        this.demo = "gymregistersuccess";
      }
    }
  }
};
</script>

<style>
.registerLogo {
  color: white;
  font-size: 24px;
  font-weight: 800;
}
.el-header {
  background-color: slategray;
  line-height: 100px;
}
.el-footer {
  background-color: #b3c0d1;
  color: white;
  font-size: 17px;
  line-height: 30px;
}
.el-container {
  height: 100%;
}
.el-aside {
  height: 100%;
}
.el-steps {
  padding-left: 60px;
}
.el-scrollbar__wrap {
  overflow-x: hidden;
}
.joinmain {
  padding: 0;
}
.listbutton {
  color: white;
}
</style>
