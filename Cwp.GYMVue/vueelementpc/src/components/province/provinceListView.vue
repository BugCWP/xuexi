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
  name: "provinceList",
  components:{
      "cwp-list":cwplist
  },
  data() {
    return {
      title:"省",
      controllerName:'province',
      columns:[
        { prop: 'name', label: '名称', sortable: true },
      ],
      routerData:{
        router:'provinceEdit',
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
