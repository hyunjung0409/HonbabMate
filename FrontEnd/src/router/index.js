import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../views/Home.vue";
// import Mainhome from "../views/Mainhome.vue";
import Manual from "../views/Manual.vue";
import FAQ from "../views/FAQ.vue";

import ChatOption from "@/views/ChatOption.vue";
import SilenceOrTalk from "@/components/chat_option/SilenceOrTalk.vue";
import NumberOfPeople from "@/components/chat_option/NumberOfPeople.vue";

import Loading from "../views/Loading.vue";

import Chatroom from "../views/Chatroom.vue";
import Talkable2 from "../views/Chatroom/Talkable2.vue";
import Talkable5 from "../views/Chatroom/Talkable5.vue";
import Nontalkable2 from "../views/Chatroom/Nontalkable2.vue";
import Nontalkable5 from "../views/Chatroom/Nontalkable5.vue";

import Login from "../views/Login.vue";
import Profile from "@/views/Profile.vue";
import UpdateProfile from "@/views/UpdateProfile.vue";

Vue.use(VueRouter);

const routes = [
  {
    // path: '/chat-option',
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
    path: "/talkable2",
    name: "talkable2",
    component: Talkable2,
  },
  {
    path: "/talkable5",
    name: "talkable5",
    component: Talkable5,
  },
  {
    path: "/nontalkable2",
    name: "nontalkable2",
    component: Nontalkable2,
  },
  {
    path: "/nontalkable5",
    name: "nontalkable5",
    component: Nontalkable5,
  },

  {
    path: "/chat-option",
    name: "ChatOption",
    component: ChatOption,
    redirect: "/chat-option/people",

    children: [
      {
        path: "people",
        name: "People",
        component: NumberOfPeople,
      },
      {
        path: "talk",
        name: "Talk",
        component: SilenceOrTalk,
      },
    ],
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/profile",
    name: "Profile",
    component: Profile,
  },
  {
    path: "/update",
    name: "UpdateProfile",
    component: UpdateProfile,
  },
];

const router = new VueRouter({
  mode: "history",
  routes,
});

export default router;
