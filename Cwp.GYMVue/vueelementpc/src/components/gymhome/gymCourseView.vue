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
        <div style="width:100%">
          <el-row>
            <el-col :span="22">
              <cwp-list
                :title="'课程'"
                :controllerName="'gym_course'"
                :columns="columns"
                :titledisabled="true"
                :createrbtn="false"
                :deletebtn="false"
                :searchbtn="false"
                :paramList="paramList"
                :btnagree="false"
              ></cwp-list>
            </el-col>
            <el-col :span="2">
              <el-button type="primary" @click="gotoedit">新增</el-button>
            </el-col>
          </el-row>
        </div>
      </div>
    </el-main>
  </el-container>
</template>

<script>
import cwplookup from "@/components/cwplookup/cwplookupView";
import cwplist from "@/components/cwplist/cwplistView";
export default {
  components: {
    "cwp-lookup": cwplookup,
    "cwp-list": cwplist
  },
  props: {
    thisgymid: String,
    thisstaffid: String
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
      coursedata: {
        courseid:"",
        coursename:'',
        duration:"",
        starttime:"",
        startstatus:"等待",
        gymid:"",
        gymname:"",
      },
      coursedisabled: true,
      columns: [
        { prop: "coursename", label: "课程名", sortable: true },
        { prop: "coachname", label: "教练", sortable: true },
        { prop: "startstatus", label: "课程状态", sortable: true },
        {
          prop: "starttime",
          label: "开课时间",
          sortable: true,
          type: "datetime"
        },
        { prop: "duration", label: "时长(分)", sortable: true },
        { prop: "amount", label: "人数", sortable: true }
      ],
      paramList: { 'gymid': this.thisgymid },
      gymdata: {}
    };
  },
  mounted() {
    this.loaddate();
  },
  methods: {
    loaddate() {
      var url = "/api/gym/GetData?id=" + this.thisgymid;
      var that = this;
      this.$axios
        .get(url)
        .then(resp => {
          that.gymdata = resp.data;
        })
        .catch(err => {});
    },
    changeindex(value) {
      this.index = value;
    },
    getcourseinput(data) {
      this.coursedata.courseid = data.id;
      this.coursedata.coursename = data.name;
    },
    saveCourse() {
      this.coursedata.gymid=this.gymdata.id;
      this.coursedata.gymname=this.gymdata.name;
        var url = "/api/gym_course/CreateData";
      this.$axios
        .post(url, this.coursedata)
        .then(resp => {
          this.$message({
            message: "添加成功",
            type: "success"
          });
          this.coursedisabled=true;
        })
        .catch(err => {
          this.$message.error("添加失败");
        });
    },
    gotoCourselist() {
      this.coursedisabled = true;
    },
    gotoedit() {
      this.coursedisabled = false;
    }
  }
};
</script>

<style>
</style>
