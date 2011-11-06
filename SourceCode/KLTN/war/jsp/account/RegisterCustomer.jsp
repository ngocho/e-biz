<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<title>Jada Mobile</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="Jada Mobile">
<meta name="Description" content="Jada Mobile">

<!-- Individual YUI CSS files -->
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.7.0/build/reset-fonts-grids/reset-fonts-grids.css">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.7.0/build/container/assets/skins/sam/container.css">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.7.0/build/menu/assets/skins/sam/menu.css">
<!-- Individual YUI JS files -->

<script type="text/javascript" src="http://yui.yahooapis.com/2.7.0/build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.7.0/build/animation/animation-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.7.0/build/connection/connection-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.7.0/build/container/container-min.js"></script>
<script type="text/javascript" src="http://yui.yahooapis.com/2.7.0/build/menu/menu-min.js"></script>

<link rel="stylesheet" type="text/css" href="/jada/content/template/basic/styles.css">
<script type="text/javascript" src="/jada/content/template/basic/carousel.js"></script>
<script type="text/javascript" src="/jada/content/template/basic/jcCommon.js"></script>

</head>

<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<div align="center" style="background-color: #eeeeee">
 My Mobile Site
</div>
<div align="center" style="background-color: #eeeeee">
  <div style="margin:0pt auto; width:950px;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>
          <div align="left">

            <script type="text/javascript">
    YAHOO.example.onMenuBarReady = function(p_oEvent) {
    // Instantiate and render the menu bar
    var oMenuBar = new YAHOO.widget.MenuBar("MAIN12", { autosubmenudisplay:true, hidedelay:750, lazyload:true });
        oMenuBar.render();
    }
    // Initialize and render the menu bar when it is available in the DOM
    // YAHOO.util.Event.onContentReady("${menuDivId}_done", YAHOO.example.onMenuBarReady);
    YAHOO.util.Event.on(window, "load", YAHOO.example.onMenuBarReady);
</script>
<div id="MAIN12" align="left" style="white-space: nowrap;" class="yuimenubar yuimenubarnav"><div class="bd" align="left" style="white-space: nowrap;" ><ul class="first-of-type"><li class="yuimenubaritem" class="first-of-type"><a href="/jada/web/fe/mobile/English/home" class="yuimenubaritemlabel" onclick="javascrpt:window.open('/jada/web/fe/mobile/English/home', '_self' );return false;">Home</a></li><li class="yuimenubaritem" class="first-of-type"><a href="/jada/web/fe/mobile/English/category/Home+Phones/Home+Phones" class="yuimenubaritemlabel" onclick="javascrpt:window.open('/jada/web/fe/mobile/English/category/Home+Phones/Home+Phones', '_self' );return false;">Phones</a><div id="MAIN121"  class="yuimenu"><div class="bd"  ><ul class="first-of-type"><li class="yuimenuitem"><a href="/jada/web/fe/mobile/English/category/Home+Phones+Classic+phones/Home+Phones+Classic+phones" class="yuimenuitemlabel" onclick="javascrpt:window.open('/jada/web/fe/mobile/English/category/Home+Phones+Classic+phones/Home+Phones+Classic+phones', '_self' );return false;">Classic phones</a></li><li class="yuimenuitem"><a href="/jada/web/fe/mobile/English/category/Home+Phones+Smart+phones/Home+Phones+Smart+phones" class="yuimenuitemlabel" onclick="javascrpt:window.open('/jada/web/fe/mobile/English/category/Home+Phones+Smart+phones/Home+Phones+Smart+phones', '_self' );return false;">Smart phones</a></li></ul></div></div></li><li class="yuimenubaritem" class="first-of-type"><a href="/jada/web/fe/mobile/English/category/Home+Accessories/Home+Accessories" class="yuimenubaritemlabel" onclick="javascrpt:window.open('/jada/web/fe/mobile/English/category/Home+Accessories/Home+Accessories', '_self' );return false;">Accessories</a><div id="MAIN122"  class="yuimenu"><div class="bd"  ><ul class="first-of-type"><li class="yuimenuitem"><a href="/jada/web/fe/mobile/English/category/Home+Accessories+Headset/Home+Accessories+Headset" class="yuimenuitemlabel" onclick="javascrpt:window.open('/jada/web/fe/mobile/English/category/Home+Accessories+Headset/Home+Accessories+Headset', '_self' );return false;">Headset</a></li><li class="yuimenuitem"><a href="/jada/web/fe/mobile/English/category/Home+Accessories+Faceplates/Home+Accessories+Faceplates" class="yuimenuitemlabel" onclick="javascrpt:window.open('/jada/web/fe/mobile/English/category/Home+Accessories+Faceplates/Home+Accessories+Faceplates', '_self' );return false;">Faceplates</a></li></ul></div></div></li><li class="yuimenubaritem" class="first-of-type"><a href="/jada/myaccount/portal/myAccountPortal.do?process=start&prefix=mobile&langName=English" class="yuimenubaritemlabel" onclick="javascrpt:window.open('/jada/myaccount/portal/myAccountPortal.do?process=start&prefix=mobile&langName=English', '_self' );return false;">My account</a></li></ul></div></div>

          </div>
            </td>

            <td valign="middle">
              <div align="right">
          <script language="JavaScript">
