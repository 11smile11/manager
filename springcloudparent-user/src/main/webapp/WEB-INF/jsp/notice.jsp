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
<body >
<div class="middle" style="width:90%;height: 400px; overflow:auto;">
<h2 style="text-align: center;">公告信息展示</h2>
<br>
<br>
<br>
<table class="table table-striped">
<tr>
<th>编号</th>
<th>标题</th>
<th>发布人</th>
<th>查看详情</th>
</tr>
<c:forEach items="${gonggao}" var="m">
<tr>
<td>${m.id}</td>
<td>${m.title}</td>
<td>${m.name}</td>
<td><a href="/user/ggxq?id=${m.id}" >查看</a></td>
</tr>
</c:forEach>
</table>
</div>

<div class="page">
<% int pageNo=(int)request.getAttribute("pageNo");
   int totalPage=(int)request.getAttribute("totalPage");
%>

第<%=pageNo+1%>页     共<%=totalPage %>页            
     
<%                    if(pageNo<totalPage-1){   %>               
<a href="/user/usernotice?pageNo=<%=pageNo+1%>">下一页</a>
<%  }                    if(pageNo>0){ %>
<a href="/user/usernotice?pageNo=<%=pageNo-1 %>">上一页</a>
<%  } %>
</div>
</body>
</html>