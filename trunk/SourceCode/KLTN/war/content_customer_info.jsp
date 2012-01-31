<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<div class="page-title category-title">
  <h1>Thông tin khách hàng</h1>
</div>
<table style="font-size: 10pt;margin-left: 10px;">
  <tbody>
    <logic:present name="user">
    <tr height="22px">
        <th>Hình đại diện</th>
        <td><bean:write name="user" property="url" />
        </td>
      </tr>
      <tr height="22px">
        <th>Tên đăng nhập:</th>
        <td><bean:write name="user" property="loginId" />
        </td>
      </tr>
      <tr height="22px">
        <th>Họ và tên:</th>
        <td><bean:write name="user" property="loginName" />
        </td>
      </tr>
      <tr height="22px">
        <th>Giới tính:</th>
        <td><bean:write name="user" property="gender" />
        </td>
      </tr>
      <tr height="22px">
        <th>Email</th>
        <td><bean:write name="user" property="email" />
        </td>
      </tr>
      <tr height="22px">
        <th>Số điện thoại</th>
        <td><bean:write name="user" property="phone" />
        </td>
      </tr>
      <tr height="22px">
        <th>Địa chỉ</th>
        <td></td>
      </tr>
      <tr height="22px">
        <th>Số nhà</th>
        <td><bean:write name="user" property="homeNumber" />
        </td>
      </tr>
      <tr height="22px">
        <th>Tòa nhà</th>
        <td><bean:write name="user" property="buildingName" />
        </td>
      </tr>
      <tr height="22px">
        <th>Tên đường</th>
        <td><bean:write name="user" property="streetName" />
        </td>
      </tr>
      <tr height="22px">
        <th>Tên phường</th>
        <td><bean:write name="user" property="wardName" />
        </td>
      </tr>
      <tr height="22px">
        <th>Tên quận</th>
        <td><bean:write name="user" property="districtName" />
        </td>
      </tr>
      <tr height="22px">
        <th>Nhận thông tin khuyến mãi qua</th>
        <td></td>
      </tr>
    </logic:present>
  </tbody>
</table>