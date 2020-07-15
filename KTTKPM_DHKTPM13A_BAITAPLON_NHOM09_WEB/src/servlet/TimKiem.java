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
 * Servlet implementation class TimKiem
 */
@WebServlet("/TimKiem")
public class TimKiem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB
	  private SanPhamEJB_CRUDRemote sanPhamEJB_CRUDRemote;
	 
	 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimKiem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String tenSanPham=request.getParameter("timkiem");
		List<SanPham> list = sanPhamEJB_CRUDRemote.getSanPhamByten(tenSanPham);
		request.setAttribute("listSanPham", list);
		request.setAttribute("tukhoa", tenSanPham);
		request.getRequestDispatcher("ListKetQuaTimKiem.jsp").forward(request, response);
		response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/TimKiem");
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
