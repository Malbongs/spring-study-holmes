# spring-study-holmes
# 프로젝트 스터디 홈즈
![image](https://user-images.githubusercontent.com/51532254/166196523-d80438c4-753b-4609-a156-cea16f72cb54.png)
 
#### 프로젝트 이름(project name) : spring-study-holmes 

#### 프로젝트 기간 : 2022.04.21 ~ 2022.05.04 (버그 수정: 2022.05.05~)

#### 프로젝트 인원 : 4명

## Description

([MVC2](https://github.com/ckcks1997/project-study-holmes)방식으로 제작중인 프로젝트를 스프링 방식으로 전환하여 진행한 프로젝트입니다.)

스터디 홈즈는 온/오프라인 스터디의 개최 및 참여, 커뮤니티 서비스를 제공하는 프로젝트 입니다.




본인 구현 기능
------------
- 마이페이지 
- 내 정보
- 프로필
- 본인 커뮤니티 게시글 목록
- 본인 스터디 게시글 목록
- 출석 이벤트
- 프로젝트 소개 페이지

사용된 기술
-------------

#### 모델링 툴 : Figma, Whimsical
#### IDE/Editor : Eclipse, VSCode
#### 웹서버 : Apache Tomcat 9.0
#### DB : Oracle
#### 개발 패턴 : Spring MVC
#### 빌드 툴 : Maven
#### 사용 언어 : HTML, CSS, Javascript, Java, JSP
#### 프론트 프레임워크/라이브러리 : Bootstrap 4, jQuery, SummerNote
#### 백엔드 프레임워크/라이브러리 : Spring 5.3, MyBatis
#### 사용 API : 카카오 API(지도, 로그인)
#### 협업 : Github

Image
=========
### ERD
<img width="764" alt="image (2)" src="https://user-images.githubusercontent.com/51532254/166196674-1d83c57a-f860-492f-abd3-36ab4a532f95.png"><br/><br/>

### 메뉴 구조도
<img width="764" alt="image (3)" src="https://user-images.githubusercontent.com/51532254/166196897-df3f903b-4fed-4127-8b39-d8522c3fa113.jpg"><br/><br/>

Screenshot
=========

 메인화면
-------------
 
<img width="764" alt="image (5)" src="https://user-images.githubusercontent.com/51532254/166634936-6b8f2c8a-7f8f-4676-a368-d3373de76896.jpg"><br/><br/>

 마이페이지
-------------

<img width="500" alt="스크린샷 2022-11-07 14 57 37" src="https://user-images.githubusercontent.com/99636339/200236617-1a03bfee-fcfd-4dd4-bcfa-04a1296242f6.png">
1.로그아웃 실행<br>
2.마이페이지 이동<br>
3.출석 이벤트 이동<br>



 내 정보 메뉴
-------------
<img width="500" src="https://user-images.githubusercontent.com/99636339/200237318-44bd8aa9-76a6-4e59-ba7f-c4742d1e6fce.png">

1. 내정보 메뉴<br>
2. Post요청으로 마이 포인트, 가입일 정보를 DB에 저장된 내용을 가져옴<br>
3. 스터디 평가 정보(평가 항목에서 평가 된 정보에 따라 기본 저장된 point DB에 -5~+5까지 정보 저장)point에 따른 표정변화<br>

 프로필
-------------

<img width="500" src="https://user-images.githubusercontent.com/99636339/200237331-93dfe77b-6b1d-4ff4-b30d-53e32a5ff148.png">

1. 프로필 내 자기소개 정보를 수정 하여 Update요정 보냄.<br>
2. 비밀 번호 변경을 위해 저장된 비밀번호가 DB에 일치하는 지 확인 후 변경(알림창 생성)<br>
3. 회원 탈퇴시 delete 요청을 보내 DB테이블 내에 관련된 회원의 모든 정보 삭제<br>

본인 커뮤니티 게시글 목록
-------------------

<img width="500" src="https://user-images.githubusercontent.com/99636339/200237909-a14ecd09-a5c2-45e0-8988-54a58b1e167c.png">

1.작성자의 프로필과 날짜 제목 닉네임등을 DB에서 자신의 회원 정보와 일치하는 커뮤니티 table의 모든 정보 호출<br>
2.작성된 커뮤니티 게시글 페이징 처리<br>

본인 스터디 게시글 목록
-------------------

<img width="500" src="https://user-images.githubusercontent.com/99636339/200238153-8265c6a7-1911-486b-bea9-384c4949e373.png">

1.작성자의 프로필과 날짜 제목 닉네임등을 DB에서 자신의 회원 정보와 일치하는 스터디 table의 모든 정보 호출<br>
2.작성된 스터디 게시글 페이징 처리<br>

출석 이벤트
--------

<img width="500" src="https://user-images.githubusercontent.com/99636339/200238441-a2024446-7a1c-4516-9e75-60c03b5e4b83.png">

1.계정 당 1 회 이벤트 실시<br>
2.div에 따른 value값 내장<br>
3.침div에 일치 하는 div의 value를 반환 하여 상품권이로 저장<br>

프로젝트 소개 페이지
---------------
<img width="500" alt="스크린샷 2022-11-07 15 17 15" src="https://user-images.githubusercontent.com/99636339/200239976-1ec14104-1622-4b96-a45b-3c67217c1240.png">
<img width="500" alt="스크린샷 2022-11-07 15 17 29" src="https://user-images.githubusercontent.com/99636339/200239987-4ff70eda-565d-4d21-bb8f-37828e792dc3.png">


