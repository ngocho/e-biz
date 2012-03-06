<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>
<script type="text/javascript" src="js/jquery.Jcrop.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        //remove 0
        $("#number").focus(function() {
            $("#number").val("");
        });

        $("#price").focus(function() {
            $("#price").val("");
        });

        $("#promoPrice").focus(function() {
            $("#promoPrice").val("");
        });
        //change status : normal, promotion Food
        $("#status").change(function() {
            var status = $("#status option:selected").val();
            if (status == 2) {
                $("#divPrice").hide();
            } else {
                $("#divPrice").show();
            }
        });
        
        //submit form
        $("#upload").click(function() {
        var flag =  validateProviderFood();
        if(!flag){
            return false;
          //  $("#uploadForm").submit();
        }
        });
        
         //reset Form
        $("#reset").click(function() {
            resetFormProvider(2);

            $("#name").val("");
            $("#detail").val("");
            $("#cooking").val("");

            $("#price").val("0");
            $("#number").val("0");
            $("#promoPrice").val("0");

            $("#status option:selected").removeAttr('selected');
            $("#status").val("1").attr('selected', true);

            $("#idAttr option:selected").removeAttr('selected');
            $("#idAttr").val("1").attr('selected', true);

            $("#productTypeId option:selected").removeAttr('selected');
            $("#productTypeId").val("1").attr('selected', true);
            //hide Image
            $("#image").hide();
            //focus
            $("#headerFocus").focus();
        });
        
        //change color background(validation)
        $("#name").blur(function() {
            if($(this).val() != ""){
                $(this).css("background", "#FFF");
            }
        });
        
        $(".zero").blur(function() {
            if($(this).val() != "0" || $(this).val() != "" ){
                $(this).css("background", "#FFF");
            }
        });
        
        $("textarea[name=detail]").blur(function() {
            if($(this).val() != "" ){
                $(this).css("background", "#FFF");
            }
        }); 
        
    });
    function updateImage(urlKey){
    	 $('#image-container').html('<img src="/serveImage.vn?urlKey='+urlKey+'" width="200" height="150" />');
    }
</script>

