<template>
  <div class="customerhomebox">
    <div>
      <coach-index v-if="index==1" :account="account"></coach-index>
      <coach-course v-if="index==2" :account="account"></coach-course>
      <coach-self v-if="index==3" :account="account"></coach-self>
    </div>
    <div class="footer">
      <el-row style="padding-top:20px">
        <el-col :span="8" ><span @click="changeindex(1)">首页</span></el-col>
        <el-col :span="8"><span  @click="changeindex(2)">我的课程</span></el-col>
        <el-col :span="8" ><span @click="changeindex(3)">个人中心</span></el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import coachSelf from "@/components/CoachHome/coachSelf";
import coachIndex from "@/components/CoachHome/coachIndex";
import coachmycourse from "@/components/CoachHome/coachmycourse";
export default {
  components: {
    "coach-self": coachSelf,
    "coach-index": coachIndex,
    "coach-course":coachmycourse,
  },
  data() {
    return {
      index: 1,
      account:"",
    };
  },
  mounted(){
     if(this.$route.query!=undefined){
         this.account=this.$route.query.id;
     }
  },
  methods: {
    changeindex(value) {
      this.index = value;
    }
  }
};
</script>

<style scoped>
.footer {
  width: 100%;
  height: 10%;
  position: fixed;
  bottom: 0;
  left: 0;
  background-color: slategray;
  color: white;
}
.customerhomebox{
  background-color: rgba(243, 242, 242, 0.61);
  height: 100%;
}
</style>
