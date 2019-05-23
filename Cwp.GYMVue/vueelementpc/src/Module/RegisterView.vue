<template>
  <el-container>
    <el-header height="80px">
      <el-row>
        <el-col :span="3" class="registerLogo">GYM</el-col>
        <el-col :span="19">&nbsp;</el-col>
        <el-col :span="2">
          <el-button type="text" icon="el-icon-back" class="listbutton" @click="goback">登陆</el-button>
        </el-col>
      </el-row>
    </el-header>
    <el-container style="margin-left:200px;">
      <el-form :model="formData" ref="form" :rules="rules" label-width="120px" v-if="thisform">
        <el-row class="row_padding">
          <el-col class="section_title" :span="6">法人基本信息</el-col>
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
            <el-form-item label="性别" prop="sex">
              <el-select v-model="formData.sex" placeholder="请选择">
                <el-option
                  v-for="item in optionssex"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="年龄" prop="sex">
              <el-input v-model="formData.age" clearable></el-input>
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
          <el-col :span="18">&nbsp;</el-col>
          <el-col :span="6">
            <el-button type="success" @click="saveone">确认</el-button>
          </el-col>
        </el-row>
      </el-form>
      <el-form :model="formData" ref="form" :rules="rules" label-width="120px" v-else>
        <el-row class="row_padding">
          <el-col class="section_title" :span="7">法人账号密码</el-col>
        </el-row>
        <el-row>
          <el-col :span="16">
            <el-form-item label="账号" prop="accountnumber">
              <el-input v-model="formData.accountnumber" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="16">
            <el-form-item label="密码" prop="password">
              <el-input v-model="formData.password" clearable></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="16">
            <el-form-item label="再次输入密码" prop="password">
              <el-input v-model="password" clearable></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">&nbsp;</el-col>
          <el-col>
            <el-button type="success" @click="savetwo">确认</el-button>
          </el-col>
        </el-row>
      </el-form>
    </el-container>
    <el-footer></el-footer>
  </el-container>
</template>

<script>
import cwplookup from "@/components/cwplookup/cwplookupView";
export default {
  name: "Register",
  components: {
    "cwp-lookup": cwplookup
  },
  data() {
    return {
      controllerName: "staff",
      formData: {

      },
      rules: {
        accountNumber: [
          { required: true, message: "账号不能为空", trigger: "blur" }
        ],
        password: [{ required: true, message: "密码不能为空", trigger: "blur" }]
      },
      active: "0",
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
      optionssex: [
        {
          value: "男",
          label: "男"
        },
        {
          value: "女",
          label: "女"
        }
      ],
      thisform: true
    };
  },
  methods: {
    goback() {
      this.$router.push("/Login");
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
    },
    saveone() {
      var url = "/api/" + this.controllerName + "/CreateData";
      var that=this;
      this.$axios
        .post(url, this.formData)
        .then(resp => {
          that.thisform=false;
        })
        .catch(err => {
          this.$message.error("添加失败");
        });
    },
    savetwo() {
      if (this.passwordData.password != this.password) {
        this.$message.error("两次输入密码不一致");
      } else {
        this.passwordData.id = this.editId;
        var url = "/api/" + this.controllerName + "/UpdateData";
        this.$axios
          .post(url, this.passwordData)
          .then(resp => {
            that.goback();
          })
          .catch(err => {
            this.$message.error("失败");
          });
      }
    }
  }
};
</script>

<style>
.registerLogo {
  color: white;
  font-size: 24px;
  font-weight: 800;
}
.el-header {
  background-color: slategray;
  line-height: 100px;
}
.el-footer {
  background-color: #b3c0d1;
  color: white;
  font-size: 17px;
  line-height: 30px;
}
.el-container {
  height: 100%;
}
.el-aside {
  height: 100%;
}
.el-steps {
  padding-left: 60px;
}
.el-scrollbar__wrap {
  overflow-x: hidden;
}
.joinmain {
  padding: 0;
}
.listbutton {
  color: white;
}
.row_padding {
  padding-bottom: 40px;
  padding-top: 20px;
}
.el-form {
  padding-bottom: 50px;
}
</style>
