/*
package com.zhq.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.zhq.dao.UserDao;
import com.zhq.entity.User;

@Component
@Transactional
public class UserService implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSessionFactory() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<User> selectUsers() {
		String hql = "from User u";
		List<User> userList=getSessionFactory().createQuery(hql).list();
		return userList;
	}

	@Override
	public void insertUser(User user) {
		getSessionFactory().save(user);

	}

	@Override
	public void deleteUser(User user) {
		
		getSessionFactory().delete(user);
		
	}

	@Override
	public User getUserById(Long id) {
		
		return (User) getSessionFactory().get(User.class,id);
	}

	@Override
	public void updateUser(User user) {
		getSessionFactory().update(user);
		
	}

	@Override
	public User getUserByName(String name) {
		String hql = "from User u where username=:uname";
		User user = (User) getSessionFactory().createQuery(hql)
				.setString("uname", name).uniqueResult();
		return user;
	}
}
*/
