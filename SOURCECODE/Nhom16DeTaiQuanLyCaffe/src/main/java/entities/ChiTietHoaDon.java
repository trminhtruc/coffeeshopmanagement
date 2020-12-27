package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Embeddable
@NamedNativeQueries({ @NamedNativeQuery(name = "find-all-ct", query = "{}", resultClass = ChiTietHoaDon.class)	
})
public class ChiTietHoaDon implements Serializable {

	/**
	 * @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Type(type="objectid")
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private MonAnUong maAnUong;
	
	@Column(name = "soluongct")
	private int soluong;

	public ChiTietHoaDon(int soluong) {
		super();
		
		this.soluong = soluong;
	}

	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MonAnUong getMaAnUong() {
		return maAnUong;
	}

	public void setMaAnUong(MonAnUong maAnUong) {
		this.maAnUong = maAnUong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public double getSoluong() {
		return soluong;
	}

}
