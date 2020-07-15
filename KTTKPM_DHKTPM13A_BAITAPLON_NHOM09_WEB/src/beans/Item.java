package beans;

import entities.SanPham;

public class Item {
	private int id;
	private String tenSanpham;
	private String urlHinhAnh;
	private float donGia;
	private int soLuong;
	private int soLuongConTrongKho;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenSanpham() {
		return tenSanpham;
	}
	public void setTenSanpham(String tenSanpham) {
		this.tenSanpham = tenSanpham;
	}
	public String getUrlHinhAnh() {
		return urlHinhAnh;
	}
	public void setUrlHinhAnh(String urlHinhAnh) {
		this.urlHinhAnh = urlHinhAnh;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	public int getSoLuongConTrongKho() {
		return soLuongConTrongKho;
	}
	public void setSoLuongConTrongKho(int soLuongConTrongKho) {
		this.soLuongConTrongKho = soLuongConTrongKho;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public Item(int id, String tenSanpham, String urlHinhAnh, float donGia, int soLuong, int soLuongConTrongKho) {
		super();
		this.id = id;
		this.tenSanpham = tenSanpham;
		this.urlHinhAnh = urlHinhAnh;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.soLuongConTrongKho = soLuongConTrongKho;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", tenSanpham=" + tenSanpham + ", urlHinhAnh=" + urlHinhAnh + ", donGia=" + donGia
				+ ", soLuong=" + soLuong + ", soLuongConTrongKho=" + soLuongConTrongKho + "]";
	}
	
	
	
	
}
