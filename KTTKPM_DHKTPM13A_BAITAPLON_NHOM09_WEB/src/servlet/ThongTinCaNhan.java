package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.KhachHangEJB_CRUDRemote;
import ejbs.TaiKhoanEJB_CRUDRemote;
import entities.KhachHang;

/**
 * Servlet implementation class ThongTinCaNhan
 */
@WebServlet("/ThongTinCaNhan")
public class ThongTinCaNhan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    private TaiKhoanEJB_CRUDRemote taiKhoanEJB_CRUDRemote;
    @EJB 
    private KhachHangEJB_CRUDRemote  khachHangEJB_CRUDRemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinCaNhan() {
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
				showForm(request, response);
			}
			else if(action.equals("capnhatthongtin")) {
				capNhatThongTinCaNhan(request, response);
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
	public void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenTaiKhoan = request.getParameter("tenTaiKhoan");
		KhachHang khachHang = khachHangEJB_CRUDRemote.getKhachHangByTaiKhoan(tenTaiKhoan);
		request.setAttribute("kh", khachHang);
		request.getRequestDispatcher("thongtincanhan.jsp").forward(request, response);
	}
	public void capNhatThongTinCaNhan(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tenTaiKhoan = request.getParameter("tenTaiKhoan");
		int maKhachHang = Integer.valueOf(request.getParameter("maKhachHang"));
		String tenKhachHang = request.getParameter("name");
		String email = request.getParameter("email");
		String diaChi = request.getParameter("diaChi");
		String soDienThoai = request.getParameter("dienThoai");
		KhachHang khachHang = new KhachHang();
		khachHang.setMaKhachHang(maKhachHang);
		khachHang.setTenKhachHang(tenKhachHang);
		khachHang.setEmail(email);
		khachHang.setDiaChi(diaChi);
		khachHang.setSoDienThoai(soDienThoai);
		//khach hang tim boi tai khoan da login
		KhachHang khachHangLogin = khachHangEJB_CRUDRemote.getKhachHangByTaiKhoan(tenTaiKhoan);
		khachHang.setNgaySinh(khachHangLogin.getNgaySinh());
		khachHang.setSoCMND(khachHangLogin.getSoCMND());
		khachHang.setTrangThai(khachHangLogin.getTrangThai());
		khachHang.setTaiKhoan(khachHangLogin.getTaiKhoan());
		// cập nhật lại khách hàng
		khachHangEJB_CRUDRemote.updateKhachHang(khachHang);
		response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListSanPham");
	}
}
