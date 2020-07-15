<%@page import="entities.SanPham"%>
<%@page import="ejbs.SanPhamEJB_CRUDRemote"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="entities.DanhMuc"%>
<%@page import="java.util.List"%>
<%@page import="ejbs.DanhMucEJB_CRUDRemote"%>
<%@page import="javax.ejb.EJB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous"> -->
   <!--<link rel="stylesheet" type="text/css" href="../css/fontawesome-free-5.13.0-web/css/all.css">  --> 
    <link rel="stylesheet" type="text/css" href="./css/fontawesome-free-5.13.0-web/css/all.css">
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.css" />
    <script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="./js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/css.css">
    <title>Shop Đồ Nam Nữ</title>
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
                        <div class="section_sidebar_slider">
                            <div class="container">
                                <div class="row">
                                    <div class="dqdt-sidebar sidebar left-content col-lg-3 col-md-12 hidden-sm hidden-xs">
                                        <div class="wrap_background_aside asidecollection">

                                            <aside class="aside-item sidebar-category collection-category margin-bottom-20">
                                                <div class="aside-title">
                                                    <h2 class="title-head margin-top-0 cate"><i class="fas fa-bars"></i><span>Danh mục sản phẩm</span></h2>
                                                </div>
                                                <div class="aside-content">
                                                    <nav class="nav-category navbar-toggleable-md">
                                                        <ul class="nav navbar-pills">





                                                            <li class="nav-item ">
                                                                <a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListMenuSanPham?action=aothun" class="nav-link a1">Áo Thun</a>
                                                            </li>




                                                            <li class="nav-item ">
                                                                <a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListMenuSanPham?action=aophong" class="nav-link a1">Áo phông</a>

                                                            </li>




                                                            <li class="nav-item ">
                                                                <a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListMenuSanPham?action=aosomi" class="nav-link a1">Áo sơ mi</a>

                                                            </li>




                                                            <li class="nav-item ">
                                                                <a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListMenuSanPham?action=aococtay" class="nav-link a1">Áo cộc tay</a>
                                                            </li>




                                                            <li class="nav-item ">
                                                                <a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListMenuSanPham?action=quanjeannam" class="nav-link a1">Quần Jean Nam</a>

                                                            </li>




                                                            <li class="nav-item "><a class="nav-link" href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListSanPham">Tất cả sản phẩm</a></li>



                                                            <li class="nav-item ">
                                                                <a class="nav-link"></a>
                                                            </li>
                                                            <li class="nav-item ">
                                                                <a class="nav-link"></a>
                                                            </li>
                                                            <li class="nav-item ">
                                                                <a class="nav-link"></a>
                                                            </li>


                                                            <!--<li class=" fix-show nav-item "><a class="nav-link" href="/san-pham-khuyen-mai">Sản phẩm khuyến mãi</a></li>  -->
                                                        </ul>
                                                    </nav>
                                                </div>
                                            </aside>

                                        </div>
                                    </div>
                                    <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
                                        <div class="sectionslider">
                                            <div class="section home-slider">

                                                <div id="demo" class="carousel slide" data-ride="carousel">

                                                    <!-- Indicators -->
                                                    <ul class="carousel-indicators">
                                                        <li data-target="#demo" data-slide-to="0" class="active"></li>
                                                        <li data-target="#demo" data-slide-to="1"></li>
                                                        <li data-target="#demo" data-slide-to="2"></li>
                                                    </ul>

                                                    <!-- The slideshow -->
                                                    <div class="carousel-inner">
                                                        <div class="carousel-item active">
                                                            <img src="./img/slider_1.jpg" alt="Los Angeles" width="1100" height="600">
                                                        </div>
                                                        <div class="carousel-item">
                                                            <img src="./img/slider_2.jpg" alt="Chicago" width="1100" height="600">
                                                        </div>
                                                        <div class="./img/slider_1.jpg">
                                                            <img src="./img/slider_1.jpg" alt="New York" width="1100" height="600">
                                                        </div>
                                                    </div>

                                                    <!-- Left and right controls -->
                                                    <a class="carousel-control-prev" href="#demo" data-slide="prev">
                                                        <span class="carousel-control-prev-icon"></span>
                                                    </a>
                                                    <a class="carousel-control-next" href="#demo" data-slide="next">
                                                        <span class="carousel-control-next-icon"></span>
                                                    </a>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-12 col-lg-12">
                <div class="row">
                    
                    <c:forEach items="${listDanhMuc }" var="dm">
                    	<div class="title-modules">
                        	<h2 class="title_h2"><a href="#">${dm.tenDanhMuc }</a></h2>
                    	</div>
                    	<c:forEach items="${listSanPham}" var="sp">
                    		<c:if test="${dm.maDanhMuc == sp.danhMuc.maDanhMuc }">
                    			<div class="col-xl-4 clo-lg-4" style="text-align: center;">
			                        <form action="MuaHang" method="POST">
			                            <img src="${sp.urlHinh}" class="img-responsive" style="width: 100%">
			                            <p class="text-danger">
			                                ${sp.tenSanPham}
			                            </p>
			                            <p class="text-info">
			                               	${sp.donGia}
			                            </p>
			                            <p>
			                            	<input type="hidden" name="maSanPham" value="${sp.maSanPham}">
			                            	<input type="hidden" name="tenSanPham" value="${sp.tenSanPham}">
			                            	<input type="hidden" name="urlHinh" value="${sp.urlHinh}">
			                            	<input type="hidden" name="donGia" value="${sp.donGia}">
			                            	<input type="hidden" name="soLuong" value="1">
			                            	<input type="hidden" name="action" value="add"> 
			                            	<a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/MuaHang?action=xemthongtinsanpham&maSanPham=${sp.maSanPham}"><input type="button" class="btn btn-primary" value="Xem Nhanh" /></a>
			                                <input type="submit" class="btn btn-primary" value="Mua hàng" />
			                            </p>
			                        </form>
		                    	</div>
                    		</c:if>
						</c:forEach>
                    </c:forEach>
					<!--  -->
						<c:if test="${listDanhMuc == null }">
							<%!
								DanhMucEJB_CRUDRemote danhMucEJB_CRUDRemote;
								SanPhamEJB_CRUDRemote sanPhamEJB_CRUDRemote;
							%>
							<% 
								try{
									Context ctx = new InitialContext();
									danhMucEJB_CRUDRemote =(DanhMucEJB_CRUDRemote) ctx.lookup("DanhMucEJB_CRUDRemote");
									sanPhamEJB_CRUDRemote =(SanPhamEJB_CRUDRemote) ctx.lookup("SanPhamEJB_CRUDRemote");
									%>
									<!--  -->
									<% for(DanhMuc danhMuc : danhMucEJB_CRUDRemote.getAllDanhMuc()){ %>
										<div class="title-modules">
			                        		<h2 class="title_h2"><a href="#"><% out.println(danhMuc.getTenDanhMuc()); %></a></h2>
			                    		</div>
			                    		<% for(SanPham sanPham:sanPhamEJB_CRUDRemote.getAllSanPham()) {
			                    				if(danhMuc.getMaDanhMuc().toString().equals(sanPham.getDanhMuc().getMaDanhMuc().toString())){ %>
				                    					<div class="col-xl-4 clo-lg-4" style="text-align: center;">
				    			                        <form action="MuaHang" method="POST">
				    			                            <img src="<%out.println(sanPham.getUrlHinh()) ;%>" class="img-responsive" style="width: 100%">
				    			                            <p class="text-danger">
				    			                               <%out.println(sanPham.getTenSanPham()) ;%>
				    			                            </p>
				    			                            <p class="text-info">
				    			                               	<%out.println(sanPham.getDonGia()); %>
				    			                            </p>
				    			                            <p>
				    			                            	<input type="hidden" name="maSanPham" value="<%out.print(sanPham.getMaSanPham()) ;%>">
				    			                            	<input type="hidden" name="tenSanPham" value="<%out.println(sanPham.getTenSanPham()); %>">
				    			                            	<input type="hidden" name="urlHinh" value="<%out.println(sanPham.getUrlHinh());%>">
				    			                            	<input type="hidden" name="donGia" value="<%out.println(sanPham.getDonGia());%>">
				    			                            	<input type="hidden" name="soLuong" value="1">
				    			                            	<input type="hidden" name="action" value="add"> 
				    			                            	<a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/MuaHang?action=xemthongtinsanpham&maSanPham=<%out.println(sanPham.getMaSanPham());%>"><input type="button" class="btn btn-primary" value="Xem Nhanh" /></a>
				    			                                <input type="submit" class="btn btn-primary" value="Mua hàng" />
				    			                            </p>
				    			                        </form>
				    		                    	</div>
			                    		<%		}
			                    	
							 			} 
									}
								}
								catch(Exception e){
									e.printStackTrace();
								}
							%>
							
						</c:if>
					<!--  -->
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
</body>

</html>