package cn.edu.tju.cs.lab.oa.dal;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.edu.tju.cs.lab.oa.mysql.entities.Plane;


public class PlaneDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	 
	public List<Plane> getPlaneBySQL(String sql){
		return getSession().createSQLQuery(sql).addEntity(Plane.class).list();
	}
	public Plane getPlaneById(int id){
		List<Plane> list=getSession().createSQLQuery("select * from plane where id="+id).addEntity(Plane.class).list();
		if(list==null||list.size()==0)return null;
		return list.get(0);
	}
	
	public Boolean deleteById(int id){
		try{
			getSession().delete(getPlaneById(id));
			getSession().flush();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
}
