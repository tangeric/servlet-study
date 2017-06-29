<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body>
<form action="loginTest" method="post">
<table align="center">
<caption>用户登录</caption>
<tr>
<td>用户名：</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>密码：</td>
<td><input type="password"name="password"></td>
</tr>
<tr>
<td>请选择您的工号：</td>
<td><select name="id">
<option value=1 selected>1</option>
<option value=2>2</option>
<option value=3>3</option>
</select></td>
</tr>
<tr>
<td><input type="submit" value="登录" ></td>
<td><input type="reset" value="重置"></td>
</tr>
</table>
</form>
</body>
</html>