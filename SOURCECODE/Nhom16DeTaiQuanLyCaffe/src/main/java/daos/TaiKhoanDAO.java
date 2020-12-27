package daos;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.Query;

import entities.TaiKhoan;

public interface TaiKhoanDAO extends Remote{
	public TaiKhoan findId(String id) throws RemoteException;
	public List<TaiKhoan> listTaiKhoan()throws RemoteException;
	public boolean addTaiKhoan(TaiKhoan taikhoan) throws RemoteException;
	public boolean deleteTaiKhoanId(String id) throws RemoteException;
	public boolean updateTaiKhoan(TaiKhoan taikhoan,String matKhau) throws RemoteException;
}
