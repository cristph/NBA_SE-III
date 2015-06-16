package data.funddata;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import data.fundDataReader.FundDataReadService;
import data.fundDataReader.FundDataReader;
import data.sqlservice.DBUtil;
import po.PlayerPO;
import po.TeamPO;

public class FundData implements FundDataService {

	FundDataReadService fdrs=null;
	File imgFold=null;
	File txtFile=null;
	File acimgFold=null;
	File portimgFold=null;
	File playerFold=null;
	
	public FundData(){
		fdrs=new FundDataReader();
		imgFold=new File("data/teamPng");
		txtFile=new File("data/teams/teams.txt");
		acimgFold=new File("data/players/action");
		portimgFold=new File("data/players/portrait");
		playerFold=new File("data/players/info");
	}
	

	public ArrayList<TeamPO> getTeamFundData() 
	{
	    String sql="select * from teamTbl";
	    Connection conn=DBUtil.open();
	    ArrayList<TeamPO> teamList=new ArrayList<TeamPO>();
	    try 
	    {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			//TeamPO po=new TeamPO();
			while(rs.next())
			{
			TeamPO po=new TeamPO();
			String teamName=rs.getString(1);
			String shortName=rs.getString(2);
			String city=rs.getString(3);
			String area=rs.getString(4);
			String zone=rs.getString(5);
			String home=rs.getString(6);
			String birthYear=rs.getString(7);
			String imgPath=rs.getString(8);
			
			po.setTeamName(teamName);
			po.setShortName(shortName);
			po.setLocation(city);
			po.setCompArea(area);
			po.setZone(zone);
			po.setHome(home);
			po.setBirthday(birthYear);
			Image img=Toolkit.getDefaultToolkit().getImage(imgPath);
			po.setTeamPic(img);
			teamList.add(po);
			}
			DBUtil.close(conn);
			
		} 
	    catch (SQLException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return teamList;
    }
	
	public HashMap<String, Image> getTeamImage() 
	{
		HashMap<String,Image> imgMap=fdrs.readTeamImgFile(imgFold);
		return imgMap;
	}


	public ArrayList<PlayerPO> getPlayerFundData()
	{
		    String sql="select * from playerTbl";
		    Connection conn=DBUtil.open();
		    ArrayList<PlayerPO> teamList=new ArrayList<PlayerPO>();
		    try 
		    {
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				//TeamPO po=new TeamPO();
				while(rs.next())
				{
				PlayerPO po=new PlayerPO();
				String playerName=rs.getString(1);
				String number=rs.getString(2);
				String position=rs.getString(3);
				String height=rs.getString(4);
				String weight=rs.getString(5);
				String birth=rs.getString(6);
				String age=rs.getString(7);
				String exp=rs.getString(8);
				String school=rs.getString(9);
				String actImgPath=rs.getString(10);
				String porImgPath=rs.getString(11);
				
				po.setName(playerName);
				po.setNumber(number);
				po.setPosition(position);
				po.setHeight(height);
				po.setWeight(weight);
				po.setBirth(birth);
				po.setAge(age);
				po.setExp(exp);
				po.setSchool(school);
				Image act=Toolkit.getDefaultToolkit().getImage(actImgPath);
				Image por=Toolkit.getDefaultToolkit().getImage(porImgPath);
				
				po.setActionImage(act);
				po.setPortaitImage(por);
				//Image img=Toolkit.getDefaultToolkit().getImage(imgPath);
				
				teamList.add(po);
				}
				DBUtil.close(conn);
				
			} 
		    catch (SQLException e) 
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return teamList;
	}
	
}
