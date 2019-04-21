<template>
  <el-container>
    <el-form :model="formData" ref="form" :rules="rules" label-width="120px">
      <el-row class="row_padding">
        <el-col class="section_title" :span="7">法人账号密码</el-col>
      </el-row>
      <el-row>
        <el-col :span="16">
          <el-form-item label="账号" prop="accountnumber">
            <el-input v-model="formData.accountnumber" clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="16">
          <el-form-item label="密码" prop="password">
            <el-input v-model="formData.password" clearable></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="16">
          <el-form-item label="再次输入密码" prop="password">
            <el-input v-model="password" clearable></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="17">&nbsp;</el-col>
        <el-col :span="7">
          <el-button @click="firstbtn">上一步</el-button>
          <el-button type="success" @click="thridbtn">下一步</el-button>
        </el-col>
      </el-row>
    </el-form>
  </el-container>
</template>

<script>
import cwplookup from "@/components/cwplookup/cwplookupView";
export default {
  name: "gymregistergym",
  components: {
    "cwp-lookup": cwplookup
  },
  data() {
    return {
      formData: {
        accountnumber: "",
        password: ""
      },
      password: "",
      routedata: {
        data: "",
        count: "3",
        last: false
      }
    };
  },
  props: {
    lastdata: {
      type: Object,
      default: () => ({})
    }
  },
  mounted() {
    if (this.lastdata != null && this.lastdata != {}) {
      this.formData = this.lastdata;
    }
  },
  methods: {
    firstbtn() {
      this.routedata.last = true;
      this.routedata.data = this.formData;
      this.$emit("listionRouter", this.routedata);
    },
    thridbtn() {
      if (this.formData.password == this.password) {
        this.routedata.data = this.formData;
        this.$emit("listionRouter", this.routedata);
      } else {
        this.$message.error("两次密码输入不同");
      }
    }
  }
};
</script>

<style>
.el-container {
  margin: 0;
  padding: 0;
}
.row_padding {
  padding-bottom: 40px;
  padding-top: 20px;
}
</style>
