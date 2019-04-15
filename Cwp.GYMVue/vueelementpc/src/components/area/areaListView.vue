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
  name: "areaList",
  components:{
      "cwp-list":cwplist
  },
  data() {
    return {
      title:"区",
      controllerName:'area',
      columns:[
        { prop: 'name', label: '名称', sortable: true },
        { prop: 'cityname', label: '上级市', sortable: true },
      ],
      routerData:{
        router:'areaEdit',
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
