package data.gamedata;

import java.sql.Connection;
import java.util.HashMap;

import data.sqlservice.DBUtil;

public class TeamInfoServer {

	private Connection conn=null;
	//private TeamInfo[] tifs=null;
	private static HashMap<String,TeamInfo> tifs=null;
	private static String currentPair=null;
	private static String currentDate=null;

	
	public TeamInfoServer(){
		conn=DBUtil.open();
		tifs=new HashMap<String,TeamInfo>();
	}
	protected void finalize(){
		DBUtil.close(conn);
	}
	public TeamInfo getTeamInfo(String matchdate,String matchPair,String team){
		
		if((matchdate!=null)&&(matchPair!=null)&&(team!=null))
		{
		
			boolean yes=((matchdate.equals(currentDate))&&(matchPair.equals(currentPair)));
		    if(!yes)
		    	{
		    	    return new TeamInfo();
		           /*String sql="select (teamName,all_time,reb_Num,reb_Att_Num,reb_Def_Num,hitNum,"
		           		+ "twoNum,shotNum,f_shotNum,errNum) from teamgametbl where matchDate=? "
		           		+ "and matchPair=?";
		           
		           String sql1="select * from teamgametbl where matchDate=? "
			           		+ "and matchPair=?";
		           currentDate=matchdate;
		           currentPair=matchPair;
		           tifs=new HashMap<String,TeamInfo>();
		           try 
		           {
			           PreparedStatement pst=conn.prepareStatement(sql1);
			           pst.setString(1, matchdate);
			           pst.setString(2, matchPair);
			
		               ResultSet rs=pst.executeQuery();
			           String names[]=new String[2];
			
			           int i=0;
			           while(rs.next())
			           {
				        	TeamInfo tif=new TeamInfo();
				            names[i]=rs.getString(1);
				            tif.setAllPlayerTime(rs.getInt(2));
				            tif.setTeamRebNum(rs.getInt(3));
				            tif.setTeamAttRebNum(rs.getInt(4));
				            tif.setTeamDefRebNum(rs.getInt(5));
				            tif.setTeamHitNum(rs.getInt(6));
				            tif.setTeamTwoNum(rs.getInt(7));
				            tif.setTeamThrowNum(rs.getInt(8));
				            tif.setTeamFreeNum(rs.getInt(9));
				            tif.setTeamErrorNum(rs.getInt(10));
				            tifs.put(names[i++], tif);
		                }
			            team1=names[0];
		            	team2=names[1];
			
			           TeamInfo tif1=tifs.get(names[0]);
			           TeamInfo tif2=tifs.get(names[1]);
			
			           tif1.setOppAttNum(tif2.getTeamAttRebNum());
			           tif1.setOppTeamAttRebNum(tif2.getTeamAttRebNum());
			           tif1.setOppTeamDefRebNum(tif2.getTeamDefRebNum());
			           tif1.setOppTeamRebNum(tif2.getTeamRebNum());
			           tif1.setOppTwoNum(tif2.getTeamTwoNum());
			
			           tif2.setOppAttNum(tif1.getTeamAttRebNum());
			           tif2.setOppTeamAttRebNum(tif1.getTeamAttRebNum());
		               tif2.setOppTeamDefRebNum(tif1.getTeamDefRebNum());
			           tif2.setOppTeamRebNum(tif1.getTeamRebNum());
			           tif2.setOppTwoNum(tif1.getTeamTwoNum());
			        } 
		            catch (SQLException e) 
		            {
			           e.printStackTrace();
		            }*/
		        }
		    else
		    {
		    	return tifs.get(team);
		     }
		}
		
		
		return new TeamInfo();
	
	}
}
