<%@page import="ebiz.util.CommonConstant"%>
<%@page import="ebiz.form.OrderBillForm"%>

<%@page import="ebiz.dto.checkout.NL_Checkout"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<div class="home-spot" >
    <div class="col-2 registered-users" class="login">
        <div class="content">
            
            <h2>LỰA CHỌN HÌNH THỨC THANH TOÁN</h2>
            Số tiền Thanh toán là : <bean:write name="bill" property="sumPrice"/>  VNĐ
              <form action="/checkoutMoney.vn" method="get" >
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
                       <button type="button" title="Thanh toán"  class="button"  onclick="setLocation('/checkoutMoney.vn?checkoutOption=home')"><span>Thanh toán bằng tiền mặt tại nhà</span></button>
                        </div>
                    </li>
                    <li style="margin-top:10px;">
                        <div class="input-box">
                         <button type="button" title="Thanh toán"  class="button"  onclick="setLocation('/checkoutMoney.vn?checkoutOption=xu')"><span>Thanh toán với tài khoản Xu</span></button>
                        </div>
                    </li>
                    <%NL_Checkout nl_checkout = new NL_Checkout();
                    OrderBillForm bill =(OrderBillForm) session.getAttribute("bill");
                    String return_url ="http://12.test-kltn1.appspot.com/checkoutMoney.vn?checkoutOption=xu";
                    String receiver ="uit.mmt@gmail.com";
                    String transaction_info ="Thanh toán hóa đơn";
                    String order_code = String.valueOf(bill.getId());
                    String price = String.valueOf(bill.getSumPrice());
                    String url =  nl_checkout.buildCheckoutUrl(return_url, receiver, order_code, price, transaction_info);
                    %>
                    <li style="margin-top:10px;">
                        <div class="input-box">
                       <a href="<%=url %>">
                       <img src="Images/Commons/btn-paynow-122.png" /></a>
                        </div>
                    </li>
            </ul>
 </form>

        </div>
    </div>
</div>