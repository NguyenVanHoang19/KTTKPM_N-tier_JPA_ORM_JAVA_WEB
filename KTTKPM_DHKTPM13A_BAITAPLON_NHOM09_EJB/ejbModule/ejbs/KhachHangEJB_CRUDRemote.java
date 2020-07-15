package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.KhachHang;

@Remote
public interface KhachHangEJB_CRUDRemote {
	public KhachHang addKhachHang(KhachHang khachHang);
	public List<KhachHang> getAllKhachHang();
	public KhachHang updateKhachHang(KhachHang khachHang);
	public KhachHang getKhachHangByTaiKhoan(String tenTaiKhoan);
	public KhachHang getKhachHangById(int id);
}
