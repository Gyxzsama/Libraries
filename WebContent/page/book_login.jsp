<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>图书管理系统</title>
<link href="Wopop_files/style_log.css" rel="stylesheet" type="text/css" />
</head>

<body class="login">
	<div class="login_m">
	<br/><br/><p align="center" style="font-size:30px">管理员登录</p><br/><br/>
		<div class="login_boder">
			<div class="login_padding" id="login_model">
				<form method="post" action="login.do">
					<h2>用户名</h2>
					<!-- 此处的&#39表示单引号  需显示单引号(')，我们必须这样写：&apos; 或 &#39;-->
					<label> <input type="text" name="username" id="name"
						class="txt_input txt_input2"
						onfocus="if (value ==&#39;Your name&#39;){value =&#39;&#39;}"
						onblur="if (value ==&#39;&#39;){value=&#39;Your name&#39;}"
						value="Your name" />
					</label>
					<h2>密码</h2>
					<label> <input type="password" name="userpwd" id="pwd"
						class="txt_input"
						onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}"
						onblur="if (value ==&#39;&#39;){value=&#39;******&#39;}"
						value="******" />
					</label> 
					<br/><br/>
					<div class="rem_sub">
						<!-- 如果密码错误 msg为servlet返回的值 -->
						<label> <span style="color: #F00">${msg }</span>
						<input type="hidden" name="pageNo" value="1" /> <input type="hidden" name="pageSize" value="10" />
						<input type="submit" class="sub_button" name="button" id="button" value="登录" style="opacity: 0.7;" />
						</label>
					</div>
				</form>
			</div>
		</div>
	</div>
	<br/>
	<br/>
	<p align="center">湖北工业大学-14gb计算1-01410251Y15-高杨兴子</p>
</body>
</html>