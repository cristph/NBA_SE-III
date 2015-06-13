package data.gamedata;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import data.common.MatchFileList;
import data.common.Signal;
import po.PlayerAllGamePO;
import po.PlayerGamePO;
import po.TeamAllGamePO;
import po.TeamGamePO;

public class GameData implements GameDataService,Runnable{

	private static HashMap<String,TeamAllGamePO> teamMap=null;
	private static HashMap<String,PlayerAllGamePO> playerMap=null;
	private static File matchFold=null;
	private static boolean dataChange=false;
	
	private GameSqlServer gSql=null;
	
    static
    {
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
			GameInfo gif=gdrs.readMatchFile(array[i]);
			addGif(gif);
		}
	}
	
	private static void addTeamGamePO(TeamGamePO po){
		if(po!=null){
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
		//ArrayList<PlayerGamePO> playerList=playerList;
		for(int j=0;j<list.size();j++)
		{
			addPlayerGamePO(list.get(j));
		}
	}
	
	public static boolean getDataChange(){
		boolean tmp=dataChange;
		dataChange=false;
		return tmp;
	}
	
	
	public GameData(){
		gSql=new GameSqlServer();
	}
	
	public ArrayList<PlayerAllGamePO> getPlayerGameData(Selector st)
	{
		String kind=st.getKind();
		String season=st.getSeason();
		
		HashMap<String,PlayerAllGamePO> pMap=gSql.getPlayerGameData(season, kind);
		java.util.Iterator<String> it=pMap.keySet().iterator();
		
		
	    ArrayList<PlayerAllGamePO> list=new ArrayList<PlayerAllGamePO>();
        while(it.hasNext())
        {
			PlayerAllGamePO temp=pMap.get(it.next());
		    list.add(temp);
	    }
		return list;
	}
	
	public ArrayList<TeamAllGamePO> getTeamGameData(Selector st) {
		String kind=st.getKind();
		String season=st.getSeason();
		
		HashMap<String,TeamAllGamePO> tMap=gSql.getTeamGameData(season, kind);
		java.util.Iterator<String> it=tMap.keySet().iterator();
		
		
	    ArrayList<TeamAllGamePO> list=new ArrayList<TeamAllGamePO>();
        while(it.hasNext())
        {
        	TeamAllGamePO temp=tMap.get(it.next());
		    list.add(temp);
	    }
		return list;
	}

    public ArrayList<PlayerGamePO> get_Latest_PlayerGameData(){
		return gSql.getLatestPlayer();
	}
	
	
	
    public void run() {
		// TODO Auto-generated method stub
		  
    	  File arr[]=matchFold.listFiles();
	      MatchFileList mfl=new MatchFileList(arr);
	 
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
	    	  
	    	  File[] f=matchFold.listFiles();
	    	  Signal sig=mfl.hasThese(f);
	    	
	    	  boolean change=sig.getChange();
	    	  if(!change)
	    		  continue;
	    	  else
	    	  {   
	    		  dataChange=true;
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
