<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="ebiz.form.ProductVO" %>
<script type="text/javascript">
$(document).ready(function(){
    $(".addShopping").click(function() {
        addToCart(1,$(this).attr('name'));
        return false;
    });
});
</script>

<script type="text/javascript">
function slideSwitch() {
    var $active = $('#slideshow IMG.active');

    if ($active.length == 0)
        $active = $('#slideshow  IMG:last');

    // use this to pull the images in the order they appear in the markup
    var $next = $active.next().length ? $active.next() : $('#slideshow  IMG:first');

    // uncomment the 3 lines below to pull the images in random order

    // var $sibs  = $active.siblings();
    // var rndNum = Math.floor(Math.random() * $sibs.length );
    // var $next  = $( $sibs[ rndNum ] );

    $active.addClass('last-active');

    $next.css({
        opacity : 0.0
    }).addClass('active').animate({
        opacity : 1.0
    }, 1000, function() {
        $active.removeClass('active last-active');
    });
}

    $(function() {
        setInterval("slideSwitch()", 5000);
    });
</script>
<style type="text/css">

/*** set the width and height to match your images **/

#slideshow {
  position: relative;
  height: 220px;
  margin-left: 130px;
}

#slideshow  IMG {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 8;
  opacity: 0.0;
}

#slideshow  IMG.active {
  z-index: 10;
  opacity: 1.0;
}

#slideshow  IMG.last-active {
  z-index: 9;
}

</style>
<logic:present name="flagCompare">
  <c:if test="${flagCompare =='home' && language =='vi'}">
  <script type="text/javascript" >
  $(document).ready(function(){
    alert("Không có sản phẩm để so sánh");
  });
  </script>
  </c:if>
  
     <c:if test="${flagCompare =='home' && language =='en'}">
  <script type="text/javascript" >
  $(document).ready(function(){
    alert("No product to compare");
  });
  </script>
  </c:if>
 <c:remove var="flagCompare"/>
