<template>
  <div style="padding-top: 50px">
    <v-row class="text-h6" algi>
      <v-col>
        <!-- 이전 인원 선택 페이지에서 선택한 옵션 데이터 받아서
            아래 문구에 바인딩해야 함. (2인/5인)  -->
        <div>
          2인 방 선택! <b>마이크 옵션</b>을 선택해주세요!
          <v-btn plain x-small :to="{ name: 'People' }"> 뒤로가기 </v-btn>
        </div>
      </v-col>
    </v-row>

    <v-row class="mt-n3">
      <v-col>
        <!-- <router-link :to="{ name: 'Loading' }"> -->
        <v-btn
          class="text-h6 mr-3"
          depressed
          rounded
          color="amber darken-1"
          dark
          x-large
          width="160px"
          @click="smalltalk"
        >
          마이크 On
        </v-btn>

        <v-btn
          class="text-h6 ml-3"
          depressed
          rounded
          color="amber darken-1"
          dark
          x-large
          width="160px"
          @click="silence"
        >
          마이크 Off
        </v-btn>
        <!-- </router-link> -->
      </v-col>
    </v-row>
  </div>
</template>

<script>
import rest from "../../api/index.js";

export default {
  name: "Talk",

  computed: {
    user() {
      return this.$store.state.user;
    },
    useroption() {
      return this.$store.state.useroption;
    },
  },

  methods: {
    silence() {
      this.$store.commit("soundoption", false);
      console.log("useroption : ", this.useroption);

      console.log("num : " + this.useroption.number);

      if (this.useroption.number === 2) {
        this.$store.commit("finaloption", "nontalkable2");
        console.log("2선택 finaloption : ", this.useroption.final);
      } else if (this.useroption.number === 5) {
        this.$store.commit("finaloption", "nontalkable5");
        console.log("5 선택 finaloption : ", this.useroption.final);
      }

      console.log("user id : ", this.id);
    },

    smalltalk() {
      this.$store.commit("soundoption", true);
      console.log("useroption : ", this.useroption);

      console.log("num : " + this.useroption.number);

      if (this.useroption.number === 2) {
        this.$store.commit("finaloption", "talkable2");
        console.log("2선택 finaloption : ", this.useroption.final);
      } else if (this.useroption.number === 5) {
        this.$store.commit("finaloption", "talkable5");
        console.log("5 선택 finaloption : ", this.useroption.final);
      }

      console.log("user id : ", this.id);
      this.updateOption();
    },

    async updateOption() {
      await rest
        .axios({
          method: "put",
          url: "/members/match",
          data: {
            id: this.user,
            option: this.useroption.final,
          },
        })
        .then(() => {
          console.log("수정완료");
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style lang=""></style>
