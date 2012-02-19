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
	<%--MAIL --%>
		<c:if test="${voucherType =='mail'}">
		<div class="content">
			<h2> GỞI MAIL</h2>
			<p >Chúng tôi sẽ gởi voucher đến mail mà bạn nhập ở phía dưới<br>
			Vui lòng in ra khi đến cửa hàng dùng bữa <br>
			Hoặc <span style="impressionText">cung cấp số điện thoại và số voucher khi đến cửa hàng</span>	
			<ul class="form-list">
				<html:form action="/createVoucher.vn" method="get" styleId="loginForm">
				<li><label for="email" class="required" id="typeLogin"><em>*</em>Số điện thoại</label>
						<div class="input-box">
							<html:text property="phone" styleId="phone"  />
						</div>
					</li>
					<li><label for="email" class="required" id="typeLogin"><em>*</em>Email</label>
						<div class="input-box">
							<html:text property="email" styleId="email"  />
						</div>
					</li>
					<li style="margin-top:10px;">
						<div class="input-box">
						<input type="submit" value="Nhận Voucher"  class="buttonBG"/>
						</div>
					</li>
					
				</html:form>
			</ul>


			<p class="required">* Bắt buộc phải nhập</p>
		</div>
		</c:if>
	<%--PHONE --%>	
	<c:if test="${voucherType =='message'}">
	<div class="content">
			<h2> GỞI TIN NHẮN</h2>
			<span style="impressionText">Chúng tôi sẽ gởi tin nhắn đến số điện thoại mà bạn nhập ở phía dưới</span>	<br>
			<span style="impressionText">Cung cấp số điện thoại và số voucher khi đến cửa hàng</span>	
			<ul class="form-list">
				<html:form action="/createVoucher.vn" method="get" styleId="loginForm">
				<li><label for="email" class="required" id="typeLogin"><em>*</em>Số điện thoại</label>
						<div class="input-box">
							<html:text property="phone" styleId="phone"  />
						</div>
					</li>
					<li style="margin-top:10px;">
						<div class="input-box">
						<input type="submit" value="Nhận Voucher"  class="buttonBG"/>
						</div>
					</li>
					
				</html:form>
			</ul>


			<p class="required">* Bắt buộc phải nhập</p>
		</div>
		</c:if>
	</div>
</div>