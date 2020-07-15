package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.ChiTietDonHang;

/**
 * Session Bean implementation class ChiTietDonHangEJB_CRUD
 */
@Stateless(mappedName="ChiTietDonHangEJB_CRUDRemote")
@LocalBean
public class ChiTietDonHangEJB_CRUD implements ChiTietDonHangEJB_CRUDRemote, ChiTietDonHangEJB_CRUDLocal {
	@PersistenceContext(unitName="WEBBANHANGEJB")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ChiTietDonHangEJB_CRUD() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public ChiTietDonHang addChiTietDonHang(ChiTietDonHang chiTietDonHang) {
		// TODO Auto-generated method stub
		em.persist(chiTietDonHang);
		return chiTietDonHang;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ChiTietDonHang> getAllChiTietDonHang() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select *from ChiTietDonHang", ChiTietDonHang.class).getResultList();
	}
	@Override
	public List<ChiTietDonHang> getChiTietDonHang(int maDonHang) {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select * from ChiTietDonHang c where c.MADONHANG="+maDonHang+"", ChiTietDonHang.class).getResultList();
	}

	@Override
	public List<ChiTietDonHang> getAllChiTietDonHangbyDonHang(int maDonHang) {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select * from ChiTietDonHang c where c.MADONHANG="+maDonHang+"", ChiTietDonHang.class).getResultList();
	}
}
