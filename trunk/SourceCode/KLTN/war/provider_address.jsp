<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<script type="text/javascript">
$(document).ready(function(){
    initialize();
    calcRoute();
    
});
</script>
<div class="cart">
<p class="home-callout">
<logic:present name="endProvider">
<div>
<strong>Bắt đầu: </strong>
<input type="text" id="start" name="start" size="300px" style="width:200px;" value="<bean:write name="startProvider"/>" /><br>
<strong>Tới: </strong>
<bean:write name="endProvider"/>
<input type="hidden" id="end"  name="end" value="<bean:write name="endProvider"/>" /><br>

<input type="button" name="view" value="Xem đường đi" onclick="calcRoute();" class="buttonBG""/>
</div>
</logic:present>

<div id="map_canvas" style="width:800px; height:500px;"></div>
</div>
