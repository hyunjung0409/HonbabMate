<template>
  <v-container fluid>
    <v-row>
      <v-col>
        <div class="pl-3">같이 밥 먹을 친구가 필요하다면?</div>
        <div class="pl-3">이제 온라인으로 새로운 사람과 식사하며 소통해요!</div>
      </v-col>
    </v-row>
    <div style="padding-top: 100px">
      <v-row>
        <v-col align="center">
          <span class="mr-3 pa-3"> 아래 채팅 인원 옵션을 선택해주세요!　 </span>
        </v-col>
      </v-row>
      <v-row class="">
        <v-col align="center">
          <router-link :to="{ name: 'SilenceOrTalk' }">
            <v-btn
              class="mr-3"
              depressed
              color="orange accent-1"
              height="100"
              width="200"
            >
              2인
            </v-btn>
            <v-btn
              class="ml-3"
              depressed
              color="orange accent-1"
              height="100"
              width="200"
            >
              5인
            </v-btn>
          </router-link>
        </v-col>
      </v-row>
    </div>
  </v-container>
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
