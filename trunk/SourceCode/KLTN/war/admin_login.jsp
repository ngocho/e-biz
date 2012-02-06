<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#reset").click(function() {
			//resetFormProvider(0);
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
			<h2>ĐĂNG NHẬP</h2>
			<ul class="form-list">
				<html:form action="/loginAdmin.vn" method="get" styleId="loginForm">
					<li><label for="email" class="required" id="typeLogin"><em>*</em>Tên
							đăng nhâp</label>
						<div class="input-box">
							<html:text property="id" styleId="id"  />
						</div>
					</li>
					<li><label for="pass" class="required"><em>*</em>Password</label>
						<div class="input-box">
							<html:password property="pass" styleId="pass"  />
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
						<a href="/registerAdmin.vn">Đăng kí nếu chưa có tài khoản</a>
					</div>
					
				</html:form>
			</ul>


			<p class="required">* Bắt buộc phải nhập</p>
		</div>
	</div>
</div>