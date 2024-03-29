package action;

import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import model.GameHouse;
import model.GameHouseManager;
import model.User;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.xiaonei.api.XiaoneiRestClient;

import dao.UserDao;

public class TestAction {
	public static final String USER_SESSION_KEY = "user_session_key";
	private static final Logger log = Logger.getLogger(TestAction.class.getName());

	private String message;
	private User user;
	private List<GameHouse> houseList;
	private GameHouseManager gameHouseManager;
	private String xn_sig_session_key;
	private Long xn_sig_user;
	private int count;
	private UserDao userDao;
	private UserService userService;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String execute(){
		HttpServletRequest req = ServletActionContext.getRequest();
		StringBuilder sb = new StringBuilder();
		Enumeration en = req.getParameterNames();
		String s = null;
		while(en.hasMoreElements()){
			s = (String)en.nextElement();
			sb.append(s+"&nbsp;"+req.getParameter(s)+"<br/>");
		}
		sb.append("<br/>共：" + userDao.count());
		message = sb.toString();
		user = (User)req.getSession().getAttribute(USER_SESSION_KEY);
		if(user==null){
			if(xn_sig_user!=null){
				user = userService.loadUserById(xn_sig_user);
			}
			if(user == null){
				user = new User();
				user.setId(System.currentTimeMillis());
				user.setExperience((int)(10000*Math.random()));
			}
			req.getSession().setAttribute(USER_SESSION_KEY, user);
		}
		houseList = gameHouseManager.listHouse(1);
		return "success";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getXn_sig_session_key() {
		return xn_sig_session_key;
	}

	public void setXn_sig_session_key(String xn_sig_session_key) {
		this.xn_sig_session_key = xn_sig_session_key;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getXn_sig_user() {
		return xn_sig_user;
	}

	public void setXn_sig_user(Long xn_sig_user) {
		this.xn_sig_user = xn_sig_user;
	}

	public List<GameHouse> getHouseList() {
		return houseList;
	}

	public void setHouseList(List<GameHouse> houseList) {
		this.houseList = houseList;
	}

	public GameHouseManager getGameHouseManager() {
		return gameHouseManager;
	}

	public void setGameHouseManager(GameHouseManager gameHouseManager) {
		this.gameHouseManager = gameHouseManager;
	}
}
