package action;

import java.util.Date;
import java.util.logging.Logger;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 5800217820384651399L;
	
	private UserService userService;
	
	private Integer xn_sig_user;
	private Date xn_sig_time;
	public String grant(){
		System.out.println("---------------------");
		try{
			userService.save(xn_sig_user.longValue());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String revoke(){
		
		return SUCCESS;
	}

	public Integer getXn_sig_user() {
		return xn_sig_user;
	}

	public void setXn_sig_user(Integer xn_sig_user) {
		this.xn_sig_user = xn_sig_user;
	}

	public Date getXn_sig_time() {
		return xn_sig_time;
	}

	public void setXn_sig_time(long xn_sig_time) {
		this.xn_sig_time = new Date(xn_sig_time);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
