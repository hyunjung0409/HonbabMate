<template>
  <v-container>
    <v-row>
      <v-col cols="7">
        <v-row class="text-h3">
          <v-col cols="12">
            <div class="mt-10">
              <b>혼밥메이트</b>
            </div>
          </v-col>
        </v-row>

        <v-row class="text-h6">
          <v-col cols="12">
            <div>
              혼자 밥 먹기도 지친 외로운 혼밥러들을 위한 <b>랜덤 매칭 서비스</b>
            </div>
            <div>
              <b>혼밥메이트</b>를 사용해 온라인으로 함께 식사하며 랜선 친목을
              다져보아요!
            </div>
          </v-col>
        </v-row>

        <v-row class="mt-5">
          <v-col cols="12">
            <v-btn
              class="text-h6"
              depressed
              rounded
              color="amber darken-1"
              dark
              x-large
              width="200px"
              @click="changePage"
            >
              <b>시작하기</b>
            </v-btn>
          </v-col>
        </v-row>
      </v-col>
      <v-col cols="5">
        <v-img
          src="@/assets/honbab-mockup.png"
          width="700px"
          alt="honbab-mockup"
          style="top: 200px"
        />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "About",
  components: {},

  computed: {
    user() {
      return this.$store.state.user;
    },
  },
  methods: {
    changePage() {
      this.$router.push("/chat-option");
    },
  },
};
</script>
