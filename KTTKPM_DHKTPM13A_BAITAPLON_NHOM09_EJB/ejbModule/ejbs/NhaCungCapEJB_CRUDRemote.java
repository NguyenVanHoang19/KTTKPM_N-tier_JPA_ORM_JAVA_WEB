package ejbs;

import java.util.List;

import javax.ejb.Remote;

import entities.NhaCungCap;

@Remote
public interface NhaCungCapEJB_CRUDRemote {
	public NhaCungCap addNhaCungCap(NhaCungCap nhaCungCap);
	public List<NhaCungCap> getALLNCC();
	public NhaCungCap getNhaCungCap(int manhaCungCap);
	public NhaCungCap getNhaCungCapbyTen(String ten);
}
