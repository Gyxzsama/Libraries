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
				<ul class="am-icon-flag on" >查看书籍信息</ul> &nbsp;&nbsp;  <ul style="color: #F00" class="am" > ${msg} </ul>
				<dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">查看书籍信息</a> </dl>
			</div>
			<form  method="post" action="EditBook.do" class="am-form am-g">
				<table class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
					<thead>
						<tr class="am-success">
							<th class="table-id am-text-center">编号</th>
							<th class="table-title">书名</th>
							<th class="table-author am-hide-sm-only">作者</th>
							<th class="table-author am-hide-sm-only">出版社</th>
							<th class="table-author am-hide-sm-only">价格</th>
							<th class="table-author am-hide-sm-only">总数</th>
							<th class="table-author am-hide-sm-only">当前数量</th>
							<th class="table-author am-hide-sm-only">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pageBook.objects}" var="e">
							<tr>
								<td class="am-text-center">${e.id}</td>
								<td>${e.bookname}</td>
								<td>${e.author}</td>
								<td class="am-hide-sm-only">${e.publisher}</td>
								<td >${e.price}</td>
								<td >${e.stock}</td>
								<td >${e.current}</td>
								<td>
									<div class="am-btn-toolbar">
										<div class="am-btn-group am-btn-group-xs">
											<button type="submit" class="am-btn am-btn-default am-btn-xs am-text-secondary am-round"  title="修改" 
											name="submit" id="修改" value="1${e.id}" > 
											<span class="am-icon-pencil-square-o"></span>
											</button>
											<button type="submit" class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除" 
											name="submit" id="删除" value="2${e.id}">
											<span class="am-icon-trash-o"></span>
											</button>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="am-pagination am-fr">
					<li><a href="listBook.do?pageNo=1&pageSize=10">«</a></li>
					<li><a href="listBook.do?pageNo=${pageBook.prePage}&pageSize=10">上一页</a> </li>
					<li><a href="listBook.do?pageNo=${pageBook.nextPage}&pageSize=10">下一页</a></li>
					<li><a href="listBook.do?pageNo=${pageBook.lastPage}&pageSize=10">»</a> </li>
				</ul>
				<hr/>
				<p></p>
			</form>
			<div class="foods">
				<p>@2017. 14GB计算1</p>
			</div>
		</div>
	</div>
	<script src="assets/js/amazeui.min.js"></script>
</body>
</html>