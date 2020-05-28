<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoblinCat</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="body_standby">
	<!-- ヘッダー -->
	<div class="header-wrapper">
		<div class="header_main">
			<img src="img/logo_header_tra.png" alt="titlelogo" height="35" >
			<img src="img/arrow2.png" alt="arrow" height="35">
		</div>
	</div>
	<!-- ヘッダーここまで -->
	<!-- コンテンツ -->
	<div class="contents">
		<div class="torimidashi"><!-- マウス画像 -->
			<img src="img/tori2.png" alt="tori2" height="120" >
		</div>

		<!-- ボックス-->
		<div class="box_cheese">
			<div class="box_standby">
			<form action="/GoblinCat/GameServlet" method="post" name="form1">
				<%int i=0; %>
				<c:forEach var="participate" items="${participateList}">
					<tr><td>

					<input type="hidden" name="play"  value="${participate.id }"/>
					<img src ="${participate.image}" width="150" /><!-- ねずみ画像呼出 -->
					</td></tr>
					<% i++; %>
				</c:forEach>
					<div class="box3">
						<input type="hidden" name="participateCount" value=<%=i %>>
						<a href="javascript:form1.submit()" class="btn"><button type="button"><font size="5">OK!スタート！</font></button></a>
					</div>
			</form>
			<div class="box3">
						<a href="/GoblinCat/StandbyServlet" class="btn"><button type="button"><font size="5">戻る</font></button></a>
			</div>
		</div>
	</div>
			<!-- ボックスここまで -->
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