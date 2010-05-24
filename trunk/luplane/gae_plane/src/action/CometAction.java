package action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.GameHouseManager;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

public class CometAction implements ServletRequestAware{
	private HttpServletRequest request;
	private JSONObject jsonObject;
	private GameHouseManager gameHouseManager;
	
	public String test() throws Exception{
//		Thread.sleep(30000);
		
		jsonObject = JSONObject.fromObject("{'success':"+new Date().getTime()+"}");
		return "json";
	}

	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
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
}
