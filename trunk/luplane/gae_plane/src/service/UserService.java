package service;

import model.User;

public interface UserService {
	void save(Long id);
	User loadUserById(Long id);
	void test();
}
