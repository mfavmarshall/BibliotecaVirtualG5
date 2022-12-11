import { createRouter, createWebHistory } from "vue-router";
import Login from "../views/Login.vue";
import Home from "../views/Home.vue";
import MyLibrary from "../views/MyLibrary.vue";
import EditProfile from "../views/EditProfile.vue";
import CreateProfile from "../views/CreateProfile.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASEURL),
  routes: [
    {
      path: "/",
      name: "login",
      component: Login,
    },
    {
      path: "/home",
      name: "home",
      component: Home,
    },
    {
      path: "/mylibrary",
      name: "mylibrary",
      component: MyLibrary,
    },
    {
      path: "/editprofile",
      name: "editprofile",
      component: EditProfile,
    },
    {
      path: "/createprofile",
      name: "createprofile",
      component: CreateProfile,
    }
  ],
});

export default router;
