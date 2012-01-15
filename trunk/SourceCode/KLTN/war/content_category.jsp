<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
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
            $active = $('#slideshow IMG:last');

        // use this to pull the images in the order they appear in the markup
        var $next = $active.next().length ? $active.next() : $('#slideshow IMG:first');

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
    $(document).ready(function() {

        var limit = $("#limit").val();
        $("#record option:selected").removeAttr('selected');
        $("#record").val("/categoryRecord.vn?limit=" + limit).attr('selected', true);

        var col = $("#col").val();
        $("#order option:selected").removeAttr('selected');
        $("#order").val("/categoryRecord.vn?col=" + col).attr('selected', true);

        var page = $("#page").val();
        if ($("a").text == page) {
            var a = $("a").text;
            a.css("color", "black");
        }

    });
</script>
<script type="text/javascript">
    $(document).ready(function() {
        $("#addToCart").click(function() {
            var quantity = $("#quantity").val();
            var idProduct = $("#id").val();
            addToCart(quantity, idProduct);
            return false;
        });
    });
</script>
<style type="text/css">

/*** set the width and height to match your images **/
#slideshow {
  position: relative;
  height: 220px;
  margin-left: 130px;
}

#slideshow IMG {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 8;
  opacity: 0.0;
}

#slideshow IMG.active {
  z-index: 10;
  opacity: 1.0;
}

#slideshow IMG.last-active {
  z-index: 9;
}
</style>
  <div class="page-title category-title">

    <h1>
      <a href="category.vn?typeProduct=1"></a>
       <% ProductVO vo = (ProductVO)session.getAttribute("productVo");
       if(vo !=null){
        String temp = vo.getTypeProduct();
        if(temp.equals("1")){
       
       %>
      Thực phẩm sơ chế
      <%}else if(temp.equals("2")) {%>
      Thức ăn nấu sẵn
      <%}else if(temp.equals("3")) {%>
      Rau xanh
      <%}else if(temp.equals("4")){ %>
     Gia vị
      <%}} %>
    </h1>
  </div>


  <p class="category-image">
  <div id="slideshow">
    <logic:present name="Food">
      <logic:iterate id="element" name="Food">
        <a href="/displayProductDetail.vn?id=<bean:write name="element" property="id"/>"><img width="300" height="200"
          src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>"
          alt="Slideshow Image 1" class="active" /> </a>
      </logic:iterate>
    </logic:present>
  </div>

  <div class="category-products">
    <div class="toolbar">
      <div class="pager">
        <p class="amount">
          <strong>Page: &nbsp;</strong> <span> <input
            type="hidden" name="page" id="page"
            value="<bean:write name="productVo" property="page"/>"></input>
            <logic:present name="productVo" property="pagingList">
              <logic:iterate id="element" name="productVo"
                property="pagingList">
                <c:choose>
                  <c:when test="${element.id ==1}">
                    <a
                      href="/categoryRecord.vn?page=<bean:write name="element" property="id"/>"><bean:write
                        name="element" property="id" /> | </a>

                  </c:when>
                  <c:otherwise>
                    <a
                      href="/categoryRecord.vn?page=<bean:write name="element" property="id"/>"><bean:write
                        name="element" property="id" /> | </a>
                  </c:otherwise>
                </c:choose>


              </logic:iterate>
            </logic:present> </span>
        </p>

        <div class="limiter">
          <label>Hiển thị </label> <input type="hidden" id="limit"
            value="<bean:write name="productVo" property="limit"/>"></input>
          <select id="record" onchange="setLocation(this.value)">
            <option value="/categoryRecord.vn?limit=8"
              selected="selected">8</option>
            <option value="/categoryRecord.vn?limit=14">14</option>
            <option value="/categoryRecord.vn?limit=30">30</option>
          </select> sản phẩm mỗi trang
        </div>
      </div>

      <div class="sorter">
        <p class="view-mode">
          <!-- <label>6 món ăn</label> -->
          <!--  <strong title="Grid" class="grid">Grid</strong>&nbsp;
                                                                <a href="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?mode=list" title="List" class="list">List</a>&nbsp;                -->
        </p>

        <div class="sort-by">
          <logic:present name="productVo">
            <c:choose>
              <c:when test="${productVo.order == 'asc'}">
                <label>Sắp xếp tăng dần theo</label>
              </c:when>
              <c:when test="${productVo.order == 'desc'}">
                <label>Sắp xếp giảm dần dần theo</label>
              </c:when>
              <c:otherwise>
               <label>Sắp xếp tăng dần theo</label>
              </c:otherwise>
            </c:choose>
          </logic:present>
          <input type="hidden" name="col" id="col"
            value="<bean:write name="productVo" property="col"/>"></input>
          <select id="order" onchange="setLocation(this.value)">
            <option value="/categoryRecord.vn?col=foodName"
              selected="selected">Tên</option>
            <option value="/categoryRecord.vn?col=price">Giá
              tiền</option>
            <option value="/categoryRecord.vn?col=reviewer">
              Lượt người xem</option>
          </select>
          
           <logic:present name="productVo">
            <c:choose>
              <c:when test="${productVo.order == 'asc'}">
                 <a style="text-decoration: none;"
              href="/categoryRecord.vn?order=desc"
              title="Set Descending Direction"><img
              src="Furniture%20-%20Magento%20Commerce%20Demo%20Store_files/i_asc_arrow.gif"
              alt="Sắp xếp giảm dần" class="v-middle">
            </a>
              </c:when>
              <c:when test="${productVo.order == 'desc'}">
                <a style="text-decoration: none;"
              href="/categoryRecord.vn?order=desc"
              title="Set Descending Direction"><img
              src="Furniture%20-%20Magento%20Commerce%20Demo%20Store_files/i_asc_arrow.gif"
              alt="Sắp xếp tăng dần " class="v-middle">
            </a>
              </c:when>
               <c:otherwise>
               <a style="text-decoration: none;"
              href="/categoryRecord.vn?order=desc"
              title="Set Descending Direction"><img
              src="Furniture%20-%20Magento%20Commerce%20Demo%20Store_files/i_asc_arrow.gif"
              alt="Sắp xếp giảm dần" class="v-middle">
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
              Lượt xem: <span class="amount" style="color: red;">
                <!-- <a href="#" onclick="var t = opener ? opener.window : window; t.location.href='http://demo.magentocommerce.com/review/product/list/id/52/category/10/'; return false;"> -->
                <bean:write name="element" property="reviewer" /> </span>
            </div>
            <div class="price-box">

              <p class="old-price">
                <span class="price-label">Giá bình thường:</span> <span
                  class="price" id="old-price-52"> <bean:write
                    name="element" property="price" /> </span>
              </p>

              <p class="special-price">
                <span class="price-label">Giá khuyến mãi:</span> <span
                  class="price" id="product-price-52"> <bean:write
                    name="element" property="promoPrice" /> </span>
              </p>
               <p class="special-price">
                <span class="price-label">Số lượng:</span> <span
                  class="price" id="product-price-52"> <bean:write
                    name="element" property="number" /> </span>
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
