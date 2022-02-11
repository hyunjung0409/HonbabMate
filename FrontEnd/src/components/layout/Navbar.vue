<template>
  <v-app-bar app color="grey lighten-3" flat height="80">
    <router-link :to="{ path: '/' }" class="pa-5">
      <v-icon size="40px" color="amber darken-1"> mdi-alpha-h-circle </v-icon>
    </router-link>

    <!-- <v-avatar
      :color="$vuetify.breakpoint.smAndDown ? 'grey darken-1' : 'transparent'"
      size="32"
    /> -->

    <v-tabs centered class="ml-n9" color="amber darken-1">
      <v-tab v-for="link in links" :key="link.name" :to="link.route">
        <h3>
          {{ link.title }}
        </h3>
      </v-tab>
    </v-tabs>

    <v-btn
      v-if="this.user.email == undefined"
      color="primary"
      @click="kakaologin"
    >
      Login
    </v-btn>

    <v-btn v-if="this.user.email != undefined" color="primary" @click="profile">
      Profile
    </v-btn>

    <v-btn
      v-if="this.user.email != undefined"
      color="primary"
      @click="kakaologout"
    >
      Logout
    </v-btn>

    <!-- <v-avatar
      class="hidden-sm-and-down"
      color="grey darken-1 shrink"
      size="36"
    /> -->
  </v-app-bar>
</template>

<script>
import rest from "../../api/index.js";

export default {
  name: "AppBar",

  data: () => ({
    links: [
      { title: "혼밥메이트", name: "Home", route: `/` },
      { title: "사이트 사용법", name: "Manual", route: `/manual` },
      { title: "자주하는 질문", name: "FAQ", route: `/FAQ` },
    ],
    userlogin: false,
    id: "",
  }),
  computed: {
    user() {
      return this.$store.state.user;
    },
  },

  methods: {
    kakaologin() {
      window.Kakao.Auth.login({
        scope: "account_email, gender, profile_nickname, profile_image",
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
          this.login(kakao_account);
          alert("로그인성공");
          this.userlogin = true;
          this.$store.commit("user", kakao_account);
        },
      });
    },

    async login(kakao_account) {
      await rest
        .axios({
          method: "post",
          url: "/members/login",
          data: {
            email: kakao_account.email,
            nickname: kakao_account.profile.nickname,
            gender: kakao_account.gender,
          },
        })
        .then((res) => {
          sessionStorage.setItem("nickname", kakao_account.profile.nickname);
          sessionStorage.setItem("memberID", res.data);
          console.log(res.data);
          console.log("sessionStorage", sessionStorage.getItem("memberID"));
          // 회원정보 가져와서 store에 넣기
          this.id = res.data;
          // this.$store.commit("member", res.data);
          // this.$store.commit("user", kakao_account);
          sessionStorage.setItem("userId", this.id);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    kakaologout() {
      // window.Kakao.API.request({
      //   url: "/v1/user/unlink",
      //   success: function (response) {
      //     console.log(response);
      //     alert("로그아웃");

      //     // this.$store.commit("user", {});

      //     this.userlogin = false;
      //     location.reload();
      //   },
      //   fail: function (error) {
      //     console.log(error);
      //   },
      // });
      // 자체 로그아웃
      window.Kakao.Auth.logout((response) => {
        console.log(response);
        alert("로그아웃");
        this.logout(this.id);
        // this.userlogin = false;
      });
    },

    async logout(id) {
      await rest
        .axios({
          method: "get",
          url: "/members/logout/" + id,
          // params: {
          //   id: id,
          // },
        })
        .then((res) => {
          // localStorage.removeItem("nickname");
          // localStorage.removeItem("memberID");
          localStorage.clear();
          console.log(res);
          // 회원정보 가져와서 store에 넣기
          this.id = "";
          this.$store.commit("user", "");
          this.userlogin = false;
          location.reload();
          this.$router.push({ path: "/" });
        })
        .catch((err) => {
          console.log(err);
        });
    },

    profile() {
      this.$router.push("/profile");
    },

    // async profile() {
    //   await rest
    //     .axios({
    //       method: "get",
    //       url: "/profile/}",
    //       params: {
    //         id: this.id,
    //       },
    //     })
    //     .then((res) => {
    //       //store에 member 값 저장

    //       this.$router.push("/profile");
    //       console.log(res);
    //     })
    //     .catch((err) => {
    //       console.log(err);
    //     });
    // },
  },
};
</script>
