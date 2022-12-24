import { createRouter, createWebHistory } from 'vue-router'

import HomeIndexView from '../views/home/HomeIndexView'
import KucunIndexView from "../views/kucun/KucunIndexView.vue"
import DinghuoIndexView from "../views/dinghuo/DinghuoIndexView.vue"
import CaiGouIndexView from "../views/caigou/CaiGouIndexView.vue"
import CaiWuAIndexView from "../views/caiwubaoxiaoA/CaiWuAIndexView"
import CaiWuBindexView from "../views/caiwubaoxiaoB/CaiWuBIndexView"
import BillIndexView from "../views/bill/BillIndexView.vue"

import NotFound from '../views/error/NotFound'
const routes = [
  {
    path:"/",
    name: 'home',
    redirect:"/home/",
  },
  {
    path: "/home/",
    name: 'home_index',
    component: HomeIndexView,

  },
  {
    path: "/kucun/",
    name: 'kucun_index',
    component: KucunIndexView,

  },
  {
    path: "/dinghuo/",
    name: 'dinghuo_index',
    component: DinghuoIndexView,

  },
  {
    path:"/caigou/",
    name:'caigou_index',
    component:CaiGouIndexView,
  },
  {
    path:"/caiwua/",
    name:'caiwua_index',
    component:CaiWuAIndexView,
  },
  {
    path:"/caiwub/",
    name:'caiwub_index',
    component:CaiWuBindexView,

  },
  {
    path:"/bill/",
    name:"bill_index",
    component:BillIndexView,
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



export default router