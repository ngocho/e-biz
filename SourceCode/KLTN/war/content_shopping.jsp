<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<div class="main">
                                <div class="col-main">
                                        <div class="cart">
    <div class="page-title title-buttons">
        <h1>Shopping Cart</h1>
                <ul class="checkout-types">
                                                                                            <li>    <button type="button" title="Proceed to Checkout" class="button btn-proceed-checkout btn-checkout" onclick="window.location='https://demo.magentocommerce.com/checkout/onepage/';"><span><span>Proceed to Checkout</span></span></button>
</li>
                            </ul>
            </div>
            <form action="/checkAuthentication.vn" method="post" id="idForm">
        <fieldset>
            <table id="shopping-cart-table" class="data-table cart-table">
                <colgroup><col width="1">
                <col>
                <col width="1">
                                        <col width="1">
                                        <col width="1">
                            <col width="1">
                                        <col width="1">

                            </colgroup><thead>
                    <tr class="first last">
                        <th rowspan="1">&nbsp;</th>
                        <th rowspan="1"><span class="nobr">Product Name</span></th>
                       <!--  <th rowspan="1"></th> -->
                                                <th class="a-center" colspan="1"><span class="nobr">Unit Price</span></th>
                        <th rowspan="1" class="a-center">Qty</th>
                        <th class="a-center" colspan="1">Subtotal</th>
                        <th rowspan="1" class="a-center">&nbsp;</th>
                    </tr>
                                    </thead>
                <tfoot>
                    <tr class="first last">
                        <td colspan="50" class="a-right last">
                        <input type="hidden" name="type" value="0"/>
                                                        <button type="button" title="Continue Shopping" class="button btn-continue" onclick="setLocation('http://demo.magentocommerce.com/')"><span><span>Continue Shopping</span></span></button>
                                                        <button type="button"  id="updateSC"  title="Update Shopping Cart" class="button btn-update"><span><span>Cập nhật</span></span></button>
                                                        <button type="submit" title="Check Out Shopping Cart"  id ="checkout" class="button btn-update"><span><span>Thanh toán</span></span></button>
                        </td>
                    </tr>
                </tfoot>
                <tbody>
                
                <logic:present name="shop" property="products">
                <logic:iterate id="element"  name="shop" property="products">
                <tr class="first last odd">
    <td><a href="" title="Chair" class="product-image"><img src="<bean:write name="element" property="url"/>" alt="Chair" width="75" height="75"/></a></td>
    <td>
        <h2 class="product-name">
        <input type="hidden" name="idFood" value="<bean:write name="element"  property="id" />" />
                    <a href="http://demo.magentocommerce.com/chair.html"><bean:write name="element" property="name" /> </a>
                </h2>
                                                </td>
   <!--  <td class="a-center">
                <a href="/editProductShopping" title="Edit item parameters">Edit</a>
            </td>
     -->
    
                <td class="a-right">
                            <span class="cart-price">
                                                <span class="price"><bean:write name="element" property="price" />  </span>                
            </span>


                    </td>
                        <td class="a-center">
        <input name="<bean:write name="element" property="id"/>" value="1" size="4"  id="<bean:write name="element" property="id"/>.update" title="Qty" class="input-text qty" maxlength="12" onblur="onchange(this);"/>
        
    </td>
        <td class="a-right">
                    <span class="cart-price">
        
                                                <span class="price"><bean:write name="element" property="subTotal"/></span>                            
        </span>
            </td>
            <td class="a-center last"><a href="http://demo.magentocommerce.com/checkout/cart/delete/id/495540/uenc/aHR0cDovL2RlbW8ubWFnZW50b2NvbW1lcmNlLmNvbS9jaGVja291dC9jYXJ0Lw,,/" title="Remove item"  class="a-center">Xóa</a></td>
