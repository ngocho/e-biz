<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div class="home-spot">
  <p class="home-callout">
<div id='wrapper'>
        <!--div id='header'></div-->
        <div id='body'>
            <div id="bigPic">
               <a href=""><img src="Images/Foods/1.jpg" alt="" /></a> 
                 <a href=""><img src="Images/Foods/2.jpg" alt="" /></a>
                 <a href=""><img src="Images/Foods/3.jpg" alt="" /></a>
                 <a href=""><img src="Images/Foods/4.jpg" alt="" /></a>
                 <a href=""><img src="Images/Foods/5.jpg" alt="" /></a>
                 <a href=""><img src="Images/Foods/6.jpg" alt="" /></a>
            
            </div>
            
            
            <ul id="thumbs">
                <li class='active' rel='1'><img src="Images/Foods/1.jpg" alt="" /></li>
                <li rel='2'><img src="Images/Foods/2.jpg" alt="" /></li>
                <li rel='3'><img src="Images/Foods/3.jpg" alt="" /></li>
                <li rel='4'><img src="Images/Foods/4.jpg" alt="" /></li>
                <li rel='5'><img src="Images/Foods/5.jpg" alt="" /></li>
                <li rel='6'><img src="Images/Foods/6.jpg" alt="" /></li>
                
            </ul>
        
        </div>
        <div class='clearfix'></div>
        <div id='push'></div>
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
<h3>Các sản phẩm bán chạy nhất</h3>
<table border="0" cellspacing="0">
    <tbody>
        <tr class="odd">
            <td><a href="http://localhost/magento/index.php/sony-vaio-vgn-txn27n-b-11-1-notebook-pc.html"><img class="product-img" src="Images/Foods/1.jpg" border="0" height="120" width="160"></a>
            <div class="product-description">
            <p><a href="http://localhost/magento/index.php/sony-vaio-vgn-txn27n-b-11-1-notebook-pc.html">Măng chua</a></p>
            <p><a href=""><img src="Images/Commons/xem.jpg" width="70"></img></a><!-- a class="link" href="#" >Xem hang </a> --></p>
            <p><a href=""><img src="Images/Commons/mua.jpg" width="70"></img></a>
            <p>
            Xem tất cả <a href="http://localhost/magento/index.php/electronics/computers/laptops.html">Rau</a>
            </p>
            </div>
            </td>
          <td><a href="http://localhost/magento/index.php/sony-vaio-vgn-txn27n-b-11-1-notebook-pc.html"><img class="product-img" src="Images/Foods/2.jpg" border="0" height="120" width="160"></a>
            <div class="product-description">
            <p><a href="http://localhost/magento/index.php/sony-vaio-vgn-txn27n-b-11-1-notebook-pc.html">Bí đỏ</a></p>
            <p><a href=""><img src="Images/Commons/xem.jpg" width="70"></img></a><!-- a class="link" href="#" >Xem hang </a> --></p>
            <p><a href=""><img src="Images/Commons/mua.jpg" width="70"></img></a>
            <p>
            Xem tất cả <a href="http://localhost/magento/index.php/electronics/computers/laptops.html">Rau</a>
            </p>
            </div>
            </td>
        </tr>
        <tr class="even">
            <td><a href="http://localhost/magento/index.php/olympus-stylus-750-7-1mp-digital-camera.html"><img class="product-img" src="js/best_selling_img03.jpg" border="0" width="95"></a>
            <div class="product-description">
            <p>
            <a href="http://localhost/magento/index.php/olympus-stylus-750-7-1mp-digital-camera.html">Olympus Stylus 750 7.1MP Digital Camera</a>
            </p>
            <p>
            See all <a href="http://localhost/magento/index.php/electronics/cameras/digital-cameras.html">Digital Cameras</a>
            </p>
            </div>
            </td>
            <td><a href="http://localhost/magento/index.php/acer-ferrari-3200-notebook-computer-pc.html"><img class="product-img" src="js/best_selling_img04.jpg" border="0" width="95"></a>
            <div class="product-description">
            <p>
            <a href="http://localhost/magento/index.php/acer-ferrari-3200-notebook-computer-pc.html">Acer Ferrari 3200 Notebook Computer PC</a>
            </p>
            <p>
            See all <a href="http://localhost/magento/index.php/electronics/computers/laptops.html">Laptops</a>
            </p>
            </div>
            </td>
        </tr>
        <tr class="odd">
            <td><a href="http://localhost/magento/index.php/asics-men-s-gel-kayano-xii.html"><img class="product-img" src="js/best_selling_img05.jpg" border="0" width="95"></a>
            <div class="product-description">
            <p><a href="http://localhost/magento/index.php/asics-men-s-gel-kayano-xii.html">ASICS® Men's GEL-Kayano® XII</a></p>
            <p>See all <a href="http://localhost/magento/index.php/apparel/shoes.html">Shoes</a></p>
            </div>
            </td>
            <td><a href="http://localhost/magento/index.php/coalesce-functioning-on-impatience-t-shirt.html"><img class="product-img" src="js/best_selling_img06.jpg" border="0" width="95"></a>
            <div class="product-description">
            <p>
            <a href="http://localhost/magento/index.php/coalesce-functioning-on-impatience-t-shirt.html">Coalesce: Functioning On Impatience T-Shirt</a>
            </p>
            <p>
            See all <a href="http://localhost/magento/index.php/apparel/shirts.html">Shirts</a>
            </p>
            </div>
            </td>
        </tr>
    </tbody>
</table>
</div>
</div>