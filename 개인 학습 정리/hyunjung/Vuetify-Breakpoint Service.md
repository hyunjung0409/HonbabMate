# Breakpoint Service
컴포넌트 내에서 뷰포트(어플리케이션 화면 크기) 정보에 접근하는 프로그래밍 방식이다.<br>
`$vuetify` 오브젝트에는 뷰포트 크기에 따라 어플리케이션 화면을 제어하는 데 사용하는 여러 속성이 있다.<br>
https://vuetifyjs.com/en/features/breakpoints/

```
<!-- Vue Component -->
<!-- breakpoint 마다 v-card의 height를 변경하는 예시 --> 
<template>
  <v-card :height="height">
    ...
  </v-card>
</template>

<script>
  export default {
    computed: {
      height () {
        switch (this.$vuetify.breakpoint.name) {
          case 'xs': return 220
          case 'sm': return 400
          case 'md': return 500
          case 'lg': return 600
          case 'xl': return 800
        }
      },
    },
  }
</script>
```

### Breakpoint Service를 활용한 실습 

- 뷰포트 크기에 따라 모바일 사이즈일 때는 다이얼로그가 전체화면으로, 모바일 사이즈 이상일 때는 팝업으로 뜨도록 구현해보는 실습
```
<!-- Vue Component -->
<template>
  <v-container>
    <v-card>
      <v-card-title>
        $vuetify.breakpoint.mobile: {{ $vuetify.breakpoint.mobile }} <!-- 현재 뷰포트 크기가 mobileBreakpoint 기준에 따라 true/false로 나타남 -->
        {{ $vuetify.breakpoint.mobileBreakpoint }} <!-- mobileBreakpoint 기준이 나타남 -->
      </v-card-title>
      <v-container class="grey lighten-3">
        <!-- fullscreen 속성으로 버튼 클릭 시 나오는 다이얼로그 창이 전체화면으로 나타남 -->
        <!-- fullscren 속성에 $vuetify.breakpoint.mobile가 true일 때만 적용되도록 설정하면 모바일 사이즈일 때만 전체화면으로 보여짐 -->
        <v-dialog
          v-model="dialog"
          width="500"
          :fullscreen="$vuetify.breakpoint.mobile"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="red lighten-2" dark v-bind="attrs" v-on="on">
              Click Me
            </v-btn>
          </template>

          <v-card>
            <v-card-title class="text-h5 grey lighten-2">
              Privacy Policy
            </v-card-title>

            <v-card-text>
              ...
            </v-card-text>

            <v-divider />

            <v-card-actions>
              <v-spacer />
              <v-btn color="primary" text @click="dialog = false">
                I accept
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-container>
    </v-card>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    dialog: false,
  }),
  computed: {
    height() {
      switch (this.$vuetify.breakpoint.name) {
        case "xs":
          return 100;
        case "sm":
          return 200;
        case "md":
          return 300;
        case "lg":
          return 400;
        default:
          return 500;
      }
    },
  },
};
</script>
<style lang=""></style>
```

- mobile breakpoint 기준(default: xs, sm)을 변경하고 싶다면 vuetify.js 에서 아래와 같이 설정한다.
```
import Vue from "vue";
import Vuetify from "vuetify/lib/framework";

Vue.use(Vuetify);

export default new Vuetify({
  <!-- mobileBreakpoint 기준을 xs로 변경하여 xs일 때만 다이얼로그가 전체화면으로 나타남. -->
  breakpoint: {
    mobileBreakpoint: "xs",
  },
});
```


[참고]
Vuetify 강의 Ep10 - Breakpoint Service | Vuetify를 시작하기 전에 꼭 봐야 하는 영상 | Vuetify Admin Template 만들기<br>
짐코딩의 CODING GYM<br>
https://youtu.be/7sKpBB-pC2w
