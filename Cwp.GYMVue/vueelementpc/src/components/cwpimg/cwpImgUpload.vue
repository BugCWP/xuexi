<template>
  <div>
    <el-button type="text" icon="el-icon-picture-outline" @click="dialogVisiblechange">图片</el-button>

    <el-dialog
      :title="dialogtitle"
      :visible.sync="dialogshow"
      :width="dialogwidth"
      :before-close="handleClose"
    >
      <el-upload
        :action="updateurl"
        list-type="picture-card"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove"
        :file-list="fileList"
        :data="uploadImgData"
      >
        <i class="el-icon-plus"></i>
      </el-upload>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancelbtn">取 消</el-button>
        <el-button type="primary" @click="confirm">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog :visible.sync="dialogVisible">
      <img width="100%" :src="dialogImageUrl" alt>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogshow: false,
      dialogVisible: false,
      controllerName: "picturepath",
      updateurl: "http://localhost:50379/ashx/" + "imgupdate.ashx",
      fileList: [],
      dialogImageUrl: "",
      uploadImgData: {
        data: ""
      },
      formData: {},
      paramList: [],
      imgListdata: []
    };
  },
  props: {
    dialogtitle: {
      type: String,
      default: ""
    },
    dialogwidth: {
      type: String,
      default: "50%"
    },
    ThingcontrollerName: {
      type: String,
      default: ""
    },
    Thingid: {
      type: String,
      default: ""
    }
  },
  mounted() {
    this.getFoemData();
  },
  methods: {
    dialogVisiblechange() {
      if (this.dialogshow) {
        this.dialogshow = false;
      } else {
        this.dialogshow = true;
      }
    },
    cancelbtn() {
      this.dialogshow = false;
    },
    confirm() {
      this.dialogshow = false;
    },
    handleRemove(file, fileList) {
      var url = "/api/" + this.controllerName + "/DeleteData";
      var multipleSelection = [];
      multipleSelection.push({ id: file.id });
      this.$axios
        .post(url, multipleSelection)
        .then(resp => {
          this.$message({
            message: "成功删除" + resp.data + "条省记录信息",
            type: "success"
          });
        })
        .catch(err => {
          this.$message.error("删除失败");
        });
    },
    handlePictureCardPreview(file) {
      this.dialogVisible = true;
      this.dialogImageUrl = file.url;
    },
    getFoemData() {
      var that = this;
      if (this.Thingid != null && this.Thingid != "") {
        var url =
          "/api/" + this.ThingcontrollerName + "/GetData?id=" + this.Thingid;
        this.$axios
          .get(url)
          .then(resp => {
            that.formData = resp.data;
            that.uploadImgData.data = JSON.stringify(that.formData.code);
            that.getImgPath();
          })
          .catch();
      }
    },
    getImgPath() {
      var that = this;
      var url = "/api/" + this.controllerName + "/GetDataList";
      if (this.formData != null) {
        this.paramList = {};
        this.paramList = { code: this.formData.code };
        url = url + "?paramList=" + JSON.stringify(this.paramList);
        this.$axios
          .get(url)
          .then(resp => {
            that.imgListdata = resp.data;
            that.getimgbase(resp.data[0]);
          })
          .catch(err => {});
      }
    },
    getimgbase(value) {
      var that = this;
      if (value != null) {
        var url = "http://localhost:50379/ashx/imgdown.ashx?code=" + value.code;
        this.$axios
          .get(url)
          .then(resp => {
            for (var i = 0; i < resp.data.length; i++) {
              var src = "";
              src = "data:image/png;base64," + resp.data[i].url;
              that.fileList.push({
                id:  resp.data[i].id,
                url: src
              });
            }
          })
          .catch(err => {});
      }
    }
  }
};
</script>

<style>
</style>
