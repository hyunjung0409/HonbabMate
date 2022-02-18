<template>
  <div style="padding-top: 50px">
    <v-row class="text-h6" algi>
      <v-col>
        <div>
          {{ this.$store.state.useroption.number }}인 방 선택!
          <b>마이크 옵션</b>을 선택해주세요!
          <v-btn plain x-small :to="{ name: 'People' }"> 뒤로가기 </v-btn>
        </div>
      </v-col>
    </v-row>

    <v-row class="mt-n3">
      <v-col>
        <router-link :to="{ name: 'Loading' }">
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
        </router-link>
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
    member() {
      return this.$store.state.member;
    },
  },

  methods: {
    silence() {
      this.$store.commit("soundoption", false);
      // console.log("useroption : ", this.useroption);
      // console.log("num : " + this.useroption.number);

      if (this.useroption.number === 2) {
        this.$store.commit("finaloption", "nontalkable2");
        // console.log("2선택 finaloption : ", this.useroption.final);
      } else if (this.useroption.number === 5) {
        this.$store.commit("finaloption", "nontalkable5");
        // console.log("5 선택 finaloption : ", this.useroption.final);
      }
      this.updateOption();
    },

    smalltalk() {
      this.$store.commit("soundoption", true);
      // console.log("useroption : ", this.useroption);
      // console.log("num : " + this.useroption.number);

      if (this.useroption.number === 2) {
        this.$store.commit("finaloption", "talkable2");
        // console.log("2선택 finaloption : ", this.useroption.final);
      } else if (this.useroption.number === 5) {
        this.$store.commit("finaloption", "talkable5");
        // console.log("5 선택 finaloption : ", this.useroption.final);
      }

      this.updateOption();
    },

    async updateOption() {
      await rest
        .axios({
          method: "put",
          url: "/members/match",
          data: {
            id: this.member.id,
            option: this.useroption.final,
          },
        })
        .then((res) => {
          // console.log(res);
          this.$store.commit("memberSession", res.data.id);
          // console.log("memberSession", this.$store.state.member.sessionId);
          // console.log("member + ", this.$store.state.member);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style lang=""></style>
