var dom_create_house = $("<table style='display: none;'>"+
	"<tbody><tr><td>房间名称</td><td><input type='text'/></td></tr>"+
		"<tr><td>设置密码</td><td><input type='password'/></td></tr>"+
		"<tr><td>等级限制</td><td><input type='text' value='0'/></td></tr>"+
		"<tr><td colspan='2'><input type='button' value='创建房间' name='create_button'/></td></tr></tbody></table>");
function contectHouse(house_id){
	$("#content_id").load("house_contectHouse.action?zxdf="+Math.random(),"gameHouse.id="+house_id,function(){
		var info_two = $("#info_two");
		info_two.removeClass("plane_user_ctrl").addClass("plane_user_info");
		info_two.find("h4").html("等待用户加入");
		info_two.find("table").html("");
		bind_game_td();
		fn_getHisInfo();
	});
};
function fn_getHisInfo(){
	$("#info_two").load("jsoncomet_userInfo.action?ffff="+Math.random(),function(){
		if($("#info_two").find("h4").html()=="等待用户加入"){
			setTimeout("fn_getHisInfo();",2000);
		}
	});
}
function fn_join_House(house_id){
	$.getJSON("house_joinHouse.action?pppp="+Math.random(),{"gameHouse.id":house_id},function(data){
		if(data.jsonObject.success){
			contectHouse(house_id);
		}else{
			alert(data.jsonObject.error);
		}
	});
}
var my_game_td = null;
var my_game_td_array = new Array();
var plane_map = new Object();
var plane_sign = 0;

function plane_rotation(){
	plane_sign = (plane_sign+1)%4;
}

function bind_game_td(){
	my_game_td = $("#my_game td");
	for(var i=0;i<10;i++){
		my_game_td_array[i] = new Array();
	}
	my_game_td.each(function(i){
		var index_str = $(this).attr("name");
		var index_x = parseInt(index_str.substring(0,index_str.indexOf(",")));
		var index_y = parseInt(index_str.substring(index_str.indexOf(",")+1));
		my_game_td_array[index_x][index_y] = $(this);
	});
	my_game_td.hover(function(){
		my_game_td.each(function(i){
			$(this).removeClass("game_td_head").removeClass("game_td_body");
		});
		var hover_td = $(this);
		hover_td.addClass("game_td_head");
		var index_str = hover_td.attr("name");
		var index_x = parseInt(index_str.substring(0,index_str.indexOf(",")));
		var index_y = parseInt(index_str.substring(index_str.indexOf(",")+1));
		$.each(game_plane_classic,function(){
			var index_x_inner = fn_math_sign_x(index_x,$(this));
			var index_y_inner = fn_math_sign_y(index_y,$(this));
			if(0<=index_y_inner && index_y_inner<10 && 0<=index_x_inner && index_x_inner<10){
				if(!my_game_td_array[index_x_inner][index_y_inner].hasClass("game_td_head"))
					my_game_td_array[index_x_inner][index_y_inner].addClass("game_td_body");
			}
		});
	});
	my_game_td.click(function(){
		if(confirm("确定飞机放置在这里吗？")){
			var click_td = $(this);
			if(plane_map[click_td.attr("name")]){
				alert("飞机不允许相互覆盖");
				return false;
			}
			click_td.addClass("game_td_head");
			var index_str = click_td.attr("name");
			var index_x = parseInt(index_str.substring(0,index_str.indexOf(",")));
			var index_y = parseInt(index_str.substring(index_str.indexOf(",")+1));
			var temp_arr = new Array();
			$.each(game_plane_classic,function(i){
				var index_x_inner = fn_math_sign_x(index_x,$(this));
				var index_y_inner = fn_math_sign_y(index_y,$(this));
				if(0<=index_y_inner && index_y_inner<10 && 0<=index_x_inner && index_x_inner<10){
					my_game_td_array[index_x_inner][index_y_inner].addClass("game_td_body");
					temp_arr[i]=my_game_td_array[index_x_inner][index_y_inner];
					if(plane_map[my_game_td_array[index_x_inner][index_y_inner].attr("name")]){
						alert("飞机不允许相互覆盖");
						temp_arr = null;
						return false;
					}
				}else{
					alert("飞机不限有效范围内");
					temp_arr = null;
					return false;
				}
			});
			if(temp_arr == null)return false;
			$.ajax({url:"house_settingPlane.action?hhhhh="+Math.random(), 
				async:false,
				data:{point_x:index_x,point_y:index_y,sign:plane_sign},
				dataType:"json",
				success: function(data){
				if(data.jsonObject.success){
				    temp_arr[temp_arr.length] = click_td;
				    for(var i=0;i<temp_arr.length;i++){
				    	temp_arr[i].unbind();
				    	plane_map[temp_arr[i].attr("name")] = temp_arr[i];
				    }
				    my_game_td = my_game_td.filter(function(index){
				    	for(var i=0;i<temp_arr.length;i++){
				    		if(temp_arr[i].attr("name")==$(my_game_td[index]).attr("name")){
				    			return false;
				    		}
				    	}
				    	return true;
				    });
				    if(data.jsonObject.success=="finish"){
				    	alert("飞机布置完毕");
				    	my_game_td.unbind();
				    	fn_gaming_begin();
				    }
				}else{
					alert(data.jsonObject.error);
				}
			}});
		}
	});
};

function fn_math_sign_x(index,point){
	switch(plane_sign){
	case 0:return index+point[0];
	case 1:return index+point[1];
	case 2:return index-point[0];
	case 3:return index-point[1];
	}
}
function fn_math_sign_y(index,point){
	switch(plane_sign){
	case 0:return index+point[1];
	case 1:return index+point[0];
	case 2:return index-point[1];
	case 3:return index-point[0];
	}
}
$(function(){
	dom_create_house.find("input[name='create_button']").click(function(){
		var temp_inputs = $(this).parent().parent().parent().find("input");
		$(this).unbind();
		var gameHouse = new Object();
		gameHouse.name = temp_inputs.eq(0).val();
		gameHouse.password = temp_inputs.eq(1).val();
		gameHouse.level = temp_inputs.eq(2).val();
		if(isNaN(gameHouse.level)){
			alert("等级限制，请输入数字");
			return;
		}
		$.getJSON("house_createHouse.action?qqqq="+Math.random(),{"gameHouse.name":gameHouse.name
			,"gameHouse.password":gameHouse.password,"gameHouse.level":gameHouse.level},function(data){
			if(data.jsonObject.success){
				alert("房间创建成功");
				contectHouse(data.jsonObject.success);
			}else if(data.jsonObject.error){
				alert("房间已达到最大，无法创建");				
			}
			$("#floatBox .title span").click();
		});
	});
});