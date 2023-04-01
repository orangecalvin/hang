/**
 * 
 */

//검색 아이콘을 눌렀을 때
document.querySelector("#searchButton").addEventListener("click", function(event) {
	const menuicon = document.getElementById('menuicon');
	event.preventDefault();
	searchHeritage();
	if (menuicon.checked == false) {
		menuicon.checked = !menuicon.checked;
	}
});

// 엔터키를 쳤을 때
document.querySelector("#searchInput").addEventListener("keydown", function(event) {
	const menuicon = document.getElementById('menuicon');
	if (event.key === "Enter") {
		event.preventDefault();
		searchHeritage();
		if (menuicon.checked == false) {
		menuicon.checked = !menuicon.checked;
	}
	}
});

// 검색결과 사이드바에 보여지게 하기
function searchHeritage() {
	let keyword = document.getElementById("searchInput").value;
	fetch("/heritage/item/search", {
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
				html += `<div>`;
				html += `<p>문화재명</p>
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






//검색한 문화재의 위치를 지도에 핀 찍어주기
var marker2 = new kakao.maps.Marker();
var marker2Image = new kakao.maps.MarkerImage('./img/ping.png', new kakao.maps.Size(25, 35));
// 마커 이미지 변경
marker2.setImage(marker2Image);
let infowindow2 = new kakao.maps.InfoWindow({ zindex: 1 });



//자세히 보기 클릭 시 특정 문화재에 대한 세부항목 전송 및 전달
function detailContent(event) {
	event.preventDefault(); // a태그의 기본 속성인 href로 이동하는 것을 막음
	let ccbaKdcd = event.target.querySelector('input[name="ccbaKdcd"]').value;
	let ccbaAsno = event.target.querySelector('input[name="ccbaAsno"]').value;
	let ccbaCtcd = event.target.querySelector('input[name="ccbaCtcd"]').value;
	let detailData = {
		ccbaKdcd: ccbaKdcd,
		ccbaAsno: ccbaAsno,
		ccbaCtcd: ccbaCtcd,
	}
	// POST 요청 보내기
	fetch('/heritage/item/search/detail', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(detailData)
	})
		.then(response => {
			return response.json();
		})
		.then(data => {
			for (let i = 0; i < data.length; i++) {
				let item = data[i];
				let markerLongitude = Number(item.longitude);
				let markerLatitude = Number(item.latitude);
				let moveLatLon = new kakao.maps.LatLng(markerLatitude, markerLongitude);
				marker2.setPosition(moveLatLon);
				marker2.setMap(map);
				map.panTo(moveLatLon);

				//문화재 설명 컨텐츠 창
				var content2 = `
          
    <div class="bAddr"
    style="overflow: hidden; width:800px; background-color:#f5f5f5; border:2px solid rgb(140, 145, 236); max-height:600px; padding:10px;">
    <div style="float:left; width: 49%; height:100%;">
      <div style="height:10%; width: 100%; font-size:1.2em; font-weight:800;">
        ${item.ccbaMnm1}
        <p style="font-size:0.8em; font-weight: 800;">${item.ccmaName}</p>
      </div>
      <div style="height: 40%; width:100%; font-size:0.6em; color:gray; margin-bottom: 10px;">
        리뷰(<span style='color:blue;'>13</span>)<br>${star2}
        <br>
        여기가 코멘트 창
      </div>
      <div id="scrollBarDesign" style="width:100%; max-height:350px; font-size:0.7em; overflow: auto; border:2px solid rgba(140, 145, 236, 0.5); padding: 1%; text-align: justify;">
        ${item.content}
      </div>
    </div>
    <div style="float:right; width: 49%; height: 100%; margin-left: 2%; ">
      <div style="width:100%; position:relative;">
        <p style="width:100%; vertical-align:middle; position:absolute; top:0%; transform:translateY(-0%);"><img style="width:100%;object-fit: contain;" src="${item.imageUrl}"></p>
      </div>
    </div>
  </div>
  
        	    `;

				infowindow2.setContent(content2);
				infowindow2.open(map, marker2);

			}
		}).catch(error => {
			alert(`관리자에게 문의해주세요\n${error}`);
		});
}
// 별점
var star2 = `
  <fieldset class="rate">
  <input type="radio" id="rating10" name="rating" value="10"><label for="rating10" title="5점"></label>
  <input type="radio" id="rating9" name="rating" value="9"><label class="half" for="rating9" title="4.5점"></label>
  <input type="radio" id="rating8" name="rating" value="8"><label for="rating8" title="4점"></label>
  <input type="radio" id="rating7" name="rating" value="7"><label class="half" for="rating7" title="3.5점"></label>
  <input type="radio" id="rating6" name="rating" value="6"><label for="rating6" title="3점"></label>
  <input type="radio" id="rating5" name="rating" value="5"><label class="half" for="rating5" title="2.5점"></label>
  <input type="radio" id="rating4" name="rating" value="4"><label for="rating4" title="2점"></label>
  <input type="radio" id="rating3" name="rating" value="3"><label class="half" for="rating3" title="1.5점"></label>
  <input type="radio" id="rating2" name="rating" value="2"><label for="rating2" title="1점"></label>
  <input type="radio" id="rating1" name="rating" value="1"><label class="half" for="rating1" title="0.5점"></label>
  </fieldset>
`;



// 마커2 클릭 시 마커 지워짐
kakao.maps.event.addListener(marker2, 'click', function() {
	// marker2 지우기
	marker2.setMap(null);
	infowindow2.close();
});

