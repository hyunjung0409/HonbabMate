<template>
  <div style="padding-top: 50px">
    <v-row>
      <v-col class="text-h6">
        <div>아래 <b>채팅 인원 옵션</b>을 선택해주세요!</div>
      </v-col>
    </v-row>

    <v-row class="mt-n3">
      <v-col>
        <router-link :to="{ name: 'SilenceOrTalk' }">
          <v-btn
            class="text-h6 mr-3"
            depressed
            rounded
            color="amber darken-1"
            dark
            x-large
            width="160px"
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
  name: "NumberOfPeople",
};
</script>

<style>
/* .area {
  padding-top: 100px;
} */
</style>
