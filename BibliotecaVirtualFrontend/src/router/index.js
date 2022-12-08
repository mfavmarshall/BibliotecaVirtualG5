import { createRouter, createWebHistory } from "vue-router";
import Login from '../views/Login.vue'

const router = createRouter(
    {
        history: createWebHistory(import.meta.env.BASEURL),
        routes: [
            {
                path: '/',
                name: 'login',
                component: Login
            },
            {
                path: '/home',
                name: 'home',
                component: ()=> import('../views/Home.vue')
            },
            {   path: '/mylibrary',
                name: 'mylibrary',
                component: ()=> import('../views/MyLibrary.vue')
            }
        ]
    }
)

export default router