function profilePost(query) {
    var url = document.siteProfile.action;
    if (url.indexOf('?') == -1) {
        url += '?';
    }
    else {
        url += '&';
    }
    url += query;
    window.location.href = url;
}

function selectLanguage() {
    var object = document.siteProfile.langName;
    var langName = object.options[object.selectedIndex].value;
    profilePost('langName=' + langName);
}

function selectCurrency() {
    var object = document.siteProfile.currencyCode;
    var currencyCode = object.options[object.selectedIndex].value;
    profilePost('currencyCode=' + currencyCode);
}
</script>
<form name="siteProfile" method="post" action="/jada/web/fe/mobile/English/home">
<span id="profile-language-text">Language</span>
<select id="profile-language" name="langName" onChange="selectLanguage();">
                      <option value="English" selected>English</option>
                <option value="French" >Français</option>

    </select>
<span id="profile-currency-text">Currency</span>
<select class="profile-currency" name="currencyCode" onChange="selectCurrency();">
                      <option value="USD" selected>USD</option>
    </select>
</form>          </div>
            </td>
          </tr>
        </table>

  </div>
</div>

<div align="center">
<div style="margin:0pt auto; width:950px;">
<table width="100%" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td nowrap><font size="36px" face="Arial, Helvetica, sans-serif">Mffffe</font>
    </td>
    <td width="100%" valign="bottom" align="right">
        <script type="text/javascript" language="JavaScript">
function focusfield(infocus, control) {
    if (infocus) {
        if (control.value == "Keyword Search") {
            control.value = "";
        }
    }
    else {
        if (control.value == "") {
            control.value = "Keyword Search";
        }
    }
}
function jc_query_submit() {
    var url = '/jada/web/fe/mobile/English/search';
    var search = document.getElementById('search');
    url += '?query=' + search.value;
    document.location.href = url;
}

</script>
<search-query-container>
    <form name="search" method="post" action="/jada/web/fe/mobile/English/search">
        <input name="query" class="jc_input_small" id="search-query-input" onfocus="focusfield(true, this);" onblur="focusfield(false, this);" value="Keyword Search" size="20" maxlength="100">
        <a href="javascript:document.search.submit();" class="search-query-link">Search</a>
    </form>
</search-query-container>    </td>
    <td>
      <div align="right">

        <a href="http://demo1.jadasite.com/jada/web/fe/mobile/English/home">
        <!--img src="/jada/services/ImageProvider.do?type=S&imageId=6&maxsize=120" border="0"-->
        </a>
      </div>
    </td>
  </tr>
</table>
<hr>
<br>
<table width="100%" border="0" cellspacing="0" cellpadding="5">
  <tr>

    <td valign="top">
      <div align="left">
                  





<script type="text/javascript" src="http://www.google.com/recaptcha/api/js/recaptcha_ajax.js"></script>
<script type="text/javascript" language="JavaScript"><!--
function submitForm(type) {
    document.myAccountRegisterActionForm.process.value = type;
    document.myAccountRegisterActionForm.submit();
}

YAHOO.util.Event.onContentReady('recaptcha_div', function() {
    if ("" == "Y") {
        var options = {
                    theme: "clean",
                    callback: Recaptcha.focus_response_field,
                    custom_translations : { instructions_visual : 'unknown',
                                            instructions_audio : 'unknown',
                                            play_again : 'Play sound again',
                                            cant_hear_this : 'Download sound as MP3',
                                            visual_challenge : 'Get a visual challenge',
                                            audio_challenge : 'Get an audo challenge',
                                            refresh_btn : 'Get a new challenge',
                                            help_btn : 'Help',
                                            incorrect_try_again : "unknown" }
                };
        Recaptcha.create("", "recaptcha_div", options);
    }
} );
//--></script>

<div id="my-account-container">
<div id="my-account-public-header-container">
  <span id="my-account-public-header">Account registration</span>
</div>
<br>
<html:form  method="POST" action="/register.vn" >
<table>
<tr>
<td>Vui lòng nhập đầy đủ thông tin phía dưới</td></tr>
<tr>
<td>
Tên đăng nhập:</td>
<td><html:text property="customerId" /></td><td><span id="kt" onmouseover='color()' onmouseout='out()' onclick='new_ajax(register)'>Kiểm tra</span></td><td><div id="id"></div>
</td>
<td align="left" class="stlerror" ><html:errors property="customerId" /></td></tr>

<tr>
<td>Mật khẩu:</td>
<td><html:password  property="customerPassword"/></td>
<td align="left" class="stlerror" ><html:errors property="customerPassword" /></td></tr>
<tr>
<td>Email:</td>
<td><html:text property="customerEmail"/></td>
<td align="left" class="stlerror" ><html:errors property="customerEmail" /></td></tr>
<tr>
<td>Địa chỉ:</td>
<td><html:text property="customerAddress"/></td><td>
<td align="left" class="stlerror" ><html:errors property="customerAddress" /></td></tr>
<tr><td></td>
<td>
<html:reset property="Xóa hết " />
<html:submit  value="Đăng kí" ></html:submit></td></tr>
</table>
<font color="red">Cung cấp thêm một số thông tin của bạn</font>
</html:form>
<logic:messagesPresent >
<font color="red">
<html:messages id="error">
<%= error%>
</html:messages>
</font>
</logic:messagesPresent>
</div>

</body>
</html>