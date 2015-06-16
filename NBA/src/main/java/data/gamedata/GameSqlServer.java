package data.gamedata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import po.PlayerAllGamePO;
import po.PlayerGamePO;
import po.TeamAllGamePO;
import po.TeamGamePO;
import util.PlayerChoosor;
import util.Selector;
import util.TeamInfo;
import data.common.MapToList;
import data.sqlservice.DBUtil;

public class GameSqlServer {

	private Connection conn=null;
	//private TeamInfoServer tis=null;
	private static HashMap<Updator,HashMap<String,PlayerAllGamePO>> playerGamemap=null;
	private static HashMap<Updator,HashMap<String,TeamAllGamePO>>   teamGamemap=null;
	private static int playerId=0;
	private static int teamId=0;
	
	
	static
	{
		playerGamemap=new HashMap<Updator,HashMap<String,PlayerAllGamePO>>();
		teamGamemap=new HashMap<Updator,HashMap<String,TeamAllGamePO>>();
	}
	
	public GameSqlServer(){
		conn=DBUtil.open();
	}
	
	public ArrayList<PlayerAllGamePO> getPlayerGameData(Selector st){
		setMaxID();
		Updator u=new Updator(st,playerId);
		
        if(containKey(u,playerGamemap.keySet()))
        {
        	Iterator<Updator> it=playerGamemap.keySet().iterator();
        	while(it.hasNext())
        	{
        		Updator tmp=it.next();
        		if(tmp.equals(u)&&(tmp.getMaxId()==u.getMaxId()))
        		{
        			 return MapToList.convertList(playerGamemap.get(tmp));
        	    }
        		else if(tmp.equals(u)&&(tmp.getMaxId()<u.getMaxId()))
        		{
        			 HashMap<String,PlayerAllGamePO> oldMap=playerGamemap.get(tmp);
        			
        			 HashMap<String,PlayerAllGamePO> newMap=updatePlayerGameData(tmp.getMaxId(),oldMap);
        			 playerGamemap.put(u, newMap);
        			 return MapToList.convertList(newMap);
        		}
        	}
        }
        else
        {
        	HashMap<String,PlayerAllGamePO> newMap=makePlayerGameData(st);
        	playerGamemap.put(u, newMap);
        	return MapToList.convertList(newMap);
        }
		return null;
}
	
	private HashMap<String,PlayerAllGamePO> updatePlayerGameData(int id,HashMap<String,PlayerAllGamePO> oldMap)
	{
		String updateSql="select * from playergametbl where id >"+id;
		try 
		{
			/*PreparedStatement pst=conn.prepareStatement(updateSql);
			pst.setInt(1, id);*/
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(updateSql);
			while(rs.next())
			{
				PlayerGamePO newPo=makePlayerGamePO(rs);
				String playerName=newPo.getPlayerName();
				if(oldMap.containsKey(playerName))
				{
				oldMap.get(newPo.getPlayerName()).addMatch(newPo);
				}
				else
				{
				 PlayerAllGamePO po=new PlayerAllGamePO();
				 po.setPlayerName(playerName);
				 po.setTeamName(newPo.getTeam());
				 po.addMatch(newPo);
				 oldMap.put(playerName, po);
				}
			}
	      } 
		    catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		return oldMap;
	}
	
	private HashMap<String,PlayerAllGamePO> makePlayerGameData(Selector st){
		String sql=null;
		HashMap<String,PlayerAllGamePO> map=new HashMap<String,PlayerAllGamePO>();
		
		try 
		{
			PreparedStatement pst=null;
			if(st.getKind().equals("A"))
			{
				sql="select * from playergametbl where season=?";
				pst=conn.prepareStatement(sql);
				pst.setString(1, st.getSeason());
			}
			else
			{
				sql="select * from playergametbl where season=? and kind=?";
				pst=conn.prepareStatement(sql);
				pst.setString(1, st.getSeason());
				pst.setString(2, st.getKind());
			}
			 
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				PlayerGamePO gamePo=makePlayerGamePO(rs);
				String playerName=gamePo.getPlayerName();
				String teamName=gamePo.getTeam();
				boolean hasOne=map.containsKey(playerName);
				if(hasOne)
				{
					map.get(playerName).addMatch(gamePo);
				}
				else
				{
					PlayerAllGamePO newPo=new PlayerAllGamePO();
					newPo.setPlayerName(playerName);
					newPo.setTeamName(teamName);
					map.put(playerName, newPo);
					newPo.addMatch(gamePo);
				}
		    }
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return map;
	}
	
