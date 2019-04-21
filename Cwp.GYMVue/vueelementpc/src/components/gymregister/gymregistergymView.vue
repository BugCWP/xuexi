<template>
  <el-container>
    <el-form :model="formData" ref="form" :rules="rules" label-width="120px">
      <el-row class="row_padding">
        <el-col class="section_title" :span="6">健身房基本信息</el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="名称" prop="name">
            <el-input v-model="formData.name" clearable></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="电话" prop="phone">
            <el-input v-model="formData.phone" clearable></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="开始营业" prop="sex">
            <el-time-picker
              v-model="formData.start_time"
              :picker-options="{selectableRange: '00:00:00 - 23:59:59'}"
              placeholder="开始营业时间"
              value-format="HH:mm"
            ></el-time-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="结束营业" prop="sex">
            <el-time-picker
              v-model="formData.end_time"
              :picker-options="{selectableRange: '00:00:00 - 23:59:59'}"
              placeholder="结束营业时间"
              value-format="HH:mm"
            ></el-time-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="所在省" prop="province">
            <cwp-lookup
              :title="provincetitle"
              :controllerName="provincecontrollerName"
              :inputdata="formData.provincename"
              :columns="provincecolumns"
              @lookdata="getprovinceinput"
            ></cwp-lookup>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所在市" prop="city">
            <cwp-lookup
              :title="citytitle"
              :controllerName="citycontrollerName"
              :inputdata="formData.cityname"
              :columns="citycolumns"
              @lookdata="getcityinput"
              :disabled="citydisabled"
              :params="{'provinceid':formData.provinceid}"
            ></cwp-lookup>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="所在区" prop="city">
            <cwp-lookup
              :title="areatitle"
              :controllerName="areacontrollerName"
              :inputdata="formData.areaname"
              :columns="areacolumns"
              @lookdata="getareainput"
              :disabled="areadisable"
              :params="{'cityid':formData.cityid}"
            ></cwp-lookup>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所在街道" prop="street">
            <cwp-lookup
              :title="streettitle"
              :controllerName="streetcontrollerName"
              :inputdata="formData.streetname"
              :columns="streetcolumns"
              @lookdata="getstreetinput"
              :disabled="streetdisable"
              :params="{'areaid':formData.areaid}"
            ></cwp-lookup>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="详细地址" prop="specificaddress">
            <el-input v-model="formData.specificaddress" clearable type="textarea" :rows="1"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="formData.email" clearable></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-form-item label="介绍" prop="remark">
            <el-input type="textarea"  v-model="formData.remark" clearable></el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="17">&nbsp;</el-col>
        <el-col :span="7">
          <el-button type="success" @click="firstbtn">下一步</el-button>
        </el-col>
      </el-row>
    </el-form>
  </el-container>
</template>

<script>
import cwplookup from "@/components/cwplookup/cwplookupView";
export default {
  name: "gymregistergym",
  components: {
    "cwp-lookup": cwplookup
  },
  data() {
    return {
      formData: {
        name:'',
        phone:'',
        start_time:'',
        end_time:'',
        provincename:'',
        cityname:'',
        areaname:'',
        streetname:'',
        specificaddress:'',
        email:'',
        remark:''
      },
      routedata:{
        data:"",
        count:'1',
        label:false,
      },
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
    };
  },
  props:{
    lastdata:{
      type:Object,
      default:()=>({})
    }
  },
  mounted(){
      this.formData=this.lastdata;
  },
  methods:{
    firstbtn(){
      this.routedata.data=this.formData;
       this.$emit("listionRouter", this.routedata);
    },
    getareainput(data) {
      this.formData.areaname = data.name;
      this.formData.areaid = data.id;
      this.streetdisable = false;
    },
    getprovinceinput(data) {
      this.formData.provinceid = data.id;
      this.formData.provincename = data.name;
      this.citydisabled = false;
    },
    getcityinput(data) {
      this.formData.cityid = data.id;
      this.formData.cityname = data.name;
      this.areadisable = false;
    },
    getstreetinput(data) {
      this.formData.streetid = data.id;
      this.formData.streetname = data.name;
    }
  }
};
</script>

<style>
.el-container {
  margin: 0;
  padding: 0;
}
.row_padding {
  padding-bottom: 40px;
  padding-top: 20px;
}
</style>
