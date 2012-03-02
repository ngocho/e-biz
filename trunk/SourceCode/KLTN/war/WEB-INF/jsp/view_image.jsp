<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Chọn ảnh làm avatar. </title>
      <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
      <script type="text/javascript" src="js/jquery.Jcrop.min.js"></script>
      <link rel="stylesheet" type="css/jquery.Jcrop.css" />
      <script>
      jQuery(function($){
          var x,y;
          var jcrop_api;
          $('#cropping').Jcrop({
              onChange: cropChange,
              onSelect: cropChange,
              onRelease: cropClear,
              aspectRatio: 3/4
            },function(){
                  var b = this.getBounds();
                  x = b[0];y=b[1];
                });
          function cropChange(c){
              $('#x').val(c.x);
              $('#y').val(c.y);
              $('#x2').val(c.x2);
              $('#y2').val(c.y2);
              if(parseInt(c.w)>0){
                  var r=150/c.w;
                  $('#preview').css({
                      width: Math.round(r * x) + 'px',
                      height: Math.round(r * y) + 'px',
                      marginLeft: '-' + Math.round(r * c.x) + 'px',
                      marginTop: '-' + Math.round(r * c.y) + 'px'
                    });
                }
            };
              function cropClear(){
                  this.setSelect(getRandom());
                }
        });
      function cropImage(){
    	  if($('x').val() != ''
    			  && $('y').val() != ''
    			  && $('x2').val() != ''
    			  && $('y2').val() != ''){
    		  $.ajax({
                  url: '/cropImage.vn',
                  data: {
                      'leftX' : $('#x').val(),
                      'topY' : $('#y').val(),
                      'rightX' : $('#x2').val(),
                      'bottomY' : $('#y2').val(),
                      'width' : $('#cropping').width(),
                      'height' : $('#cropping').height()
                  },
                  dataType: 'text',
                  success: function(data){
                          window.opener.updateImage(data);
                          window.close();
                  }
              });
    	  } else {
    		  alert('Please choose an area to crop.');
    	  }
          
      }
      </script>
  </head>
  <body>
    <logic:present name="urlImageKey" >
      <img src="/serveImage.vn?urlKey=<bean:write name="urlImageKey"/>" id="cropping" />
      <input type="hidden" id="x" >
      <input type="hidden" id="y" >
      <input type="hidden" id="x2" >
      <input type="hidden" id="y2" >
      <input type="button" value="Chọn" onclick="cropImage()" />
    </logic:present>
    <logic:notPresent name="urlImageKey">
      <div>
        Website của chúng tôi phát hiện 1 lỗi đang xảy ra. Bồ vui lòng quay lại vào lúc khác. Cảm ơn bồ đã thông cảm.
      </div>
    </logic:notPresent>
  </body>
</html>