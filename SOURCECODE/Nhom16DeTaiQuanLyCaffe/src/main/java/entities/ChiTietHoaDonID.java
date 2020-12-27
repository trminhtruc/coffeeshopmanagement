package entities;
import java.rmi.activation.*;
import java.io.Serializable;

import javax.persistence.Embeddable;

/*@Embeddable*/
public class ChiTietHoaDonID implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mamonan;
	
	public String getMaHoaDon() {
		return mamonan;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.mamonan = maHoaDon;
	}
	
	public ChiTietHoaDonID(String maHoaDon) {
		super();
		this.mamonan = maHoaDon;
	}

	public ChiTietHoaDonID() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mamonan == null) ? 0 : mamonan.hashCode());
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
		ChiTietHoaDonID other = (ChiTietHoaDonID) obj;
		if (mamonan == null) {
			if (other.mamonan != null)
				return false;
		} else if (!mamonan.equals(other.mamonan))
			return false;
		return true;
	}
}
