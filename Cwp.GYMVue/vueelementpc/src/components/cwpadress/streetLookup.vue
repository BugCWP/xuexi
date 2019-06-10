<template>
  <div>
    <cwp-mobile-list
      title="市"
      :controllername="'street'"
      :address="true"
      :nextcontrollername="'SpecificAddress'"
      :paramList="{'areaid':this.$route.query.paramList.id}"
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
      var backroute = this.$route.query.backroute;
      this.$router.push({
        path: "SpecificAddressLookup",
        query: {
          paramList: value,
          provinceid: this.$route.query.provinceid,
          provincename: this.$route.query.provincename,
          cityid: this.$route.query.cityid,
          cityname: this.$route.query.cityname,
          areaid: this.$route.query.paramList.id,
          areaname: this.$route.query.paramList.name,
          backroute: backroute
        }
      });
    }
  }
};
</script>

<style>
</style>
