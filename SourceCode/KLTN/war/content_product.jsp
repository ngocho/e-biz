<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib  uri="http://java.sun.com/jstl/core" prefix="c"%>
<script type="text/javascript">
$(document).ready(function(){
    $("#addToCart").click(function() {
        var quantity = $("#quantity").val();
        var idProduct = $("#id").val();
        addToCart(quantity,idProduct);
        return false;
    });
});
</script>
<!-- <div class="col-main"> -->
<div style="width: 770px;">

<div id="messages_product_view"></div>
<div class="product-view">
    <div class="product-essential">
    <logic:present name="DetailProduct">
    <form action="" method="post" id="product_addtocart_form">
        <div class="no-display">
            <input name="product" value="52" type="hidden">
            <input name="related_product" id="related-products-field" value="" type="hidden">
        </div>


       <div class="product-shop">
       <div id="price-slider-4913" class="price-slider">
    <ul style="width: 1368px;">
        <li>
            <div class="box-add-bag">
                <div class="box-add-bag-int">
                    <div class="box-add-bag-int-title"></div>
                    <div class="box-buble-cart">
                        <table class="spinnerHolder" width="100%" border="0">
                            <tbody>
                                <tr style="color:black;font-weight: bold; font-size: 15px;">
                                    <td width="20%"><span class="txt-price"> <input id="quantity" name="quantity" value="1" type="text" ></span></td>
                                    <td width="60%">x    <span class="price"><bean:write name="DetailProduct" property="price" /></span> </td>
                                    <td width="25%" align="center">
                                     <a href=""  id="addToCart" ><img alt="" src="Images/Commons/mua.jpg"  width="100" border="0" height="35">  </a>
                                     <input type="hidden" id="id" value="<bean:write name ="DetailProduct" property="id" />"/>
                                     </td>                                                                           
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="box-add-bag-int-desc"></div>
                </div>
            </div>
        </li>
</ul>
</div>

            <div class="product-name">
                <h1><bean:write name ="DetailProduct" property="name" /></h1>
            </div>
            <div class="product_info">      
                <table border="1" style="border-style:ridge;;border-width:2px; border-color:#98bf21;">
            <tr>
            <th >Cửa hàng cung cấp</th>
            <td width="200" class="price" style="padding:3px;" > <bean:write name="DetailProduct" property="idProvider" /></td>
            </tr>
            <tr>
            <th >Giá khuyến mãi</th>
            <td width="200" class="price" style="padding:3px;" > <bean:write name="DetailProduct" property="promoPrice" /></td>
            </tr>
            <tr>
            <th >Giá gốc</th>
            <td width="200"  class="price" style="padding:3px;" > <bean:write name="DetailProduct" property="price" /></td>
            </tr>
          <!--   <tr>
            <th > Thành phần </th>
            <td class= "info">Thông tin sơ lược về sản phẩm</td>
            </tr> -->
            <tr>
            <th > Cung cấp năng lượng  </th>
            <td width="200" style="padding:3px;"  > <bean:write name="DetailProduct" property="calo" /></td>
            </tr>
            <tr>
            <th > Số lượng </th>
            <td  width="200" style="padding:3px;" > <bean:write name="DetailProduct" property="number" /></td>
            </tr>
            </table>
            </div>
            </div>

        <div class="product-img-box">
            <p class="product-image ">
  <a href=""  ><img  width="340" height="310" id="image" src="/serveImage.vn?urlKey=<bean:write name="DetailProduct" property="urlKey"/>" alt="Chair" title="Chair"></a></p>
<div class="more-views">
  <%--   <h2>Thêm hình</h2>
    <ul>
    <logic:present name="promotionFood">
      <logic:iterate id="element" name="promotionFood" >
            <li>
            <a href="#" title=""><img src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" alt="" width="56" height="56"></a>
        </li>
        </logic:iterate>
        </logic:present>
        </ul> --%>
</div>
        </div>

        <div class="clearer"></div>
            </form>
            </logic:present>
            
   
    </div>

    <div class="product-collateral">
        <div class="box-collateral box-description">
                            <h2>Thông tin chi tiết</h2>
    <div class="std">
       <bean:write name="DetailProduct" property="detail" />    </div>
        </div>
        <div class="box-collateral box-additional">
                            <h2>Hướng dẫn nấu </h2>
                            thông tin hướng dẫn nấu ăn
   
 
        </div>
        <div class="box-collateral box-up-sell">
    <h2>Có lẽ bạn quan tâm đến những sản phẩm này ?</h2>
    <table class="products-grid" id="upsell-product-table">
                    <tbody><tr class=""> 
                     <logic:present name="promotionFood">
            <logic:iterate id="element" name="promotionFood" length="2" >
                                <td>
                <a href="" title="Hình ảnh" class="product-image"><img src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" width="250" height="250"></a>
                <h3 class="product-name"><a href="" title="Magento Red Furniture Set"><bean:write name="element" property="name"/></a></h3>
                

                <div class="price-box">
            <p class="minimal-price">
                <span class="price-label">Giá:</span>
                                                    <span class="price" id="product-minimal-price-54-upsell">
                   <bean:write name="element" property="price"/>              </span>
                            </p>
        </div>
                        <div class="ratings">
                    <div class="rating-box">
                <div class="rating" style="width: 93%;"></div>
            </div>
                <p class="rating-links">
            <a href="http://demo.magentocommerce.com/review/product/list/id/54/category/10/">2 Review(s)</a>
            <span class="separator">|</span>
            <a href="http://demo.magentocommerce.com/review/product/list/id/54/category/10/#review-form">Add Your Review</a>
        </p>
    </div>
            </td>
            </logic:iterate>
            </logic:present>
                                            <!--td class="empty">&nbsp;</td>
                                            <td class="empty last">&nbsp;</td-->
                            </tr>
        </tbody></table>
 
</div>
            <div class="box-collateral box-tags">

    <!--     <form id="addTagForm" action="http://demo.magentocommerce.com/tag/index/save/product/52/uenc/aHR0cDovL2RlbW8ubWFnZW50b2NvbW1lcmNlLmNvbS9jaGFpci5odG1s/" method="get">
        <div class="form-add">
            <label for="productTagName">Add Your Tags:</label>
            <div class="input-box">
                <input class="input-text required-entry" name="productTagName" id="productTagName" type="text">
            </div>
            <button type="button" title="Add Tags" class="button" onclick="submitTagForm()">
                <span>
                    <span>Add Tags</span>
                </span>
            </button>
        </div>
    </form> -->
    
</div>
    </div>
</div>

</div>
            <!--     </div> -->