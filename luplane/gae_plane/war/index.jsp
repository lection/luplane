<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%if(request.getParameter("xn_sig_domain")==null){ %>
	<script type="text/javascript">
    XN = {env:{domain:'renren.com',shortSiteName:'人人',siteName:'人人网'}};
    </script>
	<script type="text/javascript" src="http://s.xnimg.cn/a2/js/prototype.js"></script>
	<script type="text/javascript" src="http://s.xnimg.cn/a5476/js/compact.js"></script>
	<script type="text/javascript" src="http://s.xnimg.cn/a9176/jspro/base.js"></script>
    <script type="text/javascript">
    XN.getFileVersion(
    [
        'http://s.xnimg.cn/a7925/csspro/apps/profile.css',
        'http://s.xnimg.cn/a5777/jspro/xn.app.recommendFriend.js',
        'http://s.xnimg.cn/a7384/jspro/xn.ui.pager.js',
        'http://s.xnimg.cn/a7845/jspro/xn.ui.multiFriendSelectorBox.js',
        'http://s.xnimg.cn/a7295/csspro/module/friendSelector.css'
    ]);
    load_jebe_ads(1);
    </script>
<script type="text/javascript" src="http://s.xnimg.cn/a2252/js/api/xnjs/xnjs_config.js"></script>
<script type="text/javascript">if (XNJS_Xiaonei_Config) XNJS_Config = XNJS_Xiaonei_Config;</script>
<script type="text/javascript" src="http://s.xnimg.cn/a8178/js/api/xnjs/xnjs_dom.js"></script>
<script type="text/javascript" src="http://s.xnimg.cn/a7942/js/api/xnjs/xnjs_lib.js"></script>
<script type="text/javascript" src="http://s.xnimg.cn/a7977/jspro/xn.app.share.js"></script>
<script type="text/javascript" src="http://s.xnimg.cn/a5093/js/api/canvas.js"></script>
<script type="text/javascript" src="http://s.xnimg.cn/a8193/js/api/xnml/taglib.js"></script>
<%}%>
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
<div id="plane_center" style="border:1px solid black;">
	<div style="border:1px solid red;">
		<ul class="plane_menu" style="height:50px;">
			<li><a href="#nogo">游戏大厅</a></li>
			<li><a href="#nogo">道具商城</a></li>
		</ul>
	</div>
	<div style="height:550px;">
		<%@include file="WEB-INF/pages/hall.jsp"%>
	</div>
</div>