<template>
  <div style="padding-top: 50px">
    <v-row class="text-h6" algi>
      <v-col>
        <!-- 이전 인원 선택 페이지에서 선택한 옵션 데이터 받아서
            아래 문구에 바인딩해야 함. (2인/5인)  -->
        <div>
          2인 방 선택! <b>마이크 옵션</b>을 선택해주세요!
          <v-btn plain x-small :to="{ name: 'NumberOfPeople' }">
            뒤로가기
          </v-btn>
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
          >
            마이크 Off
          </v-btn>
        </router-link>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "SilenceOrTalk",
};
</script>

<style lang=""></style>
