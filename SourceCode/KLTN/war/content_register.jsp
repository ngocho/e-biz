<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#isAdEmail").attr('checked', true);
	$("#isAdPhone").attr('checked', true);
    //submit
     $("#register").click(function() {
        var flag =  validateCustomerRegister();
        if(!flag){
            return false;
        }
    });
     
    $("#reset").click(function() {
        resetFormCustomer();
        $("#loginIdR").val("");
        $("#loginPasswordR").val("");
        $("#loginPasswordPreR").val("");
        //focus
        $("#headerHome").focus();
        $("#loginIdR").focus();

    });
    
    $("#loginIdR").blur(function() {
        if($(this).val() != ""){
            $(this).css("background", "#FFF");
        }
    });
    
    $("#loginPasswordR").blur(function() {
        if($(this).val() != ""){
            $(this).css("background", "#FFF");
        }
    });
    
    $("#loginPasswordPreR").blur(function() {
        if($(this).val() != ""){
            $(this).css("background", "#FFF");
        }
    });
    
    $("#loginPhoneR").blur(function() {
        if($(this).val() != ""){
            $(this).css("background", "#FFF");
        }
    });
    
    $("#loginEmailR").blur(function() {
        if($(this).val() != ""){
            $(this).css("background", "#FFF");
        }
    });
    
});
</script>
<div class="home-spot">
                                        <div class="account-create">

    <div class="page-title">
        <h1>Tạo một tài khoản mới</h1>
    </div>
    <html:form action="/registerAction.vn" method="get" styleId="registerForm">
        <div class="fieldset">
           <h2 class="legend">Thông tin bắt buộc</h2>
            
            <ul class="form-list">
            <li class="fields">
              <div class="field">
            </div>
            </li>
                <li class="fields">
                    <div class="customer-name">
    <div class="field name-firstname">
        <label for="firstname" class="required" id="typeLogin"  ><em>*</em>Tên đăng nhập</label>
        <div class="input-box">
        <html:text property="loginId" styleId="loginIdR" styleClass="validate"/> 
        </div>

    </div>
    <html:errors property="usrinvalid" />
    </div>
                </li>
                
                <li class="fields">
                    <div class="field">
                        <label for="password" class="required"><em>*</em>Mật khẩu</label>
                        <div class="input-box">
                            <html:password property="loginPassword" styleId="loginPasswordR" styleClass="validate"/> <span style="color:red;">
                        ít nhất 8 kí tự
</span>
                        </div>
                    </div>
                    <div class="field">
                        <label for="confirmation" class="required"><em>*</em>Nhập lại mật khẩu</label>
                        <div class="input-box">
                           <html:password property="loginPasswordPre" styleId="loginPasswordPreR" styleClass="validate"/>
                           <span style="color:red;">
                        ít nhất 8 kí tự</span>
                        </div>
                    </div>

                </li>
                 <li>
                 <div class="field">
                        <label for="confirmation" class="required" ><em>*</em>Số điện thoại</label>
                        <div class="input-box">
                           <html:text property="phone" size="40" styleId="loginPhoneR"/>
                        </div>
                    </div>

                </li>
                 <li class="fields">
                    <div class="field">
                        <label for="password" class="required" ><em>*</em>Email</label>
                        <div class="input-box">
                           <html:text property="email" size="40" styleId="loginEmailR"/>

                        </div>
                    </div>
                    </li>
                    
                <li>
                <span style="color:red" >
        <logic:messagesPresent >
         <html:messages id="error"  header="providerForm.registerMadatory" >
        </html:messages>
         </logic:messagesPresent>
</span>
                
                </li>                                                                   </ul>
        </div>
            <div class="fieldset">

            <h2 class="legend">Thông tin khách hàng </h2>
            <ul class="form-list">
            <li class="fields">
            </li>
            <li class="fields">
                    <div class="field">
                        <label for="password" class="required">Tên </label>
                        <div class="input-box">
                            <html:text property="loginName" size="40"/>
                        </div>
                    </div>
                        <label for="confirmation" class="required">Giới tính : </label><br>
                        Nữ  <html:radio property="gender" value="0" />
                        Nam  <html:radio property="gender"  value="1" />
                      
                    </li>
                    <li class="fields">
                    <div class="field">
                        <label for="password" class="required">Ngày sinh</label>
                        <div class="input-box">
                           <html:text property="birthDate" size="40"/>

                        </div>
                    </div>
                    </li>
               
                   <li class="fields">
                    <div class="field">
                        <label for="billing:company">Số nhà</label>
                        <div class="input-box">
                         <html:text property="homeNumber"/>
                        </div>
                    </div>
                      <div class="field">
                        <label for="billing:email" class="required">Tên đường</label>
                        <div class="input-box">
                           <html:text property="streetName" size="40"/>
                        </div>
                      </div>
                    </li>
                     <li class="fields">
                    <div class="field">
                        <label for="billing:company">Phường</label>
                        <div class="input-box">
                           <html:text property="wardName" size="40"/>
                        </div>
                    </div>
                    
                    </li>
                     <li class="fields">
                    <div class="field">
                        <label for="billing:city" class="required">Tòa nhà</label>
                        <div class="input-box">
                        <html:text property="buildingName" size="40"/>
                        </div>
                    </div>
                  </li>
                  <li>
                     <div class="field">
                        <label for="billing:email" class="required" ><em>*</em>Quận</label>
                        <div class="input-box">
                        <html:select property="districtName"  styleId="districtNameR">
    <html:option value="">- - - - - - - - - - - - Chọn quận- - - - - - - - - - - - -</html:option>
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
                   
                <li>
                    <div class="field">
                      <html:checkbox property="isAdEmail" styleId="isAdEmail" />   Nhận thông tin khuyến mãi qua email 
                    </div>

                </li>
                 <li>
                    <div class="field">
                      <html:checkbox property="isAdPhone"  styleId="isAdPhone"/>   Nhận thông tin khuyến mãi qua di động
                    </div>
                </li>
                            </ul>
                            
            <div id="window-overlay" class="window-overlay" style="display:none;"></div>

</div>
 <button type="submit" title="Submit" style="margin-left:200px;" id="register" class="button">
    <span><span>Đăng kí</span>
    </span>
  </button>
  
   <button type="button" title="Reset" style="margin-left:50px;" id="reset" class="button">
    <span><span>Xóa hết</span>
    </span>
  </button>
  
<div class="buttons-set1">
  <p class="buttons-set1 p.required required">*Yêu cầu nhập </p>
  <br />

</div>
</html:form>

</div>
</div>