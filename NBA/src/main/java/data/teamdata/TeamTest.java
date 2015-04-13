package data.teamdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import po.TeamAllGamePO;
import po.TeamGamePO;

public class TeamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeamTest tt=new TeamTest();
        tt.test1();
	
	}
	public void test1(){
		Scanner sc=new Scanner(System.in);
		TeamGameDataReader tgds=new TeamGameDataReader();
		HashMap<String,TeamAllGamePO> myMap=new HashMap<String,TeamAllGamePO>();
        while(true){
		int c=sc.nextInt();
		double time1=System.currentTimeMillis();
		myMap=tgds.getTeamAllGamePo();
		double time2=System.currentTimeMillis();
		System.out.println(" 处理时间是"+(time2-time1));
		
		TeamAllGamePO hou=myMap.get("HOU");
		ArrayList<TeamGamePO> list=hou.getGameDataList();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{   
			TeamGamePO temp=list.get(i);
			System.out.println(temp.getMatchDate()+" "+temp.getMatchPair()+" "+temp.getMatchResult());
		}
        }
	}

}
