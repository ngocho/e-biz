<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<div class="home-spot">
  <p class="home-callout">
  
<div id='wrapper'>
        <logic:present name="promotionFood">
        <div id='body'>
            <div id="bigPic">
            <logic:iterate id="element" name="promotionFood" >
               <a href=""><img src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" alt="" /></a> 
            <!--      <a href=""><img src="Images/Foods/2.jpg" alt="" /></a>
                 <a href=""><img src="Images/Foods/3.jpg" alt="" /></a>
                 <a href=""><img src="Images/Foods/4.jpg" alt="" /></a>
                 <a href=""><img src="Images/Foods/5.jpg" alt="" /></a>
                 <a href=""><img src="Images/Foods/6.jpg" alt="" /></a> -->
            </logic:iterate>
            </div>
            
            
            <ul id="thumbs">
            <logic:iterate id="element" name="promotionFood" >
                <li class='active' rel='1'><img src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" alt="" /></li>
               <!--  <li rel='2'><img src="Images/Foods/2.jpg" alt="" /></li>
                <li rel='3'><img src="Images/Foods/3.jpg" alt="" /></li>
                <li rel='4'><img src="Images/Foods/4.jpg" alt="" /></li>
                <li rel='5'><img src="Images/Foods/5.jpg" alt="" /></li>
                <li rel='6'><img src="Images/Foods/6.jpg" alt="" /></li> -->
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
<!--div id="slideshow">
    <img src="image1.jpg" alt="Slideshow Image 1" class="active" />
    <img src="js/a.jpg" alt="Slideshow Image 2" />
    <img src="js/b.jpg" alt="Slideshow Image 3" />
    <img src="js/b1.jpg" alt="Slideshow Image 4" />
</div-->

<!--p class="home-callout">
<img src="js/free_shipping_callout.jpg" border="0" width="570">
</p-->
<div class="box best-selling" style=" width:570px">
<h3>Các sản phẩm khuyến mãi</h3>
<logic:present name="promotionFood">

<table border="0" cellspacing="0">
    <tbody>
    <logic:iterate id="element" name="promotionFood" >
        <tr class="odd">
            <td><a href="#"><img class="product-img" src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" border="0" height="120" width="160"></a>
            <div class="product-description">
            <p><a href="#"><bean:write name="element" property="name"/>  </a></p>
            <p><a href="/displayProductDetail.vn?id=<bean:write name="element" property="id" />"><img src="Images/Commons/xem.jpg" width="70"></img></a><!-- a class="link" href="#" >Xem hang </a> --></p>
            <p><a href="/addShopping.vn?id=<bean:write name="element" property="id"/>"><img src="Images/Commons/mua.jpg" width="70"></img></a>
            <p>
            Xem tất cả <a href="#"></a>
            </p>
            </div>
       <!--      </td>
          <td><a href="http://localhost/magento/index.php/sony-vaio-vgn-txn27n-b-11-1-notebook-pc.html"><img class="product-img" src="Images/Foods/2.jpg" border="0" height="120" width="160"></a>
            <div class="product-description">
            <p><a href="http://localhost/magento/index.php/sony-vaio-vgn-txn27n-b-11-1-notebook-pc.html">Bí đỏ</a></p>
            <p><a href=""><img src="Images/Commons/xem.jpg" width="70"></img></a>a class="link" href="#" >Xem hang </a></p>
            <p><a href=""><img src="Images/Commons/mua.jpg" width="70"></img></a>
            <p>
            Xem tất cả <a href="http://localhost/magento/index.php/electronics/computers/laptops.html">Rau</a>
            </p>
            </div>
            </td> -->
        </tr>
        </logic:iterate>
    </tbody>
</table>
</logic:present>
</div>
</div>