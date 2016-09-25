package cn.edu.tju.cs.lab.oa.mysql.entities;

import java.util.List;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu implements java.io.Serializable {

	// Fields

	private Integer menuid;
	private Integer parentid;
	private String name;
	private String url;
	private String description;
	private String target;
	private String style;
	private Boolean isfolder;
	private Boolean isopen;
	private Integer listorder;
	private List<Menu> submenus;

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** full constructor */
	public Menu(Integer parentid, String name, String url, String description,
			String target, String style, Boolean isfolder, Boolean isopen,
			Integer listorder) {
		this.parentid = parentid;
		this.name = name;
		this.url = url;
		this.description = description;
		this.target = target;
		this.style = style;
		this.isfolder = isfolder;
		this.isopen = isopen;
		this.listorder = listorder;
		this.submenus = null;
	}

	// Property accessors

	public Integer getMenuid() {
		return this.menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Boolean getIsfolder() {
		return this.isfolder;
	}

	public void setIsfolder(Boolean isfolder) {
		this.isfolder = isfolder;
	}

	public Boolean getIsopen() {
		return this.isopen;
	}

	public void setIsopen(Boolean isopen) {
		this.isopen = isopen;
	}

	public Integer getListorder() {
		return this.listorder;
	}

	public void setListorder(Integer listorder) {
		this.listorder = listorder;
	}
	
	public List<Menu> getsubmenus(){
		return this.submenus;
	}
	
	public void setsubmenus(List<Menu> menus){
		this.submenus = menus;
	}

}