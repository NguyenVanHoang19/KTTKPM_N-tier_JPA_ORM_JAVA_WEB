package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TaiKhoan")
public class TaiKhoan implements Serializable{
	@Id
	@Column(name="TenTaiKhoan")
	private String tenTaiKhoan;
	private String matKhau;
	@OneToOne(mappedBy="taiKhoan")
	private KhachHang khachHang;
	@OneToOne(mappedBy="taiKhoan")
	private NguoiQuanLy nguoiQuanLy;
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NguoiQuanLy getNguoiQuanLy() {
		return nguoiQuanLy;
	}
	public void setNguoiQuanLy(NguoiQuanLy nguoiQuanLy) {
		this.nguoiQuanLy = nguoiQuanLy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tenTaiKhoan == null) ? 0 : tenTaiKhoan.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		if (tenTaiKhoan == null) {
			if (other.tenTaiKhoan != null)
				return false;
		} else if (!tenTaiKhoan.equals(other.tenTaiKhoan))
			return false;
		return true;
	}
	public TaiKhoan(String tenTaiKhoan, String matKhau, KhachHang khachHang, NguoiQuanLy nguoiQuanLy) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.khachHang = khachHang;
		this.nguoiQuanLy = nguoiQuanLy;
	}
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(String tenTaiKhoan, String matKhau) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
	}
	@Override
	public String toString() {
		return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", khachHang=" + khachHang
				+ ", nguoiQuanLy=" + nguoiQuanLy + "]";
	}
	
	
	
}
