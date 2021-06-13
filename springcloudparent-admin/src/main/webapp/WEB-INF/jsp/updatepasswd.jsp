<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/static1/bootstrap-3.4.1-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/static1/css/page.css">
<script src="/static1/js/jquery.min.js"></script>
<script src="/static1/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="container" style="width:400px">
 <h2>管理员密码修改</h2>
 <br>
 <br>
  <form action="${pageContext.request.contextPath}/admin/updatepasswd" method="post">
    <div class="form-group">
      <label for="name">输入原密码:</label>
      <input type="text" class="form-control" name="passwd" placeholder="请输入原密码">
    </div>
    <div class="form-group">
      <label for="passwd">输入新密码:</label>
      <input type="text" class="form-control" name="passwd1" placeholder="请输入新密码">
    </div>
    <div class="form-group">
      <label for="passwd">确认密码:</label>
      <input type="text" class="form-control" name="passwd2" placeholder="请确认新密码">
    </div>
     <br> 
    <button type="submit" class="btn btn-primary">修改</button>
  </form>
</div>


${msg}
</body>
</html>