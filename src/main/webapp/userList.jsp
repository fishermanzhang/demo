<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript">
	function del(){
		if(confirm("确认要删除吗")){
			return true;
		}else{
			return false;
		}
	}
</script>
</head>
<body>
	<center>
			<div>
				<span style="color:#jd0;font-size:40px">用户信息名单</span>
			</div>
			<hr style="color:blue">
			<div>
				<table border="1" cellpadding="0" cellspacing="0">
					<tr style="background-color:yellow">
						<td>用户编号</td>
						<td>用户名</td>
						<td>密码</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;操作</td>
					</tr>
					<c:forEach var="user" items="${userList }" varStatus="vs">
						<c:if test="${vs.count%2==0 }">
							<tr style="background-color: red">
						</c:if>
						<c:if test="${vs.count%2!=0}">
							<tr style="background-color: green">
						</c:if>
						<td>${user.userId }</td>
						<td>${user.username }</td>
						<td>${user.password }</td>
						<td><a href="${path}/user/toUpdate?userId=${user.userId}">修改</a>||
						<a href="${path}/user/delete?userId=${user.userId}" onclick="return del()">删除</a></td>
						</tr>
					</c:forEach>
				</table>
		</div>
		<div><a href="${path}/user/toAdd">添加学生</a></div>
		<br><br>
		<a href="${path }/user/tologin">登陆</a>
	</center>
</body>
</html>


