package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.TaiKhoan;

/**
 * Session Bean implementation class TaiKhoanEJB_CRUD
 */
@Stateless(mappedName="TaiKhoanEJB_Remote")
@LocalBean
public class TaiKhoanEJB_CRUD implements TaiKhoanEJB_CRUDRemote, TaiKhoanEJB_CRUDLocal {
	@PersistenceContext(unitName="WEBBANHANGEJB")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public TaiKhoanEJB_CRUD() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public TaiKhoan addTaiKhoan(TaiKhoan taiKhoan) {
		// TODO Auto-generated method s
		em.persist(taiKhoan);
		return taiKhoan;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<TaiKhoan> getAllTaiKhoan() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select *from TaiKhoan", TaiKhoan.class).getResultList();
	}

	@Override
	public TaiKhoan getTaiKhoanById(String id) {
		// TODO Auto-generated method stub
		return em.find(TaiKhoan.class, id);
	}

	@Override
	public List<TaiKhoan> getTaiKhoanByIdAndMK(String tenTaiKhoan, String matKhau) {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select *from dbo.TaiKhoan where TenTaiKhoan = '"+tenTaiKhoan+"' and MATKHAU='"+matKhau+"'", TaiKhoan.class).getResultList();
	}

}
