<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<div class="header" >
<div >
      <c:if test="${admin !=null}"> <span class="impressionText"> Admin : 
       <bean:write name="admin"/>
        </span>
        </c:if>
    </div>
  <div class="header-row1" id="headerFocus">
    
    <ul class="super-links"  id="customer_super_links">
      <li>Lựa chọn ngôn ngữ 
<select>
<option>
Tiếng Việt
</option>
<option >
Tiếng Anh
</option>

</select>
</li>

      <li></li>
      <c:if test="${admin !=null}">
      <li class="first"><a href="/logoutAdmin.vn"><span  style="color:white;">Đăng xuất</span></a>        </li>
     
      </c:if>
      </ul>
 </div>
 <div class="header-row3"  style="background:green">
<div class="nav-container"  >

    <ul id="nav">
    <li>
      <a
          href="/home.vn"
          class="level-top">
<img src="Images/Commons/icon-trang-chu.png" width="20" height="20" style="margin-left:-70px;"><span style="margin-left:10px;margin-top:-10px;" class="nav-text-provider"> Trang chủ</span></img>
        </a></li>
        <logic:present name="admin">
        <li class="level0 nav-1 level-top first parent">
<a href="/registerAd.vn"
          class="level-top">

<span class="nav-text-provider">Đăng kí Admin</span>
        </a>
        <a
          href="/adminAuthentication.vn"
          class="level-top">

<span class="nav-text-provider">Sản phẩm</span>
        </a>
</li>
  <li class="level0 nav-4 level-top first parent">
<a href="#"
          class="level-top">

<span class="nav-text-provider">Nhà cung cấp</span>
        </a>
        </li>
          <li class="level0 nav-4 level-top first parent">
<a
          href="/displayCustomerCategory.vn"
          class="level-top">

<span class="nav-text-provider">Khách hàng</span>
        </a></li>
                  <li class="level0 nav-4 level-top first parent">
<a
          href="#"
          class="level-top">

<span class="nav-text-provider">Nhân viên</span>
        </a></li>
        <li class="level0 nav-4 level-top first parent">
<a
          href="/displayBillCategory.vn"
          class="level-top">
<span class="nav-text-provider">Hóa đơn</span>
        </a></li>
        <li class="level0 nav-4 level-top first parent">
<a
          href="xuAdmin.vn"
          class="level-top">

<span class="nav-text-provider">Thẻ Xu</span>
        </a></li>
       </logic:present>
</ul>

</div>
            </div>
      </div>
