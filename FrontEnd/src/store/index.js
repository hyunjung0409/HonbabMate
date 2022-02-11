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
      final: "",
    },

    //memberID 기반 정보
    member: {
      id: null,
    },
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

    finaloption(state, data) {
      state.useroption.final = data;
    },

    member(state, data) {
      state.member.id = data;
    },
  },
  actions: {},
  modules: {
    // memberStore,
  },
});
