<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table border="1" width="100%" height="98%" class="game_hall">
	<tbody>
		<tr>
			<td width="70%" valign="top" id="content_id">
			<%@include file="hall/houses.jsp"%>
			</td>
			<td width="30%" valign="top" class="user_info">
				<div class="plane_user_info" id="info_one">
					<h4>用户资料</h4>
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
				</div>
				<div class="plane_user_ctrl" id="info_two">
					<h4>用户操作</h4>
					<table width="100%">
						<tbody>
							<tr>
								<td><input type="button" value="创建房间" onclick="createHouse()"/></td>
								<td><input type="button" value="随机进入"/></td>
							</tr>
						</tbody>
					</table>
				</div>
			</td>
		</tr>
	</tbody>
</table>