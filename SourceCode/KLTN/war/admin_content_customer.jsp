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
<table  style="font-size: 10pt;margin-left: 0px;" border="1">
<tbody>
<tr>
<th>TÊN ĐĂNG NHẬP</th>
<th>MẬT KHẨU</th>
<th>HỌ TÊN</th>
<th>EMAIL</th>
<th>SỐ ĐIỆN THOẠI</th>
<th>ĐỊA CHỈ</th>
<th>NHẬN KM QUA MAIL</th>
<th>NHẬN KM QUA ĐIỆN THOẠI</th>
<!-- <th>ĐẶT LẠI HÓA ĐƠN </th> -->
<th>XÓA USER</th>
</tr>
<logic:present name="customerAdmin" >
<logic:iterate id="element"  name="customerAdmin">
<tr>
<td> <bean:write name="element" property="loginId"/></td>
<td> <bean:write name="element" property="loginPassword"/></td>
<td><bean:write name="element" property="loginName"/></td>
<td><bean:write name="element" property="email"/></td>
<td><bean:write name="element" property="phone"/></td>
<td></td>
<td><bean:write name="element" property="isAdEmail"/></td>
<td><bean:write name="element" property="isAdPhone"/></td>
<%-- <td><a id="reOrder" href="/reOrder.vn?id=<bean:write name="element" property="id"/>">Đặt lại</a></td> --%>
<td><a id="delBill" href="/deleteCustomer.vn?id=<bean:write name="element" property="loginId"/> ">Xóa</a></td>
</tr>
</logic:iterate>
</logic:present>
</tbody>
</table>