package ejbs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.NguoiQuanLy;

/**
 * Session Bean implementation class NguoiQuanLyEJB_CRUD
 */
@Stateless(mappedName="NguoiQuanLyEJB_CRUDRemote")
@LocalBean
public class NguoiQuanLyEJB_CRUD implements NguoiQuanLyEJB_CRUDRemote, NguoiQuanLyEJB_CRUDLocal {
	@PersistenceContext(unitName="WEBBANHANGEJB")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public NguoiQuanLyEJB_CRUD() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public NguoiQuanLy addNguoiQuanLy(NguoiQuanLy nguoiQuanLy) {
		// TODO Auto-generated method stub
		em.persist(nguoiQuanLy);
		return nguoiQuanLy;
	}

}
