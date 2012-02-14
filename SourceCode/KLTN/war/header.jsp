<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<div class="header">
  <div class="header-row1" >
    <ul class="super-links" style="" id="customer_super_links">
      <li><span style="color:black;">Lựa chọn ngôn ngữ </span>
<select>
<option>
Tiếng Việt
</option>
<option >
Tiếng Anh
</option>

</select>
</li>
</ul>
 </div>
 <div class="header-row2" id="headerNav">
                
<div class="nav-container" id="headerHome">
    <ul id="nav" style="width:738px;" >
        <li class="level0 nav-1 level-top first parent">
        <a
          href="home.vn"
          class="level-top">
<img src="Images/Commons/icon-trang-chu.png" width="20" height="20" style="margin-left:-70px;" /><span style="margin-left:10px;margin-top:-10px;" class="nav-text"> Trang chủ</span>
        </a>
<a
          href="category.vn?typeProduct=1"
          class="level-top">

<span class="nav-text">Thực phẩm sơ chế</span>
        </a>
        <a
          href="category.vn?typeProduct=2"
          class="level-top">

<span class="nav-text">Thức ăn nấu sẵn</span>
        </a>
</li>
  <li class="level0 nav-4 level-top first parent">
<a
          href="category.vn?typeProduct=3"
          class="level-top">

<span class="nav-text">Rau xanh</span>
        </a>
        </li>
          <li class="level0 nav-4 level-top first parent">
<a
          href="category.vn?typeProduct=4"
          class="level-top">

<span class="nav-text">Trái cây</span>
        </a>

 <li class="level0 nav-2 level-top parent">
<a
          href="provider.vn"
          class="level-top">
<span class="nav-text">Cửa hàng</span>
        </a>

</li> 
  <c:if test="${user !=null}">
    <li class="level0 nav-2 level-top parent">
<a         href="customer.vn"
            class="level-top">
<span class="nav-text">Tài khoản</span>
        </a>
</li>
</c:if>

</ul>
</div>
 <html:form action="/search.vn" method="GET">
<fieldset class="form-search">
    <legend>Search Site</legend>
   <p>
   <html:text property="searchText" size="32" value="Nhập tên thức ăn" onfocus="this.value='' ;" styleClass="input-text input-reset inactive" />
            <html:hidden property="type" value="0"/>
             <html:hidden property="attr" value="0"/>
              <html:hidden property="price" value="0"/>
               <html:hidden property="status" value="0"/>

    <input src="Images/Commons/btn_go.png" alt="Tìm kiếm" class="btn"
            type="image" onclick ="" />
        </p>
</fieldset>
</html:form>
            </div>
      </div>
