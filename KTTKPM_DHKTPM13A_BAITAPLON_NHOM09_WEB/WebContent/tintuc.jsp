<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous"> -->
   <!--<link rel="stylesheet" type="text/css" href="../css/fontawesome-free-5.13.0-web/css/all.css">  --> 
    <link href="<c:url value="./css/fontawesome-free-5.13.0-web/css/all.css"/>" rel='stylesheet' type='text/css'/>
    <link href="<c:url value="./css/bootstrap.min.css"/>" rel='stylesheet' type='text/css'/>
    <link href="<c:url value="./css/bootstrap.css"/>" rel='stylesheet' type='text/css'/>
    <script src="<c:url value="./js/jquery-3.3.1.min.js" />"></script>
    <script src="<c:url value="./js/bootstrap.min.js" />"></script>
    <link href="<c:url value="./css/css.css"/>" rel='stylesheet' type='text/css'/>
    <title>Tin tức</title>
</head>

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
	                        <li><a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/dangki.jsp"><span>Đăng ký</span></a></li>
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
                        <a href="#" style="display: block;line-height: 100px;height: 100px;">
                            <img  src="./img/logo.png">
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
                                    <p style="color: #66a182;font-size: 16px;">Miễn phí vận chuyển</p>
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
                                    <p style="color: #66a182;font-size: 16px;">Đặt hàng nhanh</p>
                                    <span style="font-size: 14px;">Gọi ngay
                                        <strong>18006750</strong>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-2 col-lg-2 hidden-md hiden-sm hidden-xs" id="giohang">
                    <div class="cart visible-xl visible-lg hidden-md hidden-sm hidden-xs">
                        <a href="#" id="icon-cart">
                            <img src="./img/icon-cart.png" style="padding-top: 12px;">
                        </a>
                        <div class="text-giohang">
                            <a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ChiTietDonHang.jsp" style="font-size: 16px;color: #66a182;">Giỏ hàng</a>
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
                                                <form action="TimKiem" method="POST" class="input-group search-bar" role= "search">
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
                   
					 <div class="blog_wrapper" itemscope="" itemtype="https://schema.org/Blog">
						<meta itemprop="name" content="Tin tức">
						
						<div class="clearfix"></div>
						<div class="container">
							<div class="row">
								
								<div class="blog_left_base col-xl-3 col-lg-3 col-md-12 col-sm-12 col-xs-12 order-xs-last order-sm-last order-md-last">
									
						<aside class="aside-item sidebar-category collection-category margin-bottom-20">
							<div class="aside-title">
							<h2 class="title-head margin-top-0 cate"><i class="fas fa-bars"></i><span>Danh mục tin tức</span></h2>
						</div>
						<div class="aside-content">
							<nav class="nav-category navbar-toggleable-md">
								<ul class="nav navbar-pills">
									
									
									<li class="nav-item iconh"><a class="nav-link a1" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListSanPham">Trang chủ
										</a>
					
									</li>
									
									
									
									<li class="nav-item iconh"><a class="nav-link a1" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/gioithieu.jsp">Giới thiệu
										</a>
					
									</li>
							
									<li class="nav-item iconh"><a class="nav-link a1" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/tintuc.jsp">Tin tức
										</a>
					
									</li>
									
									
									
									<li class="nav-item iconh"><a class="nav-link a1" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/lienhe.jsp">Liên hệ
										</a>
					
									</li>
									
									
								</ul>
							</nav>
						</div>
					</aside>
					
					<!-- TIN TỨC LIÊN QUAN -->
					<div class="sidebar-right clearfix f-left w-100 margin-top-10">
						
						
						
						<div class="section_title_base">
							<h2 class="title_modules">
								<a href="#" title="Tin tức liên quan">Tin tức liên quan</a>
							</h2>
						</div>
						<div class="blog_content slick_blog slick_margin slick-initialized slick-slider"><button type="button" data-role="none" class="slick-prev slick-arrow slick-disabled" aria-label="Previous" role="button" aria-disabled="true" style="display: block;">Previous</button><div aria-live="polite" class="slick-list draggable"><div class="slick-track" style="opacity: 1; width: 524px; transform: translate3d(0px, 0px, 0px);" role="listbox"><div class="slick-slide slick-current slick-active" data-slick-index="0" aria-hidden="false" style="width: 262px;" tabindex="-1" role="option" aria-describedby="slick-slide00"><div><div class="single-recent-post" style="width: 100%; display: inline-block;">
								<div class="post-thumb">
									
									<a class="image-blog" href="/khi-thoi-trang-la-tham-hoa-thi-se-nhu-the-nao"	 title="Khi thời trang là thảm họa thì sẽ như thế nào ?" tabindex="0">
										<img class="lazyload loaded" src="./img/1.jpg" data-src="//bizweb.dktcdn.net/thumb/small/100/091/100/articles/thoi-trang-tham-hoa.jpg?v=1467428209137" alt="Khi thời trang là thảm họa thì sẽ như thế nào ?" data-was-processed="true">
									</a>
									
								</div>
								<div class="post-info">
									<h3><a title="Khi thời trang là thảm họa thì sẽ như thế nào ?" href="#" tabindex="0">Khi thời trang là thảm họa thì sẽ như thế nào ?</a></h3>
									<div class="post-date">31/05/2016</div>
								</div>
							</div></div><div><div class="single-recent-post" style="width: 100%; display: inline-block;">
								<div class="post-thumb">
									
									<a class="image-blog" href="/trao-luu-chup-anh-song-giay-thinh-hang-tai-chau-au" title="Tại sao càng trưởng thành, bạn bè lại càng xa nhau?" tabindex="0">
										<img class="lazyload loaded" src="./img/a11.jpg" alt="Tại sao càng trưởng thành, bạn bè lại càng xa nhau?" data-was-processed="true">
									</a>
									
								</div>
								<div class="post-info">
									<h3><a title="Tại sao càng trưởng thành, bạn bè lại càng xa nhau?" href="/trao-luu-chup-anh-song-giay-thinh-hang-tai-chau-au" tabindex="0">Tại sao càng trưởng thành, bạn bè lại càng xa nhau?</a></h3>
									<div class="post-date">31/05/2016</div>
								</div>
							</div></div><div><div class="single-recent-post" style="width: 100%; display: inline-block;">
								<div class="post-thumb">
									
									<a class="image-blog" href="/dan-sieu-mau-trinh-dien-thoi-trang-mua-thu-tai-london" title="Dàn siêu mẫu trình diễn thời trang mùa thu tại London" tabindex="0">
										<img class="lazyload loaded" src="./img/a21.jpg" alt="Dàn siêu mẫu trình diễn thời trang mùa thu tại London" data-was-processed="true">
									</a>
									
								</div>
								<div class="post-info">
									<h3><a title="Dàn siêu mẫu trình diễn thời trang mùa thu tại London" href="#" tabindex="0">Dàn siêu mẫu trình diễn thời trang mùa thu tại London</a></h3>
									<div class="post-date">31/05/2016</div>
								</div>
							</div></div><div><div class="single-recent-post" style="width: 100%; display: inline-block;">
								<div class="post-thumb">
									
									<a class="image-blog" href="#" title="Nghệ thuật phối màu vintage trong thời trang cổ điển" tabindex="0">
										<img class="lazyload loaded" src="./img/a31.jpg" alt="Nghệ thuật phối màu vintage trong thời trang cổ điển" data-was-processed="true">
									</a>
									
								</div>
								<div class="post-info">
									<h3><a title="Nghệ thuật phối màu vintage trong thời trang cổ điển" href="#" tabindex="0">Nghệ thuật phối màu vintage trong thời trang cổ điển</a></h3>
									<div class="post-date">31/05/2016</div>
								</div>
							</div></div></div><div class="slick-slide" data-slick-index="1" aria-hidden="true" style="width: 262px;" tabindex="-1" role="option" aria-describedby="slick-slide01"><div><div class="single-recent-post" style="width: 100%; display: inline-block;">
								<div class="post-thumb">
									
									<a class="image-blog" href="/zara-ra-mat-mau-giay-classic-moi-canh-tranh-voi-nike" title="Zara ra mắt mẫu giày classic mới cạnh tranh với Nike" tabindex="-1">
										<img class="lazyload" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC" data-src="//bizweb.dktcdn.net/thumb/small/100/091/100/articles/img-3.jpg?v=1467428304777" alt="Zara ra mắt mẫu giày classic mới cạnh tranh với Nike">
									</a>
									
								</div>
								<div class="post-info">
									<h3><a title="Zara ra mắt mẫu giày classic mới cạnh tranh với Nike" href="#" tabindex="-1">Zara ra mắt mẫu giày classic mới cạnh tranh với Nike</a></h3>
									<div class="post-date">31/05/2016</div>
								</div>
							</div></div><div></div><div></div><div></div></div></div></div><button type="button" data-role="none" class="slick-next slick-arrow" aria-label="Next" role="button" style="display: block;" aria-disabled="false">Next</button></div>
					</div>
								</div>
								<div class="right-content col-xl-9 col-lg-9 col-md-12 margin-top-0">
									<section class="bread-crumb">
						<span class="crumb-border"></span>
						<div class="container no-padding">
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<ul class="breadcrumb">					
										<li class="home">
											<a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListSanPham"><span>Trang chủ</span></a>						
											<span class="mr_lr">&nbsp;<i class="fas fa-chervon-right"></i>&nbsp;</span>
										</li>
										
										
										<li><strong><span>Tin tức</span></strong></li>
										
										
									</ul>
								</div>
							</div>
						</div>
					</section>
									<h1>Tin tức</h1>
									<div class="clearfix"></div>
									
									<div class="content_blog_new list-blogs blog-main">
										<div class="row row_blog_responsive">
											
											<div class="col-xl-6 col-lg-6">
						<div class="blog-item blog_page">
							<div class="blog-item-thumbnail">
								
								<a class="image-blog" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListSanPham" title="Khi thời trang là thảm họa thì sẽ như thế nào ?">
									<img class="lazyload loaded" src="//bizweb.dktcdn.net/thumb/large/100/091/100/articles/thoi-trang-tham-hoa.jpg?v=1467428209137" data-src="//bizweb.dktcdn.net/thumb/large/100/091/100/articles/thoi-trang-tham-hoa.jpg?v=1467428209137" alt="Khi thời trang là thảm họa thì sẽ như thế nào ?" data-was-processed="true">
								</a>
								
							</div>
							<h3 class="blog-item-name"><a href="#" title="Khi thời trang là thảm họa thì sẽ như thế nào ?">Khi thời trang là thảm họa thì sẽ như thế nào ?</a></h3>
							<div class="postby">
								<div class="user"><i class="fas fa-user"></i> Nguyễn Hữu Nhật </div>
								<div class="clock"><i class="far fa-clock"></i> 20/06/2020</div>
							</div>
							<p class="blog-item-summary"> Trong các tuần lễ thời trang, ngoài thời trang của các sao là vấn đề gây chú ý thì thời trang của các fashionista cũng là một chủ đề...</p>
							
							<a href="/khi-thoi-trang-la-tham-hoa-thi-se-nhu-the-nao" class="btn btn-style btn-readmore" title="Đọc tiếp">Đọc tiếp</a>
							
						</div>
					</div>
											
											<div class="col-xl-6 col-lg-6">
						<div class="blog-item blog_page">
							<div class="blog-item-thumbnail">
								
								<a class="image-blog" href="#" title="Tại sao càng trưởng thành, bạn bè lại càng xa nhau?">
									<img class="lazyload loaded" src="//bizweb.dktcdn.net/thumb/large/100/091/100/articles/img-5.jpg?v=1467428257180" data-src="//bizweb.dktcdn.net/thumb/large/100/091/100/articles/img-5.jpg?v=1467428257180" alt="Tại sao càng trưởng thành, bạn bè lại càng xa nhau?" data-was-processed="true">
								</a>
								
							</div>
							<h3 class="blog-item-name"><a href="#" title="Tại sao càng trưởng thành, bạn bè lại càng xa nhau?">Tại sao càng trưởng thành, bạn bè lại càng xa nhau?</a></h3>
							<div class="postby">
								<div class="user"><i class="fas fa-user"></i> Nguyễn Ngọc Dũng </div>
								<div class="clock"><i class="far fa-clock"></i> 31/05/2016</div>
							</div>
							<p class="blog-item-summary"> Bước ra khỏi ghế nhà trường, chúng ta sẽ thay đổi để hòa nhập với môi trường sống lẫn công việc mới. Song đến lúc bạn gặp lại đối...</p>
							
							<a href="#" class="btn btn-style btn-readmore" title="Đọc tiếp">Đọc tiếp</a>
							
						</div>
					</div>
											
											<div class="col-xl-6 col-lg-6">
						<div class="blog-item blog_page">
							<div class="blog-item-thumbnail">
								
								<a class="image-blog" href="#" title="Dàn siêu mẫu trình diễn thời trang mùa thu tại London">
									<img class="lazyload loaded" src="//bizweb.dktcdn.net/thumb/large/100/091/100/articles/img-1.jpg?v=1467428275097" data-src="//bizweb.dktcdn.net/thumb/large/100/091/100/articles/img-1.jpg?v=1467428275097" alt="Dàn siêu mẫu trình diễn thời trang mùa thu tại London" data-was-processed="true">
								</a>
								
							</div>
							<h3 class="blog-item-name"><a href="#" title="Dàn siêu mẫu trình diễn thời trang mùa thu tại London">Dàn siêu mẫu trình diễn thời trang mùa thu tại London</a></h3>
							<div class="postby">
								<div class="user"><i class="fas fa-user"></i> Nguyễn Hữu Nhật </div>
								<div class="clock"><i class="far fa-clock"></i> 20/06/2020</div>
							</div>
							<p class="blog-item-summary"> Trong các Tuần lễ thời trang, Alexander McQueen luôn là một trong những tên tuổi được mong đợi nhiều nhất. Đặc biệt trong năm nay, giám đốc sáng tạo...</p>
							
							<a href="#" class="btn btn-style btn-readmore" title="Đọc tiếp">Đọc tiếp</a>
							
						</div>
					</div>
											
											<div class="col-xl-6 col-lg-6">
						<div class="blog-item blog_page">
							<div class="blog-item-thumbnail">
								
								<a class="image-blog" href="#" title="Nghệ thuật phối màu vintage trong thời trang cổ điển">
									<img class="lazyload loaded" src="//bizweb.dktcdn.net/thumb/large/100/091/100/articles/img-2.jpg?v=1467428290187" data-src="//bizweb.dktcdn.net/thumb/large/100/091/100/articles/img-2.jpg?v=1467428290187" alt="Nghệ thuật phối màu vintage trong thời trang cổ điển" data-was-processed="true">
								</a>
								
							</div>
							<h3 class="blog-item-name"><a href="http://dec.edu.vn/96/Tim-hieu-phong-cach-thoi-trang-co-dien-(classic)-DEC-TEAM" title="Nghệ thuật phối màu vintage trong thời trang cổ điển">Nghệ thuật phối màu vintage trong thời trang cổ điển</a></h3>
							<div class="postby">
								<div class="user"><i class="fas fa-user"></i> Nguyễn Hữu Nhật </div>
								<div class="clock"><i class="far fa-clock"></i> 20/6/2020</div>
							</div>
							<p class="blog-item-summary"> Bạn thích những bộ váy giống như mẹ hay mặc ngày xưa? Cách phối đồ phong cách vintage chính là gợi ý cho bạn trở thành một phiên bản...</p>
							
							<a href="/nghe-thuat-phoi-mau-vintage-trong-thoi-trang-co-dien" class="btn btn-style btn-readmore" title="Đọc tiếp">Đọc tiếp</a>
							
						</div>
					</div>
											
							
											
										</div>
										<div class="col-xs-12 text-right">
											
										</div>
											
									</div>
									
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
								<a href="#" class="logo-wrapper">					
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
									<a class="nav-link" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListSanPham">Trang chủ</a>
								</li>
								
								<li class="nav-item">
									<a class="nav-link" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/gioithieu.jsp">Giới thiệu</a>
								</li>
								
								<li class="nav-item">
									<a class="nav-link" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListSanPham">Sản phẩm</a>
								</li>
								
								<li class="nav-item">
									<a class="nav-link" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/tintuc.jsp">Tin tức</a>
								</li>
								
								<li class="nav-item">
									<a class="nav-link" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/lienhe.jsp">Liên hệ</a>
								</li>
								
							</ul>
						</div>
					</div>
				</div>
				
				<a href="#" class="backtop show" title="Lên đầu trang"><i class="fa fa-angle-up" aria-hidden="true"></i></a>
				
			</div>
		</div>
	<link rel="stylesheet" href="//bizweb.dktcdn.net/100/091/100/themes/756257/assets/responsive.scss.css?1587091907685" type="text/css"></footer>
</div>
		
					</div>
					
					
					
					
					
					
			
					<div class="ab-module-article-mostview">
					
					</div>
					                        
                        
                
                        
                        
                        
                     </div>
                     </div>
                    </div>
                   </div>
                   
                   
                   
                      </div>
                        
                        
                        
                        </body>
                        
                        
                        
                        