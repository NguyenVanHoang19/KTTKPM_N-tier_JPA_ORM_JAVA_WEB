package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.TaiKhoan;

@Remote
public interface TaiKhoanEJB_CRUDRemote {
	public TaiKhoan addTaiKhoan(TaiKhoan taiKhoan);
	public List<TaiKhoan> getAllTaiKhoan();
	public TaiKhoan getTaiKhoanById(String id);
	public List<TaiKhoan> getTaiKhoanByIdAndMK(String tenTaiKhoan,String matKhau);
	
}
