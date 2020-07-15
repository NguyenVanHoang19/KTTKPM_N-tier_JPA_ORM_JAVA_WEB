package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.ChiTietDonHangEJB_CRUDRemote;
import ejbs.DonHangEJB_CRUDRemote;
import ejbs.KhachHangEJB_CRUDRemote;
import ejbs.SanPhamEJB_CRUDRemote;
import ejbs.TaiKhoanEJB_CRUDRemote;
import entities.KhachHang;


/**
 * Servlet implementation class dsDonHangKhachHang
 */
@WebServlet("/dsDonHangKhachHang")
public class dsDonHangKhachHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB
	 private TaiKhoanEJB_CRUDRemote taiKhoanEJB_CRUDRemote;
	 @EJB 
	 private KhachHangEJB_CRUDRemote  khachHangEJB_CRUDRemote;
	 @EJB
	 private DonHangEJB_CRUDRemote donHangEJB_CRUDRemote;
	 @EJB 
	 private ChiTietDonHangEJB_CRUDRemote chiTietDonHangEJB_CRUDRemote;
	 @EJB 
	 private SanPhamEJB_CRUDRemote sanPhamEJB_CRUDRemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dsDonHangKhachHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if(action !=null && !action.equals("")) {
			if(action.equals("showForm")) {
				danhSachDonHang(request, response);
			}
			else if(action.equals("xemchitietdonhang")) {
				xemChiTietDonHang(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void danhSachDonHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KhachHang khachHang = khachHangEJB_CRUDRemote.getKhachHangByTaiKhoan(request.getParameter("tenTaiKhoan"));
		if(donHangEJB_CRUDRemote.getAllDonHangbyMaKhachHang(khachHang.getMaKhachHang()).isEmpty()) {
			request.getRequestDispatcher("XemDSDonHang_KhachHang.jsp").forward(request, response);
		}
		else {
			request.setAttribute("listDonHangKhachHang",donHangEJB_CRUDRemote.getAllDonHangbyMaKhachHang(khachHang.getMaKhachHang()));
			request.getRequestDispatcher("XemDSDonHang_KhachHang.jsp").forward(request, response);
		}
	}
	public void xemChiTietDonHang(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String maDonHang=request.getParameter("maDonHangKH");
		request.setAttribute("listChiTietKhachHang", chiTietDonHangEJB_CRUDRemote.getAllChiTietDonHangbyDonHang(Integer.parseInt(maDonHang)));
		request.getRequestDispatcher("XemDSChiTiet_KhachHang.jsp").forward(request, response);
	}
}
