import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Manual from "../views/Manual.vue";
import FAQ from "../views/FAQ.vue";
import About from "../views/About.vue";
import Loading from "../views/Loading.vue";
import Chatroom from "../views/Chatroom.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    component: About,
  },
  {
    path: "/manual",
    name: "Manual",
    component: Manual,
  },
  {
    path: "/FAQ",
    name: "FAQ",
    component: FAQ,
  },
  {
    path: "/loading",
    name: "Loading",
    component: Loading,
  },

  {
    path: "/chatroom",
    name: "Chatroom",
    component: Chatroom,
  },
];

const router = new VueRouter({
  routes,
});

export default router;
