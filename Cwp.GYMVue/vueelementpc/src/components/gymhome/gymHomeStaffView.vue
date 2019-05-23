<template>
  <el-container>
    <el-aside width="150px">
      <el-menu default-active="1" class="el-menu-vertical-demo">
        <el-menu-item index="1" @click="changeindex(1)">
          <span slot="title">基础信息</span>
        </el-menu-item>
        <el-menu-item index="2" @click="changeindex(2)">
          <span slot="title">请假信息</span>
        </el-menu-item>
        <el-menu-item index="3" @click="changeindex(3)">
          <span slot="title">出勤信息</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main>
      <el-container v-if="index==1">
        <el-header>
          <div class="stafftext">职位选择:</div>
          <div class="staffbtn">
            <el-button plain size="mini" @click="changestafflevel('全部')">全部</el-button>
          </div>
          <div class="staffbtn" v-for="(item,index) in staffbtn" :key="index">
            <el-button plain size="mini" @click="changestafflevel(item.id)">{{item.name}}</el-button>
          </div>
        </el-header>
        <el-main>
          <div class="staffcard" v-for="(item, index) in staffcard" :key="index">
            <img
              class="staffcardimage"
              :src="'data:image/png;base64,'+item.imgList[0]"
              height="100px"
              width="150px"
            >
            <div style="padding: 14px;">
              <span>{{item.staff.name}}</span>
              <br>
              <span>{{item.staff.stafflevelname}}</span>
              <div class="bottom clearfix">
                <el-button type="text" class="button">更多</el-button>
              </div>
            </div>
          </div>
        </el-main>
        <el-footer>
          <el-pagination
            @current-change="handleCurrentChange"
            layout="prev, pager, next"
            :page-size="pageSize"
            :total="total"
          ></el-pagination>
        </el-footer>
      </el-container>
      <el-container v-if="index==2">
        <cwp-list-table
          :controllerName="'staffLeave'"
          :columns="staffLeavecolumns"
          :paramList="{'courseid':editId}"
          :loaddata="secondload"
        ></cwp-list-table>
      </el-container>
      <el-container v-if="index==3"></el-container>
    </el-main>
  </el-container>
</template>

<script>
import cwplisttable from "@/components/cwplist/cwplisttableView";
export default {
  components: {
    "cwp-list-table": cwplisttable
  },
  data() {
    return {
      index: 1,
      staffbtn: [],
      staffcard: [],
      pageIndex: 1,
      pageSize: 10,
      search: "",
      total: 0,
      stafflevelid: "",
      staffLeavecolumns: [
        { prop: "coursename", label: "课程名", sortable: true },
        { prop: "gymname", label: "健身房", sortable: true },
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
      ]
    };
  },
  props: {
    thisgymid: String
  },
  mounted() {
    this.getstafflevel();
    if (this.thisgymid != "") {
      this.stafflevelid = "{'gymid':'" + this.thisgymid + "'}";
      this.getstaffcard();
    }
  },
  methods: {
    changeindex(value) {
      this.index = value;
    },
    getstafflevel() {
      var url = "/api/stafflevel/GetDataAllList";
      var that = this;
      this.$axios
        .get(url)
        .then(resp => {
          that.staffbtn = resp.data;
        })
        .catch(err => {});
    },
    getstaffcard() {
      var url =
        "/api/staff/GetDataListAndImg?pageIndex=" +
        this.pageIndex +
        "&pageSize=" +
        this.pageSize +
        "&search=" +
        this.search +
        "&paramList=" +
        this.stafflevelid;
      var that = this;
      this.$axios
        .get(url)
        .then(resp => {
          that.staffcard = resp.data.list;
          that.total = parseInt(resp.data.Count);
        })
        .catch(err => {});
    },
    handleCurrentChange(data) {
      this.pageIndex = data;
      this.getstaffcard();
    },
    changestafflevel(value) {
      if (value == "全部") {
        this.stafflevelid = "{'gymid':'" + this.thisgymid + "'}";
      } else {
        this.stafflevelid =
          "{'stafflevelid':'" + value + "','gymid':'" + this.thisgymid + "'}";
      }
      this.getstaffcard();
    }
  }
};
</script>

<style scoped>
.asidebtn {
  font-size: 16px;
  padding-top: 40px;
  padding-bottom: 40px;
  cursor: pointer;
}
.stafftext {
  float: left;
  padding-right: 10px;
}
.staffbtn {
  float: left;
  padding-left: 20px;
}
.staffcard {
  float: left;
  width: 170px;
  height: 200px;
  box-shadow: 1px 1px 5px #888888;
}
.staffcardimage {
}
</style>
