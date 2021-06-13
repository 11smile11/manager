<%@ page language="java" contentType="text/html; charset=utf-8" 
    pageEncoding="utf-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="/static1/bootstrap-3.4.1-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/static1/css/page.css">
<script src="/static1/js/jquery.min.js"></script>
<script src="/static1/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width:400px;">
<form action="${pageContext.request.contextPath}/admin/updateuser" method="post">
<div class="table-responsive">
<table class="table">
<tr>
<td>用户名：</td>
<td><input type="hidden" name="uname" value="${u.uname}" /></td>
</tr>
<tr>
<td>用户名：</td>
<td>${u.uname}</td>
</tr>
<tr>
<td>注册时间：</td>
<td>${u.date}</td>
</tr>

<tr>
<td>用户密码</td>
<td></td>
</tr>
<tr>
<td>用户状态</td>
<td><select name="status">
<option value=1 ${u.status==1?'selected':''}>正常</option>
<option value=2 ${u.status==2?'selected':''}>封禁</option>
</select></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="提交" /></td>
<td><input type="reset" name="reset" value="重置" /></td>
</tr>
</table>
</div>
</form>



</div>
${hh}
</body>
</html>