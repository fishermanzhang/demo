package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.zhq.AppConfig;
import com.zhq.dao.UserDao;
import com.zhq.entity.User;
public class TestUser {
	
	@Test
	public void test() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(
				AppConfig.class);
		UserDao us= ac
				.getBean(UserDao.class);
		us.insertUser(new User(5L,"jack","1234"));
	}
    
	
	@Test
	public void del(){
		ApplicationContext ac = new AnnotationConfigApplicationContext(
				AppConfig.class);
		UserDao us= ac
				.getBean(UserDao.class);
		User user=us.getUserById(5L);
		us.deleteUser(user);
	}
	
	@Test 
	public void getAllUsers(){
		ApplicationContext ac = new AnnotationConfigApplicationContext(
				AppConfig.class);
		UserDao us= ac
				.getBean(UserDao.class);
		List<User> users=us.selectUsers();
		for (User user : users) {
			System.out.println(user);
		}
	}
}
