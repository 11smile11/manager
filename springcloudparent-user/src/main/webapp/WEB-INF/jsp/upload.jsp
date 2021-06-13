<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/static/bootstrap-3.4.1-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/page.css">
<!-- <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script> -->
<script src="/static/js/jquery.min.js"></script>
<script src="/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>

<script type="text/javascript">
function check(){	
var file=document.getElementById("upfile").files[0];
var titlle=document.getElementById("vname").value;
if(file.size==0 || titlle==""){
	alert("上传失败，请检查文件或封面 ");
	return false;
}else if(titlle==""){
	alert("标题不能为空 ");
	return false;
}else{
	alert("正在上传中 ");
	return true;
}
}


function ckvideo(){
var file=document.getElementById("upfile")。files[0];
var last=(file.name.lastIndexOf(".")+1)
var filemaxsize = 1024*1024* 50;
if(file.size>filemaxsize){
	alert("文件大小不能超过50M ");
	  file.value = "";
}else if(file.name.substring(last)!="mp4"){
	alert("上传视频格式必须为mp4");
	file.value = "";
}else{
	alert("正在上传中 ");
}
}

</script>

</head>

<body>
<div>
<h2 style="text-align: center;">视频上传</h2>
<br><br><br><br>

<div style="width:300px;height:200px;float:left;">
<h6>上传视频展示区:</h6>

<video src="${filename}" controls preload="auto" width=300px height=170px;>
</video>

</div>
<div class="middle" style="width:30%;">
    <form  action="/user/videoUpload" method="post" onsubmit="return check()" enctype="multipart/form-data">
        <div class="form-group">
        <label for="vname">上传视频</label>
        <input type="text" class="form-control" id="vname" name="vname" placeholder="请输入视频名称"/><br>
        </div>

    <!--  <div class="custom-file mb-1">
        <input class="custom-file-input" onchange="ckimage()" type="file" id="image" name="image"/>
        <label class="custom-file-label" for="image">上传视频封面</label>
        </div>
        <br> -->

        <div class="custom-file mb-1">
        <input class="custom-file-input" onchange="ckvideo()"  type="file" id="upfile" name="file"/>
        <label class="custom-file-label" for="upfile">选择文件</label>
        </div>
        <br>
        <br>
        <input type="submit" class="btn btn-primary" value="上传"/>
    </form>
</div>
</div>
${msg}
</body>
</html>