package data.playerdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import po.PlayerAllGamePO;
import po.PlayerGamePO;

public class PlayerGameDataReader implements PlayerGameDataReadService {

	private String currentSeason=null;
	private String currentDate=null;
	private String currentPair=null;
	private String currentTeam=null;
	private String currentResult=null;
	private String currentPlayer=null;
	
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


	
	
	private PlayerGamePO getPO(String line){
		PlayerGamePO temp=new PlayerGamePO();
		String info[]=line.split(";");
		currentPlayer=info[0];
		
		if(!info[1].equals(""))
			temp.setPosition(info[1]);
		else
			temp.setPosition("substitution");
		
		String time[]=info[2].split(":");
		int tim=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
	    temp.setTime(tim);
	    
		
		int data[]=new int[14];
		
		for(int i=3;i<info.length;i++)
		{   
		try{
	    	data[i-3]=Integer.parseInt(info[i]);
		
		}catch(NumberFormatException n)
		{
			data[i-3]=-1;
		}
		}
		
		temp.setHitShootNum(data[0]);
		temp.setShootNum(data[1]);
		temp.setThreePointNum(data[2]);
		temp.setThreeShootNum(data[3]);
		temp.setFreeHitNum(data[4]);
		temp.setFreeNum(data[8]);
		temp.setRebAttNum(data[9]);
		//temp.
		
		
		/*球员名;位置;在场时间;投篮命中数;投篮出手数;三分命中数;三分出手数;罚球命中数;罚 球出手数;
		 * 进攻 （前场）篮板数;防守 （后场）篮板数;总篮板数;助攻数;盖帽数;失误数;犯规 数; 个人得分; 
		 */
		
		
		
		
		return null;
		
	}
	
}
