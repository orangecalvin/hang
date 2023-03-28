<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<script type="text/javascript"
  src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f51f22a3699fa4000697e5b37ae2ffe4&libraries=services,clusterer,drawing"></script>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/star.css">
    <link rel="stylesheet" href="./css/map.css">

<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
  crossorigin="anonymous">

<meta name="viewport" content="width=device-width, initial-scale=1.0">


<script type="text/javascript"
  src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=f51f22a3699fa4000697e5b37ae2ffe4"></script>
  

  
<title>main</title>
<style>
/*=================전체 디폴트=================  */
* {
	margin: 0;
	padding: 0;
}

html, body {
	width: 100%;
	height: 100%;
}

#map {
	position: relative;
	width: 100%;
	height: 100%;
}

.buttonbackimg {
	/*공용 버튼 색*/
	background: rgb(98, 107, 233);
  border: none;
}

.buttonbackimg:hover {
	background-image: url("img/backimg.png");
}

.dp-1 {
	color: rgb(98, 107, 233);
}


input[id="menuicon"] {
      display: none;
    }

    input[id="menuicon"]+ul {
      display: block;
      position: fixed;
      left: -32px;
      top: 50%;
      transform: translateY(-50%);
      transition: all .35s;
      text-align: right;
    }

    input[id="menuicon"]+ul>li {
      display: block;
      width: 50px;
      height: 50px;
      position: relative;
      margin-top: -1px;
    }

    input[id="menuicon"]+ul>li>a {
      display: block;
      width: auto;
      height: 50px;
      overflow: hidden;
      transition: all .35s;
    }

    input[id="menuicon"]+ul>li>label {
      display: block;
      cursor: pointer;
      width: auto;
      height: 50px;
      background: rgb(135, 119, 236);
    }

    input[id="menuicon"]+ul>li:nth-child(1) label span {
      display: block;
      position: absolute;
      width: 50%;
      height: 3px;
      border-radius: 30px;
      background: rgb(223, 228, 239);
      transition: all .35s;
    }

    input[id="menuicon"]+ul>li:nth-child(1) label span:nth-child(1) {
      top: 30%;
      left: 50%;
      transform: translateX(-50%);
    }

    input[id="menuicon"]+ul>li:nth-child(1) label span:nth-child(2) {
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
    }

    input[id="menuicon"]+ul>li:nth-child(1) label span:nth-child(3) {
      bottom: 30%;
      left: 50%;
      transform: translateX(-50%);
    }

    input[id="menuicon"]:checked+ul {
      z-index: 2;
      left: 318px;
    }

    input[id="menuicon"]:checked+ul>li:nth-child(1) label {
      z-index: 2;
      left: 318px;
    }

    input[id="menuicon"]:checked+ul>li:nth-child(1) label span:nth-child(1) {
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%) rotate(45deg);
    }

    input[id="menuicon"]:checked+ul>li:nth-child(1) label span:nth-child(2) {
      opacity: 0;
    }

    input[id="menuicon"]:checked+ul>li:nth-child(1) label span:nth-child(3) {
      bottom: 50%;
      left: 50%;
      transform: translate(-50%, 50%) rotate(-45deg);
    }

    div[class="sidebar"] {
      width: 350px;
      height: 100%;
      background: rgb(223, 228, 239);
      position: fixed;
      top: 0;
      left: -350px;
      z-index: 1;
      transition: all .35s;
      border-right: 4px solid rgb(140, 145, 236);
      border-radius: 0px 30px 30px 0px;
    }

    input[id="menuicon"]:checked+ul+div {
      left: 0;
    }


</style>
<link rel="stylesheet" href="./css/main.css"> 
</head>

