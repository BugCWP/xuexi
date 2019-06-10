<template>
  <el-container>
    <el-aside width="150px">
      <el-menu default-active="1" class="el-menu-vertical-demo">
        <el-menu-item index="1" @click="changeindex(1)">
          <span slot="title">选购器材</span>
        </el-menu-item>
        <el-menu-item index="2" @click="changeindex(2)">
          <span slot="title">已有器材</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main>
      <el-container v-if="index==1">
        <el-main>
          <div class="staffcard" v-for="(item, index) in equipmentList" :key="index">
            <img
              class="staffcardimage"
              :src="equipmentShopimg(item,index)"
              height="100px"
              width="150px"
            >
            <div
              style="display:inline-block;padding-left:20px;vertical-align: top;padding-top:20px"
            >
              <span>{{item.equipment.name}}</span>
              <br>
              <span style="font-size:12px;color:gray">{{item.equipment.price}}元</span>
              <br>
              <span style="font-size:14px;">{{item.equipment.remark}}</span>
            </div>
            <div style="display:inline-block;float:right;margin-right:20px;margin-top:30px">
              <el-input-number
                size="mini"
                v-model="num[index]"
                controls-position="right"
                @change="handleChange"
                :min="1"
              ></el-input-number>
              <el-button type="text" class="button" @click="buybtn(item,index)">购买</el-button>
            </div>
          </div>
        </el-main>
        <el-footer>
          <el-pagination
            @current-change="handleCurrentChange"
            layout="prev, pager, next"
            :page-size="pageSize"
            :total="total"
          ></el-pagination>
        </el-footer>
      </el-container>
      <el-container v-if="index==2">
        <el-main style="text-align:left">
          <div class="OwinEquipmentCard" v-for="(item, index) in equipmentOwinList" :key="index">
              <img :src="'../../static/img/nothing.gif'" width="180px" height="110px" v-if="thisimgisNull(item.imgList)"/>
            <el-carousel trigger="click" height="110px" v-else>
              <el-carousel-item v-for="(item2,index) in item.imgList" :key="index" > 
                <img :src="'data:image/png;base64,'+item2"/>
              </el-carousel-item>
            </el-carousel>
            <div style="padding-left:10px">
              <span>{{item.gym_equipment.equipmentname}}</span>
              <br>
              <span style="font-size:13px">数量:{{item.gym_equipment.amount}}</span>
              <br/>
            </div>
          </div>
        </el-main>
        <el-footer>
          <el-pagination
            @current-change="handleCurrentChange2"
            layout="prev, pager, next"
            :page-size="pageSize2"
            :total="total2"
          ></el-pagination>
        </el-footer>
      </el-container>
    </el-main>
  </el-container>
</template>

<script>
export default {
  props: {
    thisgymid: String
  },
  data() {
    return {
      index: 1,
      pageIndex: 1,
      pageSize: 10,
      search: "",
      paramList: "",
      equipmentList: [],
      total: 0,
      num: {},
      pageIndex2: 1,
      pageSize2: 10,
      total2: 0,
      paramList2:'',
      equipmentOwinList: []
    };
  },
  mounted() {
    this.getEquipmentAndImg();
  },
  computed: {},
  methods: {
    equipmentShopimg: function(value, index) {
      console.log(value);
      return value.imgList.length != 0
        ? "data:image/png;base64," + value.imgList[0]
        : "../../static/img/nothing.gif";
    },
    changeindex(value) {
      this.index = value;
      if (value == 1) {
        this.getEquipmentAndImg();
      } else if (value == 2) {
        this.getOwinEquipmentAndImg();
      }
    },
    getEquipmentAndImg() {
      var url =
        "/api/equipment/GetDataListAndImg?pageIndex=" +
        this.pageIndex +
        "&pageSize=" +
        this.pageSize +
        "&search=" +
        this.search +
        "&paramList=" +
        this.paramList;
      var that = this;
      this.$axios
        .get(url)
        .then(resp => {
          that.equipmentList = resp.data.list;
          that.total = parseInt(resp.data.Count);
        })
        .catch(err => {});
    },
    handleCurrentChange(value) {
      this.pageIndex = value;
      this.getEquipmentAndImg();
    },
    handleChange() {},
    getOwinEquipmentAndImg() {
        this.paramList2="{'gymroomid':'"+this.thisgymid+"'}"
         var url =
        "/api/gym_equipment/getOwinEquipmentAndImg?pageIndex=" +
        this.pageIndex2 +
        "&pageSize=" +
        this.pageSize2 +
        "&search=" +
        this.search +
        "&paramList=" +
        this.paramList2;
      var that = this;
      this.$axios
        .get(url)
        .then(resp => {
          that.equipmentOwinList = resp.data.list;
          that.total2 = parseInt(resp.data.Count);
        })
        .catch(err => {});
    },
    handleCurrentChange2(value) {
      this.pageIndex2 = value;
      this.getOwinEquipmentAndImg();
    },
    thisimgisNull(value){
       if(value.length==0){
           return true;
       }else{
           return false;
       }
    },
    buybtn(item,index){
      var equipmentid=item.equipment.id;
      var number=this.num[index];
      var gymid=this.thisgymid;
       var url =
        "/api/gym_equipment/Bugequipment?equipmentid=" +
        equipmentid +
        "&gymid=" +
        gymid +
        "&number=" +
        number ;
      var that = this;
      this.$axios
        .get(url)
        .then(resp => {
           this.$message({
            message: "购买成功",
            type: "success"
          });
        })
        .catch(err => {
           this.$message.error("购买失败");
        });
      
    }
  }
};
</script>

<style>
.staffcard {
  width: 100%;
  height: 100px;
  box-shadow: 1px 1px 5px #888888;
  margin-bottom: 10px;
  text-align: left;
}
.staffcardimage {
  display: inline-block;
}
.OwinEquipmentCard{
    width: 180px;
    height: 200px;
    box-shadow: 1px 1px 5px #888888;
    display: inline-block;
    margin-right: 10px;
    margin-bottom: 10px;
}
</style>
