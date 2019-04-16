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
  name: "courseList",
  components: {
    "cwp-list": cwplist
  },
  data() {
    return {
      title: "开设课程",
      controllerName: "course",
      columns: [
        { prop: "name", label: "名称", sortable: true },
        { prop: "coursetype", label: "课程种类", sortable: true },
        { prop: "customerlevel", label: "会员等级", sortable: true },
        { prop: "coachlevel", label: "教练等级", sortable: true },
        { prop: "price", label: "课程费用", sortable: true },
        { prop: "remuneration", label: "课程报酬", sortable: true }
      ],
      routerData: {
        router: "courseEdit",
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