<body>

  <!--##################### nav 시작 #######################-->

  <div class="container">
    <div class="row">

      <nav class="navbar fixed-top hangnav">
        <!--nav바 전체 : hang_01 -->



        <div class="col-2"></div>
        <!-- 검색창 시작-->
        <div class="col-5 relative hangsearch">
          <!--nav 검색창 : hang_02 -->
          <form action="/search" id="heritagename" method="post" style="height: 38px;">
          <input type="text" class="form-control" name="heritagename" placeholder="검색"
            aria-label="Recipient's username"
            aria-describedby="button-addon2" maxlength="50">
            <a role="button" type="submit" onclick="document.getElementById('heritagename').submit();"><img class="shabsolute" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png"></a>
            </form>
        </div>
        
        
        
        
        
        <!-- 검색창 끝-->

        <div class="col-1"></div>



        <ul class="col-3 nav nav-pills">
          <!--로그인 구역 :hang_03-->
          <li class="nav-item hanglogin">






            <button type="button"
              class="btn btn-primary buttonbackimg logbtn"
              data-bs-toggle="modal" data-bs-target="#login">
              로그인</button>

            <div class="container ">

              <div class="modal fade" id="login" tabindex="-1"
                aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content hangmodal">

                    <div id="top1">

                      <main class="form-signin w-100 m-auto">
                        <form>
                          <img class="mb-4" src="img/t2.png" alt=""
                            width="100" height="100">
                          <h1 class="h3 mb-3 fw-normal">로그인 화면</h1>

                          <div class="form-floating">
                            <input type="email" class="form-control"
                              id="floatingInput" placeholder="Id"
                              required
                              oninvalid="this.setCustomValidity('아이디를 입력해주세요')">
                            <label for="floatingInput">ID</label>
                          </div>
                          <div class="form-floating">
                            <input type="password" class="form-control"
                              id="floatingPassword"
                              placeholder="Password" required
                              oninvalid="this.setCustomValidity('패스워드를 입력해주세요')">
                            <label for="floatingPassword">Password</label>
                          </div>

                          <div class="checkbox mb-3">
                            <label> <input type="checkbox"
                              value="remember-me"> 로그인 상태 유지
                            </label>
                          </div>
                          <button
                            class="w-100 btn btn-lg btn-primary buttonbackimg">로그인</button>
                          <hr class="loghr">
                          <div class="wellcome">
                            <p class="wellcol">
                              <a href="#"> 아이디 찾기</a> |<a href="#">
                                비밀번호 찾기 </a>
                            </p>
                          </div>
                          <p class="mt-5 mb-3 text-muted">&copy;
                            2023</p>
                        </form>
                      </main>

                    </div>
                  </div>

                </div>
              </div>



            </div> <!--로그인 끝-->
          </li>
          <!--회원 가입 시작: hang_04 -->
          <li class="nav-item newgestbtn">

            <button type="button" class="btn btn-primary buttonbackimg"
              data-bs-toggle="modal" data-bs-target="#regist">
              회원가입</button>


            <div class="container">
              <main>

                <div class="modal fade" id="regist" tabindex="-1"
                  aria-labelledby="exampleModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                    <div class="modal-content hanglogcont">




                      <div class="row g-5 justify-content-md-center p-5">
                        <div class="col-md-5 col-lg-12">
                          <h2 class="mb-3">회원가입 신청서</h2>
                          <div id="essential" class="mb-3">
                            <span class="dp-1">*</span> 는 필수입력
                          </div>
                          <form class="needs-validation" novalidate
                            method="post" id="myForm">
                            <div class="row g-3">

                              <div class="col-12">
                                <label for="lastName" class="form-label">이름<span
                                  class="dp-1">*</span></label> <input
                                  type="text" class="form-control"
                                  id="name" placeholder="" value=""
                                  required>
                                <div class="invalid-feedback">이름이
                                  잘못 입력되었습니다.</div>
                              </div>

                              <div class="col-12">
                                <label for="username" class="form-label">아이디<span
                                  class="dp-1">*</span></label>
                                <div class="input-group has-validation">
                                  <input type="text"
                                    class="form-control" id="username"
                                    placeholder="ID" required>
                                  <div class="invalid-feedback">
                                    아이디를 잘못 입력되었습니다.</div>
                                </div>
                              </div>

                              <div
                                class="form-group has-feedback col-12">
                                <label for="password" class="form-label">비밀번호<span
                                  class="dp-1">*</span></label>
                                <div class="input-group has-validation">
                                  <input type="text"
                                    class="form-control" id="password1"
                                    placeholder="Password" required>
                                </div>
                                <div class="invalid-feedback">
                                  비밀번호를 잘못 입력되었습니다.</div>
                              </div>


                              <div
                                class="form-group has-feedback col-12">
                                <label for="passwordConfirm"
                                  class="form-label">비밀번호 확인<span
                                  class="dp-1">*</span></label>
                                <div class="input-group has-validation">
                                  <input type="text"
                                    class="form-control" id="password2"
                                    placeholder="Password Confirm"
                                    required>
                                  <div class="invalid-feedback">
                                    비밀번호가 맞지 않습니다.</div>
                                </div>
                              </div>

                              <div class="col-12">
                                <label for="phone" class="form-label">연락처<span
                                  class="dp-1">*</span></label> <input
                                  type="text" class="form-control"
                                  id="phone" placeholder="010-1234-5678"
                                  required>
                              </div>

                              <div class="col-12">
                                <label for="email" class="form-label">이메일</label>
                                <input type="email" class="form-control"
                                  id="email"
                                  placeholder="example@google.com">
                              </div>


                            </div>
                          </form>

                          <div class="mt-2 mx-auto text-wrap">
                            <button
                              class="w-100 btn btn-primary btn-lg mt-4 buttonbackimg"
                              onclick="confirm1();" type="submit">가입</button>
                            <button
                              class="w-100 btn btn-secondary btn-lg mt-4 buttonbackimg"
                              data-bs-dismiss="modal">취소</button>
                          </div>
                        </div>
                      </div>

                    </div>
                  </div>
                </div>
              </main>

            </div> <!--회원가입 끝 -->
          </li>

        </ul>

        <div class="col-1">
          <!-- 어사이드 와 오른쪽 버튼 : hang_05  -->
          <button class="navbar-toggler hangtoggler" type="button"
            data-bs-toggle="offcanvas"
            data-bs-target="#offcanvasScrolling"
            aria-controls="offcanvasDarkNavbar">
            <span class="navbar-toggler-icon hangtoggler-icon"></span>
          </button>
        </div>
        <!-- 버튼끝 -->
        <div class="offcanvas offcanvas-end bug1" data-bs-scroll="true"
          data-bs-backdrop="false" tabindex="-1" id="offcanvasScrolling"
          aria-labelledby="offcanvasScrollingLabel">
          <div class="offcanvas-header bug2">
            <h5 class="offcanvas-title" id="offcanvasScrollingLabel">제목</h5>
            <button type="button" class="btn-close"
              data-bs-dismiss="offcanvas" aria-label="Close"></button>
          </div>

          <div class="offcanvas-body bug3">
            <p>즐겨찾기나 여러가지 등등</p>
          </div>
        </div>
        <!-- 어사이드 끝-->


      </nav>
    </div>
  </div>

  <script>
    function confirm1() {
      let p1 = document.getElementById('password1').value;
      let p2 = document.getElementById('password2').value;
      console.log(p1);
      if (p1.length < 6) {
        alert('입력한 글자가 6글자 이상이어야 합니다.');
        return false;
      }
      if (p1 != p2) {
        alert("비밀번호 불일치");
        return false;
      }
    }
  </script>

  <!-- #############nav 끝##################-->
  <div style="z-index: 9999;  position: relative;" >
      <input type="checkbox" id="menuicon" >
<ul>
  <li>
    <label for="menuicon">
      <span></span><span></span><span></span>
    </label>
  </li>
  
</ul>

<div class="sidebar">
  <div id="searchResult">문화재</div>
</div>
  </div>
  
    <script>
const resultArr = '${result}'.slice(2, -2).split('!');
let count = 1;
//각 문화재별 15개씩으로 구분해야 함
resultArr.forEach((value) => {
  document.getElementById('searchResult').innerHTML += count + '번째 ' + value + '<br>';
  count++;
});
</script>
  


 
 
 
  <div id="map" >
  </div>


  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
    crossorigin="anonymous"></script>
    <script type="text/javascript" src="./js/map.js"></script>
   
</body>

</html>