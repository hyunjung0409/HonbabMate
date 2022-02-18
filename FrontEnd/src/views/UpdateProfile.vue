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

        <v-col class="mt-2" cols="4">
          <div>
            <v-text-field
              id="nickname"
              v-model="nickname"
              label="닉네임"
              hint="닉네임 입력은 필수입니다"
              :placeholder="member.nickname"
              counter="10"
              required
              color="amber darken-1"
            />
          </div>
          <div>
            <p>좋아요 받은 수 : {{ member.cntOfLikes }}</p>
          </div>
        </v-col>

        <v-col class="mt-11" cols="2" align="end">
          <v-btn rounded color="primary" dark @click="modify"> 수정하기 </v-btn>
        </v-col>

        <v-col class="mt-11" cols="4">
          <v-btn rounded color="secondary" light @click="cancel"> 취소 </v-btn>
        </v-col>
      </v-row>

      <v-divider class="mt-12 mb-5" />

      <v-list style="background-color: #eeeeee">
        <v-list-item>
          <v-list-item-title max-width="200px"> 최애음식 </v-list-item-title>
          <v-dialog v-model="fooddialog" width="500">
            <template v-slot:activator="{ on, attrs }">
              <v-btn text v-bind="attrs" v-on="on">
                <v-icon> mdi-plus </v-icon>
              </v-btn>
            </template>
            <v-card>
              <v-card-title class="text-h5 grey lighten-2">
                최애음식
              </v-card-title>
              <v-card-text>
                <v-text-field
                  v-model="food"
                  placeholder="좋아하는 음식을 적어주세요"
                />
              </v-card-text>
              <v-divider />
              <v-card-actions>
                <v-spacer />
                <v-btn color="primary" text @click="addfood"> 추가하기 </v-btn>
                <v-btn color="secondary" text @click="closefood"> 취소 </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-list-item>

        <div class="px-4">
          <v-chip
            v-for="food in member.foods"
            :key="food"
            class="mr-2 mb-2"
            @click="deletefood(food)"
          >
            {{ food }}
          </v-chip>
        </div>

        <v-divider class="mt-12 mb-5" />

        <v-list-item>
          <v-list-item-title max-width="200px"> 또 뭐있지? </v-list-item-title>
          <v-dialog v-model="etcdialog" width="500">
            <template v-slot:activator="{ on, attrs }">
              <v-btn text v-bind="attrs" v-on="on">
                <v-icon> mdi-plus </v-icon>
              </v-btn>
            </template>
            <v-card>
              <v-card-title class="text-h5 grey lighten-2">
                기타사항
              </v-card-title>
              <v-card-text>
                <v-text-field
                  v-model="oneetc"
                  placeholder="나를 표현할 수 있는 것을 적어주세요"
                />
              </v-card-text>
              <v-divider />
              <v-card-actions>
                <v-spacer />
                <v-btn color="primary" text @click="addetc"> 추가하기 </v-btn>
                <v-btn color="secondary" text @click="closeetc"> 취소 </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-list-item>

        <div class="px-4">
          <v-chip
            v-for="tag in member.etc"
            :key="tag"
            class="mr-2 mb-2"
            @click="deleteetc(tag)"
          >
            {{ tag }}
          </v-chip>
        </div>
      </v-list>
    </v-container>
  </v-main>
</template>

<script>
import rest from "@/api/index.js";
import qs from "qs";
import Swal from "sweetalert2";

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
  },

  methods: {
    modify() {
      if (!this.nickname) {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "닉네임을 입력해주세요!",
        });
      } else {
        this.usermodify();
      }
    },

    async usermodify() {
      await rest
        .axios({
          method: "put",
          url: "/profile",
          params: {
            etc: this.member.etc,
            foods: this.member.foods,
            id: this.member.id,
            nickname: this.nickname,
          },
          paramsSerializer: (params) => {
            return qs.stringify(params, { arrayFormat: "brackets" });
          },
        })
        .then((res) => {
          // console.log("etc : ", this.member.etc);
          // console.log("nickname : ", this.nickname);
          // console.log(res);

          this.$store.commit("memberNickname", this.nickname);

          Swal.fire({
            position: "top",
            icon: "success",
            title: "수정완료!",
            showConfirmButton: false,
            timer: 1500,
          });
          this.$router.push({ path: "/profile" });
          sessionStorage.clear();
          // alert("다시 로그인해주세요!");
          // location.reload();
        })
        .catch((err) => {
          console.log(err);
        });
    },

    addfood() {
      // console.log("입력 food : ", this.food);
      this.member.foods.push(this.food);
      // console.log("member food", this.member.foods);
    },

    deletefood(food) {
      // console.log("deletefood :", food);
      // console.log(this.member.foods.length);
      for (var i = 0; i < this.member.foods.length; i++) {
        if (this.member.foods[i] == food) {
          if (i == 0) {
            this.member.foods.splice(i, 1);
          } else {
            this.member.foods.splice(i, i);
          }
        }
        // console.log("Array[food] : ", this.member.foods);
      }
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

    deleteetc(etc) {
      // console.log("deleteetc :", etc);
      // console.log(this.member.etc.length);
      for (var i = 0; i < this.member.etc.length; i++) {
        if (this.member.etc[i] == etc) {
          if (i == 0) {
            this.member.etc.splice(i, 1);
          } else {
            this.member.etc.splice(i, i);
          }
        }
        // console.log("Array[etc] : ", this.member.etc);
      }
    },

    closeetc() {
      this.etcdialog = false;
    },

    cancel() {
      this.$router.push("/profile");
    },
  },
};
</script>

<style></style>
