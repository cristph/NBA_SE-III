package data.teamdata;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import po.TeamAllGamePO;
import po.TeamPO;
import dataservice.teamdataservice.TeamDataService;

public class TeamData implements TeamDataService {

	static boolean hasDraw=false;
	static HashMap<String,Image> map=null;
	public ArrayList<TeamPO> getTeamData() {
		// TODO Auto-generated method stub
		TeamDataReadService tdrs=new TeamDataReader();
		ArrayList<TeamPO> list=tdrs.getTeamPo();
		
		return list;
	}

	public HashMap<String, Image> getTeamImage() {
		// TODO Auto-generated method stub
		if(!hasDraw){
		TeamDataReadService tdrs=new TeamDataReader();
		HashMap<String,Image> result=tdrs.getTeamImage();
		map=result;
		return result;
		}
		else{
			return map;
		}
		//Image img=result.get("MEM");
		//System.out.println("------------------TeamData结束");
		
		
	}
	
	public ArrayList<TeamAllGamePO> getTeamGameData() {
		// TODO Auto-generated method stub
		TeamGameDataReadService tgdrs=new TeamGameDataReader();
		HashMap<String,TeamAllGamePO> map=tgdrs.getTeamAllGamePo();
		java.util.Iterator<String> it=map.keySet().iterator();
		
		ArrayList<TeamAllGamePO> list=new ArrayList<TeamAllGamePO>();
		while(it.hasNext()){
			TeamAllGamePO temp=map.get(it.next());
			list.add(temp);
		}
		
		return list;
	}

	public static void main(String args[]){
		TeamData td=new TeamData();
		td.getTeamImage();
	}

}
