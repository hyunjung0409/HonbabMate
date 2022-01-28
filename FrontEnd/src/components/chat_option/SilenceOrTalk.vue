<template>
  <v-container fluid>
    <v-row>
      <v-col align="center">
        <!-- 이전 인원 선택 페이지에서 선택한 옵션 데이터 받아서
            아래 문구에 바인딩해야 함. (2인/5인)  -->
        <span class="mr-3 pa-3">
          2인 방 선택! 아래 옵션을 선택해주세요!　
        </span>
        <router-link :to="{ name: 'NumberOfPeople' }">
          <v-btn class="ml-3" plain> 뒤로가기 </v-btn>
        </router-link>
      </v-col>
    </v-row>
    <v-row>
      <v-col align="center">
        <router-link :to="{ name: 'Loading' }">
          <v-btn
            class="mr-3"
            depressed
            color="orange accent-1"
            height="100"
            width="200"
          >
            조용히 먹고 싶어요
          </v-btn>

          <v-btn
            class="ml-3"
            depressed
            color="orange accent-1"
            height="100"
            width="200"
          >
            스몰토크 나누고 싶어요
          </v-btn>
        </router-link>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "SilenceOrTalk",
};
</script>

<style lang=""></style>
