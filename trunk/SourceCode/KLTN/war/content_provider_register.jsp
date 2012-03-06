<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ page
  import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script type="text/javascript">
    $(document).ready(function() {
        $("#reset").click(function() {
            resetFormProvider(1);
            $(".reset").val("");
            $("#districtName option:selected").removeAttr('selected');
            $("#districtName").val("0").attr('selected', true);
            //focus
            $("#headerFocus").focus();
            $("#loginId").focus();

        });

        $("#register").click(function() {
            var flag = validateProviderRegister();
            if (!flag) {
                return false;
            }
        });

        $(".reset").blur(function() {
            if ($(this).val() != "") {
                $(this).css("background", "#FFF");
            }
        });
    });
    function updateImage(urlKey){
        $('#image-container').html('<img src="/serveImage.vn?urlKey='+urlKey+'" width="200" height="150" />');
   }
</script>
<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory
					.getBlobstoreService();
%>
<div class="home-spot">
  <div class="account-create">

    <div class="page-title">
      <h1>Tạo một tài khoản mới</h1>
    </div>
      <form name="uploadImage"
      action="<%=blobstoreService.createUploadUrl("/uploadImage.vn")%>"
      method="post" enctype="multipart/form-data">
      <input type="file" name="myFile" class="buttonBG"> 
      <input type="hidden" value="1" name="type"/>
      <input  type="submit" value="Upload Hình"
        class="buttonBG">
    </form>
    
    <html:form action="/registerProvierAcc.vn" method="post"
      styleId="registerForm">
      <div class="fieldset">
        <h2 class="legend">Thông tin đăng nhập</h2>

        <ul class="form-list">
          <li class="fields">
            <div class="field"></div>
          </li>
          <li class="fields">
            <div class="customer-name">
              <div class="field name-firstname">
                <label class="required" id="typeLogin"><em>*</em>Tên
                  đăng nhập</label>
              </div>
              <div class="input-box">
                <html:text property="loginId" styleId="loginId"
                  styleClass="reset" />
              </div>

            </div> <html:errors property="usrinvalid" />
          </li>

          <li class="fields">
            <div class="field">
              <label class="required"><em>*</em>Mật khẩu</label>
              <div class="input-box">
                <html:password property="loginPassword"
                  styleClass="reset" />

              </div>
            </div>
            <div class="field">
              <label class="required"><em>*</em>Nhập lại mật
                khẩu</label>
              <div class="input-box">
                <html:password property="loginPasswordPre"
                  styleClass="reset" />
              </div>
            </div>
          </li>
          <li><logic:messagesPresent message="true">
              <html:messages id="message" message="true">
               <span class="impressionText"><bean:write name="message" /></span> 
                <br />
              </html:messages>
            </logic:messagesPresent>
          </li>
        </ul>
      </div>
      <div class="fieldset">

        <h2 class="legend">
          <span>Thông tin cửa hàng</span>
        </h2>
        <ul class="form-list">
        <li>
    </li>
     <li class="fields">
            <div class="customer-name">
              <div class="field name-firstname">
                <label for="firstname" class="required" ><em>*</em>Hình</label>
                <div class="input-box" id="image-container">
                  
                  <logic:present name="notCropped">
                    <logic:present name="urlImageKeyP">
                      <script>
                      $(document).ready( function(){
                    	  window.open('viewImage.vn?key=provider','Cropping','height=500,width=800,status=1,resizable=0,menubar=0');
                      });
                      </script>
                    </logic:present>
                  </logic:present>
                  <logic:notPresent name="notCropped">
                    <logic:present name="urlImageKeyP">
                      <img src="/serveImage.vn?urlKey=<bean:write name="urlImageKeyP"/>" width="200" height="150" id="image" />
                    </logic:present>
                  </logic:notPresent>
                 
                </div>
              </div>
            </div>
          </li>
          <li class="fields">
            <div class="field">
              <label class="required"><em>*</em>Tên cửa hàng</label>
              <div class="input-box">
                <html:text property="loginName" size="40"
                  styleClass="reset" />
              </div>
            </div>
          </li>
          <li class="fields">
            <div class="field">
              <label class="required"><em>*</em>Email</label>
              <div class="input-box">
                <html:text property="email" size="40" styleClass="reset" />

              </div>
            </div>
          </li>
          <li class="fields">
            <div class="field">
              <label class="required"><em>*</em>Số nhà</label>
              <div class="input-box">
                <html:text property="homeNumber" styleClass="reset" />
              </div>
            </div>
            <div class="field">
              <label class="required"><em>*</em>Tên đường</label>
              <div class="input-box">
                <html:text property="streetName" size="40"
                  styleClass="reset" />
              </div>
            </div>
          </li>
          <li class="fields">
            <div class="field">
              <label class="required"><em>*</em>Phường</label>
              <div class="input-box">
                <html:text property="wardName" size="40"
                  styleClass="reset" />
              </div>
            </div>
            <div class="field">
              <label for="billing:email" class="required"><em>*</em>Quận</label>
              <div class="input-box">
                <html:select property="districtName"
                  styleId="districtName">
                  <html:option value="0">- - - - - - - - - - - - Chọn quận- - - - - - - - - - - - -</html:option>
                  <html:option value="18">1</html:option>
                  <html:option value="42">2</html:option>
                  <html:option value="17">3</html:option>
                  <html:option value="21">4</html:option>
                  <html:option value="20">5</html:option>
                  <html:option value="25">6</html:option>
                  <html:option value="41">7</html:option>
                  <html:option value="37">8</html:option>
                  <html:option value="43">9</html:option>
                  <html:option value="19">10</html:option>
                  <html:option value="24">11</html:option>
                  <html:option value="44">12</html:option>
                  <html:option value="36">Bình Chánh</html:option>
                  <html:option value="39">Bình Tân</html:option>
                  <html:option value="31">Bình Thạnh</html:option>
                  <html:option value="38">Gò Vấp</html:option>
                  <html:option value="61">Hóc Môn</html:option>
                  <html:option value="63">Nhà Bè</html:option>
                  <html:option value="32">Phú Nhuận</html:option>
                  <html:option value="22">Tân Bình</html:option>
                  <html:option value="40">Tân Phú</html:option>
                  <html:option value="45">Thủ Đức</html:option>
                </html:select>
              </div>
            </div>
          </li>
          <li class="fields">
            <div class="field">
              <label class="required">Tòa nhà</label>
              <div class="input-box">
                <html:text property="buildingName" size="40"
                  styleClass="reset" />
              </div>
            </div>
          </li>
          <li>
            <div class="field">
              <label class="required"><em>*</em>Số điện thoại</label>
              <div class="input-box">
                <html:text property="phone" size="40" styleClass="reset" />
              </div>
            </div>
          </li>
          <li>
          
            <div class="field">
              <label class="required"><em>*</em>Giới thiệu về
                cửa hàng</label>
              <div class="input-box">
                <html:textarea property="detail" styleClass="reset" style="width: 200px;"/>
              </div>
            </div>
          </li>
          <li><span style="color: red" id="errorID"> <logic:messagesPresent>
                <script type="text/javascript">
                                                                    $(document).ready(function() {
                                                                        $("#register").focus();
                                                                    });
                                                                </script>
                <html:messages id="error"
                  header="providerForm.registerMadatory">
                </html:messages>
              </logic:messagesPresent> </span></li>
              <li>
              <div class="input-box">
<input type="submit" title="Submit"  class="buttonBG" id="register" value="Đăng kí"/>
<input type="button" title="Reset" id="reset"
         class="buttonBG" value="Xóa hết"/>
        </div>
              </li>
        </ul>



      </div>
     
    </html:form>
  </div>


  <div class="buttons-set1">
    <p class="buttons-set1 p.required" style="color: red;">*
      Required Fields</p>
    <br />

  </div>


</div>
