<template>
  <div>
    <cwp-mobile-list
      title="市"
      :controllername="'city'"
      :address="true"
      :nextcontrollername="'area'"
      :paramList="{'provinceid':this.$route.query.paramList.id}"
      @selectclick="selectbtn"
    ></cwp-mobile-list>
  </div>
</template>

<script>
import cwpMobileList from "@/components/cwpadress/cwpMobileList";
export default {
  components: {
    "cwp-mobile-list": cwpMobileList
  },
  data() {
    return {
        
    };
  },
  methods:{
      selectbtn(value){
         var backroute=this.$route.query.backroute;
         this.$router.push({
           path:'areaLookup',
           query:{
               paramList:value,
               provinceid:this.$route.query.paramList.id,
               provincename:this.$route.query.paramList.name,
                backroute:backroute
           }
       });
      }
  }
};
</script>

<style>
</style>
