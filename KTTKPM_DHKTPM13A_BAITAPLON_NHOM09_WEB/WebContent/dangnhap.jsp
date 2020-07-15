<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous"> -->
    <link href="<c:url value="/css/fontawesome-free-5.13.0-web/css/all.css"/>" rel='stylesheet' type='text/css'/>
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel='stylesheet' type='text/css'/>
    <link href="<c:url value="/css/bootstrap.css"/>" rel='stylesheet' type='text/css'/>
    <script src="<c:url value="/js/jquery-3.3.1.min.js" />"></script>
    <script src="<c:url value="/js/bootstrap.min.js" />"></script>
    <link href="<c:url value="/css/csslogin.css"/>" rel='stylesheet' type='text/css'/>
    <title>Đăng Nhập</title>
</head>


<body>
   <div class="container">
        <div class="row vertical-center-row">
            <div class="col-md-4 col-center-block login-widget">
                <h1 class="text-center"><i class="fa fa-dot-circle-o"></i>Đăng Nhập
                </h1>
                <div>
                	<c:set var="tb" value="${thongBaoDangNhapLoi}" scope="session"></c:set>
                	<c:if test="${tb == 'true' }">
                          <h4 style="color: red;">Sai Tài Khoản Hoặc Mật Khẩu</h4>
                     </c:if>
                    <form action="DangNhap" method="POST">
                        <div class="form-group">
                            <div class="input-group">
                            	
                                <div class="input-group-addon"><i class="fa fa-user fa-fw"></i>
                                </div> <input class="form-control" placeholder="Tên đăng nhập" type="text" name="tenDangNhap">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon"><i class="fa fa-key fa-fw"></i>
                                </div> <input class="form-control" placeholder="******" type="password" name="matKhau">
                            </div>
                        </div>
                		<input type="hidden" name="action" value="dangnhap">
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary btn-block" value="Đăng nhập" />
                            <hr>
                        </div>
                    </form>
                    <p class="text-center">Bạn có tài khoản không? <strong><a href="/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/dangki.jsp" class="blue-text">Đăng ký ngay!</a></strong>
                    </p>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</body>

</html>