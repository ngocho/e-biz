<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<script type="text/javascript">
$(document).ready(function(){
/*     $(".updateShopping").click(function() {
        var index = $(this).attr('rel');
        var id = $(this).attr('name');
        var number = $("#"+index).val();
        updateNumberProduct(id,number,index);
        return false;
    }); */
    calcRoute();
    
});
</script>
<div class="cart">
<p class="home-callout">
<div>
<strong>Bắt đầu: </strong>
<input type="text" id="start" name="start" value="<bean:write name="startProvider"/>"/>
<strong>Tới: </strong>
<bean:write name="endProvider"/>
<input type="hidden" id="end"  name="end" value="<bean:write name="endProvider"/>" />
</div>
<div id="map_canvas" style="width:800px; height:500px;"></div>


</div>
