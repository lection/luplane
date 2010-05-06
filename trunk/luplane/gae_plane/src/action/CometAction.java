package action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

public class CometAction implements ServletRequestAware{
	private HttpServletRequest request;
	private JSONObject jsonObject;
	
	public String test() throws Exception{
		Thread.sleep(3000);
		jsonObject = JSONObject.fromObject("{'success':"+new Date().getTime()+"}");
		return "json";
//		ServletActionContext.getResponse().setContentType("text/html");
//		ServletActionContext.getResponse().getWriter().print("{json:{\"success\":\"123123123\"}}");
//		ServletActionContext.getResponse().flushBuffer();
//		return null;
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
}
