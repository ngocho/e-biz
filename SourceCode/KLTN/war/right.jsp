<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<div class="col-right sidebar">
 <div class="block block-cart">
    <div class="block-title">
      <strong><span>ĐĂNG NHẬP</span>
      </strong>
    </div>
    <div class="block-content">
    <form action="">
    Tên đăng nhập:
     <!--   hoặc <a href="#">Email </a>:<br> -->
      <input type="text" name="id"/><br>
      Mật khẩu:</br>
      <input type="password" name="password"   size="30"/><br>
      <input type="submit" value="Đăng nhập"/> 
     </form>
    </div>
  </div>
  <div class="block block-cart">
    <div class="block-title">
      <a href="" ><strong><span>GIỎ HÀNG</span>
      </strong></a>
    </div>
    <div class="block-content">
    <p class="empty"> Bạn đã mua <span id="countShop"  style="color:red; font-weight: bold; font-size: 15pt">
    <logic:present name="shop">
    <bean:write name ="shop" property="count" /> 
    </logic:present>
    </span> món hàng</p>
      <p class="empty">a</p>
      <p class="empty">b</p>
      <p class="empty">c</p>
      <p class="empty" style="text-align: right">
        <a href="#">...thanh toán</a>
      </p>
    </div>
  </div>
  <div class="block block-cart">
    <div class="block-title" style="background: red">
      <strong style="color:white; font-size: 16px;"><span>ĐỔI TIỀN </span>
      </strong>
    </div>
    <div class="block-content" style="background: white">
      <!--p class="empty">You have no items in your shopping cart.</p-->
      <form name="money">
        <table>
          <tr>
            <th>Nhập số tiền:</th>
          </tr>
          <tr>
            <td><input type="text" size="32" 
              name="money" />
            </td>
          </tr>
          <tr>
            <td>Đơn vị&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select>
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
            &nbsp;&nbsp;&nbsp;
            <input type="submit" style="width: 100px" onclick="" name="changeMoney" value="Đổi"/>
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
      <strong ><span>ĐÁNH GIÁ</span>
      </strong>
    </div>
    <form id="pollForm"
      action="http://localhost/magento/index.php/poll/vote/add/poll_id/2/"
      method="post" onsubmit="return validatePollAnswerIsSelected();">
      <div class="block-content">
        <p class="block-subtitle">Bạn thích gì ở trang web chúng tôi?</p>
        <ul id="poll-answers">
          <li class="odd"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_5" value="5"> <span
            class="label"><label for="vote_5">Món ăn đa dạng</label>
          </span></li>
          <li class="even"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_6" value="6"> <span
            class="label"><label for="vote_6">Giá cả phải chăng</label>
          </span></li>
          <li class="odd"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_7" value="7"> <span
            class="label"><label for="vote_7">Giao diện dễ sử dụng</label>
          </span></li>
          <li class="last even"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_8" value="8"> <span
            class="label"><label for="vote_8">Thanh toán đảm bảo</label>
          </span></li>
          <li class="last even"><input type="radio" name="vote"
            class="radio poll_vote" id="vote_8" value="8"> <span
            class="label"><label for="vote_8">Giao hàng tận tình</label>
          </span></li>
        </ul>
        <div class="actions">
          <button type="submit" title="Vote" class="button">
            <span><span>Vote</span>
            </span>
          </button>
        </div>
      </div>
    </form>
  </div>
   <div class="paypal-logo">
    <a href="http://localhost/magento/#" title="Additional Options"
      onclick="javascript:window.open(&#39;https://www.paypal.com/us/cgi-bin/webscr?cmd=xpt/Marketing/popup/OLCWhatIsPayPal-outside&#39;,&#39;paypal&#39;,&#39;width=600,height=350,left=0,top=0,location=no,status=yes,scrollbars=yes,resizable=yes&#39;); return false;"><img
      src="Images/Commons/bnr_nowAccepting_150x60.gif"
      alt="Các ngân hàng trực tuyến có thể thanh toán" title="Additional Options">
    </a>
  </div>
</div>