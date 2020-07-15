package servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.SanPhamEJB_CRUDRemote;
import entities.SanPham;

/**
 * Servlet implementation class ListMenuSanPham
 */
@WebServlet("/ListMenuSanPham")
public class ListMenuSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	 private SanPhamEJB_CRUDRemote sanPhamEJB_CRUDRemote;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMenuSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		if(action !=null && !action.equals("")) {
			if(action.equals("aococtay")) {
				listAoCocTay(request, response);
			}
			else if(action.equals("quanjeannam")) {
				listQuanJeanNam(request, response);
			}
			else if(action.equals("aothun")) {
				listAoThun(request, response);
			}
			else if(action.equals("aophong")) {
				listAoPhong(request, response);
			}
			else if(action.equals("aosomi")) {
				listAoSoMi(request, response);
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
	public void listAoThun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SanPham> list = sanPhamEJB_CRUDRemote.getAoThun();
		request.setAttribute("listSanPham", list);
		request.setAttribute("danhmuc", "Áo thun");
		request.getRequestDispatcher("ListMenuSanPham.jsp").forward(request, response);
	}
	public void listAoPhong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SanPham> list = sanPhamEJB_CRUDRemote.getAoPhong();
		request.setAttribute("listSanPham", list);
		request.setAttribute("danhmuc", "Áo phong");
		request.getRequestDispatcher("ListMenuSanPham.jsp").forward(request, response);
	}
	public void listAoSoMi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SanPham> list = sanPhamEJB_CRUDRemote.getAoSoMi();
		request.setAttribute("listSanPham", list);
		request.setAttribute("danhmuc", "Áo sơ mi");
		request.getRequestDispatcher("ListMenuSanPham.jsp").forward(request, response);
	}
	public void listAoCocTay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SanPham> list = sanPhamEJB_CRUDRemote.getAococtay();
		request.setAttribute("listSanPham", list);
		request.setAttribute("danhmuc", "Áo Cộc Tay");
		request.getRequestDispatcher("ListMenuSanPham.jsp").forward(request, response);
	}
	public void listQuanJeanNam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SanPham> list = sanPhamEJB_CRUDRemote.getQuanJeanNam();
		request.setAttribute("listSanPham", list);
		request.setAttribute("danhmuc", "Quần Jean Nam");
		request.getRequestDispatcher("ListMenuSanPham.jsp").forward(request, response);
	}
}
