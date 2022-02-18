<template>
  <v-main>
    <v-container>
      <v-row>
        <v-col cols="2">
          <v-avatar size="120">
            <img :src="memberimage.url" alt="profile-picture" />
          </v-avatar>
        </v-col>

        <v-col class="mt-9" cols="4">
          <div>
            <p>닉네임 : {{ member.nickName }}</p>
          </div>
          <div>
            <p>좋아요 받은 수 : {{ member.cntOfLikes }}</p>
          </div>
        </v-col>

        <v-col class="mt-11" cols="2">
          <v-btn
            rounded
            color="primary"
            dark
            class="ml-8"
            @click="updateprofile"
          >
            수정하기
          </v-btn>
        </v-col>
        <v-col cols="4" />
      </v-row>

      <v-divider class="mt-12 mb-5" />

      <v-list style="background-color: #eeeeee">
        <v-list-item>
          <v-list-item-title max-width="200px"> 최애음식 </v-list-item-title>
        </v-list-item>

        <div class="px-4">
          <v-chip v-for="food in member.foods" :key="food" class="mr-2 mb-2">
            {{ food }}
          </v-chip>
        </div>

        <v-divider class="mt-12 mb-5" />

        <v-list-item>
          <v-list-item-title max-width="200px"> 또 뭐있지? </v-list-item-title>
        </v-list-item>

        <div class="px-4">
          <v-chip v-for="tag in member.etc" :key="tag" class="mr-2 mb-2">
            {{ tag }}
          </v-chip>
        </div>
      </v-list>
    </v-container>
  </v-main>
</template>

<script>
export default {
  name: "Profile",
  data: () => ({
    fav: true,
    menu: false,
    blockDialog: false,
    reportDialog: false,

    food: "",
    oneetc: "",
    fooddialog: false,
    etcdialog: false,
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
    // console.log("created : ", this.member);
    // console.log("created member image", this.memberimage);
  },

  methods: {
    updateprofile() {
      this.$router.push("/update");
    },

    addfood() {
      // console.log("입력 food : ", this.food);
      this.member.foods.push(this.food);
      // console.log("member food", this.member.foods);
    },

    closefood() {
      this.fooddialog = false;
    },

    addetc() {
      this.dialog = false;
      // console.log("입력 etc : ", this.oneetc);
      this.member.etc.push(this.oneetc);
      // console.log("etc : ", this.member.etc);
    },

    closeetc() {
      this.etcdialog = false;
    },
  },
};
</script>

<style></style>
