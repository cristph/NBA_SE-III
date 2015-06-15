package data.dataloader;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Judger {

	
	private static HashMap<String,String> pMap=null;
	
	static
	{
		pMap=new HashMap<String,String>();
		pMap.put("2012-2013", "2013-04-17");
		pMap.put("2013-2014", "2014-04-17");
		pMap.put("2014-2015", "2015-04-17");
		
	}
	
	public static String judge(String date)
	{
		String season=getSeason(date);
		String beginDate=pMap.get(season);
	    
		if(season!=null)
	    {
	    String s1[]=beginDate.split("-");
	    Calendar cal1=Calendar.getInstance();
	    cal1.set(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]), Integer.parseInt(s1[2]));
	    Date bDate=cal1.getTime();
	    
	    String s2[]=date.split("-");
	    Calendar cal2=Calendar.getInstance();
	    cal2.set(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]), Integer.parseInt(s2[2]));
	    Date mDate=cal2.getTime();
	    
	    
	    boolean p=mDate.after(bDate);
	    if(p)
           return "P";		
	    else
	       return "R";
	    }
	    return "p";
	}
	public static String getSeason(String date){
		String season=null;
		String d_arr[]=date.split("-");
		int month=Integer.parseInt(d_arr[1]);
		if(month>=7)
		{
			season=d_arr[0]+"-"+(Integer.parseInt(d_arr[0])+1);
		}
		else
		{
			season=(Integer.parseInt(d_arr[0])-1)+"-"+d_arr[0];
		}
		return season;
		
	}
	
}
