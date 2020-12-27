package daos;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.Query;

import entities.MonAnUong;

public interface MonAnUongDAO extends Remote{
	public MonAnUong findAll(String Id) throws RemoteException;
	public MonAnUong findId(String id) throws RemoteException;
	public List<MonAnUong> listMonAnUong()throws RemoteException;
	public boolean addMonAnUong(MonAnUong monanuong)throws RemoteException;
	public boolean updateMonAnUongTen(MonAnUong monanuong, String ten) throws RemoteException;
	public boolean updateMonAnUongDonGia(MonAnUong monanuong, double dongia)throws RemoteException;
	public boolean updateTrangThai(MonAnUong monanuong,String trangThai) throws RemoteException;	
}
