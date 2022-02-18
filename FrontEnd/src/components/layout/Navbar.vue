<template>
  <v-app-bar app color="grey lighten-3" flat height="80">
    <v-row class="ma-0 pa-0">
      <v-col cols="2" class="pa-0">
        <router-link :to="{ path: '/' }" class="pa-5">
          <v-icon size="40px" color="amber darken-1">
            mdi-alpha-h-circle
          </v-icon>
        </router-link>
      </v-col>

      <v-col cols="8" class="pa-0" align="center">
        <v-tabs
          centered
          class="ml-n9"
          background-color="grey lighten-3"
          color="amber darken-1"
        >
          <v-tab v-for="link in links" :key="link.name" :to="link.route">
            <h3>
              {{ link.title }}
            </h3>
          </v-tab>
        </v-tabs>
      </v-col>

      <v-col cols="2" class="pa-0" align="end">
        <v-btn
          v-if="this.user.email == undefined"
          text
          color="grey"
          @click="kakaologin"
        >
          <b>Login</b>
        </v-btn>

        <v-btn
          v-if="this.user.email != undefined"
          text
          color="grey"
          @click="profile"
        >
          <b>Profile</b>
        </v-btn>

        <v-btn
          v-if="this.user.email != undefined"
          text
          color="grey"
          @click="kakaologout"
        >
          <b>Logout</b>
        </v-btn>
      </v-col>

      <!-- <v-avatar
      class="hidden-sm-and-down"
      color="grey darken-1 shrink"
      size="36"
    /> -->
    </v-row>
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
    changeurl: "",
  }),
  computed: {
    user() {
      return this.$store.state.user;
    },

    member() {
      return this.$store.state.member;
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
      // console.log("프로필 받기", authObj);
      localStorage.setItem("access_token", authObj.access_token);
      window.Kakao.API.request({
        url: "/v2/user/me",
        success: (res) => {
          const kakao_account = res.kakao_account;
          console.log(kakao_account);
          this.login(kakao_account);
          // alert("로그인성공");

          this.$store.commit("user", kakao_account);
        },
      });
    },

    async login(kakao_account) {
      const temp = kakao_account.profile.profile_image_url;
      const temp2 = temp.replace(/http/g, "https");
      await rest
        .axios({
          method: "post",
          url: "/members/login",
          data: {
            email: kakao_account.email,
            nickname: kakao_account.profile.nickname,
            gender: kakao_account.gender,
            imageURL: temp2,
          },
        })
        .then((res) => {
          sessionStorage.setItem("nickname", kakao_account.profile.nickname);
          sessionStorage.setItem("memberID", res.data);
          // console.log(res.data);
          // console.log("sessionStorage", sessionStorage.getItem("memberID"));
          // console.log("change url", temp2);

          // 회원정보 가져와서 store에 넣기
          this.id = res.data;
          // this.$store.commit("member", res.data);
          // this.$store.commit("user", kakao_account);
          sessionStorage.setItem("userId", this.id);
          this.$store.commit("memberId", this.id);
          // console.log("memberId", this.$store.state.member.id);

          // memberID 저장
          const temp = sessionStorage.getItem("memberID");
          this.storeuser(temp);

          // member image 저장
          // console.log("kakao image", temp2);
          this.$store.commit("memberimage", temp2);
          // console.log("store", this.$store.state.memberimage);
          // this.storeuserimg(temp);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    async storeuser(temp) {
      await rest
        .axios({
          method: "get",
          url: "/profile/" + temp,
        })
        .then((res) => {
          // console.log(res);
          this.$store.commit("member", res.data);
          // console.log("member : ", this.$store.state.member);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    // async storeuserimg(temp) {
    //   await rest
    //     .axios({
    //       method: "get",
    //       url: "/profile/image/" + temp,
    //     })
    //     .then((res) => {
    //       console.log(res);
    //       this.$store.commit("memberimage", res.data);
    //     })
    //     .catch((err) => {
    //       console.log(err);
    //     });
    // },

    kakaologout() {
      // window.Kakao.API.request({
      //   url: "/v1/user/unlink",
      //   success: function (response) {
      //     console.log(response);
      //     alert("로그아웃");
      //     this.logout(this.id);
      //     // this.$store.commit("user", {});
      //     this.$router.push({ path: "/" });
      //   },
      //   fail: function (error) {
      //     console.log(error);
      //   },
      // });

      // 자체 로그아웃
      window.Kakao.Auth.logout((response) => {
        console.log(response);
        // this.$store.commit("user", "");
        // alert("로그아웃");
        this.logout();
        // this.userlogin = false;
        this.$router.push({ path: "/" });
      });
    },

    async logout() {
      await rest
        .axios({
          method: "get",
          url: "/members/logout/" + this.member.id,
          // params: {
          //   id: id,
          // },
        })
        .then((res) => {
          // sessionStorage.clear();
          console.log(res);
          // 회원정보 가져와서 store에 넣기
          this.$store.commit("user", "");
          localStorage.clear();
          location.reload();
          // this.$router.push({ path: "/" });
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
