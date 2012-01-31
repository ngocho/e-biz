<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div class="col-left ">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function(){
    $("#searchID").focus(function() {
        $("#searchID").val("");
    });
   

});
</script>
 <div class="block block-cart">
    <div class="block-title">
      <strong><span>TÌM KIẾM</span>
      </strong>
    </div>
    <div class="block-content">
    <html:form action="/search.vn" method="GET">
    <ul>
    <li>Nhập vào:</br><html:text property="searchText" size="32" styleId="searchID"/>
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
 <div class="block block-cart">
    <div class="block-title">
      <strong><span>THÔNG TIN THỜI TIẾT</span>
      </strong>
    </div>
    <div class="block-content">
     <form name="weather">
     Hiển thị thông tin của vùng hiện tại
     
     
     <!-- <input type="submit" value="Xem"/> -->
     </form>
    </div>
  </div>
 <div  >
 <a href="#" class="freeShip" >
 Miễn phí giao hàng nội địa với hóa đơn trên 300.000 VNĐ
</a>
  </div>

  <div class="block block-tags">
</div>
<div>
Hiển thị thông tin quảng cáo
</div>

</div>