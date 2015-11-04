package com.zhq.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class MyListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent event) {
			ServletContext application=event.getServletContext();
			String path=application.getContextPath();
			application.setAttribute("path", path);
			System.out.println("监听器启动"+path);
	}
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}
}
