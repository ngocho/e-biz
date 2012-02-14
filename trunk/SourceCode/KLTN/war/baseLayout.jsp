<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home page</title>
<meta name="description" content="Default Description">
<meta name="keywords" content="Food E-commerce">
<meta name="robots" content="*">
<link rel="icon" href="#" type="image/x-icon"/>
<link rel="shortcut icon" href="#" type="image/x-icon"/>
<!--[if lt IE 7]>
<script type="text/javascript">
//<![CDATA[
    var BLANK_URL = 'http://localhost/magento/js/blank.html';
    var BLANK_IMG = 'http://localhost/magento/js/spacer.gif';
//]]>
</script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="css/styles.css" media="all"/>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>

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
        
    </noscript>
    <div class="page"  >
        <div class="header-container">
        <tiles:insert attribute="header" />
</div>
 <tiles:insert attribute ="pankuzu" />
        <div class="main-container ">
    
           <!--  <div class="main"> -->
             
                <tiles:insert attribute="left" />
              <div class="col-main">
              
                                      <tiles:insert attribute="content" />    
                                          </div>     
 <tiles:insert attribute ="right" />
         <!--  </div> -->
     
        </div>
        
  <tiles:insert attribute ="footer" />      
  </div>
</div>


</body></html>