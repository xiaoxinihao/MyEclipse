<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="url" value="${pageContext.request.contextPath}"></c:set> 
<!DOCTYPE HTML>
<html>
  <head>
  <meta charset="UTF-8">
    <title>注册</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="stylesheet" href="${url}/AmazeUI-2.4.2/assets/css/amazeui.min.css"/>
    <link href="${url}/css/dlstyle.css" rel="stylesheet" type="text/css">
    
<style type="text/css">
	.am-icon-md:before{
		font-size: 170%;
		vertical-align: -1%;
	}
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
        form .login-links label.error{
            top:24px;
            text-indent: 48px;
        }
        form#register-phone .login-links label.error{
            top:24px;
            text-indent: 48px;
        }
        form#register-phone label.error{
            position: absolute;
            top: 36px;
            line-height: 20px;
            height: 20px;
            width: auto;
        }
        .user-name,.user-pass,.user-email,.user-phone{
            height: 65px;
            vertical-align: top;
        }
        #emailTest{
        position: absolute;
  			top: 44px;
  			font-size: 12px;
  			line-height: 20px;
  			height: 20px;
 			text-indent: 60px;
  			width: auto;
            color: red;
        }
        #phoneTest{
        position: absolute;
  			top: 44px;
  			font-size: 12px;
  			line-height: 20px;
  			height: 20px;
 			text-indent: 60px;
  			width: auto;
            color: red;
        }
    </style>
   
 <script src="${url}/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
 <script src="${url}/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
</head>

<body>

<div class="login-boxtitle">
    <a href="home/demo.html"><img alt="" src="${url}/images/logobig.png"/></a>
</div>

<div class="res-banner">
    <div class="res-main">
        <div class="login-banner-bg"><span></span><img src="${url}/images/big.jpg"/></div>
        <div class="login-box">

            <div class="am-tabs" id="doc-my-tabs">
                <ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
                    <li class="am-active"><a href="">邮箱注册</a></li>
                    <li><a href="">手机号注册</a></li>
                </ul>

                <div class="am-tabs-bd">
                    <div class="am-tab-panel am-active">
                        <form method="post" id="register-email" class="register" action="${url}/EmailSelect">

                            <div class="user-email test">
                                <label for="email"><i class="am-icon-envelope-o"></i></label>
                                <input type="email" name="email" id="email" placeholder="请输入邮箱账号">
                            </div>
                            <div class="user-pass test">
                                <label for="password"><i class="am-icon-lock"></i></label>
                                <input type="password" name="password" id="password-email" placeholder="设置密码">
                            </div>
                            <div class="user-pass test">
                                <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
                                <input type="password" name="passwordRepeat" id="passwordRepeat-email" placeholder="确认密码">
                            </div>
                            <div class="login-links">
                                <label for="reader-me">
                                    <input id="reader-me-email" name="readerMe" type="checkbox"> 点击表示您同意商城《服务协议》
                                </label>
                            </div>
                            <div class="am-cf">
                                <input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
                            </div>
                        </form>

                    </div>

                    <div class="am-tab-panel">
                        <form method="post" id="register-phone" class="register" action="${url}/PhoneSelect">
                        	<input type="hidden" id="code1" >
                            <div class="user-phone test">
                                <label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label>
                                <input type="tel" name="phone" id="phone" placeholder="请输入手机号">   
                            </div>
                            <div class="verification test">
                                <label for="code"><i class="am-icon-code-fork"></i></label>
                                <input type="tel" name="code" id="code" placeholder="请输入验证码">
                               	<!-- <input type="button" class="btn" id="dyMobileButton" value="获取"> -->
                                <a class="btn" href="javascript:void(0);" id="sendMobileCode" >
                                    <span id="dyMobileButton">获取</span></a>
                            </div>
                            <div class="user-pass test">
                                <label for="password"><i class="am-icon-lock"></i></label>
                                <input type="password" name="password" id="password" placeholder="设置密码">
                            </div>
                            <div class="user-pass test">
                                <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
                                <input type="password" name="passwordRepeat" id="passwordRepeat" placeholder="确认密码">
                            </div>
                            <div class="login-links">
                                <input id="reader-me" name="readerMe" type="checkbox">
                                <label for="reader-me">点击表示您同意商城《服务协议》</label>
                            </div>
                            <div class="am-cf">
                                <input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
                            </div>
                        </form>
                    </div>

                    <script>
                        $(function () {
                            $('#doc-my-tabs').tabs();
                        })
                    </script>

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
                <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
                    - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
            </p>
        </div>
    </div>
