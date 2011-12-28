<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib  uri="http://java.sun.com/jstl/core" prefix="c"%>
<script type="text/javascript">


function slideSwitch() {
    var $active = $('#slideshow IMG.active');

    if ( $active.length == 0 ) $active = $('#slideshow IMG:last');

    // use this to pull the images in the order they appear in the markup
    var $next =  $active.next().length ? $active.next()
        : $('#slideshow IMG:first');

    // uncomment the 3 lines below to pull the images in random order
    
    // var $sibs  = $active.siblings();
    // var rndNum = Math.floor(Math.random() * $sibs.length );
    // var $next  = $( $sibs[ rndNum ] );


    $active.addClass('last-active');

    $next.css({opacity: 0.0})
        .addClass('active')
        .animate({opacity: 1.0}, 1000, function() {
            $active.removeClass('active last-active');
        });
}

$(function() {
    setInterval( "slideSwitch()", 5000 );
});
$(document).ready(function(){
    
     var limit = $("#limit").val();
     $("#record option:selected").removeAttr('selected');
     $("#record").val("/categoryRecord.vn?limit="+limit).attr('selected',true);
     
     var col = $("#col").val();
     $("#order option:selected").removeAttr('selected');
     $("#order").val("/categoryRecord.vn?col="+col).attr('selected',true);
    
     var page = $("#page").val();
     if ($("a").text == page){
         var a = $("a").text;
         a.css("color", "black");
     }
     
    

});



</script>
<style type="text/css">

/*** set the width and height to match your images **/

#slideshow {
    position:relative;
    height:220px;
    margin-left : 130px;
}

#slideshow IMG {
    position:absolute;
    top:0;
    left:0;
    z-index:8;
    opacity:0.0;
}

#slideshow IMG.active {
    z-index:10;
    opacity:1.0;
}

#slideshow IMG.last-active {
    z-index:9;
}

</style>
<div class="home-spot">
                                                <div class="page-title category-title">
            <!--a href="http://demo.magentocommerce.com/rss/catalog/category/cid/10/store_id/1/" class="link-rss">Subscribe to RSS Feed</a-->
        <h1>Thực phẩm sơ chế</h1>
</div>


    <p class="category-image">
    <div id="slideshow">
    <a href="#"><img width ="320" height="220" src="Images/Foods/1.jpg" alt="Slideshow Image 1" class="active" /> </a>
    <a href="#"><img width ="320" height="220" src="Images/Foods/2.jpg" alt="Slideshow Image 2" /></a>
    <a href="#"><img width ="320" height="220" src="Images/Foods/3.jpg" alt="Slideshow Image 3" /></a>
    <a href="#"><img width ="320" height="220" src="Images/Foods/4.jpg" alt="Slideshow Image 4" /></a>
</div>
    </p>

    <div class="category-products">
    <div class="toolbar">
    <div class="pager">
        <p class="amount">
                            <strong>Page: &nbsp;</strong> 
                          
                              <span >
                               <input type="hidden" id="page" value ="<bean:write name="productVo" property="page"/>"></input>
<logic:present name="productVo" property="pagingList">
<logic:iterate id="element"  name="productVo" property="pagingList">
<c:choose>
<c:when test="${element.id ==1}">
                              <a href="/categoryRecord.vn?page=<bean:write name="element" property="id"/>" ><bean:write name="element" property="id"/>  | </a> 
           
</c:when>

<c:when test="${element.id >1 && element.id < 5}">
                              <a href="/categoryRecord.vn?page=<bean:write name="element" property="id"/>" ><bean:write name="element" property="id"/> | </a> 
           
</c:when>
<c:when test="${element.id == 5}">
<a href="<bean:write name="element" property="cursorString"/>">Trang sau </a> 
</c:when>
<c:otherwise>

</c:otherwise>
</c:choose>

 
</logic:iterate>
</logic:present>                              
                              </span>                 </p>

        <div class="limiter">
            <label>Hiển thị </label>
           
            <input type="hidden" id="limit" value ="<bean:write name="productVo" property="limit"/>"></input>
            <select id="record" onchange="setLocation(this.value)">
                            <option value="/categoryRecord.vn?limit=8" selected="selected">
                    8                </option>
                            <option value="/categoryRecord.vn?limit=14">
                    14                </option>
                            <option value="/categoryRecord.vn?limit=30">
                    30                </option>
           </select> sản phẩm mỗi trang        </div>
    </div>

        <div class="sorter">
                <p class="view-mode">
                                    <label>6 món ăn</label>
                                               <!--  <strong title="Grid" class="grid">Grid</strong>&nbsp;
                                                                <a href="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?mode=list" title="List" class="list">List</a>&nbsp;                -->                                 </p>
            
        <div class="sort-by">
            <label >Sắp xếp tăng dần theo</label>
            <input type="hidden" id="col" value ="<bean:write name="productVo" property="col"/>"></input>
            <select id="order" onchange="setLocation(this.value)">
                            <option value="/categoryRecord.vn?col=foodName" selected="selected">
                    Tên                </option>
                            <option value="/categoryRecord.vn?col=price" >
                    Giá tiền                </option>
                           <option value="/categoryRecord.vn?col=reviewer" >
                    Lượt người xem               </option>
                        </select>
                            <a style="text-decoration: none;" href="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?dir=desc&amp;order=price" title="Set Descending Direction"><img src="Furniture%20-%20Magento%20Commerce%20Demo%20Store_files/i_asc_arrow.gif" alt="Sắp xếp giảm dần" class="v-middle"></a>                    </div>
    </div>
    </div>
        
    
                            <ul class="products-grid first odd">
