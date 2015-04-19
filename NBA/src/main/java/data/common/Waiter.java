package data.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Waiter {

	
	/*changeDate方法
	 * 将类似于‘JAN141985’这样的生日改写成‘1985-1-14’
	 * 如果输入的字符串不是符合 mdddyyyy格式，则返回字符串‘wrong’
	*/
	
	
	public String changeDate(String s){
		
		StringBuffer sb=new StringBuffer(s);
		String sMonth=sb.substring(0, 3);
		String month=null;
		
		
		if(!sMonth.equals("SEP"))
		{
			if(sMonth.equals("JAN"))
	    	  month="1";
	        else if(sMonth.equals("FEB"))
	    	  month="2";
	        else if(sMonth.equals("MAR"))
	          month="3";
	        else if(sMonth.equals("APR"))
	          month="4";
	        else if(sMonth.equals("MAY"))
	          month="5";
	        else if(sMonth.equals("JUN"))
	          month="6";
	        else if(sMonth.equals("JUL"))
	          month="7";
	        else if(sMonth.equals("AUG"))
	          month="8";
	        else if(sMonth.equals("OCT"))
	          month="10";
	        else if(sMonth.equals("NOV"))
	          month="11";
	        else if(sMonth.equals("DEC"))
	          month="12";
			
			sb=sb.delete(0, 3);
		}
		else
		{
			month="9";
			sb=sb.delete(0, 4);
		}
			
		
		    String day=sb.substring(0, 2);
			String year=sb.substring(2);
			
		    String date=year+"-"+month+"-"+day;
	        
		    
		    boolean b1=(year==null);
		    boolean b2=(month==null);
		    boolean b3=(day==null);
		   
		    if(b1||b2||b3)
		    	return "Wrong";
	    	return date;
		
	}

	
	/*getYear()方法
	 * 返回系统当前的年份
	 */
	
	public  String getYear(){
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(d);
		return year;
	}
	
	
	/*isNumber方法
	 * 确定一个字符串是否为数字格式
	 * 
	 */
	
	public boolean isNumber(String s){
		char ch[]=s.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			boolean b=(ch[i]>='0')&&(ch[i]<='9');
			if(!b)
			{
				return false;
			}
		}
		return true;
	}
	
	
}
