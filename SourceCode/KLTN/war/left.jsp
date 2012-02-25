<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div class="col-left ">
<%@taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
  <script type="text/javascript">
            $(document).ready(function() {
                //initialize google map api
                initialize();
                $("#searchID").focus(function() {
                    $("#searchID").val("");
                });
                $("#submitSearch").click(function() {
                    if ($("#searchID").val() == "") {
                        alert("Nhập thông tin tìm kiếm");
                        return false;
                    }
                });

                $("#resetSearch").click(function() {
                    $("#searchID").val("");
                    $("#type option:selected").removeAttr('selected');
                    $("#type").val("0").attr('selected', true);

                    $("#attr option:selected").removeAttr('selected');
                    $("#attr").val("0").attr('selected', true);

                    $("#price option:selected").removeAttr('selected');
                    $("#price").val("0").attr('selected', true);

                    $("#status option:selected").removeAttr('selected');
                    $("#status").val("1").attr('selected', true);

                });

            });
        </script>
  <div class="block block-cart">
    <div class="block-title">
      <strong><span class="whiteImPression"><bean:message key="home.search" /></span> </strong>
    </div>
    <div class="block-content">
      <html:form action="/search.vn" method="GET">
        <ul>
          <li><bean:message key="home.search.text" /><br>
          <html:text property="searchText" size="32" /></li>
          <li><bean:message key="home.search.optional1" />:<br> <html:select
              property="type" style="width: 190px;">
              <html:option value="0"><bean:message key="home.search.value1" /></html:option>
              <html:option value="1"><bean:message key="home.nav.menu1" /></html:option>
              <html:option value="2"><bean:message key="home.nav.menu2" /></html:option>
              <html:option value="3"><bean:message key="home.nav.menu3" /></html:option>
              <html:option value="4"><bean:message key="home.nav.menu4" /></html:option>
            </html:select></li>
          <li><bean:message key="home.search.optional2" />:<br> <html:select property="attr"
              style="width: 190px;">
              <html:option value="0"><bean:message key="home.search.value1" /></html:option>
              <html:option value="1"><bean:message key="home.search.optional2.1" /></html:option>
              <html:option value="2"><bean:message key="home.search.optional2.2" /></html:option>
              <html:option value="3"><bean:message key="home.search.optional2.3" /></html:option>
              <html:option value="4"><bean:message key="home.search.optional2.4" /></html:option>
              <html:option value="5"><bean:message key="home.search.optional2.5" /></html:option>
            </html:select></li>
          <li><bean:message key="home.search.optional3" />: <br> <html:select property="price"
              style="width: 190px;">
              <html:option value="0"><bean:message key="home.search.value1" /></html:option>
              <html:option value="1"><bean:message key="home.search.optional3.1" /></html:option>
              <html:option value="2"><bean:message key="home.search.optional3.2" /></html:option>
              <html:option value="3"><bean:message key="home.search.optional3.3" /></html:option>
              <html:option value="4"><bean:message key="home.search.optional3.4" /></html:option>
            </html:select></li>
          <li><bean:message key="home.search.optional4" />:<br> <html:select property="status"
              style="width: 190px;">
              <html:option value="1"><bean:message key="home.search.optional4.1" /></html:option>
              <html:option value="2"><bean:message key="home.search.optional4.2" /></html:option>
              <html:option value="0"><bean:message key="home.search.value1" /></html:option>
            </html:select></li>
          <logic:present name="providerSearchParam">
            <li><bean:message key="home.search.optional5" />:<br> <html:select property="provider"
                style="width: 190px;">
                <html:option value="0"><bean:message key="home.search.value1" /></html:option>
                <logic:iterate id="element" name="providerSearchParam">
                  <html:option value="${element.loginId}">
                    <bean:write name="element" property="loginName" />
                  </html:option>
                </logic:iterate>
              </html:select></li>
          </logic:present>
          <li><bean:message key="home.search.optional6" />:<br> <html:select
              property="districtNameS" style="width: 190px;">
              <html:option value="0">- - - - - - - <bean:message key="home.search.value2" />- - - - - - - </html:option>
              <html:option value="1">1</html:option>
              <html:option value="2">2</html:option>
              <html:option value="3">3</html:option>
              <html:option value="4">4</html:option>
              <html:option value="5">5</html:option>
              <html:option value="6">6</html:option>
              <html:option value="7">7</html:option>
              <html:option value="8">8</html:option>
              <html:option value="9">9</html:option>
              <html:option value="10">10</html:option>
              <html:option value="11">11</html:option>
              <html:option value="12">12</html:option>
              <html:option value="Bình Chánh">Bình Chánh</html:option>
              <html:option value="Bình Tân">Bình Tân</html:option>
              <html:option value="Bình Thạnh">Bình Thạnh</html:option>
              <html:option value="Gò Vấp">Gò Vấp</html:option>
              <html:option value="Hóc Môn">Hóc Môn</html:option>
              <html:option value="Nhà Bè">Nhà Bè</html:option>
              <html:option value="Phú Nhuận">Phú Nhuận</html:option>
              <html:option value="Tân Bình">Tân Bình</html:option>
              <html:option value="Tân Phú">Tân Phú</html:option>
              <html:option value="Thủ Đức">Thủ Đức</html:option>
            </html:select></li>
          <li><input type="submit" value="<bean:message key="home.search.button" />"
            class="buttonBG" size="30px" />
          </li>
        </ul>
      </html:form>
    </div>
  </div>
  <p class="home-callout">
 <a href="/getAddProviderList.vn" style="color:blue; text-decoration: underline;">Tìm địa chỉ cửa hàng</a>
<div id="map_canvas" style="width: 200px; height: 300px" onclick=""></div>
  <p class="home-callout">
    <a href=""><img src="Images/Commons/giaohang.png" width="195"
      height="200" border="0">
    </a>
  </p>
  <p class="home-callout">
    <a href=""><img src="Images/Commons/mail_sms.png" width="195"
      height="200" border="0">
    </a>
  </p>

  <p class="home-callout">
    <a href=""><img src="Images/Commons/voucher.png" width="195"
      height="200" border="0">
    </a>
  </p>

</div>
