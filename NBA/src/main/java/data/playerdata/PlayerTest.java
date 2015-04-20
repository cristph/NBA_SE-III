package data.playerdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import po.PlayerAllGamePO;
import po.PlayerGamePO;

public class PlayerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          test1();
	}

	public static void test1(){
		Scanner sc=new Scanner(System.in);
		PlayerGameDataReader tgds=new PlayerGameDataReader();
		HashMap<String,PlayerAllGamePO> myMap=new HashMap<String,PlayerAllGamePO>();
        while(true){
		int c=sc.nextInt();
		double time1=System.currentTimeMillis();
		myMap=tgds.getPlayerGamePo();
		double time2=System.currentTimeMillis();
		System.out.println(" 处理时间是"+(time2-time1));
		
		PlayerAllGamePO hard=myMap.get("James Harden");
		ArrayList<PlayerGamePO> list=hard.getGameDataList();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{   
			PlayerGamePO temp=list.get(i);
			System.out.println(temp.getMatchDate()+" "+temp.getMatchPair()+" "+temp.getMatchResult()+""
					+" "+temp.getScore());
		}
        }
	}
	}

