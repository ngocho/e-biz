<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script type="text/javascript">
$(document).ready(function(){
    $("#addToCart").click(function() {
        var quantity = $("#quantity").val();
        var idProduct = $("#id").val();
        var value =  addToCart(quantity,idProduct);
        $("#numberID").html(value);
        return false;
    });
});
</script>

<div style="width: 750px;">

<div id="messages_product_view"></div>
<div class="product-view">
    <div class="product-essential">
    <logic:present name="DetailProduct">
    <form action="" method="post" id="product_addtocart_form">
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
                                     <a href=""  id="addToCart" ><img alt="" src="Images/Commons/<bean:message key="button.buy" />"  width="100" border="0" height="35">  </a>
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
                <h1> <bean:message key="home.content.food.id" /> : <span class="impressionText" ><bean:write name ="DetailProduct" property="id" /></span></h1>
            </div>
            <div class="product_info" style="margin-top:0px;">      
                <table border="1" style="border-style:ridge;;border-width:2px; border-color:black;">
            <tr>
            <th > <bean:message key="home.content.food.name" /></th>
            <td width="200" style="padding:3px;" > <bean:write name="DetailProduct" property="name" /></td>
            </tr>
             <tr>
            <th class="old-price"><bean:message key="home.content.food.price"/></th>
            <td width="200"  style="padding:3px;" >
              <c:choose>
                  <c:when test="${DetailProduct.promoPrice != 0}">
                   <span style="text-decoration:line-through;color:black;" class="price" id="old-price-52"> </span>
                  </c:when>
                  <c:otherwise>
                   <span style="color:black;" class="price" id="old-price-52"> </span>
                  </c:otherwise>
                  </c:choose>
             <bean:write name="DetailProduct" property="price" /> </td>
            </tr>
             <tr>
            <th  class="price-label"><bean:message key="home.content.food.priceP" /></th>
            <c:choose>
                  <c:when test="${DetailProduct.promoPrice != 0}">
                  <td width="200" class="price" style="padding:3px;" >  <span
                  class="price" id="product-price-52"> <bean:write
                    name="DetailProduct" property="promoPrice" /> </span></td>
                  </c:when>
                  <c:otherwise>
                 <td> <span style="text-decoration:line-through;color:black;color:red;"><bean:message key="product.status"/></span></td>
                  </c:otherwise>
                  </c:choose>
            </tr>
            <tr>
            <th ><bean:message key="category.content.number"/></th>
             <c:choose>
                  <c:when test="${DetailProduct.number != 0}">
                   <td  width="200" style="padding:3px;" > <span id="numberID" ><bean:write name="numberDisplay"  /></span></td>
                  </c:when>
                  <c:otherwise>
                    <td  width="200" style="padding:3px;" > <span id="numberID" style="text-decoration:line-through;color:black;color:red;"><bean:message key="product.out" /></span></td>
                  </c:otherwise>
                  </c:choose>
          
            
            
            </tr>
            <tr>
            <th> <bean:message key="product.provider.name"/> </th>
            <td  width="200" style="padding:3px;" ><a href="/displayProviderInfo.vn?id=<bean:write name="DetailProduct" property="idProvider" />"><bean:write name="DetailProduct" property="nameProvider" /></a> 
            <a href="/displayAddProviderGM.vn?id=<bean:write name="DetailProduct" property="idProvider" />" >
            <span style="color:red;font-size: 10px"><bean:message key="product.provider.showAdd"/></span>
            </a></td>
            </tr>
            </table>
            </div>
            </div>

        <div class="product-img-box">
            <p class="product-image ">
  <a href ="#"  ><img  width="335" height="315" id="image" src="/serveImage.vn?urlKey=<bean:write name="DetailProduct" property="urlKey"/>" alt="Chair" ></a></p>
<div class="more-views">
</div>
        </div>

        <div class="clearer"></div>
            </form>
            </logic:present>
            
   
    </div>

		<div class="product-collateral">
			<c:if test="${DetailProduct.productTypeId == 2}">
				<div class="box-collateral box-description">
					<h2><bean:message key="product.voucher.slogan"/></h2>
					<div class="std">
					<form action="/getVoucher.vn" name="voucher">
					<bean:message key="product.voucher.number"/> : <input type="text"  name="numVoucher"/>
					<input type="submit" value="<bean:message key="product.voucher.button"/>" class="buttonBG"/>
					</form>
					</div>
				</div>
			</c:if>
			<div class="box-collateral box-description">
				<h2><bean:message key="product.detail"/></h2>
				<div class="std">
					<bean:write name="DetailProduct" property="detail" />
				</div>
			</div>
			<div class="box-collateral box-additional">
				<h2><bean:message key="product.cooking"/></h2>
				<bean:write name="DetailProduct" property="cooking" />


			</div>
			<div class="box-collateral box-up-sell">
				<h2><bean:message key="product.refer"/></h2>
				<table class="products-grid" id="upsell-product-table">
					<tbody>
						<tr class="">
							<logic:present name="promotionFood">
								<logic:iterate id="element" name="promotionFood" length="2">
									<td><a
										href="/displayProductDetail.vn?id=<bean:write name="element" property="id" />"
										title="Hình ảnh" class="product-image"><img
											src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>"
											width="250" height="250">
									</a>
										<h3 class="product-name">
											<a href="" title="Magento Red Furniture Set"><bean:write
													name="element" property="name" />
											</a>
										</h3>


										<div class="price-box">
											<p class="minimal-price">
												<span class="price-label"><bean:message key="product.price"/>:</span> <span class="price"
													id="product-minimal-price-54-upsell"> <bean:write
														name="element" property="promoPrice" /> </span>
											</p>
										</div>
										<div class="ratings">
											<div class="rating-box">
												<div class="rating" style="width: 93%;"></div>
											</div>
										</div></td>
								</logic:iterate>
							</logic:present>
						</tr>
					</tbody>
				</table>

			</div>
			<div class="box-collateral box-tags">

			</div>
		</div>
	</div>

</div>
