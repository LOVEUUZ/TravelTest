import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import MainMenuView from '../views/MainMenu.vue'
import UserInfo from "@/views/UserInfo";

Vue.use(VueRouter)

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
        path: '/MainMenu',
        name: 'MainMenu',
        component: MainMenuView,
        children: [{
            path: 'travelInfo',
            name: 'travelInfo',
            component: () => import('../views/TravelInfo.vue')
        }, {
            path: 'userInfo',
            name: 'userInfo',
            component: UserInfo
        },
            {
                path: '/video',
                name: 'videoTest',
                component: () => import(/* webpackChunkName: "about" */ '../views/VideoTest.vue')
            },
        ]
    },

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
