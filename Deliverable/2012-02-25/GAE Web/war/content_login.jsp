<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
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
      <h2><bean:message key="home.right.login.title" /></h2>
      <!--p>If you have an account with us, please log in.</p-->
      <ul class="form-list">
        <html:form action="/loginAction.vn" method="get" styleId="loginForm">
          <li><label for="email" class="required" id="typeLogin"><em>*</em><bean:message key="home.right.login.name" /></label>
            <div class="input-box">
              <html:text property="loginId" styleId="id" />
            </div>
          </li>
          <li><label for="pass" class="required"><em>*</em><bean:message key="home.right.login.password" /></label>
            <div class="input-box">
              <html:password property="loginPassword" styleId="pass"/>
            </div>
          </li>
          <li>
            <div class="input-box">
              <input type="submit" class="buttonBG" name="login" id="login" title="Password" value="<bean:message key="home.right.login.button" />">
               <input type="button"  class="buttonBG" name="reset"
                id="reset" title="Password" value="<bean:message key="customer.register.button1" />"  >
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

      <a href="/registerCustomer.vn" >Đăng kí nếu chưa có tài khoản</a>
      <div style="height:10px;"></div>
      <p style="color:red;font-size: 11px; margin-left: 100px;">(* Bắt buộc phải nhập)</p> 	
    </div>
  </div>
</div>