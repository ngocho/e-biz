<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart - Magento Commerce Demo Store</title>
<meta name="description" content="Default Description">
<meta name="keywords" content="Magento, Varien, E-commerce">
<meta name="robots" content="INDEX,FOLLOW">
<link rel="icon" href="http://demo3.magentocommerce.com/skin/frontend/default/default/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="http://demo3.magentocommerce.com/skin/frontend/default/default/favicon.ico" type="image/x-icon">
<!--[if lt IE 7]>
<script type="text/javascript">
//<![CDATA[
    var BLANK_URL = 'http://demo.magentocommerce.com/js/blank.html';
    var BLANK_IMG = 'http://demo.magentocommerce.com/js/spacer.gif';
//]]>
</script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="css/styles.css" media="all">
<link rel="stylesheet" type="text/css" href="css/widgets.css" media="all">
<link rel="stylesheet" type="text/css" href="css/print.css" media="print">
<script type="text/javascript" src="js/ccard.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<script type="text/javascript" src="js/builder.js"></script>
<script type="text/javascript" src="js/effects.js"></script>
<script type="text/javascript" src="js/dragdrop.js"></script>
<script type="text/javascript" src="js/controls.js"></script>
<script type="text/javascript" src="js/slider.js"></script>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/form.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/translate.js"></script>
<script type="text/javascript" src="js/cookies.js"></script>
<script type="text/javascript" src="js/weee.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="js/jquery-1.2.6.min.js"></script>

<script type="text/javascript">
//jQuery.noConflict();
$(document).ready(function(){
    $('[id$=.update]').blur(function(){
        var index = $('[id$=.update]').index(this);
        var item = $('[id$=.update]')[index];
        var numberUpdate =$('[id$=.update]').find( item ).val();
        var idUpdate = $('[id$=.update]').find( item ).attr("name");
        updateNumberProduct(idUpdate,numberUpdate);
    });
});

</script>
<script type="text/javascript">

$(document).ready(function(){
    $("#checkout").click(function() {
        $("#idForm").submit();
    });
});

</script>
</head>

<body class=" checkout-cart-index">

<!-- BEGIN GOOGLE ANALYTICS CODE -->

<!-- END GOOGLE ANALYTICS CODE --><div class="wrapper">
        <noscript>
        <div class="noscript">
            <div class="noscript-inner">
                <p><strong>JavaScript seem to be disabled in your browser.</strong></p>
                <p>You must have JavaScript enabled in your browser to utilize the functionality of this website.</p>
            </div>
        </div>
    </noscript>
    <p class="demo-notice">This is a demo store. Any orders placed through this store will not be honored or fulfilled.</p>
    <div class="page">
        <div class="header-container">
    <tiles:insert attribute="header" />
</div>



        <div class="main-container col1-layout">
            <tiles:insert attribute="content" />
        </div>
        <div class="footer-container">
    <div class="footer">
        <div class="store-switcher">
    <label for="select-store">Select Store:</label>
    <select id="select-store" title="Select Store" onchange="location.href=this.value">
                        <option value="http://demo.magentocommerce.com/?___store=blue">Blue Skin</option>
                    <option value="" selected="selected">Main Store</option>
                    <option value="http://demo.magentocommerce.com/?___store=modern_theme2">Modern Theme</option>
        </select>
</div>
<ul>
<li><a href="http://demo.magentocommerce.com/about-magento-demo-store">About Us</a></li>
<li class="last"><a href="http://demo.magentocommerce.com/customer-service">Customer Service</a></li>
</ul><ul class="links">
                        <li class="first"><a href="http://demo.magentocommerce.com/catalog/seo_sitemap/category/" title="Site Map">Site Map</a></li>
                                <li><a href="http://demo.magentocommerce.com/catalogsearch/term/popular/" title="Search Terms">Search Terms</a></li>
                                <li><a href="http://demo.magentocommerce.com/catalogsearch/advanced/" title="Advanced Search">Advanced Search</a></li>
                                <li><a href="https://demo.magentocommerce.com/sales/guest/form/" title="Orders and Returns">Orders and Returns</a></li>
                                <li><a href="http://demo.magentocommerce.com/contacts/" title="Contact Us">Contact Us</a></li>
                                <li class=" last"><a href="http://demo.magentocommerce.com/rss/" title="RSS" class="link-rss">RSS</a></li>
            </ul>
        <p class="bugs">Help Us to Keep Magento Healthy - <a href="http://www.magentocommerce.com/bug-tracking" onclick="this.target='_blank'"><strong>Report All Bugs</strong></a> (ver. 1.6.1.0)</p>
        <address>Â© 2011 Magento Demo Store. All Rights Reserved.</address>
    </div>
</div>
            </div>
</div>


</body></html>