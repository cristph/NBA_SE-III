package data.gamedata;

import java.util.ArrayList;

import po.PlayerGamePO;
import po.TeamGamePO;

public class DirtyFilter {

	GameInfo filt(GameInfo gif)
	{
		TeamGamePO po1=gif.getTeamGame1();
		boolean isDirty=po1.getIsDirty();
		if(isDirty)
			gif=fixData(gif);
		
		return gif;
	}
	private GameInfo fixData(GameInfo gif){
	   	gif=fixPlayerTime(gif);
	   	gif=fixPlayerScore(gif);
		
	    setDirty(gif);
		return gif;
	}
	
	private GameInfo fixPlayerTime(GameInfo gif)
    {
		TeamGamePO team1=gif.getTeamGame1();
		TeamGamePO team2=gif.getTeamGame2();
		ArrayList<PlayerGamePO> list=gif.getGameList();
		
		String teamName1=team1.getTeamName();
		
		int playerNum=-1;
		
		for(int i=0;i<list.size();i++)
		{
			PlayerGamePO tmp=list.get(i);
			int time=tmp.getTime();
			if(time==-1)
			{
				playerNum=i;
		    }
    	}
		
		
		if(playerNum!=-1)
		{
			int realTime=0;
			PlayerGamePO po=list.get(playerNum);
			if(po.getTeam().equals(teamName1))
			{
				int allTime=team1.getAllPlayerTime();
				int normalTime=fixTeamTime(allTime);
				realTime=normalTime-allTime+1;
			}
			else
			{
				int allTime=team2.getAllPlayerTime();
				int normalTime=fixTeamTime(allTime);
				realTime=normalTime-allTime;
			}
			po.setTime(realTime);
			}
		
		return gif;
     }
	
    private int fixTeamTime(int time){
		
		if((time>=11500)&&(time<=15000))
		{
			time=48*5*60;
	    }
		else if((time>15000)&&(time<=16000))
		{
		    time=48*4*60+5*5*60;	
		}
		else if((time>16000)&&(time<=18000))
		{
			time=48*4*60+(5*5*60)*2;
		}
		else if((time>18000)&&(time<=19000))
		{
			time=48*4*60+(5*5*60)*3;
		}
		else if((time>19000)&&(time<=21000))
		{
			time=48*4*60+(5*5*60)*4;
		}
		return time;
	}
	
	private GameInfo fixPlayerScore(GameInfo gif){
		ArrayList<PlayerGamePO> list=gif.getGameList();
	    
		TeamGamePO team1=gif.getTeamGame1();
		String teamName1=team1.getTeamName();
		
		String score=team1.getMatchResult();
		String ssore[]=score.split("-");
		int teamscore1=Integer.parseInt(ssore[0]);
		int teamscore2=Integer.parseInt(ssore[1]);
		
		int score1=0;
		int score2=0;
		int playerNum=-1;
		
		for(int i=0;i<list.size();i++)
		{
			PlayerGamePO tmp=list.get(i);
			String teamName=tmp.getTeam();
			int tmpscore=tmp.getScore();
			
			if(tmpscore!=-1)
			{
	     	    if(teamName.equals(teamName1))
		    	{
				   score1=score1+tmpscore;
			    }
	     	    else
	     	    {
	     	    	score2=score2+tmpscore;
	      	    }
		    }
			else
			{
				playerNum=i;
			}
		}
		if(playerNum!=-1)
		{
			int realScore=0;
			PlayerGamePO po=list.get(playerNum);
			if(po.getTeam().equals(teamName1))
			{
				realScore=teamscore1-score1;
			}
			else
			{
				realScore=teamscore2-score2;
			}
			po.setScore(realScore);
		}
		
		return gif;
	}
	
	private void setDirty(GameInfo gif){
		ArrayList<PlayerGamePO> poList=gif.getGameList();
		boolean isDirty=false;
		for(int i=0;i<poList.size();i++)
		{
			isDirty=isDirty(poList.get(i));
			if(isDirty)
				break;
	    }
		for(int i=0;i<poList.size();i++)
		{
			PlayerGamePO po=poList.get(i);
			po.setDirty(isDirty);
		}
		gif.getTeamGame1().setIsDirty(isDirty);
		gif.getTeamGame2().setIsDirty(isDirty);
		
	}
	
	private boolean isDirty(PlayerGamePO temp){
		
		boolean b1=(temp.getHitShootNum()==-1);
		boolean b2=(temp.getShootNum()==-1);
		boolean b3=(temp.getThreePointNum()==-1);
		boolean b4=(temp.getThreeShootNum()==-1);
		boolean b5=(temp.getFreeHitNum()==-1);
		boolean b6=(temp.getFreeNum()==-1);
		boolean b7=(temp.getRebAttNum()==-1);
		boolean b8=(temp.getRebDefNum()==-1);
		boolean b9=((temp.getRebTotalNum()==-1));
		boolean b10=(temp.getAssistNum()==-1);
		boolean b11=(temp.getStealNum()==-1);
		boolean b12=(temp.getBlockNum()==-1);
		boolean b13=(temp.getFoulNum()==-1);
		boolean b14=(temp.getErrorNum()==-1);
		boolean b15=(temp.getScore()==-1);
		
		boolean dirty=(b1||b2||b3||b4||b5||b6||b7||b8||b9||b10||b11||b12||b13||b14||b15);
		return dirty;
	}
	
	
	/*private GameInfo filtScore(GameInfo gif) {
		// TODO Auto-generated method stub
		ArrayList<PlayerGamePO> list=gif.getGameList();
		
		TeamGamePO po1=gif.getTeamGame1();
		TeamGamePO po2=gif.getTeamGame2();
		
		String teamName1=po1.getTeamName();
		
		String score[]=po1.getMatchPair().split("-");
		int teamScore1=Integer.parseInt(score[0]);
		int teamScore2=Integer.parseInt(score[1]);
		
		int sumScore1=0;
		int sumScore2=0;
		
		for(int i=0;i<list.size();i++)
		{
			PlayerGamePO po=list.get(i);
			String poTeam=po.getTeam();
			if(poTeam.equals(teamName1))
				sumScore1+=(po.getScore());
			else
				sumScore2+=(po.getScore());
		}
		boolean b1=(sumScore1==teamScore1);
		boolean b2=(sumScore2==teamScore2);
		
		boolean right=(b1&&b2);
		if(!right)
		{   
			
			filtDeeply()
		}  
        return ;
	}
	*/
  
}
