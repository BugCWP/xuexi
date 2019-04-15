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
  components:{
      "cwp-list":cwplist
  },
  data() {
    return {
      title:"街道",
      controllerName:'street',
      columns:[
        { prop: 'name', label: '名称', sortable: true },
        { prop: 'areaname', label: '上级区', sortable: true },
      ],
      routerData:{
        router:'streetEdit',
        id:''
      }
    };
  },
  mounted() {
  },
  methods: {
     goEdit(data){
         this.$emit("listionRouter",data);
     }
  }
};
</script>