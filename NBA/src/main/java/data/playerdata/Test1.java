package data.playerdata;

import java.util.ArrayList;

import data.teamdata.TeamData;
import po.PlayerPO;
import po.TeamPO;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Test1 t1=new Test1();
        t1.testTwo();
		
	}

	public void testOne(){
		   PlayerData pd=new PlayerData();
	        double time1=System.currentTimeMillis();
	        ArrayList<PlayerPO> list1=pd.getPlayerData();
	        double time2=System.currentTimeMillis();
	        double time=time2-time1;
	    	System.out.println("时间为"+time);

	        for(int i=0;i<list1.size();i++){
	        	PlayerPO temp=list1.get(i);
	        	System.out.println(temp.getName()+";"+temp.getExp()+";"+temp.getPosition()+";"
	        			+temp.getHeight()+";"+temp.getWeight()+";"+temp.getSchool()+";");
	        }
	}
	public void testTwo(){
		   TeamData td=new TeamData();
	        ArrayList<TeamPO> list=td.getTeamData();
	        for(int i=0;i<list.size();i++){
	        	TeamPO temp=list.get(i);
	        	System.out.println(temp.getTeamName()+";"+temp.getShortName()+";"+temp.getZone()
	        			+";"+temp.getBirthday()+";"+temp.getCompArea()+";"+temp.getHome()+";"+temp.getLocation());
	        }
	}
}
