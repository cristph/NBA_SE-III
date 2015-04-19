package data.funddata;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import data.common.Filter;
import data.common.Waiter;
import po.PlayerPO;
import po.TeamPO;

public class FundDataReader implements FundDataReadService {

	
	public ArrayList<TeamPO> readTeamFile(File txtFile,File imgFold) {
		// TODO Auto-generated method stub
        ArrayList<TeamPO> result=new ArrayList<TeamPO>();
		
		try 
		{
			Filter filter=new Filter();
			InputStream in=new FileInputStream(txtFile);
			InputStreamReader 	inOne = new InputStreamReader(in,"UTF-8");
			BufferedReader inTwo=new BufferedReader(inOne);
			String line=inTwo.readLine();
			int row=1;
			while((line=inTwo.readLine())!=null)
			{
				if(row<=30)
				{
				  line=filter.filtTeam(line);
				
				  String info[]=line.split("│");
				  TeamPO temp=new TeamPO();
				  temp.setTeamName(info[0]);
				  temp.setShortName(info[1]);
				  temp.setLocation(info[2]);
				  temp.setCompArea(info[3]);
				  temp.setZone(info[4]);
				  temp.setHome(info[5]);
				  temp.setBirthday(info[6]);
				  Image teamImg=Toolkit.getDefaultToolkit().getImage(imgFold.toString()+"/"+info[1]
						  +".png");
				  temp.setTeamPic(teamImg);
				  result.add(temp);
				  }
				row++;
			}
			inTwo.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return result;
    }

	public HashMap<String, Image> readTeamImgFile(File imgFold) {
		// TODO Auto-generated method stub
		HashMap<String,Image> imgMap=new HashMap<String,Image>();
		File array[]=imgFold.listFiles();
		
		for(int i=0;i<array.length;i++)
		{
			String fileName=array[i].getName();
			boolean isPng=fileName.substring((fileName.indexOf('.')+1)).equals("png");
			String teamName=fileName.substring(0, fileName.indexOf('.'));
			if(isPng)
			{   
				Image img=Toolkit.getDefaultToolkit().getImage(imgFold+"/"+fileName);
				imgMap.put(teamName, img);
			}
		}
		
		return imgMap;
	}

	
	public PlayerPO readPlayerFile(File f,String acImgFold,String porImgFold) {
		PlayerPO result=new PlayerPO();
		Filter filter=new Filter();
		Waiter waiter=new Waiter();
		
		int birthYear=0;
		int txtAge=0;
		
		try {
			
			InputStream in=new FileInputStream(f);
			InputStreamReader inOne=new InputStreamReader(in,"UTF-8");
			
			BufferedReader inTwo=new BufferedReader(inOne);
			int row=1;
			
			String line=null;
	       
			while((line=inTwo.readLine())!=null)
			{
			  String bufLine=line;
			  line=filter.filtPlayer(line);
			  StringBuffer sb=new StringBuffer(line);	
			  if(row==2)
			  {
				StringBuffer sbb=new StringBuffer(bufLine);
				sbb.delete(0, 8);
				String name=filter.filtName(sbb.toString());
				result.setName(name);
				
			  }
			  if(row==4)           //第4行为球员号码
		      {
				 sb.delete(0, 8);
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
		    	  String birth=waiter.changeDate(sb.toString());
		    	  result.setBirth(birth);
		    	  String temp[]=birth.split("-");
		    	  birthYear=Integer.parseInt(temp[0]);
		    	  
		    	  
		      }
		      else if(row==14)
		      {
		    	  sb=sb.delete(0, 3);
		    	  
		    	  int nowYear=Integer.parseInt(waiter.getYear());
		    	  int age=nowYear-birthYear;
		    	  result.setAge(String.valueOf(age));
		    	  txtAge=Integer.parseInt(sb.toString());
		    	    
		      }else if(row==16)
		      {
		    	  sb=sb.delete(0, 3);
		    	  if(waiter.isNumber(sb.toString()))
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
		
	  /*  
	    String fileName=f.getName();
	    StringBuffer sb=new StringBuffer(fileName);
	    sb.delete(sb.length()-4,sb.length());
	    //name=name[0].split("\\\\");
	    String playerName=sb.toString();
	    
		result.setName(playerName);
		*/
		
		String playerName=result.getName();
		String actionPng=acImgFold+"/"+playerName+".png";
		String portraitImage=porImgFold+"/"+playerName+".png";
		
		Image actionImg=Toolkit.getDefaultToolkit().getImage(actionPng);
		Image portraitImg=Toolkit.getDefaultToolkit().getImage(portraitImage);
		
		result.setActionImage(actionImg);
		result.setPortaitImage(portraitImg);
		
		return result;
	}

	
}
