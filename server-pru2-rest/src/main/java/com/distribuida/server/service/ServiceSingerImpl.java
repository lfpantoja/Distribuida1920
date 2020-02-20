package com.distribuida.server.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.distribuida.server.model.Singer;

@ApplicationScoped
public class ServiceSingerImpl implements ServiceSinger{
	
	//@Inject private DbProducer conn;
	
	//@Inject 
	//private EntityManager conn;
	
	//private PreparedStatement pst;
	//public static final String SELECT_SINGER = "SELECT e FROM singer e ORDER BY id;";
	public static final String SELECT_SINGER = "SELECT e FROM singer e";
	public static final String SELECT_SINGER_ID = "SELECT * FROM singer WHERE id = ?";
	public static final String INSERT_SINGER = "INSERT INTO singer (id, first_name, last_name, birth_date) VALUES(?,?,?,?);";
	public static final String DELETE_SINGER = "DELETE FROM singer WHERE id=?;";
	public static final String UPDATE_SINGER = "UPDATE singer SET id = ?, first_name = ?, last_name = ?, birth_date = ? WHERE id = ?;";
	
	//@Transactional(readOnly = true)
	//@Transactional
	
//	@PersistenceContext(unitName = "SingerPU")
//	private EntityManager cn;
	
	//@Inject	private EntityManager entityManager;
	//@PersistenceContext(name = "SingerPU")
    //private EntityManager entityManager;
	
	@Override
	public List<Singer> listSingers() {
		System.out.println("*****************************************Impl");
		//con JPA no vale
		//CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
		//cq.select(cq.from(Singer.class));
		//List<Singer> groups = entityManager.createQuery(cq).getResultList();
		//System.out.println(groups);
		//sin JPA funciona
		Singer ab = new Singer(1, "a", "n", null);
		List<Singer> aaa = new ArrayList<Singer>();
		aaa.add(ab);
		
		//System.out.println(this.manager.createQuery(SELECT_SINGER,Singer.class).getResultList());
		//System.out.println(entityManager.createQuery(SELECT_SINGER,Singer.class).getResultList());
		//conn.getEntityManager().createNamedQuery("singers.findAll", Singer.class).getResultList().toArray();
		//System.out.println(conn.getEntityManager().createNamedQuery("singers.findAll", Singer.class).getResultList().toArray(new Singer[0]));
		//conn.getEntityManager().createNativeQuery(sqlString)
		//conn.createEntityManagerFactory().createEntityManager().
		//conn.close(em);
		//System.out.println(conn.createEntityManagerFactory().createEntityManager().createQuery(SELECT_SINGER,Singer.class).getResultList());
		//List<Singer> list = Arrays.asList(conn.getEntityManager().createNamedQuery("singers.findAll", Singer.class).getResultList().toArray(new Singer[0]));
		//return list;
		return aaa;
	}

	@Override
	public Singer getSinger(Integer id) {
		Singer album = new Singer();
//		try {
//			Connection con = conn.getDataSource().getConnection();
//			pst = con.prepareStatement(SELECT_SINGER_ID);
//			pst.setInt(1, id);
//			ResultSet rs = pst.executeQuery();
//			while(rs.next()) {
//				album.setId(rs.getInt(1));
//				album.setFirstName(rs.getString(2));
//				album.setLastName(rs.getString(3));
//				album.setBirthDate(rs.getDate(4));
//				
//			}
//			con.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return album;
	}

	@Override
	public Singer addSinger(Singer e) {
		try {
//			Connection con = conn.getDataSource().getConnection();
//			pst = con.prepareStatement(INSERT_SINGER);
//			
//			pst.setInt(1, e.getId());
//			pst.setString(2, e.getFirstName());
//			pst.setString(3, e.getLastName());
//			java.sql.Date sDate = new java.sql.Date(e.getBirthDate().getTime());
//			pst.setDate(4,  sDate);
//			pst.executeQuery();
//			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	@Override
	public void deleteSinger(Integer id) {
		try {
//			Connection con = conn.getDataSource().getConnection();
//			pst = con.prepareStatement(DELETE_SINGER);
//			pst.setInt(1, id);
//			pst.executeQuery();
//			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Singer updateSinger(Integer id, Singer e) {
		try {
//			Connection con = conn.getDataSource().getConnection();
//			pst = con.prepareStatement(UPDATE_SINGER);
//			pst.setInt(1, e.getId());
//			pst.setString(2, e.getFirstName());
//			pst.setString(3, e.getLastName());
//			java.sql.Date sDate = new java.sql.Date(e.getBirthDate().getTime());
//			pst.setDate(4, sDate);
//			pst.setInt(5, id);
//			pst.executeQuery();
//			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		//java.sql.Date sDate = new java.sql.Date(e.getReleaseDate().getTime());
	
		return e;
	}
	
	

}
