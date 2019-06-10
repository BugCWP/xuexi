<template>
  <div>
    <div class="headbox">
      <i class="el-icon-arrow-left" style="font-size:30px;color:white" @click="goback"></i>
      <span class="headtitle">具体地址</span>
    </div>
    <div style="widh:100%;height:100px"></div>
    <div class="mainbody">
      <el-row>
        <el-col :span="2">&nbsp;</el-col>
        <el-col :span="18">
          <el-row>
            <el-col :span="6">输入地址:</el-col>
            <el-col :span="18">
              <el-input
                type="textarea"
                :autosize="{ minRows: 3}"
                placeholder="请输入内容"
                v-model="spacificAdress"
              ></el-input>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">&nbsp;</el-col>
            <el-col :span="18">
              <el-button type="primary" style="width:100%;margin-top:60px" @click="isOK">确定</el-button>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      spacificAdress: "",
      province: {
        id: "",
        name: ""
      },
      city: {
        id: "",
        name: ""
      },
      area: {
        id: "",
        name: ""
      },
      streat:{
          id:"",
          name:""
      }
    };
  },
  mounted() {
      this.province.id=this.$route.query.provinceid;
      this.province.name=this.$route.query.provincename;
      this.city.id=this.$route.query.cityid;
      this.city.name=this.$route.query.cityname;
      this.area.id=this.$route.query.areaid;
      this.area.name=this.$route.query.areaname;
      this.streat.id=this.$route.query.paramList.id;
      this.streat.name=this.$route.query.paramList.name;
  },
  methods: {
    goback() {
      this.$router.back();
    },
    isOK() {
        var backroute = this.$route.query.backroute;
        this.$router.push({
           path:backroute,
           query:{
               province:this.province,
               city:this.city,
               area:this.area,
               streat:this.streat,
               spacificAdress:this.spacificAdress
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
  width: 100%;
  height: 35px;
  padding-top: 10px;
  position: fixed;
  left: -5px;
  padding-left: 10px;
  top: -5px;
}
.headtitle {
  font-size: 20px;
  color: white;
  margin-left: 30%;
}
</style>
