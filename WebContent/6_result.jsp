<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Goblin Cat</title>
<link rel="stylesheet" href="css/style.css">
<script>

</script>
</head>
<body class="body_result">
	<!-- ヘッダー -->
	<div class="header-wrapper">
		<div class="header_main">
		<img src="img/logo_header_tra.png" alt="titlelogo" height="35" >
		<img src="img/arrow5.png" alt="arrow" height="35">
		</div>
	</div>
	<!-- ヘッダーここまで -->

	<!-- コンテンツ -->
	<div class="contents_result">
				<div class="torimidashi">
					<img src="img/tori5.png" alt="tori5" height="120">
		</div>
	</div>
		<!-- ボックス-->
		<div class="box_wood">
			<div class="box_result">

	<c:choose>
	<c:when test="${ result == 1}">
	<img src="img/catwin.png" class="winpic" width="350px"><br>
	<p class="text">ネズミたちの家は滅んでしまいました…。<br>
	猫側プレイヤーに2ポイント！<br></p>
	<br>
	</c:when>
	<c:otherwise>
	<img src="img/mousewin.png" class="winpic" width="350px"><br>
	<p class="text">ゴブリンキャットは逃げていきました。。。<br>
	ネズミ側プレイヤーに1ポイント！<br></p>
	<br>
	</c:otherwise>
	</c:choose>
	<c:forEach var="player" items="${player}">
	<img src ="${player.image}" width="100" />

	ワード:${player.getWord() }<br>
	</c:forEach>
			<div class="box3">
				<form action="/GoblinCat/GameServlet" method="post" name="form1">
				<% //int i=0; %>
			<c:forEach var="play" items="${play}">
				<tr><td>
				<input type="hidden" name="play"  value="${play}"/>
				</td></tr>
				<% //i++; %>
			</c:forEach>
				<input type="hidden" name="hidden" value="3">
				<a href="javascript:form1.submit()" class="btn"><button type="button"><font size="5">もう一度プレー</font></button></a>
				</form>
			</div>
			<div class="box3">
				<a href="/GoblinCat/MainServlet">
					<button type="button"><font size="5">戻る</font></button>
				</a>

					</div>
			</div>
	</div>
	<!-- コンテンツここまで -->
		<script>
    window.onload = function(){
    	ring();
    }
	function ring() {
	document.getElementById("Sound").play();
	}
	</script>
		<audio id="Sound" preload="auto">
		<source src="bgm/mazuha.mp3" >
	</audio>

</body>
</html>