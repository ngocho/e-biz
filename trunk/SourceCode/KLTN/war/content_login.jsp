<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib  uri="http://java.sun.com/jstl/core" prefix="c"%>
<script type="text/javascript">
    function change() {
        var i = document.getElementById("type").value;
        if (i == 1) {
            document.getElementById("type").value = '0';
            document.getElementById("typeLogin").innerHTML = "<em>*</em>Email đăng nhập";
            document.getElementById("idLogin").value = 'Dùng tên tài khoản để đăng nhập';
        } else {
            document.getElementById("type").value = '1';
            document.getElementById("typeLogin").innerHTML = "<em>*</em>Tên đăng nhập";
            document.getElementById("idLogin").value = 'Dùng email để đăng nhập';

        }
    }
</script>
<div class="home-spot">
  <div class="col-2 registered-users" class="login">
    <div class="content">
      <h2>ĐĂNG NHẬP</h2>
      <!--p>If you have an account with us, please log in.</p-->
      <ul class="form-list">
        <html:form action="/loginAction.vn" method="get">
          <li class="fields">

            <div class="field">
              <input type="hidden" name="type" id="type" value="1" /> <input
                type="button"
                style="background: url(); background: #00CCFF"
                onclick="change()" id="idLogin"
                value="Dùng email để đăng nhập" />
            </div></li>
          <li><label for="email" class="required" id="typeLogin"><em>*</em>Tên
              đăng nhâp</label>
            <div class="input-box">
              <html:text property="loginId" />
              <!--  <input type="text" name="login[username]" value="" id="email" class="input-text required-entry validate-email" title="Email Address"> -->
            </div></li>
          <li><label for="pass" class="required"><em>*</em>Password</label>
            <div class="input-box">
              <html:text property="loginPassword" />
              <!--  <input type="password" name="login[password]" class="input-text required-entry validate-password" id="pass" title="Password"> -->
            </div></li>
          <li>
            <div class="input-box">
              <input type="submit" name="OK" id="pass" title="Password"
                value="Đăng nhập">
                    <input type="reset" name="OK" id="reset" title="Password"
                value="Xóa hết">
            </div></li>
          <li>
           <li>
                <logic:messagesPresent message="true">
   <html:messages id="message" message="true">
     <bean:write name="message"/><br/>
   </html:messages>
</logic:messagesPresent>
<html:messages id="error">
<%= error%>
</html:messages>
                
                </li>     
            <div class="input-box">
              <a href="/registerCustomer.vn" >Đăng kí nếu chưa có
                tài khoản</a>
            </div></li>
        </html:form>
      </ul>


      <script type="text/javascript">
                            //         
                            function toggleRememberMepopup(event) {
                                if ($('remember-me-popup')) {
                                    var viewportHeight = document.viewport.getHeight(), docHeight = $$('body')[0]
                                            .getHeight(), height = docHeight > viewportHeight ? docHeight
                                            : viewportHeight;
                                    $('remember-me-popup').toggle();
                                    $('window-overlay').setStyle({
                                        height : height + 'px'
                                    }).toggle();
                                }
                                Event.stop(event);
                            }

                            document.observe("dom:loaded", function() {
                                new Insertion.Bottom($$('body')[0], $('window-overlay'));
                                new Insertion.Bottom($$('body')[0], $('remember-me-popup'));

                                $$('.remember-me-popup-close').each(function(element) {
                                    Event.observe(element, 'click', toggleRememberMepopup);
                                })
                                $$('#remember-me-box a').each(function(element) {
                                    Event.observe(element, 'click', toggleRememberMepopup);
                                });
                            });
                            //
                        </script>
      <p class="required">* Bắt buộc phải nhập</p>
    </div>
  </div>
</div>