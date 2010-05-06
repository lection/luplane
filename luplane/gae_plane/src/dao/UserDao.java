package dao;

import model.User;

public interface UserDao {
	void save(User user);
	Integer count();
	User load(Long id);
}
