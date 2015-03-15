package data.playerdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import po.PlayerAllGamePO;

public class PlayerGameDataReader implements PlayerGameDataReadService {

	private String currentSeason=null;
	private String currentDate=null;
	private String currentPair=null;
	private String currentTeam=null;
	private String currentResult=null;
	
	public HashMap<String, PlayerAllGamePO> getPlayerGamePo() {
		// TODO Auto-generated method stub
		String path="data/matches";
		File root=new File(path);
		File array[]=root.listFiles();
		for(int i=0;i<array.length;i++)
		{
			if(array[i].isFile())
			{
				String temp[]=array[i].getName().split("_");
				currentSeason=temp[0];
				try {
					FileReader inOne=new FileReader(array[i]);
					BufferedReader inTwo=new BufferedReader(inOne);
					String line=null;
					int row=1;
					while((line=inTwo.readLine())!=null)
					{
						
						if(row==1)
						{
							initCurrent(line);
						}
					    else if(row==2)
					    {
							continue;
					    }
						else if(line.length()<4)
						{
							currentTeam=line;
						}
						else 
						{
			                				
						}
			
						
						
					}
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		return null;
		}
	
	private void initCurrent(String s){
		String info[]=s.split(";");
	    currentDate=changeDate(info[0]);
	    currentPair=info[1];
	    currentResult=info[2];
	  }
	private String changeDate(String s){
		String dateParts[]=s.split("-");
		int month=Integer.parseInt(dateParts[0]);
        String year[]=currentSeason.split("-");
        String preYear=year[0];
        String backYear=year[1];
        String yyear=null;
		if((month>0)&&(month<=4))
		{
			yyear="20"+preYear;
		}
		else
		{
			yyear="20"+backYear;
		}
		return yyear+"-"+s;
			
	}

}
