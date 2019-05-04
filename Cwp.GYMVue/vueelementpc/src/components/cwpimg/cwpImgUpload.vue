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
        :headers="headers"
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
      controllerName:"picturepath",
      updateurl: "http://localhost:50379/ashx/" + "imgupdate.ashx",
      fileList: [],
      dialogImageUrl: "",
      headers: [{ "Access-Control-Allow-Origin": "*" }],
      uploadImgData: {
        data: ""
      }
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
    controllerName: {
      type: String,
      default: ""
    },
    paramList: {
      type: Object,
      default: () => null
    },
    imgcode:{
      type:String,
      default:""
    }
  },
  mounted() {
    this.getImgPath();
    if (imgcode != "") {
      this.uploadImgData.data = this.imgcode;
    }
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
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      console.log(file);
    },
    async getImgPath() {
      var url =
        "/api/" +
        this.controllerName +
        "/GetDataList? ";
      if (this.params != null) {
        url = url + "&paramList=" + JSON.stringify(this.params);
          await this.$axios
          .get(url)
          .then(resp => {
          
          })
          .catch(err => {
         
          });
      }
    }
  }
};
</script>

<style>
</style>
