<template>
  <div class="customerhomebox">
    <div>
      <customer-index v-if="index==1" :account="account"></customer-index>
      <customer-course v-if="index==2" :account="account"></customer-course>
      <customer-self v-if="index==3" :account="account"></customer-self>
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
import customerself from "@/components/CustomeHome/customerSelf";
import customerindex from "@/components/CustomeHome/customerIndex";
import customercourse from "@/components/CustomeHome/customermycourse";
export default {
  components: {
    "customer-self": customerself,
    "customer-index": customerindex,
    "customer-course":customercourse,
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
