import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
import WebRTC from "vue-webrtc";

Vue.config.productionTip = false;
Vue.use(WebRTC);

new Vue({
  router,
  store,
  vuetify,
  render: (h) => h(App),
}).$mount("#app");

window.Kakao.init("5ac1f42d6765ca41349331f8ae7d1e35");
