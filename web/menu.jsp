<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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

<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" href="css/base.css" type="text/css" />
<link rel="stylesheet" href="css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="js/menu.js"></script>


<base target="main" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <c:if test="${empty sessionScope.userMessger }">
	<c:redirect url="index.jsp"/>
 </c:if>
<body target="main">


	<table width='99%' height="100%" border='0' cellspacing='0'
		cellpadding='0'>
		<tr>
			<td style='padding-left: 3px; padding-top: 8px' valign="top">
				<dl class='bitem'>
					<dt onClick='showHide("items2_1")'>
						<b>订单处理</b>
					</dt>
					<dd style='display: block' class='sitem' id='items2_1'>
						<ul class='sitemu'>
							<li><a href="allPlace.jsp" target='frame'>查看所有代领信息</a></li>
							<li><a href="allSend.jsp" target='frame'>查看所有快件信息</a></li>
						</ul>
					</dd>
				</dl> <!-- Item 2 Start -->
				<dl class='bitem'>
					<dt onClick='showHide("items2_2")'>
						<b>信息管理</b>
					</dt>
					<dd style='display: block' class='sitem' id='items2_2'>
						<ul class='sitemu'>
							<li>
								<a href="pushFind.jsp" target='frame'>发布失务召领信息</a>
							</li>
						</ul>
					</dd>
				</dl>
			</td>
		</tr>
	</table>
</body>
</html>