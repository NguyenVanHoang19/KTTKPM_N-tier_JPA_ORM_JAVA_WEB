package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.DonHang;

/**
 * Session Bean implementation class DonHangEJB_CRUD
 */
@Stateless(mappedName="DonHangEJB_CRUDRemote")
@LocalBean
public class DonHangEJB_CRUD implements DonHangEJB_CRUDRemote, DonHangEJB_CRUDLocal {
	@PersistenceContext(unitName="WEBBANHANGEJB")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public DonHangEJB_CRUD() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public DonHang addDonHang(DonHang donHang) {
		// TODO Auto-generated method stub
		em.persist(donHang);
		return donHang;
	}

	@Override
	public int getIdMax() {
		// TODO Auto-generated method stub
		List<DonHang> list = em.createNativeQuery("select *from DonHang", DonHang.class).getResultList();
		int maxId = 1 ;
		for(DonHang dh : list) {
			if(maxId < dh.getMaDonHang()) {
				maxId = dh.getMaDonHang();
			}
		}
		return maxId;
	}

	@Override
	public List<DonHang> getAllDonHang() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select *from DonHang", DonHang.class).getResultList();
	}

	@Override
	public List<DonHang> getAllDonHangbyMaKhachHang(int maKhacHang) {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select * from DonHang d where d.MAKHACHHANG="+maKhacHang+"", DonHang.class).getResultList();
	}

}
