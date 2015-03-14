package data.playerdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import po.PlayerGamePO;
import po.PlayerPO;

public class PlayerDataReader implements PlayerDataReadService {

	public PlayerPO getPlayerPo(String path) {
		// TODO Auto-generated method stub
		PlayerPO result=new PlayerPO();
		
		try {
			FileReader inOne=new FileReader(new File(path));
			BufferedReader inTwo=new BufferedReader(inOne);
			int row=1;
			
			String line=null;
	        line=inTwo.readLine();
			while(line!=null)
			{
			  StringBuffer sb=new StringBuffer(line);	
		      if(row==4)           //第4行为球员号码
		      {
		    	 sb=sb.delete(0, 5);
		    	// result
		      }
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public HashMap<String, PlayerGamePO> getPlayerGamePo() {
		// TODO Auto-generated method stub
		return null;
	}

	private String process(String s){
	   s=s.trim();
	   StringBuffer sb=new StringBuffer(s);
	   char[] array=s.toCharArray();
       for(int i=0;i<array.length;i++)
       {
    	   char temp=array[i];
    	   boolean b1=(temp>='a')&&(temp<='z');
    	   boolean b2=(temp>='A')&&(temp<='Z');
    	   boolean b3=(temp>='0')&&(temp<='9');
    	   boolean b4=(temp=='-');
    	   boolean b=!(b1||b2||b3||b4);
    	   if(b)
    	   {
    		   sb=sb.deleteCharAt(i);
    		   array=sb.toString().toCharArray();
    		   i=i-1;
    	   }
       }
       return sb.toString();
       
	}
	
}
