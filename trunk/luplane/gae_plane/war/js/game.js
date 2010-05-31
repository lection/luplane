var gaming_state;
var his_game_td;
function fn_gaming_begin(){
	$.getJSON("jsoncomet_gaming_begin.action?dasfsda="+new Date().getTime(),function(data){
		if(data.jsonObject.success){
			alert("比赛开始");
			gaming_state = data.jsonObject.success;
			his_game_td = $("#his_game td");
			fn_gaming_state();
		}else if(data.jsonObject.wait){
			setTimeout("fn_gaming_begin();",2000);
		}
	});
};
function fn_gaming_state(){
	switch(gaming_state){
	case 1:{
		$("#game_state").html("轰炸飞机");
		his_game_td.click(fn_gaming_click);
		break;
	}
	case 2:{
		$("#game_state").html("等待对方轰炸");
		fn_gaming_receive();
		break;
	}
	case -1:{
		alert("您获胜了,成功炸毁对方三架飞机。卢主席口头表扬一次。");
		break;
	}
	case -2:{
		alert("很遗憾，您被炸毁了三架飞机");
		break;
	}
	}
};
function fn_gaming_click(){
	if(confirm("确定轰炸到这里吗?")){
		his_game_td.unbind();
		var click_td = $(this);
		var click_point = $(this).attr("name");
		$.getJSON("house_gaming_click.action?zzz="+new Date().getTime(),
			{point_x:click_point.substring(0,click_point.indexOf(","))
			,point_y:click_point.substring(click_point.indexOf(",")+1)},function(data){
			if(data.jsonObject.success){
				gaming_state = 2;
				switch(data.jsonObject.success){
				case 1:{
					click_td.addClass("game_td_head");
					break;
				}
				case 2:{
					click_td.addClass("game_td_body");
					break;
				}case -1:{
					click_td.addClass("game_td_another");
					break;
				}
				case -2:{
					click_td.addClass("game_td_head");
					gaming_state = -1;
					break;
				}
				}
				his_game_td = his_game_td.filter(function(index){
		    		if(click_point==$(his_game_td[index]).attr("name")){
		    			return false;
		    		}
			    	return true;
			    });
			}else{
				alert(data.jsonObject.error);
			}
			fn_gaming_state();
		});
	}
};
function fn_gaming_receive(){
	$.getJSON("house_gaming_receive.action?xxxxx="+new Date().getTime(),function(data){
		if(data.jsonObject.success){
			if(data.jsonObject.success == 1){
				my_game_td_array[data.point_x][data.point_y].addClass("game_td_dead");
				gaming_state = 1;
			}else{
				for(var i=0;i<my_game_td_array.length;i++){
					for(var j;j<my_game_td_array[i].length;j++){
						my_game_td_array[i][j].addClass("game_td_dead");
					}
				}
				gaming_state = -2;
			}
			fn_gaming_state();
			return;
		}
		setTimeout("fn_gaming_receive();",2000);
	});
};