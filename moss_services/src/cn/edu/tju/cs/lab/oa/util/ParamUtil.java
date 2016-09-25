package cn.edu.tju.cs.lab.oa.util;

import javax.servlet.http.HttpServletResponse;

public class ParamUtil {
	public static void AddCross(HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
	}
	
	public static boolean isInteger(String s){
        try{
            if(isEmpty(s))return false;
            Integer.parseInt(s);
        }catch (Exception e){
            return false;
        }
        return true;
    }
	
    public static boolean isEmpty(String s){
        return s==null||s.length()==0;
    }
}
