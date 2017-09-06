<%--
  Created by IntelliJ IDEA.
  User: xinjian.ye
  Date: 2017/3/26
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.yexj.yougo.rest.pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<html>
<head>
    <script type="text/javascript">
        <!--
        function askdel()
        {
            return window.confirm("你真的要删除吗？");
        }
        -->
    </script>
    <title>Title</title>
</head>
<body>
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
    <%--<a href="main.jsp">返回主界面</a>--%>
    <hr>
    <h1>用户信息列表</h1>
    <%
        //UserBeanCl ubc=new  UserBeanCl();
        //ArrayList<UserBean> al=ubc.getUsersByPage(pageNow);
        ArrayList<User> al=(ArrayList<User>)request.getAttribute("result");
    %>
    <table border="1">
        <tr bgcolor="pink"><td>用户ID</td><td>用户名</td>
            <td>密码</td><td>电子邮件</td><td>级别</td>
            <td>修改用户</td><td>删除用户</td></tr>
        <%
            String []color={"silver","pink"};
            for(int i=0;i<al.size();i++)
            {
                User ub=(User)al.get(i);
        %>
        <tr bgcolor=<%=color[i%2]%>><td><%=ub.getUserId() %></td><td><%=ub.getUserName() %></td>
            <td><%=ub.getPasswd() %></td><td><%=ub.getEmail() %></td><td><%=ub.getGrade() %></td>
            <td><a href="<%=basePath%>user/updateUser?userId=<%=ub.getUserId() %>&userName=<%=ub.getUserName()%>&passwd=<%=ub.getPasswd()%>
                            &email=<%=ub.getEmail()%>&grade=<%=ub.getGrade()%>">修改用户</a></td><td>
                <a  onclick="return askdel();" href="<%=basePath%>user/deleteUser?userId=<%=ub.getUserId()%>">删除用户</a></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        int pageNow=((Integer)request.getAttribute("pageNow")).intValue();
        if(pageNow!=1)
        {
            //显示上一页
            out.println("<a href="+basePath+"user/manageUser?pageNow="+(pageNow-1)+">上一页</a>");
        }
        int pageCount=((Integer)request.getAttribute("pageCount")).intValue();
        //显示超链接
        for(int i=1;i<=pageCount;i++)
        {
            out.println("<a href="+basePath+"user/manageUser?pageNow="+i+"> ["+i+"]</a>");
        }
        if(pageNow!=pageCount)
        {
            //显示下一页
            out.println("<a href="+basePath+"user/manageUser?pageNow="+(pageNow+1)+">下一页</a>");
        }
    %>
    <%
    %>
</center>
<hr>
</body>
</html>
