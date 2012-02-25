<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
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
<!-- <script type="text/javascript">
$(document).ready(function(){
    $(".").click(function() {
        addToCart(1,$(this).attr('name'));
        return false;
    });
});
</script> -->
                                        <div class="cart">
    <div class="page-title title-buttons">
        <h1>Giỏ hàng</h1>
                <ul class="checkout-types">
                            </ul>
            </div>
            <logic:present name="shop">
            Tổng tiền : <span style="color:red;font-weight: bold;" id="total"><bean:write name="shop"  property="total" /></span>
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
                                                     <button type="submit" title="Check Out Shopping Cart"  id ="checkout" class="button btn-update"><span><span>Đặt hàng</span></span></button>
                        </td>
                    </tr>
                </tfoot>
                <tbody>
                
                <logic:present name="shop" property="products">
                <logic:iterate id="element"  name="shop" property="products" indexId="index">
                <tr class="first last odd">
    <td><img src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" alt="Chair" width="75" height="75"/></td>
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
           <input type="text" class="num" id='<%=index%>'  name="number" value="<bean:write name="element" property="number"/>"/>
    </td>
        <td class="a-right">
                    <span class="cart-price">
        
                                                <span class="price" id='Sub<%=index%>'><bean:write name="element" property="subTotal"/></span>                            
        </span>
            </td>
            <td ><a rel="<%=index%>" class="updateShopping"  name="<bean:write name="element" property="id"/>" href="" title="Sửa "  class="a-center">
            <span><img src="Images/Commons/update-icon.gif"
                width="20"></a></td>
            <td class="a-center last"><a href="deleteShoppingFood.vn?id=<bean:write name="element" property="id"/>" title="Remove item"  class="a-center"><span><img src="Images/Commons/DeleteRed.png"
                width="20"></span></a></td>
</tr>
</logic:iterate>
</logic:present>

                                </tbody>
            </table>
           
        </fieldset>
    </form>

</div>
