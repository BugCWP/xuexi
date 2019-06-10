<template>
  <div>
    <cwp-mobile-list
      title="区"
      :controllername="'area'"
      :address="true"
      :nextcontrollername="'street'"
      :paramList="{'cityid':this.$route.query.paramList.id}"
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
        path: "streetLookup",
        query: {
          paramList: value,
          provinceid: this.$route.query.provinceid,
          provincename: this.$route.query.provincename,
          cityid: this.$route.query.paramList.id,
          cityname: this.$route.query.paramList.name,
          backroute: backroute
        }
      });
    }
  }
};
</script>

<style>
</style>

