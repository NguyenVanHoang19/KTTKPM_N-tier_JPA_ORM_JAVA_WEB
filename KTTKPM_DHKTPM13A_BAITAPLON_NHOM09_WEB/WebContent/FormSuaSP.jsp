<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous"> -->
<!--<link rel="stylesheet" type="text/css" href="../css/fontawesome-free-5.13.0-web/css/all.css">  -->
<link rel="stylesheet" type="text/css"
	href="./css/fontawesome-free-5.13.0-web/css/all.css">
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
							<li><a href="${pageContext.request.contextPath}/dangnhap.jsp"><span>Đăng
										nhập</span></a></li>
							<li><a href="#"><span>Đăng ký</span></a></li>
						</ul>

					</c:if>
					<c:if test="${tentk!=null}">
						<ul>
							<li><a href="${pageContext.request.contextPath}/dangnhap.jsp"><span>Xin
										Chào ${tk.tenTaiKhoan } </span></a></li>
							<li><a href="${pageContext.request.contextPath}/DangNhap?action=dangxuat"><span>Đăng
										Xuất</span></a></li>
						</ul>
					</c:if>
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
												<li class="nav-item  active "><a class="a-img"
													href="${pageContext.request.contextPath}/ListSanPham" title="Trang chủ">
														<span>Trang chủ</span>
												</a></li>
												<li class="nav-item  active "><a class="a-img"
													href="${pageContext.request.contextPath}/quanLySanPham?action=dsdonhang" title="Trang chủ">
														<span>Quản lý đơn hàng</span>
												</a></li>
												<li class="nav-item  active "><a class="a-img"
													href="${pageContext.request.contextPath}/quanLySanPham?action=listsp" title="Danh sách sản phẩm">
														<span>Quản lý sản phẩm</span>
														<ul class="item_small">
															<li><a href="${pageContext.request.contextPath}/quanLySanPham?action=formthem" title="Thêm sản phẩm">Thêm sản
																	phẩm</a></li>
															<li><a href="${pageContext.request.contextPath}/quanLySanPham?action=listsp" title="Danh sách sản phẩm">Danh sách
																	sản phẩm</a>
														</ul>
												</a></li>
											</ul>
										</nav>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container form-text">
		<div class="row">
			<div class="col-sm-12">
				<h1>Thêm Sản Phẩm</h1>
			</div>
			<div class="col-sm-12">
				<!-- Form Thêm sản phẩm -->
				<form action="${pageContext.request.contextPath}/quanLySanPham?action=suasp" method="post"  >
				<!-- Mã sản phẩm -->
					<div class="form-group">
						<label for="txtname">Mã sản phẩm</label> 
						<input class="form-control"  type="text" name="txtmasua" required="required" value="${spsua.maSanPham }" readonly>
					</div>
					
					<!-- Tên sản phẩm -->
					<div class="form-group">
						<label for="txtname">Tên sản phẩm</label> 
						<input class="form-control"  type="text" name="txttensua" required="required" value="${spsua.tenSanPham }">
					</div>
					
					<!-- Mô tả sản phẩm -->
					<div class="form-group">
						<label for="txtname">Mô tả sản phẩm</label> 
						<input class="form-control"  type="text" name="txtmotasua" required="required" value="${spsua.moTa }">
					</div>
					<!-- Đơn vị tính sản phẩm -->
					<div class="form-group">
						<label for="txtname">Đơn vị tính sản phẩm</label> 
						<input class="form-control"  type="text" name="txtdvtsua" required="required" value="${spsua.donViTinh }">
					</div>

					<!-- Số lượng sản phẩm -->
					<div class="form-group">
						<label for="txtquantity">Số lượng sản phẩm</label> 
						<input class="form-control" type="number"  name="txtslsua" required="required" value="${spsua.soLuongNhap }">
					</div>
					<!-- Giá sản phẩm -->
					<div class="form-group">
						<label for="txtprice">Giá sản phẩm</label> <input
							class="form-control" type="number"  name="txtgiasua"
							 required="required" value="${spsua.donGia }">
					</div>
					<!-- Ngày sản xuất sản phẩm -->
					<div class="form-group">
						<label for="txtngay">Ngay sản phẩm</label> <input
							class="form-control" type="date" name="txtngaysua"  required="required" value="${spsua.ngaySanXuat }">
					</div>

					<!-- Loại sản phẩm -->
					<div class="form-group">
						<label>Loại sản phẩm</label> <select class="form-control"
							name="txttenloaisua">
							<option > ${spsua.danhMuc.tenDanhMuc } </option>
							<c:forEach items="${listDMSua }" var="d">
								<option > ${d.tenDanhMuc }</option>
								
							</c:forEach>

						</select>
					</div>
						<div class="form-group">
						<label>Nhà sản xuất</label> <select class="form-control"
							name="txttennccsua">
							<option > ${spsua.nhaCungCap.tenNhaCungCap }</option>
							<c:forEach items="${listNCCSua }" var="ncc">
								<option > ${ncc.tenNhaCungCap }</option>
							</c:forEach>
						</select>
					</div>
					
<!--  						<div class="form-group">
						<label>Nhà sản xuất</label> <select class="form-control"
							name="txttrangthai">
							<option value="" selected>-- Chọn trang thái sản phẩm --</option>
							<option>true</option>
							<option>false</option>
						</select>
					</div>
					-->
				
                        <input type="submit" value="Sửa sản phẩm">
				</form>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</body>

</html>