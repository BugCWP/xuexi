<template>
  <el-container>
    <el-header height="80px">
      <el-row>
        <el-col :span="3" class="headLogo">GYM</el-col>
        <el-col></el-col>
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
          <el-menu-item index="1" @click="changeMenu">
            <i class="el-icon-menu"></i>
            <span slot="title">导航栏</span>
          </el-menu-item>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span slot="title">健身房管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="gymList">健身房</el-menu-item>
              <el-menu-item index="2-2">健身器材</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span slot="title">人员管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="3-1">客户</el-menu-item>
              <el-menu-item index="3-2">健身教练</el-menu-item>
              <el-menu-item index="3-3">员工</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="4">
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
          <component :is="demo" @listionRouter="changedemo"></component>
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
import cityList from "@/components/city/cityListView";
import areaList from "@/components/area/areaListView";
import streetList from "@/components/street/streetListView";

export default {
  name: "Home",
  components: {
    gymList,
    gymEdit,
    provinceList,
    cityList,
    areaList,
    streetList
  },
  data() {
    return {
      isCollapse: false,
      asideWidth: "200px",
      handleOpen: "2",
      demo: "gymList"
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
      if (data.id != null && data.id != "") {
        this.$refs.child.EditId(data.id);
      }
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
</style>
