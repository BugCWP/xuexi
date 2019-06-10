<template>
  <div>
    <div class="headbox1">
      <div style="width:100%;height:10px;">&nbsp;</div>
      <el-row>
        <el-col :span="4">&nbsp;</el-col>
        <el-col :span="16">
          <cwp-adress @goroute="goroute" :backroute="'customerHome'" :adressstr="adressstr"></cwp-adress>
        </el-col>
      </el-row>
    </div>
    <div class="indexbox">
      <div v-for="(item,index) in gymList" :key="index">
        <div class="indexeachbox" @click="gotogym(item)">
          <el-row>
            <el-col :span="1">&nbsp;</el-col>
            <el-col :span="4" style="margin-top:20px">
              <img
                :src="item.imgList.length>0?'data:image/png;base64,'+item.imgList[0]:customerbase"
                class="headimg"
              >
            </el-col>
            <el-col :span="2">&nbsp;</el-col>
            <el-col :span="10">
              <el-row>
                <el-col :span="24" style="margin-top:20px;text-align:left">{{item.gym.name}}</el-col>
              </el-row>
              <el-row>
                <el-col :span="6" style="text-align:left;margin-top:5px">电话:</el-col>
                <el-col :span="12" style="text-align:left;margin-top:5px">{{item.gym.phone}}</el-col>
              </el-row>
              <el-row>
                <el-col
                  :span="24"
                  style="text-align:left;margin-top:5px"
                >{{item.gym.start_time+"-"+item.gym.end_time}}</el-col>
              </el-row>
              <el-row>
                <el-col :span="6" style="text-align:left;margin-top:5px">地址:</el-col>
                <el-col
                  :span="18"
                  style="text-align:left;margin-top:5px"
                >{{item.gym.provincename+item.gym.cityname+item.gym.areaname+item.gym.streetname+item.gym.specificaddress}}</el-col>
              </el-row>
            </el-col>
            <el-col :span="7" style="font-size:30px;text-align:right;margin-top:30px;">
              <i class="el-icon-arrow-right" style="margin-top:30px"></i>
            </el-col>
          </el-row>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import cwpadress from "@/components/cwpadress/adressLookup";
export default {
  components: {
    "cwp-adress": cwpadress
  },
  props: {
    account: {
      type: String,
      default: ""
    }
  },
  data() {
    return {
      gymList: {},
      adressstr: "",
      formData: {
        cityid: "",
        cityname: "",
        areaid: "",
        areaname: "",
        provinceid: "",
        provincename: "",
        streetid: "",
        streetname: "",
        specificaddress: ""
      },
      customerbase: "../../static/img/nothing.gif",
      paramList: {}
    };
  },
  mounted() {
    if (this.$route.query.province != undefined) {
      this.formData.provinceid = this.$route.query.province.id;
      this.formData.provincename = this.$route.query.province.name;
      this.formData.cityid = this.$route.query.city.id;
      this.formData.cityname = this.$route.query.city.name;
      this.formData.areaid = this.$route.query.area.id;
      this.formData.areaname = this.$route.query.area.name;
      this.formData.streetid = this.$route.query.streat.id;
      this.formData.streetname = this.$route.query.streat.name;
      this.formData.specificaddress = this.$route.query.spacificAdress;
      this.adressstr =
        this.formData.provincename +
        this.formData.cityname +
        this.formData.areaname +
        this.formData.streetname +
        this.formData.specificaddress;
    }
    this.getAllList();
  },
  methods: {
    getAllList() {
      if (this.formData.provinceid != "" && this.formData.provinceid != null) {
        this.paramList = {
          provinceid: this.formData.provinceid,
          cityid: this.formData.cityid,
          areaid: this.formData.areaid,
          streetid:this.formData.streetid
        };
        var url =
          "/api/gym/GetDataListAndImg?paramList=" +
          JSON.stringify(this.paramList);
      } else {
        var url = "/api/gym/GetDataListAndImg";
      }

      var that = this;
      this.$axios
        .get(url)
        .then(resp => {
          console.log(resp.data);
          that.gymList = resp.data.list;
        })
        .catch(err => {});
    },
    goroute() {
      this.$router.push({
        path: "/provinceLookup",
        query: { backroute: "customerHome" }
      });
    },
    gotogym(value) {
      this.$router.push({
        path: "/customergym",
        query: {
          gymid: value.gym.id,
          id: this.account
        }
      });
    }
  }
};
</script>

<style>
.headbox1 {
  background-color: slategray;
  width: 100%;
  height: 60px;
}
.indexbox {
  height: 520px;
  width: 100%;
  overflow: auto;
  background-color: rgba(243, 242, 242, 0.61);
}
.indexeachbox {
  height: 160px;
  background-color: white;
  width: 100%;
  margin-top: 10px;
}
.headimg {
  width: 100px;
  height: 100px;
}
</style>
