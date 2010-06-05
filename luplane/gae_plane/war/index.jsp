<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>Insert title here</title>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery_dialog.js"></script>
	<script type="text/javascript" src="js/game.js"></script>
	<script type="text/javascript" src="js/houses.js"></script>
	<script type="text/javascript" src="js/plane.js"></script>
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
	<link href="css/jquery_dialog.css" rel="stylesheet" type="text/css" media="all"/>
	<link href="css/house.css" rel="stylesheet" type="text/css" media="all"/>
	</head>
<body>
<div id="plane_center">
	<div id="plane_menu">
		<ul style="height:30px;">
			<li><a href="#nogo">游戏大厅</a></li>
			<li><a href="#nogo">排行榜</a></li>
			<li><a href="#nogo">道具商城</a></li>
			<li><a href="#nogo">游戏说明</a></li>
		</ul>
	</div>
	<div style="height:320px;">
		<%@include file="WEB-INF/pages/hall.jsp"%>
	</div>
</div>
</body>
</html>