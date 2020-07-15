package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.SanPham;

@Remote
public interface SanPhamEJB_CRUDRemote {
	public SanPham addSanPham(SanPham sanPham);
	public SanPham getSanPhamById(int id);
	public List<SanPham> getAllSanPham();
	public List<SanPham> getAllSanPhambyTrangThai();
	public void xoaSanPham(int id);
	public void suaSanPham(SanPham sanPham);
	public List<SanPham> getAococtay();
	public List<SanPham> getQuanJeanNam();
	public List<SanPham> getAoSoMi();
	public List<SanPham> getAoPhong();
	public List<SanPham> getAoThun();
	public List<SanPham> getSanPhamByten(String ten);
	
}
