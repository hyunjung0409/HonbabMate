import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Manual from "../views/Manual.vue";
import FAQ from "../views/FAQ.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
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
];

const router = new VueRouter({
  routes,
});

export default router;
