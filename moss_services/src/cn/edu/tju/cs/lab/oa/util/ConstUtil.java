package cn.edu.tju.cs.lab.oa.util;

import com.alibaba.fastjson.JSONObject;

public class ConstUtil {
	public static JSONObject JSON_PARAM_FORTMAT_ERROR;
    public static JSONObject JSON_MYSQL_QUERY_ERROR;
    static{
        JSON_PARAM_FORTMAT_ERROR=new JSONObject();
        JSON_PARAM_FORTMAT_ERROR.put("code",1);
        JSON_PARAM_FORTMAT_ERROR.put("msg","parameter format error");

        JSON_MYSQL_QUERY_ERROR=new JSONObject();
        JSON_MYSQL_QUERY_ERROR.put("code",2);
        JSON_MYSQL_QUERY_ERROR.put("msg","SQL query failed");
    }
}
