package daos;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


import entities.ChiTietHoaDon;
import entities.HoaDon;

public interface HoaDonDAO extends Remote{
	public HoaDon findId(String id) throws RemoteException;
	public List<HoaDon> listHoaDon()throws RemoteException;
	public boolean addHoaDon(HoaDon hoaodon) throws RemoteException;
	public boolean deleteHoaDon(String id) throws RemoteException;
	public boolean updateTinhTrangHoaDon(HoaDon hoadon,String tinhTrang)throws RemoteException;
	public boolean updateChiTietHoaDon(HoaDon hoadon,List<ChiTietHoaDon> cthd)throws RemoteException;
	
}
