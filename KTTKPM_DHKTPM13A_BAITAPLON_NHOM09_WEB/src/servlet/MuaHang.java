package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.GioHang;
import beans.Item;
import ejbs.ChiTietDonHangEJB_CRUDRemote;
import ejbs.DonHangEJB_CRUDRemote;
import ejbs.KhachHangEJB_CRUDRemote;
import ejbs.SanPhamEJB_CRUDRemote;
import ejbs.TaiKhoanEJB_CRUDRemote;
import entities.ChiTietDonHang;
import entities.ChiTietDonHangID;
import entities.DonHang;
import entities.KhachHang;
import entities.SanPham;
import entities.TaiKhoan;

/**
 * Servlet implementation class MuaHang
 */
@WebServlet("/MuaHang")
public class MuaHang extends HttpServlet {
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
    public MuaHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String xemnhanh = null;
		xemnhanh=request.getParameter("xemnhanh");
		String action = request.getParameter("action");
		if(action !=null && !action.equals("")) {
			if(action.equals("add")) {
				addItem(request, response);
			}
			else if(action.equals("xemthongtinsanpham")) {
				xemThongTinSanPham(request, response);
			}
			else if(action.equals("update")) {
				updateSoLuong(request, response);
			}
			else if(action.equals("delete")) {
				deleteItem(request, response);
			}
			else if(action.equals("thanhtoan")) {
				thanhToan(request, response);
			}
			else if(action.equals("xacnhanthanhtoan")) {
				xacNhanThanhToan(request, response);
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
	public void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id =Integer.valueOf(request.getParameter("maSanPham"));
		String tenSanPham = request.getParameter("tenSanPham");
		String urlHinhAnh = request.getParameter("urlHinh");
		float donGia = Float.valueOf(request.getParameter("donGia"));
		int soLuong = Integer.valueOf(request.getParameter("soLuong"));
		
	//	String tenSanPhamDecoded = URLDecoder.decode(tenSanPham, "UTF-8");
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
		int soLuongConTrongKho = 0 ;
		try {
			if(soLuongConTrongKho(id)!=0) {
				soLuongConTrongKho += soLuongConTrongKho(id);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		gioHang.ThemItem(new Item(id, tenSanPham, urlHinhAnh, donGia, soLuong,soLuongConTrongKho));
		response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ChiTietDonHang.jsp");
	}
	public void themVaoGioHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id =Integer.valueOf(request.getParameter("maSanPham"));
		String tenSanPham = request.getParameter("tenSanPham");
		String urlHinhAnh = request.getParameter("urlHinh");
		float donGia = Float.valueOf(request.getParameter("donGia"));
		int soLuong = Integer.valueOf(request.getParameter("soLuong"));
		
	//	String tenSanPhamDecoded = URLDecoder.decode(tenSanPham, "UTF-8");
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
		int soLuongConTrongKho = 0 ;
		try {
			if(soLuongConTrongKho(id)!=0) {
				soLuongConTrongKho += soLuongConTrongKho(id);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		gioHang.ThemItem(new Item(id, tenSanPham, urlHinhAnh, donGia, soLuong,soLuongConTrongKho));
		response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/xemthongtinsanpham.jsp");
	}
	public void updateSoLuong(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id =Integer.valueOf(request.getParameter("id"));
		int soLuong =Integer.valueOf(request.getParameter("soLuong"));
		
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
			gioHang.updateItem(gioHang.getItemById(id),soLuong);
		response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ChiTietDonHang.jsp");
	}
	public void deleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id =Integer.valueOf(request.getParameter("id"));
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
		
		gioHang.deleteItem(gioHang.getItemById(id));
		response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ChiTietDonHang.jsp");
	}
	public void thanhToan(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tenTaiKhoan = request.getParameter("tenTaiKhoan");
		KhachHang khachHang = null;
		if(tenTaiKhoan.equalsIgnoreCase("")) {
			response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/dangnhap.jsp");
		}
		else {
			khachHang = khachHangEJB_CRUDRemote.getKhachHangByTaiKhoan(tenTaiKhoan);
			request.setAttribute("kh", khachHang);
			request.getRequestDispatcher("thanhtoan.jsp").forward(request, response);
//			response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/thanhtoan.jsp");
		}
	}
	public int soLuongSanPhamDaDat(int maSanPham) {
		int soLuong = 0;
		List<SanPham> listSanPhamDaDat = new ArrayList<SanPham>();
		for(ChiTietDonHang chiTietDonHang :chiTietDonHangEJB_CRUDRemote.getAllChiTietDonHang()) {
			if(chiTietDonHang.getSanPham().getMaSanPham()==maSanPham) {
				soLuong += chiTietDonHang.getSoLuong();
			}
		}
		return soLuong;
	}
	public boolean kiemTraSoLuongCon(int soLuongMua,int maSanPham) {
		if(sanPhamEJB_CRUDRemote.getSanPhamById(maSanPham).getSoLuongNhap()>soLuongSanPhamDaDat(maSanPham)) {
			return true;
		}
		return false;
		   
	}
	public int soLuongConTrongKho(int maSanPham) {
		int soLuongCon = 0 ;
		soLuongCon =sanPhamEJB_CRUDRemote.getSanPhamById(maSanPham).getSoLuongNhap() - soLuongSanPhamDaDat(maSanPham);
		return soLuongCon;
	}
	public void xemThongTinSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSP = request.getParameter("maSanPham");
		int maSanPham = Integer.parseInt(maSP);
		SanPham sanPham = sanPhamEJB_CRUDRemote.getSanPhamById(maSanPham);
		request.setAttribute("sp", sanPham);
		request.setAttribute("soLuongDaBan", soLuongSanPhamDaDat(maSanPham));
		request.setAttribute("soLuongCon", soLuongConTrongKho(maSanPham));
		request.getRequestDispatcher("xemthongtinsanpham.jsp").forward(request, response);
	}
	public void xacNhanThanhToan(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
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
		// them don hang
		DonHang donHang = new DonHang();
		donHang.setNgayLap(LocalDate.now());
		donHang.setKhachHang(khachHangEJB_CRUDRemote.getKhachHangById(maKhachHang));
		donHangEJB_CRUDRemote.addDonHang(donHang);
		donHang.setMaDonHang(donHangEJB_CRUDRemote.getIdMax());
		// them chi tiet don hang
		HttpSession session = request.getSession();
		GioHang gioHang = null;
		Object objGioHang = session.getAttribute("cart");
		if(objGioHang!=null) {
			gioHang = (GioHang) objGioHang;
			for(Item item : gioHang.getGioHang()) {
				ChiTietDonHang chiTietDonHang = new ChiTietDonHang(new ChiTietDonHangID(donHangEJB_CRUDRemote.getIdMax(), sanPhamEJB_CRUDRemote.getSanPhamById(item.getId()).getMaSanPham()),sanPhamEJB_CRUDRemote.getSanPhamById(item.getId()) , donHang, item.getSoLuong(), item.getDonGia()*item.getSoLuong());
				chiTietDonHangEJB_CRUDRemote.addChiTietDonHang(chiTietDonHang);
			}
			session.removeAttribute("cart");
		}
		response.sendRedirect("/KTTKPM_DHKTPM13A_BAITAPLON_NHOM09_WEB/ListSanPham");
		
		
		
	}
}
