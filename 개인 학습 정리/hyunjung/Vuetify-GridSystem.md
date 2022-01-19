# Grid System

- `Grid` : 격자를 뜻함, 수직과 수평으로 분할된 면을 의미
- 웹 페이지는 12개의 Column으로 구성됨
- 그리드 시스템의 장점
    - 컨텐츠 **정렬, 정돈**된 결과
    - **일관적**이고 **규칙적**인 디자인
    - 디자인 **가이드** 및 **협업**에 도움
    - **반응형 디자인 설계**가 쉬움
- `Container` : 콘텐츠 영역의 가장 큰 폭의 기준
- `Column` : 콘텐츠 영역
- `Gutter` : Column 사이 간격
- `Margin` : 좌우 여백


# Vuetify - Grid System

- flexbox를 사용하여 구축됨
    - `flexbox` : CSS3의 새로운 레이아웃 방식.
- 12 Column Grid System
- 5가지의 Breakpoints 제공
    - `breakpoints` : 반응형 웹에서 사이즈가 변화하는 지점.
    - Extra small `xs`, Small `sm`, Medium `md`, Large `lg`, Extra large `xl`

# 실습

### 우측 메뉴바 토글 기능 추가

1. Vuetify 홈페이지에서 Toolbars를 검색하여 아래 코드를 복사
    
    ```java
    <v-app-bar-nav-icon></v-app-bar-nav-icon>
    ```
    
2. App.vue의 template 태그 안에 붙여 넣기
3. script 태그의 data 영역에 `drawer: false,` 코드를 추가
4. template 태그의 `<v-navigation-drawer v-model="drawer" app>`으로 바인딩 처리
5. template 태그의 `<v-app-bar-nav-icon @click="drawer = !drawer" />`으로 토글 처리

### Grid System

- `v-container`
    
    ```java
    //📁src/views/GridSystem.vue
    <template>
      <v-container class="red" fluid> //container에 fluid 속성을 주어 화면에 꽉 차도록 설정
        <v-card class="yellow pa-3"> Col </v-card> //padding 값 설정
      </v-container>
    </template>
    
    ```
    
- `v-row` **:** v-col의 배치나 정렬을 하기 위해 사용됨
- `v-col`
    
    ```java
    //📁src/views/GridSystem.vue
    //<v-row> 안에 <v-col>. <v-col> 안에 contents.
    <template>
      <v-container fluid>
        <v-card class="pa-3">
          <v-row> //기본 gutter 24px. dense 속성을 주면 8px. no-gutters 속성을 주면 0px.
            <v-col>
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
            <v-col>
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
            <v-col>
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
          </v-row>
    		</v-card>
      </v-container>
    </template>
    ```
    
- `v-spacer` : 컴포넌트 사이에 빈 공간을 생성
    
    ```java
    //📁src/views/GridSystem.vue
    <v-card class="mt-5 pa-3">
          <v-row>
            <v-col>
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
            **<v-spacer />**
            <v-col>
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
            <v-col>
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
          </v-row>
          <v-row>
            **<v-spacer />**
            <v-col>
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
            <v-col>
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
            <v-col>
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
          </v-row>
        </v-card>
    ```
    

- `align` : v-row 속성으로 자식 컴포넌트를 수직 정렬
- `align-self` : v-col 속성으로 자기 자신을 수직 정렬
    
    ```java
    //📁src/views/GridSystem.vue
    <v-card class="mt-5 pa-3">
          <v-row :style="{ height: '120px' }" class="red" align="end"> //end, center, start로 정렬
            <v-col>
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
            <v-col>
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
            <v-col>
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
          </v-row>
          <v-row :style="{ height: '120px' }" class="yellow">
            <v-col align-self="end">
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
            <v-col align-self="center">
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
            <v-col align-self="start">
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
          </v-row>
        </v-card>
    ```
    


### Breakpoint

- v-col에 `breakpoint` 속성을 주어 화면 크기에 따라 컨텐츠가 보이는 형식을 변경
    
    ```java
    //📁src/views/GridListPage.vue
    <template>
      <div>
        <v-container>
          <v-row>
    				// xs(default)에는 1개, sm에는 2개, md 3개, la/xl 4개의 컨텐츠를 보여줌
            <v-col v-for="count in 12" :key="count" cols="12" sm="6" md="4" lg="3">
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
          </v-row>
        </v-container>
      </div>
    </template>
    <script>
    export default {};
    </script>
    <style lang=""></style>
    ```
    

### Justify

- `justify` v-row 속성으로 자식 컴포넌트를 수평 정렬
    - `start` (좌측), `center` (중앙), `end` (우측), `space-around` (균등 분할하여 중앙 정렬),  `sapce-between` (균등 분할하여 좌측, 중앙, 우측으로 각각 정렬)
    
    ```java
    //📁src/views/GridSystem.vue
    <v-card class="mt-5 pa-3">
          <v-row **justify="space-between"**>
            <v-col **cols="auto"**> //컨텐츠에 맞게 크기가 자동 설정됨
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
            <v-col cols="auto">
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
            <v-col cols="auto">
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
          </v-row>
    			<v-row **justify="space-between"**>
            <v-col cols="auto">
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
            <v-col cols="auto">
              <v-card class="pa-3" outlined> Col </v-card>
            </v-col>
          </v-row>
        </v-card>
    ```
    


### flexbox 가이드

- [https://css-tricks.com/snippets/css/a-guide-to-flexbox/#flexbox-background](https://css-tricks.com/snippets/css/a-guide-to-flexbox/#flexbox-background)

- 참고
    - Vuetify 강의 Ep07 - Grid System 2탄 - **[짐코딩의 CODING GYM](https://www.youtube.com/channel/UCZ30aWiMw5C8mGcESlAGQbA)**
        - [https://youtu.be/InuKrcuByWI](https://youtu.be/InuKrcuByWI)
    - [http://designbase.co.kr/sketch-4/](http://designbase.co.kr/sketch-4/)
