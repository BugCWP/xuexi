<template>
  <div>
    <div class="headbox">
      <i class="el-icon-arrow-left" style="font-size:30px;color:white" @click="goback"></i>
      <span class="headtitle">{{title}}</span>
    </div>
    <div style="width:100%;height:30px;"></div>
    <div v-for="(item,index) in formdata" :key="index">
      <div class="tablerow" @click="gotonext(item)">
        <div class="tabletext">{{item.name}}</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    title: {
      style: String,
      default: ""
    },
    controllername: {
      style: String,
      default: ""
    },
    address: {
      style: Boolean,
      default: false
    },
    nextcontrollername: {
      style: String,
      default: ""
    },
    paramList: {
      type: Object,
      default: () => null
    },
    backroute:{
        type:String,
        default:""
    }
  },
  data() {
    return {
      formdata: [],
      loading: false
    };
  },
  mounted() {
    this.loadData();
  },
  methods: {
    goback() {
      this.$router.back();
    },
    loadData() {
      var url = "";
      if (this.paramList != null) {
        url =
          "/api/" + this.controllername + "/GetDataList?paramList=" + JSON.stringify(this.paramList);
      } else {
        url = "/api/" + this.controllername + "/GetDataList";
      }
      const that = this;
      this.$axios
        .get(url)
        .then(resp => {
          that.formdata = resp.data;
        })
        .catch();
    },
    gotonext(value) {
        this.$emit('selectclick',value);
    }
  }
};
</script>

<style>
.headbox {
  background-color: slategray;
  text-align: left;
  width: 100%;
  height: 35px;
  padding-top: 10px;
  position: fixed;
  left: -5px;
  padding-left: 10px;
  top: -5px;
}
.headtitle {
  font-size: 20px;
  color: white;
  margin-left: 40%;
}
.tablerow {
  width: 100%;
  text-align: left;
  border-bottom: 0.1px solid rgba(0, 0, 0, 0.8);
}
.tabletext {
  font-size: 20px;
  padding-left: 30px;
  padding-top: 15px;
  padding-bottom: 15px;
}
</style>
