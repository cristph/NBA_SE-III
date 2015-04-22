package data.funddata;

import java.util.ArrayList;

import po.PlayerPO;
import po.TeamPO;

public class FundTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//double time1=System.currentTimeMillis(); 
        testTeamInfo();
        //double time2=System.currentTimeMillis();
        //System.out.println(time2-time1);
		
	}

	public static void testTeamInfo(){
		FundData fd=new FundData();
	    ArrayList<TeamPO> list=fd.getTeamFundData();
	   // System.out.println(list.size());
	   // for(int i=0;i<list.size();i++)
	   // {
	    	//TeamPO temp=list.get(i);
	    	//System.out.println(temp.getTeamName()+" "+temp.getShortName()+" "+temp.getHome()+" "+
	    //	     temp.getCompArea());
	   // }
	}
	
	public static void testPlayerInfo(){
		FundData fd=new FundData();
	    ArrayList<PlayerPO> list=fd.getPlayerFundData();
	    System.out.println(list.size());
	    for(int i=0;i<list.size();i++)
	    {
	    	PlayerPO temp=list.get(i);
	    	System.out.println(temp.getName()+" "+temp.getAge()+" "+temp.getBirth()+" "+
	    	temp.getHeight()+" "+temp.getExp()+" "+temp.getNumber()+" "+temp.getSchool());
	    }
	}
	
}
