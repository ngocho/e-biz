<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
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
        <html:form action="/getInforBill.vn" method="get">

    <ul class="form-list">
        <li id="billing-new-address-form">
        <fieldset class="highlight">
            <ul>
                <li class="fields"><div class="customer-name">
    <div class="field name-firstname">
        <label for="billing:firstname" class="required"><em>*</em>Họ và tên</label>
        <div class="input-box">
        <html:text size="30" property="loginName"/>
        </div>
    </div>
</div>
</li>
                <li class="fields">
                    <div class="field">
                        <label for="billing:company" class="required"><em>*</em>Điện thoại</label>
                        <div class="input-box">
                           <html:text size="30" property="phone"/>
                        </div>
                    </div>
                        </li>
                <li class="fields">
                    <div class="field">
                        <label for="billing:company">Số nhà</label>
                        <div class="input-box">
                            <html:text size="30" property="homeNumber"/>
                        </div>
                    </div>
                      <div class="field">
                        <label for="billing:email" class="required"><em>*</em>Tên đường</label>
                        <div class="input-box">
                            <input name="billing[email]" id="billing:email" title="Email Address" class="input-text validate-email required-entry" type="text">
                        </div>
                      </div>
                    </li>
                        <li class="fields">
                    <div class="field">
                        <label for="billing:company">Phường</label>
                        <div class="input-box">
                            <input id="billing:company" name="billing[company]" title="Company" class="input-text" type="text">
                        </div>
                    </div>
                     <div class="field">
                        <label for="billing:email" class="required"><em>*</em>Quận</label>
                        <div class="input-box">
                        <select name="ddlDist0" id="ddlDist0">
                         <option selected="selected" value="0"> - - - - - - - - - - - - Chọn quận- - - - - - - - - - - - - </option>
    <option value="18">1</option>
    <option value="42">2</option>
    <option value="17">3</option>
    <option value="21">4</option>
    <option value="20">5</option>
    <option value="25">6</option>
    <option value="41">7</option>
    <option value="37">8</option>
    <option value="43">9</option>
    <option value="19">10</option>
    <option value="24">11</option>
    <option value="44">12</option>
    <option value="36">Bình Chánh</option>
    <option value="39">Bình Tân</option>
    <option value="31">Bình Thạnh</option>
    <option value="38">Gò Vấp</option>
    <option value="61">Hóc Môn</option>
    <option value="63">Nhà Bè</option>
    <option value="32">Phú Nhuận</option>
    <option value="22">Tân Bình</option>
    <option value="40">Tân Phú</option>
    <option value="45">Thủ Đức</option>
</select>
                        </div>
                      </div>
                    </li>
                        <li class="fields">
                    <div class="field">
                        <label for="billing:city" class="required">Tòa nhà</label>
                        <div class="input-box">
                            <input title="City" name="billing[city]" class="input-text required-entry" id="billing:city" type="text">
                        </div>
                    </div>
                  </li>
                  <li class="fields">
                    <div class="field">
                        <label for="billing:city" class="required">Lời nhắn</label>
                        <div class="input-box">
                            <textarea style="width: 528px;" cols="8" rows="2"> </textarea>
                        </div>
                    </div>
                  </li>
           
                                                                    <li class="no-display"><input name="billing[save_in_address_book]" value="1" type="hidden"></li>
                            </ul>
            


        </fieldset>
     </li>
          <!--   <li class="control">
            <input name="billing[use_for_shipping]" id="billing:use_for_shipping_yes" value="1" checked="checked" title="Ship to this address" onclick="$('shipping:same_as_billing').checked = true;" class="radio" type="radio"><label for="billing:use_for_shipping_yes">Thanh toán qua th? ATM</label></li>
        <li class="control">
            <input name="billing[use_for_shipping]" id="billing:use_for_shipping_no" value="0" title="Ship to different address" onclick="$('shipping:same_as_billing').checked = false;" class="radio" type="radio"><label for="billing:use_for_shipping_no">Thanh toán qua c?ng thanh toán tr?c tuy?n</label>
        </li> -->
        <li>
        <button type="submit" title="Thanh toán" class="button"  ><span><span>Tiếp tục</span></span></button>
        </li>
        </ul>
        </html:form>
        <div class="buttons-set" id="billing-buttons-container">
        <p class="required">* Required Fields</p>
        <span class="please-wait" id="billing-please-wait" style="display:none;">
            <img src="Checkout%20-%20Magento%20Commerce%20Demo%20Store_files/opc-ajax-loader.gif" alt="Loading next step..." title="Loading next step..." class="v-middle"> Loading next step...        </span>
    </div>
  

</fieldset>

        </div>
    </li>
    </ul>
    </div>
