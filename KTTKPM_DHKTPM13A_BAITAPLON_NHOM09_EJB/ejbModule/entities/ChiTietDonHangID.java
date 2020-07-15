package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class ChiTietDonHangID  implements Serializable{
	private Integer maDonHangID;
	private Integer maSanPhamID;
	public Integer getMaDonHangID() {
		return maDonHangID;
	}
	public void setMaDonHangID(Integer maDonHangID) {
		this.maDonHangID = maDonHangID;
	}
	public Integer getMaSanPhamID() {
		return maSanPhamID;
	}
	public void setMaSanPhamID(Integer maSanPhamID) {
		this.maSanPhamID = maSanPhamID;
	}
	public ChiTietDonHangID(Integer maDonHangID, Integer maSanPhamID) {
		super();
		this.maDonHangID = maDonHangID;
		this.maSanPhamID = maSanPhamID;
	}
	public ChiTietDonHangID() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDonHangID == null) ? 0 : maDonHangID.hashCode());
		result = prime * result + ((maSanPhamID == null) ? 0 : maSanPhamID.hashCode());
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
		ChiTietDonHangID other = (ChiTietDonHangID) obj;
		if (maDonHangID == null) {
			if (other.maDonHangID != null)
				return false;
		} else if (!maDonHangID.equals(other.maDonHangID))
			return false;
		if (maSanPhamID == null) {
			if (other.maSanPhamID != null)
				return false;
		} else if (!maSanPhamID.equals(other.maSanPhamID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ChiTietDonHangID [maDonHangID=" + maDonHangID + ", maSanPhamID=" + maSanPhamID + "]";
	}
	
	
}
