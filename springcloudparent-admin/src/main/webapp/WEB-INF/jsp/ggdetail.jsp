<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/static1/bootstrap-3.4.1-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/static1/css/page.css">
<script src="/static1/js/jquery.min.js"></script>
<script src="/static1/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function add(){
	var id =$("#id").text();
	$.post("/admin/sqxg?",{id:id, status:2},function(data){
		
	})
})
</script>
</head>
<body>
<br>
<br>
<br>
<br>
<div class="container table-responsive" style="width:60%;">
<table class="table">
<tr>
<td>序号：</td>
<td id="id">${gg.id}</td>
</tr>
<tr>
<td>标题：</td>
<td>${gg.title}</td>
</tr>
<tr>
<td>上传人：</td>
<td>${gg.oper}</td>
</tr>
<tr>
<td id="status">状态：</td>
<td>
<c:if test="${gg.status == 1}"> 未查看</c:if>
<c:if test="${gg.status == 2}"> 已查看</c:if>
</td>
</tr>
<tr>
<td>公告简介：</td>
<td>${gg.name}</td>
</tr>

<tr>
<td>详细信息：</td>
<td><textarea cols="50" rows="5" disabled>${gg.detail}</textarea></td>
</tr>
</table>
</div>
</body>
</html>