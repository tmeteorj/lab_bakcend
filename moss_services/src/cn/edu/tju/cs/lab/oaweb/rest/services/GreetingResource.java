package cn.edu.tju.cs.lab.oaweb.rest.services;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.edu.tju.cs.lab.oa.models.impl.MenuServiceImpl;
import cn.edu.tju.cs.lab.oa.mysql.entities.Menu;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Component
@Path("/SmartCity")
public class GreetingResource {
	
	//将前台返回来的数据组合成一个Map
	private Map<String,String> splitdata(String data){
		data = data.substring(1);
		data = data.substring(0,data.length()-1);
		String[] items = data.split(", ");
		Map<String,String> values = new HashMap<String,String>(); 
		int i;
		for(i=0;i<items.length;i++){
			String item = items[i];
			String name,value;
			int spin = item.indexOf("=");
			name = item.substring(0,spin);
			value = item.substring(spin+1);
			values.put(name, value);
		}
		return values;
	}
	
	//Menu服务
	private MenuServiceImpl menuservice;
	
	public MenuServiceImpl getmenuservice(){
		return menuservice;
	}
	
	public void setMenuService(MenuServiceImpl menuservice){
		this.menuservice = menuservice;
	}
	
		/*
		 * @author:田强
		 * @function:返回Menu的下层菜单
		 */
		@GET
		@Path("/getdownmenu/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Menu> getdownmenu(@Context HttpServletResponse response,@PathParam("id")String id)
		{
			try{
				response.addHeader("Access-Control-Allow-Origin", "*");
		        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		        response.addHeader("Access-Control-Max-Age", "1728000");
				return menuservice.getdownmenus(id);
			}catch(Exception E){
				System.out.println(E.getMessage());
				return null;
			}
		}
		
		/*
		 * @author:田强
		 * @function:返回所有顶层菜单
		 */
		@GET
		@Path("/gettopmenus")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Menu> gettopmenus()
		{
			try{
				
				System.out.println("asdfasgsagsagd");
				return menuservice.gettopmenus();
			}catch(Exception E){
				System.out.println(E.getMessage());
				return null;
			}
		}
		
		
		/*
		 * @author:田强
		 * @function:返回所有菜单
		 */
		@GET
		@Path("/getallmenus/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Menu> getallmenus(@PathParam("id")String id)
		{
			try{
				return menuservice.getallmenus(id);
			}catch(Exception E){
				System.out.println(E.getMessage());
				return null;
			}
		}
		
		/*
		 * @author:田强
		 * @function:根据ID返回对应的菜单内容
		 */
		@GET
		@Path("/getmenuitem/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Menu getMenuItem(@PathParam("id")String id){
			try{
				return menuservice.select(id);
			}catch(Exception e){
				System.out.println(e.getMessage());
				return null;
			}
		}
		
		/*
		 * @author:田强
		 * @function:根据前台传来的数据在数据库中添加一条功能记录
		 */
		@POST
		@Path("/addfunction")
		@Produces(MediaType.APPLICATION_JSON)
		public boolean addfunction(@FormParam("data") String data)
		{
			//System.out.println(data);
			Map<String,String> datas = splitdata(data);
			return menuservice.addfunction(datas);
		}
		
		
		/*
		 * @author:田强
		 * @function:根据ID删除某个功能
		 */
		@GET
		@Path("/deletefunction/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Boolean deletefunction(@PathParam("id")String id){
			try{
				System.out.println("删除功能");
				return menuservice.deletefunction(id);
			}catch(Exception e){
				System.out.println(e.getMessage());
				return false;
			}
		}
		
		
		/*
		 * @author:田强
		 * @function:修改功能数据内容
		 */
		@POST
		@Path("/updatefunction")
		@Produces(MediaType.APPLICATION_JSON)
		public boolean updatefunction(@FormParam("data") String data)
		{
			System.out.println("dddd:"+data);
			Map<String,String> datas = splitdata(data);		
			return menuservice.updatefunction(datas);
		}
		
}
