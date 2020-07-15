package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.DanhMuc;

/**
 * Session Bean implementation class DanhMucEJB_CRUD
 */
@Stateless(mappedName="DanhMucEJB_CRUDRemote")
@LocalBean
public class DanhMucEJB_CRUD implements DanhMucEJB_CRUDRemote, DanhMucEJB_CRUDLocal {
	@PersistenceContext(unitName="WEBBANHANGEJB")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public DanhMucEJB_CRUD() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public DanhMuc addDanhMuc(DanhMuc danhMuc) {
		// TODO Auto-generated method stub
		em.persist(danhMuc);
		return danhMuc;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<DanhMuc> getAllDanhMuc() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select *from DanhMuc",DanhMuc.class).getResultList();
	}
	@Override
	public DanhMuc getDanhMuc(int id) {
		// TODO Auto-generated method stub
		return em.find(DanhMuc.class, id);
	}

	@Override
	public DanhMuc getDanhMucbyTen(String ten) {
		// TODO Auto-generated method stub
		return (DanhMuc) em.createNativeQuery("select * from DanhMuc d where d.TENDANHMUC = N'"+ten+"'", DanhMuc.class).getResultList().get(0);
	}
}
