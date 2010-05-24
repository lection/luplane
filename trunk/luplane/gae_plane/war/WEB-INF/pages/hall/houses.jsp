<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table id="gameHouses" width="100%" height="14%">
		<thead>
			<tr>
				<th width="">编号</th>
				<th width="">房间名称</th>
				<th width="">状态</th>
				<th width="">密码</th>
				<th width="">操作</th>
			</tr>
		</thead>					
</table>
<table id="gameHouses" width="100%">
	<tbody>
	<s:iterator value="houseList" id="house">
		<tr>
			<td width=""><s:property value="id"/></td>
			<td width=""><s:property value="name"/></td>
			<td width=""><s:if test="state==0">等待加入</s:if><s:else>开始游戏</s:else></td>
			<td width=""><s:if test="password!=null">加密</s:if><s:else>无密码</s:else></td>
			<td width=""><s:if test="state==0">
<input type="button" name="join_house" value="加入房间" onclick="contectHouse(<s:property value="id"/>)">
			</s:if></td>
		</tr>
	</s:iterator>
	</tbody>
</table>
<table id="gameHouses" width="100%" height="5%">
	<tbody>
		<tr>
			<td>底下</td>
		</tr>
	</tbody>
</table>