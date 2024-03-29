<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<div class="home-spot">
                                        <div class="account-create">

    <div class="page-title">
        <h1>Tạo một tài khoản mới</h1>
    </div>
    <html:form action="/registerAction.vn" method="get">
        <div class="fieldset">
            <input type="hidden" name="success_url" value="" />
            <input type="hidden" name="error_url" value="" />
             <input type="hidden" name="type" id = "type" value="1" />
            <h2 class="legend">Thông tin đăng nhập</h2>
            
            <ul class="form-list">
            <li class="fields">
              <div class="field">
            <input type="button" style="background:url(); background:#00CCFF" onclick="change()" id= "idLogin" value="Dùng email để đăng kí" />
            </div>
            </li>
                <li class="fields">
                    <div class="customer-name">
    <div class="field name-firstname">
        <label for="firstname" class="required" id="typeLogin"  ><em>*</em>Tên đăng nhập</label>
        <div class="input-box">
        <html:text property="loginId" />
        </div>

    </div>
                </li>
                
                <li class="fields">
                    <div class="field">
                        <label for="password" class="required"><em>*</em>Mật khẩu</label>
                        <div class="input-box">
                            <html:text property="loginPassword" />

                        </div>
                    </div>
                    <div class="field">
                        <label for="confirmation" class="required"><em>*</em>Nhập lại mật khẩu</label>
                        <div class="input-box">
                           <html:text property="loginPasswordPre" />
                        </div>
                    </div>

                </li>
                                <!--li class="control">

                    <div class="input-box">
                        <input type="checkbox" name="is_subscribed" title="Sign Up for Newsletter" value="1" id="is_subscribed" class="checkbox" />
                    </div>
                    <label for="is_subscribed">Sign Up for Newsletter</label>
                </li-->
                                                                                                    </ul>
        </div>
            <div class="fieldset">

            <h2 class="legend">Thông tin khách hàng </span></h2> <span> 
            <ul class="form-list">
            <li class="fields">
            <!--a href="" style="text-decoration:none; color:#990000"> Rút gọn </a> | <a href="" > Đầy đủ </a-->
            </li>
            <li class="fields">
                    <div class="field">
                        <label for="password" class="required">Tên </label>
                        <div class="input-box">
                            <html:text property="loginName" size="40"/>
                        </div>
                    </div>
                        <label for="confirmation" class="required">Giới tính : </label></br>
                        Nữ  <html:radio property="gender" value="0" />&nbsp &nbsp &nbsp
                        Nam  <html:radio property="gender"  value="1" />
                       <!-- <input type="radio" name="gender" value="female" checked="true"/>
                       &nbsp &nbsp &nbsp <input type="radio" name="gender" value="male" /> Nam -->
                      
                    </li>
                <li class="fields">
                    <div class="field">
                        <label for="password" class="required">Email</label>
                        <div class="input-box">
                           <html:text property="email" size="40"/>

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
                        <label for="confirmation" class="required">Số điện thoại</label>
                        <div class="input-box">
                           <html:checkbox property="isAd" />
                        </div>
                    </div>

                </li>
                            </ul>
                            
            <div id="window-overlay" class="window-overlay" style="display:none;"></div>
<div id="remember-me-popup" class="remember-me-popup" style="display:none;">
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

</div>
<script type="text/javascript">
//<![CDATA[
    function toggleRememberMepopup(event){
        if($('remember-me-popup')){
            var viewportHeight = document.viewport.getHeight(),
                docHeight      = $$('body')[0].getHeight(),
                height         = docHeight > viewportHeight ? docHeight : viewportHeight;
            $('remember-me-popup').toggle();
            $('window-overlay').setStyle({ height: height + 'px' }).toggle();
        }
        Event.stop(event);
    }

    document.observe("dom:loaded", function() {
        new Insertion.Bottom($$('body')[0], $('window-overlay'));
        new Insertion.Bottom($$('body')[0], $('remember-me-popup'));

        $$('.remember-me-popup-close').each(function(element){
            Event.observe(element, 'click', toggleRememberMepopup);
        })
        $$('#remember-me-box a').each(function(element) {
            Event.observe(element, 'click', toggleRememberMepopup);
        });
    });
//]]>
</script>
</div>
 <button type="submit" title="Submit" style="margin-left:200px;" class="button">
    <span><span>Submit</span>
    </span>
  </button>
<div class="buttons-set1">
  <p class="buttons-set1 p.required">* Required Fields</p>
  <br />
  <p class="buttons-set1 p.back-link">
    <a href="https://demo.magentocommerce.com/customer/account/login/"
      class="back-link"><small>&laquo; </small>Back</a>
  </p>

</div>
</html:form>

<script type="text/javascript">
    //<![CDATA[
        var dataForm = new VarienForm('form-validate', true);
            //]]>
    </script>
</div>
</div>