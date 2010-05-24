package action;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import service.HouseService;

import com.opensymphony.xwork2.ActionContext;
import net.sf.json.JSONObject;
import model.GameHouse;
import model.GameHouseManager;
import model.User;

public class HouseAction {
	public static final String HOUSE_SESSION_KEY = "house_session_key";
	
	private GameHouse gameHouse;
	private GameHouseManager gameHouseManager;
	private JSONObject jsonObject;
	private HouseService houseService;
	private int sign;
	private int point_x;
	private int point_y;
	
	public String createHouse(){
		Map session = ActionContext.getContext().getSession();
		gameHouse = gameHouseManager.createGameHouse(gameHouse.getName(), gameHouse.getPassword()
				, gameHouse.getLevel(), 
				(User)session.get(TestAction.USER_SESSION_KEY));
		if(gameHouse != null){
			session.put(HOUSE_SESSION_KEY, gameHouse);
			jsonObject = JSONObject.fromObject("{success:"+gameHouse.getId()+"}");
		}
		else
			jsonObject = JSONObject.fromObject("{error:'error'}");
		return "json";
	}
	
	public String contectHouse(){
		User user = (User)ActionContext.getContext().getSession().get(TestAction.USER_SESSION_KEY);
		gameHouse = gameHouseManager.getHouseById(gameHouse.getId());
		if(gameHouse.getCaller() == null){
			
		}
		return "gameHouse";
	}
	
	public String settingPlane(){
		Map session = ActionContext.getContext().getSession();
		GameHouse gameHouse = (GameHouse)session.get(HouseAction.HOUSE_SESSION_KEY);
		User user = (User)session.get(TestAction.USER_SESSION_KEY);
		jsonObject = houseService.settingPlane(point_x, point_y, sign,user,gameHouse);
		return "json";
	}
	
	public GameHouse getGameHouse() {
		return gameHouse;
	}
	public void setGameHouse(GameHouse gameHouse) {
		this.gameHouse = gameHouse;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setGameHouseManager(GameHouseManager gameHouseManager) {
		this.gameHouseManager = gameHouseManager;
	}

	public HouseService getHouseService() {
		return houseService;
	}

	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

	public int getPoint_x() {
		return point_x;
	}

	public void setPoint_x(int point_x) {
		this.point_x = point_x;
	}

	public int getPoint_y() {
		return point_y;
	}

	public void setPoint_y(int point_y) {
		this.point_y = point_y;
	}
}
