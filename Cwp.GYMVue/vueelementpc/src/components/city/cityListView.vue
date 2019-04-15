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
  name: "cityList",
  components:{
      "cwp-list":cwplist
  },
  data() {
    return {
      title:"市",
      controllerName:'city',
      columns:[
        { prop: 'name', label: '名称', sortable: true },
        { prop: 'provincename', label: '上级省', sortable: true },
      ],
      routerData:{
        router:'cityEdit',
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
