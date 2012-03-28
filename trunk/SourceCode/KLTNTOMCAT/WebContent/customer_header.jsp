<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<div class="header" >
  <div class="header-row1" id="headerFocus" >
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
      <c:if test="${provider ==null}">
      <li class="first"><a href="/loginProvider.vn">Đăng nhập</a>        </li>
      </c:if>
      <c:if test="${provider !=null}">
      <li class="first"><a href="/logoutProviderAcc.vn">Đăng xuất</a>        </li>
      </c:if>
        <li>
            <a href="/registerProvider.vn">Đăng kí</a>        </li>
      </ul>
 </div>
 <div class="header-row3" style="background:green;" >
<div class="nav-container" >

    <ul id="nav">
    <li>
      <a
          href="/home.vn"
          class="level-top">
<img src="Images/Commons/icon-trang-chu.png" width="20" height="20" style="margin-left:-70px;"><span style="margin-left:10px;margin-top:-10px;" class="nav-text-provider"> Trang chủ</span></img>
        </a></li>
        <logic:present name="user">
        <li class="level0 nav-1 level-top first parent">
<a href="customer.vn"
          class="level-top">

<span class="nav-text-provider">Thông tin cá nhân</span>
        </a>
        <a
          href="changePass.vn"
          class="level-top">

<span class="nav-text-provider">Đổi mật khẩu</span>
        </a>
</li>
  <li class="level0 nav-4 level-top first parent">
<a href="/displayBill.vn?value=0"
          class="level-top">

<span class="nav-text-provider">Danh sách hóa đơn</span>
        </a>
        </li>
       </logic:present>
</ul>

</div>
<!-- <form id="search_mini_form" action="#" method="get">
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
</form>  -->
            </div>
      </div>
        <!-- ends .header -->