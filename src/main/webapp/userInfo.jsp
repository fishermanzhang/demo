<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<form action="${path}/user/update" method="post">
  <center>
  <div>
  <table>
     <tr>
       <td>用户编号</td>
       <td>
         <input type="text" name="userId" value="${user.userId}">
       </td>
     </tr>
     <tr>
       <td>用户姓名</td>
       <td>
         <input type="text" name="username" value="${user.username}" >
       </td>
     </tr>
     <tr>
       <td>用户密码</td>
       <td>
         <input type="text" name="password" value="${user.password}">
       </td>
     </tr>
    <tr>
      <td colspan="2">
      <input type="submit" value="修改" id="btn">
      </td>
    </tr>
  
  </table>
  </div>
  </center>
  </form>
</body>
</html>