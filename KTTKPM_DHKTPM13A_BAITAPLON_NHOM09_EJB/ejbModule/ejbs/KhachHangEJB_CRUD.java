package ejbs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.KhachHang;

/**
 * Session Bean implementation class KhachHangEJB_CRUD
 */
@Stateless(mappedName="KhachHangEJB_Remote")
@LocalBean
public class KhachHangEJB_CRUD implements KhachHangEJB_CRUDRemote, KhachHangEJB_CRUDLocal {
	@PersistenceContext(unitName="WEBBANHANGEJB")
	private EntityManager em ;
    /**
     * Default constructor. 
     */
    public KhachHangEJB_CRUD() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public KhachHang addKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		em.persist(khachHang);
		return khachHang;
	}
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<KhachHang> getAllKhachHang() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select *from KhachHang", KhachHang.class).getResultList();
	}
	@Override
	public KhachHang updateKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		em.merge(khachHang);
		return khachHang;
	}
	@Override
	public KhachHang getKhachHangByTaiKhoan(String tenTaiKhoan) {
		// TODO Auto-generated method stub
		KhachHang khachHang = null;
		List<KhachHang> list = new ArrayList<KhachHang>();
		list = em.createNativeQuery("select *from dbo.KhachHang where TENTAIKHOAN = '"+tenTaiKhoan+"'", KhachHang.class).getResultList();
		for(KhachHang kh : list ) {
			khachHang = kh;
		}
		if(khachHang==null)
			return null;
		else
			return khachHang;
		 
	}
	@Override
	public KhachHang getKhachHangById(int id) {
		// TODO Auto-generated method stub
		return em.find(KhachHang.class, id);
	}

}
