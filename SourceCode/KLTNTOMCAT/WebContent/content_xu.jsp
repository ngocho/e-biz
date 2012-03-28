<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<div class="home-spot">
  <div class="col-2 registered-users" class="login">
    <div class="content">
      <h2>ĐĂNG NHẬP</h2>
      <ul class="form-list">
        <html:form action="/addXu.vn" method="get">
          <li><label for="email" class="required" id="typeLogin"><em>*</em>Mã nhập Xu</label>
            <div class="input-box">
              <html:text property="loginId" />
            </div>
          </li>
          <li>
            <div class="input-box">
              <input type="submit" name="OK" id="pass" title="Password"
                value="Nạp xu"> <input type="reset" name="OK"
                id="reset"  value="Xóa">
            </div>
          </li>
          <li>
          <li><span style="color: red;"> <logic:messagesPresent
                message="true">
                <html:messages id="message" message="true">
                  <bean:write name="message" />
                  <br />
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