import Vue from 'vue';
import VueRouter from 'vue-router';

// import Home from '../views/Home.vue';
import Manual from '../views/Manual.vue';
import FAQ from '../views/FAQ.vue';
import About from '../views/About.vue';
import Loading from '../views/Loading.vue';

// import Chatroom from '../views/Chatroom.vue';
import Chatroom from '@/views/Chatroom.vue';
import TwoPeople from '@/components/chat_room/TwoPeople.vue';
import FivePeople from '@/components/chat_room/FivePeople.vue';

import ChatOption from '@/views/ChatOption.vue';
import SilenceOrTalk from '@/components/chat_option/SilenceOrTalk.vue';
import NumberOfPeople from '@/components/chat_option/NumberOfPeople.vue';

Vue.use(VueRouter);

const routes = [
  // {
  //   path: '/',
  //   name: 'Home',
  //   component: Home,
  // },
  {
    path: '/about',
    name: 'About',
    component: About,
  },
  {
    path: '/manual',
    name: 'Manual',
    component: Manual,
  },
  {
    path: '/FAQ',
    name: 'FAQ',
    component: FAQ,
  },
  {
    path: '/loading',
    name: 'Loading',
    component: Loading,
  },

  {
    path: '/chatroom',
    name: 'Chatroom',
    component: Chatroom,
    children: [
      {
        path: 'two',
        name: 'TwoPeople',
        component: TwoPeople,
      },
      {
        path: 'five',
        name: 'FivePeople',
        component: FivePeople,
      },
    ],
  },
  {
    // path: '/chat-option',
    path: '/',
    name: 'ChatOption',
    component: ChatOption,
    redirect: '/people',
    children: [
      {
        path: 'people',
        name: 'NumberOfPeople',
        component: NumberOfPeople,
      },
      {
        path: 'talk',
        name: 'SilenceOrTalk',
        component: SilenceOrTalk,
      },
    ],
  },
];

const router = new VueRouter({
  mode: 'history',
  routes,
});

export default router;
