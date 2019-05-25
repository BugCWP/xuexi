<template>
  <el-container>
    <el-aside width="150px">
      <el-menu default-active="1" class="el-menu-vertical-demo">
        <el-menu-item index="1" @click="changeindex(1)">
          <span slot="title">个人中心</span>
        </el-menu-item>
        <el-menu-item index="2" @click="changeindex(2)">
          <span slot="title">健身房信息</span>
        </el-menu-item>
        <el-menu-item index="3" @click="changeindex(3)">
          <span slot="title">请假申请</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main v-if="index==1">
      <div style="width:100%" v-if="personeditdisplay">
        <div style="width:100%;height:30px;"></div>
        <el-row>
          <el-col :span="1">&nbsp;</el-col>
          <el-col :span="4">
            <img
              :src="imgurl"
              width="160px"
              height="180px"
              style=" box-shadow: 1px 1px 5px #888888;"
            >
            <el-upload
              class="upload-demo"
              action="http://localhost:50379/ashx/imgchange.ashx"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :on-success="handleSuccess"
              :file-list="fileList"
              list-type="picture"
              :data="imgdata"
              :limit="1"
            >
              <el-button
                size="small"
                type="primary"
                style="margin-top:20px;width:160px;height:35px;"
              >更换头像</el-button>
            </el-upload>
          </el-col>
          <el-col :span="8">
            <el-row>
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="18" style="text-align:left;">
                <span>姓名:{{staffdata.name}}</span>
              </el-col>
              <el-col :span="2">
                <i class="el-icon-edit personedit" style="cursor: pointer;" @click="gotostaffedit"></i>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="18" style="text-align:left;margin-top:10px">
                <span>年龄:{{staffdata.age}}</span>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="18" style="text-align:left;margin-top:10px">
                <span>性别:{{staffdata.sex}}</span>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="18" style="text-align:left;margin-top:10px">
                <span>所属健身中心:{{staffdata.gymname}}</span>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="18" style="text-align:left;margin-top:10px">
                <span>职位:{{staffdata.stafflevelname}}</span>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="18" style="text-align:left;margin-top:10px">
                <span>电话:{{staffdata.phone}}</span>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="18" style="text-align:left;margin-top:10px">
                <span>邮箱:{{staffdata.email}}</span>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="20" style="text-align:left;margin-top:10px">
                <span>地址:{{address}}</span>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
      </div>
      <div v-if="!personeditdisplay" style="width:100%">
        <div style="width:100%;height:30px;"></div>
        <el-row>
          <el-col :span="1">&nbsp;</el-col>
          <el-col :span="4">
            <img
              :src="imgurl"
              width="160px"
              height="180px"
              style=" box-shadow: 1px 1px 5px #888888;"
            >
            <el-upload
              class="upload-demo"
              action="http://localhost:50379/ashx/imgchange.ashx"
              :on-preview="handlePreview"
              :on-remove="handleRemove"
              :on-success="handleSuccess"
              :file-list="fileList"
              list-type="picture"
              :data="imgdata"
              :limit="1"
            >
              <el-button
                size="small"
                type="primary"
                style="margin-top:20px;width:160px;height:35px;"
              >更换头像</el-button>
            </el-upload>
          </el-col>
          <el-col :span="8">
            <el-row>
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="4" style="padding-top:5px;">姓名:</el-col>
              <el-col :span="14" style="text-align:left;">
                <div class="demo-input-suffix">
                  <el-input v-model="staffdata.name"></el-input>
                </div>
              </el-col>
              <el-col :span="2"></el-col>
            </el-row>
            <el-row style="margin-top:10px">
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="4" style="padding-top:5px;">年龄:</el-col>
              <el-col :span="14" style="text-align:left;">
                <div class="demo-input-suffix">
                  <el-input v-model="staffdata.age"></el-input>
                </div>
              </el-col>
            </el-row>
            <el-row style="margin-top:10px">
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="4" style="padding-top:5px;">性别:</el-col>
              <el-col :span="14" style="text-align:left;">
                <div class="demo-input-suffix">
                  <el-input v-model="staffdata.sex"></el-input>
                </div>
              </el-col>
            </el-row>
            <el-row style="margin-top:10px">
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="4" style="padding-top:5px;">电话:</el-col>
              <el-col :span="14" style="text-align:left;">
                <div class="demo-input-suffix">
                  <el-input v-model="staffdata.phone"></el-input>
                </div>
              </el-col>
            </el-row>
            <el-row style="margin-top:10px">
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="4" style="padding-top:5px;">邮箱:</el-col>
              <el-col :span="14" style="text-align:left;">
                <div class="demo-input-suffix">
                  <el-input v-model="staffdata.email"></el-input>
                </div>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="10">
            <el-row>
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="4" style="padding-top:5px;">省:</el-col>
              <el-col :span="14" style="text-align:left;">
                <cwp-lookup
                  :title="provincetitle"
                  :controllerName="provincecontrollerName"
                  :inputdata="staffdata.provincename"
                  :columns="provincecolumns"
                  @lookdata="getprovinceinput"
                ></cwp-lookup>
              </el-col>
            </el-row>
            <el-row style="margin-top:10px">
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="4" style="padding-top:5px;">市:</el-col>
              <el-col :span="14" style="text-align:left;">
                <cwp-lookup
                  :title="citytitle"
                  :controllerName="citycontrollerName"
                  :inputdata="staffdata.cityname"
                  :columns="citycolumns"
                  @lookdata="getcityinput"
                  :disabled="citydisabled"
                  :params="{'provinceid':staffdata.provinceid}"
                ></cwp-lookup>
              </el-col>
            </el-row>
            <el-row style="margin-top:10px">
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="4" style="padding-top:5px;">区:</el-col>
              <el-col :span="14" style="text-align:left;">
                <cwp-lookup
                  :title="areatitle"
                  :controllerName="areacontrollerName"
                  :inputdata="staffdata.areaname"
                  :columns="areacolumns"
                  @lookdata="getareainput"
                  :disabled="areadisable"
                  :params="{'cityid':staffdata.cityid}"
                ></cwp-lookup>
              </el-col>
            </el-row>
            <el-row style="margin-top:10px">
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="4" style="padding-top:5px;">街道:</el-col>
              <el-col :span="14" style="text-align:left;">
                <cwp-lookup
                  :title="streettitle"
                  :controllerName="streetcontrollerName"
                  :inputdata="staffdata.streetname"
                  :columns="streetcolumns"
                  @lookdata="getstreetinput"
                  :disabled="streetdisable"
                  :params="{'areaid':staffdata.areaid}"
                ></cwp-lookup>
              </el-col>
            </el-row>
            <el-row style="margin-top:10px">
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="4" style="padding-top:5px;">街道:</el-col>
              <el-col :span="14" style="text-align:left;">
                <div class="demo-input-suffix">
                  <el-input v-model="staffdata.specificaddress"></el-input>
                </div>
              </el-col>
            </el-row>
            <el-row style="margin-top:10px">
              <el-col :span="4">&nbsp;</el-col>
              <el-col :span="4" style="padding-top:5px;">具体地址:</el-col>
              <el-col :span="14" style="text-align:left;">
                <div class="demo-input-suffix">
                  <el-input v-model="staffdata.specificaddress"></el-input>
                </div>
              </el-col>
            </el-row>
            <div style="width:100%;height:10px"></div>
            <el-row>
              <el-col :span="14">&nbsp;</el-col>
              <el-col :span="3">
                <el-button type="primary" @click="savestaff">确认</el-button>
              </el-col>
              <el-col :span="7">
                <el-button @click="gotostafflist">取消</el-button>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
      </div>
    </el-main>
    <el-main v-if="index==2">
      <div style="width:100%" v-if="persongymdisplay">
        <div style="width:100%;height:30px;"></div>
        <el-row>
          <el-col :span="6">&nbsp;</el-col>
          <el-col :span="12">
            <el-carousel height="180px">
              <el-carousel-item v-for="(item,index) in imggymurl" :key="index">
                <img
                  :src="item"
                  width="500px"
                  height="150px"
                  style=" box-shadow: 0px 0px 5px #888888;"
                >
              </el-carousel-item>
            </el-carousel>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="6">&nbsp;</el-col>
          <el-col :span="12">
            <el-row>
              <el-col :span="10" style="text-align:left">健身房名称:{{gymdata.name}}</el-col>
              <el-col :span="2">
                <i class="el-icon-edit personedit" style="cursor: pointer;" @click="gotogymedit"></i>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="20" style="text-align:left;padding-top:10px">营业时间:{{gymtime}}</el-col>
            </el-row>
            <el-row>
              <el-col :span="20" style="text-align:left;padding-top:10px">电话:{{gymdata.phone}}</el-col>
            </el-row>
            <el-row>
              <el-col :span="20" style="text-align:left;padding-top:10px">邮箱:{{gymdata.email}}</el-col>
            </el-row>
            <el-row>
              <el-col :span="20" style="text-align:left;padding-top:10px">地址:{{gymaddress}}</el-col>
            </el-row>
            <el-row>
              <el-col
                :span="20"
                style="text-align:left;padding-top:10px"
              >注解:{{gymdata.remark==null?" --":gymdata.remark}}</el-col>
            </el-row>
          </el-col>
        </el-row>
      </div>
      <div style="width:100%" v-else>
        <el-row>
          <el-col>
            <el-upload
              action="http://localhost:50379/ashx/imgupdate.ashx"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove"
              :data="gymimgcode"
              :file-list="gymfileList"
            >
              <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible">
              <img width="100%" :src="dialogImageUrl" alt>
            </el-dialog>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="10">
            <el-row style="padding-top:10px">
              <el-col :span="6">&nbsp;</el-col>
              <el-col :span="6" style="padding-top:10px">健身房名称:</el-col>
              <el-col :span="12">
                <el-input v-model="gymdata.name"></el-input>
              </el-col>
            </el-row>
            <el-row style="padding-top:10px">
              <el-col :span="6">&nbsp;</el-col>
              <el-col :span="6" style="padding-top:10px">电话:</el-col>
              <el-col :span="12">
                <el-input v-model="gymdata.phone"></el-input>
              </el-col>
            </el-row>
            <el-row style="padding-top:10px">
              <el-col :span="6">&nbsp;</el-col>
              <el-col :span="6" style="padding-top:10px">邮箱:</el-col>
              <el-col :span="12">
                <el-input v-model="gymdata.email"></el-input>
              </el-col>
            </el-row>
            <el-row style="padding-top:10px">
              <el-col :span="6">&nbsp;</el-col>
              <el-col :span="6" style="padding-top:10px">开门时间:</el-col>
              <el-col :span="12">
                <el-input v-model="gymdata.start_time"></el-input>
              </el-col>
            </el-row>
            <el-row style="padding-top:10px">
              <el-col :span="6">&nbsp;</el-col>
              <el-col :span="6" style="padding-top:10px">关门时间:</el-col>
              <el-col :span="12">
                <el-input v-model="gymdata.end_time"></el-input>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="10">
            <el-row style="padding-top:10px">
              <el-col :span="6">&nbsp;</el-col>
              <el-col :span="6" style="padding-top:5px;">省:</el-col>
              <el-col :span="12" style="text-align:left;">
                <cwp-lookup
                  :title="provincetitle"
                  :controllerName="provincecontrollerName"
                  :inputdata="gymdata.provincename"
                  :columns="provincecolumns"
                  @lookdata="getprovinceinput2"
                ></cwp-lookup>
              </el-col>
            </el-row>
            <el-row style="padding-top:10px">
              <el-col :span="6">&nbsp;</el-col>
              <el-col :span="6" style="padding-top:5px;">市:</el-col>
              <el-col :span="12" style="text-align:left;">
                <cwp-lookup
                  :title="citytitle"
                  :controllerName="citycontrollerName"
                  :inputdata="gymdata.cityname"
                  :columns="citycolumns"
                  @lookdata="getcityinput2"
                  :disabled="citydisabled2"
                  :params="{'provinceid':gymdata.provinceid}"
                ></cwp-lookup>
              </el-col>
            </el-row>
            <el-row style="padding-top:10px">
              <el-col :span="6">&nbsp;</el-col>
              <el-col :span="6" style="padding-top:5px;">区:</el-col>
              <el-col :span="12" style="text-align:left;">
                <cwp-lookup
                  :title="areatitle"
                  :controllerName="areacontrollerName"
                  :inputdata="gymdata.areaname"
                  :columns="areacolumns"
                  @lookdata="getareainput2"
                  :disabled="areadisable2"
                  :params="{'cityid':gymdata.cityid}"
                ></cwp-lookup>
              </el-col>
            </el-row>
            <el-row style="padding-top:10px">
              <el-col :span="6">&nbsp;</el-col>
              <el-col :span="6" style="padding-top:5px;">街道:</el-col>
              <el-col :span="12" style="text-align:left;">
                <cwp-lookup
                  :title="streettitle"
                  :controllerName="streetcontrollerName"
                  :inputdata="gymdata.streetname"
                  :columns="streetcolumns"
                  @lookdata="getstreetinput2"
                  :disabled="streetdisable2"
                  :params="{'areaid':gymdata.areaid}"
                ></cwp-lookup>
              </el-col>
            </el-row>
            <el-row style="padding-top:10px">
              <el-col :span="6">&nbsp;</el-col>
              <el-col :span="6" style="padding-top:5px;">具体地址:</el-col>
              <el-col :span="12" style="text-align:left;">
                <el-input v-model="gymdata.specificaddress"></el-input>
              </el-col>
            </el-row>
            <el-row style="padding-top:10px">
              <el-col :span="12">&nbsp;</el-col>
              <el-col :span="6">
                <el-button type="primary" @click="savegym">确认</el-button>
              </el-col>
              <el-col :span="6">
                <el-button @click="gotogymlist">取消</el-button>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
      </div>
    </el-main>
    <el-main v-if="index==3">
      <div v-if="leavedisabled" style="width:100%">
        <div style="text-align:right">
          <el-button type="text" icon="el-icon-plus" @click="goAddPage">新建</el-button>
        </div>
        <staff-leave :titledisabled="false" :paramList="paramList" :btnagree="false"></staff-leave>
      </div>
      <div v-else style="width:100%">
        <el-row>
          <el-col :span="4">&nbsp;</el-col>
          <el-col :span="8">
            <el-row style="padding-top:10px">
              <el-col :span="6" style="padding-top:10px">开始时间:</el-col>
              <el-col :span="4">
                <el-date-picker
                  value-format="yyyy-MM-dd HH:mm"
                  v-model="starttime"
                  type="datetime"
                  placeholder="选择日期时间"
                ></el-date-picker>
              </el-col>
            </el-row>
            <el-row style="padding-top:20px">
              <el-col :span="6" style="padding-top:10px">结束时间:</el-col>
              <el-col :span="4">
                <el-date-picker
                  value-format="yyyy-MM-dd HH:mm"
                  v-model="endtime"
                  type="datetime"
                  placeholder="选择日期时间"
                ></el-date-picker>
              </el-col>
            </el-row>
            <el-row style="padding-top:20px">
              <el-col :span="6" style="padding-top:10px">请假理由:</el-col>
              <el-col :span="18">
                <el-input
                  type="textarea"
                  :autosize="{ minRows: 2, maxRows: 10}"
                  placeholder="请输入内容"
                  v-model="remark"
                ></el-input>
              </el-col>
            </el-row>
            <el-row style="padding-top:20px">
              <el-col :span="10">&nbsp;</el-col>
              <el-col :span="14">
                <el-button type="primary" @click="saveleave">确认</el-button>
                <el-button @click="gotoleavelist">取消</el-button>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
      </div>
    </el-main>
  </el-container>