<logic:present name="Food">
<logic:iterate id="element" name="Food">
                    <li class="item ">
                <a href="/displayProductDetail.vn?id=<bean:write name="element" property="id"/>" title="" class="product-image"><img src="<bean:write name="element" property="url"/>" alt="Chair" width="260" height="255"></a>
                <h2 class="product-name"><a href="/displayProductDetail.vn?id=<bean:write name="element" property="id"/>" title="Chair"><bean:write name="element" property="id"/>
                </a></h2>
                                    <div class="ratings">
                    <div class="rating-box">
                <div class="rating" style="width: 87%;"></div>
            </div>
               Lượt xem:  <span class="amount" style= "color:red;"><!-- <a href="#" onclick="var t = opener ? opener.window : window; t.location.href='http://demo.magentocommerce.com/review/product/list/id/52/category/10/'; return false;"> -->
            <bean:write name="element" property="reviewer"/>
</span>    </div>
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
            </div>
            <div class="actions">
                <a href="/displayProductDetail?id=<bean:write name="element" property="id" />"><img src="Images/Commons/xem.jpg" width="70"></img></a>
                <a href="" id="#buy"><img src="Images/Commons/mua.jpg" width="70"></img></a>
              <!-- <button type="button" title="Add to Cart"
                class="button btn-cart"
                onclick="setLocation('http://demo.magentocommerce.com/checkout/cart/add/uenc/aHR0cDovL2RlbW8ubWFnZW50b2NvbW1lcmNlLmNvbS9jYXRhbG9nL2NhdGVnb3J5L3ZpZXcvcy9iZWQtYW5kLWJhdGgvaWQvMTAv/product/52/')">
                <span><span>Mua sản phẩm</span>
                </span>
              </button> -->
             <!--  <ul class="add-to-links">
                <li><a
                  href="https://demo.magentocommerce.com/wishlist/index/add/product/52/"
                  class="link-wishlist">Add to Wishlist</a>
                </li>
                <li><span class="separator">|</span> <a
                  href="http://demo.magentocommerce.com/catalog/product_compare/add/product/52/uenc/aHR0cDovL2RlbW8ubWFnZW50b2NvbW1lcmNlLmNvbS9jYXRhbG9nL2NhdGVnb3J5L3ZpZXcvcy9iZWQtYW5kLWJhdGgvaWQvMTAv/"
                  class="link-compare">Add to Compare</a>
                </li>
              </ul> -->
            </div></li>
</logic:iterate>
</logic:present>

                </ul>
                       
    
    <div class="toolbar-bottom">
        <div class="toolbar">
    <div class="pager">
        <p class="amount">
                            <strong>6 Item(s)</strong>                    </p>

        <div class="limiter">
            <label>Show</label>
            <select onchange="setLocation(this.value)">
                            <option value="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?limit=9" selected="selected">
                    8                </option>
                            <option value="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?limit=15">
                    14                </option>
                            <option value="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?limit=30">
                    30                </option>
                        </select> per page        </div>
    </div>

        <div class="sorter">
                <p class="view-mode">
                                    <label>View as:</label>
                                                <strong title="Grid" class="grid">Grid</strong>&nbsp;
                                                                <a href="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?mode=list" title="List" class="list">List</a>&nbsp;                                                </p>
            
        <div class="sort-by">
            <label>Sort By</label>
            <select onchange="setLocation(this.value)">
                            <option value="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?dir=asc&amp;order=position">
                    Position                </option>
                            <option value="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?dir=asc&amp;order=name">
                    Name                </option>
                            <option value="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?dir=asc&amp;order=price" selected="selected">
                    Price                </option>
                            <option value="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?dir=asc&amp;order=contrast_ratio">
                    Contrast Ratio                </option>
                        </select>
                            <a href="http://demo.magentocommerce.com/catalog/category/view/s/bed-and-bath/id/10/?dir=desc&amp;order=price" title="Set Descending Direction"><img src="Furniture%20-%20Magento%20Commerce%20Demo%20Store_files/i_asc_arrow.gif" alt="Set Descending Direction" class="v-middle"></a>                    </div>
    </div>
    </div>
    </div>
</div>
                    </div>