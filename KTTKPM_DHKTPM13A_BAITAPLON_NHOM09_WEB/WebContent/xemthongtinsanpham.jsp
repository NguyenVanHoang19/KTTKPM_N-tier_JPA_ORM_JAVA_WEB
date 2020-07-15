<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous"> -->
    <link rel="stylesheet" type="text/css"
	href="./css/fontawesome-free-5.13.0-web/css/all.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./css/css.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
    <script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>

    <title>Shop Đồ Nam Nữ</title>
</head>
<style>
    .breadcrumb-item+.breadcrumb-item::before {
        content: ">"
    }
    
    .breadcrumb {
        display: -ms-flexbox;
        display: flex;
        -ms-flex-wrap: wrap;
        flex-wrap: wrap;
        padding: .1rem 0rem !important;
        margin-bottom: 0rem;
        list-style: none;
        background-color: #ffffff;
        border-radius: .25rem
    }
    
    .single_product {
        padding-top: 66px;
        padding-bottom: 140px;
        background-color: #e5e5e5;
        margin-top: 0px;
        padding: 17px
    }
    
    .product_name {
        font-size: 20px;
        font-weight: 400;
        margin-top: 0px
    }
    
    .badge {
        display: inline-block;
        padding: 0.50em .4em;
        font-size: 75%;
        font-weight: 700;
        line-height: 1;
        text-align: center;
        white-space: nowrap;
        vertical-align: baseline;
        border-radius: .25rem
    }
    
    .product-rating {
        margin-top: 10px
    }
    
    .rating-review {
        color: #5b5b5b
    }
    
    .product_price {
        display: inline-block;
        font-size: 30px;
        font-weight: 500;
        margin-top: 9px;
        clear: left
    }
    
    .product_discount {
        display: inline-block;
        font-size: 17px;
        font-weight: 300;
        margin-top: 9px;
        clear: left;
        margin-left: 10px;
        color: red
    }
    
    .product_saved {
        display: inline-block;
        font-size: 15px;
        font-weight: 200;
        color: #999999;
        clear: left
    }
    
    .singleline {
        margin-top: 1rem;
        margin-bottom: .40rem;
        border: 0;
        border-top: 1px solid rgba(0, 0, 0, .1)
    }
    
    .product_info {
        color: #4d4d4d;
        display: inline-block
    }
    
    .product_options {
        margin-bottom: 10px
    }
    
    .product_description {
        padding-left: 0px
    }
    
    .product_quantity {
        width: 104px;
        height: 47px;
        border: solid 1px #e5e5e5;
        border-radius: 3px;
        overflow: hidden;
        padding-left: 8px;
        padding-top: -4px;
        padding-bottom: 44px;
        float: left;
        margin-right: 22px;
        margin-bottom: 11px
    }
    
    .order_info {
        margin-top: 18px
    }
    
    .shop-button {
        height: 47px
    }
    
    .product_fav i {
        line-height: 44px;
        color: #cccccc
    }
    
    .product_fav {
        display: inline-block;
        width: 52px;
        height: 46px;
        background: #FFFFFF;
        box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.1);
        border-radius: 11%;
        text-align: center;
        cursor: pointer;
        margin-left: 3px;
        -webkit-transition: all 200ms ease;
        -moz-transition: all 200ms ease;
        -ms-transition: all 200ms ease;
        -o-transition: all 200ms ease;
        transition: all 200ms ease
    }
    
    .br-dashed {
        border-radius: 5px;
        border: 1px dashed #dddddd;
        margin-top: 6px
    }
    
    .pr-info {
        margin-top: 2px;
        padding-left: 2px;
        margin-left: -14px;
        padding-left: 0px
    }
    
    .break-all {
        color: #5e5e5e
    }
    
    .image_selected {
        display: -webkit-box;
        display: -moz-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        width: calc(100% + 15px);
        height: 525px;
        -webkit-transform: translateX(-15px);
        -moz-transform: translateX(-15px);
        -ms-transform: translateX(-15px);
        -o-transform: translateX(-15px);
        transform: translateX(-15px);
        border: solid 1px #e8e8e8;
        box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.1);
        overflow: hidden;
        padding: 15px
    }
    
    .image_list li {
        display: -webkit-box;
        display: -moz-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 165px;
        border: solid 1px #e8e8e8;
        box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.1) !important;
        margin-bottom: 15px;
        cursor: pointer;
        padding: 15px;
        -webkit-transition: all 200ms ease;
        -moz-transition: all 200ms ease;
        -ms-transition: all 200ms ease;
        -o-transition: all 200ms ease;
        transition: all 200ms ease;
        overflow: hidden
    }
    
    @media (max-width: 390px) {
        .product_fav {
            display: none
        }
    }
    
    .bbb_combo {
        width: 100%;
        margin-right: 7%;
        padding-top: 21px;
        padding-left: 20px;
        padding-right: 20px;
        padding-bottom: 24px;
        border-radius: 5px;
        margin-top: 0px;
        text-align: -webkit-center
    }
    
    .bbb_combo_image {
        width: 170px;
        height: 170px;
        margin-bottom: 15px
    }
    
    .fs-10 {
        font-size: 10px
    }
    
    .step {
        background: #167af6;
        border-radius: 0.8em;
        -moz-border-radius: 0.8em;
        -webkit-border-radius: 6.8em;
        color: #ffffff;
        display: inline-block;
        font-weight: bold;
        line-height: 3.6em;
        margin-right: 5px;
        text-align: center;
        width: 3.6em;
        margin-top: 116px
    }
    
    .row-underline {
        content: "";
        display: block;
        border-bottom: 2px solid #3798db;
        margin: 0px 0px;
        margin-bottom: 20px;
        margin-top: 15px
    }
    
    .deal-text {
        margin-left: -10px;
        font-size: 25px;
        margin-bottom: 10px;
        color: #000;
        font-weight: 700
    }
    
    .padding-0 {
        padding-left: 0;
        padding-right: 0
    }
    
    .padding-2 {
        margin-right: 2px;
        margin-left: 2px
    }
    
    .vertical-line {
        display: inline-block;
        border-left: 3px solid #167af6;
        margin: 0 10px;
        height: 364px;
        margin-top: 4px
    }
    
    .p-rating {
        color: green
    }
    
    .combo-pricing-item {
        display: flex;
        flex-direction: column
    }
    
    .boxo-pricing-items {
        display: inline-flex
    }
    
    .combo-plus {
        margin-left: 10px;
        margin-right: 18px;
        margin-top: 10px
    }
    
    .add-both-cart-button {
        margin-left: 36px
    }
    
    .items_text {
        color: #b0b0b0
    }
    
    .combo_item_price {
        font-size: 18px
    }
    
    .p_specification {
        font-weight: 500;
        margin-left: 22px
    }
    
    .mt-10 {
        margin-top: 10px
    }
    
    @charset "utf-8";
    @import url('https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700,800,900|Rubik:300,400,500,700,900');
    * {
        margin: 0;
        padding: 0;
        -webkit-font-smoothing: antialiased;
        -webkit-text-shadow: rgba(0, 0, 0, .01) 0 0 1px;
        text-shadow: rgba(0, 0, 0, .01) 0 0 1px
    }
    
    body {
        font-family: 'Rubik', sans-serif;
        font-size: 14px;
        font-weight: 400;
        background: #FFFFFF;
        color: #000000
    }
    
    div {
        display: block;
        position: relative;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box
    }
    
    ul {
        list-style: none;
        margin-bottom: 0px
    }
    
    .single_product {
        padding-top: 16px;
        padding-bottom: 140px
    }
    
    .image_list li {
        display: -webkit-box;
        display: -moz-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 165px;
        border: solid 1px #e8e8e8;
        box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.1);
        margin-bottom: 15px;
        cursor: pointer;
        padding: 15px;
        -webkit-transition: all 200ms ease;
        -moz-transition: all 200ms ease;
        -ms-transition: all 200ms ease;
        -o-transition: all 200ms ease;
        transition: all 200ms ease;
        overflow: hidden
    }
    
    .image_list li:last-child {
        margin-bottom: 0
    }
    
    .image_list li:hover {
        box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.3)
    }
    
    .image_list li img {
        max-width: 100%
    }
    
    .image_selected {
        display: -webkit-box;
        display: -moz-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        width: calc(100% + 15px);
        height: 525px;
        -webkit-transform: translateX(-15px);
        -moz-transform: translateX(-15px);
        -ms-transform: translateX(-15px);
        -o-transform: translateX(-15px);
        transform: translateX(-15px);
        border: solid 1px #e8e8e8;
        box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.1);
        overflow: hidden;
        padding: 15px
    }
    
    .image_selected img {
        max-width: 100%
    }
    
    .product_category {
        font-size: 12px;
        color: rgba(0, 0, 0, 0.5)
    }
    
    .product_rating {
        margin-top: 7px
    }
    
    .product_rating i {
        margin-right: 4px
    }
    
    .product_rating i::before {
        font-size: 13px
    }
    
    .product_text {
        margin-top: 27px
    }
    
    .product_text p:last-child {
        margin-bottom: 0px
    }
    
    .order_info {
        margin-top: 16px
    }
    
    .product_quantity {
        width: 182px;
        height: 50px;
        border: solid 1px #e5e5e5;
        border-radius: 5px;
        overflow: hidden;
        padding-left: 25px;
        float: left;
        margin-right: 30px
    }
    
    .product_quantity span {
        display: block;
        height: 50px;
        font-size: 16px;
        font-weight: 300;
        line-height: 50px;
        float: left
    }
    
    .product_quantity input {
        display: block;
		width: 83px;
		height: 50px;
		border: none;
		outline: none;
		font-size: 23px;
		font-weight: 300;
		text-align: left;
		padding-left: 9px;
		line-height: 50px;
		float: left;
    }
    
    .quantity_buttons {
        position: absolute;
        top: 0;
        right: 0;
        height: 100%;
        width: 29px;
        border-left: solid 1px #e5e5e5
    }
    
    .quantity_inc,
    .quantity_dec {
        display: -webkit-box;
        display: -moz-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        flex-direction: column;
        align-items: center;
        width: 100%;
        height: 50%;
        cursor: pointer
    }
    
    .quantity_control i {
        font-size: 11px;
        color: rgba(0, 0, 0, 0.3);
        pointer-events: none
    }
    
    .quantity_control:active {
        border: solid 1px rgba(14, 140, 228, 0.2)
    }
    
    .quantity_inc {
        padding-bottom: 2px;
        justify-content: flex-end;
        border-top-right-radius: 5px
    }
    
    .quantity_dec {
        padding-top: 2px;
        justify-content: flex-start;
        border-bottom-right-radius: 5px
    }
