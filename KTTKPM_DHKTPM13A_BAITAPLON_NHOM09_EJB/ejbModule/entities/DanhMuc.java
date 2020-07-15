package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="DanhMuc")
public class DanhMuc implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer maDanhMuc;
	@Column(columnDefinition="nvarchar(255)")
	private String tenDanhMuc;
	public Integer getMaDanhMuc() {
		return maDanhMuc;
	}
	public void setMaDanhMuc(Integer maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDanhMuc == null) ? 0 : maDanhMuc.hashCode());
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
		DanhMuc other = (DanhMuc) obj;
		if (maDanhMuc == null) {
			if (other.maDanhMuc != null)
				return false;
		} else if (!maDanhMuc.equals(other.maDanhMuc))
			return false;
		return true;
	}
	public DanhMuc(Integer maDanhMuc, String tenDanhMuc) {
		super();
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMuc = tenDanhMuc;
	}
	public DanhMuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DanhMuc [maDanhMuc=" + maDanhMuc + ", tenDanhMuc=" + tenDanhMuc + "]";
	}
	
}
