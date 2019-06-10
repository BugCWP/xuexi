<template>
  <el-container>
    <el-header height="60px">
      <el-row>
        <el-col :span="3" class="headLogo">GYM</el-col>
        <el-col :span="6"></el-col>
        <el-col :span="2">&nbsp;</el-col>
        <!-- <el-col :span="2">
          <el-button type="text" class="navbtn" @click="changeIndex('1')">首页</el-button>
        </el-col> -->
        <el-col :span="2">
          <el-button type="text" class="navbtn" @click="changeIndex('2')">员工管理</el-button>
        </el-col>
        <el-col :span="2">
          <el-button type="text" class="navbtn" @click="changeIndex('3')">器材管理</el-button>
        </el-col>
        <el-col :span="2">
          <el-button type="text" class="navbtn" @click="changeIndex('4')">课程管理</el-button>
        </el-col>
        <el-col :span="7">&nbsp;</el-col>
        <el-col :span="4">
          <div class="headimgdiv">
            <img :src="staffbase" class="headimg">
          </div>
          <span class="headname" @click="changeIndex('5')">{{staffdata.name}}</span>
        </el-col>
      </el-row>
    </el-header>
    <el-main>
      <gym-home-index v-if="index=='1'" :thisgymid="gymid"></gym-home-index>
      <gym-home-staff v-if="index=='2'" :thisgymid="gymid" :thisstaffid="staffdata.gymid"></gym-home-staff>
      <gym-home-equipment v-if="index=='3'" :thisgymid="gymid"></gym-home-equipment>
      <gym-course v-if="index=='4'" :thisgymid="gymid"></gym-course>
      <gym-person v-if="index=='5'" :thisid="staffdata.id"></gym-person>
    </el-main>
  </el-container>
</template>

<script>
import gymcourseview from "@/components/gymhome/gymCourseView";
import gymhomeequipmentview from "@/components/gymhome/gymHomeEquipmentView";
import gymhomeindexview from "@/components/gymhome/gymHomeIndexView";
import gymhomestaffview from "@/components/gymhome/gymHomeStaffView";
import gympersonview from "@/components/gymhome/gymPersonView";

export default {
  name: "gym-home",
  components: {
    "gym-course": gymcourseview,
    "gym-home-equipment": gymhomeequipmentview,
    "gym-home-index": gymhomeindexview,
    "gym-home-staff": gymhomestaffview,
    "gym-person": gympersonview
  },
  data() {
    return {
      index: "1",
      staffdata: {
        name: ""
      },
      staffbase: "../../static/img/person.png",
      account: "",
      gymid:"",
    };
  },
  mounted() {
    this.loaddate();
  },
  methods: {
    changeIndex(value) {
      this.index = value;
    },
    loaddate() {
      this.account = this.$route.query.id;
      if (
        this.account == "" ||
        this.account == null ||
        this.account == undefined
      ) {
        this.$router.back();
      } else {
        var url = "/api/staff/GetData";
        var formData = {
          account: this.account
        };
        var that = this;
        this.$axios
          .post(url, formData)
          .then(resp => {
            that.staffdata = resp.data;
            that.gethearimg(resp.data.code);
            that.gymid=resp.data.gymid;
          })
          .catch(err => {});
      }
    },
    gethearimg(value) {
      var str = [];
      var that = this;
      var url = "http://localhost:50379/ashx/imgdown.ashx?code=" + value;
      this.$axios
        .get(url)
        .then(resp => {
          that.staffbase = "data:image/png;base64," + resp.data[0].url;
        })
        .catch(err => {});
    }
  }
};
</script>

<style scoped>
.el-header {
  background-color: slategray;
  line-height: 60px;
}
.headLogo {
  color: white;
  font-size: 24px;
  font-weight: 800;
}
.navbtn {
  color: white;
}
.headimgdiv {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  display: inline-block;
  margin-top: 10px;
  overflow: hidden;
}
.headimg {
  width: 40px;
  height: 40px;
}
.headname {
  font-size: 14px;
  color: white;
  position: relative;
  top: -10px;
  cursor: pointer;
}
</style>
<style>
/* //滚动条的宽度 */
::-webkit-scrollbar {
  width: 5px;
  height: 10px;
}
/* //滚动条的滑块 */
::-webkit-scrollbar-thumb {
  background-color: #a1a3a9;
  border-radius: 3px;
}
</style>

