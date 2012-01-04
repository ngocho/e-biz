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
<div class="col-main">


<div id="messages_product_view"></div>
<div class="product-view">
    <div class="product-essential">
    <logic:present name="DetailProduct">
    <form action="http://demo.magentocommerce.com/checkout/cart/add/uenc/aHR0cDovL2RlbW8ubWFnZW50b2NvbW1lcmNlLmNvbS9jaGFpci5odG1sP19fX1NJRD1V/product/52/" method="post" id="product_addtocart_form">
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
                                    <td width="60%">x    <span class="price">$29.96</span> </td>
            <!--                         <td width="25%">
                                        <div class="qty-prod"><input id="quantity" name="quantity" value="1" class="qty-prod-input spinner-field" type="text"> </div>                                    </td> -->
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
    <img  width="380" height="400" id="image" src="Images/Foods/3.jpg" alt="Chair" title="Chair"></p>
<div class="more-views">
    <h2>More Views</h2>
    <ul>
            <li>
            <a href="#" onclick="popWin('http://demo.magentocommerce.com/catalog/product/gallery/id/52/image/176/', 'gallery', 'width=300,height=300,left=0,top=0,location=no,status=yes,scrollbars=yes,resizable=yes'); return false;" title=""><img src="resource_files/chairlarge_1.jpg" alt="" width="56" height="56"></a>
        </li>
        </ul>
</div>
        </div>

        <div class="clearer"></div>
            </form>
            </logic:present>
            
    <script type="text/javascript">
    //<![CDATA[
      /*  var productAddToCartForm = new VarienForm('product_addtocart_form');
        productAddToCartForm.submit = function(button, url) {
            if (this.validator.validate()) {
                var form = this.form;
                var oldUrl = form.action;

                if (url) {
                   form.action = url;
                }
                var e = null;
                try {
                    this.form.submit();
                } catch (e) {
                }
                this.form.action = oldUrl;
                if (e) {
                    throw e;
                }

                if (button && button != 'undefined') {
                    button.disabled = true;
                }
            }
        }.bind(productAddToCartForm);

        productAddToCartForm.submitLight = function(button, url){
            if(this.validator) {
                var nv = Validation.methods;
                delete Validation.methods['required-entry'];
                delete Validation.methods['validate-one-required'];
                delete Validation.methods['validate-one-required-by-name'];
                if (this.validator.validate()) {
                    if (url) {
                        this.form.action = url;
                    }
                    this.form.submit();
                }
                Object.extend(Validation.methods, nv);
            }
        }.bind(productAddToCartForm);*/
    //]]>
    </script>
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
    <h2>You may also be interested in the following product(s)</h2>
    <table class="products-grid" id="upsell-product-table">
                    <tbody><tr class=""> <!--first last odd-->
                                <td>
                <a href="http://demo.magentocommerce.com/magento-red-furniture-set.html" title="Magento Red Furniture Set" class="product-image"><img src="resource_files/fullsetmedium_1.jpg" alt="Magento Red Furniture Set" width="125" height="125"></a>
                <h3 class="product-name"><a href="http://demo.magentocommerce.com/magento-red-furniture-set.html" title="Magento Red Furniture Set">Magento Red Furniture Set</a></h3>
                

                <div class="price-box">
            <p class="minimal-price">
                <span class="price-label">Starting at:</span>
                                                    <span class="price" id="product-minimal-price-54-upsell">
                    $99.99                </span>
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
                                     
                                                             <td >
                <a href="http://demo.magentocommerce.com/magento-red-furniture-set.html" title="Magento Red Furniture Set" class="product-image"><img src="resource_files/fullsetmedium_1.jpg" alt="Magento Red Furniture Set" width="125" height="125"></a>
                <h3 class="product-name"><a href="http://demo.magentocommerce.com/magento-red-furniture-set.html" title="Magento Red Furniture Set">Magento Red Furniture Set</a></h3>
                

                <div class="price-box">
            <p class="minimal-price">
                <span class="price-label">Starting at:</span>
                                                    <span class="price" id="product-minimal-price-54-upsell">
                    $99.99                </span>
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
    </div><strong></strong>
                                            </td>
                                            <!--td class="empty">&nbsp;</td>
                                            <td class="empty last">&nbsp;</td-->
                            </tr>
        </tbody></table>
 
</div>
            <div class="box-collateral box-tags">
    <h2>Product Tags</h2>
            <h3>Other people marked this product with these tags:</h3>
    <ul id="product-tags_c5b99950e43c3a027aeeb3e67ab887c6" class="product-tags">
        <li class="first"><a href="http://demo.magentocommerce.com/tag/product/list/tagId/7/">furniture</a> (4)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/8/">modern</a> (2)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/12/">cool</a> (19)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/31/">red</a> (10)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/78/">lova</a> (1)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/85/">chair</a> (2)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/91/">nice</a> (14)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/102/">super</a> (6)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/113/">rouge</a> (1)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/114/">modern,</a> (1)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/115/">moderne</a> (1)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/132/">teste</a> (2)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/142/">hi</a> (5)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/145/">Canapé</a> (2)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/256/">sofa</a> (2)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/267/">world</a> (3)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/369/">comfortable</a> (2)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/397/">cozy</a> (1)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/431/">one</a> (3)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/476/">product</a> (4)</li> <li><a href="http://demo.magentocommerce.com/tag/product/list/tagId/575/">trandy</a> (1)</li> <li class="last"><a href="http://demo.magentocommerce.com/tag/product/list/tagId/687/">new</a> (5)</li>    </ul>

        <form id="addTagForm" action="http://demo.magentocommerce.com/tag/index/save/product/52/uenc/aHR0cDovL2RlbW8ubWFnZW50b2NvbW1lcmNlLmNvbS9jaGFpci5odG1s/" method="get">
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
    </form>
    <p class="note">Use spaces to separate tags. Use single quotes (') for phrases.</p>
    
</div>
    </div>
</div>

<script type="text/javascript">
    var lifetime = 3600;
    var expireAt = Mage.Cookies.expires;
    if (lifetime > 0) {
        expireAt = new Date();
        expireAt.setTime(expireAt.getTime() + lifetime * 1000);
    }
    Mage.Cookies.set('external_no_cache', 1, expireAt);
</script>
                </div>