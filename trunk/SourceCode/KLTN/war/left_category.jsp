<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
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

<div class="block block-layered-nav">
    <div style="background:#009900" >
        <strong><span style="text-transform:uppercase" class="whiteImPression">MENU</span></strong>    </div>
    <div class="block-content">
                            <p class="block-subtitle">TÙY CHỌN</p>
            <dl id="narrow-by-list">
                                                                    <c:choose>
                <c:when test="${productVo.typeProduct == '1' ||productVo.typeProduct == '2' }"> <dt class="odd">MÓN ĂN</dt></c:when></c:choose>
                                                                    
                    <dd class="odd">
<ol>
  <li>
  
                <a href="/categoryRecord.vn?attr=0">
                <c:choose>
                <c:when test="${productVo.typeProduct == '1' ||productVo.typeProduct == '2' }">
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
</c:when>
</c:choose>
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
</div>
