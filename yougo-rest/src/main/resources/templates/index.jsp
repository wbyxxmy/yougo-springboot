<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户登录</title>
</head>
<body bgcolor="#CED3FE">
<center>
<%
    String err=request.getParameter("err");
    if(err!=null)
    {
        if(err.equals("1"))
        {
            out.println("<h1>用户没有正常登录，请登录！</h1>");
        }
    }
%>
    <hr>
    <form action="UserManage/checkLogin" method="post" id="myform">
        <table align="center">
            <tr>
                <td>用户名：</td>
                <td><input type="text" id="username" name="userName" /></td>
            </tr>
            <tr>
                <td>  密码：</td>
                <td><input type="password" id="passwd" name="password" /></td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="登录" id="login" />&nbsp;<input type="reset" value="重置"/>
                </td>

        </table>
    </form>
    <hr>
</center>
</body>
</html>
