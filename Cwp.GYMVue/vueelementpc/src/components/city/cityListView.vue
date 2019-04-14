<template>
  <div>
    <div>
      <el-row class="listbtnbox">
        <el-col :span="2" class="listtitle">市</el-col>
        <el-col :span="12">&nbsp;</el-col>
        <el-col :span="2">
          <template>
            <el-button type="text" icon="el-icon-plus" class="listbutton" @click="goAddPage">新建</el-button>
          </template>
        </el-col>
        <el-col :span="2">
          <template>
            <el-button type="text" icon="el-icon-delete" class="listbutton">删除</el-button>
          </template>
        </el-col>
        <el-col :span="5">
          <el-input placeholder="请输入内容" v-model="search" size="medium">
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </el-col>
      </el-row>
    </div>
    <div class="listbox">
      <el-row>
        <el-col :span="24">
          <el-table
            ref="multipleTable"
            :data="tableData"
            tooltip-effect="dark"
            style="width: 100%"
            @selection-change="handleSelectionChange"
            :stripe="isstripe"
          >
            <el-table-column type="selection" width="80"></el-table-column>
            <el-table-column prop="name" label="名称" width="400"></el-table-column>
            <el-table-column prop="provincename" label="上级省" width="500"></el-table-column>
          </el-table>
        </el-col>
      </el-row>
      <el-row>
        <el-col>
          <div class="block">
            <el-pagination
              @current-change="handleCurrentChange"
              :current-page="currentPage"
              :page-size="pageSize"
              layout="total, prev, pager, next, jumper"
              :total="total"
            ></el-pagination>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "cityList",
  data() {
    return {
      tableData: [],
      pageSize: 5,
      pageIndex: 1,
      total: 0,
      currentPage: 1,
      search: "",
      isstripe: true,
      routerData: {
        router: "cityEdit",
        id: ""
      }
    };
  },
  mounted() {
      this.loadData();
  },
  methods: {
    handleSelectionChange() {},
    handleCurrentChange(data) {
       this.pageIndex=data;
       this.loadData();
    },
    goAddPage() {
      this.$emit("listionRouter", this.routerData);
    },
    loadData() {
      var url = "http://localhost:50379/api/city/GetDataList?pageIndex="+this.pageIndex+"&pageSize="+this.pageSize+"&search";
      this.$axios
        .get(url)
        .then(resp=>{
            this.tableData=resp.data.list;
            this.total=parseInt(resp.data.Count);
        })
        .catch();
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
</style>
