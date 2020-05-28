<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ranking</title>
<link rel="stylesheet" href="css/rankingtable.css">
<link rel="stylesheet" href="css/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome-animation/0.0.10/font-awesome-animation.css" type="text/css" media="all" />
</head>
<body class="body_ranking">
<!-- ヘッダー -->
	<div class="header_main">
		<img src="img/logo_header_tra.png" alt="titlelogo" height="40" >
	</div>
<!-- ヘッダーここまで -->
<!-- コンテンツ -->
	<div class="ranking_outside">
			<div class="rankingtitle">
				<img src="img/rankingtitle.png" alt="titlelogo" height="80">
				<div class="capybara">
				<img src="img/capybara.png" alt="capybara" height="80"></div>
			</div>

			<div class="box_ranking">

			<!-- 中西作成ランキングテーブルここから -->
	<table class="table_ranking">
			<tr>
				<th>順位</th>
				<th>キャラ名</th>
				<th>プレイ数</th>
				<th>勝利数</th>
				<th>スコア</th>
				<th>勝率</th>
			</tr>
  <tr bgcolor="#FFD700">
  	<td bgcolor="white"><img src="img/rank1.png" height="50"></td>
    <td class="rankribbon1"><c:out value="${rankList[0].name}" /></td>
    <td><c:out value="${rankList[0].playCount}"/></td>
    <td><c:out value="${rankList[0].winCount}"/></td>
    <td><c:out value="${rankList[0].score}" /></td>
    <td class="rankribbon2"><c:out value="${rankList[0].winper}"/></td>
  </tr>
  <tr bgcolor="#C0C0C0">
   	<td bgcolor="white"><img src="img/rank2.png" height="50"></td>
    <td class="rankribbon1"><c:out value="${rankList[1].name}" /></td>
    <td><c:out value="${rankList[1].playCount}"/></td>
    <td><c:out value="${rankList[1].winCount}"/></td>
    <td><c:out value="${rankList[1].score}" /></td>
    <td class="rankribbon2"><c:out value="${rankList[1].winper}"/></td>
  </tr>
  <tr bgcolor="#da744b">
   	<td bgcolor="white"><img src="img/rank3.png" height="50"></td>
    <td class="rankribbon1"><c:out value="${rankList[2].name}" /></td>
    <td><c:out value="${rankList[2].playCount}"/></td>
    <td><c:out value="${rankList[2].winCount}"/></td>
    <td><c:out value="${rankList[2].score}" /></td>
    <td class="rankribbon2"><c:out value="${rankList[2].winper}"/></td>
  </tr>
  <tr bgcolor="white">
    <td bgcolor="white"><img src="img/rank4.png" height="40"></td>
    <td class="rankribbon1"><c:out value="${rankList[3].name}" /></td>
    <td><c:out value="${rankList[3].playCount}"/></td>
    <td><c:out value="${rankList[3].winCount}"/></td>
    <td><c:out value="${rankList[3].score}" /></td>
    <td class="rankribbon2"><c:out value="${rankList[3].winper}"/></td>
  </tr>
  <tr bgcolor="white">
    <td bgcolor="white"><img src="img/rank5.png" height="40"></td>
    <td class="rankribbon1"><c:out value="${rankList[4].name}" /></td>
    <td><c:out value="${rankList[4].playCount}"/></td>
    <td><c:out value="${rankList[4].winCount}"/></td>
    <td><c:out value="${rankList[4].score}" /></td>
    <td class="rankribbon2"><c:out value="${rankList[4].winper}"/></td>
  </tr>
  <tr bgcolor="white">
    <td bgcolor="white"><img src="img/rank6.png" height="40"></td>
      <td class="rankribbon1"><c:out value="${rankList[5].name}" /></td>
    <td><c:out value="${rankList[5].playCount}"/></td>
    <td><c:out value="${rankList[5].winCount}"/></td>
    <td><c:out value="${rankList[5].score}" /></td>
    <td class="rankribbon2"><c:out value="${rankList[5].winper}"/></td>
  </tr>
  <tr bgcolor="white">
    <td bgcolor="white"><img src="img/rank7.png" height="30"></td>
         <td class="rankribbon1"><c:out value="${rankList[6].name}" /></td>
    <td><c:out value="${rankList[6].playCount}"/></td>
    <td><c:out value="${rankList[6].winCount}"/></td>
    <td><c:out value="${rankList[6].score}" /></td>
    <td class="rankribbon2"><c:out value="${rankList[6].winper}"/></td>
  </tr>
  <tr bgcolor="white">
    <td bgcolor="white"><img src="img/rank8.png" height="30"></td>
    <td class="rankribbon1"><c:out value="${rankList[7].name}" /></td>
    <td><c:out value="${rankList[7].playCount}"/></td>
    <td><c:out value="${rankList[7].winCount}"/></td>
    <td><c:out value="${rankList[7].score}" /></td>
    <td class="rankribbon2"><c:out value="${rankList[7].winper}"/></td>
  </tr>
  <tr bgcolor="white">
    <td bgcolor="white"><img src="img/rank9.png" height="30"></td>
    <td class="rankribbon1"><c:out value="${rankList[8].name}" /></td>
    <td><c:out value="${rankList[8].playCount}"/></td>
    <td><c:out value="${rankList[8].winCount}"/></td>
    <td><c:out value="${rankList[8].score}" /></td>
    <td class="rankribbon2"><c:out value="${rankList[8].winper}"/></td>
  </tr>
  <tr bgcolor="white">
    <td bgcolor="white"><img src="img/rank10.png" height="35"></td>
    <td class="rankribbon1"><c:out value="${rankList[9].name}" /></td>
    <td><c:out value="${rankList[9].playCount}"/></td>
    <td><c:out value="${rankList[9].winCount}"/></td>
    <td><c:out value="${rankList[9].score}" /></td>
    <td class="rankribbon2"><c:out value="${rankList[9].winper}"/></td>
  </tr>
  <tr bgcolor="white">
    <td bgcolor="white"><img src="img/rank11.png" height="35"></td>
    <td class="rankribbon1"><c:out value="${rankList[10].name}" /></td>
    <td><c:out value="${rankList[10].playCount}"/></td>
    <td><c:out value="${rankList[10].winCount}"/></td>
    <td><c:out value="${rankList[10].score}" /></td>
    <td class="rankribbon2"><c:out value="${rankList[10].winper}"/></td>
  </tr>
  <tr bgcolor="white">
    <td bgcolor="white"><img src="img/rank12.png" height="20"></td>
   <td class="rankribbon1"><c:out value="${rankList[11].name}" /></td>
    <td><c:out value="${rankList[11].playCount}"/></td>
    <td><c:out value="${rankList[11].winCount}"/></td>
    <td><c:out value="${rankList[11].score}" /></td>
    <td class="rankribbon2"><c:out value="${rankList[11].winper}"/></td>
  </tr>
</table>
			<!-- 中西作成ランキングテーブルここまで -->

		 		<div class="close">
					<a href="#" onClick="window.close();"><i class="fas fa-window-close fa-3x fontawesome2 faa-ring animated-hover"></i></a><p>閉じる</p><br/>
			  	</div>
	 </div>
</div>
</body>
</html>