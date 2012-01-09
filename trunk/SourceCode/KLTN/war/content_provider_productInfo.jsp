<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<script type="text/javascript">
$(document).ready(function(){
    var value = $("#value").val();
    $("#choose option:selected").removeAttr('selected');
    $("#choose").val("/displayBill.vn?value="+value).attr('selected',true);

});
</script>
<div class="page-title category-title">
  <h1>DANH SACH SẢN PHẨM</h1>
<%-- <input type="hidden"  id="value" value ="<bean:write name="user" property="isCustomerBill"/>"></input> --%>
<select id="provider_product" name="choose"  onchange="setLocation(this.value)">
<option value="/displayProduct.vn?value=0" selected="selected">Tất cả </option>
<option value="/displayProduct.vn?value=1"> Sản phẩm khuyến mãi</option>
<option value="/displayProduct.vn?value=3"> Sản phẩm đã hết </option>
<option value="/displayProduct.vn?value=4"> Sản phẩm chưa bán</option>
<option value="/displayProduct.vn?value=2"> Sản phẩm không khuyến mãi</option>
</select>
</div>

<table  style="font-size: 10pt;margin-left: 10px;" border="1">
<tbody>
<tr >
<th style="font-weight: bold;">HÌNH ĐẠI DIỆN</th>
<th style="font-weight: bold;">MÃ SẢN PHẨM</th>
<th style="font-weight: bold;">TÊN SẢN PHẨM</th>
<th style="font-weight: bold;">NHÓM SẢN PHẨM</th>
<th style="font-weight: bold;">TÌNH TRẠNG SẢN PHẨM</th>
<th style="font-weight: bold;">GIÁ</th>
<th style="font-weight: bold;">GIÁ KHUYỄN MÃI</th>
<th style="font-weight: bold;">SỐ LƯỢNG</th>
<th style="font-weight: bold;">CHI TIẾT</th>
<th style="font-weight: bold;">HƯỚNG DẪN </th>
<th style="font-weight: bold;">THAY ĐỔI</th>
<th style="font-weight: bold;">XÓA </th>
</tr>
<logic:present name="providerProduct" >
<logic:iterate id="element"  name="providerProduct">
<tr>
<td> <img src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" width="30" height="30"/></td>
<td> <bean:write name="element" property="id"/></td>
<td> <bean:write name="element" property="name"/></td>
<td><bean:write name="element" property="productTypeId"/></td>
<td><bean:write name="element" property="statusName"/></td>
<td><bean:write name="element" property="price"/></td>
<td><bean:write name="element" property="promoPrice"/></td>
<td><bean:write name="element" property="number"/></td>
<td><bean:write name="element" property="detail"/></td>
<td><bean:write name="element" property="cooking"/></td>
<td><a id="reOrder" href="/reOrder.vn?id=<bean:write name="element" property="id"/>">Sửa</a></td>
<td><a id="delBill" href="/reOrder.vn?id=<bean:write name="element" property="id"/> ">Xóa</a></td>
</tr>
</logic:iterate>
</logic:present>
</tbody>
</table>