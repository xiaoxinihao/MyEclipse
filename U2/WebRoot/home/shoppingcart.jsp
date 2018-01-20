<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="url" value="${pageContext.request.contextPath}"></c:set> 
<script type="text/javascript">
	context="${url}";
</script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<title>购物车页面</title>

		<link href="${url}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="${url}/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="${url}/css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="${url}/css/optstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="${url}/js/jquery.js"></script>

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
				<div class="topMessage mini-cart" id="shopping">
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
						<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
					</form>
				</div>
			</div>

			<div class="clear"></div>

			<!--购物车 -->
			<div class="concent">
				<div id="cartTable">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
								<div id="J_SelectAll1" class="select-all J_SelectAll">

								</div>
							</div>
							<div class="th th-item">
								<div class="td-inner">商品信息</div>
							</div>
							<div class="th th-price">
								<div class="td-inner">单价</div>
							</div>
							<div class="th th-amount">
								<div class="td-inner">数量</div>
							</div>
							<div class="th th-sum">
								<div class="td-inner">金额</div>
							</div>
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>

					<tr class="item-list">
						<div class="bundle  bundle-last ">
							<div class="clear"></div>
							<div class="bundle-main">
								<c:if test="${!empty sessionScope.ShoppingCart }">
									
							<c:forEach var="itme" items="${sessionScope.ShoppingCart.items }">
								<ul class="item-content clearfix">
									<li class="td td-chk">
										<div class="cart-checkbox ">
											<input class="check" id="J_CheckBox_170037950254" name="items[]" value="170037950254" type="checkbox">
											<label for="J_CheckBox_170037950254"></label>
										</div>
									</li>
									<li class="td td-item">
										<div class="item-pic">
											<a href="javascript:" class="J_MakePoint" data-point="tbcart.8.12">
												<img src="${url}/images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg"></a>
										</div>
										<div class="item-info">
											<div class="item-basic-info">
												<a href="javascript:" target="_blank" class="item-title J_MakePoint" data-point="tbcart.8.11">${itme.product.name }</a>
											</div>
										</div>
									</li>
									<li class="td td-info">
										<div class="item-props item-props-can">
										</div>
									</li>
									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content">
												<div class="price-line">
													<em class="J_Price price-now" tabindex="0">${itme.product.price }</em>
												</div>
											</div>
										</div>
									</li>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<div class="sl">
													<input class="min am-btn"  name="" type="button" value="-" />
													<input class="text_box"  name="${itme.product.id }" type="text" value="${itme.quantity }" style="width:30px;" />
													<input class="add am-btn" name="" type="button" value="+" />
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner">
											<em tabindex="0" class="J_ItemSum number" id="price">${itme.itemMoney }</em>
										</div>
									</li>
									<li class="td td-op">
										<div class="td-inner">
											<a title="移入收藏夹" class="btn-fav" href="#"> 移入收藏夹</a>
											<a href="${url}/ShoppingCartAjax?flag=delete&id=${itme.product.id }" data-point-url="" class="delete"> 删除</a>
										</div>
									</li>
								</ul>
						</c:forEach>
							</div>
						</div>
					</tr>
				</div>
				<div class="clear"></div>

				<div class="float-bar-wrapper">
					<div id="J_SelectAll2" class="select-all J_SelectAll">
						<div class="cart-checkbox">
							<input class="check-all check" id="J_SelectAllCbx2" name="select-all" value="true" type="checkbox">
							<label for="J_SelectAllCbx2"></label>
						</div>
						<span>全选</span>
					</div>
					<div class="operations">
						<a href="${url}/ShoppingCartAjax?flag=deleteAll" hidefocus="true" class="deleteAll">清空购物车</a>
						<a href="#" hidefocus="true" class="J_BatchFav">移入收藏夹</a>
					</div>
					<div class="float-bar-right">
						<div class="amount-sum">
							<span class="txt">已选商品</span>
							<em id="J_SelectedItemsCount">${sessionScope.ShoppingCart.productNumber }</em><span class="txt">件</span>
							<div class="arrow-box">
								<span class="selected-items-arrow"></span>
								<span class="arrow"></span>
							</div>
						</div>
						<div class="price-sum">
							<span class="txt">合计:</span>
							<strong class="price">¥<em id="J_Total">${sessionScope.ShoppingCart.totalMoney }</em></strong>
						</div>
						<div class="btn-area">
							<a href="pay.html" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
								<span>结&nbsp;算</span></a>
						</div>
						</div>
					</c:if>
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
		<!--引导 -->
		<div class="navCir">
			<li><a href="home2.html"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
			<li class="active"><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>	
			<li><a href="${url}/person/index.html"><i class="am-icon-user"></i>我的</a></li>					
		</div>
		
<script type="text/javascript">
	$(function(){
		//当用户点击加的时候 触发加一个
	 $(".add").click(function(){
    	var idVal = $(this).prev().attr('name');//获取id
		var quantutyVal = $(this).prev().val();//获取val值
		var quantuty  = parseInt(quantutyVal)+1; //获取的val 值加1
		var $product = $(this).parents("ul.item-content");
		revise(idVal,quantuty,$product);
		$product.find(".min ").removeAttr("disabled");	
      });     
      //当用户点击减的时候 触发减一个
     $(".min ").click(function(){
        var idVal = $(this).next().attr('name'); //获取id
		var quantutyVal =$(this).next().val();//获取val值
		var quantuty  = parseInt(quantutyVal)-1; //获取的val 值加1
		var $product = $(this).parents("ul.item-content");
		revise(idVal,quantuty,$product);
		if(quantuty==1){
			$product.find(".min ").attr({"disabled":"disabled"});
		}				
      });
	});
	
 	function revise(idVal,quantuty,$product){
			$.ajax({
				url:context+"/ShoppingCartAjax",
				type:"POST",
				dataType:"json",
          		data:{"flag":"changeNumb","id":idVal,"quantuty":quantuty},
          		success:function(data){
          			$product.find(".J_ItemSum").text(data.ItemMoney);
          			$("#J_MiniCartNum").text(data.ProductNumber);
          			$("#J_Total").text(data.TotalMoney);
          			$("#J_SelectedItemsCount").text(data.ProductNumber);
          		}
			});
		} 
 	</script>
	</body>

</html>