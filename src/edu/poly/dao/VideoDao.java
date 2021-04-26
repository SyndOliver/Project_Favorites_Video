package edu.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import edu.poly.model.User;
import edu.poly.model.Video;

public class VideoDao extends AbstractEntityDao<Video> {

	public VideoDao() {
		super(Video.class);
		
	}
	
	public List<Video> findAll(int page)
	{
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "SELECT o from Video o ORDER BY o.views DESC";
		TypedQuery<Video> query = em.createQuery(jpql,Video.class);
		query.setFirstResult(page*8);
		query.setMaxResults(8);
		List<Video> list = query.getResultList();
		return list;
		
	}
	
	public Long getTotal() {

		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "SELECT COUNT(*) FROM Video";
		TypedQuery<Long> query = em.createQuery(jpql,Long.class);
		return (long)Math.ceil(query.getSingleResult()/8.0);
	}
	
}
