<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script type="text/javascript">
$(document).ready(function(){
    var value = $("#value").val();
    $("#choose option:selected").removeAttr('selected');
    $("#choose").val("/displayBill.vn?value="+value).attr('selected',true);

});
</script>
<div class="page-title category-title">
  <h1>CHI TIẾT HÓA ĐƠN</h1>
<input type="hidden"  id="value" value ="<bean:write name="user" property="isCustomerBill"/>"></input>
<select id="customer_bill" name="choose"  onchange="setLocation(this.value)">
<option value="/displayBill.vn?value=0" selected="selected">All </option>
<option value="/displayBill.vn?value=1"> Hóa đơn chưa thanh toán</option>
<option value="/displayBill.vn?value=2"> Hóa đơn chưa nhận hàng </option>
<option value="/displayBill.vn?value=3"> Hóa đơn đã thanh toán</option>
<option value="/displayBill.vn?value=4"> Hóa đơn đã nhận hàng </option>
</select>
</div>

<table  style="font-size: 10pt;margin-left: 10px;" border="1">
<tbody>
<tr>
<th>MÃ HÓA ĐƠN</th>
<th>NHÂN VIÊN</th>
<th>NGÀY ĐẶT HÀNG</th>
<th>NGÀY GIAO HÀNG</th>
<th>ĐỊA CHỈ GIAO HÀNG</th>
<th>EMAIL</th>
<th>ĐIỆN THOẠI</th>
<th>TÌNH TRẠNG</th>
<th>ĐẶT LẠI HÓA ĐƠN </th>
<th>XÓA HÓA ĐƠN</th>
</tr>
<logic:present name="bill" >
<logic:iterate id="element"  name="bill">
<tr>
<td> <bean:write name="element" property="id"/></td>
<td> <bean:write name="element" property="idEmployee"/></td>
<td><bean:write name="element" property="dateOrder"/></td>
<td><bean:write name="element" property="dateShip"/></td>
<td><bean:write name="element" property="address"/></td>
<td><bean:write name="element" property="email"/></td>
<td><bean:write name="element" property="phone"/></td>
<td><bean:write name="element" property="status"/></td>
<td><a id="reOrder" href="/reOrder.vn?id="+<bean:write name="element" property="id"/>>Đặt lại</a></td>
<td><a id="delBill" href="/reOrder.vn?id="+<bean:write name="element" property="id"/> >Xóa</a></td>
</tr>
</logic:iterate>
</logic:present>
</tbody>
</table>