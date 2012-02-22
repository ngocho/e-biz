<%@page import="ebiz.util.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
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