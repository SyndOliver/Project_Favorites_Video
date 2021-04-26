package edu.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.poly.domain.ShareUserReport;
import edu.poly.model.Share;

public class ShareDao extends AbstractEntityDao<Share> {

	public ShareDao() {
		super(Share.class);
		
	}
	public List<ShareUserReport> reportShareUserByVideos(String videoId)
	{
		String jpql = "SELECT new edu.poly.domain.ShareUserReport(f.user.username, f.user.email,"
				+ "f.emails, f.shareDate) from Share f where f.video.videoId =:videoId";
		
		EntityManager em = JpaUtils.getEntityManager();
		List<ShareUserReport> list = null;
		try {
			TypedQuery<ShareUserReport> query = em.createQuery(jpql,ShareUserReport.class);
			query.setParameter("videoId", videoId);
			list =  query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}
	
	
	
	
}
