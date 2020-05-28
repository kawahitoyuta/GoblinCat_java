<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goblin Cat</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="body_standby">
	<!-- ヘッダー -->
	<div class="header-wrapper">
			<div class="header_main">
				<img src="img/logo_header_tra.png" alt="titlelogo" height="35" >
				<img src="img/arrow3.png" alt="arrow" height="35">
		</div>
	</div>
	<!-- ヘッダーここまで -->
		<!-- コンテンツ -->
	<div class="contents">
		<div class="torimidashi">
			<img src="img/tori3.png" alt="tori3" height="120">
		</div>
	</div>
		<!-- ボックス-->
		<div class="box_pop4">
			<div class="box_standby">
				<p class="text"><c:out value="${Nplayer[executeCount-1].getName() }" />
				だけワードを確認してね<br><br></p>
				<img src ="${Nplayer[executeCount-1].getImage()}" width="150" />
				<br>
				<button onclick="clickEvent()">ワードを確認する</button><br />
					<div class="box3">
						<form action="/GoblinCat/GameServlet" method="post"  name="form1">

						<%int i=0; %>
					<c:forEach var="participate" items="${participateList}">
						<tr><td>
						<input type="hidden" name="play"  value="${participate.id }"/>
						</td></tr>
						<% i++; %>
					</c:forEach>
						<a href="javascript:form1.submit()" class="btn"><button type="button"><font size="5">次へ</font></button></a>
						</form>
					</div>
			</div>
		</div>
<script>
	function clickEvent() {
		var word = "${Nplayer[executeCount-1].getWord() }";
		alert(word);
	}
</script>
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