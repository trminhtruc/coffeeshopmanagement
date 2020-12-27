package daos;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.Query;

import entities.NhanVien;

public interface NhanVienDAO extends Remote{
	public NhanVien findId(String id) throws RemoteException;
	public List<NhanVien> listNhanVien()throws RemoteException;
	public boolean addNhanVien(NhanVien nhanvien) throws RemoteException;
	public boolean deleteNhanVien(String manhanvien) throws RemoteException;
	public boolean updateTenNhanVien(NhanVien nhanvien, String ten) throws RemoteException;
	public boolean updateCMNDNhanVien(NhanVien nhanvien, String cmnd) throws RemoteException;
	public boolean updateTrangThai(NhanVien nhanvien, String trangThai) throws RemoteException;
	public boolean updateSDT(NhanVien nhanVien,String sdt)throws RemoteException;
	public boolean updatePassWord(NhanVien nhanvien, String matKhauMoi) throws RemoteException;
	public boolean updateChucVu(NhanVien nhanvien, String chucVu)throws RemoteException;
}