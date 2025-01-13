import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/songsheet',//歌单
    name: 'SongSheet',
    component: () => import(/* webpackChunkName: "about" */ '../views/SongSheet.vue')
  },
  {
    path:'/playingMusic',//正在播放的列表
    name:'playingMusic',
    component:()=>import('../views/PlayingMusic.vue')

  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
