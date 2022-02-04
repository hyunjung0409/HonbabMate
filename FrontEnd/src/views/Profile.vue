<template>
  <v-container class="ma-4 pa-4" align="center">
    <div class="top">
      <v-row justify="space-between">
        <v-col cols="4">
          <v-avatar size="150">
            <img
              src="https://cdn.vuetifyjs.com/images/john.jpg"
              alt="profile-picture"
            />
          </v-avatar>
        </v-col>
        <v-col cols="4">
          <v-row>
            <p>혼밥메이트206</p>
          </v-row>
          <v-row>
            <p>좋아요 받은 수 :</p>
          </v-row>
        </v-col>
        <v-col cols="4">
          <v-spcaer />
          <v-btn rounded color="primary" dark> 수정하기 </v-btn>
        </v-col>
      </v-row>
    </div>
  </v-container>
</template>

<script>
export default {
  name: "Profile",
};
</script>

<style lang=""></style>
