import Vue from "vue";
import Vuex from "vuex";
// import createPersistedState from "vuex-persistedstate";

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
      cntOfLikes: null,
      image: null,
      nickname: null,
      //정언
      //---------------
      //현정
      // option: null,
      sessionId: null,
    },

    memberimage: {
      url: "",
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

    memberId(state, data) {
      state.member.id = data;
    },
    memberNickname(state, data) {
      state.member.nickname = data;
    },

    memberSession(state, data) {
      state.member.sessionId = data;
    },

    member(state, data) {
      state.member = data;
    },

    memberimage(state, file) {
      state.memberimage.url = file;
    },
  },
  actions: {},
  modules: {
    // memberStore,
  },
  // plugins: [
  //   createPersistedState(),
  //   // {
  //   //주목! : 여기에 쓴 모듈만 저장됩니다.
  //   // paths: ["cart", "auth"],
  //   // }
  // ],
});
