package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;

@Entity
@NamedNativeQueries({@NamedNativeQuery(name = "find-all-hd",query = "{}",resultClass = HoaDon.class)})
public class HoaDon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String maHoaDon;
	private LocalDate ngayLap;
	private String tinhTrang;
	private String soBan;
	
	@ElementCollection(fetch =FetchType.EAGER)
	private List<ChiTietHoaDon> cthd = new ArrayList<ChiTietHoaDon>();
	
	@ManyToOne 
	private NhanVien nhanVien;
//	private nhan maNhanVien;
	
	public HoaDon(String maHoaDon, LocalDate ngayLap,String tinhTrang) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.tinhTrang = tinhTrang;
	}

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}
	

	public List<ChiTietHoaDon> getCthd() {
		return cthd;
	}

	public void setCthd(List<ChiTietHoaDon> cthd) {
		this.cthd = cthd;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

//	public String getMaNhanVien() {
//		return maNhanVien;
//	}
//
//	public void setMaNhanVien(String maNhanVien) {
//		this.maNhanVien = maNhanVien;
//	}

	public String getSoBan() {
		return soBan;
	}

	public void setSoBan(String soBan) {
		this.soBan = soBan;
	}

	public double tinhThanhTien() {
		double tongtien= 0 ;
		for (ChiTietHoaDon chiTietHoaDon : cthd) {
			tongtien +=chiTietHoaDon.getSoluong()*chiTietHoaDon.getMaAnUong().getDonGia();
		}
		return tongtien;
	}
}
