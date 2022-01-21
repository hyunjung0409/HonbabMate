import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/Home.vue";
import About from "@/views/About.vue";
import ChatTalkOption from "@/views/ChatTalkOption.vue";
import Loading from "@/views/Loading.vue";

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
    path: "/chat-talk-option",
    name: "ChatTalkOption",
    component: ChatTalkOption,
  },
  {
    path: "/loading",
    name: "Loading",
    component: Loading,
  },
];

const router = new VueRouter({
  mode: "history",
  routes,
});

export default router;
