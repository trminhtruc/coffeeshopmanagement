package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQueries({@NamedNativeQuery(name = "find-all-mAn",query = "{}",resultClass = MonAnUong.class)})
public class MonAnUong implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Id
	private String maMonAnUong;
	private String ten;	
	private double donGia;
	private String trangThai;
	private String loai;
	public String getMaMonAnUong() {
		return maMonAnUong;
	}
	public void setMaMonAnUong(String maMonAnUong) {
		this.maMonAnUong = maMonAnUong;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public double getDonGia() {
		return donGia;
	}
	
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public MonAnUong(String maMonAnUong,String loai, String ten, double donGia, String  trangThai) {
		super();
		this.maMonAnUong = maMonAnUong;
		this.ten = ten;
		this.loai= loai;
		this.donGia = donGia;
		this.trangThai = trangThai;
	}
	public MonAnUong() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MonAnUong [maMonAnUong=" + maMonAnUong + ", ten=" + ten + ", donGia=" + donGia + ", trangThai=" + trangThai
				+ "]";
	}
	
}
