package com.zhq.dao;

import com.zhq.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lenovo on 2015/11/5.
 * @author 张洪强
 */
public interface UserDao extends CrudRepository<User,Long> {

	/**
	 * 根据 name 查询 User
	 */

	User findByUsername(String username);
}
