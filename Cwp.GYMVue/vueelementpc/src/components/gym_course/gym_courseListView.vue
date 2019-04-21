<template>
  <cwp-list
    :title="title"
    :controllerName="controllerName"
    :columns="columns"
    :routerData="routerData"
     :readOnly="true"
    @listionRouter="goEdit"
  ></cwp-list>
</template>

<script>
import cwplist from "@/components/cwplist/cwplistView";
export default {
  name: "gym_courseList",
  components: {
    "cwp-list": cwplist
  },
  data() {
    return {
      title: "课程表",
      controllerName: "gym_course",
      columns: [
        { prop: "coursename", label: "课程名", sortable: true },
        { prop: "gymname", label: "健身房", sortable: true },
        { prop: "coachname", label: "教练", sortable: true },
        { prop: "startstatus", label: "课程状态", sortable: true },
        { prop: "starttime", label: "开课时间", sortable: true,type:"datetime" },
        { prop: "duration", label: "时长(分)", sortable: true },
        { prop: "amount", label: "人数", sortable: true }
      ],
      routerData: {
        router: "gym_courseEdit",
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