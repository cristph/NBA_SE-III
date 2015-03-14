package businesslogic.playerbl;

import java.util.ArrayList;

import po.PlayerAllGamePO;
import po.PlayerGamePO;
import vo.PlayerInfoVO;

public class PlayerCalculator {
	
	ArrayList<PlayerGameInfo> playerList;
	ArrayList<PlayerInfoVO> totalList;
	ArrayList<PlayerInfoVO> avgList;
	
	public PlayerCalculator(){
		playerList=new ArrayList<PlayerGameInfo>();
		iniData();
	}
	
	public void calTotal(){
		totalList=new ArrayList<PlayerInfoVO>();
		
		double shooting;//投篮命中率
	    double threeRate;//三分命中率
	    double freeRate;//罚球命中率
	    
	    double rate;//效率
	    double GMSC;//GmSc效率
	    double realHitRate;//真实命中率
	    double throwRate;//投篮效率
	    double rebRate;//篮板率
	    double attRebRate;//进攻篮板率
	    double defRebRate;//防守篮板率
	    double assistRate;//助攻率
	    double stealRate;//抢断率
	    double blockRate;//盖帽率
	    double errorRate;//失误率
	    double usedRate;//使用率
	}
	
	public void calAvg(){
		avgList=new ArrayList<PlayerInfoVO>();
	}
	
	/*
	 * iniData()方法用于初始化数据
	 * 从数据层获取所有球员的所有比赛数据，然后计算得每个球员的各项总数据
	 * 存储于ArrayList<PlayerGameInfo> playerList中
	 */
	public void iniData(){
		
		//从数据层获取数据
		ArrayList<PlayerAllGamePO> gameList = null;
		int gameListSize=gameList.size();
		
		//若球员列表不为空
		if(gameListSize>0){
			for(int i=0;i<gameListSize;i++){
				
				PlayerAllGamePO pag=gameList.get(i);
				
				ArrayList<PlayerGamePO> list=pag.getGameDataList();//获取该球员所有比赛数据列表
				int pgSize=list.size();//比赛场数
				
				String name=pag.getPlayerName();
				String team = null;//所属球队
				String time = null; //在场时间(分钟:秒)
				
				//参赛场数为pgSize
			    int firstTime=0;//先发场数
			    
			    int hitShootNum=0; //投篮命中数
				int shootNum=0; //投篮出手数
				
				int threePointNum=0; //三分命中数
				int threeShootNum=0; //三分出手数
				
				int freeHitNum=0; //罚球命中数
				int freeNum=0; //罚球出手数
				
				int rebAttNum=0; //进攻篮板数
				int rebDefNum=0; //防守篮板数
				int rebTotalNum=0; //总篮板数
				
				int assistNum=0;//助攻数
				int stealNum=0;//抢断数
			    int blockNum=0;//盖帽数
			    int errorNum=0;//失误数
			    int foulNum=0;//犯规数
			    
			    int score=0; //个人得分
				
			    //若该球员参加过比赛
			    if(pgSize>0){
			    	
					for(int j=0;j<pgSize;j++){//计算各项指标总数据
						
						//获取单场比赛数据
						PlayerGamePO pg=list.get(j);
						
						//time+=pg.getTime(); //在场时间(分钟:秒)
						
						if(pg.isFirst()){
							firstTime+=1;
							}//先发场数
					    
					    hitShootNum+=pg.getHitShootNum(); //投篮命中数
						shootNum+=pg.getShootNum(); //投篮出手数
						
						threePointNum+=pg.getThreePointNum(); //三分命中数
						threeShootNum+=pg.getThreeShootNum(); //三分出手数
						
						freeHitNum+=pg.getFreeHitNum(); //罚球命中数
						freeNum+=pg.getFreeNum(); //罚球出手数
						
						rebAttNum+=pg.getRebAttNum(); //进攻篮板数
						rebDefNum+=pg.getRebDefNum(); //防守篮板数
						rebTotalNum+=pg.getRebTotalNum(); //总篮板数
						
						assistNum+=pg.getAssistNum();//助攻数
						stealNum+=pg.getStealNum();//抢断数
					    blockNum+=pg.getBlockNum();//盖帽数
					    errorNum+=pg.getErrorNum();//失误数
					    foulNum+=pg.getFoulNum();//犯规数
					    
					    score+=pg.getScore(); //个人得分
					}//end of for loop
				}else{//该球员未参加任何比赛
					//do nothing
				}
			    PlayerGameInfo player=null;
				
				playerList.add(player);
			}
			
		}	
	}
	
	
	
}
