<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#reset").click(function() {
			resetFormProvider(0);
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
		   
		   $("#loginId").blur(function() {
		        if($(this).val() != ""){
		        $(this).css("background", "#FFF");
		    }
		    });
		   $("#loginPassword").blur(function() {
               if($(this).val() != ""){
               $(this).css("background", "#FFF");
           }
           });
	});
</script>
<div class="home-spot">
	<div class="col-2 registered-users" class="login">
		<div class="content">
		<h2>KẾT QUẢ KHẢO SÁT</h2>
			<logic:present name="assList" scope="request">
			<logic:iterate id="elemt" name="assList">
			
			<ul class="form-list">
				<li><label><bean:write name="elemt" property="name"/> </label> <br><div style="background: red; width:<bean:write name="elemt" property="number"/>px;"><span style="color:red;">0</span></div>
				<bean:write name="elemt" property="number"/> 
				</li>
				</ul>
			</ul>
			</logic:iterate>
</logic:present>

		</div>
	</div>
</div>