<%--
  Created by IntelliJ IDEA.
  User: xinjian.ye
  Date: 2017/3/20
  Time: 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>welcome</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body bgcolor="#CED3FE">
    欢迎光临:${usersResultDTO.userName}
    <center>
        <hr>
        <h1>请选择操作</h1>
        <a href="<%=basePath%>UserManage/updateUser?userId=${usersResultDTO.userId}">修改信息</a><br>
        <a href="<%=basePath%>UserManage/addUser">添加用户</a><br>
        <a href="<%=basePath%>UserManage/manageUser?pageNow=1">管理用户</a><br>
        <hr>
    </center>
</body>
</html>
