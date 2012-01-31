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
            <logic:present name="pageList" >
              <logic:iterate id="element"  name="pageList">
                <c:choose>
                  <c:when test="${element == pageIndex}">
                    <a style="color:green;font-weight: bold;"
                      href="/searchPaging.vn?page=<bean:write name="element" />"><bean:write
                        name="element"  /></a> 

                  </c:when>
                  <c:otherwise>
                    <a
                      href="/searchPaging.vn?page=<bean:write name="element" />"><bean:write
                        name="element" /> </a>
                  </c:otherwise>
                </c:choose>


              </logic:iterate>
            </logic:present> </span>
        </p>

       
      </div>

<ul>
<logic:present name="searchResult" >
<logic:iterate id="element"  name="searchResult">
<li style="margin-left:10px;"> <a
            href="/displayProductDetail.vn?id=<bean:write name="element" property="id"/>"
            title="" class="product-image">
<img src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" width="50" height="40"/></a>
<a href="/displayProductDetail.vn?id=<bean:write name="element" property="id"/>"><bean:write name="element" property="name"/></a> 

<br>
<bean:write name="element" property="detail"/>
<div style="margin-right: 90px;">
<a  href="/displayProductDetail.vn?id=<bean:write name="element" property="id"/>"><img src="Images/Commons/xem.jpg" width="50" /></a>
<a  href="/displayProductDetail.vn?id=<bean:write name="element" property="id"/>"><img src="Images/Commons/mua.jpg" width="50" /></a>
</div>
</li>
<div style="height:15px;"></div>
</logic:iterate>
</logic:present>
</ul>