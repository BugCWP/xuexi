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
  name: "gym_equipmentList",
  components: {
    "cwp-list": cwplist
  },
  data() {
    return {
      title: "健身器材",
      controllerName: "gym_equipment",
      columns: [
        { prop: "gymroomname", label: "健身房", sortable: true },
        { prop: "equipmentname", label: "健身器材", sortable: true },
        { prop: "amount", label: "数量", sortable: true }
      ],
      routerData: {
        router: "gym_equipmentEdit",
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