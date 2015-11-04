package com.zhq.dao;

import java.util.List;
import com.zhq.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/*public interface UserDao {
	//查询所有用户
	List<User> selectUsers();
	//添加用户
	void insertUser(User user);
	//删除用户
	void deleteUser(User user);
	//根据ID查询用户
	User getUserById(Long id);
	//修改用户
	void updateUser(User user);
	//根据姓名查询用户
	User getUserByName(String name);
}*/

public interface UserDao extends CrudRepository<User,Long>, JpaSpecificationExecutor<User> {

	/**
	 * 根据 name 查询 User
	 */

	User findByUsername(String username);
}
