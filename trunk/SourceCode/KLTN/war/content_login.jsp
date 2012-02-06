<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<script type="text/javascript">
$(document).ready(function(){
     $("#login").click(function() {
        var flag =  validateProviderLogin();
        if(!flag){
            return false;
        }
    });
    
    $("#reset").click(function() {
        resetFormCustomer();
        $("#id").val("");
        $("#pass").val("");
        //focus
        $("#headerHome").focus();
        $("#id").focus();

    });
    
    $("#id").blur(function() {
        if($(this).val() != ""){
            $(this).css("background", "#FFF");
        }
    });
    
    $("#pass").blur(function() {
        if($(this).val() != ""){
            $(this).css("background", "#FFF");
        }
    });
    
});
</script>
<div class="home-spot">
  <div class="col-2 registered-users" class="login">
    <div class="content">
      <logic:present name="type" scope="request">
        <c:if test="${type ==1}">
          <b> Hãy đăng kí trước khi thanh toán đơn hàng</b>
        </c:if>
      </logic:present>
      <h2>ĐĂNG NHẬP</h2>
      <!--p>If you have an account with us, please log in.</p-->
      <ul class="form-list">
        <html:form action="/loginAction.vn" method="get" styleId="loginForm">
          <li><label for="email" class="required" id="typeLogin"><em>*</em>Tên
              đăng nhâp</label>
            <div class="input-box">
              <html:text property="loginId" styleId="id" />
            </div>
          </li>
          <li><label for="pass" class="required"><em>*</em>Password</label>
            <div class="input-box">
              <html:password property="loginPassword" styleId="pass"/>
            </div>
          </li>
          <li>
            <div class="input-box">
              <input type="submit" class="buttonBG" name="login" id="login" title="Password" value="Đăng nhập">
               <input type="button"  class="buttonBG" name="reset"
                id="reset" title="Password" value="Xóa hết"  >
            </div>
          </li>
          <li>
          <li><span style="color: red;" id="message"> 
          <logic:messagesPresent message="true">
                <!-- display message return by action-->
                <html:messages id="message" message="true">
                  <bean:write name="message" />
                </html:messages>
          </logic:messagesPresent> 
              <!-- display error checked by XML -->
              <html:messages id="error">
                <%=error%>
              </html:messages>
          </span></li>

        </html:form>
      </ul>

      <a href="/registerCustomer.vn">Đăng kí nếu chưa có tài khoản</a>

      <p class="required">* Bắt buộc phải nhập</p>
    </div>
  </div>
</div>