<template>
  <v-main>
    <v-container>
      <div>로그인 페이지</div>

      <v-btn
        v-if="this.userlogin === false"
        color="primary"
        @click="kakaologin"
      >
        Login
      </v-btn>
    </v-container>
  </v-main>
</template>
<script>
import axios from "axios";

export default {
  name: "Login",

  data: () => ({
    userlogin: false,
  }),

  methods: {
    kakaologin() {
      console.log("click login btn");
      window.Kakao.Auth.login({
        scope: "account_email, gender, profile_image",
        success: this.getProfile,
      });
    },

    getProfile(authObj) {
      console.log("프로필 받기");
      console.log(authObj);
      window.Kakao.API.request({
        url: "/v2/user/me",
        success: (res) => {
          const kakao_account = res.kakao_account;
          console.log(kakao_account);
          alert("로그인성공");
          this.userlogin = true;
        },
      });
    },

    async login(kakao_account) {
      await axios.post("members/login", {
        email: kakao_account.email,
        nickname: kakao_account.profile.nickname,
        gender: kakao_account.profile.gender,
      });
    },

    kakaologout() {
      window.Kakao.API.request({
        url: "/v1/user/unlink",
        success: function (response) {
          console.log(response);
          alert("로그아웃");
          this.userlogin = false;
          location.reload();
        },
        fail: function (error) {
          console.log(error);
        },
      });

      // 자체 로그아웃
      // window.Kakao.Auth.logout((response) => {
      //   console.log(response);
      //   alert("로그아웃");
      //   this.userlogin = false;
      // });
    },
  },
};
</script>
