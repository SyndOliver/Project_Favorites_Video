package edu.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.tuple.entity.EntityMetamodel;


import edu.poly.domain.FavoriteReport;
import edu.poly.domain.FavoriteShareReport;
import edu.poly.domain.FavoriteUserReport;
import edu.poly.domain.ListFavorite;
import edu.poly.model.Favorite;
import edu.poly.model.Video;

public class FavoriteDao extends AbstractEntityDao<Favorite> {

	public FavoriteDao() {
		super(Favorite.class);

	}
	public List<FavoriteShareReport>  reportsFavoriteShareByVideos(String videoId)
	{
		String jpql = " select new edu.poly.domain.FavoriteShareReport(f.username, f.videoId,f.emails,f.shareDate) "
				+ "from Share f where f.videoId = :videoId";
		EntityManager em = JpaUtils.getEntityManager();
		List<FavoriteShareReport> list = null;
		try {
			TypedQuery<FavoriteShareReport> query = em.createQuery(jpql, FavoriteShareReport.class);
			query.setParameter("videoId",videoId);
			list= query.getResultList();
		} finally {
			em.close();
		}
		return list;
		
	}
	
	public List<ListFavorite> listfavorite(String username)
	{
		String jpql = "select new edu.poly.domain.ListFavorite(f.user.username,f.video.videoId,"
				+ "f.likeDate, f.video.title,f.video.poster) from Favorite f where f.user.username =:username";
		EntityManager em = JpaUtils.getEntityManager();
		List<ListFavorite> list = null;
		try {
			TypedQuery<ListFavorite> query =  em.createNamedQuery(jpql,ListFavorite.class);
			query.setParameter("username", username);
			list =  query.getResultList();
			
		} finally {
			em.close();
		}
		return list;
	}
	
	
	
	public List<FavoriteUserReport> reportFavoriteUserByVideos(String videoId) {
		String jpql = "select new edu.poly.domain.FavoriteUserReport(f.user.username, f.user.fullname,"
				+ "f.user.email, f.likeDate) from Favorite f where f.video.videoId = :videoId";
		EntityManager em = JpaUtils.getEntityManager();
		List<FavoriteUserReport> list = null;
		try {
			TypedQuery<FavoriteUserReport> query = em.createQuery(jpql, FavoriteUserReport.class);
			query.setParameter("videoId",videoId);
			list= query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}

	public List<FavoriteReport> reportFavoriteByVideos() {
		String jpql = "Select new edu.poly.domain.FavoriteReport(f.video.title, count(f), min(f.likeDate), max(f.likeDate))"
				+ "from Favorite f group by f.video.title";

		EntityManager em = JpaUtils.getEntityManager();
		List<FavoriteReport> list = null;
		try {
			TypedQuery<FavoriteReport> query = em.createQuery(jpql, FavoriteReport.class);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}
	
	
	
	
	public List<Video> findAllByUserId(String username) {
		EntityManager en = JpaUtils.getEntityManager();
		try {
			String jpql = "SELECT v.video FROM Favorite v WHERE v.user.username = :username";	
			TypedQuery<Video> query = en.createQuery(jpql, Video.class);
			query.setParameter("username", username);
			List<Video> list = query.getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	public Favorite findOneByUserIdAndVideoId(String userId, String videoId)
	{
		EntityManager em = JpaUtils.getEntityManager();
		try {
			String sql = "SELECT f FROM Favorite f WHERE f.user.username =:userId and f.video.videoId =:videoId";
			TypedQuery<Favorite> query = em.createQuery(sql,Favorite.class);
			query.setParameter("userId", userId);
			query.setParameter("videoId", videoId);
			Favorite favorite = query.getSingleResult();
			return favorite;
			
		} catch (Exception e) {
			return null;
		}
		
		
	}

}
