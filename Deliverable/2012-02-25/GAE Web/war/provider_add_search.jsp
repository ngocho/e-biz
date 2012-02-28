<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script type="text/javascript">
$(document).ready(function(){
	initialize1();
});
</script>
<div class="cart">
<p class="home-callout">
<logic:present name="gmDisplay" >
<c:if test="${gmDisplay == '1'}">
<bean:message key="home.search.gm1" />
 <a href="/getAddProviderList.vn" style="color:blue; text-decoration: underline;">
 <bean:message key="home.search.gm" /></a>
 </c:if>
 <c:if test="${gmDisplay == '0'}">
 <span class="impressionText" ><bean:message key="home.search.gm" /></span>
 </c:if>
</logic:present>
<div>
<strong><bean:message key="home.search.gm.from" />: </strong>
<input type="text" id="start" name="start" value=""   style="width:200px;"/>
<strong><bean:message key="home.search.gm.to" />: </strong>
 <logic:present name="providerAddList">
 <select name="end" id="end">
<logic:iterate id="element" name="providerAddList"  >
<option value="<bean:write name="element" property="address"/>">
<bean:write name="element" property="loginName"/>
</option>
</logic:iterate>
</select>
</logic:present>
<input type="button" name="view" value="<bean:message key="home.search.gm.button" />" onclick="calcRoute1();" class="buttonBG""/>
<br>
<strong><bean:message key="home.search.gm.name" />: </strong>
 <logic:present name="providerAddList">
 <select name="add" id="add">
<logic:iterate id="element" name="providerAddList"  >
<option value="<bean:write name="element" property="address"/>">
<bean:write name="element" property="loginName"/>
</option>
</logic:iterate>
</select>
<input type="button" name="view" value="<bean:message key="home.search.gm.button1" />" onclick="codeAddress();" class="buttonBG""/>
</logic:present>
<br>
</div>
<div id="map_canvas" style="width:920px; height:500px;"></div>
</div>
