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
<script type="text/javascript">
function tip(){
	alert("下架视频随时可能被删除,请勿随意下架 ");
}

</script>


</head>
<body>

<div class="search">
 <form class="" action="${pageContext.request.contextPath}/user/userOfviewlist" method="post">
 <button class="btn btn-primary" style="float: right;margin-top: 15px;margin-right: 180px;margin-left: 20px" type="submit">搜索</button>
 <input type="text" name="uname" style="width:200px; float: right; margin-top: 15px;" placeholder="请输入视频名称">
 <input type="hidden" name="status" value="1">
</form>
</div>

<br>
<div class="middle" style="width:90%;height: 300px; overflow:auto;">
<table class="table table-striped">
<tr>
<th>视频</th>
<th>视频编号</th>
<th>视频名称</th>
<th>上传时间</th>
<th>操作</th>
</tr>
<c:forEach items="${userifo}" var="v">
<tr>
<td><img  src="${v.image}" width="50px" height="50px"/> </td>
<td>${v.vid}</td>
<td>${v.vname}</td>
<td>${v.vdata}</td>
<td ><a href="/user/userdel?vid=${v.vid}"  onclick="tip()">下架</a></td>
</tr>
</c:forEach>
</table>
</div>
 <div class="page">
<% int pageNo=(int)request.getAttribute("pageNo");
   int totalPage=(int)request.getAttribute("totalPage");
   String status =(String)request.getAttribute("status");
%>
第<%=pageNo+1%>页     共<%=totalPage %>页                 
<%                    if(pageNo<totalPage-1){                  %>
<a href="/user/userOfviewlist?status=<%=status%>&pageNo=<%=pageNo+1%>&uname=${uname}">下一页</a>
<%  }                    if(pageNo>0){ %>
<a href="/user/userOfviewlist?status=<%=status%>&pageNo=<%=pageNo-1 %>&uname=${uname}">上一页</a>
<%  } %>
</div> 
${msg}
</body>
</html>