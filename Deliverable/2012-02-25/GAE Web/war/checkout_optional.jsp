<%@page import="ebiz.util.CommonConstant"%>
<%@page import="ebiz.form.OrderBillForm"%>

<%@page import="ebiz.dto.checkout.NL_Checkout"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<div class="home-spot" >
    <div class="col-2 registered-users" class="login">
        <div class="content">
            
            <h2><bean:message key="checkout.optional.title" /></h2>
            <bean:message key="checkout.money" /> : <bean:write name="bill" property="sumPrice"/>  VNĐ
              <form action="/checkoutmoney.vn" method="get" >
            <ul style="margin-top:20px;margin-left: 20px;" >
              
                    <li><span style="color: red;" id="message"> <logic:messagesPresent
                                message="true">
                                <!-- display message return by action-->
                                <html:messages id="message" message="true">
                                    <bean:write name="message" />
                                </html:messages>
                            </logic:messagesPresent> <!-- display error checked by XML --> <html:messages id="error">
                                <%=error%>
                            </html:messages> </span>
                    </li>

                    <li >
                        <div class="input-box">
                       <button type="button" title="Thanh toán"  class="button"  onclick="setLocation('/checkoutmoney.vn?checkout=home')"><span><bean:message key="checkout.optional.home" /></span></button>
                        </div>
                    </li>
                    <li style="margin-top:10px;">
                        <div class="input-box">
                         <button type="button" title="Thanh toán"  class="button"  onclick="setLocation('/checkoutmoney.vn?checkout=xu')"><span><bean:message key="checkout.optional.xu" /></span></button>
                        </div>
                    </li>
                    <li style="margin-top:10px;">
                        <div class="input-box">
                       <a href="<%=(null==session.getAttribute("nganluongurl"))?"":((String)session.getAttribute("nganluongurl"))%>">
                       <img src="Images/Commons/btn-paynow-122.png" /></a>
                        </div>
                    </li>
            </ul>
 </form>

        </div>
    </div>
</div>