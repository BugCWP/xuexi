<template>
  <el-container>
    <el-aside width="150px">
      <el-menu default-active="1" class="el-menu-vertical-demo">
        <el-menu-item index="1" @click="changeindex(1)">
          <span slot="title">课程查看</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main v-if="index==1">
      <div style="width:100%" v-if="!coursedisabled">
        <el-row>
          <el-col :span="4">&nbsp;</el-col>
          <el-col :span="8">
            <el-row>
              <el-col :span="8" style="padding-top:10px">课程选择：</el-col>
              <el-col :span="16">
                <cwp-lookup
                  :title="coursetitle"
                  :controllerName="coursecontrollerName"
                  :inputdata="coursedata.coursename"
                  :columns="coursecolumns"
                  @lookdata="getcourseinput"
                ></cwp-lookup>
              </el-col>
            </el-row>
            <el-row style="padding-top:10px">
              <el-col :span="8">开始时间：</el-col>
              <el-col :span="16">
                <el-date-picker v-model="coursedata.starttime" type="datetime" placeholder="课程时间"></el-date-picker>
              </el-col>
            </el-row>
            <el-row style="padding-top:10px">
              <el-col :span="8">课时长度(分)：</el-col>
              <el-col :span="16">
                <el-input v-model="coursedata.duration" clearable></el-input>
              </el-col>
            </el-row>
            <el-row style="padding-top:10px">
              <el-col :span="12">&nbsp;</el-col>
              <el-col :span="6">
                <el-button type="primary" @click="saveCourse">确认</el-button>
              </el-col>
              <el-col :span="6">
                <el-button @click="gotoCourselist">取消</el-button>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
      </div>
      <div v-if="coursedisabled">
        <el-calendar>
          <!-- <template slot="dateCell" slot-scope="{date, data}">
            <p
              :class="data.isSelected ? 'is-selected' : ''"
            >{{ data.day.split('-').slice(1).join('-') }} {{ data.isSelected ? '✔️' : ''}}</p>
          </template> -->
        </el-calendar>
      </div>
      <div></div>
    </el-main>
  </el-container>
</template>

<script>
import cwplookup from "@/components/cwplookup/cwplookupView";
export default {
  components: {
    "cwp-lookup": cwplookup
  },
  data() {
    return {
      index: 1,
      coursetitle: "开设课程",
      coursecontrollerName: "course",
      coursecolumns: [
        { prop: "name", label: "名称", sortable: true },
        { prop: "coursetype", label: "种类", sortable: true },
        { prop: "customerlevel", label: "会员等级", sortable: true },
        { prop: "coachlevel", label: "教练等级", sortable: true }
      ],
      coursedata: {},
      coursedisabled: true
    };
  },
  methods: {
    changeindex(value) {
      this.index = value;
    },
    getcourseinput(data) {
      this.coursedata.courseid = data.id;
      this.coursedata.coursename = data.name;
    },
    saveCourse() {},
    gotoCourselist() {
      this.coursedisabled = true;
    }
  }
};
</script>

<style>
</style>
