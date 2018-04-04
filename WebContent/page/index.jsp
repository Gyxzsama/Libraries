<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js">
<head>
<title>图书管理系统</title>
<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/i/favicon.png">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css">
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>
</head>

<body>
	<header class="am-topbar admin-header">
		<div class="am-topbar-brand">
			<img src="${pageContext.request.contextPath}/assets/i/logo.png">
		</div>
		<div class="am-collapse am-topbar-collapse" id="topbar-collapse">
			<ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">
				<li class="am-dropdown tognzhi" data-am-dropdown> 
					<button class="am-btn am-btn-primary am-dropdown-toggle am-btn-xs am-radius am-icon-bell-o" data-am-dropdown-toggle>
					 功能选择<span></span>
					</button>
					<ul class="am-dropdown-content">
						<li><a href="${pageContext.request.contextPath}/listBook.do?pageNo=1&pageSize=10">查看书籍信息</a></li>
						<li><a href="${pageContext.request.contextPath}/page/book_add.jsp">增加书籍信息</a></li>
						<li><a href="${pageContext.request.contextPath}/listReader.do?pageNo=1&pageSize=10">查看用户信息</a></li>
						<li><a href="${pageContext.request.contextPath}/page/reader_add.jsp">增加用户信息</a></li>
						<li><a href="${pageContext.request.contextPath}/page/book_borrow.jsp">借书操作</a></li>
					</ul>
					&nbsp;&nbsp;&nbsp;&nbsp;
				</li>
			</ul>
		</div>
	</header>

	<div class="am-cf admin-main">
		<div class="nav-navicon admin-main admin-sidebar">
			<div class="sideMenu am-icon-dashboard" style="color: #aeb2b7; margin: 10px 0 0 0;">欢迎系统管理员: ${username}</div>
			<div class="sideMenu">
				<h3 class="am-icon-flag"><em></em><a href="${pageContext.request.contextPath}/listInfo.do">&nbsp;图书管理</a></h3>
				<ul>
					<li><a href="${pageContext.request.contextPath}/listBook.do?pageNo=1&pageSize=10">查看书籍信息</a></li>
					<li><a href="${pageContext.request.contextPath}/page/book_add.jsp">增加书籍信息</a></li>
					<li><a href="${pageContext.request.contextPath}/page/book_borrow.jsp">借书操作</a></li>
					<li><a href="${pageContext.request.contextPath}/page/book_operate_1.jsp">还书操作</a></li>
				</ul>
				<h3 class="am-icon-users"><em></em>&nbsp;用户管理</h3>
				<ul>
					<li><a href="${pageContext.request.contextPath}/listReader.do?pageNo=1&pageSize=10">查看用户信息</a></li>
					<li><a href="${pageContext.request.contextPath}/page/reader_add.jsp">增加用户信息</a></li>
				</ul>
			</div>
			<!-- 左边列表效果主要代码 -->
			<script type="text/javascript">
						jQuery(".sideMenu").slide({
							titCell: "h3", //鼠标触发对象
							targetCell: "ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
							effect: "slideDown", //targetCell下拉效果
							delayTime: 300, //效果时间
							triggerTime: 150, //鼠标延迟触发时间（默认150）
							defaultPlay: true, //默认是否执行效果（默认true）
							returnDefault: false //鼠标从.sideMen移走后返回默认状态（默认false）
						});
			</script>
		</div>
		<!--主要功能代码---------------------------------------------------------------------------------------------- -->
		<!--主要功能代码---------------------------------------------------------------------------------------------- -->
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul class="am-icon-flag on" >首页</ul>
				<dl class="am-icon-home" style="float: right"> 当前位置： 首页 </dl>
			</div>
			<div class="admin-index">
				<dl data-am-scrollspy="{animation: 'slide-right', delay: 100}">
					<dt class="qs">
						<i class="am-icon-area-chart"></i>
					</dt>
					<dd>${msg1}</dd>
					<dd class="f12">书籍总类</dd>
				</dl>
				<dl data-am-scrollspy="{animation: 'slide-right', delay: 300}">
					<dt class="cs">
						<i class="am-icon-area-chart"></i>
					</dt>
					<dd>${msg2}</dd>
					<dd class="f12">书籍总数</dd>
				</dl>
				<dl data-am-scrollspy="{animation: 'slide-right', delay: 600}">
					<dt class="hs">
						<i class="am-icon-users"></i>
					</dt>
					<dd>${msg3}</dd>
					<dd class="f12">用户数量</dd>
				</dl>
				<dl data-am-scrollspy="{animation: 'slide-right', delay: 900}">
					<dt class="ls">
						<i class="am-icon-users"></i>
					</dt>
					<dd>${msg4}</dd>
					<dd class="f12">借书总数</dd>
				</dl>
			</div>
			<input type="hidden" name="pageNo" value="1" /> <input type="hidden" name="pageSize" value="10" />
			<div class="foods">
				<p>@2017. 14GB计算1</p>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
</body>

</html>