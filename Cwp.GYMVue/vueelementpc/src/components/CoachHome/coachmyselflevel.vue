<template>
  <div class="mylevelbox">
    <div class="headbox">
      <i class="el-icon-arrow-left" style="font-size:30px;color:white;" @click="goback"></i>
    </div>
    <div style="width:100%;height:20px"></div>
    <div class="mylevel">
      <el-row class="myleveltitle" style="padding-top:5px;">
        <el-col :span="1">&nbsp;</el-col>
        <el-col :span="10">我的职称:{{customerleveldata.name}}</el-col>
      </el-row>
      <el-row style="padding-top:15px">
        <el-col :span="2">&nbsp;</el-col>
        <el-col :span="5">教练等级:</el-col>
        <el-col :span="6">{{customerleveldata.levelname}}</el-col>
      </el-row>
      <el-row style="padding-top:10px">
        <el-col :span="2">&nbsp;</el-col>
        <el-col :span="3">简介:</el-col>
        <el-col :span="14" style="text-align:left">{{customerleveldata.remark}}</el-col>
      </el-row>
    </div>
    <div class="levellistbox">
      <div v-for="(item,index) in customerlistdata" :key="index">
        <div class="eachlevelbox">
          <el-row>
            <el-col :span="2">&nbsp;</el-col>
            <el-col :span="10">
              <el-row>
                <el-col :span="15" style="margin-top:20px;text-align:left">{{item.name}}</el-col>
              </el-row>
              <el-row>
                <el-col :span="10" style="margin-top:5px;">等级:</el-col>
                <el-col :span="9" style="margin-top:5px;">{{item.levelname}}</el-col>
              </el-row>
            </el-col>
            <el-col :span="10" class="buybox">
              <span @click="bugbutton(item)">申请</span>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="2">&nbsp;</el-col>
            <el-col :span="4" style="margin-top:5px;">简介:</el-col>
            <el-col :span="14" style="text-align:left">{{item.remark}}</el-col>
          </el-row>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      account: "",
      customerdata: {},
      customerlevelid: "",
      customerleveldata: {},
      customerlistdata: []
    };
  },
  mounted() {
    if (this.$route.query.id != undefined) {
      this.account = this.$route.query.id;
      this.getLoad();
    }
    this.getList();
  },
  methods: {
    goback() {
      this.$router.push({
        path: "coachHome",
        query: {
          id: this.account
        }
      });
    },
    getLoad() {
      if (this.account != "") {
        var url = "/api/coach/GetData";
        var formData = {
          accountnumber: this.account
        };
        var that = this;
        this.$axios
          .post(url, formData)
          .then(resp => {
            that.customerdata = resp.data;
            that.customerlevelid = resp.data.coachlevelid;
            that.getlevel();
          })
          .catch(err => {});
      }
    },
    getlevel() {
      if (this.customerlevelid != "" && this.customerlevelid != null) {
        var url = "/api/coachlevel/GetData";
        var formData = {
          id: this.customerlevelid
        };
        var that = this;
        this.$axios
          .post(url, formData)
          .then(resp => {
            that.customerleveldata = resp.data;
          })
          .catch(err => {});
      }
    },
    getList() {
      var url = "/api/coachlevel/GetDataAllList";
      var that = this;
      this.$axios
        .get(url)
        .then(resp => {
          that.customerlistdata = resp.data;
        })
        .catch(err => {});
    },
    bugbutton(value) {
      var url = "/api/coach/UpdateData";
      var that = this;
      this.customerdata.coachlevelid = value.id;
      this.customerdata.coachlevelname = value.name;
    //   this.customerdata.customerleveltime = new Date().getFullYear()+"-"+(new Date().getMonth()+1)+"-"+new Date().getDate();
      this.$axios
        .post(url, that.customerdata)
        .then(resp => {
          that.getLoad();
        })
        .catch(err => {});
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
.mylevel {
  background-color: white;
  height: 140px;
  width: 96%;
  margin-left: 2%;
}
.myleveltitle {
  font-size: 18px;
}
.mylevelbox {
  background-color: rgba(243, 242, 242, 0.61);
  height: 100%;
}
.levellistbox {
  width: 100%;
  height: 400px;
  margin-top: 15px;
  overflow: auto;
}
.eachlevelbox {
  width: 100%;
  height: 120px;
  background-color: white;
  margin-bottom: 15px;
}
.buybox {
  color: green;
  text-align: right;
  margin-top: 45px;
}
</style>
