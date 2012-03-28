<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script type="text/javascript">
	/* $(document).ready(function() {
		$("#reset").click(function() {
			resetFormProvider(0);
			//$(".remove").val("");
			$("#loginId").val('');
			$("#loginPassword").val('');
			$("#loginId").focus();
		});

		$("#login").click(function() {
			var flag = validateProviderLogin();
			if (!flag) {
				return false;
			}
		});

		$("#loginId").blur(function() {
			if ($(this).val() != "") {
				$(this).css("background", "#FFF");
			}
		});
		$("#loginPassword").blur(function() {
			if ($(this).val() != "") {
				$(this).css("background", "#FFF");
			}
		});
	}); */
</script>
<div class="home-spot">
	<div class="col-2 registered-users" class="login">
		<div class="content">
			<h2>CHỨNG THỰC</h2>
        <form action="/authenticationProvider.vn" method="get" id="loginForm">
			<ul class="form-list">
					<li><label for="email" class="required" id="typeLogin"><em>*</em>Nhập
							vào mã chứng thực: </label>
						<div class="input-box">
							<input type="text" name="valueAuthen"  value=""/>
						</div></li>
					<li><input type="submit"  class="buttonBG" value="Gởi" /></li>

					<li>
					<li><span style="color: red;" id="message"> <logic:messagesPresent
								message="true">
								<html:messages id="message" message="true">
									<bean:write name="message" />
								</html:messages>
							</logic:messagesPresent> <html:messages id="error">
								<%=error%>
							</html:messages> </span>
					</li>

			
			</ul>
    </form>
			<p class="required">* Bắt buộc phải nhập</p>
		</div>
	</div>
</div>