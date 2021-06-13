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
<div class="search">
 <form class="" action="${pageContext.request.contextPath}/admin/videobyid" method="post">
 
 <select name="status" style="margin-top: 15px;margin-left: 20px;margin-left:600px;">
 <option value="" ${status==""?'selected':''}>全部</option>
 <option value="1" ${status=="1"?'selected':''}>发布</option>
 <option value="2" ${status=="2"?'selected':''}>下架</option>
</select>
 <button class="btn btn-primary" style="float: right;margin-top: 15px;margin-right: 180px;margin-left: 20px" type="submit">搜索</button>
 <input type="text" id="vid" name="vid" onchange="check()" style="width:200px; float: right; margin-top: 15px;" placeholder="请输入视频ID">
</form>
</div>
<div class="middle table-responsive" style="width:90%;height: 400px; overflow:auto;">



<table class="table table-striped">
<tr>
<th>视频</th>
<th>视频编号</th>
<th>视频标题</th>
<th>视频地址</th>
<th>操作</th>
</tr>
<c:forEach items="${videolt}" var="v">
<tr>
<td style="width:80px"><img  src="${v.image}" width="50px" height="50px"/>     </td>
<td style="width:80px">${v.vid}</td>
<td style="width:100px">${v.vname}</td>
<td style="word-wrap:break-word;word-break:break-all;">${v.url}</td>
<td style="width:80px">
   <a href="/admin/delvideo?vid=${v.vid}&path=${v.url}">删除</a> &nbsp;&nbsp;
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

<script type="text/javascript">
function check(){
var vid=$('#vid').val();
if(isNaN(vid)){
	$('#vid').val("");
alert("输入的编号必须为数专字属 ");
  
return false;
}
}
</script>
</body>
</html>