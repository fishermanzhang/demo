package com.zhq.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.zhq.dao.UserDao;
import com.zhq.entity.User;
/**
 * Created by lenovo on 2015/11/5.
 * @author 张洪强
 */
@SessionAttributes(value={"user"},types={String.class})
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserDao userDao;
	/**
	 * 查询所有用户
	 */
	/*@RequestMapping("/index")
	public String test(Model model){
		String password="123";
		model.addAttribute("password", password);
		return "helloThymeleaf";
	}*/

	/**
	 * 查询所有用户
	 */
	@RequestMapping("/index")
	public String queryUser(HttpServletRequest req){
		List<User> userList=(List<User>)userDao.findAll();
		req.setAttribute("userList", userList);
		return "listUser";
	}
	
	/**
	 * 转到添加界面
	 */
	@RequestMapping(value="/toAdd",method = RequestMethod.GET)
	public String toAdd(Model model){
		model.addAttribute("user", new User());
		return "add";
	}
	/**
	 * 添加用户
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Model model,User user){
		model.addAttribute("user", user);
		userDao.save(user);
		return "redirect:/user/index";
	}
	/**
	 * 转到修改界面
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate(HttpServletRequest req,Long userId){
		User user=userDao.findOne(userId);
		req.setAttribute("user1", user);
		return "userInfo";
	}
	/**
	 * 对修改的用户进行保存
	 */
	/*@RequestMapping(value="/update")
	public String update(Long userId,String username,String password){
		User user=userDao.findOne(userId);
		user.setUsername(username);
		user.setPassword(password);
		userDao.save(user);
		return "redirect:/user/index";
	}*/
	/**
	 * 对修改的用户进行保存
	 */
	@RequestMapping(value="/update")
	public String update(User user){
		userDao.save(user);
		return "redirect:/user/index";
	}
	/**
	 * 删除用户
	 */
	@RequestMapping("/delete")
	public String  delete(HttpServletRequest req,Long userId,HttpServletResponse rep){
		User user=userDao.findOne(userId);
		userDao.delete(user);
		List<User> userList=(List<User>)userDao.findAll();
		req.setAttribute("userList", userList);			
		return "listUser";
	}
}
