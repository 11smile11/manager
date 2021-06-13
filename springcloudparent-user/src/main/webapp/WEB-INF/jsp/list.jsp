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
<div class="middle" style="width:80%;height: 390px; overflow:auto;">
<c:if test="${oper==1 }"><h3 style="text-align: center; ">我的喜欢展示</h3></c:if>
<c:if test="${oper==2 }"><h3 style="text-align: center; ">我的收藏展示</h3></c:if>
<br>
<br>
<table class="table table-striped table-hover" style="vertical-align:center;">
<tr>
<th>视频</th>
<th>视频编号</th>
<th>视频名称</th>
<th>视频点击数</th>
</tr>
<c:forEach items="${list}" var="v">
<tr>
<td style="vertical-align:middle;"><a href="/user/videopaly?vid=${v.vid}">
<img  src="${v.video.image}" width="50px" height="50px"/></a></td>
<td style="vertical-align:middle;">${v.video.vid}</td>
<td style="vertical-align:middle;">${v.video.vname}</td>
<td style="vertical-align:middle;">${v.video.vnumber}</td>
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
<a href="/user/recordvideo1?pageNo=<%=pageNo+1%>&oper=${oper}">下一页</a>
<%  }                    if(pageNo>0){ %>
<a href="/user/recordvideo1?pageNo=<%=pageNo-1 %>&oper=${oper}">上一页</a>
<%  } %>
</div>
</body>
</html>