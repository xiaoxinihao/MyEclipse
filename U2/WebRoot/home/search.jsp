<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="url" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript">
	context="${url}";
</script>

<!DOCTYPE>
<html >

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>搜索页面</title>

		<link href="${url}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="${url}/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />

		<link href="${url}/basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="${url}/css/seastyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="${url}/basic/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="${url}/js/script.js"></script>
	</head>

	<body>

		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
				<c:if test="${empty sessionScope.user}">
					<div class="menu-hd">
						<a href="#" target="_top" class="h">亲，请登录</a>
						<a href="#" target="_top">免费注册</a>
					</div>
				</c:if>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home">
					<div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
				</div>
				<div class="topMessage mini-cart">
					<c:if test="${empty sessionScope.ShoppingCart}">
						<div class="menu-hd"><a id="mc-menu-hd" href="${url }/home/shoppingcart.jsp" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
					</c:if>
					<c:if test="${!empty sessionScope.ShoppingCart}">
						<div class="menu-hd"><a id="mc-menu-hd" href="${url }/home/shoppingcart.jsp" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">${sessionScope.ShoppingCart.productNumber }</strong></a></div>
					</c:if>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
			</ul>
			</div>

			<!--悬浮搜索框-->

			<div class="nav white">
				<div class="logo"><img src="${url}/images/logo.png" /></div>
				<div class="logoBig">
					<li><img src="${url}/images/logobig.png" /></li>
				</div>

				<div class="search-bar pr">
					<a name="index_none_header_sysc" href="#"></a>
					<form action="${url}/ProductServlet?flag=search" method="post">
						<input id="searchInput" name="index_none_header_sysc" value="${requestScope.keyword==null?'':requestScope.keyword}" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn"  value="搜索" index="1" type="submit">
					</form>
				</div>
			</div>

			<div class="clear"></div>
			<b class="line"></b>
           <div class="search">
			<div class="search-list">
			<div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="#">首页</a></li>
                                <li class="qc"><a href="#">闪购</a></li>
                                <li class="qc"><a href="#">限时抢</a></li>
                                <li class="qc"><a href="#">团购</a></li>
                                <li class="qc last"><a href="#">大包装</a></li>
							</ul>
						    <div class="nav-extra">
						    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
						    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
						    </div>
						</div>
			</div>
			
				
					<div class="am-g am-g-fixed">
						<div class="am-u-sm-12 am-u-md-12">
	                  	<div class="theme-popover">													
								<div class="clear"></div>

								<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes" id="limit">
								
								  <c:forEach items="${requestScope.productList }" var="product">
									<li>
										<div class="i-pic limit">
											<a href="${url}/quesyProduct?id=${product.id}"><img src="${url}/images/imgsearch1.jpg" /></a>											
											<p class="title fl">${product.name }</p>
											<p class="price fl">
												<b>¥</b>
												<strong>${product.price }</strong>
											</p>
										</div>
									</li>
								</c:forEach>
								
								</ul>
							</div>

							<div class="clear"></div>
							
							<!--分页 -->
							<ul class="am-pagination am-pagination-right">
								<li><a  href="javascript:" id="one">首页</a></li>
								<li><a  href="javascript:" id="back">上一页</a></li>
								<li><a  href="javascript:" id="next">下一页</a></li>
								<li><a  href="javascript:" id="last">尾页</a></li>
							</ul>
						</div>
					</div>
					<div class="footer">
						<div class="footer-hd">
							<p>
								<a href="#">恒望科技</a>
								<b>|</b>
								<a href="#">商城首页</a>
								<b>|</b>
								<a href="#">支付宝</a>
								<b>|</b>
								<a href="#">物流</a>
							</p>
						</div>
						<div class="footer-bd">
							<p>
								<a href="#">关于恒望</a>
								<a href="#">合作伙伴</a>
								<a href="#">联系我们</a>
								<a href="#">网站地图</a>
								<em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
							</p>
						</div>
					</div>
				</div>

			</div>

		<!--引导 -->
		<div class="navCir">
			<li><a href="home2.html"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
			<li><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>	
			<li><a href="${url}/person/index.html"><i class="am-icon-user"></i>我的</a></li>					
		</div>
		<script>
			window.jQuery || document.write('<script src="basic/js/jquery-1.9.min.js"><\/script>');
		</script>
		<script type="text/javascript" src="${url}/basic/js/quick_links.js"></script>

		<div class="theme-popover-mask"></div>
   <script type="text/javascript">
      $(function(){
      
             //分页需要的四要素
             var  totalCount="";// 总记录数         
             var  pageSize="";//  页大小
             var  pageCount="";// 总页数
             var  pageIndex="";// 当前页
             
			var keyword=$("#searchInput").val();
			
        //用户第一次进入页面的时候  默认显示第一页的内容
        
       	pageInit(pageIndex); 
       function  pageInit(indexPage){ /* start  pageInit  */
            $("#one").show();
            $("#back").show();
            $("#next").show();
            $("#last").show();
        //请求后台 获取数据
         $.ajax({
           url:context+"/ProductServlet",
           type:"POST",
           dataType:"json",
           data:{"keyword":keyword,"pageIndex":indexPage},
           success:function(data){
              $("#limit").empty();
              $(data).each(function(){
                  if(this.util!=null){
                   pageIndex=  this.util.pageIndex;
                   pageSize=  this.util.pageSize;
                   pageCount=  this.util.pageCount;
                   totalCount=  this.util.totalCount;	
                  }
					$("#limit").append("<li>"
					+"<div class='i-pic limit'>"
					+"<a href="+context+"/quesyProduct?id="+this.id+"><img src='"+context+"/images/imgsearch1.jpg' ></a>"											
					+"<p class='title fl'>"+this.name+"</p>"
					+"<p class='price fl'>"
					+"<b>¥</b>"
					+"<strong>"+this.price+"</strong>"
					+"</p>"
					+"</div>"
					+"</li>");
              });
           }
         });
      } 
      
      /* 用户点击首页 */
      $("#one").click(function(){
         pageInit(1);
      });
      /* 用户点击尾页 */
      $("#last").click(function(){
         pageInit(pageCount);
      });
      
      /* 用户点击上一页 */
      $("#back").click(function(){
          if((pageIndex-1)>0){
             pageInit(--pageIndex);
          }else{
            $("#one").hide();
            $("#back").hide();    
          }
      });
      /* 用户点击下一页 */
      $("#next").click(function(){
          if((pageIndex+1)<=pageCount){
             pageInit(++pageIndex);
          }else{
            $("#last").hide();
            $("#next").hide();
          }
      });
    });
    </script>
	</body>

</html>