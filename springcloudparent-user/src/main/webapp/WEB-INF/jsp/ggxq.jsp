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
</head>
<body>
<h2 style="text-align: center;">公告信息</h2>
<br>
<br>
<div class="container" style="width:60%;">
<table class="table">
<tr>
<td>标题：</td>
<td>${gg.title}</td>
</tr>
<tr>
<td>发布人：</td>
<td>${gg.oper}</td>
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