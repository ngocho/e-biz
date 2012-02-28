<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!-- <script type="text/javascript">
$(document).ready(function(){
    var value = $("#value").val();
    $("#choose option:selected").removeAttr('selected');
    $("#choose").val("/displayBill.vn?value="+value).attr('selected',true);

});
</script> -->
<!-- new Order -->

<div class="page-title category-title">
  <h1>CHI TIẾT HÓA ĐƠN</h1>
<%-- <input type="hidden"  id="value" value ="<bean:write name="user" property="isCustomerBill"/>"></input>
<select id="customer_bill" name="choose"  onchange="setLocation(this.value)">
<option value="/displayBill.vn?value=0" selected="selected">All </option>
<option value="/displayBill.vn?value=1"> Hóa đơn chưa thanh toán</option>
<option value="/displayBill.vn?value=2"> Hóa đơn chưa nhận hàng </option>
<option value="/displayBill.vn?value=3"> Hóa đơn đã thanh toán</option>
<option value="/displayBill.vn?value=4"> Hóa đơn đã nhận hàng </option>
</select> --%>
</div>
<logic:present name="detailBill" >
<logic:present name="flag" scope="request">
<b style="color:red">Bạn đã đặt mua thành công !!</b><br>
</logic:present>
<b><a href="/setStatusOrder.vn?type=1&id=<bean:write name="idBill"/>">ĐẶT LẠI</a></b><br>
MÃ HÓA ĐƠN : <bean:write name="idBill" /><br>
<logic:iterate id="element"  name="detailBill">
<table  style=" position:absolute;
top:270px;font-size: 10pt;margin-left: 10px;" border="1">
<tbody>
<tr>
<th>MÃ SẢN PHẨM</th>
<th>TÊN SẢN PHẨM</th>
<th>SỐ LƯỢNG</th>
<th>THÀNH TIỀN</th>
</tr>
<tr>
<td> <bean:write name="element" property="idProduct"/></td>
<td> <bean:write name="element" property="name"/></td>
<td><bean:write name="element" property="number"/></td>
<td><bean:write name="element" property="subPrice"/></td>
</tr>
</tbody>
</table>
</logic:iterate>
</logic:present>
<logic:present name="detailFlag" >
<logic:present name="detailBill" >
<logic:iterate id="element"  name="detailBill">
<span style="position:absolute;
top:170px;margin-left: 500px;font-weight: bold;">
HÓA ĐƠN MỚI</span>
<b  style="position:absolute;
top:210px;margin-left: 500px;"><a href="">ĐẶT MỚI</a></b>
<div style="position:absolute;
top:270px;margin-left: 500px;"> 

<table  style=" font-size: 10pt;color: red;" border="1">
<tbody>
<tr>
<th>MÃ SẢN PHẨM</th>
<th>TÊN SẢN PHẨM</th>
<th>SỐ LƯỢNG</th>
<th>THÀNH TIỀN</th>
</tr>
<tr>
<td> <bean:write name="element" property="idProduct"/></td>
<td> <bean:write name="element" property="name"/></td>
<td><bean:write name="element" property="number"/></td>
<td><bean:write name="element" property="subPrice"/></td>
</tr>
</tbody>
</table>
</div>
</logic:iterate>
</logic:present>
</logic:present>