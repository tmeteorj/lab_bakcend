package cn.edu.tju.cs.lab.oa.dal;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.edu.tju.cs.lab.oa.mysql.entities.Menu;

public class MenuDao {
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
	 
	public Menu select(String c)
	{
		List<Menu> s=getSession().createSQLQuery("select * from menu where menuid="+c).addEntity(Menu.class).list();
		if(s.size() > 0){
			return s.get(0);
		}else{
			return null;
		}
	}
	
	public List<Menu> GetDownMenu(String c)
	{
		//System.out.println("in dao");
		return getSession().createSQLQuery("select * from menu where parentid=" + c + " order by listorder").addEntity(Menu.class).list();
	}
	
	//获取所有顶层菜单
	public List<Menu> GetTopMenus(){
		return getSession().createSQLQuery("select * from menu where parentid = 0 order by listorder").addEntity(Menu.class).list();
	}
	
	public Boolean Addfunction(Map<String,String> datas){
		try{
			Menu item = new Menu();
			item.setName(datas.get("name"));
			item.setParentid(Integer.parseInt(datas.get("parentid")));
			item.setUrl(datas.get("url"));
			item.setDescription(datas.get("description"));
			item.setTarget(datas.get("target"));
			item.setStyle("");
			if(datas.get("isfolder").equals("0")){
				item.setIsfolder(false);
			}else{
				item.setIsfolder(true);
			}
			if(datas.get("isopen").equals("0")){
				item.setIsopen(false);
			}else{
				item.setIsopen(true);
			}
			if(datas.get("listorder").equals("")){
				item.setListorder(0);
			}else{
				item.setListorder(Integer.parseInt(datas.get("listorder")));
			}
			//System.out.println("session open:"+getSession().isOpen());
			getSession().save(item);
			getSession().flush();
			return true;
		}catch(Exception e){
			System.out.print(e.getMessage());
			return false;
		}
		
	}
	
	
	public Boolean deletefunction(String id){
		try{
			getSession().delete(select(id));
			getSession().flush();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	
	public Boolean UpdateFunction(Map<String,String> datas){
		try{
			Menu item = new Menu();
			item.setMenuid(Integer.parseInt(datas.get("menuid")));
			item.setName(datas.get("name"));
			item.setParentid(Integer.parseInt(datas.get("parentid")));
			item.setUrl(datas.get("url"));
			item.setDescription(datas.get("description"));
			item.setTarget(datas.get("target"));
			item.setStyle("");
			if(datas.get("isfolder").equals("0")){
				item.setIsfolder(false);
			}else{
				item.setIsfolder(true);
			}
			if(datas.get("isopen").equals("0")){
				item.setIsopen(false);
			}else{
				item.setIsopen(true);
			}
			if(datas.get("listorder").equals("")){
				item.setListorder(0);
			}else{
				item.setListorder(Integer.parseInt(datas.get("listorder")));
			}
			System.out.println(item.getName());
			getSession().update(item);
			getSession().flush();
			return true;
		}catch(Exception e){
			System.out.print(e.getMessage());
			return false;
		}
		
	}
	public Boolean UpdateFunction1(Map<String,String> datas){
		try{
			Menu item = new Menu();
			item.setMenuid(Integer.parseInt(datas.get("menuid")));
			item.setName(datas.get("name"));
			item.setParentid(Integer.parseInt(datas.get("parentid")));
			item.setUrl(datas.get("url"));
			item.setDescription(datas.get("description"));
			item.setTarget(datas.get("target"));
			item.setStyle("");
			if(datas.get("isfolder").equals("0")){
				item.setIsfolder(false);
			}else{
				item.setIsfolder(true);
			}
			if(datas.get("isopen").equals("0")){
				item.setIsopen(false);
			}else{
				item.setIsopen(true);
			}
			if(datas.get("listorder").equals("")){
				item.setListorder(0);
			}else{
				item.setListorder(Integer.parseInt(datas.get("listorder")));
			}
			getSession().update(item);
			getSession().flush();
			return true;
		}catch(Exception e){
			System.out.print(e.getMessage());
			return false;
		}
	}
}
