<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="data.Stuinfo"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>班级列表</title>
</head>
<style type="text/css">

    h1{
        font-size: 30px;
    }
    ul{
        list-style: none;

    }
    ul li{
        float: left;
        background-color: gray;
        color: red;
        align-content: center;
        text-align: center;
        vertical-align: middle;
    }
    ul li a{
        display: block;
        width: 300px;
        height:40px;
        text-decoration: none;
        font-size: 24px;

    }
    ul li a:hover{
        background-color: brown;
        color: blue;
    }
</style>
<body>
<h1 align="center" id="title">学生成绩管理系统</h1>
<hr>
<div align="center">
<ul>
    <li ><a href="choose.jsp">首页</a></li>
    <li><a href="list">成绩查询</a></li>
    <li><a href="update.jsp">成绩修改</a></li>
    <li><a href="delect.jsp">添加学生信息</a></li>
    <li><a href="delete.jsp">删除成绩</a></li>
</ul>
</div><br>
<table align="center" border=1>
<caption>软件二班成绩表</caption>
<tr>
<th>学号</th>
<th>姓名</th>
<th>C语言</th>
<th>高等数学</th>
<th>数据库</th>
<th>数据结构</th>
<th>java</th>
</tr>
<%Stuinfo st=(Stuinfo)session.getAttribute("student");
for(int i=0;i<st.getId().length;i++){
	%>
	<tr>
	<td><%=st.getId(i) %></td>
	<td><%=st.getName(i) %></td>
	<td><%=st.getClanguage(i) %></td>
	<td><%=st.getMaths(i) %></td>
	<td><%=st.getDatebase(i) %></td>
	<td><%=st.getDatastruct(i) %></td>
	<td><%=st.getJava(i) %></td>
	</tr>
	<%
}
%>
</table>
</body>
</html>