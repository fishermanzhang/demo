package com.zhq.test.dao;

import com.zhq.dao.UserDao;
import com.zhq.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by lenovo on 2015/11/5.
 * @author 张洪强
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
@TransactionConfiguration(defaultRollback = true)//是否回滚测试数据
public class TestUser {

	@Resource
	private UserDao userDao;

	/**
	 * 插入数据
	 */
	@Test
	public void test() {
		userDao.save(new User(5L,"jack","1234"));
	}

	/**
	 * 删除数据
	 */
	@Test
	public void del(){
		userDao.save(new User(5L,"jack","1234"));
		User user=userDao.findByUsername("jack");
		userDao.delete(user);
	}

	/**
	 * 查询数据
	 */
	@Test
	public void listAllUsers(){
		Iterable<User> userList=userDao.findAll();
		org.junit.Assert.assertNotNull(userList);
	}
	/**
	 * 修改数据
	 */
	@Test
	public void updateUser(){
		userDao.save(new User(5L,"jack","1234"));
		User user=userDao.findByUsername("jack");
		user.setUsername("Mike");
		userDao.save(user);
		org.junit.Assert.assertNotNull(user);
	}
}
