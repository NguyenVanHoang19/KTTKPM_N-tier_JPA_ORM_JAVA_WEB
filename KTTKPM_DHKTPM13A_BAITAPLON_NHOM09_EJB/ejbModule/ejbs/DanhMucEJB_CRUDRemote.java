package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.DanhMuc;

@Remote
public interface DanhMucEJB_CRUDRemote {
	public DanhMuc addDanhMuc(DanhMuc danhMuc);
	public List<DanhMuc> getAllDanhMuc();
	public DanhMuc getDanhMuc(int id);
	public DanhMuc getDanhMucbyTen(String ten);
}
