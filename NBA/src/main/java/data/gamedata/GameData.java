package data.gamedata;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import data.common.MatchFileList;
import data.common.Signal;
import data.common.Waiter;
import po.PlayerAllGamePO;
import po.PlayerGamePO;
import po.TeamAllGamePO;
import po.TeamGamePO;

public class GameData implements GameDataService,Runnable{

	
	private static HashMap<String,TeamAllGamePO> teamMap=null;
	private static HashMap<String,PlayerAllGamePO> playerMap=null;
	private static File matchFold=null;
	
    static{
		teamMap=new HashMap<String,TeamAllGamePO>();
		playerMap=new HashMap<String,PlayerAllGamePO>();
		matchFold=new File("data/matches");
		initGameData();
		
	}
	

	private static void initGameData(){
		teamMap=new HashMap<String,TeamAllGamePO>();
		playerMap=new HashMap<String,PlayerAllGamePO>();
		GameDataReadService gdrs=new GameDataReader();
		
		File[] array=matchFold.listFiles();
		for(int i=0;i<array.length;i++)
		{
			System.out.println("第"+i+"个文件");
			GameInfo gif=gdrs.readMatchFile(array[i]);
			addGif(gif);
			
		}
	}
	private static void addTeamGamePO(TeamGamePO po){
		boolean b=teamMap.containsKey(po.getTeamName());
		if(b)
		{
			teamMap.get(po.getTeamName()).addGame(po);
	    }
		else
		{
			String teamName=po.getTeamName();
			TeamAllGamePO allPo=new TeamAllGamePO();
			allPo.setTeamName(teamName);
			allPo.addGame(po);
			teamMap.put(teamName, allPo);
		}
	}
	
	private static void addPlayerGamePO(PlayerGamePO po){
		boolean b=playerMap.containsKey(po.getPlayerName());
		if(b)
		{
			playerMap.get(po.getPlayerName()).addMatch(po);
		}
		else
		{
			String playerName=po.getPlayerName();
			PlayerAllGamePO allPo=new PlayerAllGamePO();
			allPo.setPlayerName(playerName);
			allPo.setTeamName(po.getTeam());
			allPo.addMatch(po);
			playerMap.put(playerName, allPo);
		}
	}
	
	private static void addGif(GameInfo gif){
		TeamGamePO po1=gif.getTeamGame1();
		addTeamGamePO(po1);
		TeamGamePO po2=gif.getTeamGame2();
		addTeamGamePO(po2);
		
		ArrayList<PlayerGamePO> list=gif.getGameList(); 
		for(int j=0;j<list.size();j++)
		{
			addPlayerGamePO(list.get(j));
		}
	}
	
	public GameData(){
		new Thread(this).start();
	}
	

    public ArrayList<PlayerAllGamePO> getPlayerGameData() {
		// TODO Auto-generated method stub
        java.util.Iterator<String> it=playerMap.keySet().iterator();
		
		ArrayList<PlayerAllGamePO> list=new ArrayList<PlayerAllGamePO>();
		while(it.hasNext()){
			PlayerAllGamePO temp=playerMap.get(it.next());
			list.add(temp);
		}
		
		return list;
     }

	public ArrayList<TeamAllGamePO> getTeamGameData() {
		// TODO Auto-generated method stub
        java.util.Iterator<String> it=teamMap.keySet().iterator();
		
		ArrayList<TeamAllGamePO> list=new ArrayList<TeamAllGamePO>();
		while(it.hasNext()){
			TeamAllGamePO temp=teamMap.get(it.next());
			list.add(temp);
		}
		
		return list;
	
	}

	public ArrayList<PlayerGamePO> get_Latest_PlayerGameData() {
		// TODO Auto-generated method stub
		File[] array=matchFold.listFiles();
		Waiter waiter=new Waiter();
		int maxDate=0;
		GameDataReadService gdrs=new GameDataReader();
		for(int i=0;i<array.length;i++)
		{
			String name=array[i].getName();
			String names[]=name.split("_");
			String date=waiter.changeDate(names[1], names[0]);
			String time[]=date.split("-");
			date=time[0]+time[1]+time[2];
			int temp=Integer.parseInt(date);
			if(temp>maxDate)
				maxDate=temp;
		}
		
		//PlayerGamePO po=null;
		GameInfo gif=null;
		ArrayList<PlayerGamePO> result=new ArrayList<PlayerGamePO>();
		for(int i=0;i<array.length;i++)
		{
			String name=array[i].getName();
			String names[]=name.split("_");
			String date=waiter.changeDate(names[1], names[0]);
			String time[]=date.split("-");
			date=time[0]+time[1]+time[2];
			int temp=Integer.parseInt(date);
			if(temp==maxDate){
				gif=gdrs.readMatchFile(array[i]);
				ArrayList<PlayerGamePO> pList=gif.getGameList();
				result.addAll(pList);
		    }
		}
		
		return result;
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		
	      MatchFileList mfl=new MatchFileList();
	      String path="data/matches/";
	      File dataFile=new File(path);
	     
	      while(true)
	      {
	    	  try 
	    	  {
				Thread.sleep(2000);
			  } 
	    	  catch (InterruptedException e) 
	    	  {
				e.printStackTrace();
			  }
	    	  
	    	  File[] f=dataFile.listFiles();
	    	  Signal sig=mfl.hasThese(f);
	    	
	    	  boolean change=sig.getChange();
	    	  if(!change)
	    		  continue;
	    	  else
	    	  {
	    		  String op=sig.getOpration();
	    		   
	    		  if(op.equals("ADD"))
	    		  {
	    			  ArrayList<File> listF=sig.getNewFile();
	    			  for(int i=0;i<listF.size();i++)
	    			  {
	    				  File temp=listF.get(i);
	    				  GameDataReadService gdrs=new GameDataReader();
	    				  GameInfo gif=gdrs.readMatchFile(temp);
	    				  addGif(gif);
	    			  }
	    		  }
	    		  else if(op.equals("DEL"))
	    		  {
	    			      initGameData();
	    		  }
	    	  }
	    	 
	    	  
	        }
	}

}
