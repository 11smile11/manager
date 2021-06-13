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
	function openAddModal(obj) {
		
		var $td = $(obj).parents('tr').children('td');
		var culomn1 = $td.eq(0).text();
		var culomn2 = $td.eq(1).text();
		var culomn3 = $td.eq(2).text();
		var culomn4=$td.eq(3).text();
		if(culomn4.indexOf("正常")!=-1){
			culomn4=1;
		}else{
			culomn4=2;
		}
		$("#status").val(culomn4);
		$("#uname").val(culomn1);
		$("#date").text(culomn3);
		$("#passwd").text(culomn4);
		$("#uname1").text(culomn1);
	}

</script>
</head>
<body>
<div class="search">
 <form  action="${pageContext.request.contextPath}/admin/usersearch" method="post">
 
 <select name="status" class="selectpicker" style="margin-top: 15px;margin-left: 20px;margin-left:600px;">
 <option value="" ${status==""?'selected':''}>全部</option>
 <option value="1" ${status=="1"?'selected':''}>正常</option>
 <option value="2" ${status=="2"?'selected':''}>封禁</option>
</select>

 <button class="btn btn-primary" style="float: right;margin-top: 15px;margin-right: 180px;margin-left: 20px" type="submit">搜索</button>
 <input type="text" name="uname" style="width:200px; float: right; margin-top: 15px;" placeholder="请输入用户名称">
</form>
</div>


<div class="middle table-responsive"  style="width:90%;height: 250px; overflow:auto;">
<table class="table table-striped">
<tr>
<th>用户姓名</th>
<th>用户密码</th>
<th>注册时间</th>
<th>账号状态</th>
<th>操作</th>
</tr>
<c:forEach items="${userifo}" var="u">
<tr>
<td>${u.uname}</td>
<td>${u.passwd}</td>
<td>${u.date}</td>
<td>
<c:if test="${u.status==1}">正常</c:if>
<c:if test="${u.status==2}">封禁</c:if>
</td>
<td>
   <%-- <a href="/admin/update?uname=${u.uname}&date=${u.date}&status=${u.status}">编辑</a> &nbsp;&nbsp; --%>
   
   <a data-toggle="modal" data-target="#myModal" onclick="openAddModal(this)" >修改</a> &nbsp;&nbsp;
 </td>
</tr>
</c:forEach>
<tr>
</tr>
</table>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
<div class="modal-dialog" role="document">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<h4 class="modal-title" id="myModalLabel">权限管理</h4>
		</div>
		<div class="modal-body">
			<form id="updateform" class="form-horizontal"  action="${pageContext.request.contextPath}/admin/updateuser" method="post" >
 
			 <div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">用户名：</label>
				<div class="col-sm-6">
				<input type="hidden" id="uname" name="uname"  /><span id="uname1"></span>
				</div>
			 </div>
			<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">注册时间</label>
				<div class="col-sm-6">
					<span id="date"></span>
				</div>
			 </div>
			 <div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">状态代码</label>
				<div class="col-sm-6">
					<span id="passwd"></span>
				</div>
			 </div>
 
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">账号状态</label>
				<div class="col-sm-6">
					<select id="status" name="status" class="form-control">
     					 	<option value=1 ${u.status==1?'selected':''}>正常</option>
							<option value=2 ${u.status==2?'selected':''}>封禁</option>
    				</select>
				</div>
			 </div>
 
               <div class="modal-footer">
					<button type="reset" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary" >提交</button>
				</div>
 
					</form>
				</div>
				
			</div>
		</div>
	</div>


<div class="page">
<% int pageNo=(int)request.getAttribute("pageNo");
   int totalPage=(int)request.getAttribute("totalPage");
%>
第<%=pageNo+1%>页     共<%=totalPage %>页                 
<%                    if(pageNo<totalPage-1){                  %>
<a href="/admin/usersearch?pageNo=<%=pageNo+1%>&uname=${uname}&status=${status}">下一页</a>
<%  }                    if(pageNo>0){ %>
<a href="/admin/usersearch?pageNo=<%=pageNo-1 %>&uname=${uname}&status=${status}">上一页</a>
<%  } %>
</div>

</body>
</html>