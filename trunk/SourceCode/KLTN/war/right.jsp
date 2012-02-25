<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<script type="text/javascript">
$(document).ready(function(){
    $("#uploadComment").click(function() {
    	/* alert('123');
    	window.open('/home.vn'
                , '_blank'
                , 'location=yes,menubar=yes,status=no,toolbar=no,scrollbars=yes,titlebar=yes,top=0,left=0,width=1024,height=768,resizable=yes'); */
     	updateComment($("#content").val());
        return false; 
    });
    
    $("#addXu").click(function() {
    	if($("#valueXu").val() !=''){
    	addXu($("#valueXu").val());
    	}
    	else{
    		alert('Vui lòng nhập mã thẻ Xu');
    	}
    	return false;
    });
    
    $("#transferXu").click(function() {
    	if($("#idUser").val() =='' || $("#valueMoney").val() ==''){
    		alert('Vui lòng nhập tên tài khoản người nhận');
    	}
    	else if($("#valueMoney").val() =='' ||$("#valueMoney").val() =='0'){
    		alert('Vui lòng nhập số tiền');
    	}
    	else{
    		
    		transferXu($("#idUser").val(),$("#valueMoney").val());
    	}
    	return false;
    });
    
    $("#content").focus(function() {
    	//alert('js');
    	 //$("#content").css(text-algin,left);
    });
    
});
</script>
<div class="col-right">
  <div class="block block-cart">
    <c:if test="${user !=null}">
      <div class="block-title">
        <a href="/customer.vn"><strong><span class="whiteImPression"><bean:message key="home.right.account.title" /></span>
        </strong>
        </a>
      </div>
      <strong><span><bean:write name="<%=CommonConstant.WELCOME %>" scope="session" /></span></strong>
      <br>
        <strong><span ><bean:message key="home.right.account.xu" />: <span class="impressionText" id="xuOnline"><bean:write name="user" property="xuOnline" scope="session" /></span> </span></strong>
      <br>
      <a href="/logoutCustomer.vn" style="margin-left:130px;"><b><bean:message key="home.right.account.logout" /></b></a>
    </c:if>
    <c:if test="${user ==null}">
      <div class="block-title">
       <strong><span class="whiteImPression"><bean:message key="home.right.login.title" /></span>
        </strong>
      </div>
      <div class="block-content">
        <ul>


          <html:form action="/loginAction.vn" method="get">
            <li><label for="email" class="required" id="typeLogin"><bean:message key="home.right.login.name" /></label>
              <div class="input-box">
                <html:text property="loginId" />
                <!--  <input type="text" name="login[username]" value="" id="email" class="input-text required-entry validate-email" title="Email Address"> -->
              </div>
            </li>
            <li><label for="pass" class="required"><bean:message key="home.right.login.password" /></label>
              <div class="input-box">
                <html:password property="loginPassword" />
                <!--  <input type="password" name="login[password]" class="input-text required-entry validate-password" id="pass" title="Password"> -->
              </div>
            </li>
            <li>
              <div class="input-box">
                <input type="submit" name="OK" id="pass"  class="buttonBG"
                  title="Password" value="<bean:message key="home.right.login.button" />">
              </div>
            </li>
            <li>
              <div class="input-box">
                <a href="/registerCustomer.vn"><bean:message key="home.right.login.register" /></a>
              </div>
            </li>
            <li>
          </html:form>


        </ul>
      </div>
        </c:if>
  </div>
   <div class="block" >
    <div class="block-title">

      <strong><span class="whiteImPression"><bean:message key="home.right.shopping.title" /></span> </strong> 
    </div>
    <div class="block-content">
      <p >
      <span class="empty1" > <bean:message key="home.right.shopping.name" /> </span><div class="block-cart_header">
     <a id="current_cart_items_count" href="/displayShoppingCart.vn"
        class="count"> <logic:present name="shop">
          <bean:write name="shop" property="count" />
        </logic:present> </a> <bean:message key="home.right.shopping.food" />
    </div>
       <p class="empty" style="text-align: left">
        <a href="/displayShoppingCart.vn">...<bean:message key="home.right.shopping.view" /></a>
      </p>
      <p class="empty" style="text-align: right">
        <a href="/checkAuthentication.vn">...<bean:message key="home.right.shopping.checkout" /></a>
      </p>
    </div>
  </div>
 <div class="block block-cart">
    <div class="block-title">

      <a href="/displayShoppingCart.vn"><strong><span class="whiteImPression"><bean:message key="home.right.xu.title" /></span> </strong> </a>
    </div>
		<div class="block-content">
			<form name="money" action="/addXu.vn" method="get" >
				<bean:message key="home.right.xu.value" />:<br><input type="text" name="valueXu"  value="" id="valueXu" /><input  class="buttonBG"
					type="submit" value="<bean:message key="home.right.xu.button" />" id="addXu"/>
			</form>
		</div>
	</div>
	<div class="block block-cart">
    <div class="block-title">
      <strong><span class="whiteImPression"><bean:message key="home.right.transferXu.title" /></span> </strong> 
    </div>
		<div class="block-content">
			<form name="moveMoney" action="/transferXu.vn" method="get" >
				<bean:message key="home.right.transferXu.to" />:<br><input type="text" name="name"  value="" id="idUser" /><br>
				<bean:message key="home.right.transferXu.number" />: <br><input type="text" name="money"  value=""  id="valueMoney" />
				<input  class="buttonBG"
					type="submit" value="<bean:message key="home.right.transferXu.button" />" id="transferXu"/>
			</form>
		</div>
	</div>
 
  <div class="block block-cart">
    <div class="block-title" >
      <strong><span class="whiteImPression"><bean:message key="home.right.comment.title" /></span> </strong>
    </div>
    <div class="block-content" style="background: white">
      <!--p class="empty">You have no items in your shopping cart.</p-->
      <form name="comment" action="/uploadComment.vn" style="clear: both">
      <textarea id="content"  rows="10"  style="width:98%;vertical-align:left;padding-right: 0px;padding-left: 0px;" align='left' name="content" >
	   </textarea><br>
	   <!-- id="uploadComment" -->
   <input type="submit" id="uploadComment" value="<bean:message key="home.right.comment.button" />" class="buttonBG" ></input>
      </form>

    </div>
  </div>


  <div class="block block-poll">
    <div class="block-title">
      <strong><span class="whiteImPression"><bean:message key="home.right.comment.title"/></span> </strong>
    </div>
    <form id="pollForm"
      action="/displayAss.vn"
      method="get" >
      <div class="block-content">
        <p class="block-subtitle"><bean:message key="home.right.assessment.name" />
          </p>
        <ul id="poll-answers">
          <li class="odd"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_5" value="1"> <span
            class="label"><label for="vote_5"><bean:message key="home.right.assessment.option1" /></label> </span>
          </li>
          <li class="even"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_6" value="2"> <span
            class="label"><label for="vote_6"><bean:message key="home.right.assessment.option2" /></label> </span>
          </li>
          <li class="odd"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_7" value="3"> <span
            class="label"><label for="vote_7"><bean:message key="home.right.assessment.option3" /></label> </span>
          </li>
          <li class="last even"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_8" value="4"> <span
            class="label"><label for="vote_8"><bean:message key="home.right.assessment.option4" /></label> </span>
          </li>
          <li class="last even"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_8" value="5"> <span
            class="label"><label for="vote_8"><bean:message key="home.right.assessment.option5" /></label> </span>
          </li>
        </ul>
        <div class="actions">
          <button type="submit" title="Vote" class="button">
            <span><span><bean:message key="home.right.assessment.button" /></span> </span>
          </button>
        </div>
      </div>
    </form>
  </div>
  <p class="home-callout">
<a href=""><img src="Images/Commons/accepted-payment-yellow-152x63.png" width="195" height="100" border="0"></a>
</p>
  <p class="home-callout">
<a href=""><img src="Images/Commons/taikhoanXu.png" width="195" height="200" border="0"></a>
</p>
</div>
