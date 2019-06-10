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
      path: "/Register",
      name: "Register",
      component: Register
    },
    {
      path: "/gymList",
      name: "gymList",
      component: gymList
    },
    {
      path: "/gymList/edit/:id?",
      name: "gymEdit",
      component: () => import("@/components/gym/gymEditView")
    },
    {
      path: "/gymhome",
      name: "gymHome",
      component: gymhome
    },
    {
      path: "/customerHome",
      name: "customerHome",
      component: () => import("@/Module/CustomeHomeView")
    },
    {
      path: "/coachHome",
      name: "coachHome",
      component: () => import("@/Module/CoachHomeView")
    },
    {
      path: "/customeLogin",
      name: "customeLogin",
      component: () => import("@/Module/CustomeLoginView")
    },
    {
      path: "/coachLogin",
      name: "coachLogin",
      component: () => import("@/Module/CoachLoginView")
    },
    {
      path: "/customeRegister",
      name: "customeRegister",
      component: () =>import("@/Module/CustomeRegisterView")
    },
    {
      path: "/coachRegister",
      name: "coachRegister",
      component: () =>import("@/Module/CoachRegisterView")
    },
    {
      path: "/provinceLookup",
      name: "provinceLookup",
      component: () =>import("@/components/cwpadress/provinceLookup")
    },
    {
      path: "/cityLookup",
      name: "cityLookup",
      component: () =>import("@/components/cwpadress/cityLookup")
    },
    {
      path: "/areaLookup",
      name: "areaLookup",
      component: () =>import("@/components/cwpadress/areaLookup")
    },
    {
      path: "/streetLookup",
      name: "streetLookup",
      component: () =>import("@/components/cwpadress/streetLookup")
    },
    {
      path:"/SpecificAddressLookup",
      name:"SpecificAddressLookup",
      component:()=>import("@/components/cwpadress/SpecificAddressLookup")
    },
    {
      path:"/customermyself",
      name:"customermyself",
      component:()=>import("@/components/CustomeHome/customermyself")
    },
    {
      path:"/customermyselfedit",
      name:"customermyselfedit",
      component:()=>import("@/components/CustomeHome/customermyselfedit")
    },
    {
      path:"/customerpassword",
      name:"customerpassword",
      component:()=>import("@/components/CustomeHome/customerpassword")
    },
    {
      path:"/customermyselflevel",
      name:"customermyselflevel",
      component:()=>import("@/components/CustomeHome/customermyselflevel")
    },
    {
      path:"/customerIndex",
      name:"customerIndex",
      component:()=>import("@/components/CustomeHome/customerIndex")
    },
    {
      path:"/customergym",
      name:"customergym",
      component:()=>import("@/components/CustomeHome/customergym")
    },
    {
      path:"/coachmyself",
      name:"coachmyself",
      component:()=>import("@/components/CoachHome/coachmyself")
    },
    {
      path:"/coachmyselfedit",
      name:"coachmyselfedit",
      component:()=>import("@/components/CoachHome/coachmyselfedit")
    },
    {
      path:"/coachpassword",
      name:"coachpassword",
      component:()=>import("@/components/CoachHome/coachpassword")
    },
    {
      path:"/coachmyselflevel",
      name:"coachmyselflevel",
      component:()=>import("@/components/CoachHome/coachmyselflevel")
    },
    {
      path:"/coachgym",
      name:"coachgym",
      component:()=>import("@/components/CoachHome/coachgym")
    },
  ]
});
