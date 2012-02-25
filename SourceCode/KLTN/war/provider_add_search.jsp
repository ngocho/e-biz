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
<a href="/displayAddProviderGM.vn" style="color:blue; text-decoration: underline;">Tìm đường đi</a> <a href="/getAddProviderList.vn" style="color:blue; text-decoration: underline;">Tìm địa chỉ cửa hàng</a>
<div>
<strong>Bắt đầu: </strong>
<input type="text" id="start" name="start" value=""   style="width:200px;"/>
<strong>Đến cửa hàng: </strong>
 <logic:present name="providerAddList">
 <select name="end" id="end">
<logic:iterate id="element" name="providerAddList"  >
<option value="<bean:write name="element" property="address"/>">
<bean:write name="element" property="loginName"/>
</option>
</logic:iterate>
</select>
</logic:present>
<input type="button" name="view" value="Tìm đường" onclick="calcRoute1();" class="buttonBG""/>
<br>
<strong>Tên cửa hàng: </strong>
 <logic:present name="providerAddList">
 <select name="add" id="add">
<logic:iterate id="element" name="providerAddList"  >
<option value="<bean:write name="element" property="address"/>">
<bean:write name="element" property="loginName"/>
</option>
</logic:iterate>
</select>
<input type="button" name="view" value="Tìm địa chỉ" onclick="codeAddress();" class="buttonBG""/>
</logic:present>
<br>
<%-- <strong>Tìm các cửa hàng tại: </strong>
                     <div class="field">
                        <label for="billing:email" class="required" ><em>*</em>Quận</label>
                        <div class="input-box">
                        <select name="districtName"  id="districtNameR">
    <option value="">- - - - - - - - - - - - Chọn quận- - - - - - - - - - - - -</option>
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
   <option value="4">4</option>
   <option value="5">5</option>
   <option value="6">6</option>
   <option value="7">7</option>
   <option value="8">8</option>
   <option value="9">9</option>
   <option value="10">10</option>
   <option value="11">11</option>
   <option value="12">12</option>
   <option value="Bình Chánh">Bình Chánh</option>
   <option value="Bình Tân">Bình Tân</option>
   <option value="Bình Thạnh">Bình Thạnh</option>
   <option value="Gò Vấp">Gò Vấp</option>
   <option value="Hóc Môn">Hóc Môn</option>
   <option value="Nhà Bè">Nhà Bè</option>
   <option value="Phú Nhuận">Phú Nhuận</option>
   <option value="Tân Bình">Tân Bình</option>
   <option value="Tân Phú">Tân Phú</option>
   <option value="Thủ Đức">Thủ Đức</option>
</html:select>
                        </div>
                      </div> --%>
</div>


<div id="map_canvas" style="width:920px; height:500px;"></div>
</div>
