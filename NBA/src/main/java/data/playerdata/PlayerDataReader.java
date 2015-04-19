package data.playerdata;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import data.common.Filter;
import po.PlayerPO;

public class PlayerDataReader implements PlayerDataReadService {
    
	private int birthYear=0;
	private int txtAge=0;

	public PlayerPO getPlayerPo(String playerName) {
		// TODO Auto-generated method stub
		PlayerPO result=new PlayerPO();
		Filter filter=new Filter();
		try {
			String path="data/players/info"+"/"+playerName;
			InputStream in=new FileInputStream(path);
			InputStreamReader inOne=new InputStreamReader(in,"UTF-8");
			
			BufferedReader inTwo=new BufferedReader(inOne);
			int row=1;
			
			String line=null;
	       
			while((line=inTwo.readLine())!=null)
			{
			  line=filter.filtPlayer(line);
			  StringBuffer sb=new StringBuffer(line);	
		      if(row==4)           //第4行为球员号码
		      {
		    	 sb=sb.delete(0, 6);
		    	 result.setNumber(sb.toString());
		      }
		      else if(row==6)
		      {
		    	  sb=sb.delete(0, 8);
		    	  result.setPosition(sb.toString());
		      }
		      else if(row==8)
		      {
		    	  sb=sb.delete(0, 6);
		    	  result.setHeight(sb.toString());
		      }
		      else if(row==10)
		      {
		    	  sb=sb.delete(0, 6);
		    	  result.setWeight(sb.toString());
		      }
		      else if(row==12)
		      {
		    	  sb=sb.delete(0, 5);
		    	  String birth=changeDate(sb.toString());
		    	  result.setBirth(birth);
		      }
		      else if(row==14)
		      {
		    	  sb=sb.delete(0, 3);
		    	  
		    	  int nowYear=Integer.parseInt(getYear());
		    	  int age=nowYear-birthYear;
		    	  result.setAge(String.valueOf(age));
		    	  txtAge=Integer.parseInt(sb.toString());
		    	    
		      }else if(row==16)
		      {
		    	  sb=sb.delete(0, 3);
		    	  if(isNumber(sb.toString()))
		    	  {	  
		    	  int txtExp=Integer.parseInt(sb.toString());
		    	  int exp=Integer.parseInt(result.getAge())-(txtAge-txtExp);
		    	  result.setExp(String.valueOf(exp));
		    	  }
		    	  else
		    		  result.setExp("Wrong");
		    	  
		       }
		      else if(row==18)
		      {
		    	  sb=sb.delete(0, 6);
		    	  result.setSchool(sb.toString());
		       }
		      row++;
		     }
			inTwo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    int length=playerName.length();
	    playerName=playerName.substring(0, length-4);
		result.setName(playerName);
		
		String actionPng="data/players/action/"+playerName+".png";
		String portraitImage="data/players/portrait/"+playerName+".png";
		
		
		
		Image actionImg=Toolkit.getDefaultToolkit().getImage(actionPng);
		Image portraitImg=Toolkit.getDefaultToolkit().getImage(portraitImage);
		
		
		
		
		result.setActionImage(actionImg);
		result.setPortaitImage(portraitImg);
		
		return result;
	}

	private String changeDate(String s){
		System.out.println(s);
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
			birthYear=Integer.parseInt(year);
		    String date=year+"-"+month+"-"+day;
	        
		    
		    boolean b1=(year==null);
		    boolean b2=(month==null);
		    boolean b3=(day==null);
		   
		    if(b1||b2||b3)
		    	return "Wrong";
	    	return date;
		
	}
	
	private  String getYear(){
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(d);
		return year;
	}
	
	private boolean isNumber(String s){
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
