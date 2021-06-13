<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="/static/css/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">普通用户管理界面</div>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img"><%=request.getSession().getAttribute("name") %>
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">账号<%if(session.getAttribute("status").equals("1")){%>
        	        正常 <%} else { %> 异常
         <% } %></a></dd>
         <dd><a href="/user/recordvideo1?oper=1" target="right">我的收藏</a></dd>
         <dd><a href="/user/recordvideo1?oper=2" target="right">我的喜欢</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="/user/logout">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree" >
        <li class="layui-nav-item layui-nav-itemed" >
          <a class=""  href="javascript:;" target="right">用户信息展示</a>
          <dl class="layui-nav-child" >
            <dd><a href="/user/usernotice?pageNo=0" target="right">用户公告</a></dd>
            <dd><a href="/user/usersq?pageNo=0" target="right">用户申请</a></dd>
            <dd><a href="/user/usernumberrecord?pageNo=0" target="right">用户信息统计</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item layui-nav-itemed" >
          <a class=""  href="javascript:;" target="right">用户视频管理</a>
          <dl class="layui-nav-child" >
            <dd><a href="/user/videolist" target="right">用户视频浏览</a></dd>
            <dd><a href="/user/upload" target="right">本地视频上传</a></dd>
            <dd><a href="/user/onlineupload" target="right">在线网络上传</a></dd>
            <dd><a href="/user/userOfviewlist?status=1" target="right">上传视频下架</a></dd>
            <dd><a href="/user/userOfviewlist?status=2" target="right">视频上架</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="/user/uppasswd" target="right">修改密码</a></li>
        <li class="layui-nav-item"><a href="/user/logout" target="_parent">退出系统 </a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
     <iframe src="" id="right" name="right" width="100%" height="100%"></iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    ©  底部固定区域
  </div>
</div>

<script src="/static/css/layui/layui.all.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
});
</script>
</body>
</html>