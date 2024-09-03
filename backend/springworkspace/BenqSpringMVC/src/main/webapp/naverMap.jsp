<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>간단한 지도 표시하기</title>
    <style>
        #map {
            border: 1px solid #ccc;
            justify-content: center;
            align-items: center;
        }
    </style>
    <script type="text/javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=ixrayr6fmx"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div id="map" style="width:500px;height:400px;"></div>
    <script>
    var map = new naver.maps.Map('map', {
        zoom: 5,
        center: new naver.maps.LatLng(37.3614483, 127.1114883)
    });
    var markerList = [];
    var menuLayer = $('<div style="position:absolute;z-index:10000;background-color:#fff;border:solid 1px #333;padding:10px;display:none;"></div>');
    map.getPanes().floatPane.appendChild(menuLayer[0]);
    var infoWindow = new naver.maps.InfoWindow();

    naver.maps.Event.addListener(map, 'click', function(e) {
        var marker = new naver.maps.Marker({
            position: e.coord,
            map: map
        });
        markerList.push(marker);

        naver.maps.Service.reverseGeocode({
            coords: e.coord,
        }, function(status, response) {
            if (status !== naver.maps.Service.Status.OK) {
                return alert('Something wrong!');
            }

            var result = response.v2,
                items = result.results,
                address = result.address;

            var contentString = [
                '<div class="iw_inner">',
                '   <h3>주소</h3>',
                '   <p>' + address.jibunAddress + ' | ' + address.roadAddress + '</p>',
                '</div>'
            ].join('');

            infoWindow.setContent(contentString);
            infoWindow.open(map, marker);
        });
    });

    naver.maps.Event.addListener(map, 'keydown', function(e) {
        var keyboardEvent = e.keyboardEvent,
            keyCode = keyboardEvent.keyCode || keyboardEvent.which;
        var ESC = 27;
        if (keyCode === ESC) {
            keyboardEvent.preventDefault();
            for (var i=0, ii=markerList.length; i<ii; i++) {
                markerList[i].setMap(null);
            }
            markerList = [];
            menuLayer.hide();
            infoWindow.close();
        }
    });

    naver.maps.Event.addListener(map, 'mousedown', function(e) {
        menuLayer.hide();
    });

    naver.maps.Event.addListener(map, 'rightclick', function(e) {
        var coordHtml =
            'Coord: '+ e.coord + '<br />' +
            'Point: ' + e.point + '<br />' +
            'Offset: ' + e.offset;
        menuLayer.show().css({
            left: e.offset.x,
            top: e.offset.y
        }).html(coordHtml);
        console.log('Coord: ' + e.coord.toString());
    });
    </script>
</body>
</html>