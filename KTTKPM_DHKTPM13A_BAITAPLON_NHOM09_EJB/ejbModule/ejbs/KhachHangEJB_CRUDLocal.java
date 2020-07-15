package ejbs;

import javax.ejb.Local;

import entities.KhachHang;

@Local
public interface KhachHangEJB_CRUDLocal {
	public KhachHang addKhachHang(KhachHang khachHang);
}
