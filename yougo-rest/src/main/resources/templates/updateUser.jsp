<%--
  Created by IntelliJ IDEA.
  User: xinjian.ye
  Date: 2017/3/2
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>更新信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body bgcolor="#CED3FE">
<%--<img  src="img/th.png"/>--%>
<center>
    <%--<%--%>
        <%--//防止用户非法登录--%>
        <%--String u=(String)session.getAttribute("myName") ;--%>
        <%--if(u==null)--%>
        <%--{--%>
            <%--response.sendRedirect("index.html?err=1");--%>
            <%--return ;--%>
        <%--}--%>
    <%--%>--%>
    <hr>
    <h1>请输入用户信息</h1>
    <form action="<%=basePath%>user/toupdateUser" method="post">
        <table border="1">
            <tr><td bgcolor="pink">用户ID</td><td><input type="text" readonly="readonly" name="userId" value="${user.userId}"/></td></tr>
            <tr><td bgcolor="pink">用户名</td><td><input type="text" name="userName" value="${user.userName}"/></td></tr>
            <tr><td bgcolor="silver">密码</td><td><input type="password" name="passwd" value="${user.passwd}"/></td></tr>
            <tr><td bgcolor="pink">电子邮件</td><td><input type="text" name="email" value="${user.email}"/></td></tr>
            <tr><td bgcolor="silver">用户级别</td><td><input type="text" name="grade" value="${user.grade}"/></td></tr>
            <tr><td><input type="submit" value="修改用户"></td><td><input type="reset" value="重置"></td></tr>
        </table>
    </form>
    <a href="<%=basePath%>user/tomain">返回</a>
    <hr>
</center>
<%--<img  src="img/logo.png" />--%>
</body>
</html>