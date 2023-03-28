
    // 지도 구현을 위한 기본 소스값
    var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
    var options = { //지도를 생성할 때 필요한 기본 옵션
      center: new kakao.maps.LatLng(37.578559, 126.977007), //지도의 중심좌표.
      level: 3 //지도의 레벨(확대, 축소 정도)
    };
    var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

    // 일반 지도와 스카이뷰로 지도 타입을 전환 및 확대축소컨트롤
    //
    var mapTypeControl = new kakao.maps.MapTypeControl();
    // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
    // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
    map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
    // 지도 확대 축소를 제어할 수 있는 줌 컨트롤을 생성합니다
    var zoomControl = new kakao.maps.ZoomControl();
    map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);



    // 지도를 클릭한 위치에 표출할 마커와 위도 경도 값을 가져오는 스크립트 코드
    //
    var latitude = null; // 위도값
    var longitude = null; // 경도값

    // 클릭이벤트 처리
    kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
      // 클릭한 위도, 경도 정보를 가져옵니다
      var latlng = mouseEvent.latLng;
      latitude = latlng.getLat();
      longitude = latlng.getLng();
      // 마커 위치를 클릭한 위치로 옮깁니다
      marker.setPosition(latlng);
      var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
      message += '경도는 ' + latlng.getLng() + ' 입니다';
      var resultDiv = document.getElementById('clickLatlng');
      console.log(message); // 로그 확인
    });


    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new kakao.maps.services.Geocoder();

    var marker = new kakao.maps.Marker(), // 클릭한 위치를 표시할 마커입니다
      infowindow = new kakao.maps.InfoWindow({ zindex: 1 }); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다


    // 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
    searchAddrFromCoords(map.getCenter(), displayCenterInfo);

    // 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
    kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
      searchDetailAddrFromCoords(mouseEvent.latLng, function (result, status) {
        if (status === kakao.maps.services.Status.OK) {	
        	
       //=================================================================================== 	
    	 
          var star = `
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
       //=================================================================================== 	
        	
        	
          var detailAddr = !!result[0].road_address ? '<div style="font-size:0.8em;">도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
          detailAddr += '<div style="font-size:0.7em; color:gray;">지번 주소 : ' + result[0].address.address_name + '</div>';
		
          var content = `
          
        	  <div class="bAddr" style="width:500px; background:#f5f5f5; border:2px solid rgb(140, 145, 236); height:400px; padding:20px;">
        	    <p style="font-size:1.2em; font-weight:800;">문화제 이름</p>
        	    <div stlye=' overflow: hidden;'><p style="font-size:0.6em; color:gray; float: left; margin-right:5px;">리뷰(<span style='color:blue;'>13</span>)</p>${star} </div>
        	    <hr style="border:1px solid #333;">
        	    ${detailAddr}
        	    <br> <br> <br><br><br><br>
        	    <hr style="border:1px solid #333;">
        	    
        	    <div>디버깅<br>위도 : ${latitude.toFixed(6)} , 경도 : ${longitude.toFixed(6)}</div>
        	  </div>
        	`;


          // 마커를 클릭한 위치에 표시합니다 
          marker.setPosition(mouseEvent.latLng);
          marker.setMap(map);

          // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
          infowindow.setContent(content);
          infowindow.open(map, marker);
        }
      });
    });


    kakao.maps.event.addListener(map, 'idle', function () {
      searchAddrFromCoords(map.getCenter(), displayCenterInfo);
    });

    function searchAddrFromCoords(coords, callback) {
      // 좌표로 행정동 주소 정보를 요청합니다
      geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);
    }

    function searchDetailAddrFromCoords(coords, callback) {
      // 좌표로 법정동 상세 주소 정보를 요청합니다
      geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
    }

    // 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
    function displayCenterInfo(result, status) {
      if (status === kakao.maps.services.Status.OK) {
        var infoDiv = document.getElementById('centerAddr');

        for (var i = 0; i < result.length; i++) {
          // 행정동의 region_type 값은 'H' 이므로
          if (result[i].region_type === 'H') {
            infoDiv.innerHTML = result[i].address_name;
            break;
          }
        }
      }
    }
