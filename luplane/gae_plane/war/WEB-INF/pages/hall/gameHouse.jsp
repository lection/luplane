<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table height="15%" width="100%">
	<tbody>
		<tr align="center">
			<td>我方阵地</td>
			<td>敌方阵地</td>
		</tr>
	</tbody>
</table>
<table width="98%" height="85%" id="our_game">
	<tbody>
	<tr>
	<td width="40%">
		<table id="my_game" border="1" width="100%" height="100%">
			<%for(int i=0;i<10;i++){ %>
				<tr>
					<%for(int j=0;j<10;j++){ %>
						<td name="<%=i %>,<%=j %>">&nbsp;</td>
					<%} %>
				</tr>
			<%} %>
		</table>
	</td>
	<td width="20%">
	<input type="button" value="旋转" onclick="plane_rotation()">
	<span id="game_state">布置飞机</span>
	</td>
	<td width="40%">
		<table id="his_game" border="1" width="100%" height="100%"%>
			<%for(int i=0;i<10;i++){ %>
				<tr>
					<%for(int j=0;j<10;j++){ %>
						<td name="<%=i %>,<%=j %>">&nbsp;</td>
					<%} %>
				</tr>
			<%} %>
		</table>
	</td>
	</tr>
	</tbody>
</table>