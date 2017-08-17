<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.express.dao.SendDao" %>
<%@ page import="com.express.bean.Send" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

    <title>My JSP 'show_message.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <!--
<link rel="stylesheet" type="text/css" href="styles.css">
    <meta http-equiv="description" content="This is my page">
-->
    <style type="text/css">
        body {
            font-weight: normal;
            font-variant: normal;
            font-style: normal;
            font-size: 11px;
            font-family: auto, "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
            color: #4f6b72;
            background: #E6EAE9;
        }

        a {
            color: #c75f3e;
        }

        #mytable {
            width: 700px;
            padding: 0;
            margin: 0;
        }

        caption {
            padding: 0 0 5px 0;
            width: 700px;
            font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
            text-align: right;
        }

        th {
            font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
            color: green;
            border-right: 1px solid #C1DAD7;
            border-bottom: 1px solid #C1DAD7;
            border-top: 1px solid #C1DAD7;
            letter-spacing: 2px;
            text-transform: uppercase;
            padding: 6px 6px 6px 12px;
            background: #CAE8EA no-repeat;
        }

        th.nobg {
            border-top: 0;
            border-left: 0;
            border-right: 1px solid #C1DAD7;
            background: none;
        }

        td {
            border-right: 1px solid #C1DAD7;
            border-bottom: 1px solid #C1DAD7;
            background: #fff;
            font-size: 14px;
            padding: 6px 6px 6px 12px;
            color: #4f6b72;
        }

        td.alt {
            background: #F5FAFA;
            color: #797268;
        }

        th.spec {
            border-left: 1px solid #C1DAD7;
            border-top: 0;
            background: #fff no-repeat;
            font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
        }

        th.specalt {
            border-left: 1px solid #C1DAD7;
            border-top: 0;
            background: #f5fafa no-repeat;
            font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
            color: #797268;
        }

        /*---------for IE 5.x bug*/
        html > body td {
            font-size: 14px;
            text-align: center;
            min-width: 50px;
        }

        body, td, th {
            font-family: 宋体, Arial;
            font-size: 14px;
        }
    </style>
    <c:if test="${empty sessionScope.userMessger }">
        <c:redirect url="index.jsp"/>
    </c:if>
</head>
<body>
<h3>
    &nbsp; 所有快件信息展现中心
</h3>
<table id="mytable" cellspacing="0">
    <caption>
    </caption>
    <tr>
        <th scope="col">SID</th>
        <th scope="col">快递公司</th>
        <th scope="col">姓名</th>
        <th scope="col">电话</th>
        <th scope="col">派送地址</th>
        <th scope="col">订单状态</th>

        <th scope="col" width="50">操作</th>
    </tr>
    <%
        SendDao dao = new SendDao();
        List<Send> list = dao.selectAllSend();
        for (int i = 0; i < list.size(); i++) {
    %>
    <form action="UpdateSendTypeServlet">
        <tr>
            <td><%=list.get(i).getSendid()%><input type="hidden" name="sendId" value="<%=list.get(i).getSendid()%>"/></td>
            <td><%=list.get(i).getCompanyName()%></td>
            <td><%=list.get(i).getUserName()%></td>
            <td><%=list.get(i).getUserphone()%></td>
            <td style="min-width: 100px"><%=list.get(i).getUseraddress()%></td>
            <td>
                <%if (list.get(i).getSendtype() == 0){%>
                    <select name="sendType">
                        <option value="0">未揽收</option>
                        <option value="1">已揽收</option>
                    </select>
                <%}else if (list.get(i).getSendtype() == 1){%>
                    已揽收
                <%}else if (list.get(i).getSendtype() == 2){%>
                    正在派送
                <%}else {%>
                    已签收
                <%}%>
            </td>
            <td class="row">
                <%if (list.get(i).getSendtype() == 0){%>
                <button type="submit">保存修改</button>
                <%}%>
            </td>
        </tr>
    </form>
    <%}%>
</table>
</body>
</html>
