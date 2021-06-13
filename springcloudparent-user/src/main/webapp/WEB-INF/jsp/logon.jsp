<%@ page language="java" contentType="text/html; charset=utf-8" 
    pageEncoding="utf-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/static/bootstrap-3.4.1-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/page.css">
<!-- <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script> -->
<script src="/static/js/jquery.min.js"></script>
<script src="/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<style>
.col-center-block {
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;
}
</style>
</head>
<body> 
 <div  style="margin-top:150px" class="container">
  <div class="row myCenter">
    <div class="col-xs-6 col-md-4 col-center-block">
      <form class="form-signin" action="${pageContext.request.contextPath}/user/logon" method="post">
        <h2 style="text-align:center;" class="form-signin-heading">请登录</h2>
        <br>
        <label for="name" class="sr-only">用户名</label>
        <input type="text" name="name" id="name" class="form-control" placeholder="用户名" required autofocus>
        <br>
        <label for="passwd" class="sr-only">密码</label>
        <input type="password" name="passwd"  id="passwd" class="form-control" placeholder="密码" required>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>
      <div style="text-align:center;">
      <br>
      <p>没有登录？点击这里<a  href="/user/register">注册</a></p>
      </div>
    </div>
  </div>
</div>
${msg}
</body>
</html>