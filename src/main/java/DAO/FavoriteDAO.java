package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import JPAConfig.Jpa;
import Model.Favorite;
import Model.Like;

public class FavoriteDAO extends AbstractDAO<Favorite>{
	public FavoriteDAO() {
		super(Favorite.class);
	}
	public List<Like> likeReport(){
		List<Like> list = null;
		String jpql = "select new Model.Like(f.video.videoId, count(f) )" + " from Favorite f  group by f.video.videoId ";
		EntityManager em = Jpa.getEntityManager();
		try {
			TypedQuery<Like> query = em.createQuery(jpql,Like.class);
			list = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			em.close();
		}
		return list;
	}
}
