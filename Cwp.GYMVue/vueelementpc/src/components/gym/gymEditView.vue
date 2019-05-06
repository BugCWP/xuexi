<template>
  <div>
    <div>
      <el-row class="listbtnbox">
        <el-col :span="2" class="listtitle">健身房</el-col>
        <el-col :span="15">&nbsp;</el-col>
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
            <el-form-item label="名称" prop="name">
              <el-input v-model="formData.name" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="7">
            <el-form-item label="开始营业" prop="sex">
              <el-time-picker
                v-model="formData.start_time"
                :picker-options="{selectableRange: '00:00:00 - 23:59:59'}"
                placeholder="开始营业时间"
                value-format="HH:mm"
              ></el-time-picker>
            </el-form-item>
          </el-col>
          <el-col :span="7">
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
          <el-col :span="14">
            <el-form-item label="介绍" prop="remark">
              <el-input type="textarea" autosize v-model="formData.remark" clearable></el-input>
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
  name: "gymEdit",
  components: {
    "cwp-lookup": cwplookup,
    "cwp-img-upload": cwpimgupload
  },
  data() {
    return {
      controllerName: "gym",
      routerData: {
        router: "gymList",
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
      coachleveltitle: "教练等级",
      coachlevelcontrollerName: "coachlevel",
      coachlevelcolumns: [
        { prop: "name", label: "名称", sortable: true },
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
