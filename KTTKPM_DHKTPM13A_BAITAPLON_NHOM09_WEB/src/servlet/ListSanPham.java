package servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.GioHang;
import ejbs.DanhMucEJB_CRUDRemote;
import ejbs.SanPhamEJB_CRUDRemote;
import ejbs.TaiKhoanEJB_CRUDRemote;
import entities.DanhMuc;
import entities.SanPham;
import entities.TaiKhoan;

/**
 * Servlet implementation class ListSanPham
 */
@WebServlet("/ListSanPham")
public class ListSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private SanPhamEJB_CRUDRemote sanPhamEJB_CRUDRemote;
   @EJB
   private DanhMucEJB_CRUDRemote danhMucEJB_CRUDRemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<SanPham> list = sanPhamEJB_CRUDRemote.getAllSanPham();
		List<DanhMuc> danhMucs = danhMucEJB_CRUDRemote.getAllDanhMuc();
		request.setAttribute("listSanPham", list);
		request.setAttribute("listDanhMuc", danhMucs);
		HttpSession session = request.getSession();
		GioHang gioHang = null;
		Object objGioHang = session.getAttribute("cart");
		
		if(objGioHang!=null) {
			gioHang = (GioHang) objGioHang;
		}
		else {
			gioHang = new GioHang();
			session.setAttribute("cart", gioHang);
		}
		request.getRequestDispatcher("trangchu.jsp").forward(request, response);
		response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListSanPham");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