</style>

<body>
    <input type="hidden" value="${tk.tenTaiKhoan }" name="tenTaiKhoan">
	<c:set var="tentk" value="${tk.tenTaiKhoan }" scope="session"></c:set>
    <div class="container-fluid">
        <div class="topheader">
            <div class="row">
                <div class="col-md-4" id="navbar-header">
                	<c:if test="${tentk==null}">
                		<ul>
	                        <li><a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/dangnhap.jsp"><span>Đăng nhập</span></a></li>
	                        <li><a href="#"><span>Đăng ký</span></a></li>
                    	</ul>
                	
                	</c:if>
                    <c:if test="${tentk!=null}">
                		<ul>
	                        <li><a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/dangnhap.jsp"><span>Xin Chào ${tk.tenTaiKhoan } </span></a></li>
	                        <li><a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/DangNhap?action=dangxuat"><span>Đăng Xuất</span></a></li>
                    	</ul>
                	</c:if>
                </div>
                <div class="col-md-8" id="navbar-header-right">
                    <ul>
                        <c:if test="${tentk!=null}">
                    		<li><a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ThongTinCaNhan?action=showForm&tenTaiKhoan=${tk.tenTaiKhoan }"><span>Xem thông tin cá nhân</span></a></li>
                    		<li><a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/dsDonHangKhachHang?action=showForm&tenTaiKhoan=${tk.tenTaiKhoan } "><span>Đơn hàng</span></a></li>
                    	</c:if>
                    </ul>
                </div>
            </div>
        </div>
		<div class="header_menu">
			<div class="row">
				<div class="col-xl-3 col-lg-2 col-md-12 col-sm-12 col-xs-12">
					<div class="logo">
						<a href="#"
							style="display: block; line-height: 100px; height: 100px;"> <img
							src="./img/logo.png">
						</a>
					</div>
				</div>
				<div class="col-xl-7 col-lg-8 col-md-12">
					<div class="header_service">
						<div class="row">
							<div class="col-lg-6">
								<div class="wrp">
									<div class="font-awesome">
										<i class="fas fa-truck" style="line-height: 53px;"></i>
									</div>
								</div>
								<div class="text" id="text-vanchuyen">
									<p style="color: #66a182; font-size: 16px;">Miễn phí vận
										chuyển</p>
									<span style="font-size: 14px;">Với đơn hàng trị giá trên
										<strong>1.000.000</strong>
									</span>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="wrp">
									<div class="font-awesome">
										<i class="fas fa-phone" style="line-height: 53px;"></i>
									</div>
								</div>
								<div class="text" id="text-vanchuyen">
									<p style="color: #66a182; font-size: 16px;">Đặt hàng nhanh</p>
									<span style="font-size: 14px;">Gọi ngay <strong>18006750</strong>
									</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-2 col-lg-2 hidden-md hiden-sm hidden-xs"
					id="giohang">
					<div
						class="cart visible-xl visible-lg hidden-md hidden-sm hidden-xs">
						<a href="#" id="icon-cart"> <img src="./img/icon-cart.png"
							style="padding-top: 12px;">
						</a>
						<div class="text-giohang">
							<a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ChiTietDonHang.jsp" style="font-size: 16px; color: #66a182;">Giỏ hàng</a>
							<p style="margin: 0 0 15px 0;">
								(<span style="color: red;">${cart.soLuongItiem() }</span>) Sản phẩm
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    <div class="header_nav_main section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <div class="heade_menunav">
                        <div class="wrap_main d-none d-lg-block d-xl-block">
                            <div class="bg-header-nav">
                                <div class="row">
                                    <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                                        <nav class="header-nav">
                                            <ul class="item_big">
                                                <li class="nav-item  active ">
                                                    <a class="a-img" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListSanPham" title="Trang chủ">
                                                        <span>Trang chủ</span> </a>
                                                </li>
                                                <li class="nav-item ">
                                                    <a class="a-img" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/gioithieu.jsp" title="Giới thiệu">
                                                        <span>Giới thiệu</span> </a>
                                                </li>
                                                <li class="nav-item ">
                                                    <a class="a-img" href="" title="Sản phẩm">
                                                        <span>Sản phẩm</span><i class="fa fa-angle-down"></i> </a>
                                                    <ul class="item_small">
                                                        <li>
                                                            <a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListMenuSanPham?action=aothun" title="Áo Thun">Áo Thun</a>

                                                        </li>
                                                        <li>
                                                            <a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListMenuSanPham?action=aophong" title="Áo phông">Áo phông</a>

                                                        </li>
                                                        <li>
                                                            <a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListMenuSanPham?action=aosomi" title="Áo sơ mi">Áo sơ mi</a>

                                                        </li>
                                                        <li>
                                                            <a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListMenuSanPham?action=aococtay" title="Áo cộc tay">Áo cộc tay</a>
                                                            <!-- <ul>
                                                                <li>
                                                                    <a href="/san-pham-noi-bat" title="Hàng mới về" class="a3">Hàng mới về</a>
                                                                </li>
                                                                <li>
                                                                    <a href="/san-pham-khuyen-mai" title="Hàng giảm giá" class="a3">Hàng giảm giá</a>
                                                                </li>
                                                            </ul> -->
                                                        </li>
                                                        <li>
                                                            <!-- <a href="/san-pham-moi" title="Sản phẩm mới">Sản phẩm mới<i class="fa fa-angle-right"></i></a>
                                                            <ul>
                                                                <li>
                                                                    <a href="/san-pham-moi" title="Hàng mới" class="a3">Hàng mới</a>
                                                                </li>
                                                                <li>
                                                                    <a href="/san-pham-khuyen-mai" title="Hàng giảm giá" class="a3">Hàng giảm giá</a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                        -->
                                                        <li>
                                                            <a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListMenuSanPham?action=quanjeannam" title="Quần Jean Nam">Quần Jean Nam</a>
                                                        </li>
                                                        <li>
                                                            <a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListSanPham" title="Tất cả sản phẩm">Tất cả sản phẩm</a>
                                                        </li>
                                                    </ul>
                                                    </li>
                                                    <li class="nav-item ">
                                                        <a class="a-img" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/tintuc.jsp" title="Tin tức">
                                                            <span>Tin tức</span> </a>
                                                    </li>
                                                    <li class="nav-item ">
                                                        <a class="a-img" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/lienhe.jsp" title="Liên hệ">
                                                            <span>Liên hệ</span> </a>
                                                    </li>
                                            </ul>
                                        </nav>
                                    </div>
                                    <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                                        <div class="serachpc">
                                            <div class="searchform">
                                                <form action="TimKiem" method="get" class="input-group search-bar" role="search">
                                                    <input type="text" name="timkiem" value="" autocomplete="off" placeholder="Tìm kiếm..." class="input-group-field auto-search visible_index">
                                                    <button type="submit" class="visible_index btn icon-fallback-text">
															<i class="fa fa-search" ></i>      
														</button>
                                                </form>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="menu-overlay" class=""></div>
                    <section class="bread-crumb">
                        <span class="crumb-border"></span>
                        <div class="container ">
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <ul class="breadcrumb">
                                        <li class="home">
                                            <a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListSanPham"><span >Trang chủ</span></a>
                                            <span class="mr_lr">&nbsp;<i class="fas fa-chervon-right"></i>&nbsp;</span>
                                        </li>

                                        <li><strong><span>Chi Tiết Sản Phẩm</span></strong></li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!---->
                        <div class="super_container">
                            
                            <div class="single_product">
                                <div class="container-fluid" style=" background-color: #fff; padding: 11px;">
                                    <div class="row">
                                        
                                        <div class="col-lg-4 order-lg-2 order-1">
                                            <div class="image_selected"><img src="${sp.urlHinh}" alt=""></div>
                                        </div>
                                        <div class="col-lg-6 order-3">
                                            <div class="product_description">
                                               
                                                <div class="product_name">${sp.moTa}</div>
                                                <div class="product-rating"><span class="badge badge-success"><i class="fa fa-star"></i> 4.5 Sao</span> <span class="rating-review"> ${soLuongDaBan} Đã Bán</span></div>
                                                <div><h4> Còn ${soLuongCon} Sản Phẩm </h4> 
                                                	<c:if test="${soLuongCon==0}">
														<span style="color: red;font-size: 30px;">Hết Hàng</span>
													</c:if>
													<br/>
                                                <span class="product_price">
                                                	<fmt:setLocale value="vi_VN"/>
													<fmt:formatNumber value="${sp.donGia}" type="currency"/>
                                                </span> </div>
                                        
                                                <hr class="singleline">
                                                <div> <span class="product_info">Miễn Phí Vận Chuyển Khi Giao Hàng</span><br> <span class="product_info">Có hàng trong khoảng từ 2-3 ngày</span> </div>
                                                <div>
                                                    <div class="row">
                                                        <div class="col-md-5">
                                                            <div class="br-dashed">
                                                                <div class="row">
                                                                    
                                                                    
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-7"> </div>
                            </div>
                            <div class="row" style="margin-top: 15px;">
                                <div class="col-xs-6" style="margin-left: 15px;"> <span class="product_options">Các Mẫu Size</span><br> <button class="btn btn-primary btn-sm">M</button> <button class="btn btn-primary btn-sm">L</button> <button class="btn btn-primary btn-sm">XL</button> </div>
                                
                            </div>
                        </div>
                        <hr class="singleline">
                        <div class="order_info d-flex flex-row">
                            
                        </div>
                        <form action="MuaHang" method="POST">
                        <div class="row">
                            <div class="col-xs-6" style="margin-left: 13px;">
                                <div class="product_quantity"> <span>Số lượng: </span> <input id="quantity_input" name="soLuong" type="number" pattern="[0-9]*" min="1" max="300" value="1">
                                </div>
                            </div>
                            <input type="hidden" name="maSanPham" value="${sp.maSanPham}">
	                        <input type="hidden" name="tenSanPham" value="${sp.tenSanPham}">
	                        <input type="hidden" name="urlHinh" value="${sp.urlHinh}">
	                        <input type="hidden" name="donGia" value="${sp.donGia}">
	                        <input type="hidden" name="action" value="add">
                            <div class="col-xs-6">
                            	<c:if test="${soLuongCon==0}">
										<input type="button" class="btn btn-danger shop-button" onclick="thongbao()" value="Thêm vào giỏ hàng">
								</c:if>
								<c:if test="${soLuongCon>0}">
										<input type="submit" class="btn btn-primary shop-button" value="Thêm vào giỏ hàng">
								</c:if>
                            	

                            </div>
                            
                            <script>
						        function thongbao(){
						            confirm("Sản phẩm tạm hết hàng!!!");
						        }
					    </script>
                        </div>
                        </form>
                </div>
            </div>
        </div>
        
    </div>
    </div>
    <!---->
    </div>
    </div>
    
    </div>
    <div class="section footer_wwap">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" media="all"><footer class="footer">
		<div class="site-footer">
			<div class="mid-footer section">
				<div class="container">
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="logo_footer">
								<a href="/" class="logo-wrapper">					
									<img src="//bizweb.dktcdn.net/100/091/100/themes/756257/assets/logo_footer.png?1587091907685" alt="logo ">					
								</a>
							</div>
							<div class="widget-ft first">
								<div class="time_work">
									<div class="itemfooter cont">
										<div class="r">
											<i class="fas fa-map-marker-alt"></i>
											<span>
												Số 12 Nguyễn Văn Bảo, Phường 4,
												Quận Gò Vấp, Thành phố Hồ Chí Minh
												</span>
										</div>
										<div class="r">
											<i class="fas fa-phone"></i>
											<a class="fone" href="tel: 0283.8940 390"> 0283.8940 390</a>
										</div>
										<div class="r">
											<i class="far fa-envelope"></i>
											<a href="mailto:support@sapo.vn"> dhcn@iuh.edu.vn</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
			</div>
		</div>
			<div class="bg-footer-bottom copyright clearfix">
				<div class="inner clearfix container">
					<div class="row tablet">
						<div id="copyright" class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-xs-12 a-left fot_copyright">
							<span class="wsp"><span class="mobile">© Bản quyền 2015 - Trường Đại học Công nghiệp TP. Hồ Chí Minh
							Mọi hành động sử dụng nội dung đăng tải trên Website iuh.edu.vn phải có sự đồng ý bằng văn bản của Trường Đại học Công nghiệp Tp. HCM.

							</span>
							
						</div>
						<div class="col-xl-6 col-lg-6 col-sm-6 col-xs-12">
							<ul class="nav nav-inline pull-lg-right">
								
								<li class="nav-item">
									<a class="nav-link" href="trangchuu">Trang chủ</a>
								</li>
								
								<li class="nav-item">
									<a class="nav-link" href="gioithieuu">Giới thiệu</a>
								</li>
								
								<li class="nav-item">
									<a class="nav-link" href="/">Sản phẩm</a>
								</li>
								
								<li class="nav-item">
									<a class="nav-link" href="tintucc">Tin tức</a>
								</li>
								
								<li class="nav-item">
									<a class="nav-link" href="lienhee">Liên hệ</a>
								</li>
								
							</ul>
						</div>
					</div>
				</div>
				
				<a href="#" class="backtop show" title="Lên đầu trang"><i class="fa fa-angle-up" aria-hidden="true"></i></a>
				
			</div>
		</div>
	<link rel="stylesheet" href="//bizweb.dktcdn.net/100/091/100/themes/756257/assets/responsive.scss.css?1587091907685" type="text/css"></footer>
</body>

</html>