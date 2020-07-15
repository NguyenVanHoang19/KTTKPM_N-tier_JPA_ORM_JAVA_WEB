package ejbs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.SanPham;

/**
 * Session Bean implementation class SanPhamEJB_CRUD
 */
@Stateless(mappedName="SanPhamEJB_CRUDRemote")
@LocalBean
public class SanPhamEJB_CRUD implements SanPhamEJB_CRUDRemote, SanPhamEJB_CRUDLocal {
	@PersistenceContext(unitName="WEBBANHANGEJB")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public SanPhamEJB_CRUD() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public SanPham addSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		em.persist(sanPham);
		return sanPham;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<SanPham> getAllSanPham() {
		// TODO Auto-generated method stub
		
		return em.createNativeQuery("select *from SanPham", SanPham.class).getResultList();
	}

	@Override
	public SanPham getSanPhamById(int id) {
		// TODO Auto-generated method stub
		return em.find(SanPham.class,id);
	}
	@Override
	public void suaSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		em.merge(sanPham);
	}
	@Override
	public void xoaSanPham(int id) {
		// TODO Auto-generated method stub
		em.remove(getSanPhamById(id));
	}
	
	@Override
	public List<SanPham> getAllSanPhambyTrangThai() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select * from SanPham s where s.TRANGTHAI='true'", SanPham.class).getResultList();
	}
	
	
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<SanPham> getAococtay() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select * from [dbo].[SanPham] sp join [dbo].[DanhMuc] dm on sp.MADANHMUC=dm.MADANHMUC where dm.[TENDANHMUC]=N'Áo Cộc Tay'", SanPham.class).getResultList();
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<SanPham>getSanPhamByten(String ten) {
		// TODO Auto-generated method stub
		String tenThuong = ten.toLowerCase().trim();
		List<SanPham> list=new ArrayList<SanPham>();
	//	 list=em.createNativeQuery("select [TENSANPHAM] from [dbo].[SanPham] where [TENSANPHAM] like '%"+ten+"%'",SanPham.class).getResultList();
		list = em.createNativeQuery("select *from SanPham", SanPham.class).getResultList();
		List<SanPham> listSP=new ArrayList<SanPham>();
		for(SanPham sanPham : list) {
			if(sanPham.getTenSanPham().toLowerCase().trim().contains(tenThuong)) {
				listSP.add(sanPham);
			}
		}
		return listSP;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<SanPham> getQuanJeanNam() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("\r\n" + 
				"select * from [dbo].[SanPham] sp join [dbo].[DanhMuc] dm on sp.MADANHMUC=dm.MADANHMUC where dm.[TENDANHMUC]=N'Quần Jean Nam'", SanPham.class).getResultList();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<SanPham> getAoSoMi() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select * from [dbo].[SanPham] sp join [dbo].[DanhMuc] dm on sp.MADANHMUC=dm.MADANHMUC where dm.[TENDANHMUC]=N'Áo Sơ Mi'", SanPham.class).getResultList();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<SanPham> getAoPhong() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select * from [dbo].[SanPham] sp join [dbo].[DanhMuc] dm on sp.MADANHMUC=dm.MADANHMUC where dm.[TENDANHMUC]=N'Áo Phông Nam'", SanPham.class).getResultList();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<SanPham> getAoThun() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select * from [dbo].[SanPham] sp join [dbo].[DanhMuc] dm on sp.MADANHMUC=dm.MADANHMUC where dm.[TENDANHMUC]=N'Áo Thun'", SanPham.class).getResultList();
	}
}
