<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Home page</title>
<meta name="description" content="Default Description">
<meta name="keywords" content="Magento, Varien, E-commerce">
<meta name="robots" content="*">
<link rel="icon" href="http://localhost/magento/skin/frontend/default/default/favicon.ico" type="image/x-icon"/>
<link rel="shortcut icon" href="http://localhost/magento/skin/frontend/default/default/favicon.ico" type="image/x-icon"/>
<!--[if lt IE 7]>
<script type="text/javascript">
//<![CDATA[
    var BLANK_URL = 'http://localhost/magento/js/blank.html';
    var BLANK_IMG = 'http://localhost/magento/js/spacer.gif';
//]]>
</script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="css/styles.css" media="all"/>
<!-- <link rel="stylesheet" type="text/css" href="css/widgets.css" media="all"/>
<link rel="stylesheet" type="text/css" href="css/print.css" media="print"/> -->
<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src="js/ccard.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<script type="text/javascript" src="js/builder.js"></script>
<script type="text/javascript" src="js/effects.js"></script>
<script type="text/javascript" src="js/dragdrop.js"></script>
<script type="text/javascript" src="js/controls.js"></script>
<script type="text/javascript" src="js/slider.js"></script> -->
<script type="text/javascript" src="js/js.js"></script>
<!-- <script type="text/javascript" src="js/form.js"></script>
<script type="text/javascript" src="js/menu.js"></script> -->
<!-- <script type="text/javascript" src="js/cookies.js"></script> -->
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="js/jquery-1.2.6.min.js"></script>

<script type="text/javascript">

function slideSwitch() {
    var $active = $('#slideshow IMG.active');

    if ( $active.length == 0 ) $active = $('#slideshow IMG:last');

    // use this to pull the images in the order they appear in the markup
    var $next =  $active.next().length ? $active.next()
        : $('#slideshow IMG:first');

    // uncomment the 3 lines below to pull the images in random order
    
    // var $sibs  = $active.siblings();
    // var rndNum = Math.floor(Math.random() * $sibs.length );
    // var $next  = $( $sibs[ rndNum ] );


    $active.addClass('last-active');

    $next.css({opacity: 0.0})
        .addClass('active')
        .animate({opacity: 1.0}, 1000, function() {
            $active.removeClass('active last-active');
        });
}

$(function() {
    setInterval( "slideSwitch()", 2000 );
});

</script>

<!--[if lt IE 8]>
<link rel="stylesheet" type="text/css" href="http://localhost/magento/skin/frontend/default/default/css/styles-ie.css" media="all" />
<![endif]-->
<!--[if lt IE 7]>
<script type="text/javascript" src="http://localhost/magento/js/lib/ds-sleight.js"></script>
<script type="text/javascript" src="http://localhost/magento/skin/frontend/base/default/js/ie6.js"></script>
<![endif]-->


</head>
<body class=" cms-index-index cms-home">
<div class="wrapper">
        <noscript>
        &lt;div class="noscript"&gt;
            &lt;div class="noscript-inner"&gt;
                &lt;p&gt;&lt;strong&gt;JavaScript seem to be disabled in your browser.&lt;/strong&gt;&lt;/p&gt;
                &lt;p&gt;You must have JavaScript enabled in your browser to utilize the functionality of this website.&lt;/p&gt;
            &lt;/div&gt;
        &lt;/div&gt;
    </noscript>
    <div class="page">
        <!--div class="header-container"-->
        <tiles:insert attribute="header" />

        <div class="main-container col2-right-layout">
            <div class="main">
              <tiles:insert attribute ="pankuzu" />
              <div class="col-main">
                   <div class="std">
                           <tiles:insert attribute="left" />
                                      <tiles:insert attribute="content" />    
                                          </div>                </div>
 <tiles:insert attribute ="right" />
          </div>
        </div>
      <tiles:insert attribute ="footer" />
  </div>
</div>


</body></html>