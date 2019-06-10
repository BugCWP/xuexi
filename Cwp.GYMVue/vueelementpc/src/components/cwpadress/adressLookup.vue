<template>
  <div>
    <el-input placeholder="请输入内容" v-model="adressstr" :disabled="true">
      <el-button slot="append" icon="el-icon-search" @click="gopince"></el-button>
    </el-input>
  </div>
</template>

<script>
export default {
  props: {
    backroute: {
      type: String,
      default: ""
    },
    adressstr: {
      type: String,
      default: ""
    }
  },
  data() {
    return {};
  },
  methods: {
    gopince() {
      this.$emit("goroute");
    }
  }
};
</script>

<style>
</style>
