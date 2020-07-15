package servlet;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



import ejbs.ChiTietDonHangEJB_CRUDRemote;
import ejbs.DanhMucEJB_CRUDRemote;
import ejbs.DonHangEJB_CRUDRemote;
import ejbs.NhaCungCapEJB_CRUDRemote;
import ejbs.SanPhamEJB_CRUDRemote;
import entities.DanhMuc;
import entities.NhaCungCap;
import entities.SanPham;

/**
 * Servlet implementation class quanLySanPham
 */
@WebServlet("/quanLySanPham")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB

public class quanLySanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private SanPhamEJB_CRUDRemote sanPhamEJB_CRUDRemote;

	@EJB
	private DanhMucEJB_CRUDRemote danhmucEJB;

	@EJB
	private NhaCungCapEJB_CRUDRemote nhacungcapEJB;
	@EJB
	private DonHangEJB_CRUDRemote donhang ;
	@EJB
	private ChiTietDonHangEJB_CRUDRemote chitietEJB;

	private static final String UPLOAD_DIRECTORY = "img";
	private static final int THRESHOLD_SIZE 	= 1024 * 1024 * 3; 	// 3MB
	private static final int MAX_FILE_SIZE 		= 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE 	= 1024 * 1024 * 50; // 50MB

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public quanLySanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getParameter("action");
		if(action !=null && !action.equals("")) {
			if(action.equals("themsp")) {
				themSanPham(request, response);
			}
			else if(action.equals("listsp")) {
				listSanPham(request, response);
			}
			else if(action.equals("formthem")) {
				formThem(request, response);
			}
			else if(action.equals("xoasp")) {
				xoasp(request, response);
			}
			else if(action.equals("dsdonhang")) {
				listDonHang(request, response);
			}
			else if(action.equals("dschitiet")) {
				listChiTiet(request, response);
			}
			else if(action.equals("suasp")) {
				suaSP(request, response);
			}
			else if(action.equals("formsua")) {
				formSua(request, response);
			}
		}

	}

	private void formSua(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String txtidsua=request.getParameter("txtidsua");
		request.setAttribute("spsua",sanPhamEJB_CRUDRemote.getSanPhamById(Integer.parseInt(txtidsua)));
		request.setAttribute("listDMSua", danhmucEJB.getAllDanhMuc());
		request.setAttribute("listNCCSua", nhacungcapEJB.getALLNCC());
		request.getRequestDispatcher("FormSuaSP.jsp").forward(request, response);
	}

	private void suaSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maSanPham=request.getParameter("txtmasua");
		String tenSanPham= request.getParameter("txttensua");
		String mota= request.getParameter("txtmotasua");
		String donViTinh= request.getParameter("txtdvtsua");
		String soluong= request.getParameter("txtslsua");
		String dg= request.getParameter("txtgiasua");
		float donGia=Float.parseFloat(dg);
		String ngaysanxuat= request.getParameter("txtngaysua");
		String ncc=request.getParameter("txttennccsua");
		String dm= request.getParameter("txttenloaisua");

		NhaCungCap n=nhacungcapEJB.getNhaCungCapbyTen(ncc);
		DanhMuc d=danhmucEJB.getDanhMucbyTen(dm);
		SanPham sp= sanPhamEJB_CRUDRemote.getSanPhamById(Integer.parseInt(maSanPham));
		sp.setDanhMuc(d);
		sp.setDonGia(donGia);
		sp.setDonViTinh(donViTinh);
		sp.setMoTa(mota);
		sp.setNgaySanXuat(LocalDate.parse(ngaysanxuat));
		sp.setNhaCungCap(n);
		sp.setTenSanPham(tenSanPham);
		sp.setSoLuongNhap(Integer.parseInt(soluong));
		sanPhamEJB_CRUDRemote.suaSanPham(sp);
		request.setAttribute("list", sanPhamEJB_CRUDRemote.getAllSanPham());
		request.getRequestDispatcher("dssp_quanly.jsp").forward(request, response);
	}

	private void listChiTiet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("txtidDH");

		request.setAttribute("listchitiet",chitietEJB.getChiTietDonHang(Integer.parseInt(id)));
		request.getRequestDispatcher("DSChiTiet.jsp").forward(request, response);
	}

	private void listDonHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("list",donhang.getAllDonHang());
		request.getRequestDispatcher("DSDonHang.jsp").forward(request, response);
	}

	private void xoasp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ma= request.getParameter("txtid");
		int masp =Integer.parseInt(ma);
		SanPham s= sanPhamEJB_CRUDRemote.getSanPhamById(masp);
		s.setTrangThai("false");
		sanPhamEJB_CRUDRemote.suaSanPham(s);
		request.setAttribute("list", sanPhamEJB_CRUDRemote.getAllSanPham());
		request.getRequestDispatcher("dssp_quanly.jsp").forward(request, response);
	}

	private void formThem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("listDM", danhmucEJB.getAllDanhMuc());
		request.setAttribute("listNCC", nhacungcapEJB.getALLNCC());
		request.getRequestDispatcher("formthemSP.jsp").forward(request, response);
	}

	private void listSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("list", sanPhamEJB_CRUDRemote.getAllSanPham());
		request.getRequestDispatcher("dssp_quanly.jsp").forward(request, response);
	}

	public void themSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

		String tenSanPham= request.getParameter("txtten");
		String mota= request.getParameter("txtmota");
		String donViTinh= request.getParameter("txtdvt");
		String soluong= request.getParameter("txtsl");
		int soLuong = Integer.parseInt(soluong);
		String dg= request.getParameter("txtgia");
		float donGia=Float.parseFloat(dg);
		String ngaysanxuat= request.getParameter("txtngay");
		String ncc=request.getParameter("txttenncc");
		String dm= request.getParameter("txttenloai");

		NhaCungCap n=nhacungcapEJB.getNhaCungCapbyTen(ncc);
		DanhMuc d=danhmucEJB.getDanhMucbyTen(dm);
		SanPham sp= new SanPham(tenSanPham, LocalDate.parse(ngaysanxuat), donViTinh, mota,soLuong, donGia,"" , "true", n, d);
		//	themSanPham(request, response);
		/**
		 * Xử lý uploadfile
		 */
		//		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		//
		//	
		//		    FileItemFactory factory = new DiskFileItemFactory();
		//		    ServletFileUpload upload = new ServletFileUpload(factory);
		//		
		//        
		//        String uploadPath = getServletContext().getRealPath("")
		//            + File.separator + UPLOAD_DIRECTORY;
		//
		//				// creates the directory if it does not exist
		//				
		//				File uploadDir = new File(uploadPath);
		//				if (!uploadDir.exists()) {
		//					uploadDir.mkdir();
		//				}
		//				try {
		//					// parses the request's content to extract file data
		//					List formItems = upload.parseRequest(request);
		//					Iterator iter = formItems.iterator();
		//					
		//					// iterates over form's fields
		//// 					part= request.getPart("file");
		////					String fileName = extractFileName(part);
		//					
		//					 
		//					while (iter.hasNext()) {
		//						FileItem item = (FileItem) iter.next(); 
		//						// processes only fields that are not form fields
		//						
		//						if (!item.isFormField()) {
		//							String fileName = item.getName();
		//							String filePath = uploadPath + File.separator + fileName;
		//							File storeFile = new File(filePath);
		//							
		//							// saves the file on disk
		//							item.write(storeFile);
		//							
		//							sp.setUrlHinh("./img/"+fileName+"");
		//							sp.setTenSanPham("qq");
		//						}

		//						sp.setUrlHinh("./img/"+extractFileName(fileName)+"");

