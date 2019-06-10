<template>
  <div class="mycoursebox">
    <div v-for="(item,index) in gymcourseList" :key="index">
      <div class="mycoursediv">
        <el-row>
          <el-col :span="2">&nbsp;</el-col>
          <el-col :span="10">
            <el-row>
              <el-col :span="10">课程名称:</el-col>
              <el-col :span="10">{{item.coursename}}</el-col>
            </el-row>
          </el-col>
          <el-col :span="10" style="color:green;text-align:right">
            <span @click="joincouse(item)">取消</span>
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
</template>

<script>
export default {
  props: {
    account: {
      type: String,
      default: ""
    }
  },
  data() {
    return {
      customerdata: {},
      courseidlist: {},
      paramList: {},
      gymcourseList: []
    };
  },
  mounted() {
    this.getLoad();
  },
  methods: {
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
            that.getList();
          })
          .catch(err => {});
      }
    },
    getList() {
      this.paramList = { coachid: this.customerdata.id };
      var url =
        "/api/gym_course/GetDataList?paramList=" +
        JSON.stringify(this.paramList);
      var that = this;
      this.$axios
        .get(url)
        .then(resp => {
          that.gymcourseList = resp.data;
        })
        .catch(err => {});
    },
    joincouse(value) {
        console.log(value);
      var url1 = "/api/gym_course/UpdateData";
      var that = this;
      var gymcourse = value;
      console.log(gymcourse);
      gymcourse.coachid="00000000-0000-0000-0000-000000000000";
      gymcourse.coachname="null";
      this.$axios
        .post(url1, gymcourse)
        .then(resp => {
          that.getLoad();
        })
        .catch(err => {});
    }
  }
};
</script>

<style>
.mycoursebox {
  width: 100%;
  height: 100%;
  overflow: auto;
}
.mycoursediv {
  width: 100%;
  height: 100px;
  margin-bottom: 10px;
  background-color: white;
}
</style>
