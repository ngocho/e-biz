<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.Jcrop.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.Jcrop.css">
<style type="text/css">
#forPreview {
  width: 150px;
  height: 200px;
  overflow: hidden;
}
</style>
<script type="text/javascript">
jQuery(function($){
	var x,y;
	$('#image').Jcrop({
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
	    $('#width').val(c.w);
	    $('#height').val(c.h);
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
	    $('#coord input').val('');
	}
	
});

</script>
</head>
<body>
  <table>
    <tr>
      <td><img id="image" src="image/test.jpg"></td>
      <td>
        <div id="forPreview">
          <img id="preview" src="image/test.jpg">
        </div>
      </td>
    </tr>
  </table>

  <form class="coord" action="CropImageServlet" method="get">
    <input type="text" id="x" name="x" >
    <input type="text" id="y" name="y" >
    <input type="text" id="width" name="width" >
    <input type="text" id="height" name="height" >
    <input type="submit" value="Crop">
  </form>
</body>
</html>