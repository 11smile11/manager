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
<div class="middle" style="width:90%;">
<h2 style="text-align: center;">我的申请展示</h2>

<div class="search">
 <form  action="${pageContext.request.contextPath}/user//usersq" method="post">
 
 <select name="status" class="selectpicker" style="margin-top: 15px;margin-left: 20px;margin-left:600px;">
 <option value="" ${status==""?'selected':''}>全部</option>
 <option value="1" ${status=="1"?'selected':''}>未查看</option>
 <option value="2" ${status=="2"?'selected':''}>已查看</option>
</select>
 <button class="btn btn-primary" style="float: right;margin-top: 15px;margin-right: 180px;margin-left: 20px" type="submit">搜索</button>
</form>
</div>
<br>
<table class="table table-striped">
<tr>
<th>编号</th>
<th>标题</th>
<th>上传人</th>
<th>申请原因</th>
<th>申请状态</th>
</tr>
<c:forEach items="${gonggao}" var="m">
<tr>
<td>${m.id}</td>
<td>${m.title}</td>
<td>${m.oper}</td>
<td>${m.name}</td>
<td>
<c:if test="${m.status==1}">未查看</c:if>
<c:if test="${m.status==2}">已查看</c:if>
</td>
</tr>
</c:forEach>
</table>
</div>

<div class="page1">
<% int pageNo=(int)request.getAttribute("pageNo");
   int totalPage=(int)request.getAttribute("totalPage");
%>
第<%=pageNo+1%>页     共<%=totalPage %>页                 
<%                    if(pageNo<totalPage-1){   %>               
<a href="/user/usersq?pageNo=<%=pageNo+1%>&status=${status}">下一页</a>
<%  }                    if(pageNo>0){ %>
<a href="/user/usersq?pageNo=<%=pageNo-1%>&status=${status}">上一页</a>
<%  } %>
</div>
</body>
</html>