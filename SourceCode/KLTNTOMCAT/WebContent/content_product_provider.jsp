<%@page import="ebiz.util.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script type="text/javascript">
$(document).ready(function(){
    var value = $("#value").val();
    $("#choose option:selected").removeAttr('selected');
    $("#choose").val("/displayBill.vn?value="+value).attr('selected',true);

});
</script>
<h1>DANH SÁCH SẢN PHẨM</h1>
<logic:empty name="foodByProvider">
<span style="color:red;">Không có sản phẩm nào được đăng</span>
</logic:empty>
<logic:notEmpty name="foodByProvider">
      <div class="pager">
        <p class="amount">
          <strong>Page: &nbsp;</strong> <span> 
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
<logic:present name="foodByProvider" >
<logic:iterate id="element"  name="foodByProvider">
<li style="margin-left:10px;"> 
<img src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" width="50" height="40"/>
<a href="/displayProductDetail.vn?id=<bean:write name="element" property="id"/>"><bean:write name="element" property="name"/></a> 
<br>
<bean:write name="element" property="detail"/>
</li>
</logic:iterate>
</logic:present>
</ul>