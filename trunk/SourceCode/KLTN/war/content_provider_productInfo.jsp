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
<script type="text/javascript">
    $(document).ready(function() {

      /*   var status = $("#status").val();
        $("#provider_product option:selected").removeAttr('selected');
        $("#provider_product").val("/categoryProviderRecord.vn?value=" + status).attr('selected', true); */

       /*  var col = $("#col").val();
        $("#order option:selected").removeAttr('selected');
        $("#order").val("/categoryProviderRecord.vn?col=" + col).attr('selected', true);

        var page = $("#page").val();
        if ($("a").text == page) {
            var a = $("a").text;
            a.css("color", "black");
        } */

    });
</script>   
<div class="page-title category-title">
  <h1>DANH SACH SẢN PHẨM</h1>
<%-- <input type="hidden"  id="value" value ="<bean:write name="user" property="isCustomerBill"/>"></input> --%>
<logic:present name="PVO"  property="fStatusList" >
<select id="provider_product" name="choose"  onchange="setLocation(this.value)">

<logic:iterate id="element"  name="PVO" property="fStatusList">
<c:choose>
 <c:when test="${element.id == providerVo.status}">
    <option value="/categoryProviderRecord.vn?value=<bean:write name="element" property="id"/>" selected="selected"><bean:write name="element" property="display"/> </option>               
 </c:when>                
                  <c:otherwise>

<option value="/categoryProviderRecord.vn?value=<bean:write name="element" property="id"/>"><bean:write name="element" property="display"/></option>               
                 </c:otherwise>
                </c:choose>
</logic:iterate> 

<!-- <option value="/categoryProviderRecord.vn?value=0">Tất cả </option>
<option value="/categoryProviderRecord.vn?value=1"> Sản phẩm khuyến mãi</option>
<option value="/categoryProviderRecord.vn?value=2"> Sản phẩm không khuyến mãi</option>
<option value="/categoryProviderRecord.vn?value=3"> Sản phẩm đã hết </option>
<option value="/categoryProviderRecord.vn?value=4"> Sản phẩm chưa bán</option>
 -->
