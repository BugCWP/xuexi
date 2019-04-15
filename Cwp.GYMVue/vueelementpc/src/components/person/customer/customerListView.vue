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
  name: "customerList",
  components:{
      "cwp-list":cwplist
  },
  data() {
    return {
      title:"会员",
      controllerName:'customer',
      columns:[
        { prop: 'name', label: '姓名', sortable: true },
        { prop: 'age', label: '年龄', sortable: true },
         { prop: 'sex', label: '性别', sortable: true },
        { prop: 'phone', label: '电话', sortable: true },
        { prop: 'email', label: '邮箱', sortable: true },
      ],
      routerData:{
        router:'customerEdit',
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