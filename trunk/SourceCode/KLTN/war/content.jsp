<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script type="text/javascript">
$(document).ready(function(){
    $(".addShopping").click(function() {
         addToCart(1,$(this).attr('name'));
        return false;
    });
});
</script>
<logic:present name="flagCompare">
  <c:if test="${flagCompare =='home'}">
  <script type="text/javascript" >
  $(document).ready(function(){
    alert("Không có sản phẩm để so sánh");
  });
  </script>
  </c:if>
 <c:remove var="flagCompare"/>
</logic:present>
  <p class="home-callout">
  
<div id='wrapper'>
        <logic:present name="promotionFood">
        <div id='body'>
            <div id="bigPic">
            <logic:iterate id="element" name="promotionFood" >
             <a href="/displayProductDetail.vn?id=<bean:write name="element" property="id" />"><img style=" border-style: ridge;border-color: black;"src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" alt=""  /></a> 
            </logic:iterate>
            </div>
            
            
            <ul id="thumbs">
            <logic:iterate id="element" name="promotionFood" indexId="index" length="6">
                <li  rel='<%=index+1%>'><img src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" alt="" /></li>
              </logic:iterate>  
            </ul>
        
        </div>
        <div class='clearfix'></div>
        <div id='push'></div>
        </logic:present>
    </div>
<script type="text/javascript">
    var currentImage;
    var currentIndex = -1;
    var interval;
    function showImage(index){
        if(index < $('#bigPic img').length){
            var indexImage = $('#bigPic img')[index]
            if(currentImage){   
                if(currentImage != indexImage ){
                    $(currentImage).css('z-index',2);
                    clearTimeout(myTimer);
                    $(currentImage).fadeOut(250, function() {
                        myTimer = setTimeout("showNext()", 3000);
                        $(this).css({'display':'none','z-index':1})
                    });
                }
            }
            $(indexImage).css({'display':'block', 'opacity':1});
            currentImage = indexImage;
            currentIndex = index;
            $('#thumbs li').removeClass('active');
            $($('#thumbs li')[index]).addClass('active');
        }
    }
    
    function showNext(){
        var len = $('#bigPic img').length;
        var next = currentIndex < (len-1) ? currentIndex + 1 : 0;
        showImage(next);
    }
    
    var myTimer;
    
    $(document).ready(function() {
        myTimer = setTimeout("showNext()", 3000);
        showNext(); //loads first image
        $('#thumbs li').bind('click',function(e){
            var count = $(this).attr('rel');
            showImage(parseInt(count)-1);
        });
    });
    
    
    </script>   
<div class="box best-selling" >
<h3>Các sản phẩm khuyến mãi</h3>
<logic:present name="promotionFood">

<table border="0" cellspacing="0">
    <tbody>
     <logic:iterate id="element" name="promotionFood"  >
        <tr class="odd">
       
         <td><a href="/displayProductDetail.vn?id=<bean:write name="element" property="id" />"><img  class="product-img" src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" border="0" height="200" width="300"   style="margin-right: 40px;"></a>
            <div class="product-description" >
            <p>Mã sản phẩm:<a href="#"><bean:write name="element" property="id"/></a></p>
            <p>Tên  :<bean:write name="element" property="name"/>  </p>
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
              <p >
                <a href="/compareFood.vn?screen=home&id=<bean:write name="element" property="id" />" style="color:blue;"> 
                So sánh với cửa hàng khác</a>
              </p>
            <p><a href="/displayProductDetail.vn?id=<bean:write name="element" property="id" />"><img src="Images/Commons/xem.jpg" width="100"></img></a><!-- a class="link" href="#" >Xem hang </a> --></p>
            <p><a  class="addShopping" name="<bean:write name="element" property="id"/>" href=""   ><img src="Images/Commons/mua.jpg" width="100"></img></a>
            </p>
            </div>
            </td>
            </tr>
       </logic:iterate>  
       
       
    </tbody>
</table>
</logic:present>
</div>
