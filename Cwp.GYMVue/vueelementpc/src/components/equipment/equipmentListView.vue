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
  name: "equipmentList",
  components: {
    "cwp-list": cwplist
  },
  data() {
    return {
      title: "器材种类",
      controllerName: "equipment",
      columns: [
        { prop: "name", label: "名称", sortable: true },
        { prop: "price", label: "价格", sortable: true },
      ],
      routerData: {
        router: "equipmentEdit",
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