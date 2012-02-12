<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
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
			<logic:present name="type" scope="request">
				<c:if test="${type ==1}">
					<b> Hãy đăng kí trước khi thanh toán đơn hàng</b>
				</c:if>
			</logic:present>
			<h2>ĐĂNG NHẬP</h2>
			<ul class="form-list">
				<form action="/loginProviderAcc.vn" method="get" styleId="loginForm">
					<li><label for="email" class="required" id="typeLogin"><em>*</em>Nhập
							vào mã chứng thực</label>
						<div class="input-box">
							<input type="text" name="idAuthen" value="" />
						</div></li>
					<li><input type="submit" value="Gởi" /></li>

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

				</form>
			</ul>

			<p class="required">* Bắt buộc phải nhập</p>
		</div>
	</div>
</div>