<%@page import="ebiz.util.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<script type="text/javascript">
$(document).ready(function(){
    var value = $("#value").val();
    $("#choose option:selected").removeAttr('selected');
    $("#choose").val("/displayBill.vn?value="+value).attr('selected',true);

});
</script>
<h1>KẾT QUẢ TÌM KIẾM</h1>
      <div class="pager">
        <p class="amount">
          <strong>Page: &nbsp;</strong> <span> 
          <%-- <input
            type="hidden" name="page" id="status"
            value="<bean:write name="pageList"/>"></input>
          <input
            type="hidden" name="page" id="page"
            value="<bean:write name="providerVo" property="page"/>"></input> --%>
            <logic:present name="pageList" >
              <logic:iterate id="element"  name="pageList">
                <c:choose>
                  <c:when test="${element ==1}">
                    <a
                      href="/categoryProviderRecord.vn?page=<bean:write name="element" />"><bean:write
                        name="element" /></a>

                  </c:when>
                  <c:otherwise>
                   |  <a
                      href="/categoryProviderRecord.vn?page=<bean:write name="element" />"><bean:write
                        name="element" /> </a>
                  </c:otherwise>
                </c:choose>


              </logic:iterate>
            </logic:present> </span>
        </p>

       
      </div>

     <%--  <!-- hidden fields -->
          <input type="hidden" name="col" id="col"
            value="<bean:write name="providerVo" property="col"/>"></input>
            <input type="hidden" id="limit"
            value="<bean:write name="providerVo" property="limit"/>"></input>
            <input
            type="hidden" name="page" id="page"
            value="<bean:write name="providerVo" property="page"/>"></input>
              --%>
    
<%-- <table  style="font-size: 10pt;margin-left: 10px;" border="1">
<tbody>
<tr class="pProduct">
<th >HÌNH </th>
<th >MSP</th>
<th >TÊN SẢN PHẨM</th>
<th >GIÁ</th>
<th >GIÁ KHUYỄN MÃI</th>
<th >SỐ LƯỢNG</th>
<th >CHI TIẾT</th>
<th >HƯỚNG DẪN </th>
<th >MUA</th>
<th >XEM</th>
</tr>
<logic:present name="searchResult" >
<logic:iterate id="element"  name="searchResult">
<tr>
<td> <img src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" width="50" height="40"/></td>
<td style="text-align: center;" ><a href="/reOrder.vn?id=<bean:write name="element" property="id"/>"><bean:write name="element" property="id"/></a></td>
<td> <bean:write name="element" property="name"/></td>
<td><bean:write name="element"  property="price"/></td>
<td><bean:write name="element"  property="promoPrice"/></td>
<td><bean:write name="element"  property="number"/></td>
<td><bean:write name="element"  property="detail"/></td>
<td><bean:write name="element"  property="cooking"/></td>
<td><a id="" href="/displayDetailProduct.vn?id=<bean:write name="element" property="id"/>"><img src="Images/Commons/mua.jpg" width="50" /></a></td>
<td><a id="delBill" href="/deleteProduct.vn?id=<bean:write name="element" property="id"/>"><img src="Images/Commons/.jpg" width="50" /></a></td>
</tr>
</logic:iterate>
</logic:present>
</tbody>
</table> --%>
<ul>
<logic:present name="searchResult" >
<logic:iterate id="element"  name="searchResult">
<li style="margin-left:10px;"> 
<img src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" width="50" height="40"/>
<a href="/reOrder.vn?id=<bean:write name="element" property="id"/>"><bean:write name="element" property="name"/></a> 
<br>
<bean:write name="element" property="detail"/>
</li>
</logic:iterate>
</logic:present>
</ul>