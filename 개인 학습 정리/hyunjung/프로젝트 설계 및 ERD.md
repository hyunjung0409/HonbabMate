# 프로젝트 설계

## 프로젝트 설계 개념
프로젝트 설계란 요구사항 명세서를 기반으로 시스템이 제공하는 기능, 인터페이스, 데이터를 정의하고 제어와 연결을 명확히 하여<br>
개발자가 시스템을 구죽할 수 있는 수준의 문서를 만드는 작업이다.

설계는 대표적으로 프로세스 설계, 인터페이스 설계, 데이터 설계로 나눌 수 있다.

각 단계는 순차적으로 진행되지만 현재 단계가 완료되면 이전 단계의 산출물이 지속적으로 수정된다.<br>
분석 단계에서 생각하지 못했던 요구사항이 설계단계에서 도출될 수 있기 때문이다.

## ERD 다이어그램
'Entity Relationship Diagram'의 약자로 '존재하고 있는 것(Entity)들의 관계(Relationship)를 나타낸 도표(Diagram)이다.<br>

### Entity
정의 가능한 사물 또는 개념을 의미하며, 사람/객체/개념/이벤트 등을 Entity로 둘 수 있다.<br>
데이터베이스를 설계할 때, '테이블'이 Entity 정의될 수 있다.

### Entity Attribute
각각의 Entity에는 속성을 포함하고 있다. Attribute는 개체가 갖고 있는 속성이다.<br>
데이터 타입을 같이 명시해줘야 하며 RDBMS가 지원하는 타입에 맞게 정의해야 한다.

### PK (Primary key)
테이블에서 각 행의 정보들을 식별할 수 있는 정보를 표현한다.<br>
PK는 테이블 행의 여러 정보들 중 행을 식별할 수 있어야 하기 때문에 비어있으면 안되고 (NOT NULL) 중복되어서도 안된다 (Unique).<br>
또한 식별할 때 테이블의 정보를 최대한 빠르게 검색해야 하므로 간단한 정보일수록 좋다.

### FK (Foreign key)
참조하는 테이블과 참조되는 테이블의 관계를 나타낸다. 

<details><summary>출처</summary>
https://multicore-it.com/54?category=686774 <br>
https://inpa.tistory.com/410 <br>
https://mjn5027.tistory.com/43 <br>
https://velog.io/@jch9537/DATABASE-PK-FK <br>
</details>
