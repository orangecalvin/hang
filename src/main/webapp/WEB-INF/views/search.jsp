<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>

</script>
</head>
<body>

//문화재 결과값 출력
<div id="result"></div>


//문화재 검색결과 스크립트로 분리
<script>
const resultArr = '${result}'.slice(2, -2).split('!');
let count = 1;
//각 문화재별 15개씩으로 구분해야 함
resultArr.forEach((value) => {
  document.getElementById('result').innerHTML += count + '번째 ' + value + '<br>';
  count++;
});
</script>
</body>
</html>