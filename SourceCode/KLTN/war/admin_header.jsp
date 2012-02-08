<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<div class="header" >
  <div class="header-row1" id="headerFocus">
    <div class="logo-sidenote">
    </div>
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
      <c:if test="${admin ==null}">
      <li class="first"><a href="/loginProvider.vn">Đăng nhập</a>        </li>
      </c:if>
      <c:if test="${admin !=null}">
      <li class="first"><a href="/logoutProviderAcc.vn">Đăng xuất</a>        </li>
      </c:if>
        <li>
            <a href="/registerProvider.vn">Đăng kí</a>        </li>
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
<a href="#"
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
<a href="/displayProduct.vn"
          class="level-top">

<span class="nav-text-provider">Nhà cung cấp</span>
        </a>
        </li>
          <li class="level0 nav-4 level-top first parent">
<a
          href="#"
          class="level-top">

<span class="nav-text-provider">Khách hàng</span>
        </a></li>
                  <li class="level0 nav-4 level-top first parent">
<a
          href="#"
          class="level-top">

<span class="nav-text-provider">Nhân viên</span>
        </a></li>
       </logic:present>
</ul>

</div>
            </div>
      </div>