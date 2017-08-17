<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <style type="text/css">
		
		body {
			margin-left: 0px;
			margin-top: -10px;
			margin-right: 0px;
			margin-bottom: 0px;
		}
		.STYLE1 {
			color: #43860c;
			font-size: 12px;
		}
		
	</style>
	<SCRIPT type="text/javascript">
	
	</SCRIPT>
	
	


  </head>
 
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:if test="${empty sessionScope.userMessger }">
	<c:redirect url="index.jsp"/>
 </c:if>
  <body  >
 <table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
  <tr>
    <td height="9" style="line-height:9px; background-image:url(images/main_04.gif)"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="97" height="9" background="images/main_01.gif">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="47" background="images/main_09.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="38" height="47" background="images/main_06.gif">&nbsp;</td>
        <td width="59"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="29" background="images/main_07.gif">&nbsp;</td>
          </tr>
          <tr>
            <td height="18" background="images/main_14.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
              <tr>
                <td  style="width:1px;">&nbsp;</td>
                <td ><span class="STYLE1">${adminlogin.adminid}</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="155" background="images/main_08.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" valign="bottom"><img src="images/main_12.gif" width="367" height="23" border="0" usemap="#Map" /></td>
          </tr>
        </table></td>
        <td width="200" background="images/main_11.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="11%" height="23">&nbsp;</td>
            <td width="89%" valign="bottom">
            <span class="STYLE1">
          
            </span></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="5" style="line-height:5px; background-image:url(images/main_18.gif)"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="180" background="images/main_16.gif"  style="line-height:5px;">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>

<map name="Map" id="Map">
	<!-- <area shape="rect" target="frame" coords="210,2,304,20" href="user_info.jsp" />个人信息修改  -->
	<area shape="rect" coords="314,1,361,23" href="signout.jsp" target="_parent" /><!--退出 -->
	<area shape="rect" coords="160,1,304,23" href='javascript:parent.frames["frame"].location.reload();' /><!--刷新 -->
	<area shape="rect" coords="110,1,304,23" href="javascript:window.history.go(1);" /><!--前进 -->
	<area shape="rect" coords="60,1,304,23" href="javascript:window.document.frames['frame'].history.go(-1);" /><!--后退 -->
	<area shape	="rect" target="frame" coords="10,1,304,23" href="welcome.jsp" /><!--首页 -->
</map>
  
  
  </body>
</html>
