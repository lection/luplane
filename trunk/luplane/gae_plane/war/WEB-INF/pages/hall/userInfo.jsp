<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<h4><s:if test="user != null">用户资料</s:if><s:else>等待用户加入</s:else></h4>
<table width="100%">
	<tbody>
		<tr>
			<td width="25%">等级</td>
			<td width="25%"><s:property value="user.level"/></td>
			<td width="25%">经验</td>
			<td width="25%"><s:property value="user.experience"/></td>
		</tr>
		<tr>
			<td>金钱</td>
			<td><s:property value="user.money"/></td>
			<td>胜利</td>
			<td><s:property value="user.victory"/></td>
		</tr>
		<tr>
			<td>失败</td>
			<td><s:property value="user.fail"/></td>
			<td>胜率</td>
			<td><s:property value="user.victory/(user.fail + user.victory)" default="无"/></td>
		</tr>
	</tbody>
</table>