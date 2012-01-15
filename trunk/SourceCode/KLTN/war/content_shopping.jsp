<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!-- <script type="text/javascript">
$(document).ready(function(){
    $("#updateSC").click(function() {
        var quantity = $("#quantity").val();
        var idProduct = $("#id").val();
        addToCart(quantity,idProduct);
        return false;
    });
});
</script> -->
<script type="text/javascript">
$(document).ready(function(){
    $(".").click(function() {
        addToCart(1,$(this).attr('name'));
        return false;
    });
});
</script>
                                        <div class="cart">
    <div class="page-title title-buttons">
        <h1>Giỏ hàng</h1>
                <ul class="checkout-types">
                            </ul>
            </div>
            <logic:present name="shop">
            Tổng tiền : <span style="color:red;font-weight: bold;"><bean:write name="shop"  property="total" /></span>
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
                        <th rowspan="1"><span class="nobr" >Tên sản phẩm</span></th>
                       <!--  <th rowspan="1"></th> -->
                                                <th class="a-center" colspan="1"><span class="nobr">Giá</span></th>
                        <th rowspan="1" class="a-center">Số lượng</th>
                        <th class="a-center" colspan="1">Thành tiền</th>
                         <th rowspan="1" class="a-center">Cập nhật</th>
                          <th rowspan="1" class="a-center">Xóa</th>
                    </tr>
                                    </thead>
                <tfoot>
                    <tr class="first last">
                        <td colspan="50" class="a-right last">
                        <input type="hidden" name="type" value="0"/>
                                                     <button type="button" title="Continue Shopping" class="button btn-continue" onclick="setLocation('/home.vn')"><span><span>Tiếp tục mua hàng</span></span></button>
                                                    <button type="button"  id="updateSC"  title="Update Shopping Cart" class="button btn-update" onclick="setLocation('/deleteShopping.vn')"><span><span>Tạo giỏ hàng mới</span></span></button>
                                                        <button type="submit" title="Check Out Shopping Cart"  id ="checkout" class="button btn-update"><span><span>Thanh toán</span></span></button>
                        </td>
                    </tr>
                </tfoot>
                <tbody>
                
                <logic:present name="shop" property="products">
                <logic:iterate id="element"  name="shop" property="products">
                <tr class="first last odd">
    <td><img src="<bean:write name="element" property="url"/>" alt="Chair" width="75" height="75"/></td>
    <td >
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
           <%--  <input type="text" id="num" name="number" value=" --%><bean:write name="element" property="number"/> 
<%--         <input name="<bean:write name="element" property="id"/>" value="<bean:write name="element" property="number"/>" size="4"  id="<bean:write name="element" property="id"/>.update" title="Qty" class="input-text qty" maxlength="12" onblur="onchange(this);"/>
 --%>        
    </td>
        <td class="a-right">
                    <span class="cart-price">
        
                                                <span class="price"><bean:write name="element" property="subTotal"/></span>                            
        </span>
            </td>
            <td ><a  class="updateShopping" href="displayShoppingDetail.vn?id=<bean:write name="element" property="id"/>" title="Remove item"  class="a-center"><span><span>Sửa</span></span></a></td>
            <td class="a-center last"><a href="deleteShoppingFood.vn?id=<bean:write name="element" property="id"/>" title="Remove item"  class="a-center"><span><span>Xóa</span></span></a></td>
</tr>
</logic:iterate>
</logic:present>

                                </tbody>
            </table>
           
        </fieldset>
    </form>

</div>
