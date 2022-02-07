<template>
  <v-container fluid>
    <v-row>
      <v-col>
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
        <router-link :to="{ name: 'SilenceOrTalk' }">
          <v-btn
            class="mr-3"
            depressed
            color="orange accent-1"
            height="100"
            width="200"
            @click="num2"
          >
            2인
          </v-btn>
          <v-btn
            class="ml-3"
            depressed
            color="orange accent-1"
            height="100"
            width="200"
            @click="num5"
          >
            5인
          </v-btn>
        </router-link>
      </v-col>
    </v-row>
  </v-container>
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

<style lang=""></style>
