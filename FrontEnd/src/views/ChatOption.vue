<template>
  <v-main>
    <v-container>
      <v-row class="text-h3">
        <v-col>
          <div class="mt-10">
            <!-- 전체 접속자 데이터 받아서 아래 문구에 바인딩해야 함.  -->
            <b> 현재 XX명 식사 중👩‍🍳👨‍🍳</b>
          </div>
        </v-col>
      </v-row>
      <v-row class="text-h6">
        <v-col>
          <div>같이 밥 먹을 친구가 필요하다면?</div>
          <div>이제 온라인으로 새로운 사람과 식사하며 소통해요!</div>
        </v-col>
      </v-row>
      <router-view />
    </v-container>
  </v-main>
</template>

<script>
import "@/assets/SCSS/common.scss";

export default {
  name: "Option",

  computed: {
    user() {
      return this.$store.state.user;
    },
  },

  mounted() {
    if (this.user.email == undefined) {
      alert("로그인 후 사용해주세요!");
      this.$router.push({ path: "/" });
    }
  },
};
</script>
