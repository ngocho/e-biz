<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div class="col-left ">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!-- <p class="home-callout">
<img src="" border="0">
</p> -->
<script type="text/javascript">
$(document).ready(function(){
    $("#searchID").focus(function() {
        $("#searchID").val("");
    });
    $("#submitSearch").click(function() {
        if($("#searchID").val() == ""){
        alert("Nhập thông tin tìm kiếm");
        return false;
        }
    });
    
    $("#resetSearch").click(function() {
        $("#searchID").val("");
        $("#type option:selected").removeAttr('selected');
        $("#type").val("0").attr('selected', true);
        
        $("#attr option:selected").removeAttr('selected');
        $("#attr").val("0").attr('selected', true);
        
        $("#price option:selected").removeAttr('selected');
        $("#price").val("0").attr('selected', true);
        
        $("#status option:selected").removeAttr('selected');
        $("#status").val("1").attr('selected', true);
        
    });

});
</script>
 <div class="block block-cart">
    <div class="block-title">
      <strong><span class="whiteImPression">TÌM KIẾM</span>
      </strong>
    </div>
    <div class="block-content">
    <html:form action="/search.vn" method="GET">
    <ul>
    <li>Nhập vào:</br><html:text property="searchText" size="32" />
    </li>
    <li>Loại thực phẩm :</br>
    <html:select property="type" style="width: 190px;">
    <html:option value="0">Tất cả</html:option>
    <html:option value="1">Thực phẩm sơ chế</html:option>
    <html:option value="2">Thức ăn nấu sẵn</html:option>
    <html:option value="3">Rau xanh</html:option>
    <html:option value="4">Gia vị</html:option>
    </html:select>
    </li>
    <li>Kiểu thực phẩm:</br>
    <html:select property="attr" style="width: 190px;">
    <html:option value="0">Tất cả</html:option>
    <html:option value="1">Kho</html:option>
    <html:option value="2">Canh, luộc</html:option>
    <html:option value="3">Xào</html:option>
    <html:option value="4">Lẩu</html:option>
    <html:option value="5">Khác</html:option>
    </html:select>
    </li>
    <li>Giá tiền: </br>
    <html:select property="price" style="width: 190px;">
    <html:option value="0">Tất cả</html:option>
    <html:option value="1">Dưới 30.000</html:option>
    <html:option value="2">30.000 - 100.000</html:option>
    <html:option value="3">100.000 - 200.000</html:option>
    <html:option value="4">Trên 200.000</html:option>
   </html:select>
    </li>
    <li>Thực phẩm:</br>
    <html:select property="status" style="width: 190px;">
    <html:option value="1">Khuyến mãi</html:option>
    <html:option value="2">Bình thường</html:option>
    <html:option value="0">Tất cả</html:option>
   </html:select>
    </li>
    <li><input type="submit" value="Tìm kiếm" class="buttonBG" size="30px"/></li>
    </ul>
   </html:form>
    </div>
  </div>
<p class="home-callout">
<a href=""><img src="Images/Commons/giaohang.png" width="195" height="200" border="0"></a>
</p> 
<p class="home-callout">
<a href=""><img src="Images/Commons/taikhoanXu.png" width="195" height="200" border="0"></a>
</p>
 <p class="home-callout">
<a href=""><img src="Images/Commons/mail_sms.png" width="195" height="200" border="0"></a>
</p>

<p class="home-callout">
<a href=""><img src="Images/Commons/voucher.png" width="195" height="200" border="0"></a>
</p>
<!--  <div class="block block-cart">
    <div class="block-title">
      <strong><span class="whiteImPression">THÔNG TIN THỜI TIẾT</span>
      </strong>
    </div>
    <div class="block-content">
     <form name="weather">
     Hiển thị thông tin của vùng hiện tại
     
     
     <input type="submit" value="Xem"/>
     </form>
    </div>
  </div> -->


</div>
