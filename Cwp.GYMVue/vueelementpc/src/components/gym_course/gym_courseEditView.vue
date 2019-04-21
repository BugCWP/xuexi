<template>
  <div>
    <div>
      <el-row class="listbtnbox">
        <el-col :span="3" class="listtitle">课程</el-col>
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
            <el-form-item label="课程名称" prop="course">
              <cwp-lookup
                :title="coursetitle"
                :controllerName="coursecontrollerName"
                :inputdata="formData.coursename"
                :columns="coursecolumns"
                @lookdata="getcourseinput"
              ></cwp-lookup>
            </el-form-item>
          </el-col>
          <el-col :span="7">
            <el-form-item label="健身房" prop="gym">
              <cwp-lookup
                :title="gymtitle"
                :controllerName="gymcontrollerName"
                :inputdata="formData.gymname"
                :columns="gymcolumns"
                @lookdata="getgyminput"
              ></cwp-lookup>
            </el-form-item>
          </el-col>
          <el-col :span="7">
            <el-form-item label="健身教练" prop="coach">
              <cwp-lookup
                :title="coachtitle"
                :controllerName="coachcontrollerName"
                :inputdata="formData.coachname"
                :columns="coachcolumns"
                @lookdata="getcoachinput"
              ></cwp-lookup>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="7">
            <el-form-item label="人数" prop="amount">
              <el-input v-model="formData.remuneration" clearable :disabled=true></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="7">
            <el-form-item label="课程状态" prop="startstatus">
              <el-select v-model="formData.startstatus" placeholder="请选择">
                <el-option
                  v-for="item in optionsstartstatus"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="7">
            <el-form-item label="课程时间" prop="starttime">
              <el-date-picker v-model="formData.starttime" type="datetime" placeholder="课程时间"></el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="7">
            <el-form-item label="课时(分)" prop="duration">
               <el-input v-model="formData.duration" clearable></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </div>
  </div>
</template>

<script>
import cwplookup from "@/components/cwplookup/cwplookupView";
export default {
  name: "gym_courseEdit",
  components: {
    "cwp-lookup": cwplookup
  },
  data() {
    return {
      controllerName: "gym_course",
      routerData: {
        router: "gym_courseList",
        id: ""
      },
      formData: {
        name: ""
      },
      rules: {
        course: [{ required: false, message: "请选择课程", trigger: "change" }],
        gym: [{ required: false, message: "请选择健身房", trigger: "change" }],
        coach: [{ required: false, message: "请选择教练", trigger: "change" }],
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
      optionsstartstatus: [
        {
          value: "等待",
          label: "等待"
        },
        {
          value: "进行",
          label: "进行"
        },
        {
          value: "结束",
          label: "结束"
        }
      ],
      coursetitle: "开设课程",
      coursecontrollerName: "course",
      coursecolumns: [
        { prop: "name", label: "名称", sortable: true },
        { prop: "coursetype", label: "种类", sortable: true },
        { prop: "customerlevel", label: "会员等级", sortable: true },
        { prop: "coachlevel", label: "教练等级", sortable: true }
      ],
      gymtitle: "健身房",
      gymcontrollerName: "gym",
      gymcolumns: [
        { prop: "name", label: "名称", sortable: true },
        { prop: "provincename", label: "省", sortable: true },
        { prop: "cityname", label: "市", sortable: true },
        { prop: "areaname", label: "区", sortable: true },
        { prop: "streetname", label: "街道", sortable: true },
        { prop: "specificaddress", label: "详细地址", sortable: true }
      ],
      coachtitle: "教练",
      coachcontrollerName: "coach",
      coachcolumns: [
        { prop: "name", label: "名称", sortable: true },
        { prop: "coachlevelname", label: "教练等级", sortable: true }
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
    getcourseinput(data) {
      this.formData.courseid = data.id;
      this.formData.coursename = data.name;
    },
    getgyminput(data) {
      this.formData.gymid = data.id;
      this.formData.gymname = data.name;
    },
    getcoachinput(data) {
      this.formData.coachid = data.id;
      this.formData.coachname = data.name;
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
