package service;

import model.GameHouse;
import model.User;
import net.sf.json.JSONObject;

public interface HouseService {
	JSONObject settingPlane(int x,int y,int sign,User user,GameHouse house);
}
