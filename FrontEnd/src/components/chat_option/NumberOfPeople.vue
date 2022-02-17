<template>
  <div style="padding-top: 50px">
    <v-row>
      <v-col class="text-h6">
        <div>아래 <b>채팅 인원 옵션</b>을 선택해주세요!</div>
      </v-col>
    </v-row>

    <v-row class="mt-n3">
      <v-col>
        <router-link :to="{ name: 'Talk' }">
          <v-btn
            class="text-h6 mr-3"
            depressed
            rounded
            color="amber darken-1"
            dark
            x-large
            width="160px"
            @click="num2"
          >
            2인
          </v-btn>
          <v-btn
            class="text-h6 ml-3"
            depressed
            rounded
            color="amber darken-1"
            dark
            x-large
            width="160px"
            @click="num5"
          >
            5인
          </v-btn>
        </router-link>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "People",

  computed: {
    useroption() {
      return this.$store.state.useroption;
    },
  },

  methods: {
    num2() {
      this.$store.commit("numberopiton", 2);
      // console.log("useroption : ", this.useroption);
    },

    num5() {
      this.$store.commit("numberopiton", 5);
      // console.log("useroption : ", this.useroption);
    },
  },
};
</script>

<style>
/* .area {
  padding-top: 100px;
} */
</style>
