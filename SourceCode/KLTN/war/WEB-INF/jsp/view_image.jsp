<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Chọn ảnh làm avatar. </title>
      <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
      <script type="text/javascript" src="js/jquery.Jcrop.min.js"></script>
      <link rel="stylesheet" href="css/jquery.Jcrop.css" type="text/css" />
      <script>
      jQuery(function($){
          $('#cropping').Jcrop({
              onChange: cropChange,
              onSelect: cropChange,
              onRelease: cropClear,
            });
          function cropChange(c){
              $('#x').val(c.x);
              $('#y').val(c.y);
              $('#x2').val(c.x2);
              $('#y2').val(c.y2);
            };
              function cropClear(){
                  //this.setSelect(getRandom());
                }
        });
      function cropImage(){
    	  var x = $('#x').val();
    	  var y = $('#y').val();
    	  var x2 = $('#x2').val();
    	  var y2 = $('#y2').val();
    	  if(x != '' && y != ''
    			  && x != x2 && y != y2 ){
    		  if(confirm('Bạn xác nhận chọn vùng ảnh đã chọn làm ảnh đại diện.')){
    			  $.ajax({
                      url: '/cropImage.vn',
                      data: {
                          'leftX' : x,
                          'topY' : y,
                          'rightX' : x2,
                          'bottomY' : y2,
                          'width' : $('#cropping').width(),
                          'height' : $('#cropping').height(),
                          'key' : $('#key').val()
                      },
                      dataType: 'text',
                      success: function(data){
                    	  if(data != 'fail'){
                    		  window.opener.updateImage(data);
                              window.close();
                    	  }else{
                    		  alert('Có 1 sai sót nhỏ trong việc lưu ảnh.\nBồ vui lòng chọn lại giùm mình.')
                    	  }
                      }
                  });
    		  }
    	  } else {
    		  alert('Vui lòng chọn 1 vùng ảnh làm ảnh đại diện.');
    	  }
          
      }
      </script>
      <style type="text/css">
      img{
      max-height: 450px;
      max-width: 800px;
      }
      </style>
  </head>
  <body>
    <c:if test="${not empty param.key}">
      <input type="hidden" id="key" value="${param.key }">
      <c:if test="${'product' == param.key }">
        <logic:present name="urlImageKey" >
          <img src="/serveImage.vn?urlKey=<bean:write name="urlImageKey"/>" id="cropping" />
        </logic:present>
        <logic:notPresent name="urlImageKey">
          <div>
            Website của chúng tôi phát hiện 1 lỗi đang xảy ra. Bồ vui lòng quay lại vào lúc khác. Cảm ơn bồ đã thông cảm.
        </div>
        </logic:notPresent>
      </c:if>
      <c:if test="${'provider' == param.key }">
        <logic:present name="urlImageKeyP" >
          <img src="/serveImage.vn?urlKey=<bean:write name="urlImageKeyP"/>" id="cropping" />
        </logic:present>
        <logic:notPresent name="urlImageKeyP">
          <div>
            Website của chúng tôi phát hiện 1 lỗi đang xảy ra. Bồ vui lòng quay lại vào lúc khác. Cảm ơn bồ đã thông cảm.
        </div>
        </logic:notPresent>
      </c:if>
      <input type="hidden" id="x" >
      <input type="hidden" id="y" >
      <input type="hidden" id="x2" >
      <input type="hidden" id="y2" >
      <input type="button" value="Chọn" onclick="cropImage()" />
    </c:if>
    <c:if test="${empty param.key }">
      <div>
        Website của chúng tôi phát hiện 1 lỗi đang xảy ra. Bồ vui lòng quay lại vào lúc khác. Cảm ơn bồ đã thông cảm.
      </div>
    </c:if>
  </body>
</html>