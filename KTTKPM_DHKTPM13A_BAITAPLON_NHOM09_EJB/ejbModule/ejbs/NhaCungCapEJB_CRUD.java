package ejbs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.NhaCungCap;

/**
 * Session Bean implementation class NhaCungCapEJB_CRUD
 */
@Stateless(mappedName="NhaCungCapEJB_CRUDRemote")
@LocalBean
public class NhaCungCapEJB_CRUD implements NhaCungCapEJB_CRUDRemote, NhaCungCapEJB_CRUDLocal {
	@PersistenceContext(unitName="WEBBANHANGEJB")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public NhaCungCapEJB_CRUD() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public NhaCungCap addNhaCungCap(NhaCungCap nhaCungCap) {
		// TODO Auto-generated method stub
		em.persist(nhaCungCap);
		return nhaCungCap;
	}
	@Override
	public List<NhaCungCap> getALLNCC() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select * from NhaCungCap", NhaCungCap.class).getResultList();
	}

	@Override
	public NhaCungCap getNhaCungCap(int manhaCungCap) {
		// TODO Auto-generated method stub
		return em.find(NhaCungCap.class, manhaCungCap);
	}

	@Override
	public NhaCungCap getNhaCungCapbyTen(String ten) {
		// TODO Auto-generated method stub
		return (NhaCungCap) em.createNativeQuery("select * from NhaCungCap n where n.TENNHACUNGCAP= N'"+ten+"'", NhaCungCap.class).getResultList().get(0);
	}
	
}
