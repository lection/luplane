package action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.GameHouse;
import model.GameHouseManager;
import model.User;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;

public class CometAction{
	private JSONObject jsonObject;
	private GameHouseManager gameHouseManager;
	private User user;
	
	public String test() throws Exception{
		Thread.sleep(120000);
		
		jsonObject = JSONObject.fromObject("{'success':"+new Date().getTime()+"}");
		return "json";
	}
	
	public String userInfo(){
		User user = (User)ActionContext.getContext().getSession().get(TestAction.USER_SESSION_KEY);
		GameHouse gameHouse = user.getGameHouse();
		this.user = gameHouse.getInfoUser(user);
//		if(this.user == null){
//			try {
//				Thread.sleep(120000);
//			} catch (InterruptedException e) {
//				this.user = gameHouse.getInfoUser(user);
//			}			
//		}
		return "userInfo";
	}
	
	public String gaming_begin(){
		User user = (User)ActionContext.getContext().getSession().get(TestAction.USER_SESSION_KEY);
		GameHouse gameHouse = user.getGameHouse();
		if(gameHouse.getPlaneCount(gameHouse.getOwner())==3
			&& gameHouse.getPlaneCount(gameHouse.getCaller())==3){
			jsonObject = JSONObject.fromObject("{success:"+
					(gameHouse.getOwner()==user?1:2) + "}");
		}else{
			jsonObject = JSONObject.fromObject("{wait:1}");
		}
		
		return "json";
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public void setGameHouseManager(GameHouseManager gameHouseManager) {
		this.gameHouseManager = gameHouseManager;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
