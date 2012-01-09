<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<div class="header">
  <div class="header-row1">

    <div class="logo-sidenote">
      <p>
        <a href="/registerCustomer.vn">Hãy đăng kí để thuận tiện khi mua hàng!</a>
      </p>
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
      <li class="first"><a href="/logoutCustomer.vn">Đăng xuất</a>        </li>
      </c:if>
        <li>
            <a href="/registerCustomer.vn">Đăng kí</a>        </li>
      </ul>
<div class="block-cart_header">
      <a id="current_cart_items_count" href="/displayShoppingCart.vn"
        class="count"> <logic:present name="shop">
          <bean:write name="shop" property="count" />
        </logic:present> </a>
      <h3>
        <a href="/displayShoppingCart.vn"></a>
      </h3>
    <a href="/checkAuthentication.vn"" class="link-checkout"></a>
    </div>
 </div>
 <div class="header-row2">
                
<div class="nav-container">
    <ul id="nav">
        <li class="level0 nav-1 level-top first parent">
        <a
          href="home.vn"
          class="level-top">

<span class="white-text">Trang chủ</span>
        </a>
<a
          href="category.vn?typeProduct=1"
          class="level-top">

<span class="white-text">Thực phẩm sơ chế</span>
        </a>
        <a
          href="category.vn?typeProduct=2"
          class="level-top">

<span class="white-text">Thức ăn nấu sẵn</span>
        </a>
</li>
  <li class="level0 nav-4 level-top first parent">
<a
          href="category.vn?typeProduct=3"
          class="level-top">

<span class="white-text">Rau xanh</span>
        </a>
        </li>
          <li class="level0 nav-4 level-top first parent">
<a
          href="category.vn?typeProduct=1"
          class="level-top">

<span class="white-text">Gia vị</span>
        </a>

 <li class="level0 nav-2 level-top parent">
<a
          href="provider.vn"
          class="level-top">
<span class="white-text">Cửa hàng</span>
        </a>

</li>  
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
