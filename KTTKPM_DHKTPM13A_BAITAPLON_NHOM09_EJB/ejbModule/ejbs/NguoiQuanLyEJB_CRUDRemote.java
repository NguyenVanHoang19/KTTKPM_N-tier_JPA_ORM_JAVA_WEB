package ejbs;

import javax.ejb.Remote;

import entities.NguoiQuanLy;

@Remote
public interface NguoiQuanLyEJB_CRUDRemote {
	public NguoiQuanLy addNguoiQuanLy(NguoiQuanLy nguoiQuanLy);
}
