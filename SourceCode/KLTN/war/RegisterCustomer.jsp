<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>
  <%-- 
<s:form action="Register" namespace="/customer">
 
    <s:textfield label="Tên đăng nhập" name="customer.customerId" value=""/>
    <s:password key="Mật khẩu" name="customer.customerPassword" value=""/>   
    <s:submit key="Đăng kí" name="submit" />
 <s:actionerror/>
 <s:actionmessage/>
</s:form> --%>
  <html:form method="POST" action="register">
    <table>
      <tr>
        <td>Vui lòng nhập đầy đủ thông tin phía dưới</td>
      </tr>
      <tr>
        <td>Tên đăng nhập:</td>
        <td><html:text property="customerId" />
        </td>
        <td><span id="kt" onmouseover='color()' onmouseout='out()'
          onclick='new_ajax(register)'>Kiểm tra</span>
        </td>
        <td><div id="id"></div></td>
        <td align="left" class="stlerror"><html:errors
            property="customerId" />
        </td>
      </tr>

      <tr>
        <td>Mật khẩu:</td>
        <td><html:password property="customerPassword" />
        </td>
        <td align="left" class="stlerror"><html:errors
            property="customerPassword" />
        </td>
      </tr>
      <tr>
        <td>Email:</td>
        <td><html:text property="customerEmail" />
        </td>
        <td align="left" class="stlerror"><html:errors
            property="customerEmail" />
        </td>
      </tr>
      <tr>
        <td>Địa chỉ:</td>
        <td><html:text property="customerAddress" />
        </td>
        <td>
        <td align="left" class="stlerror"><html:errors
            property="customerAddress" />
        </td>
      </tr>
      <tr>
        <td></td>
        <td><html:reset property="Xóa hết " /> <html:submit
            value="Đăng kí"></html:submit>
        </td>
      </tr>
    </table>
    <font color="red">Cung cấp thêm một số thông tin của bạn</font>
  </html:form>
<a href="RegisterCustomer1.jsp">click</a>

</body>
</html>