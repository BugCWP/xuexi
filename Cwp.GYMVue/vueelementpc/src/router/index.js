import Vue from "vue";
import Router from "vue-router";
import Login from "@/Module/LoginView";
import Home from "@/Module/HomeView";
import Register from "@/Module/RegisterView";
import gymList from "@/components/gym/gymListView";
import gymhome from "@/Module/GymHomeView";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      component: Login
    },
    {
      path: "/Login",
      name: "Login",
      component: Login
    },
    {
      path: "/Home",
      name: "Home",
      component: Home
    },
    {
      path:"/Register",
      name:"Register",
      component:Register
    },
    {
      path:"/gymList",
      name:"gymList",
      component:gymList
    },
    {
      path: '/gymList/edit/:id?',
      name: 'gymEdit',
      component: () => import('@/components/gym/gymEditView')
    },
    {
      path:'/gymhome',
      name:'gymHome',
      component:gymhome
    }
  ]
});