    private HashMap<String,TeamAllGamePO> makeTeamGameData(Selector st){
    	String sql=null;
		HashMap<String,TeamAllGamePO> map=new HashMap<String,TeamAllGamePO>();
		
		try 
		{
			PreparedStatement pst=null;
			if(st.getKind().equals("A"))
			{
				sql="select * from teamgametbl where season=?";
				pst=conn.prepareStatement(sql);
				pst.setString(1, st.getSeason());
			}
			else
			{
				sql="select * from teamgametbl where season=? and kind=?";
				pst=conn.prepareStatement(sql);
				pst.setString(1, st.getSeason());
				pst.setString(2, st.getKind());
			}
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				TeamGamePO gamePo=makeTeamGamePO(rs);
				
				boolean hasOne=map.containsKey(gamePo.getTeamName());
				String teamName=gamePo.getTeamName();
				if(hasOne)
				{
					map.get(teamName).addGame(gamePo);
				}
				else
				{
					TeamAllGamePO newPo=new TeamAllGamePO();
					newPo.addGame(gamePo);
					newPo.setTeamName(teamName);
					map.put(teamName, newPo);
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
        return map;
    }
	
	public ArrayList<TeamAllGamePO> getTeamGameData(Selector st){
		setMaxID();
		Updator u=new Updator(st,teamId);
		
        if(containKey(u,teamGamemap.keySet()))
        {
        	Iterator<Updator> it=teamGamemap.keySet().iterator();
        	while(it.hasNext())
        	{
        		Updator tmp=it.next();
        		if(tmp.equals(u)&&(tmp.getMaxId()==u.getMaxId()))
        		{
        			 return MapToList.convertList(teamGamemap.get(tmp));
        	    }
        		else if(tmp.equals(u)&&(tmp.getMaxId()<u.getMaxId()))
        		{
        			 HashMap<String,TeamAllGamePO> oldMap=teamGamemap.get(tmp);
        			
        			 HashMap<String,TeamAllGamePO> newMap=updateTeamGameData(tmp.getMaxId(),oldMap);
        			 teamGamemap.put(u, newMap);
        			 return MapToList.convertList(newMap);
        		}
        	}
        }
        else
        {
        	HashMap<String,TeamAllGamePO> newMap=makeTeamGameData(st);
        	teamGamemap.put(u, newMap);
        	return MapToList.convertList(newMap);
        }
		return null;
 }
	private HashMap<String,TeamAllGamePO> updateTeamGameData(int id,HashMap<String,TeamAllGamePO> oldMap)
	{
		String updateSql="select * from teamgametbl where id >"+id;
		try 
		{
			/*PreparedStatement pst=conn.prepareStatement(updateSql);
			pst.setInt(1, id);*/
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(updateSql);
			while(rs.next())
			{
				TeamGamePO newPo=makeTeamGamePO(rs);
				String teamName=newPo.getTeamName();
				if(oldMap.containsKey(teamName))
				{
				oldMap.get(newPo.getTeamName()).addGame(newPo);
				}
				else
				{
				 TeamAllGamePO po=new TeamAllGamePO();
				 po.setTeamName(newPo.getTeamName());
				 po.addGame(newPo);
				 oldMap.put(teamName, po);
				}
			}
	      } 
		    catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		return oldMap;
	}
	
	
    public ArrayList<PlayerGamePO> getLatestPlayer()
	{
		String sql="select * from playergametbl where matchDate=(select max(matchDate) from playergametbl)";
		ArrayList<PlayerGamePO> list=new ArrayList<PlayerGamePO>();
		try 
		{
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				PlayerGamePO gamePo=makePlayerGamePO(rs);
				list.add(gamePo);
			}
			return list;
		} 
		catch (SQLException e) 
		{
		    e.printStackTrace();
		}
		return list;
	}
	
	private PlayerGamePO makePlayerGamePO(ResultSet rs){
	
		try 
		{
			PlayerGamePO gamePo=new PlayerGamePO();
		
			String playerName = rs.getString(1);
			String position=rs.getString(2);
			String teamName=rs.getString(3);
			int time=rs.getInt(4);
			
		    String matchDate=rs.getString(5);
			String matchPair=rs.getString(6);
			String matchResult=rs.getString(7);
			boolean isFirst=rs.getBoolean(8);
			
			int hitNum=rs.getInt(9);
			int shotNum=rs.getInt(10);
			int t_hitNum=rs.getInt(11);
			int t_shotNum=rs.getInt(12);
			int f_hitNum=rs.getInt(13);
			int f_shotNum=rs.getInt(14);
			int reb_Att_Num=rs.getInt(15);
			int reb_Def_Num=rs.getInt(16);
			int reb_Num=rs.getInt(17);
			int assNum=rs.getInt(18);
			int stlNum=rs.getInt(19);
			int blockNum=rs.getInt(20);
			int errNum=rs.getInt(21);
			int foulNum=rs.getInt(22);
			int score=rs.getInt(23);
			int twoNum=rs.getInt(24);
			boolean isDirty=rs.getBoolean(25);
			
			gamePo.setPlayerName(playerName);
			gamePo.setPosition(position);
			gamePo.setTeam(teamName);
			gamePo.setTime(time);
			
			gamePo.setMatchDate(matchDate);
			gamePo.setMatchPair(matchPair);
			
			gamePo.setMatchResult(matchResult);
			gamePo.setFirst(isFirst);
			
			gamePo.setHitShootNum(hitNum);
			gamePo.setShootNum(shotNum);
			
			gamePo.setThreePointNum(t_hitNum);
			gamePo.setThreeShootNum(t_shotNum);
			gamePo.setFreeHitNum(f_hitNum);
			gamePo.setFreeNum(f_shotNum);
			gamePo.setRebAttNum(reb_Att_Num);
		    gamePo.setRebDefNum(reb_Def_Num);
			gamePo.setRebTotalNum(reb_Num);
			gamePo.setAssistNum(assNum);
			gamePo.setStealNum(stlNum);
			gamePo.setBlockNum(blockNum);
			gamePo.setFoulNum(foulNum);
			gamePo.setErrorNum(errNum);
			gamePo.setScore(score);
			gamePo.setTwoNum(twoNum);
			gamePo.setDirty(isDirty);
			
			TeamInfo tif=new TeamInfo(rs.getInt(28),rs.getInt(29),rs.getInt(30),rs.getInt(31),
					rs.getInt(32),rs.getInt(33),rs.getInt(34),rs.getInt(35),rs.getInt(36),
					rs.getInt(37),rs.getInt(38),rs.getInt(39),rs.getInt(40));
			gamePo.setTif(tif);
			return gamePo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new PlayerGamePO();
	}
	
	private TeamGamePO makeTeamGamePO(ResultSet rs){
		TeamGamePO gamePo=new TeamGamePO();
		try 
		{
			gamePo.setTeamName(rs.getString(1));
			gamePo.setMatchDate(rs.getString(2));
			gamePo.setMatchPair(rs.getString(3));
			gamePo.setMatchResult(rs.getString(4));
			String partScore[]=new String[4];
			partScore[0]=rs.getString(5);
			partScore[1]=rs.getString(6);
			partScore[2]=rs.getString(7);
			partScore[3]=rs.getString(8);
			gamePo.setPartScore(partScore);
			gamePo.setHitShootNum(rs.getInt(9));
	        gamePo.setShootNum(rs.getInt(10));
			gamePo.setThreePointNum(rs.getInt(11));
			gamePo.setThreeShootNum(rs.getInt(12));
			gamePo.setFreeHitNum(rs.getInt(13));
			gamePo.setFreeNum(rs.getInt(14));
			gamePo.setRebAttNum(rs.getInt(15));
		    gamePo.setRebDefNum(rs.getInt(16));
			gamePo.setRebTotalNum(rs.getInt(17));
			gamePo.setAssistNum(rs.getInt(18));
			gamePo.setStealNum(rs.getInt(19));
			gamePo.setBlockNum(rs.getInt(20));
			gamePo.setErrorNum(rs.getInt(21));
			gamePo.setFoulNum(rs.getInt(22));
			gamePo.setAllPlayerTime(rs.getInt(23));
			//第24项，2分球数无用
			gamePo.setDirty(rs.getBoolean(25));
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gamePo;
		
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
	
	private void setMaxID(){
		String pSql="select max(id) from playerGametbl";
		String tSql="select max(id) from teamGametbl";
		try 
		{
			Statement p_stmt = conn.createStatement();
			ResultSet prs=p_stmt.executeQuery(pSql);
			while(prs.next())
			playerId=prs.getInt(1);
			Statement t_stmt = conn.createStatement();
			ResultSet trs=t_stmt.executeQuery(tSql);
			while(trs.next())
			teamId=trs.getInt(1);
	    } 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

    public static void main(String args[]){
    	GameSqlServer gss=new GameSqlServer();
    	PlayerChoosor pcs=new PlayerChoosor("2013-2014","J. Harden");
    	double time1=System.currentTimeMillis();
    	ArrayList<PlayerGamePO> list=gss.getPlayerGameData_BySeason(pcs);
    	double time2=System.currentTimeMillis();
    	System.out.println(time2-time1);
    	System.out.println(list.size());
    	/*Selector st=new Selector("2012-2013","A");
    	for(int i=0;i<5;i++){
        try 
    	{
			Thread.sleep(2000);
		} 
    	catch (InterruptedException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        double time1=System.currentTimeMillis();
    	ArrayList<TeamAllGamePO> list=gss.getTeamGameData(st);
    	double time2=System.currentTimeMillis();
    	System.out.println(time2-time1);*/
    	
    	
    	}
    	
    
    private boolean containKey(Updator up,Set<Updator> set){
    	Iterator<Updator> it=set.iterator();
    	while(it.hasNext())
    	{
    		if(it.next().equals(up))
    			return true;
    	}
		return false;
    }
    
    public ArrayList<PlayerGamePO> getPlayerGameData_BySeason(PlayerChoosor pcs){
    	String sql="select * from playergametbl where season=? and playername=?";
    	ArrayList<PlayerGamePO> resultList=new ArrayList<PlayerGamePO>();
    	try 
    	{
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, pcs.getSeason());
			pst.setString(2, pcs.getPlayerName());
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				PlayerGamePO po=makePlayerGamePO(rs);
				resultList.add(po);
			}
		} 
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
    	
		return resultList;
    }
    
}
