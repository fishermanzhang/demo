<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
<body>
<form:form action="${path}/user/add" modelAttribute="user" method="post">
<center>
	<div>
 <table>
     <tr>
       <td>用户名</td>
       <td><form:input path="username"  /></td>
       <td><form:errors path="username"/></td> 
     </tr>
     <tr>
       <td>密码</td>
         <td><form:input path="password"/></td>
       <td><form:errors path="password"/></td>
     </tr>
     <tr>
       <td colspan="2">
           <input type="submit" value="添加" id="btn" name="btn">
       </td>
     </tr>
  </table>
  </div>
 </center>
 </form:form>
</body>
</html>