</template>

<script>
import cwplookup from "@/components/cwplookup/cwplookupView";
import staffLeave from "@/components/staffLeave/staffLeaveListView";
export default {
  components: {
    "cwp-lookup": cwplookup,
    "staff-leave": staffLeave
  },
  data() {
    return {
      imgurl: "",
      staffdata: {},
      staffdata2: {},
      index: 1,
      address: "",
      personeditdisplay: true,
      persongymdisplay: true,
      areatitle: "区",
      citytitle: "市",
      provincetitle: "省",
      streettitle: "街道",
      citycontrollerName: "city",
      areacontrollerName: "area",
      provincecontrollerName: "province",
      streetcontrollerName: "street",
      provincecolumns: [{ prop: "name", label: "名称", sortable: true }],
      areacolumns: [
        { prop: "name", label: "名称", sortable: true },
        { prop: "cityname", label: "上级市", sortable: true }
      ],
      citycolumns: [
        { prop: "name", label: "名称", sortable: true },
        { prop: "provincename", label: "上级省", sortable: true }
      ],
      streetcolumns: [
        { prop: "name", label: "名称", sortable: true },
        { prop: "areaname", label: "上级区", sortable: true }
      ],
      citydisabled: true,
      areadisable: true,
      streetdisable: true,
      citydisabled2: true,
      areadisable2: true,
      streetdisable2: true,
      fileList: [],
      imgdata: {
        data: ""
      },
      gymdata: {},
      gymdata2: {},
      imggymurl: [],
      gymaddress: "",
      gymtime: "",
      gymimgcode: {
        data: ""
      },
      dialogImageUrl: "",
      dialogVisible: false,
      gymfileList: [],
      paramList: {},
      leavedisabled: true,
      starttime: "",
      endtime: "",
      remark: "",
      staffleavedata: {
        gymid: "",
        gymidname: "",
        staffid: "",
        staffidname: "",
        start_date: "",
        end_date: "",
        status: "",
        remark: ""
      }
    };
  },
  props: {
    thisid: String
  },
  mounted() {
    this.loaddate();
    this.paramList = { staffid: this.thisid };
  },
  methods: {
    loaddate() {
      var url = "/api/staff/GetData?id=" + this.thisid;
      var that = this;
      this.$axios
        .get(url)
        .then(resp => {
          that.staffdata = resp.data;
          that.loadimg(resp.data.code);
          that.address =
            resp.data.provincename +
            resp.data.cityname +
            resp.data.areaname +
            resp.data.streetname +
            resp.data.specificaddress;
          that.imgdata.data = JSON.stringify(resp.data.code);
        })
        .catch(err => {});
    },
    loadimg(value) {
      var str = [];
      var that = this;
      var url = "http://localhost:50379/ashx/imgdown.ashx?code=" + value;
      this.$axios
        .get(url)
        .then(resp => {
          if (resp.data == null) {
            that.imgurl = "../../static/img/person.png";
          } else {
            that.imgurl = "data:image/png;base64," + resp.data[0].url;
          }
        })
        .catch(err => {});
    },
    changeindex(value) {
      this.index = value;
      if (value == 1) {
        this.loaddate();
        this.personeditdisplay = true;
      } else if (value == 2) {
        this.loadgymdata();
        this.persongymdisplay = true;
      }
    },
    getareainput(data) {
      this.staffdata.areaname = data.name;
      this.staffdata.areaid = data.id;
      this.streetdisable = false;
    },
    getprovinceinput(data) {
      this.staffdata.provinceid = data.id;
      this.staffdata.provincename = data.name;
      this.citydisabled = false;
    },
    getcityinput(data) {
      this.staffdata.cityid = data.id;
      this.staffdata.cityname = data.name;
      this.areadisable = false;
    },
    getstreetinput(data) {
      this.staffdata.streetid = data.id;
      this.staffdata.streetname = data.name;
    },
    getareainput2(data) {
      this.gymdata.areaname = data.name;
      this.gymdata.areaid = data.id;
      this.streetdisable2 = false;
    },
    getprovinceinput2(data) {
      this.gymdata.provinceid = data.id;
      this.gymdata.provincename = data.name;
      this.citydisabled2 = false;
    },
    getcityinput2(data) {
      this.gymdata.cityid = data.id;
      this.gymdata.cityname = data.name;
      this.areadisable2 = false;
    },
    getstreetinput2(data) {
      this.gymdata.streetid = data.id;
      this.gymdata.streetname = data.name;
    },
    gotostaffedit() {
      this.personeditdisplay = !this.personeditdisplay;
      this.staffdata2 = this.staffdata;
    },
    gotostafflist() {
      this.staffdata = this.staffdata2;
      this.personeditdisplay = !this.personeditdisplay;
    },
    savestaff() {
      var url = "/api/staff/UpdateData";
      var that = this;
      this.$axios
        .post(url, this.staffdata)
        .then(resp => {
          this.$message({
            message: "修改成功",
            type: "success"
          });
          that.personeditdisplay = true;
        })
        .catch(err => {
          this.$message.error("修改失败");
        });
    },
    handlePreview() {},
    handleRemove() {},
    handleSuccess() {
      this.loadimg(this.staffdata.code);
    },
    loadgymdata() {
      var url = "/api/gym/GetData?id=" + this.staffdata.gymid;
      var that = this;
      this.$axios
        .get(url)
        .then(resp => {
          that.gymdata = resp.data;
          that.loadgymimg(resp.data.code);
          that.gymtime = resp.data.start_time + " ~~ " + resp.data.end_time;
          that.gymaddress =
            resp.data.provincename +
            resp.data.cityname +
            resp.data.areaname +
            resp.data.streetname +
            resp.data.specificaddress;
          that.gymimgcode.data = JSON.stringify(resp.data.code);
        })
        .catch(err => {});
    },
    loadgymimg(value) {
      var str = [];
      var that = this;
      var url = "http://localhost:50379/ashx/imgdown.ashx?code=" + value;
      this.$axios
        .get(url)
        .then(resp => {
          that.imggymurl = [];
          that.gymfileList = [];
          if (resp.data == null) {
            that.imggymurl.push("../../static/img/person.png");
          } else {
            for (var i = 0; i < resp.data.length; i++) {
              that.imggymurl.push("data:image/png;base64," + resp.data[i].url);
              that.gymfileList.push({
                id: resp.data[i].id,
                url: "data:image/png;base64," + resp.data[i].url
              });
            }
          }
        })
        .catch(err => {});
    },
    gotogymedit() {
      this.persongymdisplay = false;
      this.gymdata2 = this.gymdata;
    },
    handleAvatarSuccess() {},
    savegym() {
      var url = "/api/gym/UpdateData";
      var that = this;
      this.$axios
        .post(url, this.gymdata)
        .then(resp => {
          this.$message({
            message: "修改成功",
            type: "success"
          });
          that.persongymdisplay = true;
          that.loadgymdata();
        })
        .catch(err => {
          this.$message.error("修改失败");
        });
    },
    gotogymlist() {
      this.gymdata = this.gymdata2;
      this.persongymdisplay = true;
    },
    handleRemove(file, fileList) {
      var that = this;
      var url = "http://localhost:50379/ashx/imgdelete.ashx?id=" + file.id;
      this.$axios
        .get(url)
        .then(resp => {})
        .catch(err => {});
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    goAddPage() {
      this.leavedisabled = false;
    },
    saveleave() {
      this.staffleavedata.start_date = this.starttime;
      this.staffleavedata.end_date = this.endtime;
      this.staffleavedata.gymid = this.staffdata.gymid;
      this.staffleavedata.gymidname = this.staffdata.gymname;
      this.staffleavedata.staffid = this.staffdata.id;
      this.staffleavedata.staffidname = this.staffdata.name;
      this.staffleavedata.remark = this.remark;
      this.staffleavedata.status = "待审核";
      var url = "/api/staffLeave/CreateData";
      var that = this;
      this.$axios
        .post(url, this.staffleavedata)
        .then(resp => {
          this.$message({
            message: "保存成功",
            type: "success"
          });
         this.leavedisabled = true;
        })
        .catch(err => {
          this.$message.error("保存失败");
        });
    },
    gotoleavelist() {
      this.leavedisabled = true;
    }
  }
};
</script>

<style>
.personedit:active {
  color: blue;
}
</style>
