<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css"> 
#ie6-warning{ 
background:rgb(255,255,225) url("/upload/201006/20100628012515690.gif") no-repeat scroll 8px center; 
position:absolute; 
top:0; 
left:0; 
font-size:12px; 
color:#333; 
width:97%; 
padding: 2px 15px 2px 23px; 
text-align:left; 
} 
#ie6-warning a { 
text-decoration:none; 
} 
</style>
</head>
<body>
<!--[if lte IE 6]>
<div id="ie6-warning">您正在使用 Internet Explorer 6，在本网站中显示的效果可能有差异。建议您升级到 <a href="http://www.microsoft.com/china/windows/internet-explorer/" target="_blank">Internet Explorer 8</a>以享受最佳体验 
</div>
<script type="text/javascript">
function position_fixed(el, eltop, elleft){
// check if this is IE6
if(!window.XMLHttpRequest)
window.onscroll = function(){
el.style.top = (document.documentElement.scrollTop + eltop)+"px";
el.style.left = (document.documentElement.scrollLeft + elleft)+"px";
}
else el.style.position = "fixed";
}
position_fixed(document.getElementById("ie6-warning"),0, 0);
setTimeout($("#ie6-warning").hide(), 5000);
</script> 
<![endif]--> 
</body>
</html>