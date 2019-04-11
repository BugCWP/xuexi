<template>
  <div>
    <div>
      <el-row class="listbtnbox">
        <el-col :span="2" class="listtitle">健身房</el-col>
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
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column label="日期" width="120">
              <template slot-scope="scope">{{ scope.row.date }}</template>
            </el-table-column>
            <el-table-column prop="name" label="姓名" width="120"></el-table-column>
            <el-table-column prop="address" label="地址" show-overflow-tooltip></el-table-column>
          </el-table>
        </el-col>
      </el-row>
      <el-row>
        <el-col>
          <div class="block">
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="currentPage"
              :page-sizes="[10, 20, 30, 40]"
              :page-size="pageSize"
              layout="total, sizes, prev, pager, next, jumper"
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
  name: "gymList",
  data() {
    return {
      tableData: [],
      pageSize: 10,
      pageIndex: "",
      total: 0,
      currentPage: 1,
      search: "",
      isstripe: true,
      routerData: {
        router: "gymEdit",
        id: ""
      }
    };
  },
  methods: {
    handleSelectionChange() {},
    handleCurrentChange() {},
    handleSizeChange() {},
    goAddPage() {
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
