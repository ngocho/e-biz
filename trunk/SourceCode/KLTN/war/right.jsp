<%@page import="ebiz.util.CommonConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<div class="col-right">
  <div class="block block-cart">
    <c:if test="${user !=null}">
      <div class="block-title">
        <a href="/customer.vn"><strong><span>TÀI KHOẢN CỦA BẠN</span>
        </strong>
        </a>
      </div>
      <strong><span><bean:write name="<%=CommonConstant.WELCOME %>" scope="session" /></span></strong></br>
      <a href="/logoutCustomer.vn" style="margin-left:130px;"><b> Đăng xuất</b></a>
    </c:if>
    <c:if test="${user ==null}">
      <div class="block-title">
        <a href="/loginCustomer.vn"><strong><span>ĐĂNG NHẬP</span>
        </strong>
        </a>
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
   <div class="block block-cart">
    <div class="block-title">

      <strong><span>GIỎ HÀNG</span> </strong> 
    </div>
    <div class="block-content">
      <p >
      <span class="empty1" > Bạn đã mua </span><div class="block-cart_header">
     <a id="current_cart_items_count" href="/displayShoppingCart.vn"
        class="count"> <logic:present name="shop">
          <bean:write name="shop" property="count" />
        </logic:present> </a> món hàng
     <!--  <h3>
        <a href="/displayShoppingCart.vn"></a>
      </h3>
    <a href="/checkAuthentication.vn"" class="link-checkout"></a> -->
    </div>
        <%-- <span id="countShop"
          style="color: red; font-weight: bold; font-size: 15pt">
          <logic:present name="shop">
            <bean:write name="shop" property="count" />
          </logic:present> </span> --%>
      </p>
      <%--  <logic:present name="shop" property="products">
        <logic:iterate id="element"  name="shop" property="products" length="3">
      <p class="empty" style="color:blue;"><bean:write name="element" property="name"/></p>
      </logic:iterate>
      </logic:present> --%>
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

      <a href="/displayShoppingCart.vn"><strong><span>NẠP XU</span> </strong> </a>
    </div>
		<div class="block-content">
			<form name="money" action="" method="get">
				Nhập mã nạp xu :<input type="text" name="xu" /><input  class="buttonBG"
					type="submit" value="Nạp xu"/>
			</form>
		</div>
	</div>
 
  <div class="block block-cart">
    <div class="block-title" style="background: red">
      <strong style="color: white; font-size: 16px;"><span>ĐỔI
          TIỀN </span> </strong>
    </div>
    <div class="block-content" style="background: white">
      <!--p class="empty">You have no items in your shopping cart.</p-->
      <form name="money">
        <table>
          <tr>
            <th>Nhập số tiền:</th>
          </tr>
          <tr>
            <td><input type="text" size="32" name="money" /></td>
          </tr>
          <tr>
            <td>Đơn
              vị&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select>
                <option>U.S Dollar(USD)</option>
                <option>Euro(EUR)</option>
                <option>VNĐ</option>
            </select>
            <td>
          </tr>
          <tr>
          <tr>
            <td>Đổi thành tiền&nbsp;&nbsp;<select>
                <option>VNĐ</option>
                <option>U.S Dollar(USD)</option>
                <option>Euro(EUR)</option>

            </select>
            <td>
          </tr>
          <tr>
            <td>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp; <input type="submit"
              style="width: 100px" onclick="" name="changeMoney"
              value="Đổi" />
            <td>
          </tr>

        </table>

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
  <script type="text/javascript">
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
</script>


  <div class="block block-poll">
    <div class="block-title">
      <strong><span>ĐÁNH GIÁ</span> </strong>
    </div>
    <form id="pollForm"
      action="http://localhost/magento/index.php/poll/vote/add/poll_id/2/"
      method="post" onsubmit="return validatePollAnswerIsSelected();">
      <div class="block-content">
        <p class="block-subtitle">Bạn thích gì ở trang web chúng
          tôi?</p>
        <ul id="poll-answers">
          <li class="odd"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_5" value="5"> <span
            class="label"><label for="vote_5">Món ăn đa
                dạng</label> </span>
          </li>
          <li class="even"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_6" value="6"> <span
            class="label"><label for="vote_6">Giá cả phải
                chăng</label> </span>
          </li>
          <li class="odd"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_7" value="7"> <span
            class="label"><label for="vote_7">Giao diện
                dễ sử dụng</label> </span>
          </li>
          <li class="last even"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_8" value="8"> <span
            class="label"><label for="vote_8">Thanh toán
                đảm bảo</label> </span>
          </li>
          <li class="last even"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_8" value="8"> <span
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
  <div class="paypal-logo">
    <a href="#"
      onclick="javascript:window.open(&#39;https://www.paypal.com/us/cgi-bin/webscr?cmd=xpt/Marketing/popup/OLCWhatIsPayPal-outside&#39;,&#39;paypal&#39;,&#39;width=600,height=350,left=0,top=0,location=no,status=yes,scrollbars=yes,resizable=yes&#39;); return false;"><img
      src="Images/Commons/bnr_nowAccepting_150x60.gif"
      alt="Các ngân hàng trực tuyến có thể thanh toán"
      title="Additional Options"> </a>
  </div>
</div>