import java.time.LocalDate;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejbs.ChiTietDonHangEJB_CRUDRemote;
import ejbs.DonHangEJB_CRUDRemote;
import ejbs.KhachHangEJB_CRUDRemote;
import ejbs.SanPhamEJB_CRUDRemote;
import ejbs.TaiKhoanEJB_CRUDRemote;
import entities.ChiTietDonHang;
import entities.ChiTietDonHangID;
import entities.DonHang;
import entities.KhachHang;
import entities.TaiKhoan;

public class Main {
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.1.113"); // default!
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700"); // default!
	//	InitialContext context = new InitialContext(props);
		Context ctx = new InitialContext(props);
		TaiKhoanEJB_CRUDRemote taiKhoanEJB_CRUDRemote = (TaiKhoanEJB_CRUDRemote) ctx.lookup("TaiKhoanEJB_Remote");
		KhachHangEJB_CRUDRemote khachHangEJB_CRUDRemote = (KhachHangEJB_CRUDRemote) ctx.lookup("KhachHangEJB_Remote");
		
		SanPhamEJB_CRUDRemote sanPhamEJB_CRUDRemote = (SanPhamEJB_CRUDRemote) ctx.lookup("SanPhamEJB_CRUDRemote");
		
		DonHangEJB_CRUDRemote  donHangEJB_CRUDRemote = (DonHangEJB_CRUDRemote) ctx.lookup("DonHangEJB_CRUDRemote");
		ChiTietDonHangEJB_CRUDRemote chiTietDonHangEJB_CRUDRemote = (ChiTietDonHangEJB_CRUDRemote) ctx.lookup("ChiTietDonHangEJB_CRUDRemote");
		
		TaiKhoan taiKhoan = new TaiKhoan("hoangnguyen", "nguyenhoanghhd");
		
		DonHang donHang = new DonHang();
		donHang.setNgayLap(LocalDate.now());
		donHang.setKhachHang(khachHangEJB_CRUDRemote.getKhachHangById(1));
		donHangEJB_CRUDRemote.addDonHang(donHang);
		donHang.setMaDonHang(donHangEJB_CRUDRemote.getIdMax());
		//
		ChiTietDonHang chiTietDonHang = new ChiTietDonHang(new ChiTietDonHangID(1, sanPhamEJB_CRUDRemote.getSanPhamById(1).getMaSanPham()),sanPhamEJB_CRUDRemote.getSanPhamById(1) , donHang, 1, 25000);
		chiTietDonHangEJB_CRUDRemote.addChiTietDonHang(chiTietDonHang);
		
	//	KhachHang khachHang = new KhachHang(Integer.valueOf(6),"Nguyen hoang d",LocalDate.now(), "12344","12344","hoang", "khanhhoa", "true", taiKhoan);
		
		KhachHang khachHang = new KhachHang();
		khachHang.setTenKhachHang("nguyenhoangghhdasdasd");
		khachHang.setDiaChi("khanh hoa");
		khachHang.setEmail("nguyenvanhoang35iuh@gmail.com");
		khachHang.setSoCMND("22568452712");
		khachHang.setSoDienThoai("0898136946");
		khachHang.setTrangThai("true");
		khachHang.setNgaySinh(LocalDate.now());
		khachHang.setTaiKhoan(taiKhoan);
		//taiKhoanEJB_CRUDRemote.addTaiKhoan(taiKhoan);
		//khachHangEJB_CRUDRemote.addKhachHang(khachHang);
		
		
	//	System.out.println(donHangEJB_CRUDRemote.getIdMax());
		
		
		
//		taiKhoanEJB_CRUDRemote.getAllTaiKhoan().forEach(x->{
//			System.out.println(x);
//		});
//		khachHangEJB_CRUDRemote.getAllKhachHang().forEach(x->{
//			System.out.println(x);
//		});
//		
//		sanPhamEJB_CRUDRemote.getAllSanPham().forEach(x->{
//			System.out.println(x);
//		});
//		
//		
//		taiKhoanEJB_CRUDRemote.getTaiKhoanByIdAndMK("nguyenhoang","123").forEach(x->{
//			System.out.println(x);
//		});
	}
	
	
}