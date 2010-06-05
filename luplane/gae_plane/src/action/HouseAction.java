package action;

import service.HouseService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
import model.GameHouse;
import model.GameHouseManager;
import model.PlaneModel;
import model.User;

public class HouseAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6774684356659976532L;

	public static final String HOUSE_SESSION_KEY = "house_session_key";
	
	private GameHouse gameHouse;
	private GameHouseManager gameHouseManager;
	private JSONObject jsonObject;
	private HouseService houseService;
	private int sign;
	private int point_x;
	private int point_y;
	
	public String createHouse(){
		User user = (User)ActionContext.getContext().getSession().get(TestAction.USER_SESSION_KEY);
		gameHouse = gameHouseManager.createGameHouse(gameHouse.getName(), gameHouse.getPassword()
				, gameHouse.getLevel(), 
				user);
		if(gameHouse != null){
			user.setGameHouse(gameHouse);
			jsonObject = JSONObject.fromObject("{success:"+gameHouse.getId()+"}");
		}
		else
			jsonObject = JSONObject.fromObject("{error:'error'}");
		return "json";
	}
	
	public String contectHouse(){
		User user = (User)ActionContext.getContext().getSession().get(TestAction.USER_SESSION_KEY);
		gameHouse = gameHouseManager.getHouseById(gameHouse.getId());
		if(gameHouse.getOwner().getId()== user.getId() || gameHouse.getCaller().getId() == user.getId()){
			return "gameHouse";
		}else{
			addActionError("悲剧啊 gameHouse:"+gameHouse.getId()+"  User:"+gameHouse.getOwner() + "now:" + user
					+"<br>User_id"+gameHouse.getOwner().getId()+"  now_id:"+user.getId());
			return "error";
		}
	}
	
	public String joinHouse(){
		User user = (User)ActionContext.getContext().getSession().get(TestAction.USER_SESSION_KEY);
		gameHouse = gameHouseManager.getHouseById(gameHouse.getId());
		synchronized (gameHouse) {
			if(gameHouse.getCaller()==null){
				gameHouse.setCaller(user);
				user.setGameHouse(gameHouse);
				jsonObject = JSONObject.fromObject("{success:1}");
			}else{
				jsonObject = JSONObject.fromObject("{error:'房间已经有玩家提前加入'}");
			}
		}
		return "json";
	}
	
	public String settingPlane(){
		User user = (User)ActionContext.getContext().getSession().get(TestAction.USER_SESSION_KEY);
		GameHouse gameHouse = user.getGameHouse();
		jsonObject = houseService.settingPlane(point_x, point_y, sign,user,gameHouse);
		return "json";
	}
	
	public String gaming_click(){
		User user = (User)ActionContext.getContext().getSession().get(TestAction.USER_SESSION_KEY);
		GameHouse gameHouse = user.getGameHouse();
		String check = gameHouse.check(user, point_x, point_y);
		if(check == null){
			short type = gameHouse.clickPoints(user, point_x, point_y);
			switch(type){
			case PlaneModel.PLANE_HEAD:
				;break;
			}
			jsonObject = JSONObject.fromObject("{success:"
					+type+"}");
			gameHouse.changePlayer();
		}else{
			jsonObject = JSONObject.fromObject("{error:'"+check+"'}");
		}
		return "json";
	}
	
	public String gaming_receive(){
		User user = (User)ActionContext.getContext().getSession().get(TestAction.USER_SESSION_KEY);
		GameHouse gameHouse = user.getGameHouse();
		if(gameHouse.getPlayer()==user){
			if(gameHouse.getPlaneCount(user)==3){
				point_x = gameHouse.getLast_point()[0];
				point_y = gameHouse.getLast_point()[1];
				jsonObject = JSONObject.fromObject("{success:1}");
			}else{
				jsonObject = JSONObject.fromObject("{success:-1}");
			}
		}else{
			jsonObject = JSONObject.fromObject("{error:1}");
		}
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
