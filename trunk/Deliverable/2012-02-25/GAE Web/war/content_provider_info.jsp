<%@page import="ebiz.util.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>"c"%>
<h1>THÔNG TIN CỬA HÀNG</h1>
<ol>
<logic:present name="formProvider" >
<li style="margin-left:10px;"> 
<span style="color:red">
<a href="/displayProductByProvider.vn?id=<bean:write name="formProvider" property="loginId"/>"/><bean:write name="formProvider" property="loginName"/></span><br>
<img src="/serveImage.vn?urlKey=<bean:write name="formProvider" property="urlAvatar"/>" width="50" height="40"/>
<br>
<bean:write name="formProvider" property="detail"/><br>
<br>
<bean:write name="formProvider" property="address"/>
</li>
</logic:present>
</ol>