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
<br>

<div style="height:150px;">
<div style="float:left;width:150px;height:150px;margin-left:120px;margin-right:20px">
<img src="http://t.cn/RCzsdCq" height="140px" width="120px">
</div>
<div style="height:100%;display:flex;flex-direction:column;justify-content:space-around;">
<label>用户名称: <%=session.getAttribute("name") %></label>
<label>视频点赞数:${likenb}</label>
<label>视频收藏数:${collenb}</label>
<label>视频上传数:${upnb}</label>
</div>
</div>


<div class="middle" style="width:80%;min-height: 222px; overflow:auto;">
<h3>上传视频点击数展示</h3>
<table class="table table-striped" style="vertical-align:center;">
<tr>
<th>视频</th>
<th>视频编号</th>
<th>视频名称</th>
<th>视频点击数</th>
</tr>
<c:forEach items="${obj}" var="v">
<tr>
<td style="vertical-align:middle;"><a href="/user/videopaly?vid=${v.vid}">
<img  src="${v.image}" width="50px" height="50px"/></a></td>
<td style="vertical-align:middle;">${v.vid}</td>
<td style="vertical-align:middle;">${v.vname}</td>
<td style="vertical-align:middle;">${v.vnumber}</td>
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
<a href="/user/usernumberrecord?pageNo=<%=pageNo+1%>">下一页</a>
<%  }                    if(pageNo>0){ %>
<a href="/user/usernumberrecord?pageNo=<%=pageNo-1 %>">上一页</a>
<%  } %>
</div>
</html>