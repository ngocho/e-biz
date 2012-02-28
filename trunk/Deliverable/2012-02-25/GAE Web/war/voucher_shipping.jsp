<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<div class="home-spot" >
	<div class="col-2 registered-users" class="login">
		<div class="content">
			
			<h2>LỰA CHỌN HÌNH THỨC NHẬN VOUCHER</h2>
      <form action="/getVoucherType.vn" method="get" styleId="loginForm">
			<ul style="margin-top:20px;" >
				
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
				
			</ul>
      </form>


		</div>
	</div>
</div>