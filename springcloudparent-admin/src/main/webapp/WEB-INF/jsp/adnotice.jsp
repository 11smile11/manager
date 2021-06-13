<%@ page language="java" contentType="text/html; charset=utf-8" 
    pageEncoding="utf-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="/static1/bootstrap-3.4.1-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/static1/css/page.css">
<script src="/static1/js/jquery.min.js"></script>
<script src="/static1/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<br>
<br>
<br>
<br>
<div class="container table-responsive" style="width:60%;">
<form action="${pageContext.request.contextPath}/admin/addnotices" method="post">
<table class="table ">
<tr>
<td>标题：</td>
<td><input type="text" name="title" placeholder="输入公告的题目。" /></td>
</tr>
<tr>
<td>公告简介：</td>
<td><input type="text" name="name" placeholder="简单介绍公告内容。" /></td>
</tr>

<tr>
<td>详细信息：</td>
<td><textarea cols="50" rows="5" placeholder="请输入内容，最多输入200字。" name="detail"></textarea></td>
</tr>

<tr>
<td><input type="submit" name="submit" value="提交" /></td>
<td><input type="reset" name="reset" value="重置" /></td>
</tr>
</table>
</form>
</div>
${hh}
</body>
</html>