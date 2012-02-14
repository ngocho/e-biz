<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<script type="text/javascript">
	$(document).ready(function() {
		/* $("#reset").click(function() {
			resetFormProvider(0);
			//$(".remove").val("");
			 $("#loginId").val('');
			 $("#loginPassword").val('');
			 $("#loginId").focus();
		}); */
		
		   $("#createVoucher").click(function() {
		        var flag =  validateVoucherForm();
		        if(!flag){
		            return false;
		        }
		    });
		   
		   $("#phone").blur(function() {
		        if($(this).val() != ""){
		        $(this).css("background", "#FFF");
		    }
		    });
		   $("#homeNumber").blur(function() {
               if($(this).val() != ""){
               $(this).css("background", "#FFF");
           }
           });
		   
		   $("#streetName").blur(function() {
               if($(this).val() != ""){
               $(this).css("background", "#FFF");
           }
           });
		   
		   $("#wardName").blur(function() {
               if($(this).val() != ""){
               $(this).css("background", "#FFF");
           }
           });
		   
		   $("#districtName").blur(function() {
               if($(this).val() != ""){
               $(this).css("background", "#FFF");
           }
           });
	});
</script>
<div class="home-spot">
	<div class="col-2 registered-users" class="login">
		<div class="content">
			
			<h2> ĐỊA CHỈ</h2>
			<ul class="form-list">
				<html:form action="/createVoucher.vn" method="get" styleId="loginForm">
				<li><label for="email" class="required" id="typeLogin"><em>*</em>Số điện thoại</label>
						<div class="input-box">
							<html:text property="phone" styleId="phone"  />
						</div>
					</li>
					<li><label for="email" class="required" id="typeLogin"><em>*</em>Số nhà</label>
						<div class="input-box">
							<html:text property="homeNumber" styleId="homeNumber"  />
						</div>
					</li>
					<li><label for="pass" class="required"><em>*</em>Tên đường</label>
						<div class="input-box">
							<html:password property="streetName" styleId="streetName" />
							<!--  <input type="password" name="login[password]" class="input-text required-entry validate-password" id="pass" title="Password"> -->
						</div>
					</li>
					
					<li><label for="pass" class="required"><em>*</em>Tên phường</label>
						<div class="input-box">
							<html:password property="wardName" styleId="wardName"  />
							<!--  <input type="password" name="login[password]" class="input-text required-entry validate-password" id="pass" title="Password"> -->
						</div>
					</li>
					
					<li><label for="pass" class="required"><em>*</em>Tên quận</label>
						<div class="input-box">
							<html:password property="districtName" styleId="districtName"  />
							<!--  <input type="password" name="login[password]" class="input-text required-entry validate-password" id="pass" title="Password"> -->
						</div>
					</li>
					
					<li><label for="pass" class="required"><em>*</em>Tên tòa nhà</label>
						<div class="input-box">
							<html:password property="buildingName" styleId="buildingName"  />
							<!--  <input type="password" name="login[password]" class="input-text required-entry validate-password" id="pass" title="Password"> -->
						</div>
					</li>
					
					<li>
						<div class="input-box">
							<input type="submit" name="OK" id="createVoucher" title="Continue" value="Tiếp tục" class="buttonBG"/> 
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
					
				</html:form>
			</ul>


			<p class="required">* Bắt buộc phải nhập</p>
		</div>
	</div>
</div>