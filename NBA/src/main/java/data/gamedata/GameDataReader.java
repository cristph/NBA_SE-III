package data.gamedata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



import data.common.Waiter;
import po.PlayerGamePO;
import po.TeamGamePO;

public class GameDataReader implements GameDataReadService {

	private String currentSeason=null;
	private String currentDate=null;
	private String currentPair=null;
	private String currentResult=null;
	private String[] partScore=null;
	
	private int currentTeam=1;
	
	private String teamName1=null;
	private String teamName2=null;
	
	private TeamGamePO teamGame1=null;
	private TeamGamePO teamGame2=null;
	
    private ArrayList<PlayerGamePO> playerList=null;
	private Waiter waiter=null;
	
	public GameDataReader(){
		playerList=new ArrayList<PlayerGamePO>();
		waiter=new Waiter();
		teamGame1=new TeamGamePO();
		teamGame2=new TeamGamePO();
	}
	
	
	private void initCurrent(String s){
		String info[]=s.split(";");
	    currentDate=waiter.changeDate(info[0],currentSeason);
	    currentPair=info[1];
	    currentResult=info[2];
	  }
	
	private PlayerGamePO makePlayerPO(String line){
		PlayerGamePO temp=new PlayerGamePO();
		boolean isFirst=true;
		
		String info[]=line.split(";");
		String playerName=info[0];
		
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
		
		temp.setPlayerName(playerName);
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
		if(currentTeam==1)
		temp.setTeam(teamName1);
		else if(currentTeam==2)
		temp.setTeam(teamName2);

		return temp;
}

private void updateTeam(String line){
	
	TeamGamePO temp=null;
	if(currentTeam==1)
		temp=teamGame1;
	else
		temp=teamGame2;
	
	String info[]=line.split(";");
	
	int time=0;
	boolean isDirty=false;
	String tim[]=info[2].split(":");

	try{
	if(tim.length==1)
		time=Integer.parseInt(tim[0])*60;
	else if(tim.length==2)
		time=Integer.parseInt(tim[0])*60+Integer.parseInt(tim[1]);
	}catch(NumberFormatException e){
		time=-1;
		isDirty=true;
	}
	 
	int data[]=new int[15];
	
	for(int i=0;i<data.length;i++)
	{
		try
		{
		   data[i]=Integer.parseInt(info[i+3]);
		}catch(NumberFormatException n)
		{
		   data[i]=-1;
		   isDirty=true;
		}
    }
	 
	int allPlayerTime=temp.getAllPlayerTime()+time;
	int hitNum=temp.getHitShootNum()+data[0];
    int shootNum=temp.getShootNum()+data[1];
	int threeHitNum=temp.getThreePointNum()+data[2];
    int threeShootNum=temp.getThreeShootNum()+data[3];
    int freeHitNum=temp.getFreeHitNum()+data[4];
    int freeShootNum=temp.getShootNum()+data[5];
    int attReb=temp.getRebAttNum()+data[6];
	int defReb=temp.getRebDefNum()+data[7];
    int reb=temp.getRebTotalNum()+data[8];
    int ass=temp.getAssistNum()+data[9];
    int steal=temp.getStealNum()+data[10];
    int block=temp.getBlockNum()+data[11];
    int error=temp.getErrorNum()+data[12];
	int foul=temp.getFoulNum()+data[13];
	
	temp.setAllPlayerTime(allPlayerTime);
	temp.setHitShootNum(hitNum);
	temp.setShootNum(shootNum);
	temp.setThreePointNum(threeHitNum);
	temp.setThreeShootNum(threeShootNum);
	temp.setFreeHitNum(freeHitNum);
	temp.setFreeNum(freeShootNum);
	temp.setRebAttNum(attReb);
	temp.setRebDefNum(defReb);
	temp.setRebTotalNum(reb);
	temp.setAssistNum(ass);
	temp.setStealNum(steal);
	temp.setBlockNum(block);
	temp.setErrorNum(error);
	temp.setFoulNum(foul);
	
	if(isDirty)
		temp.setIsDirty(isDirty);
	
	
}
	

private GameInfo makeGameInfo(){
	GameInfo gif=new GameInfo();
	
	setTeamInfo(teamGame1,1);
	setTeamInfo(teamGame2,2);
	
    gif.setTeamGame1(teamGame1);
	gif.setTeamGame2(teamGame2);
	
	TeamInfo info1=new TeamInfo(teamGame1.getAllPlayerTime(),teamGame1.getRebTotalNum(),teamGame2.getRebTotalNum(),teamGame1.getRebAttNum(),
			teamGame2.getRebAttNum(),teamGame1.getRebDefNum(),teamGame2.getRebDefNum(),teamGame1.getFreeHitNum()+teamGame1.getHitShootNum(),teamGame2.getRebAttNum(),
			teamGame2.getShootNum()-teamGame2.getThreeShootNum(),teamGame1.getShootNum(),teamGame1.getFreeNum(),teamGame1.getErrorNum());
	
	TeamInfo info2=new TeamInfo(teamGame2.getAllPlayerTime(),teamGame2.getRebTotalNum(),teamGame1.getRebTotalNum(),teamGame2.getRebAttNum(),
			teamGame1.getRebAttNum(),teamGame2.getRebDefNum(),teamGame1.getRebDefNum(),teamGame2.getFreeHitNum()+teamGame2.getHitShootNum(),teamGame1.getRebAttNum(),
			teamGame1.getShootNum()-teamGame1.getThreeShootNum(),teamGame2.getShootNum(),teamGame2.getFreeNum(),teamGame2.getErrorNum());
	

	for(int i=0;i<playerList.size();i++)
	{
	    PlayerGamePO po=playerList.get(i);
	    
	    if(po.getTeam().equals(teamName1)) 
		   po.setTif(info1);
	    else
		   po.setTif(info2);
	}
	
	gif.setGameList(playerList);

	return gif;
}

	
public GameInfo readMatchFile(File f) {
		 
		playerList=new ArrayList<PlayerGamePO>();
		if(f.isFile())
		{
			teamGame1=new TeamGamePO();
			teamGame2=new TeamGamePO();
			
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
				    	partScore=line.split(";");
						continue;
				    }
					else if(row==3)
					{
						teamName1=line;
						currentTeam=1;
					}
					else if((line.length()<=4)&&(row!=3))
					{
						teamName2=line;
						currentTeam=2;
				    }
					else 
					{
		                PlayerGamePO temPo=makePlayerPO(line);
		                playerList.add(temPo);
		                
		                updateTeam(line);
		             }
					row++;
					}
				
				   inTwo.close();	
	            }
				catch (FileNotFoundException e) 
			    {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    } catch (IOException e) 
			    {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }
			
		        GameInfo result=makeGameInfo();
		        teamGame1=new TeamGamePO();
				teamGame2=new TeamGamePO();
		        return result;
			}
		return new GameInfo();
	}
    private void setTeamInfo(TeamGamePO po,int i){
    	po.setMatchDate(currentDate);
       	po.setPartScore(partScore);
    	
    	String result[]=currentResult.split("-");
    	String currentResult2=result[1]+"-"+result[0];
    	
    	String pair[]=currentPair.split("-");
    	String currentPair2=pair[1]+"-"+pair[0];
    	
    	if(i==1)
    	{
    		po.setMatchResult(currentResult);
    		po.setTeamName(teamName1);
    		po.setMatchPair(currentPair);
    	}
    	else if(i==2)
    	{
    		po.setMatchResult(currentResult2);
    		po.setTeamName(teamName2);
    		po.setMatchPair(currentPair2);
    	}	
    }
}	

	

