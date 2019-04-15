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
  name: "gymList",
  components:{
      "cwp-list":cwplist
  },
  data() {
    return {
      title:"健身房",
      controllerName:'gym',
      columns:[
        { prop: 'name', label: '名称', sortable: true },
      ],
      routerData:{
        router:'gymeEdit',
        id:''
      }
    };
  },
  methods: {
     goEdit(data){
         this.$emit("listionRouter",data);
     }
  }
};
</script>
