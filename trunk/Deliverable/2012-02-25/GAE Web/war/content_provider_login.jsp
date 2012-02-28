<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#reset").click(function() {
			resetFormProvider(0);
			//$(".remove").val("");
			 $("#loginId").val('');
			 $("#loginPassword").val('');
			 $("#loginId").focus();
		});
		
		   $("#login").click(function() {
		        var flag =  validateProviderLogin();
		        if(!flag){
		            return false;
		        }
		    });
		   
		   $("#loginId").blur(function() {
		        if($(this).val() != ""){
		        $(this).css("background", "#FFF");
		    }
		    });
		   $("#loginPassword").blur(function() {
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
			<ul class="form-list">
				<html:form action="/loginProviderAcc.vn" method="get" styleId="loginForm">
					<li><label for="email" class="required" id="typeLogin"><em>*</em>Tên
							đăng nhâp</label>
						<div class="input-box">
							<html:text property="loginId" styleId="loginId"  />
						</div>
					</li>
					<li><label for="pass" class="required"><em>*</em>Password</label>
						<div class="input-box">
							<html:password property="loginPassword" styleId="loginPassword"  />
							<!--  <input type="password" name="login[password]" class="input-text required-entry validate-password" id="pass" title="Password"> -->
						</div>
					</li>
					<li>
						<div class="input-box">
							<input type="submit" name="OK" id="login" title="Password" value="Đăng nhập" class="buttonBG"/> 
							<input type="button" name="Reset" id="reset" title="Password" value="Xóa hết" class="buttonBG"/>
						</div>
					</li>
					<li>
					<li><span style="color: red;" id="message"> <logic:messagesPresent
                message="true">
                <html:messages id="message" message="true">
                  <bean:write name="message" />
                </html:messages>
              </logic:messagesPresent> <html:messages id="error">
                <%=error%>
              </html:messages>
          </span></li>
					<div class="input-box">
						<a href="/registerProvider.vn">Đăng kí nếu chưa có tài khoản</a>
					</div><br>
          <p style="color:red;">*Bắt buộc phải nhập</p>
					
				</html:form>
			</ul>


		</div>
	</div>
</div>