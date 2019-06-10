<template>
  <div>
    <cwp-mobile-list
      title="省"
      :controllername="'province'"
      :address="true"
      :nextcontrollername="'city'"
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
    return {};
  },
  methods: {
    selectbtn(value) {
       var backroute=this.$route.query.backroute;
       this.$router.push({
           path:'cityLookup',
           query:{
               paramList:value,
               backroute:backroute
           }
       });
    }
  }
};
</script>

<style>
</style>
