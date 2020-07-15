package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.KhachHangEJB_CRUDRemote;
import ejbs.SanPhamEJB_CRUDRemote;
import ejbs.TaiKhoanEJB_CRUDRemote;
import entities.DonHang;
import entities.KhachHang;
import entities.TaiKhoan;

/**
 * Servlet implementation class DangKi
 */
@WebServlet("/DangKi")
public class DangKi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private KhachHangEJB_CRUDRemote khachHangEJB_CRUDRemote;

	@EJB
	private TaiKhoanEJB_CRUDRemote taiKhoanEJB_CRUDRemote;



	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		LocalDate loc;
		//		String ngay=request.getParameter("ngay");
		//		String thang=request.getParameter("thang");
		//		String nam=request.getParameter("nam");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String tenTaiKhoan = request.getParameter("tentaikhoan");
		String tenKhachHang = request.getParameter("tenkhachhang");
		String email = request.getParameter("email");
		String soDienThoai = request.getParameter("dienhoai");
		String matkhau=request.getParameter("matkhau");
		String  trangthai = request.getParameter("trangthai");
		String scmnd =request.getParameter("socmnd");
		String diachi=request.getParameter("diaChi");
		//loc=LocalDate.of(Integer.parseInt(nam),Integer.parseInt(thang),Integer.parseInt(ngay));
		//tim kiem tai khoan
		TaiKhoan taiKhoan = null;
		taiKhoan= taiKhoanEJB_CRUDRemote.getTaiKhoanById(tenTaiKhoan);
		if(taiKhoan != null) {
			request.setAttribute("thongBaoTrungTaiKhoan","Tên tài khoản đã được sử dụng.");
			request.getRequestDispatcher("dangki.jsp").forward(request, response);
		}
		else {
			//		KhachHang kh=new KhachHang();
			TaiKhoan taikhoan=new TaiKhoan(tenTaiKhoan,matkhau);
			taiKhoanEJB_CRUDRemote.addTaiKhoan(taikhoan);
			KhachHang khachHang = new KhachHang();
			khachHang.setTenKhachHang(tenKhachHang);
			khachHang.setDiaChi(diachi);
			khachHang.setEmail(email);
			//khachHang.setNgaySinh(loc);
			khachHang.setSoCMND(scmnd);
			khachHang.setSoDienThoai(soDienThoai);
			khachHang.setTaiKhoan(taikhoan);
			khachHang.setTrangThai("true");
			khachHangEJB_CRUDRemote.addKhachHang(khachHang);
			//khachHang.setDiaChi(di
			//khachHangEJB_CRUDRemote.addKhachHang(new KhachHang(tenKhachHang,loc,scmnd,soDienThoai,email,trangthai,taikhoan));

			//	request.getRequestDispatcher("trangchu.jsp").forward(request, response);
			response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/dangnhap.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
