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
  name: "streetList",
  components: {
    "cwp-list": cwplist
  },
  data() {
    return {
      title: "会员等级",
      controllerName: "customerlevel",
      columns: [
        { prop: "name", label: "名称", sortable: true },
        { prop: "leveltime", label: "时长(天)", sortable: true },
        { prop: "price", label: "价格", sortable: true },
        { prop: "remark", label: "介绍", sortable: true }
      ],
      routerData: {
        router: "customerlevelEdit",
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