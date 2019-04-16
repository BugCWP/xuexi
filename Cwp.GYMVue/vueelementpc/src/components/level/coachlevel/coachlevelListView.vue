<template>
  <cwp-list
    :title="title"
    :controllerName="controllerName"
    :columns="columns"
    :routerData="routerData"
    @listionRouter="goEdit"
  ></cwp-list>
</template>

<script>
import cwplist from "@/components/cwplist/cwplistView";
export default {
  name: "coachlevelList",
  components: {
    "cwp-list": cwplist
  },
  data() {
    return {
      title: "健身教练等级",
      controllerName: "coachlevel",
      columns: [
        { prop: "name", label: "名称", sortable: true },
        { prop: "levelname", label: "等级", sortable: true },
        { prop: "remark", label: "介绍", sortable: true }
      ],
      routerData: {
        router: "coachlevelEdit",
        id: ""
      }
    };
  },
  mounted() {},
  methods: {
    goEdit(data) {
      this.$emit("listionRouter", data);
    }
  }
};
</script>