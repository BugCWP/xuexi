// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from "vue";
import App from "./App";
import router from "./router";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import axios from 'axios';
import qs from 'qs';
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
axios.defaults.baseURL="http://localhost:50379";
// POST传参序列化（添加请求拦截器）
axios.interceptors.request.use((config)=> { 
  //在发送请求之前做某件事
  if(config.method === 'post'){ 
  config.data = qs.stringify(config.data); 
  } 
  return config; 
  },(error)=> { 
  // _.toast（“错误的传参”，“失败”）; 
     return Promise.reject(error);
  }); 
  //拦截器
  axios.interceptors.response.use((res) =>{
    if(!res.status==200){
    // _.toast(res.data.msg);
    return Promise.reject(res);
    }
    return res;
    }, (error) => {
    // _.toast("网络异常", 'fail');
    return Promise.reject(error);
    });
Vue.prototype.$axios = axios;
Vue.prototype.$qs = qs;


Vue.config.productionTip = false;
Vue.use(ElementUI);

/* eslint-disable no-new */
new Vue({
  el: "#app",
  router,
  components: { App },
  template: "<App/>"
});
