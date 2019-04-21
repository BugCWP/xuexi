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
  name: "staffList",
  components: {
    "cwp-list": cwplist
  },
  data() {
    return {
      title: "员工",
      controllerName: "staff",
      columns: [
        { prop: "name", label: "姓名", sortable: true },
        { prop: "age", label: "年龄", sortable: true },
        { prop: "sex", label: "性别", sortable: true },
        { prop: "gymname", label: "健身房", sortable: true },
        { prop: "stafflevelname", label: "职位", sortable: true },
        { prop: "phone", label: "电话", sortable: true }
      ],
      routerData: {
        router: "staffEdit",
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