<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    	<form action="${path}/user/login" method="post">
    		${requestScope.error },${sessionScope.error}
    		<br>
    		Username:<input type="text" name="username">${requestScope.nameError },${sessionScope.nameError }<br>
    		Password:<input type="password" name="password">${requestScope.passwordError },${sessionScope.passwordError }<br>
    		<input type="submit" value="登陆">
    	</form>
  </body>
</html>
