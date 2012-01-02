<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<div class="header">
  <div class="header-row1">
    <!--<h2 class="site-logo"><a href="http://foodzie.com/"><strong>Foodzie: Taste Something Different</strong></a></h2> -->

    <!-- <h2 class="site-logo site-logo-default">
                
                <a href="#"><strong>Foodzie: Taste Something Different</strong></a>                </h2> -->

    <div class="logo-sidenote">
      <p>
        <a href="#">Hãy đăng kí để thuận tiện khi mua hàng!</a>
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
<%-- <html:select property="123">
<html:option value="">Tiếng Anh
</html:option>
<html:option value="">Tiếng Việt
</html:option>
</html:select> --%>
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
                
<!--  script type="text/javascript">
    Cufon.replace('.shop-by, .site-nav', {
        fontFamily : 'Gotham Narrow Bold'
    });
</script>-->
<div class="nav-container">
    <ul id="nav">
        <li class="level0 nav-1 level-top first parent">
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
<!-- <ul class="level0">
<li class="level1 nav-1-1 first">
<a
              href="http://localhost/magento/index.php/catalog/category/view/s/living-room/id/22/">
<span>Living Room</span>
            </a>
            </li>
            <li class="level1 nav-1-2 last">
<a
              href="http://localhost/magento/index.php/catalog/category/view/s/bedroom/id/23/">
<span>Bedroom</span>
            </a>
</li>
</ul> -->
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
          href="http://localhost/magento/index.php/catalog/category/view/s/furniture/id/10/"
          class="level-top">

<span class="white-text">Gia vị</span>
        </a>
        <li class="level0 nav-2 level-top parent">
<a
          href="http://localhost/magento/index.php/catalog/category/view/s/electronics/id/13/"
          class="level-top">
<span class="white-text">Dụng cụ làm bếp</span>
        </a>

</li>  
 <li class="level0 nav-2 level-top parent">
<a
          href="http://localhost/magento/index.php/catalog/category/view/s/electronics/id/13/"
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
			<script type="text/javascript">
                jQuery(document).ready(function($) {
                    var toggle = $('.store-nav-toggle');
                    var nav = $('.store-nav');
                    var open = false;
                    /*
                    if (open && cookie) {
                      // only allow cookie to override default if on page where
                      // default is open...
                      if (cookie === 'false') {
                        open = false;
                        nav.hide();
                        toggle.removeClass('hide').addClass('show');
                      } else if (cookie === 'true') {
                        open = true;
                        nav.show();
                        toggle.removeClass('show').addClass('hide');
                      }
                    }
                    var closeTimer = null;
                    var showStoreNav = function () {
                        closeTimer = null;
                        open = true;
                        nav.slideDown();
                        toggle.removeClass('show').addClass('hide');
                        Mage.Cookies.set('showStoreNav', 'true', null, '/', '.foodzie.com');
                    };

                    var hideStoreNav = function () {
                        closeTimer = setTimeout(function () {
                            open = false;
                            nav.slideUp();
                            toggle.removeClass('hide').addClass('show');
                            Mage.Cookies.set('showStoreNav', 'false', null, '/', '.foodzie.com');
                        }, 100);
                    };

                    toggle.hover(function(e) {
                        e.preventDefault();
                        if (toggle.hasClass('hide')) {
                            hideStoreNav();
                        } else {
                            showStoreNav();
                        }
                    });
                    nav.hover(function(e) {
                        debugger;
                        e.preventDefault();
                        closeTimer = null; 
                    });
                     */
                    var timer = null;
                    toggle.mouseover(function(e) {
                        e.preventDefault();
                        if (open)
                            return;
                        clearTimeout(timer);
                        //nav.css({position:'absolute'}).fadeIn();
                        nav.slideDown();
                    });
                    toggle.mouseout(function(e) {
                        e.preventDefault();
                        if (open)
                            return;
                        timer = setTimeout(function() {
                            nav.slideUp(); /*nav.fadeOut()*/
                        }, 100);
                    });
                    nav.mouseover(function(e) {
                        e.preventDefault();
                        if (open)
                            return;
                        clearTimeout(timer);
                    });
                    nav.mouseout(function(e) {
                        e.preventDefault();
                        if (open)
                            return;
                        timer = setTimeout(function() {
                            nav.slideUp(); /*nav.fadeOut()*/
                        }, 100);
                    });

                    $('.store-nav td').mouseover(function(e) {
                        $(this).addClass('hover')
                    })
                    $('.store-nav td').mouseout(function(e) {
                        $(this).removeClass('hover')
                    })

                });
            </script>
      </div>
        <!-- ends .header -->