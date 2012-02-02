<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<div class="home-spot">

  <div class="page-title">
    <h1>Checkout</h1>
  </div>
  <ul>
    <li class="section allow active">

      <div class="step-title">
        <h2>Thông tin tài khoản</h2>
      </div>
      <div id="checkout-step-billing" class="step a-item">
        <fieldset>
          <logic:present name="bill">
            <table>
              <tbody id="bill">
                <tr>
                  <th width="150" height="25" style="font-weight: bold">Tên đăng nhập :</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="id" /></td>
                </tr>
                <tr>
                   <th width="150" height="25" style="font-weight: bold">Tên đại diện :</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="idCustomer" /></td>
                </tr>
                <tr>
                   <th width="150" height="25" style="font-weight: bold">Tên
                    khách hàng :</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="nameCustomer" /></td>
                </tr>
                <tr>
                  <th width="150" height="25" style="font-weight: bold">
                    Email:</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="email" /></td>
                </tr>
                <tr>
                  <th width="150" height="25" style="font-weight: bold">Số
                    điện thoại :</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="phone" /></td>
                </tr>
                <tr>
                   <th width="150" height="25" style="font-weight: bold">Địa
                    chỉ giao hàng:</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="address" /></td>
                </tr>
                <tr>
                   <th width="150" height="25" style="font-weight: bold">Ngày
                    đặt hàng :</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="dateOrder" /></td>
                </tr>
                <tr>
                  <th width="150" height="25" style="font-weight: bold">Ngày
                    giao hàng :</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="dateShip" /></td>
                </tr>
              </tbody>
            </table>

          </logic:present>


        </fieldset>

      </div></li>
  </ul>
</div>
    