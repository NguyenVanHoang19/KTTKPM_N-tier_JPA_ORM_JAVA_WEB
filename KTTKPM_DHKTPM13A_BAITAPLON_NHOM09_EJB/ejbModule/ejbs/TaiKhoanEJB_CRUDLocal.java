package ejbs;

import java.util.List;

import javax.ejb.Local;

import entities.TaiKhoan;

@Local
public interface TaiKhoanEJB_CRUDLocal {
	public TaiKhoan addTaiKhoan(TaiKhoan taiKhoan);
	public List<TaiKhoan> getAllTaiKhoan();
}
