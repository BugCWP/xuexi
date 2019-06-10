<template>
  <div>
    <div class="headbox">
      <i class="el-icon-arrow-left" style="font-size:30px;color:white;" @click="goback"></i>
    </div>
    <div style="width:100%;height:40px;"></div>
    <div>
      <el-row>
        <el-col :span="2">&nbsp;</el-col>
        <el-col :span="6">
          <img :src="customerbase" class="headimg">
          <el-upload
            class="upload-demo"
            action="http://localhost:50379/ashx/imgchange.ashx"
            :on-preview="handlePreview"
            :on-remove="handleRemove"
            :on-success="handleSuccess"
            :file-list="fileList"
            list-type="text"
            :data="imgdata"
            :limit="1"
          >
            <el-button
              size="small"
              type="primary"
              style="margin-top:20px;width:160px;height:35px;"
            >更换头像</el-button>
          </el-upload>
        </el-col>
      </el-row>
      <el-row style="margin-top:15px;">
        <el-col :span="2">&nbsp;</el-col>
        <el-col :span="3">姓名：</el-col>
        <el-col :span="4">{{customerdata.name}}</el-col>
        <el-col :span="6" style="text-align:right">
          <i class="el-icon-edit-outline" @click="change">编辑</i>
        </el-col>
        <el-col :span="5" style="text-align:right">
          <i class="el-icon-edit" @click="changepassword">修改密码</i>
        </el-col>
      </el-row>
      <el-row style="margin-top:15px;">
        <el-col :span="2">&nbsp;</el-col>
        <el-col :span="3">年龄：</el-col>
        <el-col :span="4">{{customerdata.age}}</el-col>
      </el-row>
      <el-row style="margin-top:15px;">
        <el-col :span="2">&nbsp;</el-col>
        <el-col :span="3">性别：</el-col>
        <el-col :span="4">{{customerdata.sex}}</el-col>
      </el-row>
      <el-row style="margin-top:15px;">
        <el-col :span="2">&nbsp;</el-col>
        <el-col :span="3">电话：</el-col>
        <el-col :span="4">{{customerdata.phone}}</el-col>
      </el-row>
      <el-row style="margin-top:15px;">
        <el-col :span="2">&nbsp;</el-col>
        <el-col :span="3">邮箱：</el-col>
        <el-col :span="10">{{customerdata.email}}</el-col>
      </el-row>
      <el-row style="margin-top:15px;">
        <el-col :span="2">&nbsp;</el-col>
        <el-col :span="3">地址：</el-col>
        <el-col
          :span="10"
          style="text-align:left"
        >{{customerdata.provincename+customerdata.cityname+customerdata.areaname+customerdata.streetname+customerdata.specificaddress}}</el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      account: "",
      customerdata: {},
      customerbase: "../../static/img/person.png",
      imgdata: {
        data: ""
      },
      fileList: []
    };
  },
  mounted() {
    if (this.$route.query.id != undefined) {
      this.account = this.$route.query.id;
    }
    this.getLoad();
  },
  methods: {
    goback() {
      this.$router.push({
        path: "customerHome",
        query: {
          id: this.account
        }
      });
    },
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
            that.gethearimg(resp.data.code);
            that.imgdata.data = JSON.stringify(resp.data.code);
          })
          .catch(err => {});
      }
    },
    gethearimg(value) {
      var str = [];
      var that = this;
      if (value != null) {
        var url = "http://localhost:50379/ashx/imgdown.ashx?code=" + value;
        this.$axios
          .get(url)
          .then(resp => {
            that.customerbase = "data:image/png;base64," + resp.data[0].url;
          })
          .catch(err => {});
      }
    },
    handlePreview() {},
    handleRemove() {},
    handleSuccess() {
      this.gethearimg(this.customerdata.code);
    },
    change() {
      this.$router.push({
        path: "customermyselfedit",
        query: {
          id: this.account
        }
      });
    },
    changepassword() {
        this.$router.push({
        path: "customerpassword",
        query: {
          id: this.account
        }
      });
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
.headimg {
  width: 100px;
  height: 100px;
}
</style>
