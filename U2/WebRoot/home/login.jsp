
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<c:set var="url" value="${pageContext.request.contextPath}"></c:set> 
<!DOCTYPE HTML>
<html>
<head>
	<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
 	<link rel="stylesheet" href="${url}/AmazeUI-2.4.2/assets/css/amazeui.css"/>
    <link href="${url}/css/dlstyle.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        form label.error{
            position: absolute;
            top: 44px;
            font-size: 12px;
            line-height: 20px;
            height: 20px;
            text-indent: 60px;
            width: auto;
            color: red;
        }
        .user-name,.user-pass{
            height: 65px;
            vertical-align: top;
        }
    </style>
</head>

<body>
	<%
	    Cookie[] cookies = request.getCookies();
	    if(cookies!=null && cookies.length > 0){
         for (Cookie cookie : cookies) {
         	String cookieName = cookie.getName();
            //如果存在这个cookie进行页面跳转
             if(cookieName.equals("user")){
             		out.print(123456789);
                 if(session.getAttribute("user")!=null){
                    response.sendRedirect(request.getContextPath()+"/home/home.jsp");
                     break;
                 }            
             }
         }
      }
	%>
<div class="login-boxtitle">
    <a href="home.html"><img alt="logo" src="${url}/images/logobig.png"/></a>
</div>

<div class="login-banner">
    <div class="login-main">
        <div class="login-banner-bg"><span></span><img src="${url}/images/big.jpg"/></div>
        <div class="login-box">
            <h3 class="title">登录商城</h3>

            <div class="clear"></div>

            <div class="login-form">
                <form id="loginForm" action="${url}/LoginSelect" method="post">
                    <div class="user-name test">
                        <label for="user"><i class="am-icon-user"></i></label>
                        <input type="text" name="user" id="user" value=""  placeholder="邮箱/手机">
                    </div>
                    <div class="user-pass test">
                        <label for="password"><i class="am-icon-lock"></i></label>
                        <input type="password" name="password" id="password" value="" placeholder="请输入密码">
                    </div>
                   <!--   <div id="mpanel4" style="margin-top:20px;"></div>-->
                    <div class="login-links">
                        <label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>
                        <a href="#" class="am-fr">忘记密码</a>
                        <a href="register.jsp" class="zcnext am-fr am-btn-default reg">注册</a>
                        <br/>
                    </div>
                    <div class="am-cf">
                        <input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm">
                    </div>
                </form>
            </div>

            <div class="partner">
                <h3>合作账号</h3>

                <div class="am-btn-group">
                    <li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span></a></li>
                    <li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span> </a></li>
                    <li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span> </a></li>
                </div>
            </div>

        </div>
    </div>
</div>


<div class="footer ">
    <div class="footer-hd ">
        <p>
            <a href="# ">恒望科技</a>
            <b>|</b>
            <a href="# ">商城首页</a>
            <b>|</b>
            <a href="# ">支付宝</a>
            <b>|</b>
            <a href="# ">物流</a>
        </p>
    </div>
    <div class="footer-bd ">
        <p>
            <a href="# ">关于恒望</a>
            <a href="# ">合作伙伴</a>
            <a href="# ">联系我们</a>
            <a href="# ">网站地图</a>
            <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank"
                                                       title="模板之家">模板之家</a> - Collect from <a
                    href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
        </p>
    </div>
</div>
<script type="text/javascript" src="${url}/js/jquery.js"></script>
<script type="text/javascript" src="${url}/js/jquery.validate.js"></script>
<script type="text/javascript" >
    $(function(){
        $.validator.addMethod(
                "veriName",
                function(value,element,params){
                    var flag = params.test(value);
                    return flag;
                },
                '用户名为邮箱/手机/用户名'
        );
        $("#loginForm").validate({
            rules:{
                user:{
                    required:true,
                    veriName:/^\w+@[a-zA-Z]+.[a-zA-Z]+(.cn)?||1\d{10}||\w+$/
                },
                password:{required:true}
            },
            messages:{
                user:{required:"用户名不能为空"},
                password:{required:"密码不能为空"}
            },
            onfocusout:function(e){
                $(e).valid();
            }
        });
    })

</script>
</body>
</html>