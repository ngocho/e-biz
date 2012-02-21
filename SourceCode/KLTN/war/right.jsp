<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
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
        <a href="/customer.vn"><strong><span class="whiteImPression"> TÀI KHOẢN CỦA BẠN</span>
        </strong>
        </a>
      </div>
      <strong><span><bean:write name="<%=CommonConstant.WELCOME %>" scope="session" /></span></strong>
      <br>
        <strong><span >Tài khoản Xu : <span class="impressionText" id="xuOnline"><bean:write name="user" property="xuOnline" scope="session" /></span> </span></strong>
      <br>
      <a href="/logoutCustomer.vn" style="margin-left:130px;"><b> Đăng xuất</b></a>
    </c:if>
    <c:if test="${user ==null}">
      <div class="block-title">
       <strong><span class="whiteImPression">ĐĂNG NHẬP</span>
        </strong>
      </div>
      <div class="block-content">
        <ul>


          <html:form action="/loginAction.vn" method="get">
            <li><label for="email" class="required" id="typeLogin">Tên
                đăng nhâp</label>
              <div class="input-box">
                <html:text property="loginId" />
                <!--  <input type="text" name="login[username]" value="" id="email" class="input-text required-entry validate-email" title="Email Address"> -->
              </div>
            </li>
            <li><label for="pass" class="required">Password</label>
              <div class="input-box">
                <html:password property="loginPassword" />
                <!--  <input type="password" name="login[password]" class="input-text required-entry validate-password" id="pass" title="Password"> -->
              </div>
            </li>
            <li>
              <div class="input-box">
                <input type="submit" name="OK" id="pass"  class="buttonBG"
                  title="Password" value="Đăng nhập">
              </div>
            </li>
            <li>
              <div class="input-box">
                <a href="/registerCustomer.vn">Đăng kí nếu chưa có tài khoản</a>
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

      <strong><span class="whiteImPression">GIỎ HÀNG</span> </strong> 
    </div>
    <div class="block-content">
      <p >
      <span class="empty1" > Bạn đã mua </span><div class="block-cart_header">
     <a id="current_cart_items_count" href="/displayShoppingCart.vn"
        class="count"> <logic:present name="shop">
          <bean:write name="shop" property="count" />
        </logic:present> </a> món hàng
    </div>
      </p>
       <p class="empty" style="text-align: left">
        <a href="/displayShoppingCart.vn">...xem giỏ hàng</a>
      </p>
      <p class="empty" style="text-align: right">
        <a href="/checkAuthentication.vn">...thanh toán</a>
      </p>
    </div>
  </div>
 <div class="block block-cart">
    <div class="block-title">

      <a href="/displayShoppingCart.vn"><strong><span class="whiteImPression">NẠP XU</span> </strong> </a>
    </div>
		<div class="block-content">
			<form name="money" action="/addXu.vn" method="get" >
				Nhập mã nạp xu :<br><input type="text" name="valueXu"  value="" id="valueXu" /><input  class="buttonBG"
					type="submit" value="Nạp xu" id="addXu"/>
			</form>
		</div>
	</div>
	<div class="block block-cart">
    <div class="block-title">
      <strong><span class="whiteImPression">CHUYỂN XU</span> </strong> 
    </div>
		<div class="block-content">
			<form name="moveMoney" action="/transferXu.vn" method="get" >
				Nhập tài khoản chuyển đến:<br><input type="text" name="name"  value="" id="idUser" /><br>
				Nhập số tiền chuyển : <br><input type="text" name="money"  value=""  id="valueMoney" />
				<input  class="buttonBG"
					type="submit" value="Chuyển" id="transferXu"/>
			</form>
		</div>
	</div>
 
  <div class="block block-cart">
    <div class="block-title" >
      <strong><span class="whiteImPression">NHẬN XÉT CỦA BẠN </span> </strong>
    </div>
    <div class="block-content" style="background: white">
      <!--p class="empty">You have no items in your shopping cart.</p-->
      <form name="comment" action="/uploadComment.vn" style="clear: both">
      <textarea id="content"  rows="10"  style="width:98%;vertical-align:left;padding-right: 0px;padding-left: 0px;" align=left name="content" >
	   </textarea><br>
	   <!-- id="uploadComment" -->
   <input type="submit" id="uploadComment" value="Gởi ý kiến" class="buttonBG" ></input>
      </form>

    </div>
  </div>

  <!-- <div class="block block-banner">
    <div class="block-content">
      <img src="./resource_files/col_right_callout.jpg"
        title="Thông tin quảng cáo"
        alt="Hiển thị thông tin quảng cáo">
    </div>
  </div> -->
  <!-- <script type="text/javascript">
//<![CDATA[
    function validatePollAnswerIsSelected()
    {
        var options = $$('input.poll_vote');
        for( i in options ) {
            if( options[i].checked == true ) {
                return true;
            }
        }
        return false;
    }
//]]>
</script> -->


  <div class="block block-poll">
    <div class="block-title">
      <strong><span class="whiteImPression">ĐÁNH GIÁ</span> </strong>
    </div>
    <form id="pollForm"
      action="/displayAss.vn"
      method="get" >
      <div class="block-content">
        <p class="block-subtitle">Bạn thích gì ở trang web chúng
          tôi?</p>
        <ul id="poll-answers">
          <li class="odd"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_5" value="1"> <span
            class="label"><label for="vote_5">Món ăn đa
                dạng</label> </span>
          </li>
          <li class="even"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_6" value="2"> <span
            class="label"><label for="vote_6">Giá cả phải
                chăng</label> </span>
          </li>
          <li class="odd"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_7" value="3"> <span
            class="label"><label for="vote_7">Giao diện
                dễ sử dụng</label> </span>
          </li>
          <li class="last even"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_8" value="4"> <span
            class="label"><label for="vote_8">Thanh toán
                đảm bảo</label> </span>
          </li>
          <li class="last even"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_8" value="5"> <span
            class="label"><label for="vote_8">Giao hàng
                tận tình</label> </span>
          </li>
        </ul>
        <div class="actions">
          <button type="submit" title="Vote" class="button">
            <span><span>Xem kết quả</span> </span>
          </button>
        </div>
      </div>
    </form>
  </div>
  <p class="home-callout">
<a href=""><img src="Images/Commons/accepted-payment-yellow-152x63.png" width="195" height="100" border="0"></a>
</p>
  <!-- <div class="paypal-logo">
    <a href="#"
      onclick="javascript:window.open(&#39;https://www.paypal.com/us/cgi-bin/webscr?cmd=xpt/Marketing/popup/OLCWhatIsPayPal-outside&#39;,&#39;paypal&#39;,&#39;width=600,height=350,left=0,top=0,location=no,status=yes,scrollbars=yes,resizable=yes&#39;); return false;"><img
      src="Images/Commons/bnr_nowAccepting_150x60.gif"
      alt="Các ngân hàng trực tuyến có thể thanh toán"
      title="Additional Options"> </a>
  </div> -->
</div>