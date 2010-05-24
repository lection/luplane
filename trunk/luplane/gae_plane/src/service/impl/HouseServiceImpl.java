package service.impl;

import java.util.Map;
import action.HouseAction;
import action.TestAction;

import com.opensymphony.xwork2.ActionContext;

import model.GameHouse;
import model.PlaneModel;
import model.User;
import net.sf.json.JSONObject;
import service.HouseService;

public class HouseServiceImpl implements HouseService {

	@Override
	public JSONObject settingPlane(int x, int y, int sign,User user,GameHouse house) {
		if(house.getPlaneCount(user) >= 3){
			return JSONObject.fromObject("{error:'不能创建过多的飞机'}");
		}
		if(!house.addPlane(user, x, y, PlaneModel.PLANE_HEAD)){
			return JSONObject.fromObject("{error:'不能覆盖之前的飞机'}");
		}
		int index_x = 0;
		int index_y = 0;
		for(int[] arr:house.getPlaneModel().getPointArray()){
			index_x = sign_x(x,arr,sign);
			index_y = sign_y(y,arr,sign);
			if(!house.addPlane(user, index_x, index_y, PlaneModel.PLANE_BODY)){
				return JSONObject.fromObject("{error:'不能覆盖之前的飞机'}");
			}
		}
		house.addPlaneCount(user);
		if(house.getPlaneCount(user) == 3){
			return JSONObject.fromObject("{success:'finish'}");
		}
		return JSONObject.fromObject("{success:'continue'}");
	}
	
	private int sign_x(int index,int[] point,int sign){
		switch(sign){
		case 0:return index+point[0];
		case 1:return index+point[1];
		case 2:return index-point[0];
		case 3:return index-point[1];
		default:return index+point[0];
		}
	}
	
	private int sign_y(int index,int[] point,int sign){
		switch(sign){
		case 0:return index+point[1];
		case 1:return index+point[0];
		case 2:return index-point[1];
		case 3:return index-point[0];
		default:return index+point[1];
		}
	}

}
