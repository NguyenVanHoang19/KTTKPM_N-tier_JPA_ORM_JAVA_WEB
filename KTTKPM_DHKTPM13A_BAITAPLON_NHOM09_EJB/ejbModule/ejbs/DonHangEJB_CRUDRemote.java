package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.DonHang;

@Remote
public interface DonHangEJB_CRUDRemote {
	public DonHang addDonHang(DonHang donHang);
	public int getIdMax();
	public List<DonHang> getAllDonHang();
	public List<DonHang> getAllDonHangbyMaKhachHang(int maKhacHang);
}
