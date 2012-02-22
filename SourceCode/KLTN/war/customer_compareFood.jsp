<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<script type="text/javascript">
$(document).ready(function(){
    $(".updateShopping").click(function() {
        var index = $(this).attr('rel');
        var id = $(this).attr('name');
        var number = $("#"+index).val();
        updateNumberProduct(id,number,index);
        return false;
    });
});
</script>
                                        <div class="cart">
    <div class="page-title title-buttons">
        <h1>So sánh</h1>
       
              <ul class="checkout-types">
              
                            </ul>
            </div>
        <fieldset>
        <span > Sản phẩm đã chọn </span>
         <ul class="products-grid first odd">
      <logic:present name="orginalCompare">
     
          <li class="item" style="margin-left:200px; margin-right:auto" ><a
            href="/displayProductDetail.vn?id=<bean:write name="orginalCompare" property="id"/>"
            title="" class="product-image"><img
              src="/serveImage.vn?urlKey=<bean:write name="orginalCompare" property="urlKey"/>"
              alt="Chair" width="240" height="255">
          </a>
            <h2 class="product-name">
              <a
                href="/displayProductDetail.vn?id=<bean:write name="orginalCompare" property="id"/>"
                title="Chair"><bean:write name="orginalCompare"
                  property="name" /> </a>
            </h2>
            <div class="ratings">
              <div class="rating-box">
                <div class="rating" style="width: 87%;"></div>
              </div>
              Mã món ăn: <span class="amount" style="color: red;">
                <!-- <a href="#" onclick="var t = opener ? opener.window : window; t.location.href='http://demo.magentocommerce.com/review/product/list/id/52/category/10/'; return false;"> -->
                <bean:write name="orginalCompare" property="id" /> </span>
            </div>
            <div class="price-box">

              <p class="old-price">
                <span class="price-label">Giá bình thường:</span> <span
                  class="price" id="old-price-52"> <bean:write
                    name="orginalCompare" property="price" /> </span>
              </p>

              <p class="special-price">
                <span class="price-label">Giá khuyến mãi:</span> <span
                  class="price" id="product-price-52"> <bean:write
                    name="orginalCompare" property="promoPrice" /> </span>
              </p>
               <p class="special-price">
                <span class="price-label">Số lượng:</span> <span
                  class="price" id="product-price-52"> <bean:write
                    name="orginalCompare" property="number" /> </span>
              </p>
            </div>
            <%-- <div class="actions">
              <a
                href="/displayProductDetail.vn?id=<bean:write name="orginalCompare" property="id" />"><img
                src="Images/Commons/xem.jpg" width="70"></img>
              </a> <a name="<bean:write name="orginalCompare" property="id"/>" class="addShopping"
                href=""
                ><img src="Images/Commons/mua.jpg"
                width="70"></img>
              </a>
            </div> --%>
          </li>
      </logic:present>

    </ul>
    <span class="impressionText"> Sản phẩm ở những cửa hàng khác </span>
             <ul class="products-grid first odd">
      <logic:present name="valueCompare">
        <logic:iterate id="element" name="valueCompare">
          <li class="item " ><a
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
              Mã món ăn: <span class="amount" style="color: red;">
                <!-- <a href="#" onclick="var t = opener ? opener.window : window; t.location.href='http://demo.magentocommerce.com/review/product/list/id/52/category/10/'; return false;"> -->
                <bean:write name="element" property="id" /> </span>
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
            <%-- <div class="actions">
              <a
                href="/displayProductDetail.vn?id=<bean:write name="element" property="id" />"><img
                src="Images/Commons/xem.jpg" width="70"></img>
              </a> <a name="<bean:write name="element" property="id"/>" class="addShopping"
                href=""
                ><img src="Images/Commons/mua.jpg"
                width="70"></img>
              </a>
            </div> --%>
          </li>
        </logic:iterate>
      </logic:present>

    </ul>

           
        </fieldset>

</div>
