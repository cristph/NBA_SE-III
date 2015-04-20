package data.gamedata;

import java.util.ArrayList;

import po.PlayerAllGamePO;
import po.PlayerGamePO;

public class GameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        test1();
	}

	public static void test1(){
		double time1=System.currentTimeMillis();
		GameData gd=new GameData();
		
		ArrayList<PlayerAllGamePO> list=gd.getPlayerGameData();
		
		
		/*for(int i=0;i<list.size();i++)
		{
			PlayerAllGamePO temp=list.get(i);
			System.out.print(temp.getPlayerName()+" "+temp.getTeamName()+" "+"打了"+temp.getGameDataList().size()+"场比赛");
			
		}*/
		
	    PlayerAllGamePO temp=list.get(24);
		System.out.println(temp.getPlayerName()+" "+temp.getTeamName()+" "+"打了"+temp.getGameDataList().size()+"场比赛"+" 他属于"+temp.getArea());
		ArrayList<PlayerGamePO> llist=temp.getGameDataList();
		for(int i=0;i<llist.size();i++)
		{
			PlayerGamePO po=llist.get(i);
			System.out.println(po.getMatchDate()+" "+po.getMatchPair()+" "+po.getMatchResult());
		}
		
		double time2=System.currentTimeMillis();
		System.out.println("开机数据处理所用的时间"+(time2-time1));
		
	}
	
}
