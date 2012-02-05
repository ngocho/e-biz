<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<script type="text/javascript">
$(document).ready(function(){
    //submit
     $("#register").click(function() {
        var flag =  validateCustomerRegister();
        if(flag){
            $("#registerForm").submit();
        }
        else{
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
    
});
</script>
<div class="home-spot">
                                        <div class="account-create">

    <div class="page-title">
        <h1>Tạo một tài khoản mới</h1>
    </div>
    <html:form action="/registerAction.vn" method="get" styleId="registerForm">
        <div class="fieldset">
           <h2 class="legend">Thông tin đăng nhập</h2>
            
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
        <html:text property="loginId" styleId="loginIdR"/> 
        </div>

    </div>
    <html:errors property="usrinvalid" />
    </div>
                </li>
                
                <li class="fields">
                    <div class="field">
                        <label for="password" class="required"><em>*</em>Mật khẩu</label>
                        <div class="input-box">
                            <html:password property="loginPassword" styleId="loginPasswordR"/>

                        </div>
                    </div>
                    <div class="field">
                        <label for="confirmation" class="required"><em>*</em>Nhập lại mật khẩu</label>
                        <div class="input-box">
                           <html:password property="loginPasswordPre" styleId="loginPasswordPreR"/>
                        </div>
                    </div>

                </li>
                <li>
                <span style="color:red" >
                <logic:messagesPresent >  
    <script type="text/javascript">
    $(document).ready(function(){
    $("#headerHome").focus();
    }
    );
</script>
        <logic:messagesNotPresent property="email">
         <html:messages id="error"  header="providerForm.registerMadatory" >
        </html:messages>
        </logic:messagesNotPresent>
        <html:messages id="error"  property="email" >
        <br>
        <span style="color:red" > Địa chỉ mail không hợp lệ !</span>
         <script type="text/javascript">
    $(document).ready(function(){
    $("#email").focus();
    }
    );
</script>
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
                        <label for="password" class="required" >Email</label>
                        <div class="input-box">
                           <html:text property="email" size="40" styleId="email"/>

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
                     <div class="field">
                        <label for="billing:email" class="required">Quận</label>
                        <div class="input-box">
                        <html:select property="districtName">
                        <html:option value="0">- - - - - - - - - - - - Chọn quận- - - - - - - - - - - - -</html:option>
    <html:option value="18">1</html:option>
    <html:option value="42">2</html:option>
    <html:option value="17">3</html:option>
   <html:option value="21">4</html:option>
   <html:option value="20">5</html:option>
   <html:option value="25">6</html:option>
   <html:option value="41">7</html:option>
   <html:option value="37">8</html:option>
   <html:option value="43">9</html:option>
   <html:option value="19">10</html:option>
   <html:option value="24">11</html:option>
   <html:option value="44">12</html:option>
   <html:option value="36">Bình Chánh</html:option>
   <html:option value="39">Bình Tân</html:option>
   <html:option value="31">Bình Thạnh</html:option>
   <html:option value="38">Gò Vấp</html:option>
   <html:option value="61">Hóc Môn</html:option>
   <html:option value="63">Nhà Bè</html:option>
   <html:option value="32">Phú Nhuận</html:option>
   <html:option value="22">Tân Bình</html:option>
   <html:option value="40">Tân Phú</html:option>
   <html:option value="45">Thủ Đức</html:option>
</html:select>
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
                        <label for="confirmation" class="required">Số điện thoại</label>
                        <div class="input-box">
                           <html:text property="phone" />
                        </div>
                    </div>

                </li>
                <li>
                    <div class="field">
                      <html:checkbox property="isAdEmail" />   Nhận thông tin khuyến mãi qua email 
                    </div>

                </li>
                 <li>
                    <div class="field">
                      <html:checkbox property="isAdPhone" />   Nhận thông tin khuyến mãi qua di động
                    </div>
                </li>
                            </ul>
                            
            <div id="window-overlay" class="window-overlay" style="display:none;"></div>
<!-- <div id="remember-me-popup" class="remember-me-popup" style="display:none;">
    <div class="remember-me-popup-head">
        <h3>What's this?</h3>
        <a href="#" class="remember-me-popup-close" title="Close">Close</a>
    </div>

    <div class="remember-me-popup-body">
        <p>Checking &quot;Remember Me&quot; will let you access your shopping cart on this computer when you are logged out</p>
        <div class="remember-me-popup-close-button a-right">
            <a href="#" class="remember-me-popup-close button" title="Close"><span>Close</span></a>
        </div>
    </div>

</div>  -->

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
  <p class="buttons-set1 p.required">*Yêu cầu nhập </p>
  <br />
  <p class="buttons-set1 p.back-link">
    <a href="https://demo.magentocommerce.com/customer/account/login/"
      class="back-link"><small>&laquo; </small>Trở lại</a>
  </p>

</div>
</html:form>

</div>
</div>