<template>
  <div style="padding-top: 50px">
    <v-row>
      <v-col class="text-h6">
        <div>아래 <b>채팅 인원 옵션</b>을 선택해주세요!</div>
      </v-col>
    </v-row>

    <v-row class="mt-n3">
      <v-col>
<<<<<<< HEAD
        <div class="pl-3">같이 밥 먹을 친구가 필요하다면?</div>
        <div class="pl-3">이제 온라인으로 새로운 사람과 식사하며 소통해요!</div>
      </v-col>
    </v-row>
    <v-row>
      <v-col align="center">
        <span class="mr-3 pa-3"> 아래 채팅 인원 옵션을 선택해주세요!　 </span>
      </v-col>
    </v-row>
    <v-row>
      <v-col align="center">
=======
>>>>>>> feature_profile
        <router-link :to="{ name: 'SilenceOrTalk' }">
          <v-btn
            class="text-h6 mr-3"
            depressed
<<<<<<< HEAD
            color="orange accent-1"
            height="100"
            width="200"
            @click="num2"
=======
            rounded
            color="amber darken-1"
            dark
            x-large
            width="160px"
>>>>>>> feature_profile
          >
            2인
          </v-btn>
          <v-btn
            class="text-h6 ml-3"
            depressed
<<<<<<< HEAD
            color="orange accent-1"
            height="100"
            width="200"
            @click="num5"
=======
            rounded
            color="amber darken-1"
            dark
            x-large
            width="160px"
>>>>>>> feature_profile
          >
            5인
          </v-btn>
        </router-link>
      </v-col>
    </v-row>
<<<<<<< HEAD
  </v-container>
=======
  </div>
>>>>>>> feature_profile
</template>

<script>
export default {
  name: "NumberOfPeople",

  computed: {
    useroption() {
      return this.$store.state.useroption;
    },
  },

  methods: {
    num2() {
      const num = 2;
      this.$store.commit("numberopiton", 2);
      console.log("useroption : ", this.useroption);
    },

    num5() {
      const num = 5;
      this.$store.commit("numberopiton", 5);
      console.log("useroption : ", this.useroption);
    },
  },
};
</script>

<style>
/* .area {
  padding-top: 100px;
} */
</style>
