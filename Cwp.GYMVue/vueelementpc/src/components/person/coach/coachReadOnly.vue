<template>
  <div>
    <div>
      <el-row class="listbtnbox">
        <el-col :span="6" class="listtitle">教练:{{formData.name}}</el-col>
        <el-col :span="13">&nbsp;</el-col>
        <el-col :span="2">
          <template>
            <el-button type="text" icon="el-icon-tickets" class="listbutton" @click="goEdit">编辑</el-button>
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
      <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
        <el-tab-pane label="基本信息" name="first">
          <el-form :model="formData" ref="form" :rules="rules" label-width="120px">
            <el-row>
              <el-col :span="7">
                <div class="readonlytext">姓名:{{formData.name}}</div>
              </el-col>
              <el-col :span="7">
                <div class="readonlytext">电话:{{formData.phone}}</div>
              </el-col>
              <el-col :span="7">
                <div class="readonlytext">邮箱:{{formData.email}}</div>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="7">
                <div class="readonlytext">性别:{{formData.sex}}</div>
              </el-col>
              <el-col :span="7">
                <div class="readonlytext">年龄:{{formData.age}}</div>
              </el-col>
              <el-col :span="7">
                <div class="readonlytext">账号:{{formData.accountnumber}}</div>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="7">
                <div class="readonlytext">省地址:{{formData.provincename}}</div>
              </el-col>
              <el-col :span="7">
                <div class="readonlytext">市地址：{{formData.cityname}}</div>
              </el-col>
              <el-col :span="7">
                <div class="readonlytext">区地址:{{formData.areaname}}</div>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="7">
                <div class="readonlytext">街道地址:{{formData.streetname}}</div>
              </el-col>
              <el-col :span="7">
                <div class="readonlytext">详细地址:{{formData.specificaddress}}</div>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="7">
                <div class="readonlytext">教练等级:{{formData.coachlevelname}}</div>
              </el-col>
              <el-col :span="7">
                <div class="readonlytext">注册时间:{{formData.entrytime}}</div>
              </el-col>
            </el-row>
          </el-form>
        </el-tab-pane>
        <el-tab-pane label="参加课程" name="second">
          <cwp-list-table
            :controllerName="coursement"
            :columns="coursecolumns"
            :paramList="{'coachid':editId}"
            :loaddata="secondload"
          ></cwp-list-table>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<script>
import cwplisttable from "@/components/cwplist/cwplisttableView";
export default {
  components: {
    "cwp-list-table": cwplisttable
  },
  data() {
    return {
      controllerName: "coach",
      routerData: {
        router: "coachEdit",
        id: ""
      },
      routerDataList: {
        router: "coachList",
        id: ""
      },
      editId: "",
      formData: {
        name: ""
      },
      activeName: "first",
      coursement: "gym_course",
      coursecolumns: [
        { prop: "coursename", label: "课程名", sortable: true },
        { prop: "gymname", label: "健身房", sortable: true },
        { prop: "coachname", label: "教练", sortable: true },
        { prop: "startstatus", label: "课程状态", sortable: true },
        { prop: "starttime", label: "开课时间", sortable: true,type:"datetime" },
        { prop: "duration", label: "时长(分)", sortable: true },
        { prop: "amount", label: "人数", sortable: true }
      ],
      secondload: false
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
    async isEdit() {
      if (this.editId != null && this.editId != "") {
        var url = "/api/" + this.controllerName + "/GetData?id=" + this.editId;
        await this.$axios
          .get(url)
          .then(resp => {
            this.formData = resp.data;
          })
          .catch();
      }
    },
    goEdit() {
      this.routerData.id = this.editId;
      this.$emit("listionRouter", this.routerData);
    },
    goback() {
      this.$emit("listionRouter", this.routerDataList);
    },
    handleClick(data) {
      if (data.name == "second") {
        this.secondload = true;
      } else {
        this.secondload = false;
      }
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
.readonlytext {
  padding-top: 20px;
}
.cwp-list-table {
  padding: 0;
}
</style>
