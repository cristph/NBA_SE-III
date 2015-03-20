package data.playerdata;

import java.io.File;
import java.util.ArrayList;

import data.teamdata.TeamData;
import po.PlayerAllGamePO;
import po.PlayerGamePO;
import po.PlayerPO;
import po.TeamPO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Test t1=new Test();
        t1.testOne();
		
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
	        			+temp.getHeight()+";"+temp.getWeight()+";"+temp.getSchool()+";"+temp.getActionImage()+";"+temp.getPortaitImage());
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
  
	public void testThree(){
       //PlayerGameDataReader pgdr=new PlayerGameDataReader();
       PlayerData pd=new PlayerData();
       ArrayList<PlayerAllGamePO>list=pd.getPlayerGameData();
       ArrayList<String> nameList=new ArrayList<String>();
       for(int i=0;i<list.size();i++){
    	   PlayerAllGamePO temp=list.get(i);
    	   System.out.println("球员："+temp.getPlayerName()+" 球队："+temp.getTeamName()+
    		   " 参加比赛数："+temp.getGameDataList().size());
    	   
    	   ArrayList<PlayerGamePO> l=temp.getGameDataList();
    	   for(int j=0;j<l.size();j++)
    	   {
    		   PlayerGamePO tempp=l.get(j);
    		   System.out.print(" 比赛时间"+tempp.getMatchDate());
    		   System.out.print(" 比赛双方"+tempp.getMatchPair());
    		   System.out.print(" 比赛结果"+tempp.getMatchResult());
    		   System.out.print(" 上场时间"+tempp.getTime());
    		   System.out.print(" 个人得分"+tempp.getScore());
    		   System.out.println();
    	   }
    	   
    	  // String name=temp.getPlayerName();
    	  // name=name.replace(" ", "");
    	  // if(nameList.contains(name)){
    	//	  System.out.println(name+"重复了"); 
    	 //  }
    	//   else
    	//	   nameList.add(name);
    	   
       }
       System.out.println("最终结果的长度是"+list.size());
       System.out.println("名单的长度是"+nameList.size());
       
	}

	public void testFour(){
		String path="data/players/info";
		PlayerData pd=new PlayerData();
	    ArrayList<PlayerAllGamePO>  list=pd.getPlayerGameData();
		
	    File root=new File(path);
		File array[]=root.listFiles();
		ArrayList<String> nameList=new ArrayList<String>();
		for(int i=0;i<array.length;i++){
			String fileName=array[i].getName();
			String playerName=fileName.substring(0,fileName.indexOf('.'));
			playerName=playerName.replace(" ", "");
			nameList.add(playerName);
		}
		int num=0;
		
		for(int i=0;i<list.size();i++){
			PlayerAllGamePO temp=list.get(i); 
			String playerName=temp.getPlayerName();
			playerName=playerName.replace(" ", "");

			if(!nameList.contains(playerName)){
			//	System.out.println(playerName+"不在名单中");
				//PlayerGamePO gamePo=temp.getGameDataList().get(0);
				//System.out.println(gamePo.getMatchPair()+" "+gamePo.getMatchDate());
				num++;
			}
		}
		System.out.println("不在名单中的共有"+num+"人");
		//System.out.println("名单的长度为"+array.length);
			
		
	}
}
