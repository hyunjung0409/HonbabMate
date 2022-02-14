<template>
  <v-main>
    <v-container>
      <!-- <v-row>
          <v-card>
            <v-card-title>
              $vuetify.breakpoint.name: {{ $vuetify.breakpoint.name }}
            </v-card-title>
          </v-card>
        </v-row> -->

      <v-row class="text-h6">
        <v-col>
          <h1>혼밥메이트</h1>
        </v-col>
      </v-row>

      <v-row class="content">
        <v-col>
          <div>
            혼밥 하고는 싶지만 실제로 만나서 식사하시는 건 부담스러우신가요?
          </div>
          <div>혼자 밥 먹기도 지친 외로운 혼밥러들을 위한 랜덤 매칭 서비스</div>
          <div>
            '혼밥메이트'를 사용해 온라인으로 함께 식사하며 랜선 친목을
            다져보아요!
          </div>
        </v-col>
      </v-row>

      <v-row class="start">
        <v-col>
          <v-btn
            depressed
            color="error"
            height="80"
            width="200"
            @click="changePage"
          >
            시작하기
          </v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>

<script>
export default {
  name: "Mainhome",
  components: {},
  methods: {
    changePage() {
      if (this.user.email === undefined) {
        alert("로그인 후 사용해주세요");
      } else {
        console.log("email :", this.user.email);
        this.$router.push("/chat-option");
      }
    },
  },

  computed: {
    user() {
      return this.$store.state.user;
    },
  },
};
</script>
