<%@page import="ebiz.util.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<link type="text/css" href="js/ui/themes/base/ui.all.css" rel="stylesheet" />
<script type="text/javascript">
    $(document).ready(function() {
        $("#checkout").click(function() {
            var flag = validateCheckoutInfo();
            if (!flag) {
                return false;
                // $("#registerForm").submit();
            }
        });
        
        $("#default").click(function() {
            var flag = updateCustomerInfo();
            if (!flag) {
                return false;
                // $("#registerForm").submit();
            }
        });
        
        $(".validated").blur(function() {
            if ($(this).val() != "") {
                $(this).css("background", "#FFF");
            }
        });
    });
</script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="js/ui/ui.datepicker_vn.js"></script>

<script type="text/javascript">
  $(function() {
      $("#datepicker").datepicker({dateFormat: 'dd/mm/yy'});
  });

</script>
<div class="home-spot">
                                        <div class="page-title">
    <h1><bean:message key="checkout.title" /></h1>
</div>
<ul>
<li class="section allow active"> 
    
        <div class="step-title">
        <h2><bean:message key="checkout.info" /></h2>
        </div>
        <div id="checkout-step-billing" class="step a-item" > 
        <html:form action="/createBill.vn" method="get">
        <html:hidden property="idCustomer" />
    <ul class="form-list">
        <li id="billing-new-address-form">
        <fieldset class="highlight">
            <ul>
                <li class="fields"><div class="customer-name">
    <div class="field name-firstname">
        <label  class="required"><em>*</em><bean:message key="checkout.fullname" /></label>
        <div class="input-box">
        <html:text size="30" property="nameCustomer" styleClass="validated"/>
        </div>
    </div>
</div>
</li>
                <li class="fields">
                    <div class="field">
                        <label  class="required"><em>*</em><bean:message key="checkout.phone" /></label>
                        <div class="input-box">
                           <html:text size="30" property="phone" styleClass="validated"/>
                        </div>
                    </div>
                        </li>
                        <li class="fields">
                    <div class="field">
                        <label  class="required"><em>*</em><bean:message key="checkout.mail" /></label>
                        <div class="input-box">
                           <html:text size="30" property="email" styleClass="validated"/>
                        </div>
                    </div>
                        </li>
                <li class="fields">
                    <div class="field">
                        <label class="required" ><em>*</em><bean:message key="customer.register.home" /></label>
                        <div class="input-box">
                            <html:text size="30" property="homeNumber" styleClass="validated"/>
                        </div>
                    </div>
                      <div class="field">
                        <label  class="required"><em>*</em><bean:message key="customer.register.street" /></label>
                        <div class="input-box">
                             <html:text size="30" property="streetName" styleClass="validated"/>
                        </div>
                      </div>
                    </li>
                        <li class="fields">
                    <div class="field">
                        <label  class="required" ><em>*</em><bean:message key="customer.register.ward" /></label>
                        <div class="input-box">
                              <html:text size="30" property="wardName" styleClass="validated"/>
                        </div>
                    </div>
                     <div class="field">
                        <label  class="required" class="required"><em>*</em><bean:message key="customer.register.district" /></label>
                        <div class="input-box">
                        <html:select property="districtName" styleId="districtName">
   <html:option value="" >- - - - - - - - - - - - <bean:message key="customer.register.district.choose" />- - - - - - - - - - - - -</html:option>
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
   <html:option value="Bình Chánh">Bình Chánh</html:option>
   <html:option value="Bình Tân">Bình Tân</html:option>
   <html:option value="Bình Thạnh">Bình Thạnh</html:option>
   <html:option value="Gò Vấp">Gò Vấp</html:option>
   <html:option value="Hóc Môn">Hóc Môn</html:option>
   <html:option value="Nhà Bè">Nhà Bè</html:option>
   <html:option value="Phú Nhuận">Phú Nhuận</html:option>
   <html:option value="Tân Bình">Tân Bình</html:option>
   <html:option value="Tân Phú">Tân Phú</html:option>
   <html:option value="Thủ Đức">Thủ Đức</html:option>
</html:select>
                        </div>
                      </div>
                    </li>
                        <li class="fields">
                    <div class="field">
                        <label  class="required"><bean:message key="customer.register.building" /></label>
                        <div class="input-box">
                        <html:text size="30" property="buildingName"/>
                        </div>
                    </div>
                  </li>

                  <li class="fields">
                    <div class="field">
                        <label  class="required"><em>*</em><bean:message key="checkout.dateShip" /></label>
                        <div class="input-box">
                        <% Date date = new Date(); 
                        String s_date = CommonUtil.convertDateToString(date);
                        %>
                           <html:text  size="30" property="dateShip" styleId="datepicker" value="<%=s_date%>" styleClass="validated"/>
                        </div>
                    </div>
                  </li>
                  <li class="fields">
                    <div class="field">
                        <label  class="required"><em>*</em><bean:message key="checkout.note" /></label><br>
                        <bean:message key="checkout.note.info" />
                        <div class="input-box">
                            <html:textarea style="width:400px;"  styleId="note" styleClass="validated"
                            value="" onfocus="this.value='';"
                            cols="200" rows="100" property="note" />
                        </div>
                    </div>
                  </li>
                   <li><span style="color: red" id="errorID"> <logic:messagesPresent>
                <script type="text/javascript">
                                                                    $(document).ready(function() {
                                                                        $("#checkout").focus();
                                                                    });
                                                             </script>
                                                             <logic:messagesPresent property="email">
                                                             <bean:message key="checkou.invemail" />
                                                             </logic:messagesPresent>
                                                             <logic:messagesNotPresent  property="email">
                                                              <html:messages id="error"
                  header="providerForm.registerMadatory">
                </html:messages>
                                                             </logic:messagesNotPresent>
               
              </logic:messagesPresent> </span></li>
                            </ul>
            


        </fieldset>
     </li>
        <li> 
        <button type="submit" title="Thanh toán" class="button" id="checkout" ><span><bean:message key="checkout.button.type" /></span></button>
        </li>
         <li>
        <button type="button" title="Thanh toán" class="button" id="default" ><span class="required"><bean:message key="checkou.button.save" /></span></button>
        </li>
        </ul>
        </html:form>
        <logic:messagesPresent message="true">
                <!-- display message return by action-->
                <html:messages id="message" message="true">
                  <bean:write name="message" />
                </html:messages>
          </logic:messagesPresent> 
        
        <div class="buttons-set" id="billing-buttons-container">
        <p class="required">* <bean:message key="customer.register.mandatory" /></p>
    </div>
  



        </div>
    </li>
    </ul>
    </div>
