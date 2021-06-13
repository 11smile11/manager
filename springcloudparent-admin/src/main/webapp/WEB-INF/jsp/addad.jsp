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
<script type="text/javascript">
$(function(){
	$("#form1").ajaxForm(function(data){  
		console.log(data)
	});     
});

function check(){
	var pass=$("#passwd").val();
	var pass1=$("#passwd1").val();
	if( pass!=pass1){
		alert("密码不一致，请重新输入");
		$("#passwd").val("");
		$("#passwd1").val("");
	}
}
</script>
</head>
<body>

<div class="container table-responsive" style="width:400px">
 <h2>管理员注册</h2>
 <br>
 <br>
  <form action="${pageContext.request.contextPath}/admin/add" id="form1" method="post">
    <div class="form-group">
      <label for="name">用户名:</label>
      <input type="text" class="form-control" id="name" name="name" placeholder="请输入要注册用户名">
    </div>
    <div class="form-group">
      <label for="passwd">输入密码:</label>
      <input type="password" class="form-control" id="passwd" name="passwd"  placeholder="请输入密码">
    </div>
     <div class="form-group">
      <label for="passwd">确认密码:</label>
      <input type="password" class="form-control" id="passwd1" name="passwd1" onchange="check()"  placeholder="请输入密码">
    </div>
     <br> 
    <button type="submit" class="btn btn-primary">注册</button>
  </form>
</div>


${msg}
</body>
</html>