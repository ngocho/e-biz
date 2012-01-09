<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>
<div class="home-spot">
  <div class="account-create">

    <div class="page-title">
      <h1>Upload sản phẩm</h1>
    </div>
    <logic:empty name="urlImage">
      <form name="uploadImage"
        action="<%=blobstoreService.createUploadUrl("/uploadImage.vn")%>"
        method="post" enctype="multipart/form-data">
      <!--  <input type="text" name="foo"> --> <input type="file"
          name="myFile"> <input id="uploadAction" type="submit"
          value="Upload Hình">
      </form>
    </logic:empty>
    <html:form action="/uploadProduct.vn" method="get">
    <html:hidden property="idProvider"/>
      <%-- <html:hidden property="idProvider" value="<bean:write name="provider" property="loginId"/>"/>
      <html:hidden property="url"  value="<bean:write name="url"/>"/> --%>
      <div class="fieldset">
        <h2 class="legend">Thông tin sản phẩm</h2>


  
      <ul class="form-list">
        <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin"><em>*</em>Lựa
                chọn loại sản phẩm</label>
              <div class="input-box">
                <html:select property="productTypeId">
                  <html:option value="1"> Thực phẩm sơ chế
     </html:option>
                  <html:option value="2"> Thực phẩm nấu sẵn
     </html:option>
                  <html:option value="3"> Rau xanh
     </html:option>
                  <html:option value="4"> Gia vị
     </html:option>
                </html:select>
              </div>
            </div>
          </div></li>
            <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin"><em>*</em>Chọn nhóm sản phẩm</label>
              <div class="input-box">
                <html:select property="idAttr">
                  <html:option value="1"> Kho
     </html:option>
                  <html:option value="2"> Canh
     </html:option>
                  <html:option value="3"> Xào
     </html:option>
                  <html:option value="4"> Lẩu
     </html:option>
      <html:option value="4"> Khác
     </html:option>
                </html:select>
              </div>
            </div>
          </div></li>
              <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin"><em>*</em>Lựa chọn trạng thái của sản phẩm</label>
              <div class="input-box">
                <html:select property="status">
                  <html:option value="1"> Thực phẩm khuyến mãi
     </html:option>
                  <html:option value="1"> Thực phẩm bình thường
     </html:option>
                
                  </html:select>
              </div>
            </div>
          </div></li>
        <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin"><em>*</em>Hình</label>
              <div class="input-box">
                <logic:present name="urlImageKey" >
                  <img src="/serveImage.vn?urlKey=<bean:write name="urlImageKey"/>" width="200"
                    height="150" />
                </logic:present>
              </div>

            </div>
          </div></li>
        <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin"><em>*</em>Tên
                món ăn</label>
              <div class="input-box">
                <html:text property="name" />
              </div>
            </div>
          </div></li>
        <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin"><em>*</em>Số
                lượng</label>
              <div class="input-box">
                <html:text property="number" />
              </div>
            </div>
          </div></li>
        <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin"><em>*</em>Giá</label>
              <div class="input-box">
                <html:text property="price" />
              </div>
            </div>
          </div></li>
        <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin">Giá
                khuyến mãi</label>
              <div class="input-box">
                <html:text property="promoPrice" />
              </div>
            </div>
          </div></li>
        <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin"><em>*</em>Giới
                thiệu về sản phẩm</label>
              <div class="input-box">
                <html:textarea property="detail" />
              </div>
            </div>
          </div></li>
        <li class="fields">
          <div class="customer-name">
            <div class="field name-firstname">
              <label for="firstname" class="required" id="typeLogin"><em>*</em>Hướng
                dẫn cách nấu</label>
              <div class="input-box">
                <html:textarea property="cooking" />
              </div>
            </div>
          </div></li>

        <li><logic:messagesPresent message="true">
            <html:messages id="message" message="true">
              <bean:write name="message" />
              <br />
            </html:messages>
          </logic:messagesPresent></li>

      </ul>
      
 


  <button type="submit" title="Submit" style="margin-left: 200px;"
    class="button">
    <span><span>Submit</span> </span>
  </button>
  <div class="buttons-set1">
    <p class="buttons-set1 p.required">* Required Fields</p>
    <br />
    <p class="buttons-set1 p.back-link">
      <a href="https://demo.magentocommerce.com/customer/account/login/"
        class="back-link"><small>&laquo; </small>Back</a>
    </p>

  </div>
   </div>
  </html:form>
</div>
</div>