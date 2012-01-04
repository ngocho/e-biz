<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<div class="header">
  <div class="header-row1">
    <div class="logo-sidenote">
    </div>
    <ul class="super-links" style="" id="customer_super_links">
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
      <c:if test="${user ==null}">
      <li class="first"><a href="/loginCustomer.vn">Đăng nhập</a>        </li>
      </c:if>
      <c:if test="${user !=null}">
      <li class="first"><a href="/loginCustomer.vn">Đăng xuất</a>        </li>
      </c:if>
        <li>
            <a href="/registerCustomer.vn">Đăng kí</a>        </li>
        <!--li class="last">
            <a href="http://foodzie.com/newsletter_signup/" onclick="showNewsletterModal(); return false;">Join Mailing List</a>        </li-->
      </ul>
 </div>
 <div class="header-row2">
<div class="nav-container">
    <ul id="nav">
        <li class="level0 nav-1 level-top first parent">
<a href="category.vn?typeProduct=1"
          class="level-top">

<span class="white-text">Thông tin cửa hàng</span>
        </a>
        <a
          href="category.vn?typeProduct=2"
          class="level-top">

<span class="white-text">Upload sản phẩm</span>
        </a>
</li>
  <li class="level0 nav-4 level-top first parent">
<a href="category.vn?typeProduct=3"
          class="level-top">

<span class="white-text">Danh sách sản phẩm</span>
        </a>
        </li>
          <li class="level0 nav-4 level-top first parent">
<a
          href="http://localhost/magento/index.php/catalog/category/view/s/furniture/id/10/"
          class="level-top">

<span class="white-text">Đơn hàng</span>
        </a>
</ul>
</div>
<form id="search_mini_form" action="#" method="get">
<fieldset class="form-search">
    <legend>Search Site</legend>
   <p>
          <input class="input-text input-reset inactive" name="q"
            value="Nhập tên thức ăn" onfocus=" this.value='' ;"
            type="text" />
    <input src="Images/Commons/btn_go.png" alt="Tìm kiếm" class="btn"
            type="image" onclick ="" />
        </p>
</fieldset>
</form> 
            </div>
      </div>
        <!-- ends .header -->