package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejbs.TaiKhoanEJB_CRUDRemote;
import entities.TaiKhoan;

/**
 * Servlet implementation class DangNhap
 */
@WebServlet("/DangNhap")
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB
	 private TaiKhoanEJB_CRUDRemote taiKhoanEJB_CRUDRemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action !=null && !action.equals("")) {
			if(action.equals("dangnhap")) {
				DangNhap(request, response);
			}
			else if(action.equals("dangxuat")) {
				HttpSession session = request.getSession();
				session.removeAttribute("tk");
				session.removeAttribute("cart");
				response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListSanPham");
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
	public void DangNhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenTaiKhoan = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		TaiKhoan taiKhoan =null;
		for(TaiKhoan tk : taiKhoanEJB_CRUDRemote.getTaiKhoanByIdAndMK(tenTaiKhoan, matKhau)) {	
			taiKhoan= tk; 
			HttpSession session = request.getSession();
			
			session.setAttribute("tk",tk);
			response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListSanPham");
		}
		if(tenTaiKhoan.equals("admin") && matKhau.equals("admin")) {
			response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/admin.jsp");
			return ;
		}
		if(taiKhoan==null) {
			HttpSession session = request.getSession();
			session.setAttribute("thongBaoDangNhapLoi","true");
			response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/dangnhap.jsp");
		}
		
	}
}
