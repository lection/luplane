<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table border="1" width="98%" height="98%">
	<tbody>
		<tr>
			<td width="70%">
			<script type="text/javascript">
				function getTestJson(){
					var ajax = new Ajax(Ajax.JSON);
					ajax.ondone = function(data){
						var dom = document.getElementById("plane_div_test");
						dom.setTextValue(dom.getInnerHTML()+data.jsonObject.success);
					}
					ajax.post('http://apps.renren.com/lu_plane/jsoncomet_test.action',null,true);
				}
			</script>
				<div id="plane_div_test"></div>
				<input type="button" onclick="getTestJson();"/>
			</td>
			<td width="30%" valign="top">
				<div class="plane_user_info">
					<h4>用户资料</h4>
					<table width="100%">
						<thead>
							<tr><th width="35%"></th><th width="65%"></th></tr>
						</thead>
						<tbody>
							<tr>
								<td>等级</td>
								<td><s:property value="user.level"/></td>
							</tr>
							<tr>
								<td>经验</td>
								<td><s:property value="user.experience"/></td>
							</tr>
							<tr>
								<td>金钱</td>
								<td><s:property value="user.money"/></td>
							</tr>
							<tr>
								<td>胜利</td>
								<td><s:property value="user.victory"/></td>
							</tr>
							<tr>
								<td>失败</td>
								<td><s:property value="user.fail"/></td>
							</tr>
							<tr>
								<td>胜率</td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</td>
		</tr>
	</tbody>
</table>
