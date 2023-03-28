const searchBar = document.getElementById("searchBar");
const searchButton = document.getElementById("searchBarButton");

// Enter키를 눌렀을 때 검색
searchBar.addEventListener("keydown", function(event) {
  if (event.key === "Enter") {
    search();
  }
});

// 검색 버튼 클릭 시 검색
searchButton.addEventListener("click", function() {
  search();
});

// 검색 함수
function search() {
  const ccbaMnm1Value = searchBar.value;

  const xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status === 200) {
        console.log(xhr.responseText); // 서블릿에서 보내온 응답을 출력
      } else {
        console.error('서버로부터 응답을 받지 못했습니다.');
      }
    }
  };
  xhr.open('GET', '/hsearch?ccbaMnm1Value=' + encodeURIComponent(ccbaMnm1Value), true); // query를 인코딩하여 GET 요청을 보냄
  xhr.send();
}