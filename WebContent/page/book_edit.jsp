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
				<ul class="am-icon-flag on">修改书籍信息</ul> &nbsp;&nbsp;
				<dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">修改书籍信息</a> </dl>
				<!--data-am-modal="{target: '#my-popup'}" 弹出层 ID  弹出层 190行 开始  271行结束-->
			</div>
			
			<script type="text/javascript">
				function checkForm()
				{
					var re =/^\d+(\.\d+)?$/;   //判断字符串是否为数字
					if(form1.bookName.value == ""){
						alert("书名不能为空");
						return false;
					}
					if(form1.author.value == ""){
						alert("作者不能为空");
						return false;
					}
					if(form1.publisher.value == ""){
						alert("出版社不能为空");
						return false;
					}
					if(form1.price.value == ""){
						alert("价格不能为空");
						return false;
					}else if (!re.test(form1.price.value)){
						alert("请输入正确价格");
						form1.price.focus();
						return false;
					}
					if(form1.stock.value == ""){
						alert("库存不能为空");
						return false;
					}else if(!re.test(form1.stock.value)){
						alert("请输入正确库存数量");
						form1.stock.focus();
						return false;
					}
					if(form1.current.value == ""){
						alert("当前数量不能为空");
						return false;
					}else if(!re.test(form1.current.value)){
						alert("请输入正确当前数量");
						form1.current.focus();
						return false;
					}
				}
				function back(){
					document.forms.form1.onsubmit="";
				}
			</script>
			<div class="fbneirong">
			<form name="form1" method="post"  action="${pageContext.request.contextPath}/SaveEditBook.do" class="am-form"  onsubmit="return checkForm()">
					<div class="am-form-group am-cf">

						<input type="hidden" name="id" value="${book.id}">
						
						<div class="zuo">书名：</div>
						<div class="you">
							<input type="text" class="am-input-sm" placeholder="请输入书名" name="bookName" value="${book.bookname}">
						</div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">作者：</div>
						<div class="you">
							<input type="text" class="am-input-sm" placeholder="请输入作者" name="author" value="${book.author}">
						</div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">出版社：</div>
						<div class="you">
							<input type="text" class="am-input-sm" placeholder="请输入出版社" name="publisher" value="${book.publisher}">
						</div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">价格：</div>
						<div class="you">
							<input type="text" class="am-input-sm" placeholder="请输入价格" name="price" value="${book.price}">
						</div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">库存总量：</div>
						<div class="you">
							<input type="text" class="am-input-sm" placeholder="请输入库存" name="stock" value="${book.stock}">
						</div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">当前数量：</div>
						<div class="you">
							<input type="text" class="am-input-sm" placeholder="请输入数量" name="current" value="${book.current}">
						</div> 
					</div>
					<div class="am-form-group am-cf">
						<div class="you" style="margin-left: 11%;">
							<input type="hidden" name="pageNo" 	 value="1" /> 
							<input type="hidden" name="pageSize" value="10" />
							<button  type="submit" class="am-btn am-btn-success am-radius" name="submit" value="1">提交修改</button>
							&nbsp;&nbsp;&nbsp;
							<button  type="submit" class="am-btn am-btn-secondary am-radius" name="submit" value="2" onclick="back()">返回列表</button>
							<label> <span style="color: #F00">${msg }</span> 
							</label>
						</div>
					</div>
				</form>
			</div>
			<form class="am-form am-g"></form>
			<div class="foods">
				<p>@2017. 14GB计算1</p>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/assets/js/amazeui.min.js">
	</script>
</body>
</html>

