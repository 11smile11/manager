<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/static1/bootstrap-3.4.1-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/static1/css/page.css">
<script src="/static1/js/jquery.min.js"></script>
<script src="/static1/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>

<form action="${pageContext.request.contextPath}/admin/addnotice" method="post">
<button class="btn btn-primary" style="float: right;margin-top: 15px;margin-right: 180px;margin-left: 20px" type="submit">增加</button>
</form>
<div class="search">
 <form class="" action="${pageContext.request.contextPath}/admin/searchnotice?manage=admin" method="post">
 <button class="btn btn-primary" style="float: right;margin-top: 15px;margin-right: 180px;margin-left: 20px" type="submit">搜索</button>
 <input type="text" name="name" style="width:200px; float: right; margin-top: 15px;" placeholder="请输入视频ID">
</form>
</div>
<div class="middle table-responsive" style="width:90%;height: 250px; overflow:auto;">



<table class="table table-striped">
<tr>
<th>id</th>
<th>公告标题</th>
<th>公告简介</th>
<th>公告操作</th>
</tr>
<c:forEach items="${gonggao}" var="g">
<tr>
<td>${g.id}</td>
<td>${g.title}</td>
<td>${g.name}</td>
<td>
   <a href="/admin/delnotice?id=${g.id}">删除</a> &nbsp;&nbsp;
   <a href="/admin/detailnotice?id=${g.id}">查看</a> &nbsp;&nbsp;
 </td>
</tr>
</c:forEach>
<tr>
</tr>
</table>
</div>





<div class="page">
<% int pageNo=(int)request.getAttribute("pageNo");
   int totalPage=(int)request.getAttribute("totalPage");
%>
第<%=pageNo+1%>页     共<%=totalPage %>页                 
<%                    if(pageNo<totalPage-1){                  %>
<a href="/admin/videolist?pageNo=<%=pageNo+1%>">下一页</a>
<%  }                    if(pageNo>0){ %>
<a href="/admin/videolist?pageNo=<%=pageNo-1 %>">上一页</a>
<%  } %>
</div>


</body>
</html>