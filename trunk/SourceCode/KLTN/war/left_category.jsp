<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<div class="col-left sidebar">

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
      <strong><span>TÌM KIẾM</span>
      </strong>
    </div>
    <div class="block-content">
    <html:form action="/search.vn" method="GET">
    <ul>
    <li>Nhập vào:<br><html:text property="searchText" style="width:98%;" styleId="searchID"/>
    </li>
    <li>Loại thực phẩm :<br>
    <html:select property="type" style="width: 190px;" styleId="type">
    <html:option value="0">Tất cả</html:option>
    <html:option value="1">Thực phẩm sơ chế</html:option>
    <html:option value="2">Thức ăn nấu sẵn</html:option>
    <html:option value="3">Rau xanh</html:option>
    <html:option value="4">Gia vị</html:option>
    </html:select>
    </li>
    <li>Kiểu thực phẩm:<br>
    <html:select property="attr" style="width: 190px;" styleId="attr">
    <html:option value="0">Tất cả</html:option>
    <html:option value="1">Kho</html:option>
    <html:option value="2">Canh, luộc</html:option>
    <html:option value="3">Xào</html:option>
    <html:option value="4">Lẩu</html:option>
    <html:option value="5">Khác</html:option>
    </html:select>
    </li>
    <li>Giá tiền: <br>
    <html:select property="price" style="width: 190px;" styleId="price">
    <html:option value="0">Tất cả</html:option>
    <html:option value="1">Dưới 30.000</html:option>
    <html:option value="2">30.000 - 100.000</html:option>
    <html:option value="3">100.000 - 200.000</html:option>
    <html:option value="4">Trên 200.000</html:option>
   </html:select>
    </li>
    <li>Thực phẩm:<br>
    <html:select property="status" style="width: 190px;" styleId="status">
    <html:option value="1">Khuyến mãi</html:option>
    <html:option value="2">Bình thường</html:option>
    <html:option value="0">Tất cả</html:option>
   </html:select>
    </li>
    <li><input type="submit" value="Tìm kiếm" class="buttonBG" id="submitSearch" size="30px"/>
    <input type="button" value="Xóa" class="buttonBG" id="resetSearch" size="30px" />
    </li>
    </ul>
   </html:form>
    </div>
  </div>
<div class="block block-layered-nav">
    <div style="background:#009900" >
        <strong><span style="text-transform:uppercase">MENU</span></strong>    </div>
    <div class="block-content">
                            <p class="block-subtitle">TÙY CHỌN</p>
            <dl id="narrow-by-list">
                                                                    <dt class="odd">MÓN ĂN</dt>
                                                                    
                    <dd class="odd">
<ol>
  <li>
  
                <a href="/categoryRecord.vn?attr=0">
                 <c:choose>
                  <c:when test="${productVo.attr == '0'}">
                  <span class="keepLink">Tất cả</span>
                  </c:when>
                  <c:otherwise>
               Tất cả
               </c:otherwise>
               </c:choose>
                </a>
               </li>
<logic:present name="Attribute">
<logic:iterate id="element" name="Attribute">
    <li>
                <a href="/categoryRecord.vn?attr=<bean:write name="element" property="productAttributeId"/>">
                <c:choose>
                 <c:when test="${productVo.attr == element.productAttributeId}">
              	 <span class="keepLink"> <bean:write name="element"  property="productAttributeName" /></span>
               	</c:when>
               <c:otherwise>
               <bean:write name="element"  property="productAttributeName" />
               </c:otherwise>
               </c:choose>
                </a>
               </li>
</logic:iterate>
</logic:present>
</ol>
</dd>
                                                                    <dt class="even">GIÁ TIỀN</dt>
                    <dd class="even">
<ol>
    <li>
                <a href="/categoryRecord.vn?price=0">
                <c:choose>
                  <c:when test="${productVo.priceId == '0'}">
                  <span class="keepLink">Tất cả</span>
                  </c:when>
                  <c:otherwise>
               Tất cả
               </c:otherwise>
               </c:choose>
                </a>
                </li>
<logic:present name="Price">
<logic:iterate id="element" name="Price">
    <li>
                <a href="/categoryRecord.vn?price=<bean:write name="element" property="id"/>">
                <c:choose>
                 <c:when test="${productVo.priceId == element.id}">
              	 <span  class="keepLink"><bean:write name="element" property="startPrice"/></span> - 
<span   class="keepLink"><bean:write name="element" property="endPrice"/></span>
               	</c:when>
               <c:otherwise>
               <span class="price" ><bean:write name="element" property="startPrice"/></span> - <span class="price">
<span class="price"><bean:write name="element" property="endPrice"/></span>
               </c:otherwise>
               </c:choose>
               

</a>
                </li>
</logic:iterate>
</logic:present > 
</ol>
</dd>
                                            </dl>
            </div>
</div>
</div>
