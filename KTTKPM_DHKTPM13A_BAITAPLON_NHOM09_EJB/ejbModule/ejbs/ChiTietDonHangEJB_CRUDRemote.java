package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.ChiTietDonHang;

@Remote
public interface ChiTietDonHangEJB_CRUDRemote {
	public ChiTietDonHang addChiTietDonHang(ChiTietDonHang chiTietDonHang);
	public List<ChiTietDonHang> getAllChiTietDonHang();
	public List<ChiTietDonHang> getChiTietDonHang(int maDonHang);
	public List<ChiTietDonHang> getAllChiTietDonHangbyDonHang(int maDonHang);
}
