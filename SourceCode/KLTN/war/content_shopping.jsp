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
            <logic:present name="shop">
            Tổng tiền : <bean:write name="shop"  property="total" />
            </logic:present>
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
    <td><img src="<bean:write name="element" property="url"/>" alt="Chair" width="75" height="75"/></td>
    <td>
        <h2 class="product-name">
        <input type="hidden" name="idFood" value="<bean:write name="element"  property="id" />" />
                    <a href="#"><bean:write name="element" property="name" /> </a>
                </h2>
                                                </td>
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
            <td class="a-center last"><a href="" title="Remove item"  class="a-center">Xóa</a></td>
</tr>
</logic:iterate>
</logic:present>

                                </tbody>
            </table>
           
        </fieldset>
    </form>

</div>
                </div>
            </div>