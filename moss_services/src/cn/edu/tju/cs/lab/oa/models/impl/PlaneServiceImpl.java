package cn.edu.tju.cs.lab.oa.models.impl;

import java.util.List;

import cn.edu.tju.cs.lab.oa.dal.PlaneDao;
import cn.edu.tju.cs.lab.oa.mysql.entities.Plane;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class PlaneServiceImpl {

	PlaneDao planeDao;
	
	public PlaneDao getPlaneDao() {
		return planeDao;
	}

	public void setPlaneDao(PlaneDao planeDao) {
		this.planeDao = planeDao;
	}
	public JSONObject searchByYMA(String year, String month, String attr) {
		String sql=String.format("select * from plane "+
                "where year=%s and month=%s",year,month);
		List<Plane> list=planeDao.getPlaneBySQL(sql);
		JSONArray data = new JSONArray();
        for (Plane plane:list) {
            data.add(plane.toMapJSON(attr));
        }
        JSONObject result = new JSONObject();
        result.put("data", data);
        result.put("msg", "success");
        result.put("code", 0);
        return result;
	}

	public JSONObject searchByPID(String pid) {
		return null;
	}
}
