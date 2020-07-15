package entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="NguoiQuanLy")
public class NguoiQuanLy implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(columnDefinition="nvarchar(255)")
	private String tenQuanLy;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTenQuanLy() {
		return tenQuanLy;
	}
	public void setTenQuanLy(String tenQuanLy) {
		this.tenQuanLy = tenQuanLy;
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
	public NguoiQuanLy(Integer id, String tenQuanLy, LocalDate ngaySinh, String soCMND, String soDienThoai,
			String email, String diaChi, String trangThai, TaiKhoan taiKhoan) {
		super();
		this.id = id;
		this.tenQuanLy = tenQuanLy;
		this.ngaySinh = ngaySinh;
		this.soCMND = soCMND;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
		this.trangThai = trangThai;
		this.taiKhoan = taiKhoan;
	}
	public NguoiQuanLy() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		NguoiQuanLy other = (NguoiQuanLy) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NguoiQuanLy [id=" + id + ", tenQuanLy=" + tenQuanLy + ", ngaySinh=" + ngaySinh + ", soCMND=" + soCMND
				+ ", soDienThoai=" + soDienThoai + ", email=" + email + ", diaChi=" + diaChi + ", trangThai="
				+ trangThai + ", taiKhoan=" + taiKhoan + "]";
	}
	
	
}
