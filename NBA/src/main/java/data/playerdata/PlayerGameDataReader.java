package data.playerdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import data.common.Monitor;
import po.PlayerAllGamePO;
import po.PlayerGamePO;


public class PlayerGameDataReader implements PlayerGameDataReadService{

	private String currentSeason=null;
	private String currentDate=null;
	private String currentPair=null;
	private String currentTeam=null;
	private String currentResult=null;
	private String currentPlayer=null;
	
	  static HashMap<String,PlayerAllGamePO> map=new HashMap<String,PlayerAllGamePO>();
	  static boolean First=true;
	
	public HashMap<String, PlayerAllGamePO> getPlayerGamePo() {
		// TODO Auto-generated method stub
		if(First){
			loadPlayerData();
			First=false;
			 if(Monitor.obNum==0)
			 {
				  Monitor m=new Monitor();
				  Thread dataTest=new Thread(m);
				  dataTest.start();
			 }
		}
		return map;
		}
	
	
	public void loadPlayerData(){
		map.clear();
        String path="data/matches";
		File root=new File(path);
		File array[]=root.listFiles();
		for(int i=0;i<array.length;i++)
		{
			processFile(array[i]);
		}
	}
	
	public void processFile(File f){
		if(f.isFile())
		{
			String name=f.getName();
			
			String temp[]=name.split("_");
			currentSeason=temp[0];
			try {
				FileReader inOne=new FileReader(f);
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
				    	row++;
						continue;
				    }
					else if(line.length()<4)
					{
						currentTeam=line;
					}
					else 
					{
		                PlayerGamePO temPo=getPO(line);
		                boolean existed=map.containsKey(currentPlayer);
		                if(existed)
		                {
		                	PlayerAllGamePO currentPO=map.get(currentPlayer);
		                	currentPO.addMatch(temPo);
		                }
		                else
		                {
		                	PlayerAllGamePO newPo=new PlayerAllGamePO();
		                	newPo.setPlayerName(currentPlayer);
		                	newPo.setTeamName(currentTeam);
		                	ArrayList<PlayerGamePO> newList=new ArrayList<PlayerGamePO>();
		                	newList.add(temPo);
		                	newPo.setGameDataList(newList);
		                	map.put(currentPlayer, newPo);
		                }
					}
					row++;
	            }
				
				inTwo.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
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
			yyear="20"+backYear;
		}
		else
		{
			yyear="20"+preYear;
		}
		return yyear+"-"+s;
			
	}
    
	private PlayerGamePO getPO(String line){
		PlayerGamePO temp=new PlayerGamePO();
		boolean isFirst=true;
		
		String info[]=line.split(";");
		currentPlayer=info[0];
		
		if(!info[1].equals(""))
			temp.setPosition(info[1]);
		else
		{
			temp.setPosition("substitution");
			isFirst=false;
		}
		
		
		String time[]=info[2].split(":");
		
		int tim=0;
		if(time.length==2)
		 tim=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
		else if(time.length==0)
		 tim=Integer.parseInt(time[0])*60;	
	    temp.setTime(tim);
	    
		int data[]=new int[15];
		
		for(int i=3;i<info.length;i++)
		{   
		try{
	    	data[i-3]=Integer.parseInt(info[i]);
		
		}catch(NumberFormatException n)
		{
			data[i-3]=-1;
			temp.setDirty(true);
		}
		}
		
		temp.setHitShootNum(data[0]);
		temp.setShootNum(data[1]);
		temp.setThreePointNum(data[2]);
		temp.setThreeShootNum(data[3]);
		temp.setFreeHitNum(data[4]);
		temp.setFreeNum(data[5]);
		temp.setRebAttNum(data[6]);
		temp.setRebDefNum(data[7]);
		temp.setRebTotalNum(data[8]);
		temp.setAssistNum(data[9]);
		temp.setStealNum(data[10]);
		temp.setBlockNum(data[11]);
		temp.setFoulNum(data[12]);
		temp.setErrorNum(data[13]);
		temp.setScore(data[14]);
		
		temp.setFirst(isFirst);
		
		int twoShoot=temp.getShootNum()-temp.getThreeShootNum();
		temp.setTwoNum(twoShoot);
		
		temp.setMatchDate(currentDate);
		temp.setMatchPair(currentPair);
		temp.setMatchResult(currentResult);
		temp.setTeam(currentTeam);
		
		return temp;
		
	}

	
	
	
}
