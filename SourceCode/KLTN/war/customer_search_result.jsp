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
<logic:empty name="searchResult">
<span style="color:red;">Không có kết quả nào</span>
</logic:empty>
<logic:notEmpty name="searchResult">
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
                  <c:when test="${element == pageIndex}">
                    <a
                      href="/categoryProviderRecord.vn?page=<bean:write name="element" />"><span class="impressionText"><bean:write
                        name="element" /></span></a>

                  </c:when>
                  <c:otherwise>
                    <a
                      href="/categoryProviderRecord.vn?page=<bean:write name="element" />"><bean:write
                        name="element" /> </a>
                  </c:otherwise>
                </c:choose>


              </logic:iterate>
            </logic:present> </span>
        </p>

       
      </div>
      </logic:notEmpty> 
<ul>
<logic:present name="searchResult" >
<logic:iterate id="element"  name="searchResult">
<li style="margin-left:10px;"> 
<img src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" width="50" height="40"/>
<a href="/displayProductDetail.vn?id=<bean:write name="element" property="id"/>"><bean:write name="element" property="name"/></a> 
<br>
<bean:write name="element" property="detail"/>
</li>
</logic:iterate>
</logic:present>
</ul>