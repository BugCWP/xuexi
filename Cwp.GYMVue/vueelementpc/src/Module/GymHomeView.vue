<template>
  <el-container>
    <el-header height="60px">
      <el-row>
        <el-col :span="3" class="headLogo">GYM</el-col>
        <el-col :span="6"></el-col>
        <el-col :span="2">&nbsp;</el-col>
        <el-col :span="2">
          <el-button type="text" class="navbtn" @click="changeIndex('1')">首页</el-button>
        </el-col>
        <el-col :span="2">
          <el-button type="text" class="navbtn" @click="changeIndex('2')">员工管理</el-button>
        </el-col>
        <el-col :span="2">
          <el-button type="text" class="navbtn" @click="changeIndex('3')">器材管理</el-button>
        </el-col>
        <el-col :span="2">
          <el-button type="text" class="navbtn" @click="changeIndex('4')">课程管理</el-button>
        </el-col>
        <el-col :span="2"></el-col>
      </el-row>
    </el-header>
    <el-main>
        <gym-course v-show="index=='1'"></gym-course>
        <gym-home-equipment v-show="index=='2'"></gym-home-equipment>
        <gym-home-index v-show="index=='3'"></gym-home-index>
        <gym-home-staff v-show="index=='4'"></gym-home-staff>
    </el-main>
  </el-container>
</template>

<script>
import gymcourseview from "@/components/gymhome/gymCourseView";
import gymhomeequipmentview from "@/components/gymhome/gymHomeEquipmentView";
import gymhomeindexview from "@/components/gymhome/gymHomeIndexView";
import gymhomestaffview from "@/components/gymhome/gymHomeStaffView";

export default {
  name: "gym-home",
  components: {
    "gym-course": gymcourseview,
    "gym-home-equipment": gymhomeequipmentview,
    "gym-home-index": gymhomeindexview,
    "gym-home-staff": gymhomestaffview
  },
  data() {
    return {
        index:'1'
    };
  },
  methods:{
      changeIndex(value){
         this.index=value;
      }
  }
};
</script>

<style>
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
</style>
