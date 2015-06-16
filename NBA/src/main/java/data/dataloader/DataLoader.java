package data.dataloader;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import po.PlayerGamePO;
import po.PlayerPO;
import po.TeamGamePO;
import po.TeamPO;
import util.TeamInfo;
import data.common.MatchFileList;
import data.common.Signal;
import data.fundDataReader.FundDataReader;
import data.gamedata.GameInfo;
import data.gamedataReader.GameDataReadService;
import data.gamedataReader.GameDataReader;
import data.sqlservice.DBUtil;

public class DataLoader implements Runnable{

	private String dataFold=null;
	private String matchFold=null;
	private String playerFold=null;
	private String teamFold=null;
	private String teamPngFold=null;
	private String playerActImgFold=null;
	private String playerPorImgFold=null;
	private Connection conn=null;

	private int threadCount=0;
	
	
    private PreparedStatement team_pst=null;
    private PreparedStatement player_pst=null;
	
	public DataLoader(){
		initFold();
		if(threadCount==0)
		{
			new Thread(this).start();
			threadCount++;
		}
		conn=DBUtil.open();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initStmt();
}

	private void initStmt(){
		String teamSql="insert into teamGameTbl(teamName,matchDate,matchPair,matchResult,chap1,chap2,chap3,"
        		+ "chap4,hitNum,shotNum,t_hitNum,t_shotNum,f_hitNum,f_shotNum,reb_Att_Num,reb_Def_Num,reb_Num,"
        		+ "assNum,stlNum,blockNum,errNum,foulNum,all_time,twoNum,isDirty,kind,season) "
        		+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		String playerSql="insert into playerGameTbl(playerName,position,teamName,time, matchDate,matchPair"
        		+ ",matchResult,isFirst,hitNum,shotNum,t_hitNum,t_shotNum,f_hitNum,f_shotNum,reb_Att_Num"
        		+ ",reb_Def_Num,reb_Num,assNum,stlNum,blockNum,errNum,foulNum,score,twoNum,isDirty,kind,season,"
        		+ "allPlayerTime,teamRebNum,"
        		+"oppTeamRebNum,teamAttRebNum,oppTeamAttRebNum,teamDefRebNum,"
				+"oppTeamDefRebNum,teamHitNum,oppAttNum,oppTwoNum,"
				+"teamThrowNum,teamFreeNum,teamErrorNum) values(?,"
        		+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			team_pst=conn.prepareStatement(teamSql);
			player_pst=conn.prepareStatement(playerSql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private void initFold()
	{
		Properties prop=new Properties();
		try 
		{
			FileReader in=new FileReader("src//config.data.properties");
			prop.load(in);
		}catch(Exception e)
		{
			System.out.println("配置文件dataProperties缺失");
			dataFold="data/";
			return ;
	    }
		dataFold=prop.getProperty("Fold");
		if(dataFold==null)
			dataFold="data/";
		
		matchFold=dataFold+"matches/";
		playerFold=dataFold+"players/info";
		teamFold=dataFold+"teams/";
	    teamPngFold=dataFold+"teamPng/";
	    playerActImgFold=dataFold+"players/action/";
	    playerPorImgFold=dataFold+"players/portrait/";
	}
	
	public void initData()
	{
		TableServer ts=new TableServer();
		ts.dropTables();
		ts.createTables();
		loadTeamData();
		loadPlayerData();
		loadGameData();
	}
	
	private void loadTeamData()
	{
		FundDataReader fdr=new FundDataReader();
		String txt=teamFold+"teams.txt";
		File teams=new File(txt);
		
		File teamPngs=new File(teamPngFold);
		ArrayList<TeamPO> teamList=fdr.readTeamFile(teams, teamPngs);
		
		String sql="insert into TeamTbl(teamName,shortName,city,area,zone,home,birthyear,imgPath) values(?,?,?,?,?,?,?,?);";
		for(int i=0;i<teamList.size();i++)
		{
			TeamPO tmp=teamList.get(i);
			try 
			{
				PreparedStatement pst=conn.prepareStatement(sql);
			    pst.setString(1, tmp.getTeamName());
			    pst.setString(2, tmp.getShortName());
			    pst.setString(3, tmp.getLocation());
			    pst.setString(4, tmp.getCompArea());
			    pst.setString(5, tmp.getZone());
			    pst.setString(6, tmp.getHome());
			    pst.setString(7, tmp.getBirthday());
			    pst.setString(8,teamPngFold+tmp.getShortName()+".png");
			  
			    pst.executeUpdate();
			 } 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		    	
	     }
	}
	
    private void loadPlayerData()
    {
    	FundDataReader fdr=new FundDataReader();
    	File players=new File(playerFold);
    	File[] p_arr=players.listFiles();

    	String sql="insert into playerTbl(playerName,number,position,height,"
    			+ "weight,birth,age,exp,school,actImg,porImg) values(?,?,?,?,?,?,?,?,?,?,?);";

    	for(int i=0;i<p_arr.length;i++)
    	{
    		PlayerPO tmp=fdr.readPlayerFile(p_arr[i], null, null);
    	    try 
		    {
		    	PreparedStatement pst=conn.prepareStatement(sql);
		    	pst.setString(1, tmp.getName());
			    pst.setString(2, tmp.getNumber());
			    pst.setString(3, tmp.getPosition());
			    pst.setString(4, tmp.getHeight());
			    pst.setString(5, tmp.getWeight());
			    pst.setString(6, tmp.getBirth());
			    pst.setString(7, tmp.getAge());
			    pst.setString(8, tmp.getExp());
			    pst.setString(9, tmp.getSchool());
			    pst.setString(10, playerActImgFold+tmp.getName()+".png");
			    pst.setString(11,playerPorImgFold+tmp.getName()+".png");
				pst.executeUpdate();
			} 
		    catch (SQLException e) 
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    }
    
    private void loadGameData()
    {
        GameDataReader gdr=new GameDataReader();
        File matches=new File(matchFold);
        File fArr[]=matches.listFiles();
        int sqlCount=0;
        for(int i=0;i<fArr.length;i++)
        {
        GameInfo gif=gdr.readMatchFile(fArr[i]);
        loadGif(gif);
        sqlCount++;
        if(sqlCount==10)
        {
        	try 
        	{
				team_pst.executeBatch();
				player_pst.executeBatch();
				conn.commit();
				team_pst.clearBatch();
				player_pst.clearBatch();
				sqlCount=0;
			} catch (SQLException e) 
        	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        }
        if(sqlCount!=0)
        {
        	try {
				team_pst.executeBatch();
				player_pst.executeBatch();
				team_pst.clearBatch();
				player_pst.clearBatch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
     }

	
    public void loadGif(GameInfo gif)
    {
    	/*String teamSql="insert into teamGameTbl(teamName,matchDate,matchPair,matchResult,chap1,chap2,chap3,"
        		+ "chap4,hitNum,shotNum,t_hitNum,t_shotNum,f_hitNum,f_shotNum,reb_Att_Num,reb_Def_Num,reb_Num,"
        		+ "assNum,stlNum,blockNum,errNum,foulNum,all_time,twoNum,isDirty,kind,season) "
        		+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        String playerSql="insert into playerGameTbl(playerName,position,teamName,time, matchDate,matchPair"
        		+ ",matchResult,isFirst,hitNum,shotNum,t_hitNum,t_shotNum,f_hitNum,f_shotNum,reb_Att_Num"
        		+ ",reb_Def_Num,reb_Num,assNum,stlNum,blockNum,errNum,foulNum,score,twoNum,isDirty,kind,season,"
        		+ "allPlayerTime,teamRebNum,"
        		+"oppTeamRebNum,teamAttRebNum,oppTeamAttRebNum,teamDefRebNum,"
				+"oppTeamDefRebNum,teamHitNum,oppAttNum,oppTwoNum,"
				+"teamThrowNum,teamFreeNum,teamErrorNum) values(?,"
        		+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";*/
       
      
       try {
        	/*PreparedStatement t_pst=conn.prepareStatement(teamSql);
        	PreparedStatement p_pst=conn.prepareStatement(playerSql);*/
        	        
        	TeamGamePO teamList[]=new TeamGamePO[2];
        	teamList[0]=gif.getTeamGame1();
        	teamList[1]=gif.getTeamGame2();
        	        
        	String mdate=teamList[0].getMatchDate();
        	String season=Judger.getSeason(mdate);
        	String kind=Judger.judge(mdate);
        	        
        	for(int j=0;j<2;j++)
        	{
        	    TeamGamePO tmp=teamList[j];
        	    team_pst.setString(1, tmp.getTeamName());
        	    team_pst.setString(2, tmp.getMatchDate());
        	    team_pst.setString(3, tmp.getMatchPair());
        	    team_pst.setString(4, tmp.getMatchResult());
        	    String score[]=tmp.getPartScore();
        	  /*  System.out.println(score.length);
        	    System.out.println(score);
        	    System.out.println(tmp.getMatchDate()+";"+tmp.getMatchPair());*/
        	    team_pst.setString(5, score[0]);
        	    team_pst.setString(6, score[1]);
        	    team_pst.setString(7, score[2]);
        	    team_pst.setString(8, score[3]);
        	    team_pst.setInt(9, tmp.getHitShootNum());
        	    team_pst.setInt(10, tmp.getShootNum());
        	    team_pst.setInt(11, tmp.getThreePointNum());
        	    team_pst.setInt(12, tmp.getThreeShootNum());
        	    team_pst.setInt(13, tmp.getFreeHitNum());
        	    team_pst.setInt(14, tmp.getFreeNum());
        	    team_pst.setInt(15, tmp.getRebAttNum());
        	    team_pst.setInt(16, tmp.getRebDefNum());
        	    team_pst.setInt(17, tmp.getRebTotalNum());
        	    team_pst.setInt(18, tmp.getAssistNum());
        	    team_pst.setInt(19, tmp.getStealNum());
        	    team_pst.setInt(20, tmp.getBlockNum());
        	    team_pst.setInt(21, tmp.getErrorNum());
        	    team_pst.setInt(22, tmp.getFoulNum());
        	    team_pst.setInt(23, tmp.getAllPlayerTime());
        	    team_pst.setInt(24, tmp.getShootNum()-tmp.getThreeShootNum());
        	    team_pst.setBoolean(25, tmp.isDirty());
        	    team_pst.setString(26, kind);
        	    team_pst.setString(27, season);
        	    team_pst.addBatch();   	
        	   // team_pst.executeUpdate();
        	 }
        	        
        	 ArrayList<PlayerGamePO> pList=gif.getGameList();
        	 
        	 for(int j=0;j<pList.size();j++)
        	 {

        	     PlayerGamePO tmp=pList.get(j);
        	     player_pst.setString(1, tmp.getPlayerName());
        	     player_pst.setString(2, tmp.getPosition());
        	     player_pst.setString(3, tmp.getTeam());
        	     player_pst.setInt(4, tmp.getTime());
        	        	
        	     player_pst.setString(5, tmp.getMatchDate());
        	     player_pst.setString(6, tmp.getMatchPair());
        	     player_pst.setString(7, tmp.getMatchResult());
        	     player_pst.setBoolean(8, tmp.isFirst());
        	     player_pst.setInt(9, tmp.getHitShootNum());
        	     player_pst.setInt(10, tmp.getShootNum());
        	     player_pst.setInt(11, tmp.getThreePointNum());
        	     player_pst.setInt(12, tmp.getThreeShootNum());
        	     player_pst.setInt(13, tmp.getFreeHitNum());
        	     player_pst.setInt(14, tmp.getFreeNum());
        	     player_pst.setInt(15, tmp.getRebAttNum());
        	     player_pst.setInt(16, tmp.getRebDefNum());
        	     player_pst.setInt(17, tmp.getRebTotalNum());
        	     player_pst.setInt(18, tmp.getAssistNum());
        	     player_pst.setInt(19, tmp.getStealNum());
        	     player_pst.setInt(20, tmp.getBlockNum());
        	     player_pst.setInt(21, tmp.getErrorNum());
        	     player_pst.setInt(22, tmp.getFoulNum());
        	     player_pst.setInt(23, tmp.getScore());
        	     player_pst.setInt(24, tmp.getTwoNum());
        	     player_pst.setBoolean(25, tmp.isDirty());
        	     player_pst.setString(26, kind);
        	     player_pst.setString(27, season);
        	        	
        	     TeamInfo tif=tmp.getTif();
        	     player_pst.setInt(28, tif.getAllPlayerTime());
        	     player_pst.setInt(29, tif.getTeamRebNum());
        	     player_pst.setInt(30, tif.getOppTeamRebNum());
        	     player_pst.setInt(31, tif.getTeamAttRebNum());
        	     player_pst.setInt(32, tif.getOppAttNum());
        	     player_pst.setInt(33, tif.getTeamDefRebNum());
        	     player_pst.setInt(34, tif.getOppTeamDefRebNum());
        	        	
        	     player_pst.setInt(35, tif.getTeamHitNum());
        	     player_pst.setInt(36, tif.getOppAttNum());
        	     player_pst.setInt(37, tif.getOppTwoNum());
        	     player_pst.setInt(38, tif.getTeamThrowNum());
        	     player_pst.setInt(39, tif.getTeamFreeNum());
        	     player_pst.setInt(40, tif.getTeamErrorNum());
        	     player_pst.addBatch();
        	     
        	     //player_pst.executeUpdate();
        	     
			}
        	System.out.println(mdate);
       }
       catch (Exception e) 
       {
    	   System.out.println("DataLoader中的loadgif出现异常");
    	  // e.printStackTrace();
       }
}
    protected void finalize()
	{
		DBUtil.close(conn);
		try {
			super.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
 	public void run() 
 	{
		  File dataFold=new File(matchFold);
		  File arr[]=dataFold.listFiles();
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
	    	  
	    	  File[] f=dataFold.listFiles();
	    	  
	    	  Signal sig=mfl.hasThese(f);
	    	  boolean change=sig.getChange();
	    	  
	    	  if(!change)
	    		  continue;
	    	  else
	    	  {   
	    		  String op=sig.getOpration();
	    		  mfl=new MatchFileList(f);
	    		  if(op.equals("ADD"))
	    		  {
	    			  ArrayList<File> listF=sig.getNewFile();
	    			  System.out.println("新加入"+listF.size()+"个文件");
	    			  for(int i=0;i<listF.size();i++)
	    			  {
	    				  File temp=listF.get(i);
	    				  GameDataReadService gdrs=new GameDataReader();
	    				  GameInfo gif=gdrs.readMatchFile(temp);
	    				  loadGif(gif);
	    			  }
	    		  }
	    		  else if(op.equals("DEL"))
	    		  {
	    			     initData();
	    		  }
	    		  
	    }
	   }
	}
}
