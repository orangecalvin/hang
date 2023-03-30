/**
 * 
 */

//검색 아이콘을 눌렀을 때
document.querySelector("#searchButton").addEventListener("click", function(event) {
	event.preventDefault();
	searchHeritage();
});

// 엔터키를 쳤을 때
document.querySelector("#searchInput").addEventListener("keydown", function(event) {
	if (event.key === "Enter") {
		event.preventDefault();
		searchHeritage();
	}
});

// 검색결과 사이드바에 보여지게 하기
function searchHeritage() {
	let keyword = document.getElementById("searchInput").value;
	fetch("/search", {
		method: "POST",
		headers: {
			"Content-Type": "application/x-www-form-urlencoded"
		},
		body: "heritagename=" + encodeURIComponent(keyword)
	})
		.then(response => response.json())
		.then(data => {
			let html = '';
			for (let i = 0; i < data.length; i++) {
				let item = data[i];
				html += `<div style="border:1px solid black; margin-bottom:20px;">`;
				html += `<p style="font-size:1.2em; font-weight:bold;">문화재명</p>
				<p>${item.ccbaMnm1}(${item.ccbaMnm2})</p>`;
				html += `<p>종목 : ${item.ccmaName}</p>`;
				html += `<p>위치 : ${item.ccbaCtcdNm} ${item.ccbaAdmin}</p>`;
				html += `<a class="detail-link" onclick="detailContent(event)" style="cursor: pointer;">
				<input type="hidden" id="${item.sn}" name="sn" value="${item.sn}">
				<input type="hidden" id="${item.ccbaKdcd}" name="ccbaKdcd" value="${item.ccbaKdcd}">
				<input type="hidden" id="${item.ccbaAsno}" name="ccbaAsno" value="${item.ccbaAsno}">
				<input type="hidden" id="${item.ccbaCtcd}" name="ccbaCtcd" value="${item.ccbaCtcd}">
				<input type="hidden" id="${item.latitude}" name="latitude" value="${item.latitude}">
				<input type="hidden" id="${item.longitude}" name="longitude" value="${item.longitude}">
				자세히보기</a>`;
				html += `</div>`;
			}
			document.getElementById('searchResult').innerHTML = html;
		})
		.catch(error => {
			alert(`관리자에게 문의해주세요\n${error}`);
		});
}

function detailContent(event) {
   event.preventDefault(); // a태그의 기본 속성인 href로 이동하는 것을 막음
   let sn = event.target.querySelector('input[name="sn"]').value;
   let ccbaKdcd = event.target.querySelector('input[name="ccbaKdcd"]').value;
   let ccbaAsno = event.target.querySelector('input[name="ccbaAsno"]').value;
   let ccbaCtcd = event.target.querySelector('input[name="ccbaCtcd"]').value;
   let latitude = Number(event.target.querySelector('input[name="latitude"]').value);
   let longitude = Number(event.target.querySelector('input[name="longitude"]').value);
   console.log(`sn: ${sn}, ccbaKdcd: ${ccbaKdcd}, ccbaAsno: ${ccbaAsno}, ccbaCtcd: ${ccbaCtcd}, latitude:${latitude.toFixed(6)}, longitude: ${longitude.toFixed(6)}`);
}

