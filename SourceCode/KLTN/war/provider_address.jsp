<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script type="text/javascript">
$(document).ready(function(){
    initialize();
    calcRoute();
    
});
</script>
<div class="cart">
<p class="home-callout">
<a href="/displayAddProviderGM.vn" style="color:blue; text-decoration: underline;">Tìm đường đi</a> <a href="/getAddProviderList.vn" style="color:blue; text-decoration: underline;">Tìm địa chỉ cửa hàng</a>

<div>
<logic:present name="gmFlag" >
<strong>Bắt đầu: </strong>
<input type="text" id="start" name="start" value="<bean:write name="startProvider"/>"   style="width:200px;"/><br>
<strong>Tới: </strong>
Cửa hàng <bean:write name="nameProvider"/> ( <bean:write name="endProvider"/> )
<input type="hidden" id="end"  name="end" value="<bean:write name="endProvider"/>" /><br></logic:present>
<logic:notPresent name="gmFlag">
<strong>Bắt đầu: </strong>
<input type="text" id="start" name="start" value=""   style="width:200px;"/><br>
<strong>Tới: </strong>
Cửa hàng 
<input type="text" id="end"  name="end" /><br>
</logic:notPresent>
<input type="button" name="view" value="Xem đường đi" onclick="calcRoute();" class="buttonBG""/>
</div>

<div id="map_canvas" style="width:800px; height:500px;"></div>
</div>
