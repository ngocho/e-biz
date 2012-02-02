<%@page import="ebiz.util.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib  uri="http://java.sun.com/jstl/core" prefix="c"%>

<div class="home-spot">
                                        <div class="page-title">
    <h1>Checkout</h1>
</div>
<ul>
<li class="section allow active"> 
    
        <div class="step-title">
        <h2>Nhập thông tin cần thiết:</h2>
        </div>
        <div id="checkout-step-billing" class="step a-item" > 
        <fieldset>
        <html:form action="/createBill.vn" method="get">
        <html:hidden property="idCustomer" />
    <ul class="form-list">
        <li id="billing-new-address-form">
        <fieldset class="highlight">
            <ul>
                <li class="fields"><div class="customer-name">
    <div class="field name-firstname">
        <label  class="required"><em>*</em>Họ và tên</label>
        <div class="input-box">
        <html:text size="30" property="nameCustomer" />
        </div>
    </div>
</div>
</li>
                <li class="fields">
                    <div class="field">
                        <label  class="required"><em>*</em>Điện thoại</label>
                        <div class="input-box">
                           <html:text size="30" property="phone"/>
                        </div>
                    </div>
                        </li>
                        <li class="fields">
                    <div class="field">
                        <label  class="required"><em>*</em>Email</label>
                        <div class="input-box">
                           <html:text size="30" property="email"/>
                        </div>
                    </div>
                        </li>
                <li class="fields">
                    <div class="field">
                        <label class="required" ><em>*</em>Số nhà</label>
                        <div class="input-box">
                            <html:text size="30" property="homeNumber"/>
                        </div>
                    </div>
                      <div class="field">
                        <label  class="required"><em>*</em>Tên đường</label>
                        <div class="input-box">
                             <html:text size="30" property="streetName"/>
                        </div>
                      </div>
                    </li>
                        <li class="fields">
                    <div class="field">
                        <label  class="required" ><em>*</em>Phường</label>
                        <div class="input-box">
                              <html:text size="30" property="wardName"/>
                        </div>
                    </div>
                     <div class="field">
                        <label  class="required" class="required"><em>*</em>Quận</label>
                        <div class="input-box">
                        <html:select property="districtName" >
                          <html:option  value="0"> - - - - - - - - - - - - Chọn quận- - - - - - - - - - - - - </html:option>
     <html:option value="1">1</html:option>
     <html:option value="2">2</html:option>
    <html:option value="3">3</html:option>
    <html:option value="4">4</html:option>
    <html:option value="5">5</html:option>
    <html:option value="6">6</html:option>
    <html:option value="7">7</html:option>
    <html:option value="8">8</html:option>
    <html:option value="9">9</html:option>
    <html:option value="10">10</html:option>
    <html:option value="11">11</html:option>
    <html:option value="12">12</html:option>
    <html:option value="13">Bình Chánh</html:option>
    <html:option value="14">Bình Tân</html:option>
    <html:option value="15">Bình Thạnh</html:option>
    <html:option value="16">Gò Vấp</html:option>
    <html:option value="17">Hóc Môn</html:option>
    <html:option value="18">Nhà Bè</html:option>
    <html:option value="19">Phú Nhuận</html:option>
    <html:option value="20">Tân Bình</html:option>
    <html:option value="21">Tân Phú</html:option>
    <html:option value="22">Thủ Đức</html:option>
</html:select>
                        </div>
                      </div>
                    </li>
                        <li class="fields">
                    <div class="field">
                        <label  class="required">Tòa nhà</label>
                        <div class="input-box">
                        <html:text size="30" property="buildingName"/>
                        </div>
                    </div>
                  </li>

                  <li class="fields">
                    <div class="field">
                        <label  class="required"><em>*</em>Ngày giao hàng</label>
                        <div class="input-box">
                        <% Date date = new Date(); 
                        String s_date = CommonUtil.convertDateToString(date);
                        %>
                           <html:text size="30" property="dateShip" styleId="datepicker" value="<%=s_date%>"/>
                        </div>
                    </div>
                  </li>
                  <li class="fields">
                    <div class="field">
                        <label  class="required">Lời nhắn</label>
                        <div class="input-box">
                            <html:textarea style="width:400px;" cols="200" rows="100" property="note" />
                        </div>
                    </div>
                  </li>
                            </ul>
            


        </fieldset>
     </li>
     <li class="fields">
                    <div class="field">
                        <label  class="required">Vui lòng chọn hình thức thanh toán</label>
                       
                    </div>
                  </li>
            <li class="control">
            <html:radio  property="isPayment" value="0" /><label>   Dùng tài khoản xu để thanh toán</label></li>
        <li class="control">
             <html:radio  property="isPayment" value="1" /><label>   Thanh toán qua thẻ ATM </label></li>
         <li class="control">
              <html:radio  property="isPayment" value="2" /><label>   Thanh toán qua ngân lượng</label></li>
       
        <li>
        <button type="submit" title="Thanh toán" class="button"  ><span><span>Thanh toán</span></span></button>
        </li>
         <li>
        <button type="submit" title="Thanh toán" class="button"  ><span><span>Trở lại</span></span></button>
        </li>
        </ul>
        </html:form>
       
        
        <div class="buttons-set" id="billing-buttons-container">
        <p class="required">* Required Fields</p>
        <span class="please-wait" id="billing-please-wait" style="display:none;">
            <img src="Checkout%20-%20Magento%20Commerce%20Demo%20Store_files/opc-ajax-loader.gif" alt="Loading next step..." title="Loading next step..." class="v-middle"> Loading next step...        </span>
    </div>
  



        </div>
    </li>
    </ul>
    </div>