<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<script type="text/javascript">
$(document).ready(function(){
    var value = $("#value").val();
    $("#choose option:selected").removeAttr('selected');
    $("#choose").val("/displayBillCategory.vn?value="+value).attr('selected',true);

});
</script>
<div class="page-title category-title">
  <h1>DANH SACH HOA DON</h1>
<!-- <select id="customer_bill" name="choose"  onchange="setLocation(this.value)">
<option value="/displayBillCategory.vn?value=5"  selected="selected"> Hóa đơn giao hàng trong ngày</option>
<option value="/displayBillCategory.vn?value=0">All </option>
<option value="/displayBillCategory.vn?value=4"> Hóa đơn đã giao hàng  </option>
<option value="/displayBillCategory.vn?value=5"> Hóa đơn cần giao hàng </option>
<option value="/displayBillCategory.vn?value=3"> Hóa đơn đã thanh toán</option>
<option value="/displayBillCategory.vn?value=4"> Hóa đơn đã nhận hàng </option>
</select> -->
<logic:present name="BVO"  property="billNameList" >
<select id="provider_product" name="choose"  onchange="setLocation(this.value)">
<logic:iterate id="element"  name="BVO" property="billNameList">
<c:choose>
 <c:when test="${element.id == aStatusBill}">
    <option value="/displayBillCategory.vn?value=<bean:write name="element" property="id"/>" selected="selected"><bean:write name="element" property="name"/> </option>               
 </c:when>                
                  <c:otherwise>

<option value="/displayBillCategory.vn?value=<bean:write name="element" property="id"/>"><bean:write name="element" property="name"/></option>               
                 </c:otherwise>
                </c:choose>
</logic:iterate> 
</select>
</logic:present>
<br>
<span> <strong>Page: &nbsp;</strong> </span> 
 <logic:present name="aPagingList" >
              <logic:iterate id="element"  name="aPagingList">
                <c:choose>
                  <c:when test="${element == aPageIndex}">
                    <a
                      href="/displayBillCategory.vn?page=<bean:write name="element" />">
                      <span class="keepLink"><bean:write  name="element" /></span></a>

                  </c:when>
                  <c:otherwise>
                   |  <a
                      href="/displayBillCategory.vn?page=<bean:write name="element" />"><bean:write
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
<logic:present name="billAdmin" >
<logic:iterate id="element"  name="billAdmin">
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