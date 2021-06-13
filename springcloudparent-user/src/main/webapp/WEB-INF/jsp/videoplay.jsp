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
function onclick1(){
	var status=<%=session.getAttribute("status")%>
	if(status=="1"){
		addup();
	}else{
		 alert('账号异常，不能进行操作');
	}
}
function onclick2(){
	var status=<%=session.getAttribute("status")%>
	if(status=="1"){
		addcol();
	}else{
		 alert('账号异常，不能进行操作');
	}
}
function addup(){
  $.post("/user/like","vid="+'${vid}',function(data){
			$(".up").text(data);
  })
}  
function addcol(){
	  $.post("/user/collect","vid="+'${vid}',function(data){
				$(".col").text(data);
				if(data=="已经收藏"){
						$(".glyphicon-heart").css("color","red");
				}else{
						$(".glyphicon-heart").css("color","black");
				}
	 })
}  
$(function(){
	 $.post("/user/likenumber","vid="+'${vid}',function(data){
			$(".up").text(data);
      })
     $.post("/user/collectnumber","vid="+'${vid}',function(data){
				$(".col").text(data);
			if(data=="已经收藏"){
					$(".glyphicon-heart").css("color","red");
			}else{
					$(".glyphicon-heart").css("color","black");
			}
	 })
})


</script>
</head>
<body>
<br>
<br>
<div class="middle" style="width:65%;">
<div class="videostyle">
<video id="video" controls preload="auto" width="100%" >
 <source src="${url}" type="video/mp4">
</video>
</div>
<!--点赞-->
<div class="praise" style="float:right;" >									
<span class="glyphicon glyphicon-thumbs-up"  onclick="onclick1()">点赞数</span>
<span class="up"></span>
</div>

<!--收藏-->
<div class="collect" style="float:right;padding-right:10px;">									
	<span class="glyphicon glyphicon-heart" onclick="onclick2()">收藏</span>
	<span class="col">${url}</span>
</div>

</div>



<div data-toggle="modal" data-target="#myModal" style="float:right;padding-right:10px;">									
	<span class="glyphicon glyphicon-envelope" >申诉</span>
</div>
<!-- 模态框（Modal） -->
 <div  class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					视频举报
				</h4>
			</div>
			<div class="modal-body">
				<form role="form" id="form" action="/user/jubao">
				    <div class="form-group">
						<label >举报视频id：${vid}</label>
					</div>
					
					<div class="form-group">
						<label for="title">举报标题</label>
						<input type="text" id="title" name="title" class="form-control" placeholder="简述申请">
					</div>
					
					<div class="form-group">
						<label for="name">举报类型     </label>
						<select id="name"  name="name" >
               					 <option>申请解封</option>
                				<option>视频举报</option>
           					 </select>
					</div>
					
					<div class="form-group">
						<label for="detail">举报原因</label>
						<input type="text" id="detail" name="detail" class="form-control" placeholder="详述申请的原因以及视频id">
					</div>
				 
			
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="submit" class="btn btn-primary" >提交</button>
			</div>
			</form>
		</div><!-- /.modal-body -->
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


</body>
</html>
