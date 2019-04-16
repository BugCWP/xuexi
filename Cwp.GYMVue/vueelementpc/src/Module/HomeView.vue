<template>
  <el-container>
    <el-header height="80px">
      <el-row>
        <el-col :span="3" class="headLogo">
          GYM
          <el-button type="text"  icon="el-icon-menu" @click="changeMenu" class="changemenubtn"></el-button>
        </el-col>
        <el-col :span="2">
          
        </el-col>
      </el-row>
    </el-header>
    <el-container>
      <el-aside :width="asideWidth">
        <el-menu
          mode="vertical"
          default-active="2-1"
          :unique-opened="true"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          :collapse="isCollapse"
          background-color="#d3dce6"
          text-color="#6c6c6c"
          active-text-color="#f0f0f0"
          @select="meaunSelect"
        >
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span slot="title">健身房管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="gymList">健身房</el-menu-item>
              <el-menu-item index="equipmentList">器材种类</el-menu-item>
              <el-menu-item index="gym_equipmentList">健身器材</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span slot="title">人员管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="customerList">会员</el-menu-item>
              <el-menu-item index="coachList">健身教练</el-menu-item>
              <el-menu-item index="3-3">员工</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
           <el-submenu index="4">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span slot="title">权限管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="customerlevelList">会员等级</el-menu-item>
              <el-menu-item index="coachlevelList">教练等级</el-menu-item>
              <el-menu-item index="stafflevelList">员工职位</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
           <el-submenu index="5">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span slot="title">课程管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="courseList">开设课程</el-menu-item>
              <el-menu-item index="5-2">课程表</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="6">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span slot="title">区域管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="provinceList">省</el-menu-item>
              <el-menu-item index="cityList">市</el-menu-item>
              <el-menu-item index="areaList">区</el-menu-item>
              <el-menu-item index="streetList">街道</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-container>
        <el-main>
          <component :is="demo" @listionRouter="changedemo" :editId="editId"></component>
        </el-main>
        <el-footer height="30px">welcome to GYM</el-footer>
      </el-container>
    </el-container>
  </el-container>
</template>
<script>
import gymList from "@/components/gym/gymListView";
import gymEdit from "@/components/gym/gymEditView";
import provinceList from "@/components/province/provinceListView";
import provinceEdit from "@/components/province/provinceEditView";
import cityList from "@/components/city/cityListView";
import cityEdit from "@/components/city/cityEditView";
import areaList from "@/components/area/areaListView";
import areaEdit from "@/components/area/areaEditView";
import streetList from "@/components/street/streetListView";
import streetEdit from "@/components/street/streetEditView";
import customerlevelList from "@/components/level/customerlevel/customerlevelListView";
import customerlevelEdit from "@/components/level/customerlevel/customerlevelEditView";
import customerList from "@/components/person/customer/customerListView";
import customerEdit from "@/components/person/customer/customerEditView";
import coachlevelList from "@/components/level/coachlevel/coachlevelListView";
import coachlevelEdit from "@/components/level/coachlevel/coachlevelEditView";
import stafflevelList from "@/components/level/stafflevel/stafflevelListView";
import stafflevelEdit from "@/components/level/stafflevel/stafflevelEditView";
import courseList from "@/components/course/courseListView";
import courseEdit from "@/components/course/courseEditView";
import coachList from "@/components/person/coach/coachListView";
import coachEdit from "@/components/person/coach/coachEditView";
import equipmentList from "@/components/equipment/equipmentListView";
import equipmentEdit from "@/components/equipment/equipmentEditView";
import gym_equipmentList from "@/components/gym_equipment/gym_equipmentListView";
import gym_equipmentEdit from "@/components/gym_equipment/gym_equipmentEditView";

export default {
  name: "Home",
  components: {
    gymList,
    gymEdit,
    provinceList,
    provinceEdit,
    cityList,
    cityEdit,
    areaList,
    areaEdit,
    streetList,
    streetEdit,
    customerlevelList,
    customerlevelEdit,
    customerList,
    customerEdit,
    coachlevelList,
    coachlevelEdit,
    stafflevelList,
    stafflevelEdit,
    courseList,
    courseEdit,
    coachList,
    coachEdit,
    equipmentList,
    equipmentEdit,
    gym_equipmentList,
    gym_equipmentEdit,
  },
  data() {
    return {
      isCollapse: false,
      asideWidth: "200px",
      handleOpen: "2",
      demo: "gymList",
      editId:""
    };
  },
  methods: {
    changeMenu() {
      if (this.isCollapse == false) {
        this.isCollapse = true;
        this.asideWidth = "65px";
      } else {
        this.isCollapse = false;
        this.asideWidth = "200px";
      }
    },
    changedemo(data) {
      this.demo = data.router;
      this.editId=data.id;
    },
    meaunSelect(data) {
      this.demo = data;
    }
  }
};
</script>
<style>
.el-header {
  background-color: slategray;
  line-height: 100px;
}
.el-aside {
  background-color: #d3dce6;
  height: 490px;
}
.el-footer {
  background-color: #b3c0d1;
  color: white;
  font-size: 17px;
  line-height: 30px;
}
.headLogo {
  color: white;
  font-size: 24px;
  font-weight: 800;
}
.el-main {
  background-color: #f0f0f0;
  padding: 0;
}
.changemenubtn{
  font-size: 20px;
  color: white;
}
</style>
