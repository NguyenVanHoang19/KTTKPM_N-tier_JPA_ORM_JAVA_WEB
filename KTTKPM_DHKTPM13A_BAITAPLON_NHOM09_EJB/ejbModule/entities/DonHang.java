package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DonHang")
public class DonHang implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer maDonHang;
	private LocalDate ngayLap;
	@ManyToOne
	@JoinColumn(name="MAKHACHHANG")
	private KhachHang khachHang;
	@OneToMany(mappedBy="donHang",cascade = CascadeType.ALL,fetch =  FetchType.EAGER)
	private List<ChiTietDonHang> chiTietDonHangs;
	public Integer getMaDonHang() {
		return maDonHang;
	}
	public void setMaDonHang(Integer maDonHang) {
		this.maDonHang = maDonHang;
	}
	public LocalDate getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public List<ChiTietDonHang> getChiTietDonHangs() {
		return chiTietDonHangs;
	}
	public void setChiTietDonHangs(List<ChiTietDonHang> chiTietDonHangs) {
		this.chiTietDonHangs = chiTietDonHangs;
	}
	public DonHang(Integer maDonHang, LocalDate ngayLap, KhachHang khachHang, List<ChiTietDonHang> chiTietDonHangs) {
		super();
		this.maDonHang = maDonHang;
		this.ngayLap = ngayLap;
		this.khachHang = khachHang;
		this.chiTietDonHangs = chiTietDonHangs;
	}
	public DonHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonHang(Integer maDonHang, LocalDate ngayLap, KhachHang khachHang) {
		super();
		this.maDonHang = maDonHang;
		this.ngayLap = ngayLap;
		this.khachHang = khachHang;
	}
	@Override
	public String toString() {
		return "DonHang [maDonHang=" + maDonHang + ", ngayLap=" + ngayLap + ", khachHang=" + khachHang + "]";
	}
	
	
	
}