</tr>
</logic:iterate>
</logic:present>

                                </tbody>
            </table>
           
        </fieldset>
    </form>
    <div class="cart-collaterals">
        <div class="col2-set">
            <div class="col-1">
                <div class="crosssell">
    <h2>Based on your selection, you may be interested in the following items:</h2>
    <ul id="crosssell-products-list">
            <li class="item odd">
            <a class="product-image" href="http://demo.magentocommerce.com/akio-dresser.html" title="Akio Dresser"><img src="js/palermo.jpg" alt="Akio Dresser" width="75" height="75"></a>
            <div class="product-details">
                <h3 class="product-name"><a href="http://demo.magentocommerce.com/akio-dresser.html">Akio Dresser</a></h3>
                

        
    <div class="price-box">
                                                            <span class="regular-price" id="product-price-41">
                    <span class="price">$399.99</span>                </span>
                        
        </div>

                <button type="button" title="Add to Cart" class="button btn-cart" onclick="setLocation('http://demo.magentocommerce.com/checkout/cart/add/uenc/aHR0cDovL2RlbW8ubWFnZW50b2NvbW1lcmNlLmNvbS9jaGVja291dC9jYXJ0Lw,,/product/41/in_cart/1/')"><span><span>Add to Cart</span></span></button>
                <ul class="add-to-links">
                                            <li><a href="https://demo.magentocommerce.com/wishlist/index/add/product/41/" class="link-wishlist">Add to Wishlist</a></li>
                                                                <li><span class="separator">|</span> <a href="http://demo.magentocommerce.com/catalog/product_compare/add/product/41/uenc/aHR0cDovL2RlbW8ubWFnZW50b2NvbW1lcmNlLmNvbS9jaGVja291dC9jYXJ0Lw,,/" class="link-compare">Add to Compare</a></li>
                                    </ul>
            </div>
        </li>
            <li class="item last even">
            <a class="product-image" href="http://demo.magentocommerce.com/barcelona-bamboo-platform-bed.html" title="Barcelona Bamboo Platform Bed"><img src="js/barcelon.jpg" alt="Barcelona Bamboo Platform Bed" width="75" height="75"></a>
            <div class="product-details">
                <h3 class="product-name"><a href="http://demo.magentocommerce.com/barcelona-bamboo-platform-bed.html">Barcelona Bamboo Platform Bed</a></h3>
                

        
    <div class="price-box">
                                                            <span class="regular-price" id="product-price-42">
                    <span class="price">$2,299.00</span>                </span>
                        
        </div>

                <button type="button" title="Add to Cart" class="button btn-cart" onclick="setLocation('http://demo.magentocommerce.com/checkout/cart/add/uenc/aHR0cDovL2RlbW8ubWFnZW50b2NvbW1lcmNlLmNvbS9jaGVja291dC9jYXJ0Lw,,/product/42/in_cart/1/')"><span><span>Add to Cart</span></span></button>
                <ul class="add-to-links">
                                            <li><a href="https://demo.magentocommerce.com/wishlist/index/add/product/42/" class="link-wishlist">Add to Wishlist</a></li>
                                                                <li><span class="separator">|</span> <a href="http://demo.magentocommerce.com/catalog/product_compare/add/product/42/uenc/aHR0cDovL2RlbW8ubWFnZW50b2NvbW1lcmNlLmNvbS9jaGVja291dC9jYXJ0Lw,,/" class="link-compare">Add to Compare</a></li>
                                    </ul>
            </div>
        </li>
        </ul>
</div>
            </div>
            

        </div>
        <div class="totals">
                <table id="shopping-cart-totals-table">
        <colgroup><col>
        <col width="1">
        </colgroup><tfoot>
            <tr>
    <td style="" class="a-right" colspan="1">
        <strong>Grand Total</strong>
    </td>
    <td style="" class="a-right">
        <strong><span class="price">$99.99</span></strong>
    </td>
</tr>
        </tfoot>
        <tbody>
            <tr>
    <td style="" class="a-right" colspan="1">
        Subtotal    </td>
    <td style="" class="a-right">
        <span class="price">$99.99</span>    </td>
</tr>
        </tbody>
    </table>
                        <ul class="checkout-types">
                                                                                                    <li>    <button type="button" title="Proceed to Checkout" class="button btn-proceed-checkout btn-checkout" onclick="window.location='https://demo.magentocommerce.com/checkout/onepage/';"><span><span>Proceed to Checkout</span></span></button>
</li>
                                                            <li><a href="https://demo.magentocommerce.com/checkout/multishipping/" title="Checkout with Multiple Addresses">Checkout with Multiple Addresses</a>
</li>
                                                                    </ul>
                    </div>
    </div>
</div>
                </div>
            </div>