package data.gamedata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import po.PlayerAllGamePO;
import po.PlayerGamePO;
import po.TeamAllGamePO;
import po.TeamGamePO;
import data.sqlservice.DBUtil;

public class GameSqlServer {

	private Connection conn=null;
	//private TeamInfoServer tis=null;
	public GameSqlServer(){
		conn=DBUtil.open();
	}
	
	public HashMap<String,PlayerAllGamePO> getPlayerGameData(String season,String kind){
		String sql="select * from playergametbl where season=? and kind=?";
		HashMap<String,PlayerAllGamePO> map=new HashMap<String,PlayerAllGamePO>();
		
		try 
		{
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, season);
			pst.setString(2, kind);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String playerName=rs.getString(1);
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
				
				PlayerGamePO gamePo=new PlayerGamePO();
				
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
				}
		    }
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return map;
}
	
	public HashMap<String,TeamAllGamePO> getTeamGameData(String season,String kind){
		String sql="select * from teamgametbl where season=? and kind=?";
		HashMap<String,TeamAllGamePO> map=new HashMap<String,TeamAllGamePO>();
		
		
/*		teamGameSql=create Table teamGameTbl(teamName varchar(5) not null,matchDate varchar(11) not null
 * ,matchPair varchar(8),matchResult varchar(8),chap1 varchar(6),chap2 varchar(6),chap3 varchar(6),
 * chap4 varchar(6),hitNum int,shotNum int,t_hitNum int,t_shotNum int,f_hitNum int,f_shotNum int,
 * reb_Att_Num int,reb_Def_Num int,reb_Num int,assNum int,stlNum int,blockNum int,errNum int,foulNum int
 * ,all_time int,twoNum int,isDirty varchar(10),kind varchar(1),season varchar(9),primary key(teamName,matchDate))
*/
		try 
		{
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, season);
			pst.setString(2, kind);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				TeamGamePO gamePo=new TeamGamePO();
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
				
				boolean hasOne=map.containsKey(gamePo.getTeamName());
				String teamName=gamePo.getTeamName();
				if(hasOne)
				{
					map.get(teamName).addGame(gamePo);
				}
				else
				{
					TeamAllGamePO newPo=new TeamAllGamePO();
					newPo.setTeamName(teamName);
					map.put(teamName, newPo);
				}
			}
			return map;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return map;
}
	public ArrayList<PlayerGamePO> getLatestPlayer(){
		String sql="select * from playergametbl where matchDate=(select max(matchDate) from playergametbl)";
		ArrayList<PlayerGamePO> list=new ArrayList<PlayerGamePO>();
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				PlayerGamePO gamePo=new PlayerGamePO();
				
				String playerName=rs.getString(1);
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
				list.add(gamePo);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
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
	
}
