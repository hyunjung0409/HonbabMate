## 소셜로그인

- 소셜네트워크서비스(SNS)에서 제공하는 로그인 기능을 사용하여 다른 사이트에 로그인하는 것

# 소셜로그인 구현원리

- client : 소셜로그인을 사용하는 유저, 즉 서비스를 만드는 '나'
- resource owner : 소셜로그인 기능을 제공하는 서비스를 사용하는 유저
- resource server : 소셜로그인 기능을 제공하는 곳, 그리고 client가 받아야 하는 진짜 유저의 데이터를 가지고 있는 곳

# 소셜로그인 구현 절차

1. 소셜로그인에 접근하기 위해 client를 resource server에 등록(client와 server 사이에 3가지 정보를 공유)

   - client id : 내가 구현할 서비스의 식별 id
   - client secret : 실제로 소셜서비스가 "나"라는 서비스가 맞는지, 옳은 서비스가 접근하여 로그인을 하려고 하는지 식별하는 pw(보안이슈로 노출해서는 안됨)
   - Authorized Redirect URL : 소셜 서비스가 인증이 가능하도록 권할을 부여하는 과정해서 그 인증코드를 전달해줄 경로

2. 등록 절차 이후, 소셜로그인 진행 과정
   a. 로그인 하고자 하는 resource owner에게 승인을 받아야한다.
   b. resource owner에게 승인을 받았으니, 그 증거를 가지고 resource server에게 해당 유저의 데이터를 전달해달라고 요청한다.

## 검색엔진 최적화(SEO)

- 검색엔진이 이해하기 쉽도록 홈페이지의 구조와 페이지를 개발해 검색 결과 상위에 노출될 수 있도록 하는 작업

# 검색엔진최적화로 구글 상위에 랭크되는 방법

1. 문법에 맞는 HTML 작성

2. 구체적인 페이지 제목 만들기

3. meta 태그 활용하기

4. 이미지에 alt 속성 기재

5. 이미지 맵에 중요한 링크 사용피하기

6. anchor 태그를 활용하여 적절한 키워드 배치

7. 모든 페이지가 유입 페이지가 되도록 사이트 구성

8. https 사용