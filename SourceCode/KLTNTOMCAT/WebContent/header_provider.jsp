<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<div class="header" >
  <div class="header-row1" id="headerFocus">
    <div class="logo-sidenote">
    </div>
    <ul class="super-links"  id="customer_super_links">
 <!--      <li>Chọn ngôn ngữ 
<select>
<option>
Tiếng Việt
</option>
<option >
Tiếng Anh
</option>

</select>
</li> -->

      <li></li>
      <c:if test="${provider ==null}">
      <li class="first"><a href="/loginProvider.vn"><span class='impressionText'>Đăng nhập</span> </a>       </li>
      </c:if>
      <c:if test="${provider !=null}">
      <li class="first"><a href="/logoutProviderAcc.vn"><span class='impressionText'>Đăng xuất </span></a>       </li>
      </c:if>
        <li>
            <a href="/registerProvider.vn"><span class='impressionText'>Đăng kí</span></a>        </li>
      </ul>
 </div>
 <div class="header-row3"  >
<div class="nav-container" >

    <ul id="nav">
    <li>
      <a
          href="/home.vn"
          class="level-top">
<img src="Images/Commons/icon-trang-chu.png" width="20" height="20" style="margin-left:-70px;"/><span style="margin-left:10px;margin-top:-10px;" class="nav-text-provider"> Trang chủ</span>
        </a>
        <a
          href="/displayProviderList.vn"
          class="level-top">
<span  class="nav-text-provider"> Danh sách cửa hàng</span>
        </a>
         <c:if test="${provider ==null}">
        <a
          href="/loginProvider.vn"
          class="level-top">
<span  class="nav-text-provider"> Đăng nhập</span>
        </a>
        </c:if>
        </li>
        <logic:present name="provider">
        <li class="level0 nav-1 level-top first parent">
<a href="#"
          class="level-top">

<span class="nav-text-provider">Thông tin cửa hàng</span>
        </a>
        <a
          href="/uploadLink.vn"
          class="level-top">

<span class="nav-text-provider">Upload sản phẩm</span>
        </a>
</li>
  <li class="level0 nav-4 level-top first parent">
<a href="/displayProduct.vn"
          class="level-top">

<span class="nav-text-provider">Danh sách sản phẩm</span>
        </a>
        </li>
          <li class="level0 nav-4 level-top first parent">
<a
          href="#"
          class="level-top">

<span class="nav-text-provider">Đơn hàng</span>
        </a></li>
       </logic:present>
</ul>

</div>
<form id="search_mini_form" action="/searchProvider.vn" method="get">
<fieldset class="form-search">
    <legend>Search Site</legend>
   <p>
          <input class="input-text input-reset inactive" name="q"
            value="Nhập tên cửa hàng" onfocus=" this.value='' ;"
            type="text" />
    <input src="Images/Commons/btn_go.png" alt="Tìm kiếm" class="btn"
            type="image" onclick ="" />
        </p>
</fieldset>
</form> 
            </div>
      </div>
        <!-- ends .header -->