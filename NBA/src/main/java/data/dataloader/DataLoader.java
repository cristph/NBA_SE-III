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
import data.funddata.FundDataReader;
import data.gamedata.GameDataReader;
import data.gamedata.GameInfo;
import data.sqlservice.DBUtil;

public class DataLoader {

	private String dataFold=null;
	private String matchFold=null;
	private String playerFold=null;
	private String teamFold=null;
	private String teamPngFold=null;
	private String playerActImgFold=null;
	private String playerPorImgFold=null;

	public DataLoader(){
		initFold();
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
		Connection conn=DBUtil.open();
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
			    pst.setString(8,teamPngFold+tmp.getTeamName()+".png");
			  
			    pst.executeUpdate();
			 } 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		    	
	     }
		DBUtil.close(conn);
		
	}
	

    private void loadPlayerData()
    {
    	FundDataReader fdr=new FundDataReader();
    	File players=new File(playerFold);
    	File[] p_arr=players.listFiles();

    	String sql="insert into playerTbl(playerName,number,position,height,weight,birth,age,exp,school,actImg,porImg) values(?,?,?,?,?,?,?,?,?,?,?);";

    	Connection conn=DBUtil.open();
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
    	DBUtil.close(conn);
    }
    
    private void loadGameData()
    {
        GameDataReader gdr=new GameDataReader();
        File matches=new File(matchFold);
        File fArr[]=matches.listFiles();
        String teamSql="insert into teamGameTbl(teamName,matchDate,matchPair,matchResult,chap1,chap2,chap3,"
        		+ "chap4,hitNum,shotNum,t_hitNum,t_shotNum,f_hitNum,f_shotNum,reb_Att_Num,reb_Def_Num,reb_Num,"
        		+ "assNum,stlNum,blockNum,errNum,foulNum,all_time,isDirty,kind) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        String playerSql="insert into playerGameTbl(playerName,position,teamName,time, matchDate,matchPair"
        		+ ",matchResult,isFirst,hitNum,shotNum,t_hitNum,t_shotNum,f_hitNum,f_shotNum,reb_Att_Num"
        		+ ",reb_Def_Num,reb_Num,assNum,stlNum,blockNum,errNum,foulNum,score,twoNum,isDirty,kind) values(?,"
        		+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        
        Connection conn=DBUtil.open();
        try {
			PreparedStatement t_pst=conn.prepareStatement(teamSql);
			PreparedStatement p_pst=conn.prepareStatement(playerSql);
			 for(int i=0;i<fArr.length;i++)
		        {
		        	GameInfo gif=gdr.readMatchFile(fArr[i]);
		        	TeamGamePO teamList[]=new TeamGamePO[2];
		            teamList[0]=gif.getTeamGame1();
		            teamList[1]=gif.getTeamGame2();
		            
		            String mdate=teamList[0].getMatchDate();
		            String kind=Judger.judge(mdate);
		            
		            for(int j=0;j<2;j++)
		            {
		            	TeamGamePO tmp=teamList[j];
		            	
		            	t_pst.setString(1, tmp.getTeamName());
		            	t_pst.setString(2, tmp.getMatchDate());
		            	t_pst.setString(3, tmp.getMatchPair());
		            	t_pst.setString(4, tmp.getMatchResult());
		            	String score[]=tmp.getPartScore();
		            	t_pst.setString(5, score[0]);
		            	t_pst.setString(6, score[1]);
		            	t_pst.setString(7, score[2]);
		            	t_pst.setString(8, score[3]);
		            	t_pst.setInt(9, tmp.getHitShootNum());
		            	t_pst.setInt(10, tmp.getShootNum());
		            	t_pst.setInt(11, tmp.getThreePointNum());
		            	t_pst.setInt(12, tmp.getThreeShootNum());
		            	t_pst.setInt(13, tmp.getFreeHitNum());
		            	t_pst.setInt(14, tmp.getFreeNum());
		            	t_pst.setInt(15, tmp.getRebAttNum());
		            	t_pst.setInt(16, tmp.getRebDefNum());
		            	t_pst.setInt(17, tmp.getRebTotalNum());
		            	t_pst.setInt(18, tmp.getAllPlayerTime());
		            	t_pst.setInt(19, tmp.getStealNum());
		            	t_pst.setInt(20, tmp.getBlockNum());
		            	t_pst.setInt(21, tmp.getErrorNum());
		            	t_pst.setInt(22, tmp.getFoulNum());
		            	t_pst.setInt(23, tmp.getAllPlayerTime());
		            	t_pst.setBoolean(24, tmp.getIsDirty());
		            	t_pst.setString(25, kind);
		            	
		            	
		            	t_pst.executeUpdate();
		            }
		            
		            ArrayList<PlayerGamePO> pList=gif.getGameList();
		            for(int j=0;j<pList.size();j++)
		            {
		   /*	String playerSql="insert into playerTbl(playerName,position,teamName,time, matchDate,matchPair"
		               + ",matchResult,isFirst,hitNum,shotNum,t_hitNum,t_shotNum,f_hitNum,f_shotNum,reb_Att_Num"
		                		+ ",reb_Def_Num,reb_Num,assNum,stlNum,blockNum,errNum,foulNum,score,twoNum,isDirty
*/		            	PlayerGamePO tmp=pList.get(j);
                        System.out.println(tmp.getPlayerName()+";"+tmp.getMatchDate());
		            	p_pst.setString(1, tmp.getPlayerName());
		            	p_pst.setString(2, tmp.getPosition());
		            	p_pst.setString(3, tmp.getTeam());
		            	p_pst.setInt(4, tmp.getTime());
		            	
		            	p_pst.setString(5, tmp.getMatchDate());
		            	p_pst.setString(6, tmp.getMatchPair());
		            	p_pst.setString(7, tmp.getMatchResult());
		            	p_pst.setBoolean(8, tmp.isFirst());
		            	p_pst.setInt(9, tmp.getHitShootNum());
		            	p_pst.setInt(10, tmp.getShootNum());
		            	p_pst.setInt(11, tmp.getThreePointNum());
		            	p_pst.setInt(12, tmp.getThreeShootNum());
		            	p_pst.setInt(13, tmp.getFreeHitNum());
		            	p_pst.setInt(14, tmp.getFreeNum());
		            	p_pst.setInt(15, tmp.getRebAttNum());
		            	p_pst.setInt(16, tmp.getRebDefNum());
		            	p_pst.setInt(17, tmp.getRebTotalNum());
		            	p_pst.setInt(18, tmp.getAssistNum());
		            	p_pst.setInt(19, tmp.getStealNum());
		            	p_pst.setInt(20, tmp.getBlockNum());
		            	p_pst.setInt(21, tmp.getErrorNum());
		            	p_pst.setInt(22, tmp.getFoulNum());
		            	p_pst.setInt(23, tmp.getScore());
		            	p_pst.setInt(24, tmp.getTwoNum());
		            	p_pst.setBoolean(25, tmp.isDirty());
		            	p_pst.setString(26, kind);
		            	
		            	p_pst.executeUpdate();
		           }
		        }
		} 
        catch (SQLException e) 
        {
			e.printStackTrace();
		}
        DBUtil.close(conn);
   }
    
    
    
}
