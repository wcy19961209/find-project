<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
                $("#captchaImage").attr("src","${pageContext.request.contextPath}/cond/createCaptcha?flag="+Math.random());
			});
            $("#user").blur(userchecked);
            $("#pass").blur(passchecked);
            $("#enCode").blur(encodechecked);
            $("#submit").submit(submitchecked);
		});
			function userchecked(){
               var user=$("#user").val();
              if(user==""){
                  $("#un").html("<font color='red'>请您正确输入用户名</font>");
			  }else{
				  $("#un").html("<font color='green'>ok</font>");
			  }
			}
            function passchecked(){
                var pass=$("#pass").val();
                if(pass==""){
                    $("#ps").html("<font color='red'>请您正确输入密码</font>");
                }else{
                    $("#ps").html("<font color='green'>ok</font>");
                }
            }
            function encodechecked(){
                var enCode=$("#enCode").val();
                if(enCode==""){
                    $("#ec").html("<font color='red'>请您输入验证码</font>");
                }else{
                    $("#ec").html("<font color='green'>ok</font>");
                }
            }
           function submitchecked(){
               var username=$("#un").text();
               var password=$("#ps").text();
               var code=$("#ec").text();
               if(username=="ok"&&password=="ok"&&code=="ok"){
                   return true;
			   }else{
                   return false;
			   }
		   }
	</script>
</head>
<body>
	
		<div class="login">
			<form id="submit" action="${pageContext.request.contextPath}/text/findAll" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="${pageContext.request.contextPath}/img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text" id="user" name="username" class="text" value="" maxlength="20" data-options="required:true"/>
								<span id="un"></span>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" id="pass" name="password" class="text" value="" maxlength="20" autocomplete="off" data-options="required:true"/>
								<span id="ps"></span>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="5" autocomplete="off" data-options="required:true"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/cond/createCaptcha" title="点击更换验证码"/>
								<span id="ec"></span>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>