</logic:present>
<%--  <bean:write name="flagCompare"/>
<input type="hidden" value="12" name="flagCompareName" id="flagCompareID"/> --%>
  <div class="page-title category-title">

    <h1>
      <a href="category.vn?typeProduct=1"></a>
      <logic:present name="productVo" property="typeProduct">
       <c:choose>
                  <c:when test="${productVo.typeProduct == '1'}">
                 <bean:message key="home.nav.menu1" />
                  </c:when>
                  <c:when test="${productVo.typeProduct == 2}">
                 <bean:message key="home.nav.menu2" />
                  </c:when>
                  <c:when test="${productVo.typeProduct == 3}">
                 <bean:message key="home.nav.menu3" />
                  </c:when>
                  <c:when test="${productVo.typeProduct == 4}">
                 <bean:message key="home.nav.menu4" />
                  </c:when>
      </c:choose>
      </logic:present>
    </h1>
  </div>


  <p class="category-image">
  <div id="slideshow">
    <logic:present name="Food">
      <logic:iterate id="element" name="Food" indexId="index" >
           <c:choose>
                  <c:when test="${index == 0}">
                    <img  width="300" height="200" src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>"
          alt="Slideshow Image 1" class="active" /> 
                  </c:when>
                  <c:otherwise>
                 <img  width="300" height="200" src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>"
          alt="Slideshow Image 1" />
                  </c:otherwise>
                </c:choose>
      </logic:iterate>
    </logic:present>
  </div>

  <div class="category-products">
    <div class="toolbar">
      <div class="pager">
        <p class="amount">
          <strong><bean:message key="category.content.page" />: &nbsp;</strong> <span> <input
            type="hidden" name="page" id="page"
            value="<bean:write name="productVo" property="page"/>"></input>
            <logic:present name="productVo" property="pagingList">
              <logic:iterate id="element" name="productVo"
                property="pagingList">
                <c:choose>
                  <c:when test="${element == productVo.page}">
                    <a
                      href="/categoryRecord.vn?page=<bean:write name="element" />">
                      <span class ="keepLink"><bean:write name="element" /></span></a>

                  </c:when>
                  <c:otherwise>
                    <a
                      href="/categoryRecord.vn?page=<bean:write name="element" />"><bean:write
                        name="element"  /> </a>
                  </c:otherwise>
                </c:choose>


              </logic:iterate>
            </logic:present> </span>
        </p>

        <div class="limiter">
          <label><bean:message key="category.content.display" /> </label> <input type="hidden" id="limit"
            value="<bean:write name="productVo" property="limit"/>"></input>
          <select id="record" onchange="setLocation(this.value)">
              <c:choose>
              <c:when test="${productVo.limit == '14'}">
            <option value="/categoryRecord.vn?limit=8"
              >8</option>
            <option value="/categoryRecord.vn?limit=14" selected="selected">14</option>
            <option value="/categoryRecord.vn?limit=30">30</option>
            </c:when>
            <c:when test="${productVo.limit == '30'}">
            <option value="/categoryRecord.vn?limit=8"
              >8</option>
            <option value="/categoryRecord.vn?limit=14" >14</option>
            <option value="/categoryRecord.vn?limit=30" selected="selected">30</option>
            </c:when>
            <c:otherwise>
             <option value="/categoryRecord.vn?limit=8"
              selected="selected">8</option>
            <option value="/categoryRecord.vn?limit=14" >14</option>
            <option value="/categoryRecord.vn?limit=30">30</option>
            </c:otherwise>
            </c:choose>
          </select>
          
          <bean:message key="category.content.display1" />
        </div>
      </div>

      <div class="sorter">
        <p class="view-mode">
        </p>

        <div class="sort-by">
          <logic:present name="productVo">
            <c:choose>
              <c:when test="${productVo.order == 'asc'}">
                <label><bean:message key="category.content.order" /></label>
              </c:when>
              <c:when test="${productVo.order == 'desc'}">
                <label><bean:message key="category.content.order1" /></label>
              </c:when>
              <c:otherwise>
               <label><bean:message key="category.content.order" /></label>
              </c:otherwise>
            </c:choose>
          </logic:present>
          <input type="hidden" name="col" id="col"
            value="<bean:write name="productVo" property="col"/>"></input>
          <select id="order" onchange="setLocation(this.value)">
            <c:choose>
              <c:when test="${productVo.col == 'saleProduct'}">
            <option value="/categoryRecord.vn?col=foodName"><bean:message key="category.content.order.value1" /></option>
              <option value="/categoryRecord.vn?col=price"><bean:message key="category.content.order.value2" /></option>
            <option value="/categoryRecord.vn?col=saleProduct" selected="selected">
              <bean:message key="category.content.order.value3" /></option>
              </c:when>
              <c:when test="${productVo.col == 'price'}">
            <option value="/categoryRecord.vn?col=foodName"
              ><bean:message key="category.content.order.value1" /></option>
              <option value="/categoryRecord.vn?col=price" selected="selected"><bean:message key="category.content.order.value2" /></option>
            <option value="/categoryRecord.vn?col=saleProduct">
              <bean:message key="category.content.order.value3" /></option>
              </c:when>
               <c:otherwise>
               <option value="/categoryRecord.vn?col=foodName"
              selected="selected"><bean:message key="category.content.order.value1" /></option>
              <option value="/categoryRecord.vn?col=price"><bean:message key="category.content.order.value2" /></option>
            <option value="/categoryRecord.vn?col=saleProduct" >
             <bean:message key="category.content.order.value3" /></option>
               </c:otherwise>
               </c:choose>
          </select>
          
           <logic:present name="productVo">
            <c:choose>
              <c:when test="${productVo.order == 'asc'}">
                 <a style="text-decoration: none;"
              href="/categoryRecord.vn?order=desc"
              title="Set Descending Direction"><bean:message key="category.content.order1" />
            </a>
              </c:when>
              <c:when test="${productVo.order == 'desc'}">
                <a style="text-decoration: none;"
              href="/categoryRecord.vn?order=asc"
              title="Set Descending Direction"><bean:message key="category.content.order" />
            </a>
              </c:when>
               <c:otherwise>
               <a style="text-decoration: none;"
              href="/categoryRecord.vn?order=desc"
              title="Set Descending Direction"><bean:message key="category.content.order1" />
            </a>
               </c:otherwise>
            </c:choose>
          </logic:present>
        </div>
      </div>
    </div>


    <ul class="products-grid first odd">
      <logic:present name="Food">
        <logic:iterate id="element" name="Food">
          <li class="item "><a
            href="/displayProductDetail.vn?id=<bean:write name="element" property="id"/>"
            title="" class="product-image"><img
              src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>"
              alt="Chair" width="240" height="255">
          </a>
            <h2 class="product-name">
              <a
                href="/displayProductDetail.vn?id=<bean:write name="element" property="id"/>"
                title="Chair"><bean:write name="element"
                  property="name" /> </a>
            </h2>
            <div class="ratings">
              <div class="rating-box">
                <div class="rating" style="width: 87%;"></div>
              </div>
              <bean:message key="home.content.food.id" />: <span class="amount" style="color: red;">
                <!-- <a href="#" onclick="var t = opener ? opener.window : window; t.location.href='http://demo.magentocommerce.com/review/product/list/id/52/category/10/'; return false;"> -->
                <bean:write name="element" property="id" /> </span>
            </div>
            <div class="price-box">

              <p class="old-price">
                <span class="price-label"><bean:message key="home.content.food.price" />:</span> <span
                  class="price" id="old-price-52"> <bean:write
                    name="element" property="price" /> </span>
              </p>

              <p class="special-price">
                <span class="price-label"><bean:message key="home.content.food.priceP" />:</span> <span
                  class="price" id="product-price-52"> <bean:write
                    name="element" property="promoPrice" /> </span>
              </p>
               <p class="special-price">
                <span class="price-label"><bean:message key="category.content.number" />:</span> <span
                  class="price" id="product-price-52"> <bean:write
                    name="element" property="number" /> </span>
              </p>
               <p >
                <a href="/compareFood.vn?screen=category&id=<bean:write name="element" property="id" />" style="color:blue;"> 
                <bean:message key="home.content.food.compare" /></a>
              </p>
            </div>
            <div class="actions">
              <a
                href="/displayProductDetail.vn?id=<bean:write name="element" property="id" />"><img
                src="Images/Commons/xem.jpg" width="70"></img>
              </a> <a name="<bean:write name="element" property="id"/>" class="addShopping"
                href=""
                ><img src="Images/Commons/mua.jpg"
                width="70"></img>
              </a>
            </div>
          </li>
        </logic:iterate>
      </logic:present>

    </ul>

  </div>
