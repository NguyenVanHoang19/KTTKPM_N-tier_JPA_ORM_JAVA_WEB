package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
@Entity
@Table(name="ChiTietDonHang")
public class ChiTietDonHang implements Serializable{
	@EmbeddedId
	private ChiTietDonHangID chiTietDonHangID;
	@ManyToOne
	@MapsId("maSanPhamID")
	@JoinColumn(name="MASANPHAM")
	private SanPham sanPham;
	@ManyToOne
	@MapsId("maDonHangID")
	@JoinColumn(name="MADONHANG")
	private DonHang donHang;
	private int soLuong;
	private float donGia;
	public ChiTietDonHangID getChiTietDonHangID() {
		return chiTietDonHangID;
	}
	public void setChiTietDonHangID(ChiTietDonHangID chiTietDonHangID) {
		this.chiTietDonHangID = chiTietDonHangID;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public DonHang getDonHang() {
		return donHang;
	}
	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chiTietDonHangID == null) ? 0 : chiTietDonHangID.hashCode());
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
		ChiTietDonHang other = (ChiTietDonHang) obj;
		if (chiTietDonHangID == null) {
			if (other.chiTietDonHangID != null)
				return false;
		} else if (!chiTietDonHangID.equals(other.chiTietDonHangID))
			return false;
		return true;
	}
	public ChiTietDonHang(ChiTietDonHangID chiTietDonHangID, SanPham sanPham, DonHang donHang, int soLuong,
			float donGia) {
		super();
		this.chiTietDonHangID = chiTietDonHangID;
		this.sanPham = sanPham;
		this.donHang = donHang;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	public ChiTietDonHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChiTietDonHang [chiTietDonHangID=" + chiTietDonHangID + ", sanPham=" + sanPham + ", donHang=" + donHang
				+ ", soLuong=" + soLuong + ", donGia=" + donGia + "]";
	}
	
	
}