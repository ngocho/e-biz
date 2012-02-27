<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script src="//maps.googleapis.com/maps/api/js?sensor=false&libraries=places"
      type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
    initialize();
    calcRoute();
    
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
 <a href="/displayAddProviderGM.vn" style="color:blue; text-decoration: underline;">
<bean:message key="home.search.gm1" /></a>
 <bean:message key="home.search.gm" />
 </c:if>
</logic:present>
<%-- <logic:notPresent name="gmDisplay">
<a href="/displayAddProviderGM.vn" style="color:blue; text-decoration: underline;">
<bean:message key="home.search.gm1" /></a>
 <!-- <a href="/getAddProviderList.vn" style="color:blue; text-decoration: underline;"> -->
 <bean:message key="home.search.gm" />
</logic:notPresent> --%>
<div>
<logic:present name="gmFlag" >
<strong><bean:message key="home.search.gm.from" />: </strong>
<input type="text" id="start" name="start" value="<bean:write name="startProvider"/>"   style="width:200px;"/><br>
<strong><bean:message key="home.search.gm.to" />: </strong>
 <bean:write name="nameProvider"/> ( <bean:write name="endProvider"/> )
<input type="hidden" id="end"  name="end" value="<bean:write name="endProvider"/>" /><br></logic:present>
<logic:notPresent name="gmFlag">
<strong><bean:message key="home.search.gm.from" />: </strong>
<input type="text" id="start" name="start" value=""   style="width:200px;"/><br>
<strong><bean:message key="home.search.gm.to" />: </strong>
<input type="text" id="end"  name="end" /><br>
</logic:notPresent>
<input type="button" name="view" value="<bean:message key="home.search.gm1.button" />" onclick="calcRoute();" class="buttonBG""/>
</div>

<div id="map_canvas" style="width:920px; height:500px;"></div>
</div>
