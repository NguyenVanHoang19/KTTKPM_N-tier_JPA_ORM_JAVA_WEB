package entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="KhachHang")
public class KhachHang implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer maKhachHang;
	@Column(columnDefinition="nvarchar(255)")
	private String tenKhachHang;
	private LocalDate ngaySinh;
	@Column(columnDefinition="nvarchar(255)")
	private String soCMND;
	@Column(columnDefinition="nvarchar(255)")
	private String soDienThoai;
	@Column(columnDefinition="nvarchar(255)")
	private String email;
	@Column(columnDefinition="nvarchar(255)")
	private String diaChi;
	@Column(columnDefinition="nvarchar(255)")
	private String trangThai;
	@OneToOne
	@JoinColumn(name="TENTAIKHOAN",referencedColumnName="tenTaiKhoan",unique=true)
	private TaiKhoan taiKhoan;
	public Integer getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(Integer maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKhachHang == null) ? 0 : maKhachHang.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (maKhachHang == null) {
			if (other.maKhachHang != null)
				return false;
		} else if (!maKhachHang.equals(other.maKhachHang))
			return false;
		return true;
	}
	public KhachHang(Integer maKhachHang, String tenKhachHang, LocalDate ngaySinh, String soCMND, String soDienThoai,
			String email, String diaChi, String trangThai, TaiKhoan taiKhoan) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.ngaySinh = ngaySinh;
		this.soCMND = soCMND;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
		this.trangThai = trangThai;
		this.taiKhoan = taiKhoan;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", ngaySinh=" + ngaySinh
				+ ", soCMND=" + soCMND + ", soDienThoai=" + soDienThoai + ", email=" + email + ", diaChi=" + diaChi
				+ ", trangThai=" + trangThai + ", taiKhoan=" + taiKhoan + "]";
	}
	
	
	
}
