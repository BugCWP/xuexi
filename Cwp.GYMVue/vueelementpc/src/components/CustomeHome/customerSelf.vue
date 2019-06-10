<template>
  <div>
    <div style="width:100%;height:50px;"></div>
    <div class="selfbox" @click="gotoMyself">
      <el-row>
        <el-col :span="1">&nbsp;</el-col>
        <el-col :span="3">
          <img :src="customerbase" class="headimg">
        </el-col>
        <el-col :span="6">
          <el-row style="margin-top:30px">
            <el-col :span="24">{{customerdata.name}}</el-col>
          </el-row>
        </el-col>
        <el-col :span="13" style="text-align:right;font-size:22px">
          <i class="el-icon-arrow-right" style="margin-top:30px"></i>
        </el-col>
      </el-row>
    </div>
    <div class="customerbox" @click="golevel">
      <el-row>
        <el-col :span="1">&nbsp;</el-col>
        <el-col :span="8" style="margin-top:15px">会员等级:{{customerdata.customerlevelname}}</el-col>
        <el-col :span="14" style="text-align:right;font-size:22px">
          <i class="el-icon-arrow-right" style="margin-top:15px"></i>
        </el-col>
      </el-row>
    </div>
    <div class="outbox" @click="gologin">
      <el-row>
        <el-col :span="1">&nbsp;</el-col>
        <el-col :span="1" style="margin-top:4px">
          <i class="el-icon-back"></i>
        </el-col>
        <el-col :span="4" style="margin-top:4px">退出登陆</el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    account: {
      type: String,
      default: ""
    }
  },
  data() {
    return {
      customerdata: {},
      customerbase: "../../static/img/person.png"
    };
  },
  mounted() {
    this.getLoad();
  },
  methods: {
    getLoad() {
      console.log(this.account);
      if (this.account != "") {
        var url = "/api/customer/GetData";
        var formData = {
          accountnumber: this.account
        };
        var that = this;
        this.$axios
          .post(url, formData)
          .then(resp => {
            that.customerdata = resp.data;
            that.gethearimg(resp.data.code);
          })
          .catch(err => {});
      }
    },
    gethearimg(value) {
      var str = [];
      var that = this;
      if (value != null) {
        var url = "http://localhost:50379/ashx/imgdown.ashx?code=" + value;
        this.$axios
          .get(url)
          .then(resp => {
            that.customerbase = "data:image/png;base64," + resp.data[0].url;
          })
          .catch(err => {});
      }
    },
    gotoMyself() {
      this.$router.push({
        path: "customermyself",
        query: {
          id: this.account
        }
      });
    },
    gologin() {
      this.$router.push({
        path: "customeLogin"
      });
    },
    golevel(){
      this.$router.push({
        path: "customermyselflevel",
        query: {
          id: this.account
        }
      });
    }
  }
};
</script>

<style>
.selfbox {
  width: 100%;
  height: 80px;
  background-color: white;
}
.headimg {
  width: 60px;
  height: 60px;
  margin-top: 10px;
}
.outbox {
  width: 100%;
  height: 30px;
  background-color: white;
  margin-top: 30px;
}
.customerbox {
  width: 100%;
  height: 50px;
  background-color: white;
  margin-top: 30px;
}
</style>
