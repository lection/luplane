<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>Insert title here</title>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.1/jquery.min.js"></script>
	<style>
		.plane_menu li{
			list-style-type: none;
			float: left;
			padding: 1em;
			font-size: 14px;
		}
		
		.plane_user_info{
			margin: 5px;
		}
		.plane_user_info h4{
			padding-bottom:5px;
			border-bottom: 1px solid #D8DFEA;
			text-align: center;
		}
		.plane_user_info table tr{
			height: 30px;
		}
	</style>
	</head>
<body>
<div id="plane_center" style="border:1px solid black;">
	<div style="border:1px solid red;">
		<ul class="plane_menu" style="height:30px;">
			<li><a href="#nogo">游戏大厅</a></li>
			<li><a href="#nogo">道具商城</a></li>
		</ul>
	</div>
	<div style="height:320px;">
		<%@include file="WEB-INF/pages/hall.jsp"%>
	</div>
</div>
</body>
</html>