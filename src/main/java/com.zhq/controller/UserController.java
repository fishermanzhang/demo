package com.zhq.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zhq.dao.UserDao;
import com.zhq.entity.User;
@SessionAttributes(value={"user"},types={String.class})
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	//private UserDao userService;
	private UserDao userDao;
	/**
	 * 登陆界面
	 */
	@RequestMapping(value="/login")
	public String login(String username,String password,User user,
			Map<String,Object> map){
		//如果输入的用户名和密码输入不为空
		if(username!=""&&password!=""){
			//根据输入的用户名查出该用户
			//user=userService.getUserByName(username);
			user=userDao.findByUsername(username);
			//如果查出用户名不为空
			if(user!=null){
				//若输入密码相等
				if(password.equals(user.getPassword())){
					//登陆成功
					return "success";
				}else{
					//输入密码不相等
					String passwordError="密码输入错误";
					map.put("passwordError", passwordError);
					return "login";
				}
			}else{
				//用户名为空
				String nameError="用户名输入错误";
				map.put("nameError", nameError);
				return "login";
			}
		}else{
			//输入的用户名和密码为空
			String error="用户名或密码输入不能为空";
			map.put("error", error);
			return "login";
		}
	}
	/**
	 * 转到登陆界面
	 */
	@RequestMapping(value="/tologin",method = RequestMethod.GET)
	public String tologin(){
		return "login";
	}
	/**
	 * 查询所有用户
	 */
	/*@RequestMapping("/index")
	public String test(Model model){
		String password="123";
		model.addAttribute("password", password);
		return "helloThymeleaf";
	}*/
	@RequestMapping("/index")
	public String queryUser(HttpServletRequest req){
		List<User> userList=(List<User>)userDao.findAll();
		//List<User> userList=userService.selectUsers();
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
		/*if(result.hasErrors()){
			model.addAttribute("user", user);
			return "add";
		}
		System.out.println(result);*/
		model.addAttribute("user", user);
		//userService.insertUser(user);
		userDao.save(user);
		return "redirect:/user/index";
	}
	/**
	 * 转到修改界面
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate(HttpServletRequest req,Long userId){
	    //User user=userService.getUserById(userId);
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
		//userService.updateUser(user);
		userDao.save(user);
		return "redirect:/user/index";
	}
	/**
	 * 删除用户
	 */
	@RequestMapping("/delete")
	public String  delete(HttpServletRequest req,Long userId,HttpServletResponse rep){
		//User user=userService.getUserById(userId);
		User user=userDao.findOne(userId);
		//userService.deleteUser(user);
		userDao.delete(user);
		//List<User> userList=userService.selectUsers();
		List<User> userList=(List<User>)userDao.findAll();
		req.setAttribute("userList", userList);			
		return "listUser";
	}
}
