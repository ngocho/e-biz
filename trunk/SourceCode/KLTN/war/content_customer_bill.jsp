<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<script type="text/javascript">
$(document).ready(function(){
    var value = $("#value").val();
    $("#choose option:selected").removeAttr('selected');
    $("#choose").val("/displayBill.vn?value="+value).attr('selected',true);

});
</script>
<div class="page-title category-title">
  <h1>DANH SACH HOA DON</h1>
<input type="hidden"  id="value" value ="<bean:write name="user" property="isCustomerBill"/>"></input>
<select id="customer_bill" name="choose"  onchange="setLocation(this.value)">
<option value="/displayBill.vn?value=0" selected="selected">All </option>
<option value="/displayBill.vn?value=1"> Hóa đơn chưa thanh toán</option>
<option value="/displayBill.vn?value=2"> Hóa đơn chưa nhận hàng </option>
<option value="/displayBill.vn?value=3"> Hóa đơn đã thanh toán</option>
<option value="/displayBill.vn?value=4"> Hóa đơn đã nhận hàng </option>
</select>
<br>
<span> <strong>Page: &nbsp;</strong> </span> 
 <logic:present name="pagingList" >
              <logic:iterate id="element"  name="pagingList">
                <c:choose>
                  <c:when test="${element ==1}">
                    <a
                      href="/displayBill.vn?page=<bean:write name="element" />"><bean:write
                        name="element" /></a>

                  </c:when>
                  <c:otherwise>
                   |  <a
                      href="/displayBill.vn?page=<bean:write name="element" />"><bean:write
                        name="element" /> </a>
                  </c:otherwise>
                </c:choose>


              </logic:iterate>
            </logic:present>
</div>

<table  style="font-size: 10pt;margin-left: 0px;" border="1">
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
<!-- <th>ĐẶT LẠI HÓA ĐƠN </th> -->
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
<%-- <td><a id="reOrder" href="/reOrder.vn?id=<bean:write name="element" property="id"/>">Đặt lại</a></td> --%>
<td><a id="delBill" href="/deleteBill.vn?id=<bean:write name="element" property="id"/> ">Xóa</a></td>
</tr>
</logic:iterate>
</logic:present>
</tbody>
</table>