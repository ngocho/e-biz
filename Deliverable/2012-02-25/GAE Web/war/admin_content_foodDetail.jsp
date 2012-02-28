<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<div class="home-spot">
	<div class="account-create">

		<div class="page-title" id="focus">
			<h1>Thông tin sản phẩm</h1>
		</div>
		<div class="fieldset">
			<h2 class="legend">Thông tin sản phẩm</h2>



			<ul class="form-list">
				<li class="fields">
					<div class="customer-name">
						<div class="field name-firstname">
							<label for="firstname" class="required"><em>*</em>Loại
								sản phẩm</label>
							<div class="input-box">
								<bean:write name="aFoodForm" property="nameTypeId" />
							</div>
						</div>
					</div></li>
				<li class="fields">
					<div class="customer-name">
						<div class="field name-firstname">
							<label for="firstname" class="required"><em>*</em>Nhóm
								sản phẩm</label>
							<div class="input-box">
								<bean:write name="aFoodForm" property="nameAttr" />
							</div>
						</div>
					</div></li>
				<li class="fields">
					<div class="customer-name">
						<div class="field name-firstname">
							<label for="firstname" class="required"><em>*</em>Trạng
								thái của sản phẩm</label>
							<div class="input-box">
								<bean:write name="aFoodForm" property="statusName" />
							</div>
						</div>
					</div></li>
				<li class="fields">
					<div class="customer-name">
						<div class="field name-firstname">
							<label for="firstname" class="required"><em>*</em>Hình</label>
							<div class="input-box">
								<img
									src="/serveImage.vn?urlKey=<bean:write name="aFoodForm" property="urlKey"/>"
									width="200" height="150" id="image" />
							</div>

						</div>
					</div></li>
				<li class="fields">
					<div class="customer-name">
						<div class="field name-firstname">
							<label for="firstname" class="required"><em>*</em>Tên
								món ăn</label>
							<div class="input-box">
								<bean:write name="aFoodForm" property="name" />
							</div>
						</div>
					</div></li>
				<li class="fields">
					<div class="customer-name">
						<div class="field name-firstname">
							<label for="firstname" class="required"><em>*</em>Số
								lượng</label>
							<div class="input-box">
								<bean:write name="aFoodForm" property="number" />
							</div>
						</div>
					</div></li>
				<li class="fields">
					<div class="customer-name">
						<div class="field name-firstname">
							<label for="firstname" class="required"><em>*</em>Giá</label>
							<div class="input-box">
								<bean:write name="aFoodForm" property="price" />
							</div>
						</div>
					</div></li>
				<li class="fields">
					<div class="customer-name" id="divPrice">
						<div class="field name-firstname">
							<label for="firstname" class="required">Giá khuyến mãi</label>
							<div class="input-box">
								<bean:write name="aFoodForm" property="promoPrice" />
							</div>
						</div>
					</div></li>
				<li class="fields">
					<div class="customer-name">
						<div class="field name-firstname">
							<label for="firstname" class="required"><em>*</em>Giới
								thiệu về sản phẩm</label>
							<div class="input-box">
								<bean:write name="aFoodForm" property="detail" />
							</div>
						</div>
					</div></li>
				<li class="fields">
					<div class="customer-name">
						<div class="field name-firstname">
							<label for="firstname" class="required">Hướng dẫn cách
								nấu</label>
							<div class="input-box">
								<bean:write name="aFoodForm" property="cooking" />
							</div>
						</div>
					</div></li>
				<c:if test="${adminVo.status == '4'}">
					<li class="fields">
						<div class="customer-name">
							<div class="field name-firstname">
								<label for="firstname" class="required"><span
									class="impressionText">Sản phẩm chưa được review</span>
								</label>
							</div>
						</div></li>
				</c:if>
				<li>

					<div class="input-box">
						<c:if test="${adminVo.status == '4'}">
							<input type="button" title="Submit" class="buttonBG" id="display"
								value="Hiển thị"  onclick="setLocation('/reviewFood.vn?id=<bean:write name="aFoodForm" property="id"/>')"/>
						</c:if>
						<input type="button" title="Delete" class="buttonBG" id="delete"
							value="Xóa"   onclick="setLocation('/deleteFood.vn?id=<bean:write name="aFoodForm" property="id"/>')"/>
					</div></li>
			</ul>
			<div class="buttons-set1">
				<p class="buttons-set1 p.required">* Yêu cầu phải nhập</p>
				<br />


			</div>
		</div>
	</div>
</div>