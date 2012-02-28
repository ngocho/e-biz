<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<div class="home-spot">

  <div class="page-title">
    <h1><bean:message key="bill.title" /></h1>
  </div>
  <ul>
    <li class="section allow active">

      <div class="step-title">
        <h2 class="impressionText"><bean:message key="bill.message" /></h2>
      </div>
      <div id="checkout-step-billing" class="step a-item">
        <fieldset>
          <logic:present name="bill">
            <table>
              <tbody id="bill">
               <tr>
                  <th width="150" height="25" style="font-weight: bold"><bean:message key="bill.sum" />:</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="sumPrice" /></td>
                </tr>
                <tr>
                  <th width="150" height="25" style="font-weight: bold"><bean:message key="bill.id" />
                    :</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="id" /></td>
                </tr>
                <tr>
                   <th width="150" height="25" style="font-weight: bold"><bean:message key="bill.idCustomer" />
                    :</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="idCustomer" /></td>
                </tr>
                <tr>
                   <th width="150" height="25" style="font-weight: bold"><bean:message key="bill.nameCustomer" />
                   :</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="nameCustomer" /></td>
                </tr>
                <tr>
                  <th width="150" height="25" style="font-weight: bold">
                    <bean:message key="checkout.mail" />:</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="email" /></td>
                </tr>
                <tr>
                  <th width="150" height="25" style="font-weight: bold">
                    <bean:message key="checkout.phone" />:</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="phone" /></td>
                </tr>
                <tr>
                   <th width="150" height="25" style="font-weight: bold">
                    <bean:message key="bill.add" />:</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="address" /></td>
                </tr>
                <tr>
                   <th width="150" height="25" style="font-weight: bold">
                   <bean:message key="bill.orderDay" />:</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="dateOrder" /></td>
                </tr>
                <tr>
                  <th width="150" height="25" style="font-weight: bold"><bean:message key="checkout.dateShip" />
                     :</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="dateShip" /></td>
                </tr>
                 <tr>
                  <th width="150" height="25" style="font-weight: bold"><bean:message key="checkout.note" />:</th>
                  <td style="font-weight: bold; color: red"><bean:write
                      name="bill" property="note" /></td>
                </tr>
              </tbody>
            </table>

          </logic:present>


        </fieldset>

      </div></li>
  </ul>
</div>