</div>
<script type="text/javascript" src="${url}/js/jquery.validate.js"></script>
<script type="text/javascript" >
    $(function(){
        var code;
        $.validator.addMethod(
                "veriName",
                function(value,element,params){
                    var flag = params.test(value);
                    return flag;
                },
                '请输入正确的格式'
        );
        $("#register-email").validate({
            rules:{
                email:{
                    required:true,
                    veriName:/^\w+@[a-zA-Z]+.[a-zA-Z]+(.cn)?$/,
                    remote:{		
               			url:"../UserNameVerifyEmailSelect",
                    	type:"post",
                    	dataType:"json",
                    	data:{
                    		email:function(){
                    		 return	$("#email").val();
                    	 }
                    	}
                      }
                    },
                password:{
                    required:true,
                    minlength:6,
                    maxlength:12,
                },
                passwordRepeat:{
                    required:true,
                    minlength:6,
                    maxlength:12,
                    equalTo:"#password-email"
                },
                readerMe:{
                    required:true
                }
            },
            messages:{
                email:{
                    required:"邮箱不能为空",
                    remote:"用户已存在"
                    
                },
                password:{
                    required:"密码不能为空",
                    minlength:"密码不能少于6位",
                    maxlength:"密码不能多于12位"
                },
                passwordRepeat:{
                    required:"确认密码不能为空",
                    minlength:"确认密码不能少于6位",
                    maxlength:"确认密码不能多于12位",
                    equalTo:"两次输入密码不一致"
                },
                readerMe:{
                    required:"您还没有同意协议"
                }
            },
            onfocusout:function(e){
                $(e).valid();
            }   
        });

        $("#register-phone").validate({
            rules:{
                phone:{
                    required:true,
                    veriName:/^1\d{10}$/,
                    remote:{		
               			url:"../UserNameVerifyPhoneSelect",
                    	type:"post",
                    	dataType:"json",
                    	data:{
                    		email:function(){
                    		 return	$("#phone").val();
                    	 }
                    	}
                      }
                },
                code:{
                    required:true,
                    veriCode:code,
                    equalTo:"#code1"
                },
                password:{
                    required:true,
                    minlength:6,
                    maxlength:12,
                },
                passwordRepeat:{
                    required:true,
                    minlength:6,
                    maxlength:12,
                    equalTo:"#password-email"
                },
                readerMe:{
                    required:true
                }
            },
            messages:{
                phone:{
                    required:"手机号不能为空",
                    remote:"用户已存在"
                },
                code:{
                    required:"验证码不能为空",
                    equalTo:"验证码输入错误"
                },
                password:{
                    required:"密码不能为空",
                    minlength:"密码不能少于6位",
                    maxlength:"密码不能多于12位"
                },
                passwordRepeat:{
                    required:"确认密码不能为空",
                    minlength:"确认密码不能少于6位",
                    maxlength:"确认密码不能多于12位",
                    equalTo:"两次输入密码不一致"
                },
                readerMe:{
                    required:"您还没有同意协议"
                }
            },
            onfocusout:function(e){
                $(e).valid();
            }
        });
    })
</script>
<script type="text/javascript">
		$("#dyMobileButton").click(function(){
		var num = $("#phone").val();
		num =$.trim(num);
		if(num != ""){
			 var url = "../VerifyMobilePhoneSelect";
			 var args={"phone":num,"time":new Date()};
	
			$.post(url,args,function(date){
				$("#code1").val(date);
				});
			}
		});
</script>
</body>
</html>