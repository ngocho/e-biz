<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<script type="text/javascript">
    $(document).ready(function() {
        $("#generate").click(function() {
            //resetFormProvider(0);
            //$(".remove").val("");
             $("#loginId").val('');
             $("#loginPassword").val('');
             $("#loginId").focus();
        });
        
           $("#login").click(function() {
                var flag =  validateProviderLogin();
                if(!flag){
                    return false;
                }
            });
           
    });
</script>
<div class="home-spot">
  <div class="col-2 registered-users" class="login">
    <div class="content">
      <h2>THẺ NẠP XU</h2>
      <ul class="form-list">
        <li><label for="email" class="required" id="typeLogin">Số
            lượng thẻ xu còn hiệu lực:    </label>
           <span style="color:red; margin-left: 30px;" id="xuActive"><bean:write name="xuActive" /></span></li>
        <li>
          <div class="input-box">
           <input type="button" name="download" id="download" onclick="setLocation('/downloadXu.vn')"
               value="Download mã Xu" class="buttonBG" />
            <input type="button" name="Generate" id="generate"
              title="Password" value="Sinh ra mã Xu mới" class="buttonBG" />
          </div></li>
      </ul>
      <p class="required">* Bắt buộc phải nhập</p>
    </div>
  </div>
</div>