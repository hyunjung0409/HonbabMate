import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    //kakao 정보
    user: {},

    useroption: {
      number: "",
      sound: "",
    },

    //memberID 기반 정보
    member: {},
  },

  mutations: {
    user(state, data) {
      state.user = data;
    },

    numberopiton(state, data) {
      state.useroption.number = data;
    },

    soundoption(state, data) {
      state.useroption.sound = data;
    },

    member(state, data) {
      state.member = data;
    },
  },
  actions: {},
  modules: {
    // memberStore,
  },
});
