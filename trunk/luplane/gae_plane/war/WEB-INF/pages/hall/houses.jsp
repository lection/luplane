<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table id="gameHouses_head" width="100%">
		<thead>
			<tr>
				<th width="15%">编号</th>
				<th width="25%">房间名称</th>
				<th width="15%">状态</th>
				<th width="15%">密码</th>
				<th width="30%">操作</th>
			</tr>
		</thead>					
</table>
<div id="gameHouses_body">
<table width="100%">
	<tbody>
	<s:iterator value="houseList" id="house">
		<tr>
			<td width="15%"><s:property value="id"/></td>
			<td width="25%"><s:property value="name"/></td>
			<td width="15%"><s:if test="state==0">等待加入</s:if><s:else>开始游戏</s:else></td>
			<td width="15%"><s:if test="password!=null">加密</s:if><s:else>无密码</s:else></td>
			<td width="30%"><s:if test="state==0">
<input type="button" name="join_house" value="加入房间" onclick="fn_join_House(<s:property value="id"/>)">
			</s:if></td>
		</tr>
	</s:iterator>
	</tbody>
</table>
</div>
<div id="gameHouses_footer" width="100%">
	<a href="#">首页</a>
	<a href="#">&lt;&lt;上一页</a>
	<a href="#">下一页&gt;&gt;</a>
	<a href="#">尾页</a>
</div>