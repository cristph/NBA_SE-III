package data.teamdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import po.TeamAllGamePO;
import po.TeamGamePO;

public class TeamGameDataReader implements TeamGameDataReadService {

	private String currentDate=null;
	private String currentPair=null;
	private String currentResult=null;
	private String[] partScore=null;
	private String currentTeam=null;
	private String currentSeason=null;
	public HashMap<String, TeamAllGamePO> getTeamAllGamePo() {
		// TODO Auto-generated method stub
		HashMap<String,TeamAllGamePO> map=new HashMap<String,TeamAllGamePO>();
		String path="data/matches";
		File root=new File(path);
		File array[]=root.listFiles();
	    for(int i=0;i<array.length;i++)
	    {
	       File file=array[i];
	       String fileName=file.getName();
	       currentSeason=fileName.substring(0, 5);
	       try {
			FileReader inOne=new FileReader(file);
			BufferedReader inTwo=new BufferedReader(inOne);
			String line=null;
			int row=1;
			TeamGamePO currentPO=new TeamGamePO();
			boolean change=false;
			while((line=inTwo.readLine())!=null)
			{
				if(row==1)
				{
					initCurrent(line);
				}
				else if(row==2)
				{
					partScore=line.split(";");
				}
				else if(line.length()<=4)
				{   
					currentPO.setMatchDate(currentDate);
					currentPO.setMatchResult(currentResult);
					currentPO.setPartScore(partScore);
					currentPO.setMatchPair(currentPair);
					currentTeam=line;
					if(change)
					{
						boolean isExisted=map.containsKey(currentTeam);
						if(isExisted)
						{
							TeamAllGamePO temp=map.get(currentTeam);
							temp.addGame(currentPO);
						}
						else{
							TeamAllGamePO newPO=new TeamAllGamePO();
							newPO.addGame(currentPO);
							newPO.setTeamName(currentTeam);
							map.put(currentTeam,newPO);
							
						}
						}
					change=true;
			       }
				else{
					currentPO=addData(currentPO,line);
				}
				row++;
             }
			boolean isExisted=map.containsKey(currentTeam);
		       if(isExisted)
		    	   map.get(currentTeam).addGame(currentPO);
		       else{
		    		TeamAllGamePO newPO=new TeamAllGamePO();
					newPO.addGame(currentPO);
					newPO.setTeamName(currentTeam);
					map.put(currentTeam,newPO);
		       }
		    	   
			inTwo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	       
	    }
		
		return map;
	}
	
	
	private void initCurrent(String s){
		String info[]=s.split(";");
	    currentDate=changeDate(info[0]);
	    currentPair=info[1];
	    currentResult=info[2];
	  }
	private String changeDate(String s){
		String dateParts[]=s.split("-");
		int month=Integer.parseInt(dateParts[0]);
        String year[]=currentSeason.split("-");
        String preYear=year[0];
        String backYear=year[1];
        String yyear=null;
		if((month>0)&&(month<=4))
		{
			yyear="20"+backYear;
		}
		else
		{
			yyear="20"+preYear;
		}
		return yyear+"-"+s;
			
	}
	
	private TeamGamePO addData(TeamGamePO po,String line){
		String info[]=line.split(";");
		
		int time=0;
		String tim[]=info[2].split(":");
		try{
		if(tim.length==1)
			time=Integer.parseInt(tim[0])*60;
		else if(tim.length==2)
			time=Integer.parseInt(tim[0])*60+Integer.parseInt(tim[1]);
		}catch(NumberFormatException e){
			time=-1;
		}
		 
		int data[]=new int[15];
		for(int i=0;i<data.length;i++)
		{
			try{
			data[i]=Integer.parseInt(info[i+3]);
			}catch(NumberFormatException n){
				data[i]=-1;
				po.setIsDirty(true);
				}
	    }
		int hitNum=data[0];
		int shootNum=data[1];
		int threeHitNum=data[2];
		int threeShootNum=data[3];
		int freeHitNum=data[4];
		int freeShootNum=data[5];
		int attReb=data[6];
		int defReb=data[7];
		int reb=data[8];
		int ass=data[9];
		int steal=data[10];
		int block=data[11];
		int error=data[12];
		int foul=data[13];
		
		po.setAllPlayerTime(po.getAllPlayerTime()+time);
		po.setAssistNum(po.getAssistNum()+ass);
		po.setBlockNum(po.getBlockNum()+block);
		po.setFoulNum(po.getFoulNum()+foul);
		po.setFreeHitNum(po.getFreeHitNum()+freeHitNum);
		po.setFreeNum(po.getFreeNum()+freeShootNum);
		po.setHitShootNum(po.getHitShootNum()+hitNum);
		po.setRebAttNum(po.getRebAttNum()+attReb);
		po.setRebDefNum(po.getRebDefNum()+defReb);
		po.setRebTotalNum(po.getRebTotalNum()+reb);
		po.setShootNum(po.getShootNum()+shootNum);
		po.setStealNum(po.getStealNum()+steal);
		po.setErrorNum(po.getErrorNum()+error);
		po.setThreePointNum(po.getThreePointNum()+threeHitNum);
		po.setThreeShootNum(po.getThreeShootNum()+threeShootNum);
		
		return po;
	}
	/*球员名;位置;在场时间;投篮命中数;投篮出手数;三分命中数;三分出手数;罚球命中数;罚 球出手数;
     * 进攻（前场）篮板数;防守（后场）篮板数;总篮板数;助攻数;抢断数;盖帽数;失误 数;犯规数;
     * 个人得分; 
    */
	
}
