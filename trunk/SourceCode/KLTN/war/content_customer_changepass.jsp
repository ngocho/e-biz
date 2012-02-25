<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<div class="page-title category-title">
  <h1>Đổi mật khẩu</h1>
</div>
<form action="/changePassword.vn" method="GET">
  <ul class="form-list">

    <li><label for="email" class="required" id="typeLogin"><em>*</em>
        Nhập mật khẩu cũ:</label>
      <div class="input-box">
        <input type="password" name="oldPass" />
      </div></li>
    <li><label for="email" class="required" id="typeLogin"><em>*</em>
        Nhập mật khẩu mới:</label>
      <div class="input-box">
        <input type="password" name="newPass" />
      </div></li>
    <li><label for="email" class="required" id="typeLogin"><em>*</em>
        Nhập lại mật khẩu mới:</label>
      <div class="input-box">
        <input type="password" name="reNew" />
      </div></li>
      <li>
            <div class="input-box">
              <input type="submit" class="buttonBG" name="change" id="login" title="Password" value="Thay đổi">
        <!--        <input type="button"  class="buttonBG" name="reset"
                id="reset" title="Password" value="Xóa hết"  > -->
            </div>
          </li>
       <li><span style="color: red;" id="message"> 
          <logic:messagesPresent message="true">
                <!-- display message return by action-->
                <html:messages id="message" message="true">
                  <bean:write name="message" />
                </html:messages>
          </logic:messagesPresent> 
          </span></li>
  </ul>
</form>