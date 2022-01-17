이번 프로젝트에서는 spring을 통해 백엔드를 구현하기로 하였다.

1학기 과정에서는 백엔드 구현에 파이썬의 django만을 사용해봤으므로, java와 spring은 새로 배워야 했다.

django를 배우기 전 파이썬을 토대로 쌓았듯 이번에도 spring을 배우기 위해 java를 먼저 익히기로 하였다.



## JAVA

#### 개인적으로 인상적이었던 JAVA의 특징

1. 모든 운영체제에서 실행 가능

   자바로 작성된 프로그램은 모든 운영체제에서 수정 없이 바로 실행할 수 있다.

   이것이 가능한 이유는 자바의 컴파일러가 코드를 직접적인 CPU 명령어로 변환하는것이 아닌, JVM이라는 자바 바이트코드 실행기가 이해하는 자바 바이트코드로 변환시키기 때문에 JVM만 있다면 어떤 운영체제에서도 같은 코드로 같은 기능을 수행해낼 수 있다.

2. 메모리 자동 정리

   힙 메모리에 존재하는 객체 중 어느 변수에도 참조되지 않는 객체가 메모리에서 자동으로 제거된다.

3. package 밑에 class를 생성하여 코드 작성

   백지상태의 py파일 하나를 생성해서 바로 코드를 작성하는 파이썬과 다르게 프로젝트를 생성하고 package를 생성하고 그 밑에 또 class를 생성하여 비로소 코드를 작성한다.

   다른 언어도 프로젝트를 생성해서 그 밑에 소스코드를 여러개 생성하는 것 같아 독립된 py파일을 생성하는 파이썬이 특이한 경우일 수도 있겠지만, 파이썬을 기준으로 작성했다.



#### 변수

* 파이썬과 달리 변수를 선언해줘야 함.

  ```python
  # 파이썬
  a = 10
  b = 0.1
  
  print(a)
  print(b)
  
  # 결과
  # 10
  # 0.1
  ```

  ```java
  // package, class, method 생략
  
  int a = 10; //명령어 끝에 ;를 붙여줘야 함.
  double b = 0.1;
  
  System.out.println(a);
  System.out.println(b);
  
  // 결과
  // 10
  // 0.1
  ```

##### 기본 타입

* 정수 타입

  byte     1byte

  short   2byte

  char     2byte (0~65535) (유니코드)

  int        4byte

  long     8byte

* 실수 타입

  float        4byte (32bit)

  double   8byte (64bit)

* 논리 타입

  boolean - True/False

* 문자열은 기본 타입이 아니다. 클래스 타입이다.



##### 타입 변환

* 작은 타입에서 큰 타입으로 변환하는 경우 (byte -> short, int / float -> double) 자동으로 타입이 변환된다.

* 정수 타입에서 실수 타입으로 변환하는 경우에도 자동으로 변환된다.

* 큰 타입에서 작은 타입으로는 자동으로 변환되지 않고 강제로 변환시켜줘야 하며, 값에 손실이 있을 수 있다.

  ```java
  byte a = 3;
  int b = a;
  // 자동으로 변환됨
  
  int a = 150;
  long b = a;
  // 자동으로 변환됨
  
  int a = 150;
  byte b = a;
  // 컴파일 에러
  
  int a = 150;
  byte b = (int) a;
  // 강제 변환
  
  double a = 3.11;
  int b = (int) a;
  // 강제 변환. 소수점 이하 자리의 값을 손실한다.
  ```



#### 연산자와 연산식

* 문자열과 숫자를 더할(+) 경우, 문자열로 변환되어 합쳐진다.

  ```java
  System.out.println('2' + 3 + 4);
  // 출력 결과 : 234
  
  System.out.println(2 + 3 + '4');
  // 출력 결과 : 54
  ```

* 단항연산자가 앞에 있는지 뒤에 있는지에 따라 연산의 순서가 바뀜.

  ```java
  int a = 1;
  int b = 10;
  
  int c = ++a + b;
  // c = 12
  int c = a++ + b;
  // c = 11 (a+b가 먼저 수행되고 나서 a에 값이 증가됨.)
  ```

외에는 파이썬과 큰 차이는 없는 것 같다.



#### 조건문과 반복문

* if, for, while의 경우 약간의 문법 차이 외엔 파이썬과 동일함.

* switch문

  ```java
  String number = "";
  
  switch(a) {
      case 0: number = "zero"
          break;
      case 1: number = "one"
          break;
      case 2: number = "two"
          break;
      case 3: number = "three"
          break;
      case 4: number = "four"
          break;
      case 5: number = "five"
          break;
      case 6: number = "six"
          break;
      case 7: number = "seven"
          break;
      case 8: number = "eight"
          break;
      case 9: number = "nine"
          break;
      default: number = "한자리 수가 아님"
          break;
  }
  // if/else 문으로 작성할 경우 조건마다 조건문을 추가해야함. switch문으로 더 간단하게 작성할 수 있다.
  ```

* do-while문

  ```java
  do {
      // 반복할 코드
  } while (/* 조건 */);
  // while문은 조건에 맞지 않으면 반복문에 진입이 안되지만,
  // do-while문은 반복문이 최소 한번은 진행되고 더 반복할지 결정하게 된다.
  ```

  





똑같은 변수, 연산, 조건, 반복인데 생각보다 다른점이 많아서 공부하면서 신기하고 재밌다.

당장은 다른 언어들과도 일맥상통하는 내용들이라 이해하기 수월한 것 같지만, 알고리즘을 짠다거나 자바 기반 라이브러리를 사용하는 등 더 심화된 내용을 접한다면 얼마나 새롭고 어려울지 살짝은 막막하다. 