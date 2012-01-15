<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<div class="home-spot">
  <div class="account-create">
<logic:present name="shopFoodDetail"> 
    <form action="/updateShopping.vn" method="get">
      <div class="fieldset">
        <h2 class="legend">Thông tin sản phẩm</h2>

<input type="hidden" name="id" value="<bean:write name="shopFoodDetail" property="id"/>"/>
  
      <ul class="form-list">
        <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin">Hình</label>
              <div class="input-box">
                  <img src="/serveImage.vn?urlKey=<bean:write name="shopFoodDetail" property="urlKey"/>" width="200"
                    height="150" />
              </div>

            </div>
          </div></li>
        <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin"> Tên
                món ăn</label>
              <div class="input-box">
               <bean:write name="shopFoodDetail" property="name"/>
              </div>
            </div>
          </div></li>
        <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin"> Số
                lượng</label>
              <div class="input-box">
                <input type="text" name="number" value="<bean:write name="shopFoodDetail" property="number"/>" />
              </div>
            </div>
          </div></li>
        <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin"> Giá mua</label>
              <div class="input-box">
               <bean:write name="shopFoodDetail" property="price"/>
              </div>
            </div>
          </div></li>
             <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin"> Thành tiền</label>
              <div class="input-box">
              <bean:write name="shopFoodDetail" property="subTotal"/>
              </div>
            </div>
          </div></li>
      </ul>

  <button type="submit" title="Submit" style="margin-left: 200px;"
    class="button">
    <span><span>Cập nhật</span> </span>
  </button>
   </div>
</form>
  </logic:present>
  <a href="/displayShoppingCart.vn">Trở lại</a>
</div>
</div>