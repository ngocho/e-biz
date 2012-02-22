<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div class="col-left ">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!-- <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #map_canvas { height: 100% }
      </style>
    -->
    
    
<script type="text/javascript">
$(document).ready(function(){
    $("#searchID").focus(function() {
        $("#searchID").val("");
    });
    $("#submitSearch").click(function() {
        if($("#searchID").val() == ""){
        alert("Nhập thông tin tìm kiếm");
        return false;
        }
    });
    
    $("#resetSearch").click(function() {
        $("#searchID").val("");
        $("#type option:selected").removeAttr('selected');
        $("#type").val("0").attr('selected', true);
        
        $("#attr option:selected").removeAttr('selected');
        $("#attr").val("0").attr('selected', true);
        
        $("#price option:selected").removeAttr('selected');
        $("#price").val("0").attr('selected', true);
        
        $("#status option:selected").removeAttr('selected');
        $("#status").val("1").attr('selected', true);
        
    });

});
</script>
 <div class="block block-cart">
    <div class="block-title">
      <strong><span class="whiteImPression">TÌM KIẾM</span>
      </strong>
    </div>
    <div class="block-content">
    <html:form action="/search.vn" method="GET">
    <ul>
    <li>Nhập vào:<br><html:text property="searchText" size="32" />
    </li>
    <li>Loại thực phẩm :<br>
    <html:select property="type" style="width: 190px;">
    <html:option value="0">Tất cả</html:option>
    <html:option value="1">Thực phẩm sơ chế</html:option>
    <html:option value="2">Thức ăn nấu sẵn</html:option>
    <html:option value="3">Rau xanh</html:option>
    <html:option value="4">Gia vị</html:option>
    </html:select>
    </li>
    <li>Kiểu thực phẩm:<br>
    <html:select property="attr" style="width: 190px;" >
    <html:option value="0">Tất cả</html:option>
    <html:option value="1">Kho</html:option>
    <html:option value="2">Canh, luộc</html:option>
    <html:option value="3">Xào</html:option>
    <html:option value="4">Lẩu</html:option>
    <html:option value="5">Khác</html:option>
    </html:select>
    </li>
    <li>Giá tiền: <br>
    <html:select property="price" style="width: 190px;">
    <html:option value="0">Tất cả</html:option>
    <html:option value="1">Dưới 30.000</html:option>
    <html:option value="2">30.000 - 100.000</html:option>
    <html:option value="3">100.000 - 200.000</html:option>
    <html:option value="4">Trên 200.000</html:option>
   </html:select>
    </li>
    <li>Thực phẩm:<br>
    <html:select property="status" style="width: 190px;">
    <html:option value="1">Khuyến mãi</html:option>
    <html:option value="2">Bình thường</html:option>
    <html:option value="0">Tất cả</html:option>
   </html:select>
    </li>
      <logic:present name="providerSearchParam">
    <li>Cửa hàng:<br>
     <html:select property="provider" style="width: 190px;">
     <html:option value="0">Tất cả</html:option>
    <logic:iterate id="element" name="providerSearchParam"  >
 	<html:option value="${element.loginId}"><bean:write name="element" property="loginName"/></html:option>
    </logic:iterate>
     </html:select>
    </li>
    </logic:present>
    <li>Địa điểm:<br>
    <html:select property="districtNameS"   style="width: 190px;">
    <c:if test="${user !=null}">
     <html:option value="-1">Gần nhất</html:option>
    </c:if>
    <html:option value="0">- - - - - - - Chọn quận- - - - - - - </html:option>
    <html:option value="1">1</html:option>
    <html:option value="2">2</html:option>
    <html:option value="3">3</html:option>
   <html:option value="4">4</html:option>
   <html:option value="5">5</html:option>
   <html:option value="6">6</html:option>
   <html:option value="7">7</html:option>
   <html:option value="8">8</html:option>
   <html:option value="9">9</html:option>
   <html:option value="10">10</html:option>
   <html:option value="11">11</html:option>
   <html:option value="12">12</html:option>
   <html:option value="Bình Chánh">Bình Chánh</html:option>
   <html:option value="Bình Tân">Bình Tân</html:option>
   <html:option value="Bình Thạnh">Bình Thạnh</html:option>
   <html:option value="Gò Vấp">Gò Vấp</html:option>
   <html:option value="Hóc Môn">Hóc Môn</html:option>
   <html:option value="Nhà Bè">Nhà Bè</html:option>
   <html:option value="Phú Nhuận">Phú Nhuận</html:option>
   <html:option value="Tân Bình">Tân Bình</html:option>
   <html:option value="Tân Phú">Tân Phú</html:option>
   <html:option value="Thủ Đức">Thủ Đức</html:option>
</html:select>
    </li>
    <li><input type="submit" value="Tìm kiếm" class="buttonBG" size="30px"/></li>
    </ul>
   </html:form>
    </div>
  </div>
<p class="home-callout">
 <div id="map_canvas" style="width:200px; height:300px"></div>
<p class="home-callout">
<a href=""><img src="Images/Commons/giaohang.png" width="195" height="200" border="0"></a>
</p> 
 <p class="home-callout">
<a href=""><img src="Images/Commons/mail_sms.png" width="195" height="200" border="0"></a>
</p>

<p class="home-callout">
<a href=""><img src="Images/Commons/voucher.png" width="195" height="200" border="0"></a>
</p>

</div>
