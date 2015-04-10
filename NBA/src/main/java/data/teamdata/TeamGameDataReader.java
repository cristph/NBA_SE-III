package data.teamdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import data.common.Monitor;

import po.TeamAllGamePO;
import po.TeamGamePO;

public class TeamGameDataReader implements TeamGameDataReadService {

	private String currentDate=null;
	private String currentPair=null;
	private String currentResult=null;
	private String[] partScore=null;
	private String team1=null;
	private String team2=null;
	
	private String currentSeason=null;
	private boolean isDirty=false;
	
	private int time=0;
	private int hitNum=0;
	private int shootNum=0;
	private int threeHitNum=0;
	private int threeShootNum=0;
	private int freeHitNum=0;
	private int freeShootNum=0;
	private int attReb=0;
	private int defReb=0;
	private int reb=0;
	private int ass=0;
	private int steal=0;
	private int block=0;
	private int error=0;
	private int foul=0;
	
    static HashMap<String,TeamAllGamePO> map=new HashMap<String,TeamAllGamePO>();
    static boolean First=true;
    //private HashMap<String,TeamAllGamePO> myMap=new HashMap<String,TeamAllGamePO>();
	
	public HashMap<String, TeamAllGamePO> getTeamAllGamePo() {
		// TODO Auto-generated method stub
   		
		if(First){
		 // ts.convertFileToTxt();
	      loadTeamData();
	      First=false;
	      if(Monitor.obNum==0){
		  Monitor m=new Monitor();
		  Thread dataTest=new Thread(m);
		  dataTest.start();
	      }
		}
		
		return map;
	}
	public void loadTeamData(){
		map.clear();
		String path="data/matches";
		File root=new File(path);
		File array[]=root.listFiles();
	    try{
		for(int i=0;i<array.length;i++)
	    {
	       File file=array[i];
	       processFile(file);
	    }
	    }catch(Exception e){
	    	
	    }
	//	map=new HashMap<String,TeamAllGamePO>(myMap);
	  
	}
	
	
	
	public void processFile(File f){
		
		String fileName=f.getName();
	
		
		isDirty=false;
	     
	    currentSeason=fileName.substring(0, 5);
	     
	     try {
			FileReader inOne=new FileReader(f);
			BufferedReader inTwo=new BufferedReader(inOne);
			
			String line=null;
			int row=1;
			TeamGamePO po1=new TeamGamePO();
			TeamGamePO po2=new TeamGamePO();
			
		
			while((line=inTwo.readLine())!=null)
			{
				if(row==1)
				{
					initCurrent(line);
					
				}
				else if(row==2)
				{
					partScore=line.split(";");
				}
				else if(row==3)
				{   
				     team1=line;
				     po1=initPO(po1);
				     initData();
				}	
				else if((line.length()<=4)&&(row!=3))
				{
                 po1=setTeamData(po1);
                 
					team2=line;
					initPO(po2);
					initData();
					
				}
				else{
					addData(line);
				}
				row++;
			}
			po2=setTeamData(po2);
			po1.setIsDirty(isDirty);
			revertResult(po2);
			addPO(team1,po1);
			addPO(team2,po2);
			
			inTwo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	
	
	
	private void revertResult(TeamGamePO po){
		String result[]=currentResult.split("-");
		currentResult=result[1]+"-"+result[0];
		String match[]=currentPair.split("-");
		currentPair=match[1]+"-"+match[0];
		po.setMatchResult(currentResult);
		po.setMatchPair(currentPair);
	}
	
	private void addPO(String name,TeamGamePO po){
		boolean isExisted=map.containsKey(name);
		if(isExisted){
			TeamAllGamePO temp=map.get(name);
			temp.addGame(po);
		}
		else{
			TeamAllGamePO newPO=new TeamAllGamePO();
			newPO.setTeamName(name);
			ArrayList<TeamGamePO> l=new ArrayList<TeamGamePO>();
			l.add(po);
			newPO.setGameDataList(l);
			map.put(name, newPO);
		}
			
	}
	
	
 	private void initCurrent(String s){
		String info[]=s.split(";");
	    currentDate=changeDate(info[0]);
	    currentPair=info[1];
	    currentResult=info[2];
	    
	  }
	private TeamGamePO initPO(TeamGamePO po){
		po.setMatchDate(currentDate);
		po.setMatchPair(currentPair);
		po.setMatchResult(currentResult);
		po.setPartScore(partScore);
		
		return po;
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
	

	private void addData(String line){
        String info[]=line.split(";");
		
		
		String tim[]=info[2].split(":");
		try{
		if(tim.length==1)
			time=Integer.parseInt(tim[0])*60;
		else if(tim.length==2)
			time=Integer.parseInt(tim[0])*60+Integer.parseInt(tim[1])+time;
		}catch(NumberFormatException e){
			time=-1;
		}
		 
		int data[]=new int[15];
		for(int i=0;i<data.length;i++)
		{
			try{
			data[i]=Integer.parseInt(info[i+3]);
			}catch(NumberFormatException n){
				data[i]=-1;
				isDirty=true;
				}
	    }
		 
		hitNum=hitNum+data[0];
	    shootNum=shootNum+data[1];
		threeHitNum=threeHitNum+data[2];
	    threeShootNum=threeShootNum+data[3];
	    freeHitNum=freeHitNum+data[4];
	    freeShootNum=freeShootNum+data[5];
	    attReb=attReb+data[6];
		defReb=defReb+data[7];
	    reb=reb+data[8];
	    ass=ass+data[9];
	    steal=steal+data[10];
	    block=block+data[11];
	    error=error+data[12];
		foul=foul+data[13];
		
	}
	
	
	private void initData(){
		 time=0;
		 hitNum=0;
		 shootNum=0;
		 threeHitNum=0;
		 threeShootNum=0;
		 freeHitNum=0;
		 freeShootNum=0;
		 attReb=0;
		 defReb=0;
		 reb=0;
		 ass=0;
		 steal=0;
		 block=0;
		 error=0;
		 foul=0;
		
	}
	
	private TeamGamePO setTeamData(TeamGamePO po){
		po.setAllPlayerTime(time);
		po.setAssistNum(ass);
		po.setBlockNum(block);
		po.setFoulNum(foul);
		po.setFreeHitNum(freeHitNum);
		po.setFreeNum(freeShootNum);
		po.setHitShootNum(hitNum);
		po.setRebAttNum(attReb);
		po.setRebDefNum(defReb);
		po.setRebTotalNum(reb);
		po.setShootNum(shootNum);
		po.setStealNum(steal);
		po.setErrorNum(error);
		po.setThreePointNum(threeHitNum);
		po.setThreeShootNum(threeShootNum);
	    po.setIsDirty(isDirty);
	    return po;
}
}