</select>
</logic:present>
</div>
      <div class="pager">
        <p class="amount">
          <strong>Page: &nbsp;</strong> <span> 
          <input
            type="hidden" name="page" id="status"
            value="<bean:write name="providerVo" property="status"/>"></input>
          <input
            type="hidden" name="page" id="page"
            value="<bean:write name="providerVo" property="page"/>"></input>
            <logic:present name="providerVo" property="pagingList">
              <logic:iterate id="element" name="providerVo"
                property="pagingList">
                <c:choose>
                  <c:when test="${element.id ==1}">
                    <a
                      href="/categoryProviderRecord.vn?page=<bean:write name="element" property="id"/>"><bean:write
                        name="element" property="id" /></a>

                  </c:when>
                  <c:otherwise>
                   |  <a
                      href="/categoryProviderRecord.vn?page=<bean:write name="element" property="id"/>"><bean:write
                        name="element" property="id" /> </a>
                  </c:otherwise>
                </c:choose>


              </logic:iterate>
            </logic:present> </span>
        </p>

        <div class="limiter">
          <label>Hiển thị </label> <input type="hidden" id="limit"
            value="<bean:write name="providerVo" property="limit"/>"></input>
          <select id="record" onchange="setLocation(this.value)">
       <%--            <%String strPage[] = new String[3];
          strPage[0] = "8";
          strPage[1] = "14";
          strPage[2] = "30";
          String s = session.getAttribute("providerVo").getLimit();;
          for(int i = 0; i<3; i++){
        	  
          %> --%>
            <logic:present name="providerVo">
            <c:choose>
            <c:when test="${providerVo.limit == 14}">
            <option value="/categoryProviderRecord.vn?limit=8"
              >8</option>
              <option value="/categoryProviderRecord.vn?limit=14"
              selected="selected">14</option>
                <option value="/categoryProviderRecord.vn?limit=30"
              >30</option>
              </c:when>
              <c:when test="${providerVo.limit == 30}">
            <option value="/categoryProviderRecord.vn?limit=8"
              >8</option>
              <option value="/categoryProviderRecord.vn?limit=14"
             >14</option>
                <option value="/categoryProviderRecord.vn?limit=30"
              selected="selected" >30</option>
              </c:when>
                <c:otherwise>
            <option value="/categoryProviderRecord.vn?limit=8"
              selected="selected">8</option>
              <option value="/categoryProviderRecord.vn?limit=14"
              >14</option>
                <option value="/categoryProviderRecord.vn?limit=30"
              >30</option>
            </c:otherwise>
             
            </c:choose>
            </logic:present>
         
          </select> sản phẩm mỗi trang
        </div>
      </div>
      
      <div class="sorter">
        <p class="view-mode">
        </p>

        <div class="sort-by">
          <logic:present name="providerVo">
            <c:choose>
              <c:when test="${providerVo.order == 'asc'}">
                <label>Sắp xếp tăng dần theo</label>
              </c:when>
              <c:when test="${providerVo.order == 'desc'}">
                <label>Sắp xếp giảm dần  theo</label>
              </c:when>
              <c:otherwise>
               <label>Sắp xếp tăng dần theo</label>
              </c:otherwise>
            </c:choose>
          </logic:present>
          <input type="hidden" name="col" id="col"
            value="<bean:write name="providerVo" property="col"/>"></input>
        
          
          <logic:present name="PVO"  property="fNameList" >
  <select id="order" onchange="setLocation(this.value)">
<logic:iterate id="element"  name="PVO" property="fNameList">
<c:choose>
 <c:when test="${element.id == providerVo.col}">

    <option value="/categoryProviderRecord.vn?col=<bean:write name="element" property="id"/>" selected="selected"><bean:write name="element" property="display"/> </option>               
 </c:when>                
<c:otherwise>

<option value="/categoryProviderRecord.vn?col=<bean:write name="element" property="id"/>"><bean:write name="element" property="display"/></option>               
</c:otherwise>
                </c:choose>
</logic:iterate> 

<!-- <option value="/categoryProviderRecord.vn?value=0">Tất cả </option>
<option value="/categoryProviderRecord.vn?value=1"> Sản phẩm khuyến mãi</option>
<option value="/categoryProviderRecord.vn?value=2"> Sản phẩm không khuyến mãi</option>
<option value="/categoryProviderRecord.vn?value=3"> Sản phẩm đã hết </option>
<option value="/categoryProviderRecord.vn?value=4"> Sản phẩm chưa bán</option>
 -->
</select>
</logic:present>
            <!-- <option value="/categoryProviderRecord.vn?col=foodName"
              selected="selected">Tên</option>
            <option value="/categoryProviderRecord.vn?col=price">Giá
              tiền</option>
            <option value="/categoryProviderRecord.vn?col=saleProduct">
              Lượt người mua</option> -->
        <!--   </select>
           -->
           <logic:present name="providerVo">
            <c:choose>
              <c:when test="${providerVo.order == 'asc'}">
            <a style="text-decoration: none;"
              href="/categoryProviderRecord.vn?order=desc"
              title="Set Descending Direction"><img
              src=""
              alt="Sắp xếp giảm dần" class="v-middle">
            </a>
              </c:when>
              <c:when test="${providerVo.order == 'desc'}">
                <a style="text-decoration: none;"
              href="/categoryProviderRecord.vn?order=asc"
              title="Set Descending Direction"><img
              src=""
              alt="Sắp xếp tăng dần " class="v-middle">
            </a>
              </c:when>
               <c:otherwise>
               <a style="text-decoration: none;"
              href="/categoryProviderRecord.vn?order=desc"
              title="Set Descending Direction"><img
              src=""
              alt="Sắp xếp giảm dần" class="v-middle">
            </a>
               </c:otherwise>
            </c:choose>
          </logic:present>
        </div>
      </div>
      <!-- hidden fields -->
          <input type="hidden" name="col" id="col"
            value="<bean:write name="providerVo" property="col"/>"></input>
            <input type="hidden" id="limit"
            value="<bean:write name="providerVo" property="limit"/>"></input>
            <input
            type="hidden" name="page" id="page"
            value="<bean:write name="providerVo" property="page"/>"></input>
             
<table  style="font-size: 10pt;margin-left: 10px;" border="1">
<tbody>
<tr class="pProduct">
<th >HÌNH </th>
<th >MSP</th>
<th >TÊN SẢN PHẨM</th>
<th >NHÓM SẢN PHẨM</th>
<th >TÌNH TRẠNG SẢN PHẨM</th>
<th >GIÁ</th>
<th >GIÁ KHUYỄN MÃI</th>
<th >SỐ LƯỢNG</th>
<th >CHI TIẾT</th>
<th >HƯỚNG DẪN </th>
<th >THAY ĐỔI</th>
<th >XÓA </th>
</tr>
<logic:present name="providerFood" >
<logic:iterate id="element"  name="providerFood">
<tr>
<td> <img src="/serveImage.vn?urlKey=<bean:write name="element" property="urlKey"/>" width="50" height="40"/></td>
<td style="text-align: center;" ><a href="/reOrder.vn?id=<bean:write name="element" property="id"/>"><bean:write name="element" property="id"/></a></td>
<td> <bean:write name="element" property="name"/></td>
<td><bean:write name="element"  property="productTypeId"/></td>
<td><bean:write name="element"  property="statusName"/></td>
<td><bean:write name="element"  property="price"/></td>
<td><bean:write name="element"  property="promoPrice"/></td>
<td><bean:write name="element"  property="number"/></td>
<td><bean:write name="element"  property="detail"/></td>
<td><bean:write name="element"  property="cooking"/></td>
<td><a id="" href="/displayDetailProduct.vn?id=<bean:write name="element" property="id"/>">Sửa</a></td>
<td><a id="delBill" href="/deleteProduct.vn?id=<bean:write name="element" property="id"/>">Xóa</a></td>
</tr>
</logic:iterate>
</logic:present>
</tbody>
</table>