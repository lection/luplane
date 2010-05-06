package service.impl;

import model.User;
import dao.UserDao;
import service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void save(Long id) {
		try{
			User user = userDao.load(id);
			if(user == null){
				userDao.save(new User(id));
			}else{
				System.out.println(id+"已经存在");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public User loadUserById(Long id) {
		return userDao.load(id);
	}
	
	public void test(){
		System.out.println("this is service test");
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
