<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<div class="home-spot" >
	<div class="col-2 registered-users" class="login">
		<div class="content">
			
			<h2>LỰA CHỌN HÌNH THỨC THANH TOÁN</h2>
			Bạn đã mua <bean:write name="voucherForm" property="numberVoucher"/> Voucher món ăn<br>
			Số tiền là : <bean:write name="voucherForm" property="sumPrice"/> 
			<ul style="margin-top:20px;" >
				<form action="/getVoucherFilter.vn" method="get" styleId="loginForm">
					<li><span style="color: red;" id="message"> <logic:messagesPresent
								message="true">
								<!-- display message return by action-->
								<html:messages id="message" message="true">
									<bean:write name="message" />
								</html:messages>
							</logic:messagesPresent> <!-- display error checked by XML --> <html:messages id="error">
								<%=error%>
							</html:messages> </span>
					</li>
					<c:if test="${voucherType =='mail'}">
					</c:if>

					<li  >
						<div class="input-box">
						<input type="radio" name="checkoutOption" value="home">Thanh toán bằng tiền mặt tại nhà 
						</div>
					</li>
					<li style="margin-top:10px;">
						<div class="input-box">
						<input type="radio" name="checkoutOption" value="xu" checked="checked">Thanh toán online với tài khoản xu
						</div>
					</li>
					<li style="margin-top:10px;">
						<div class="input-box">
						<input type="radio" name="checkoutOption" value="nganluong">Thanh toán online qua Ngân lượng
						</div>
					</li>
					<li style="margin-top:10px;">
						<div class="input-box">
						<input type="submit" value="Tiếp tục"  class="buttonBG"/>
						</div>
					</li>
				</form>
			</ul>


		</div>
	</div>
</div>