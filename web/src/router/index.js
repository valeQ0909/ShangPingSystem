import { createRouter, createWebHistory } from 'vue-router'
import LoginIndexView from "../views/LoginRegister/LoginIndexView.vue"
import RegisterIndexView from "../views/LoginRegister/RegisterIndexView.vue"

import HomeIndexView from '../views/home/HomeIndexView'
import KucunIndexView from "../views/kucun/KucunIndexView.vue"
import DinghuoIndexView from "../views/dinghuo/DinghuoIndexView.vue"
import CaiGouIndexView from "../views/caigou/CaiGouIndexView.vue"
import CaigoudetailsIndexView from "../views/caigoudetails/CaigoudetailsIndexView.vue"
import CaiWuAIndexView from "../views/caiwubaoxiaoA/CaiWuAIndexView"
import CaiWuBindexView from "../views/caiwubaoxiaoB/CaiWuBIndexView"
import BillIndexView from "../views/bill/BillIndexView.vue"
import BaoxiaodetailsView from "../views/baoxiaodetails/BaoxiaodetailsIndexView.vue"

import NotFound from '../views/error/NotFound'
import store from '../store'
const routes = [
  {
    path:"/",
    name: 'home',
    redirect:"/home/",
    meta:{
      requestAuth: true,
    }
  },
  {
    path:"/login",
    name:"login_index",
    component: LoginIndexView,
  },
  {
    path: "/register",
    name:"register_index",
    component: RegisterIndexView,
  },
  {
    path: "/home/",
    name: 'home_index',
    component: HomeIndexView,
    meta:{
      requestAuth: true,
    }
  },
  {
    path: "/kucun/",
    name: 'kucun_index',
    component: KucunIndexView,
    meta:{
      requestAuth: true,
    }
  },
  {
    path: "/dinghuo/",
    name: 'dinghuo_index',
    component: DinghuoIndexView,
    meta:{
      requestAuth: true,
    }
  },
  {
    path:"/caigou/",
    name:'caigou_index',
    component:CaiGouIndexView,
    meta:{
      requestAuth: true,
    }
  },
  {
    path:"/caigoudetails",
    name:'caigoudetails_index',
    component: CaigoudetailsIndexView,
    props: true,
    meta:{
      requestAuth: true,
    }
  },
  {
    path:"/caiwua/",
    name:'caiwua_index',
    component:CaiWuAIndexView,
    meta:{
      requestAuth: true,
    }
  },
  {
    path:"/caiwub/",
    name:'caiwub_index',
    component:CaiWuBindexView,
    meta:{
      requestAuth: true,
    }
  },
  {
    path:"/baoxiaodetails/",
    name:'baoxiaodetails_index',
    component:BaoxiaodetailsView,
    meta:{
      requestAuth: true,
    }
  },
  {
    path:"/bill/",
    name:"bill_index",
    component:BillIndexView,
    meta:{
      requestAuth: true,
    }
  },
  {
    path: "/404/",
    name: '404',
    component: NotFound,
  },
  {
    path:"/:catchAll(.*)",
    redirect: "/404/"
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  if(to.meta.requestAuth && !store.state.user.is_login){
    next({name:"login_index"});
  }
  else{
    next();
  }
})


export default router