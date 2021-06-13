<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="/static1/css/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">短视频后台管理系统</div>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img"><%=request.getSession().getAttribute("name") %>
        </a>
        <dl class="layui-nav-child">
          <dd><a href="/admin/logout">账号退出</a></dd>
          <dd><a href="http://localhost:8080/user/adlogon">普通用户登录</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">首页</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree" >
      <li class="layui-nav-item"><a href="/admin/adlists" target="right">管理员用户</a></li>
        <li class="layui-nav-item layui-nav-itemed" >
          <a class=""  href="javascript:;" target="right">普通用户管理</a>
          <dl class="layui-nav-child" >
            <dd><a href="/admin/usersearch" target="right">用户信息管理</a></dd>
            <dd><a href="/admin/userAndviewlist" target="right">用户上传信息</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="/admin/videobyid" target="right">用户视频管理</a></li>
        <li class="layui-nav-item"><a href="/admin/searchnotice?manage=admin" target="right">公告信息</a></li>
        <li class="layui-nav-item"><a href="/admin/searchnotice?manage=user" target="right">举报信息</a></li>
        <li class="layui-nav-item"><a href="/admin/uppasswd" target="right">修改密码</a></li>
        <li class="layui-nav-item"><a href="/admin/logout"  target="_parent">退出系统 </a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
     <iframe src="/admin/test1" id="right" name="right" width="100%" height="100%"></iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    ©  底部固定区域
  </div>
</div>

<script src="/static1/css/layui/layui.all.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
});
</script>
</body>
</html>