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

</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/addad" method="post">
<button class="btn btn-primary" style="float: right;margin-top: 15px;margin-right: 180px;margin-left: 20px" type="submit">增加</button>
</form>
<div class="search">
 <form class="" action="${pageContext.request.contextPath}/admin/adlists" method="post">
 <button class="btn btn-primary" style="float: right;margin-top: 15px;margin-right: 20px;margin-left: 20px" type="submit">搜索</button>
<input type="text" name="name" style="width:200px; float: right; margin-top: 15px;" placeholder="请输入用户名称">
</form>
</div>
<div>
</div>

<div class="middle table-responsive" style="width:90%;height: 250px; overflow:auto;">
<table class="table table-striped">
<tr>
<th>用户姓名</th>
<th>用户密码</th>
<th>注册时间</th>
<th>操作</th>
</tr>
<c:forEach items="${adlist}" var="a">
<tr>
<td>${a.aname}</td>
<td>${a.apasswd}</td>
<td>${a.adate}</td>
<td> <a href="/admin/delad?aname=${a.aname}">删除</a> &nbsp;&nbsp;</td>
</tr>
</c:forEach>
<tr>
</tr>
</table>
</div>
<div class="page">
<% 
int pageNo=(int)request.getAttribute("pageNo");
int totalPage=(int)request.getAttribute("totalPage");
%>
                  第${pageNo+1}页     共${totalPage}页                 
<%                    if(pageNo<totalPage-1){                  %>
<a href="/admin/adlists?pageNo=${pageNo+1}&name=${condition}">下一页</a>
<%  }                    if(pageNo>0){ %>
<a href="/admin/adlists?pageNo=${pageNo-1}&name=${condition}">上一页</a>
<%  } %>
</div>

${msg}
</body>
</html>