package com.zhq.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * Created by lenovo on 2015/11/5.
 * @author 张洪强
 */
@WebListener
public class MyListener implements ServletContextListener{
	/**
	 * 监听器开启
	 * @param event
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
			ServletContext application=event.getServletContext();
			String path=application.getContextPath();
			application.setAttribute("path", path);
	}

	/**
	 * 监听器销毁
	 * @param event
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}
}
