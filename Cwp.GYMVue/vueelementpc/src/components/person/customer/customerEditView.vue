<template>
  <div>
    <div>
      <el-row class="listbtnbox">
        <el-col :span="2" class="listtitle">会员</el-col>
        <el-col :span="14">&nbsp;</el-col>
        <el-col :span="2">
          <cwp-img-upload
            v-show="editId!=''"
            :ThingcontrollerName="controllerName"
            :Thingid="editId"
          ></cwp-img-upload>
        </el-col>
        <el-col :span="2">
          <template>
            <el-button
              type="text"
              icon="el-icon-edit"
              class="listbutton"
              @click="dialogFormVisible=true"
              v-if="!isEditOrCreate()"
            >修改密码</el-button>
          </template>
        </el-col>
        <el-col :span="2">
          <template>
            <el-button
              type="text"
              icon="el-icon-tickets"
              class="listbutton"
              @click="goAddPage"
              v-if="isEditOrCreate()"
            >保存</el-button>
            <el-button
              type="text"
              icon="el-icon-tickets"
              class="listbutton"
              @click="goEdit"
              v-else
            >修改</el-button>
          </template>
        </el-col>
        <el-col :span="2">
          <template>
            <el-button type="text" icon="el-icon-back" class="listbutton" @click="goback">返回</el-button>
          </template>
        </el-col>
      </el-row>
    </div>
    <div class="listbox">
      <el-form :model="formData" ref="form" :rules="rules" label-width="120px">
        <el-row class="row_padding">
          <el-col class="section_title" :span="3">基本信息</el-col>
        </el-row>
        <el-row>
          <el-col :span="7">
            <el-form-item label="姓名" prop="name">
              <el-input v-model="formData.name" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="7">
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
          <el-col :span="7">
            <el-form-item label="年龄" prop="age">
              <el-input v-model="formData.age" clearable></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="7">
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
          <el-col :span="7">
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
          <el-col :span="7">
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
        </el-row>
        <el-row>
          <el-col :span="7">
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
          <el-col :span="7">
            <el-form-item label="详细地址" prop="specificaddress">
              <el-input v-model="formData.specificaddress" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="7">
            <el-form-item label="电话" prop="phone">
              <el-input v-model="formData.phone" clearable></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="7">
            <el-form-item label="邮箱" prop="email">
              <el-input v-model="formData.email" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="7">
            <el-form-item label="账号" prop="accountnumber">
              <el-input v-model="formData.accountnumber" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="7">
            <el-form-item label="会员类别" prop="customerlevel">
              <cwp-lookup
                :title="customerleveltitle"
                :controllerName="customerlevelcontrollerName"
                :inputdata="formData.customerlevelname"
                :columns="customerlevelcolumns"
                @lookdata="getcustomerlevelinput"
              ></cwp-lookup>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </div>
    <el-dialog title :visible.sync="dialogFormVisible">
      <el-form>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="passwordData.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="再次输入密码" :label-width="formLabelWidth">
          <el-input v-model="password" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="changepassword">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import cwplookup from "@/components/cwplookup/cwplookupView";
import cwpimgupload from "@/components/cwpimg/cwpImgUpload";
export default {
  name: "customerEdit",
  components: {
    "cwp-lookup": cwplookup,
    "cwp-img-upload": cwpimgupload
  },
  data() {
    return {
      controllerName: "customer",
      routerData: {
        router: "customerList",
        id: ""
      },
      formData: {
        name: ""
      },
      rules: {
        name: [{ required: true, message: "请输入姓名", trigger: "change" }],
        sex: [{ required: false, message: "请选择性别", trigger: "change" }],
        age: [{ required: false, message: "请输入年龄", trigger: "change" }]
      },
      editId: "",
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
      customerleveltitle: "会员类别",
      customerlevelcontrollerName: "customerlevel",
      customerlevelcolumns: [
        { prop: "name", label: "名称", sortable: true },
        { prop: "price", label: "价格", sortable: true },
        { prop: "levelname", label: "等级", sortable: true }
      ],
      dialogFormVisible: false,
      passwordData: {
        password: "",
        id: ""
      },
      password: ""
    };
  },
  props: {
    editId: String,
    required: true
  },
  mounted() {
    this.isEdit();
  },
  methods: {
    goAddPage() {
      var url = "/api/" + this.controllerName + "/CreateData";
      this.formData.code = this.guid();
      this.$axios
        .post(url, this.formData)
        .then(resp => {
          this.$message({
            message: "添加成功",
            type: "success"
          });
          this.goback();
        })
        .catch(err => {
          this.$message.error("添加失败");
        });
    },
    goEdit() {
      var url = "/api/" + this.controllerName + "/UpdateData";
      this.$axios
        .post(url, this.formData)
        .then(resp => {
          this.$message({
            message: "修改成功",
            type: "success"
          });
          this.goback();
        })
        .catch(err => {
          this.$message.error("修改失败");
        });
    },
    goback() {
      this.$emit("listionRouter", this.routerData);
    },
    isEdit() {
      if (this.editId != null && this.editId != "") {
        var url = "/api/" + this.controllerName + "/GetData?id=" + this.editId;
        this.$axios
          .get(url)
          .then(resp => {
            this.formData = resp.data;
          })
          .catch();
      }
    },
    isEditOrCreate() {
      if (this.editId != null && this.editId != "") {
        return false;
      } else {
        return true;
      }
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
    getcustomerlevelinput(data) {
      this.formData.customerlevelid = data.id;
      this.formData.customerlevelname = data.name;
    },
    changepassword() {
      if (this.passwordData.password != this.password) {
        this.$message.error("两次输入密码不一致");
      } else {
        this.passwordData.id = this.editId;
        var url = "/api/" + this.controllerName + "/UpdateData";
        this.$axios
          .post(url, this.passwordData)
          .then(resp => {
            this.$message({
              message: "修改密码成功",
              type: "success"
            });
            this.goback();
          })
          .catch(err => {
            this.$message.error("修改密码失败");
          });
      }
    },
    guid() {
      return (
        this.S4() +
        this.S4() +
        "-" +
        this.S4() +
        "-" +
        this.S4() +
        "-" +
        this.S4() +
        "-" +
        this.S4() +
        this.S4() +
        this.S4()
      );
    },
    S4(c) {
      return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
    }
  }
};
</script>

<style>
.listbtnbox {
  width: 100%;
  height: 60px;
  padding-top: 10px;
  background-color: white;
}
.listbox {
  background-color: white;
  height: 350px;
  width: 96%;
  margin: 20px;
}
.listtitle {
  line-height: 40px;
}
.listbutton {
  color: #6c6c6c;
}
.row_padding {
  padding-bottom: 40px;
  padding-top: 20px;
}
</style>
