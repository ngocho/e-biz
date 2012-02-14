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
			
			<h2>LỰA CHỌN HÌNH THỨC NHẬN VOUCHER</h2>
			<ul style="margin-top:20px;" >
				<form action="/getVoucherType.vn" method="get" styleId="loginForm">
					<li  >
						<div class="input-box">
						<input type="radio" name="typeShipping" value="home">Nhận tại nhà
						</div>
					</li>
					<li style="margin-top:10px;">
						<div class="input-box">
						<input type="radio" name="typeShipping" value="mail" checked="checked">Gởi qua mail
						</div>
					</li>
					<li style="margin-top:10px;">
						<div class="input-box">
						<input type="radio" name="typeShipping" value="message">Gởi tin nhắn
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