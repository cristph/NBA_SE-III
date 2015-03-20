package data.teamdata;

import java.util.ArrayList;

import po.TeamAllGamePO;
import po.TeamGamePO;
import dataservice.teamdataservice.TeamDataService;

public class Test {

	TeamDataService teamData=new TeamData();
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Test t=new Test();
       t.testTwo();
	}

	public void testOne(){
		ArrayList<TeamAllGamePO> list=teamData.getTeamGameData();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			TeamAllGamePO current=list.get(i);
			ArrayList<TeamGamePO> poList=current.getGameDataList();
			System.out.print("球队"+current.getTeamName());
            System.out.println(" 比赛数："+poList.size());
			for(int j=0;j<poList.size();j++)
			{
				TeamGamePO temp=poList.get(j);
				System.out.print("日期："+temp.getMatchDate()+" 进攻篮板数："+temp.getRebAttNum()
						+" 防守篮板数："+temp.getRebDefNum()+" 总篮板数"+temp.getRebTotalNum()+
						" 投篮命中数"+temp.getHitShootNum());
				System.out.println();

			}
			
		}
	}

    public void testTwo(){
    	TeamData td=new TeamData();
    	ArrayList<TeamAllGamePO> list=td.getTeamGameData();
    	System.out.println(list.size());
    	
    	for(int j=0;j<list.size();j++){
    	TeamAllGamePO one=list.get(j);
    	ArrayList<TeamGamePO> l=one.getGameDataList();
    	
    	for(int i=0;i<l.size();i++)
    	{
    		TeamGamePO temp=l.get(i);
    		if(temp.getIsDirty()==true){
    		System.out.println(temp.getMatchDate()+" "+temp.getMatchPair()+" "+temp.getMatchResult());
    		}
    		}
    	
    }

}
}