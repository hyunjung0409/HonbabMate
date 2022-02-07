import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: {},

    useroption: {
      number: "",
      sound: "",
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
  },
  actions: {},
  modules: {
    // memberStore,
  },
});
