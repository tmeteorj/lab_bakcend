package cn.edu.tju.cs.lab.oa.mysql.entities;

import com.alibaba.fastjson.JSONObject;

/**
 * Plane entity. @author MyEclipse Persistence Tools
 */

public class Plane implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer planeId;
	private Integer year;
	private Integer month;
	private Double lng;
	private Double lat;
	private String polygon;
	private String attr;
	private JSONObject js_polygon;
	private JSONObject js_attr;

	// Constructors

	/** default constructor */
	public Plane() {
	}

	/** minimal constructor */
	public Plane(Integer planeId) {
		this.planeId = planeId;
	}

	/** full constructor */
	public Plane(Integer planeId, Integer year, Integer month, Double lng,
			Double lat, String polygon, String attr) {
		this.planeId = planeId;
		this.year = year;
		this.month = month;
		this.lng = lng;
		this.lat = lat;
		this.polygon = polygon;
		this.attr = attr;
	}

	public void generateJSON(){
		if(js_polygon==null)js_polygon=JSONObject.parseObject(polygon);
		if(js_attr==null)js_attr=JSONObject.parseObject(attr);
	}
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPlaneId() {
		return this.planeId;
	}

	public void setPlaneId(Integer planeId) {
		this.planeId = planeId;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return this.month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Double getLng() {
		return this.lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return this.lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public String getPolygon() {
		return this.polygon;
	}

	public void setPolygon(String polygon) {
		this.polygon = polygon;
	}

	public String getAttr() {
		return this.attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}
	
	public JSONObject toMapJSON(String type){
		generateJSON();
        JSONObject json=new JSONObject();
        json.put("planeid", planeId);
        json.put("lng",lng);
        json.put("lat",lat);
        json.put("polygon",js_polygon.get("edge"));
        if(type==null||!js_attr.containsKey(type)) json.put("attr",js_attr);
        else{
            JSONObject single=new JSONObject();
            single.put(type,js_attr.get(type));
            json.put("attr",single);
        }
        return json;
    }

}