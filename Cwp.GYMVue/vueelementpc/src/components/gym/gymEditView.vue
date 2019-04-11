<template>
  <div>
    <div>
      <el-row class="listbtnbox">
        <el-col :span="2" class="listtitle">健身房</el-col>
        <el-col :span="17">&nbsp;</el-col>
        <el-col :span="2">
          <template>
            <el-button type="text" icon="el-icon-tickets" class="listbutton" @click="goAddPage">保存</el-button>
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
        <el-row>
          <el-col class="section__title">基本信息</el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="名称" prop="name">
              <el-input
                v-model="formData.name"
                clearable
              ></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="开始日期" prop="start_date">
             
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="截止日期" prop="end_date">
             
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="学习人" prop="OwnerId">
             
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="16">
            <el-form-item label="备注" prop="remark">
              <el-input
                v-model="formData.remark"
                clearable
              ></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row class="form__section-gap"></el-row>
        <learn-plan-course-list v-if="isEdit" :related-attr="learnPlanCourseId"></learn-plan-course-list>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "gymEdit",
  data() {
    return {
      routerData: {
        router: "gymList",
        id: ""
      },
      formData: {},
      rules: {
        name: [
          { required: true, message: "请输入计划名称", trigger: "change" }
        ],
        OwnerId: [
          { required: true, message: "请选择学习人", trigger: "change" }
        ],
        start_date: [
          { required: true, message: "请选择计划开始日期", trigger: "change" }
        ],
        end_date: [
          { required: true, message: "请选择计划结束日期", trigger: "change" }
        ],
        remark: [{ required: false, message: "请输入备注", trigger: "change" }]
      }
    };
  },
  methods: {
    EditId(id) {},
    goAddPage() {},
    goback() {
      this.$emit("listionRouter", this.routerData);
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
  height: 200px;
  width: 96%;
  margin: 20px;
}
.listtitle {
  line-height: 40px;
}
.listbutton {
  color: #6c6c6c;
}
</style>
