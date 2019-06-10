<template>
  <div class="mycoursebox">
    <div class="headbox">
      <i class="el-icon-arrow-left" style="font-size:30px;color:white;" @click="goback"></i>
    </div>
    <div>
      <el-carousel height="200px">
        <el-carousel-item v-for="(item,index) in imgList" :key="index">
          <img :src="'data:image/png;base64,'+item.url" class="headimg">
        </el-carousel-item>
      </el-carousel>
    </div>
    <el-row style="margin-top:5px;">
      <el-col :span="8">&nbsp;</el-col>
      <el-col :span="8" style="text-align:left;font-size:20px;">{{gymdata.name}}</el-col>
    </el-row>
    <el-row style="margin-top:15px;">
      <el-col :span="2">&nbsp;</el-col>
      <el-col :span="5">营业时间：</el-col>
      <el-col :span="5">{{gymdata.start_time+"~"+gymdata.end_time}}</el-col>
    </el-row>
    <el-row style="margin-top:5px;">
      <el-col :span="2">&nbsp;</el-col>
      <el-col :span="3">电话：</el-col>
      <el-col :span="5">{{gymdata.phone}}</el-col>
      <el-col :span="1">&nbsp;</el-col>
      <el-col :span="3">邮箱：</el-col>
      <el-col :span="5">{{gymdata.email}}</el-col>
    </el-row>
    <el-row style="margin-top:5px;">
      <el-col :span="2">&nbsp;</el-col>
      <el-col :span="3">地址:</el-col>
      <el-col
        :span="18"
        style="text-align:left"
      >{{gymdata.provincename+gymdata.cityname+gymdata.areaname+gymdata.streetname+gymdata.specificaddress}}</el-col>
    </el-row>
    <el-row style="margin-top:5px;">
      <el-col :span="2">&nbsp;</el-col>
      <el-col :span="3">简介:</el-col>
      <el-col :span="18" style="text-align:left">{{gymdata.remark==null?"--":gymdata.remark}}</el-col>
    </el-row>
    <div class="customergymcoursebox">
      <div v-for="(item,index) in courseList" :key="index">
        <div class="customergymcoursediv">
          <el-row>
            <el-col :span="2">&nbsp;</el-col>
            <el-col :span="10">
              <el-row>
                <el-col :span="10">课程名称:</el-col>
                <el-col :span="10">{{item.coursename}}</el-col>
              </el-row>
            </el-col>
            <el-col :span="11" style="color:green;text-align:right">
              <span @click="joincouse(item)">报名做教练</span>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="2">&nbsp;</el-col>
            <el-col :span="4">教练:</el-col>
            <el-col :span="4">{{item.coachname}}</el-col>
            <el-col :span="2">&nbsp;</el-col>
            <el-col :span="4">课时长度:</el-col>
            <el-col :span="4">{{item.duration}}分钟</el-col>
          </el-row>
          <el-row>
            <el-col :span="2">&nbsp;</el-col>
            <el-col :span="4">开始时间:</el-col>
            <el-col :span="14">{{item.starttime}}</el-col>
          </el-row>
          <el-row>
            <el-col :span="2">&nbsp;</el-col>
            <el-col :span="2">状态:</el-col>
            <el-col :span="4">{{item.startstatus}}</el-col>
            <el-col :span="2">&nbsp;</el-col>
            <el-col :span="4">报名人数:</el-col>
            <el-col :span="4">{{item.amount}}</el-col>
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
      gymid: "",
      gymdata: {},
      imgList: {},
      paramList: "",
      courseList: [],
      customercourse: {
        courseid: "",
        coursename: "",
        customerid: "",
        customername: ""
      },
      customerdata: {}
    };
  },
  mounted() {
    if (this.$route.query.id != undefined) {
      this.account = this.$route.query.id;
      this.gymid = this.$route.query.gymid;
      this.getLoad();
      this.getgymcourse();
      this.getcustomer();
    }
  },
  methods: {
    getLoad() {
      var url = "/api/gym/GetData?id=" + this.gymid;
      var that = this;
      this.$axios
        .get(url)
        .then(resp => {
          that.gymdata = resp.data;
          that.gethearimg(resp.data.code);
        })
        .catch(err => {});
    },
    gethearimg(value) {
      var that = this;
      if (value != null) {
        var url = "http://localhost:50379/ashx/imgdown.ashx?code=" + value;
        this.$axios
          .get(url)
          .then(resp => {
            that.imgList = resp.data;
          })
          .catch(err => {});
      }
    },
    goback() {
      this.$router.push({
        path: "coachHome",
        query: {
          id: this.account
        }
      });
    },
    getgymcourse() {
      this.paramList = { gymid: this.gymid };
      var url =
        "/api/gym_course/GetDataList?paramList=" +
        JSON.stringify(this.paramList);
      var that = this;
      this.$axios
        .get(url)
        .then(resp => {
          for(var i=0;i<resp.data.length;i++){
              if(resp.data[i].coachid==null||resp.data[i].coachid=="00000000-0000-0000-0000-000000000000"){
                  that.courseList.push(resp.data[i]);
              }
          }
        })
        .catch(err => {});
    },
    getcustomer() {
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
          })
          .catch(err => {});
      }
    },
    joincouse(value) {
      console.log(value);
      var gymcourse = value;
      gymcourse.coachid=this.customerdata.id;
      gymcourse.coachname=this.customerdata.name;
      var url = "/api/gym_course/UpdateData";
      var that = this;
      this.$axios
        .post(url, gymcourse)
        .then(resp => {
          that.getLoad();
          that.getgymcourse();
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
.headimg {
  width: 100%;
  height: 200px;
}
.customergymcoursebox {
  overflow: auto;
  width: 100%;
  height: 250px;
  margin-top: 10px;
}
.mycoursebox {
  background-color: rgba(243, 242, 242, 0.61);
  height: 100%;
}
.customergymcoursediv {
  background-color: white;
  width: 100%;
  margin-bottom: 10px;
  padding-top: 20px;
  padding-bottom: 10px;
}
</style>
