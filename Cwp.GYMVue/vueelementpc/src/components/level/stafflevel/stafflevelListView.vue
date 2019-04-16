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
  name: "stafflevelList",
  components: {
    "cwp-list": cwplist
  },
  data() {
    return {
      title: "员工职位",
      controllerName: "stafflevel",
      columns: [
        { prop: "name", label: "名称", sortable: true },
        { prop: "stafflevelname", label: "上级职位", sortable: true },
        { prop: "wage", label: "工资(月)", sortable: true },
        { prop: "remark", label: "介绍", sortable: true }
      ],
      routerData: {
        router: "stafflevelEdit",
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