<div class="home-spot">
  <div class="account-create">

    <div class="page-title" id="focus">
    <logic:notPresent name="flagUpload">
        <h1>Upload sản phẩm</h1>
     </logic:notPresent>
      <logic:present name="flagUpload">
        <h1>Chỉnh sửa sản phẩm</h1>
      </logic:present>
    </div>
    <logic:present name="fUpload" scope="request">
      <span style="color: red;">Upload thành công, tiếp tục upload</span>
      <br>
    </logic:present>
    <form name="uploadImage" action="<%=blobstoreService.createUploadUrl("/uploadImage.vn")%>" method="post"
      enctype="multipart/form-data">
      <input type="file" name="myFile" class="buttonBG"> <input id="uploadAction" type="submit"
        value="Upload Hình" class="buttonBG">
    </form>

    <html:form action="/uploadProduct.vn" method="post" styleId="uploadForm">
      <html:hidden property="idProvider" />
      <html:hidden property="id" />
      <div class="fieldset">
        <h2 class="legend">Thông tin sản phẩm</h2>
        <ul class="form-list">
          <li class="fields">
            <div class="customer-name">
              <div class="field name-firstname">
                <label for="firstname" class="required"><em>*</em>Lựa chọn loại sản phẩm</label>
                <div class="input-box">
                  <html:select property="productTypeId" styleId="productTypeId">
                    <html:option value="1"> Thực phẩm sơ chế
     </html:option>
                    <html:option value="2"> Thực phẩm nấu sẵn
     </html:option>
                    <html:option value="3"> Rau xanh
     </html:option>
                    <html:option value="4"> Trái cây
     </html:option>
                  </html:select>
                </div>
              </div>
            </div>
          </li>
          <li class="fields">
            <div class="customer-name">
              <div class="field name-firstname">
                <label for="firstname" class="required" ><em>*</em>Chọn nhóm sản phẩm</label>
                <div class="input-box">
                  <html:select property="idAttr" styleId="idAttr">
                    <html:option value="1"> Kho
     </html:option>
                    <html:option value="2"> Canh
     </html:option>
                    <html:option value="3"> Xào
     </html:option>
                    <html:option value="4"> Lẩu
     </html:option>
                    <html:option value="5"> Khác
     </html:option>
                  </html:select>
                </div>
              </div>
            </div>
          </li>
          <li class="fields">
            <div class="customer-name">
              <div class="field name-firstname">
                <label for="firstname" class="required"><em>*</em>Lựa chọn trạng thái của sản phẩm</label>
                <div class="input-box">
                  <html:select property="status" styleId="status">
                    <html:option value="1"> Thực phẩm khuyến mãi
     </html:option>
                    <html:option value="2"> Thực phẩm bình thường
     </html:option>

                  </html:select>
                </div>
              </div>
            </div>
          </li>
          <li class="fields">
            <div class="customer-name">
              <div class="field name-firstname">
                <label for="firstname" class="required" ><em>*</em>Hình</label>
                <div id="image-container">
                    <logic:present name="notCropped">
                        <logic:present name="urlImageKey">
                            <script>
                            $(document).ready( function(){
                                window.open('viewImage.vn?key=product','Cropping','height=500,width=800,status=1,resizable=0,menubar=0');
                        	    });
                            </script>
                        </logic:present>
                    </logic:present>
                    <logic:notPresent name="notCropped">
                        <logic:present name="urlImageKey">
                            <img src="/serveImage.vn?urlKey=<bean:write name="urlImageKey"/>" width="200" height="150" id="image" />
                        </logic:present>
                    </logic:notPresent>
                  </div>
              </div>
            </div>
          </li>
          <li class="fields">
            <div class="customer-name">
              <div class="field name-firstname">
                <label for="firstname" class="required"><em>*</em>Tên món ăn</label>
                <div class="input-box">
                  <html:text property="name" styleId="name" size="45%"/>
                </div>
              </div>
            </div>
          </li>
          <li class="fields">
            <div class="customer-name">
              <div class="field name-firstname">
                <label for="firstname" class="required"><em>*</em>Số lượng</label>
                <div class="input-box">
                  <html:text property="number" styleId="number"   size="45%" styleClass="zero"/>
                </div>
              </div>
            </div>
          </li>
          <li class="fields">
            <div class="customer-name">
              <div class="field name-firstname">
                <label for="firstname" class="required" ><em>*</em>Giá</label>
                <div class="input-box">
                  <html:text property="price" styleId="price"  size="45%" styleClass="zero"/>
                </div>
              </div>
            </div>
          </li>
          <li class="fields">
            <div class="customer-name" id="divPrice">
              <div class="field name-firstname">
                <label for="firstname" class="required">Giá khuyến mãi</label>
                <div class="input-box">
                  <html:text property="promoPrice" styleId="promoPrice"  size="45%" styleClass="zero"/>
                </div>
              </div>
            </div>
          </li>
          <li class="fields">
            <div class="customer-name">
              <div class="field name-firstname">
                <label for="firstname" class="required"><em>*</em>Giới thiệu về sản phẩm</label>
                <div class="input-box">
                  <html:textarea property="detail" styleId="detail" />
                </div>
              </div>
            </div>
          </li>
          <li class="fields">
            <div class="customer-name">
              <div class="field name-firstname">
                <label for="firstname" class="required">Hướng dẫn cách nấu</label>
                <div class="input-box">
                  <html:textarea property="cooking" styleId="cooking" />
                </div>
              </div>
            </div>
          </li>

          <li><span style="color: red;" id="message"> <logic:messagesPresent message="true">
                <html:messages id="message" message="true">
                  <bean:write name="message" />
                </html:messages>
              </logic:messagesPresent> <html:messages id="error">
                <%=error%>
              </html:messages>
          </span></li>
<li>
          <div class="input-box">
        <logic:empty name="flagUpload">
                <input type=submit title="Submit" class="buttonBG" id="upload" value="Upload" />
                <input type="button" title="Reset" class="buttonBG" id="reset" value="Xóa hết" />
        </logic:empty>
        <logic:present name="flagUpload" >
                <input type="submit" title="Submit" class="buttonBG" id="upload" value="Cập nhật" />
        </logic:present>
        </div>
        </li>
</ul>
        <div class="buttons-set1">
          <p class="buttons-set1 p.required">* Yêu cầu phải nhập</p>
          <br />


        </div>
      </div>
    </html:form>
  </div>
</div>