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
<body>
<div class="search">
 <form class="" action="${pageContext.request.contextPath}/admin/userAndviewlist" method="post">
 <button class="btn btn-primary" style="float: right;margin-top: 15px;margin-right: 180px;margin-left: 20px" type="submit">搜索</button>
 <input type="text" name="uname" style="width:200px; float: right; margin-top: 15px;" placeholder="请输入用户名称">
</form>
</div>


<div class="middle table-responsive" style="width:90%;min-height: 300px; overflow:auto;">
<table class="table table-striped">
<tr>
<th>视频</th>
<th>用户姓名</th>
<th>视频编号</th>
<th>视频名称</th>
<th>视频播放数</th>
<th>上传时间</th>
</tr>
<c:forEach items="${userifo}" var="v">
<tr>
<td><img src="${v.image}" width="50px" height="50px"/></td>
<td>${v.user.uname}</td>
<td>${v.vid}</td>
<td>${v.vname}</td>
<td>${v.vnumber}</td>
<td>${v.vdata}</td>
</tr>
</c:forEach>
</table>
</div>
<div class="page">
<% int pageNo=(int)request.getAttribute("pageNo");
   int totalPage=(int)request.getAttribute("totalPage");
%>
第<%=pageNo+1%>页     共<%=totalPage %>页                 
<%                    if(pageNo<totalPage-1){                  %>
<a href="/admin/userAndviewlist?pageNo=${pageNo+1}&uname=${condition}">下一页</a>
<%  }                    if(pageNo>0){ %>
<a href="/admin/userAndviewlist?pageNo=${pageNo-1}&uname=${condition}">上一页</a>
<%  } %>
</div>

</body>
</html>