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
<div class="search">
 <form  action="${pageContext.request.contextPath}/user/videolist" method="post">

 <button class="btn btn-primary" style="float: right;margin-top: 15px;margin-right: 180px;margin-left: 20px" type="submit">搜索</button>
  <input type="text" name="uname" style="width:200px; float: right; margin-top: 15px;" placeholder="请输入视频标题">
</form>
</div>
<br>
<br>
<div class="middle" style="width:90%;min-height: 300px; overflow:auto;">
<div class="row" style="width:100%;">
<c:forEach items="${videolt}" var="v">
<div class="video">
<div class="video1">
<%-- <a href="/user/videopaly?vid=${v.vid}">
<video id="video" controls preload="auto" width="400px" height="300px">
 <source src="/video/1.jpg" type="video/mp4">
</video></a> --%>
<a href="/user/videopaly?vid=${v.vid}"><img alt="" src="${v.image}" width="200px" height="150px" style="padding-left:20px;padding-right:20px;"></a>
</div>
<div class="video2">
<label>标题：${v.vname} </label>
</div>
</div>
</c:forEach>
</div>
</div>

<div class="page" >
<% int pageNo=(int)request.getAttribute("pageNo");
   int totalPage=(int)request.getAttribute("totalPage");
%>
第<%=pageNo+1%>页     共<%=totalPage %>页                 
<%                    if(pageNo<totalPage-1){                  %>
<a href="/user/videolist?pageNo=<%=pageNo+1%>&uname=${uname}">下一页</a>
<%  }                    if(pageNo>0){ %>
<a href="/user/videolist?pageNo=<%=pageNo-1%>&uname=${uname}">上一页</a>
<%  } %>
</div>

</body>
</html>