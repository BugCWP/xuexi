<template>
  <cwp-list
    :title="title"
    :controllerName="controllerName"
    :columns="columns"
    :routerData="routerData"
    :titledisabled="titledisabled"
    :createrbtn="false"
    :deletebtn="false"
    :searchbtn="false"
    :paramList="paramList"
    :btnagree="btnagree"
  ></cwp-list>
</template>

<script>
import cwplist from "@/components/cwplist/cwplistView";
export default {
  name: "streetList",
  components: {
    "cwp-list": cwplist
  },
  props:{
     titledisabled:{
         type:Boolean,
         default:true
     },
      paramList: {
      type: Object,
      default: () => null
    },
    btnagree:{
        type:Boolean,
        default:false
    }
  },
  data() {
    return {
      title: "请假信息",
      controllerName: "staffLeave",
      columns: [
        { prop: "staffidname", label: "员工名称", sortable: true },
        { prop: "start_date", label: "开始时间", sortable: true },
        { prop: "end_date", label: "结束时间", sortable: true },
        { prop: "remark", label: "理由", sortable: true },
        { prop: "status", label: "是否批准", sortable: true }
      ],
      routerData: {
        router: "streetEdit",
        id: ""
      }
    };
  },
  mounted() {},
  methods: {}
};
</script>