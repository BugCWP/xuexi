<template >
  <div>
    <div class="headbox">
      <i class="el-icon-arrow-left" style="font-size:30px;color:white;" @click="goback"></i>
    </div>
    <div style="height:50px;width:100%"></div>
    <el-row>
      <el-col :span="4">&nbsp;</el-col>
      <el-col :span="15">
        <el-row style="margin-top:15px">
          <el-col :span="4" style="padding-top:10px">姓名:</el-col>
          <el-col :span="20">
            <el-input v-model="formData.name" clearable></el-input>
          </el-col>
        </el-row>
        <el-row style="margin-top:15px">
          <el-col :span="4" style="padding-top:10px">性别:</el-col>
          <el-col :span="20">
            <el-select v-model="formData.sex" placeholder="请选择">
              <el-option
                v-for="item in optionssex"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </el-col>
        </el-row>
         <el-row style="margin-top:15px">
          <el-col :span="4" style="padding-top:10px">年龄:</el-col>
          <el-col :span="20">
            <el-input v-model="formData.age" clearable></el-input>
          </el-col>
        </el-row>
        <el-row style="margin-top:15px">
          <el-col :span="4" style="padding-top:10px">邮箱:</el-col>
          <el-col :span="20">
            <el-input v-model="formData.email" clearable></el-input>
          </el-col>
        </el-row>
        <el-row style="margin-top:15px">
          <el-col :span="4" style="padding-top:10px">电话:</el-col>
          <el-col :span="20">
            <el-input v-model="formData.phone" clearable></el-input>
          </el-col>
        </el-row>
        <el-row style="margin-top:15px">
          <el-col :span="4" style="padding-top:10px">地址:</el-col>
          <el-col :span="20">
            <cwp-adress @goroute="goroute" :backroute="'customeRegister'" :adressstr="adressstr"></cwp-adress>
          </el-col>
        </el-row>
        <el-row>
          <el-col>
            <el-button type="primary" style="width:100%;margin-top:60px" @click="registerbtn">确认</el-button>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import cwpadress from "@/components/cwpadress/adressLookup";
export default {
  components: {
    "cwp-adress": cwpadress
  },
  data() {
    return {
      formData: {
        name: "",
        accountnumber: "",
        sex: "",
        email: "",
        phone: "",
        password: "",
        cityid: "",
        cityname: "",
        areaid: "",
        areaname: "",
        provinceid: "",
        provincename: "",
        streetid: "",
        streetname: "",
        specificaddress: "",
        code: ""
      },
      optionssex: [
        {
          value: "男",
          label: "男"
        },
        {
          value: "女",
          label: "女"
        }
      ],
      adressstr: "",
      account: ""
    };
  },
  mounted() {
    if (this.$route.query.id != undefined) {
      this.account = this.$route.query.id;
      this.getLoad();
    }
    const dataB = JSON.parse(sessionStorage.getItem("formdata"));
    if (dataB != null) {
      this.formData = dataB;
      this.account = this.formData.accountnumber;
    }
    if (this.$route.query.province != undefined) {
      this.formData.provinceid = this.$route.query.province.id;
      this.formData.provincename = this.$route.query.province.name;
      this.formData.cityid = this.$route.query.city.id;
      this.formData.cityname = this.$route.query.city.name;
      this.formData.areaid = this.$route.query.area.id;
      this.formData.areaname = this.$route.query.area.name;
      this.formData.streetid = this.$route.query.streat.id;
      this.formData.streetname = this.$route.query.streat.name;
      this.formData.specificaddress = this.$route.query.spacificAdress;
      this.adressstr =
        this.formData.provincename +
        this.formData.cityname +
        this.formData.areaname +
        this.formData.streetname +
        this.formData.specificaddress;
    }
  },
  methods: {
    goback() {
      sessionStorage.removeItem("formdata");
      this.$router.push({
        path: "/coachmyself",
        query: {
          id: this.account
        }
      });
    },
    registerbtn() {
      var url = "/api/coach/UpdateData";
      this.$axios
        .post(url, this.formData)
        .then(resp => {
          this.$message({
            message: "修改成功",
            type: "success"
          });
          sessionStorage.removeItem("formdata");
          this.$router.push({
            path: "/coachmyself",
            query: {
              id: this.account
            }
          });
        })
        .catch(err => {
          this.$message.error("修改失败");
        });
    },
    goroute() {
      sessionStorage.setItem("formdata", JSON.stringify(this.formData));
      this.$router.push({
        path: "/provinceLookup",
        query: { backroute: "coachmyselfedit" }
      });
    },
    getLoad() {
      if (this.account != "") {
        var url = "/api/coach/GetData";
        var formData1 = {
          accountnumber: this.account
        };
        var that = this;
        this.$axios
          .post(url, formData1)
          .then(resp => {
            that.formData = resp.data;
            that.adressstr =
              this.formData.provincename +
              this.formData.cityname +
              this.formData.areaname +
              this.formData.streetname +
              this.formData.specificaddress;
          })
          .catch(err => {});
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

