package cn.edu.tju.cs.lab.oa.models.impl;
import java.util.List;
import java.util.Map;

import cn.edu.tju.cs.lab.oa.dal.MenuDao;
import cn.edu.tju.cs.lab.oa.mysql.entities.Menu;
public class MenuServiceImpl {
	private MenuDao mymenudao;

	public MenuDao getMymenudao() {
		return mymenudao;
	}

	public void setMymenudao(MenuDao mymenudao) {
		this.mymenudao = mymenudao;
	}

	public MenuDao getmenudao() {
		return mymenudao;
	}

	public void setmymenudao(MenuDao menudao) {
		this.mymenudao = menudao;
	}
	
	public Menu select(String c)
	{
		return mymenudao.select(c);
	}
    
	public List<Menu> getdownmenus(String c)
	{
		return mymenudao.GetDownMenu(c);
	}
	
	public List<Menu> gettopmenus()
	{
		return mymenudao.GetTopMenus();
	}
	
	public List<Menu> getallmenus(String deep)
	{
		List<Menu> menus = mymenudao.GetTopMenus();
		int i,j;
		for(i=0;i<menus.size();i++){
			int id = menus.get(i).getMenuid();
			List<Menu> submenus = mymenudao.GetDownMenu(String.valueOf(id));
			for(j=0;j<submenus.size();j++){
				int subid = submenus.get(j).getMenuid();
				List<Menu> subbmenus = mymenudao.GetDownMenu(String.valueOf(subid));
				if(subbmenus.size()>0){
					submenus.get(j).setsubmenus(subbmenus);
				}else{
					submenus.get(j).setsubmenus(null);
				}
			}
			if(submenus.size()>0){
				menus.get(i).setsubmenus(submenus);
			}else{
				menus.get(i).setsubmenus(null);
			}
		}
		return menus;
	}
	
	public Boolean addfunction(Map<String,String> datas){
		try{
			if(mymenudao.Addfunction(datas)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public Boolean deletefunction(String id){
		return mymenudao.deletefunction(id);
	}
	
	
	public Boolean updatefunction(Map<String,String> datas){
		try{
			if(mymenudao.UpdateFunction(datas)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}
}
