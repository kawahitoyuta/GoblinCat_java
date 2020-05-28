<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goblin Cat</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/timer.css">

</head>
<body class="body_game">
	<!-- ヘッダー -->
	<div class="header-wrapper">
		<div class="header_main">
			<img src="img/logo_header_tra.png" alt="titlelogo" height="35" >
			<img src="img/arrow4.png" alt="arrow" height="35">
		</div>
	</div>
	<!-- ヘッダーここまで -->
	<!-- コンテンツ -->
		<div class="mousetitle">
			<img src="img/tori4.png" alt="tori4" height="120">
		</div>

	<!-- タイマー -->
	<div class="box_timer">
		<div class="timerbox">
		    <h3>Timer</h3>
		    <div class="content">
		        <p id="timer">03:00:00</p>
		    </div>
		    <div class="button" id="buttonBox">
		        <button id="start">
		            START
		        </button>
		    </div>
		</div>

    <script>
        window.onload = function(){
            document.getElementById("start").click();
            ring1();
        }
        var point;
        var sec;
        var seconds;
        var min;
        var hour;
        var start;
        var now;
        var time;
        var id;

        document.getElementById('start').addEventListener('click', function () {
            if (document.getElementById('start').innerHTML === 'START') {
                start = new Date();
                id = setInterval(goTimer, 10);
                document.getElementById('start').innerHTML = 'RESET';

                document.getElementById('buttonBox').classList.remove('button');
                document.getElementById('buttonBox').classList.add('buttonbutton');
            } else {
                clearInterval(id);
                document.getElementById('start').innerHTML = 'START';
                document.getElementById('timer').innerHTML = '03:00:00';

                document.getElementById('buttonBox').classList.remove('buttonbutton');
                document.getElementById('buttonBox').classList.add('button');
            }
        });

        var goTimer = function () {
            now = new Date();
            time = now.getTime() - start.getTime();

            point = Math.floor(time / 100);
            sec = Math.floor(time / 1000);
            min = Math.floor(sec / 60);
            hour = Math.floor(min / 60);
            seconds = Math.floor(time / 1000);

            if (seconds < 180) {
                point = 9 - (point - sec * 10);
                sec = 59 - (sec - min * 60);
                min = 2 - (min - hour * 60);

                point = addZero(point);
                sec = addZero(sec);
                min = addZero(min);

                document.getElementById('timer').innerHTML = min + ':' + sec + ':' + point;
            } else if (seconds >= 180 && seconds < 240) {
                point = point - sec * 10;
                sec = sec - min * 60;
                min = min - 3;

                point = addZero(point);
                sec = addZero(sec);
                min = addZero(min);

            } else {
                clearInterval(id);
                document.getElementById('timer').innerHTML = '03:00:00';
                document.getElementById('start').innerHTML = 'START';
                document.getElementById('buttonBox').classList.remove('buttonbutton');
                document.getElementById('buttonBox').classList.add('button');
            }
            if(document.getElementById('timer').innerHTML === '00:00:00'){
            	ringStop1();
            	ring();
            	alert("０秒になったよ");
            	document.getElementById('start').click();
            	ringStop();
            	ring1()
            }
        }
        var addZero = function (value) {
            if (value < 10) {
                value = '0' + value;
            }
            return value;
        }
        function ring() {
			document.getElementById("Sound").play();
		}
        function ring1() {
			document.getElementById("Sound1").play();
		}
        function ringStop() {
			document.getElementById("Sound").pause();
			document.getElementById("Sound").currentTime = 0;
		}
        function ringStop1() {
			document.getElementById("Sound1").pause();
			document.getElementById("Sound1").currentTime = 0;
		}



      //投票時確認JS
        function check(){
        	if(window.confirm('本当に投票しますか')){ // 確認ダイアログを表示
        		return true; // 「OK」時は送信を実行
        	}
        	else{ // 「キャンセル」時の処理

        		return false; // 送信を中止
        	}
        }


    </script>
    <!-- タイマー終わり -->
	</div>
		<!-- タイマーボックスここまで -->

				<!-- ボックス-->
		<div class="box_wood">
			<div class="box_game">

    <p class="text">ランダムで選ばれた <c:out value="${Nplayer[j].getName() }"/> から時計回り(右隣に)第一印象を発表してください。
    <p class="text">ゴブリンキャットは誰でしょう。話し合って追放しましょう。</p>

			<div class="box3">
				<form method="get"  action="/GoblinCat/GameServlet"  name="form1"  >
				   	<%  int i=0; %>
				<c:forEach var="i" begin="0" end="${Nplayer.size()-1 }" step="1">
				 		<input type="radio"  name="vote" value="${i}"<% if(i == 0){ %>checked<%} %> id="${i}"/>
				 		<label for="${i}">
				 		<!--<c:out value="${Nplayer[i].getName() }"/>-->
				 		<img src ="${Nplayer[i].getImage()}" width="100" />
				 		</label>
				 	<br>
				 	<% i++; %>
				</c:forEach>
				<input type="hidden" name="hidden" value="vote">
				<a href="javascript:form1.submit()" class="btn" onclick="return check()"><button type="button" ><font size="5">投票</font></button></a>
				</form>
			</div>
		</div>
	</div>
	<audio loop id="Sound1" preload="auto">
		<source src="bgm/mazuha.mp3" >
	</audio>
	<audio id="Sound" preload="auto">
		<source src="bgm/Mac.mp3" >
	</audio>
</body>
</html>