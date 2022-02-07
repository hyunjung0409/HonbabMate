import Vue from "vue";
import VueRouter from "vue-router";

<<<<<<< HEAD
// import Home from '../views/Home.vue';
import Mainhome from "../views/Mainhome.vue";
=======
import Home from "../views/Home.vue";
// import Mainhome from "../views/Mainhome.vue";
>>>>>>> feature_profile
import Manual from "../views/Manual.vue";
import FAQ from "../views/FAQ.vue";

import ChatOption from "@/views/ChatOption.vue";
import SilenceOrTalk from "@/components/chat_option/SilenceOrTalk.vue";
import NumberOfPeople from "@/components/chat_option/NumberOfPeople.vue";

import Loading from "../views/Loading.vue";

import Chatroom from "../views/Chatroom.vue";

import Login from "../views/Login.vue";
import Profile from "@/views/Profile.vue";

Vue.use(VueRouter);

const routes = [
<<<<<<< HEAD
  // {
  //   path: '/',
  //   name: 'Home',
  //   component: Home,
  // },
=======
>>>>>>> feature_profile
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
  {
    // path: '/chat-option',
    path: "/",
    name: "Home",
    component: Home,
  },
  // {
  //   path: "/",
  //   name: "Home",
  //   component: Mainhome,
  // },

<<<<<<< HEAD
  {
    path: "/about",
    name: "About",
    component: About,
  },
=======
>>>>>>> feature_profile
  {
    path: "/manual",
    name: "Manual",
    component: Manual,
  },
  {
    path: "/faq",
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
  {
    path: "/chat-option",
    // path: "/chatoption",
    name: "ChatOption",
    component: ChatOption,
    redirect: "/chat-option/people",

    children: [
      {
        path: "people",
        name: "NumberOfPeople",
        component: NumberOfPeople,
      },
      {
        path: "talk",
        name: "SilenceOrTalk",
        component: SilenceOrTalk,
      },
    ],
<<<<<<< HEAD
=======
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
>>>>>>> feature_profile
  },
  {
    path: "/profile",
    name: "Profile",
    component: Profile,
  },
];

const router = new VueRouter({
  mode: "history",
  routes,
});

export default router;
