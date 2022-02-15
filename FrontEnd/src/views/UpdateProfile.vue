<template>
  <v-main>
    <v-container>
      <v-row>
        <v-col cols="2">
          <v-avatar size="120">
            <img :src="memberimage.url" alt="profile-picture" />
          </v-avatar>

          <v-file-input
            :rules="rules"
            hide-input
            accept="image/png, image/jpeg, image/bmp"
            placeholder="Pick an avatar"
            prepend-icon="mdi-camera"
            label="Avatar"
          ></v-file-input>
        </v-col>

        <!-- <v-menu> </v-menu> -->

        <v-col class="mt-9" cols="3">
          <div>
            <v-text-field
              label="닉네임"
              v-model="nickname"
              hint="닉네임 입력은 필수입니다"
              counter="10"
              id="nickname"
              required
            >
            </v-text-field>
          </div>
          <div>
            <p>좋아요 받은 수 : {{ member.cntOfLikes }}</p>
          </div>
        </v-col>

        <v-col cols="6" />
      </v-row>

      <v-divider class="mt-12 mb-5" />

      <v-list style="background-color: #eeeeee">
        <v-list-item>
          <v-list-item-title max-width="200px"> 최애음식 </v-list-item-title>
          <v-btn text>
            <v-icon> mdi-plus </v-icon>
          </v-btn>
        </v-list-item>
        <div class="px-4">
          <v-chip v-for="food in member.foods" :key="food" class="mr-2 mb-2">
            {{ food }}
          </v-chip>
        </div>

        <v-list-item>
          <v-list-item-title>또 뭐있지?</v-list-item-title>
        </v-list-item>
        <div class="px-4">
          <v-chip v-for="tag in member.etc" :key="tag" class="mr-2 mb-2">
            {{ tag }}
          </v-chip>
        </div>
      </v-list>

      <v-row>
        <v-col class="mt-9" cols="1">
          <v-btn rounded color="primary" dark @click="modify"> 수정하기 </v-btn>
        </v-col>

        <v-col class="mt-9" cols="1">
          <v-btn rounded color="secondary" light @click="cancel"> 취소 </v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>

<script>
// import rest from "../../api/index.js";

export default {
  name: "UpdateProfile",
  data: () => ({
    fav: true,
    menu: false,
    blockDialog: false,
    reportDialog: false,

    rules: [
      (value) =>
        !value ||
        value.size < 2000000 ||
        "Avatar size should be less than 2 MB!",
    ],

    nickname: "",
    file: "",
    foods: [],
    etc: [],
  }),

  computed: {
    member() {
      return this.$store.state.member;
    },

    memberimage() {
      return this.$store.state.memberimage;
    },
  },

  created() {
    if (this.member.id == null) {
      this.$router.push({ path: "/" });
    }
    console.log("created : ", this.member);
  },

  methods: {
    // async modify() {
    //   await rest
    //   .axios({
    //     method:"put",
    //     url:"/profile",
    //   })
    //   .then((res) =>{
    //     console.log(res)
    //   })
    //   .catch((err) => {
    //     console.log(err)
    //   })
    // },

    modify() {
      console.log("닉네임 변경 check", this.nickname);
    },

    cancel() {
      this.$router.push("/profile");
    },
  },
};
</script>

<style></style>
