package daos;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.Query;

import entities.ChiTietHoaDon;
import entities.MonAnUong;

public interface ChiTietHoaDonDAO extends Remote{

	public ChiTietHoaDon findID(String Id) throws RemoteException;
	public List<ChiTietHoaDon> findAll() throws RemoteException;
	public ChiTietHoaDon findAll2() throws RemoteException;
	public boolean updateChiTiet(String mamonan, int soluong) throws RemoteException;
	public boolean addChiTiet(ChiTietHoaDon chiTietHoaDon) throws RemoteException;
}
