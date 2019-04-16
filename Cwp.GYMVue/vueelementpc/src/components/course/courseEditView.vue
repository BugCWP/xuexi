<template>
  <div>
    <div>
      <el-row class="listbtnbox">
        <el-col :span="3" class="listtitle">员工职位等级</el-col>
        <el-col :span="16">&nbsp;</el-col>
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
            <el-form-item label="课程种类" prop="coursetype">
              <el-select v-model="formData.coursetype" placeholder="请选择">
                <el-option
                  v-for="item in optionscoursetype"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="7">
            <el-form-item label="会员等级" prop="customerlevel">
              <el-select v-model="formData.customerlevel" placeholder="请选择">
                <el-option
                  v-for="item in optionscustomerlevel"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="7">
            <el-form-item label="教练等级" prop="coachlevel">
              <el-select v-model="formData.coachlevel" placeholder="请选择">
                <el-option
                  v-for="item in optionscoachlevel"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="7">
            <el-form-item label="课程费" prop="price">
              <el-input v-model="formData.price" clearable></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="7">
            <el-form-item label="报酬费" prop="remuneration">
              <el-input v-model="formData.remuneration" clearable></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-col :span="7"></el-col>
        <el-col :span="14">
          <el-form-item label="说明" prop="price">
            <el-input v-model="formData.remark" clearable type="textarea" autosize></el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </div>
  </div>
</template>

<script>
import cwplookup from "@/components/cwplookup/cwplookupView";
export default {
  name: "courseEdit",
  components: {
    "cwp-lookup": cwplookup
  },
  data() {
    return {
      controllerName: "course",
      routerData: {
        router: "courseList",
        id: ""
      },
      formData: {
        name: ""
      },
      rules: {
        name: [
          { required: true, message: "请输入街道名称", trigger: "change" }
        ],
        coursetype: [
          { required: false, message: "请选择课程种类", trigger: "change" }
        ],
        customerlevel: [
          { required: false, message: "请选择会员等级", trigger: "change" }
        ],
        coachlevel: [
          { required: false, message: "请选择教练等级", trigger: "change" }
        ],
        price: [
          { required: false, message: "请输入课程费", trigger: "change" }
        ],
        remuneration: [
          { required: false, message: "请输入报酬费", trigger: "change" }
        ],
        remark: [{ required: false, message: "请输入介绍", trigger: "change" }]
      },
      editId: "",
      optionscoursetype: [
        {
          value: "私教课程",
          label: "私教课程"
        },
        {
          value: "通用课程",
          label: "通用课程"
        }
      ],
      optionscustomerlevel: [
        {
          value: "普通会员",
          label: "普通会员"
        },
        {
          value: "高级会员",
          label: "高级会员"
        }
      ],
      optionscoachlevel: [
        {
          value: "高级",
          label: "高级"
        },
        {
          value: "中级",
          label: "中级"
        },
        {
          value: "初级",
          label: "初级"
        }
      ],
      staffleveltitle: "上级职位",
      stafflevelcontrollerName: "stafflevel",
      stafflevelcolumns: [
        { prop: "name", label: "名称", sortable: true },
        { prop: "stafflevelname", label: "上级领导", sortable: true },
        { prop: "wage", label: "工资", sortable: true }
      ]
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
    getstafflevelinput(data) {
      this.formData.stafflevelid = data.id;
      this.formData.stafflevelname = data.name;
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
