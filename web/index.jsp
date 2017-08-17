<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'login.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
<h2 align="center">后台管理</h2>
<form action="JspLoginServlet" method="post">
    <table align="center" width="350" border="0" cellpadding="0"
           cellspacing="0" bgcolor=#0000ff height="200">
        <tr>
            <td align="right" width="150">用户名：</td>
            <td align="left" width="200">
                <input type="text" name="userName" width="150" placeholder="请输入用户名"/>
            </td>
        </tr>

        <tr>
            <td align="right" width="150">密码是：</td>
            <td align="left" width="200">
                <input type="password" name="userPassword" width="150" placeholder="请输入密码"/>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="登录" width="80"/>
            </td>
        </tr>

    </table>

</form>
</body>
</html>