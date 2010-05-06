package dao.impl;

import java.util.Collection;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import util.PMF;
import model.User;
import dao.UserDao;

public class UserDaoImpl implements UserDao {

	public void save(User user) {
		PMF.getManager().makePersistent(user);
	}

	public User load(Long id) {
		try{
			return PMF.getManager().getObjectById(User.class, id);
		}catch(JDOObjectNotFoundException je){
			return null;
		}
	}

	public Integer count() {
		Query query = PMF.getManager().newQuery(User.class);
		query.setResult("count(this)");
		return (Integer)query.execute();
	}

}