//	}

	//					request.setAttribute("message", "Upload has been done successfully!"+uploadPath+"");


	//							request.setAttribute("message", "Upload has been done successfully!"+uploadPath+"");
	//							request.getRequestDispatcher("show.jsp").forward(request, response);
	//				} catch (Exception ex) {
	//					request.setAttribute("message", "There was an error: " + ex.getMessage());
	//				}
	/**
	 * Kết thúc xử lý file
	 */		
	sanPhamEJB_CRUDRemote.addSanPham(sp);
	request.setAttribute("list", sanPhamEJB_CRUDRemote.getAllSanPham());
	request.getRequestDispatcher("dssp_quanly.jsp").forward(request, response);
}
private String extractFileName(Part part) {
	// form-data; name="file"; filename="C:\file1.zip"
	// form-data; name="file"; filename="C:\Note\file2.zip"
	String contentDisp = part.getHeader("content-disposition");
	String[] items = contentDisp.split(";");
	for (String s : items) {
		if (s.trim().startsWith("filename")) {
			// C:\file1.zip
			// C:\Note\file2.zip
			String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
			clientFileName = clientFileName.replace("\\", "/");
			int i = clientFileName.lastIndexOf('/');
			// file1.zip
			// file2.zip
			return clientFileName.substring(i + 1);
		}
	}
	return null;
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);

}

}
