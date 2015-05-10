package data.gamedata;

import java.util.ArrayList;
import java.util.Scanner;

import po.PlayerAllGamePO;
import po.PlayerGamePO;
import po.TeamAllGamePO;
import po.TeamGamePO;

public class GameTest {

	public static void main(String[] args) 
	{
	   test();
	}
	
	public static void test(){
		GameData.setPath("C://matches");
		GameData gd=new GameData();
		ArrayList<PlayerAllGamePO> playerList=gd.getPlayerGameData();
		for(int i=0;i<playerList.size();i++)
		{
			PlayerAllGamePO tmpPo=playerList.get(i);
			ArrayList<PlayerGamePO> poList=tmpPo.getGameDataList();
			for(int j=0;j<poList.size();j++)
			{
				PlayerGamePO po=poList.get(j);
				
				System.out.println("----------------");
				System.out.println(po.isDirty());
				System.out.println(po.getPlayerName());
				System.out.println(po.getTime());
				System.out.println(po.getScore());
				System.out.println("----------------");
				
			
			}
			
		}
	}
	

	public static void test1(){
		double time1=System.currentTimeMillis();
	
		
		//ArrayList<PlayerAllGamePO> list=gd.getPlayerGameData();
		
	  //  PlayerAllGamePO temp=list.get(24);
	//	System.out.println(temp.getPlayerName()+" "+temp.getTeamName()+" "+"打了"+temp.getGameDataList().size()+"场比赛"+" 他属于"+temp.getArea());
		/*ArrayList<PlayerGamePO> llist=temp.getGameDataList();
		for(int i=0;i<llist.size();i++)
		{
			PlayerGamePO po=llist.get(i);
			//System.out.println(po.getMatchDate()+" "+po.getMatchPair()+" "+po.getMatchResult());
		}*/
		
		double time2=System.currentTimeMillis();
		System.out.println("开机数据处理所用的时间"+(time2-time1));
		
	}
	public static void test2(){
		GameData gd=new GameData();
		ArrayList<PlayerGamePO> result=gd.get_Latest_PlayerGameData();
		System.out.println("今天共有"+result.size()+"名球员参赛");
		for(int i=0;i<result.size();i++)
		{
			PlayerGamePO po=result.get(i);
			System.out.println(po.getPlayerName()+" "+po.getPosition()+" "+po.getMatchDate()+" "+po.getMatchPair());
		}
	}
	public static void test3(){
		GameData gd=new GameData();
		ArrayList<TeamAllGamePO> result=gd.getTeamGameData();
		System.out.println("共有"+result.size()+"球队");
		for(int i=0;i<result.size();i++)
		{
			TeamAllGamePO po=result.get(i);
			System.out.println("球队"+po.getTeamName()+"----------------------------------------------------");
			ArrayList<TeamGamePO> tempList=po.getGameDataList();
			for(int j=0;j<tempList.size();j++)
			{
				TeamGamePO tmpPo=tempList.get(j);
				if(tmpPo.getIsDirty()==true){
				System.out.println(tmpPo.getMatchDate()+" "+tmpPo.getMatchPair()+" "+tmpPo.getMatchResult());
				System.out.println(tmpPo.getBlockNum()+" "+tmpPo.getAssistNum()+" "+tmpPo.getRebTotalNum());
				System.out.println(tmpPo.getErrorNum()+" "+tmpPo.getFoulNum());
				System.out.println(tmpPo.getIsDirty());
				System.out.println("****************");
				}
			}
		}
     }
	public static void test4(){
		GameData gd=new GameData();
		ArrayList<PlayerAllGamePO> allList=gd.getPlayerGameData();
		//System.out.println("共有"+allList.size()+"球员参加本赛季的比赛");
		for(int i=0;i<allList.size();i++)
		{
			PlayerAllGamePO po=allList.get(i);
			System.out.println("球员"+po.getPlayerName()+"----------------------------------------------------");
			ArrayList<PlayerGamePO> tempList=po.getGameDataList();
			for(int j=0;j<tempList.size();j++)
			{
				PlayerGamePO tmpPo=tempList.get(j);
				if(tmpPo.isDirty()==true)
				{
				System.out.println(tmpPo.getMatchDate()+" "+tmpPo.getMatchPair()+" "+tmpPo.getMatchResult());
				System.out.println(tmpPo.getBlockNum()+" "+tmpPo.getAssistNum()+" "+tmpPo.getRebTotalNum());
				System.out.println(tmpPo.getErrorNum()+" "+tmpPo.getFoulNum());
				System.out.println(tmpPo.isDirty());
				System.out.println("****************");
				}
			}
		}
	}
	
	public static void test5(){
		Scanner sc=new Scanner(System.in);
		GameData gd=new GameData();
		
		
        while(true)
        {
		
        int c=sc.nextInt();
		double time1=System.currentTimeMillis();
		ArrayList<PlayerAllGamePO> allList=gd.getPlayerGameData();
		double time2=System.currentTimeMillis();
		System.out.println("用户等待时间是"+(time2-time1));
		
	
		for(int i=0;i<allList.size();i++)
		{
		PlayerAllGamePO temp=allList.get(i);
		ArrayList<PlayerGamePO> list=temp.getGameDataList();
		System.out.println(temp.getPlayerName()+"打了"+list.size()+"场比赛");
		
		for(int j=0;j<list.size();j++)
		{
			PlayerGamePO po=list.get(j);
			System.out.println(po.getMatchDate()+" "+po.getMatchPair()+" "+po.getPosition()+" "+po.isFirst());
			
		}
		System.out.println("**************************************");
		
		
		}
	    }
        
	}
	
		
}
