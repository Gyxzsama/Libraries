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
				<ul class="am-icon-flag on">还书操作</ul> &nbsp;&nbsp;<ul style="color: #F00" class="am" > ${msg} </ul>
				<dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">还书操作</a> </dl>
			</div>
			<form  method="post" action="${pageContext.request.contextPath}/BackBook.do" class="am-g">
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
					<thead>
						<tr class="am-success">
							<th class="table-title">书籍</th>
							
							<th class="table-title">用户</th>
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<td>
								<div class="am-form-group am-cf">
									编号：${ob.id}
								</div>
								<div class="am-form-group am-cf">
									书名：${ob.bookname}
								</div>
								<div class="am-form-group am-cf">
									作者：${ob.author}
								</div>
								<div class="am-form-group am-cf">
									出版社：${ob.publisher }
								</div>
								<div class="am-form-group am-cf">
									价格：${ob.price}
								</div>
								<div class="am-form-group am-cf">
									库存总量：${ob.stock}
								</div>
								<div class="am-form-group am-cf">
									当前数量：${ob.current }
								</div>
							</td>
							
							<td>
								<div class="am-form-group am-cf">
									编号：${orr.id }
								</div>
								<div class="am-form-group am-cf">
									用户名：${orr.readerName}
								</div>
								<div class="am-form-group am-cf">
									借书数：${orr.borrowNum}
								</div>
								<br/>
								<br/>
								<br/>
								<br/>
								<br/>
								<button type="submit" class="am-btn am-btn-secondary am-radius" name="submit" value="3">归还</button>
								&nbsp;&nbsp;&nbsp;
								<input type="hidden" name="ob_id" value="${ob.id }">
								<input type="hidden" name="or_id" value="${orr.id }">
								<button type="submit" class="am-btn am-btn-secondary am-radius" name="submit" value="1">返回</button>
							</td>
						</tr>
					</tbody>
				</table>
				<hr/>
				<p></p>
			</form>

			<div class="foods">
				<p>@2017. 14GB计算1</p>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
</body>

</html>

