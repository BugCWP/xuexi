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
        { prop: 'start_time', label: '开始营业时间', sortable: true },
        { prop: 'end_time', label: '结束营业时间', sortable: true },
      ],
      routerData:{
        router:'gymEdit',
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
