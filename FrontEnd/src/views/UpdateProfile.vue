<template>
  <v-main>
    <v-container>
      <v-row>
        <v-col cols="2">
          <v-avatar size="120">
            <img :src="memberimage.url" alt="profile-picture" />
          </v-avatar>
          <!-- <v-file-input @change="uploadimage"></v-file-input> -->
        </v-col>

        <!-- <v-menu> </v-menu> -->

        <v-col class="mt-9" cols="3">
          <div>
            <v-text-field
              label="닉네임"
              v-model="member.nickname"
              hint="닉네임 입력은 필수입니다"
              counter="10"
              id="nickname"
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
        </v-list-item>
        <div class="px-4">
          <v-chip v-for="food in member.foods" :key="food" class="mr-2 mb-2">
            {{ food }}
          </v-chip>
        </div>
        <div class="px-4">
          <v-dialog v-model="fooddialog" width="500">
            <template v-slot:activator="{ on, attrs }">
              <v-btn color="red lighten-2" dark v-bind="attrs" v-on="on">
                추가하기
              </v-btn>
            </template>
            <v-card>
              <v-card-title class="text-h5 grey lighten-2">
                최애음식
              </v-card-title>
              <v-card-text>
                <v-text-field v-model="food"></v-text-field>
              </v-card-text>
              <v-divider></v-divider>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="primary" text @click="addfood"> 추가하기 </v-btn>
                <v-btn color="secondary" text @click="closefood"> 취소 </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </div>

        <v-list-item>
          <v-list-item-title>또 뭐있지?</v-list-item-title>
        </v-list-item>
        <div class="px-4">
          <v-chip v-for="tag in member.etc" :key="tag" class="mr-2 mb-2">
            {{ tag }}
          </v-chip>
        </div>

        <div class="px-4">
          <v-dialog v-model="etcdialog" width="500">
            <template v-slot:activator="{ on, attrs }">
              <v-btn color="red lighten-2" dark v-bind="attrs" v-on="on">
                추가하기
              </v-btn>
            </template>
            <v-card>
              <v-card-title class="text-h5 grey lighten-2">
                기타사항
              </v-card-title>
              <v-card-text>
                <v-text-field v-model="oneetc"></v-text-field>
              </v-card-text>
              <v-divider></v-divider>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="primary" text @click="addetc"> 추가하기 </v-btn>
                <v-btn color="secondary" text @click="closeetc"> 취소 </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
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
import rest from "@/api/index.js";

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
    file: "",

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
    console.log("created : ", this.member);
  },

  methods: {
    async modify() {
      await rest
        .axios({
          method: "put",
          url: "/profile",
          data: {
            etc: this.member.etc,
            foods: this.member.foods,
            id: this.member.id,
            nickname: this.member.nickname,
          },
        })
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
          console.log("formdata", this.file);
          console.log("etc", this.member.etc);
          console.log("foods", this.member.foods);
          console.log("id", this.member.id);
          console.log("nickname", this.member.nickname);
        });
    },

    // uploadimage(e) {
    //   console.log(e);
    //   const formData = new FormData();
    //   formData.append("imageFile", e);
    //   this.file = formData;
    //   console.log("this file :", this.file);
    // },

    addfood() {
      console.log("입력 food : ", this.food);
      this.member.foods.push(this.food);
      console.log("food", this.member.foods);
    },

    closefood() {
      this.fooddialog = false;
    },

    addetc() {
      this.dialog = false;
      console.log("입력 etc : ", this.oneetc);
      this.member.etc.push(this.oneetc);
      console.log("etc : ", this.member.etc);
    },

    closeetc() {
      this.etcdialog = false;
    },

    // modify() {
    //   console.log("이거 보내주면 끝?", this.member.foods);
    // },

    cancel() {
      this.$router.push("/profile");
    },
  },
};
</script>

<style></style>
