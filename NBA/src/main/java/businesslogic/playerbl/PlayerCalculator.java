package businesslogic.playerbl;

import java.util.ArrayList;

import businesslogic.teambl.TeamInfo;
import businesslogicservice.teamblservice.TeamInfoProvider;
import po.PlayerAllGamePO;
import po.PlayerGamePO;
import vo.PlayerInfoVO;

public class PlayerCalculator {
	
	CalMethod cm;
	ArrayList<PlayerAllGamePO> gameList;
	
	ArrayList<PlayerInfoVO> totalList;
	ArrayList<PlayerInfoVO> avgList;
	
	public PlayerCalculator(){
		iniData();
		cm=new CalMethod();
	}
	
	
	/*
	 * calTotal()方法用于计算美个球员赛季总数据
	 * 结果保存于ArrayList<PlayerInfoVO> totalList中
	 */
	public void calTotal(){
		
		totalList=new ArrayList<PlayerInfoVO>();
		TeamInfoProvider tip=null; 
		
	    int gameListSize=gameList.size();
		//若球员列表不为空
		if(gameListSize>0){
			
			for(int i=0;i<gameListSize;i++){
				PlayerAllGamePO pag=gameList.get(i);
				ArrayList<PlayerGamePO> list=pag.getGameDataList();//获取该球员所有比赛数据列表
				
				int pgSize=list.size();//比赛场数
				String name=pag.getPlayerName();//队员名
				String team=pag.getTeamName();//所属球队
				int time = 0; //在场时间(分钟:秒)
				//inTime:参赛场数为pgSize
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
			    
			    int allPlayerTime=0; //球队所有队员上场时间（单位：秒）
			    int teamRebNum=0; //球队总篮板数
			    int oppTeamRebNum=0; //对手总篮板数
			    int teamAttRebNum=0; //球队总进攻篮板数
			    int oppTeamAttRebNum=0; //对手总进攻篮板数
			    int teamDefRebNum=0; //球队总防守篮板数
			    int oppTeamDefRebNum=0; //对手总防守篮板数
			    int teamHitNum=0; //球队总进球数
			    int oppAttNum=0; //对手进攻次数
			    int oppTwoNum=0; //对手两分球出手次数
			    int twoNum=0; //球员自己两分球出手数（不是球队）
			    int teamThrowNum=0; //球队所有球员总出手次数
			    int teamFreeNum=0; //球队所有球员罚球次数
			    int teamErrorNum=0; //球队所有球员失误次数
				
			    //若该球员参加过比赛
			    if(pgSize>0){
			    	
					for(int j=0;j<pgSize;j++){//计算各项指标总数据
						
						//获取单场比赛数据
						PlayerGamePO pg=list.get(j);
						//获取单场比赛的队伍信息
						TeamInfo tif=tip.getTeamInfo(pg.getTeam(), pg.getMatchDate());
						
						time+=pg.getTime(); //在场时间(分钟:秒)
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
					    
					    allPlayerTime+=tif.getAllPlayerTime(); //球队所有队员上场时间（单位：秒）
					    teamRebNum+=tif.getTeamRebNum(); //球队总篮板数
					    oppTeamRebNum+=tif.getOppTeamRebNum(); //对手总篮板数
					    teamAttRebNum+=tif.getTeamAttRebNum(); //球队总进攻篮板数
					    oppTeamAttRebNum+=tif.getOppTeamAttRebNum(); //对手总进攻篮板数
					    teamDefRebNum+=tif.getTeamDefRebNum(); //球队总防守篮板数
					    oppTeamDefRebNum+=tif.getOppTeamDefRebNum(); //对手总防守篮板数
					    teamHitNum+=tif.getTeamHitNum(); //球队总进球数
					    oppAttNum+=tif.getOppAttNum(); //对手进攻次数
					    oppTwoNum+=tif.getOppTwoNum(); //对手两分球出手次数
					    twoNum+=tif.getTwoNum(); //球员自己两分球出手数（不是球队）
					    teamThrowNum+=tif.getTeamThrowNum(); //球队所有球员总出手次数
					    teamFreeNum+=tif.getTeamFreeNum(); //球队所有球员罚球次数
					    teamErrorNum+=tif.getTeamErrorNum(); //球队所有球员失误次数
					    
					}//end of for loop
				}else{//该球员未参加任何比赛
					//do nothing
				}
				//计算比率
			    double T=cm.calT(time, allPlayerTime);//用于计算的数据T
			    double shooting=cm.calRate(hitShootNum, shootNum);//投篮命中率
			    double threeRate=cm.calRate(threePointNum, threeShootNum);//三分命中率
			    double freeRate=cm.calRate(freeHitNum, freeNum);//罚球命中率
			    double rate=cm.calEfficiency(rebTotalNum, assistNum, stealNum, blockNum, teamErrorNum, score, hitShootNum, threeShootNum, freeHitNum, teamFreeNum);//效率
			    double GMSC=cm.calGmScEfficiency(rebAttNum, rebDefNum, assistNum, stealNum, blockNum, teamErrorNum, foulNum, score, hitShootNum, threeShootNum, freeHitNum, teamFreeNum);//GmSc效率
			    double realHitRate=cm.calRealHitRate(score, threeShootNum, teamFreeNum);//真实命中率
			    double throwRate=cm.calThrowRate(hitShootNum, threeShootNum, threePointNum);//投篮效率
			    double rebRate=cm.calRebRate(rebTotalNum, T, teamRebNum, oppTeamRebNum);//篮板率
			    double attRebRate=cm.calRebRate(rebAttNum, T, teamAttRebNum, oppTeamAttRebNum);//进攻篮板率
			    double defRebRate=cm.calRebRate(rebDefNum, T, teamDefRebNum, oppTeamDefRebNum);//防守篮板率
			    double assistRate=cm.calAssistRate(assistNum, teamHitNum, hitShootNum, T);//助攻率
			    double stealRate=cm.calStealRate(stealNum, oppAttNum, T);//抢断率
			    double blockRate=cm.calBlockRate(blockNum, oppTwoNum, T);//盖帽率
			    double errorRate=cm.calErrorRate(teamErrorNum, twoNum, teamFreeNum);//失误率
			    double usedRate=cm.calUseRate(threeShootNum, freeNum, errorNum, T, teamThrowNum, teamFreeNum, teamErrorNum);//使用率
			    
			    PlayerInfoVO pi=new PlayerInfoVO(name, team, time, pgSize,
						firstTime, hitShootNum, shootNum,
						threePointNum, threeShootNum, freeHitNum,
						freeNum, rebAttNum, rebDefNum,
						rebTotalNum, assistNum, stealNum,
						blockNum, errorNum, foulNum, score,
						shooting, threeRate, freeRate, rate,
						GMSC, realHitRate, throwRate, rebRate,
						attRebRate, defRebRate, assistRate,
						stealRate, blockRate, errorRate,
						usedRate);
			    totalList.add(pi);
			}
			
		}	
	}
	
	
	/*
	 * calAvg()方法用于计算每个球员赛季平均数据
	 * 结果保存于ArrayList<PlayerInfoVO> avgList中
	public void calAvg(){
		avgList=new ArrayList<PlayerInfoVO>();
		
		int gameListSize=gameList.size();
		//若球员列表不为空
		if(gameListSize>0){
			for(int i=0;i<gameListSize;i++){
				PlayerAllGamePO pag=gameList.get(i);
				ArrayList<PlayerGamePO> list=pag.getGameDataList();//获取该球员所有比赛数据列表
				
				int pgSize=list.size();//比赛场数
				String name=pag.getPlayerName();//队员名
				String team=pag.getTeamName();//所属球队
				
				int time = 0; //在场时间(分钟:秒)
				//inTime:参赛场数为pgSize
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
			    
			    double shooting=0;//投篮命中率
			    double threeRate=0;//三分命中率
			    double freeRate=0;//罚球命中率
			    double rate=0;//效率
			    double GMSC=0;//GmSc效率
			    double realHitRate=0;//真实命中率
			    double throwRate=0;//投篮效率
			    double rebRate=0;//篮板率
			    double attRebRate=0;//进攻篮板率
			    double defRebRate=0;//防守篮板率
			    double assistRate=0;//助攻率
			    double stealRate=0;//抢断率
			    double blockRate=0;//盖帽率
			    double errorRate=0;//失误率
			    double usedRate=0;//使用率
				
				if(pgSize>0){
					for(int j=0;j<pgSize;j++){
						
						//获取单场比赛数据
						PlayerGamePO pg=list.get(j);
						
						int p_time=pg.getTime(); //在场时间(分钟:秒)
						int p_firstTime;
						if(pg.isFirst()){//先发场数
							p_firstTime=1;
							}else{
								p_firstTime=0;
							}
					    int p_hitShootNum=pg.getHitShootNum(); //投篮命中数
						int p_shootNum=pg.getShootNum(); //投篮出手数
						int p_threePointNum=pg.getThreePointNum(); //三分命中数
						int p_threeShootNum=pg.getThreeShootNum(); //三分出手数
						int p_freeHitNum=pg.getFreeHitNum(); //罚球命中数
						int p_freeNum=pg.getFreeNum(); //罚球出手数
						int p_rebAttNum=pg.getRebAttNum(); //进攻篮板数
						int p_rebDefNum=pg.getRebDefNum(); //防守篮板数
						int p_rebTotalNum=pg.getRebTotalNum(); //总篮板数
						int p_assistNum=pg.getAssistNum();//助攻数
						int p_stealNum=pg.getStealNum();//抢断数
						int p_blockNum=pg.getBlockNum();//盖帽数
						int p_errorNum=pg.getErrorNum();//失误数
						int p_foulNum=pg.getFoulNum();//犯规数
						int p_score=pg.getScore(); //个人得分
						
						int p_allPlayerTime=pg.getAllPlayerTime(); //球队所有队员上场时间（单位：秒）
						int p_teamRebNum=pg.getTeamRebNum(); //球队总篮板数
						int p_oppTeamRebNum=pg.getOppTeamRebNum(); //对手总篮板数
						int p_teamAttRebNum=pg.getTeamAttRebNum(); //球队总进攻篮板数
						int p_oppTeamAttRebNum=pg.getOppTeamAttRebNum(); //对手总进攻篮板数
						int p_teamDefRebNum=pg.getTeamDefRebNum(); //球队总防守篮板数
						int p_oppTeamDefRebNum=pg.getOppTeamDefRebNum(); //对手总防守篮板数
						int p_teamHitNum=pg.getTeamHitNum(); //球队总进球数
						int p_oppAttNum=pg.getOppAttNum(); //对手进攻次数
						int p_oppTwoNum=pg.getOppTwoNum(); //对手两分球出手次数
						int p_twoNum=pg.getTwoNum(); //球员自己两分球出手数（不是球队）
						int p_teamThrowNum=pg.getTeamThrowNum(); //球队所有球员总出手次数
						int p_teamFreeNum=pg.getTeamFreeNum(); //球队所有球员罚球次数
						int p_teamErrorNum=pg.getTeamErrorNum(); //球队所有球员失误次数
						
						//计算数据总和
						time+=p_time; //在场时间(分钟:秒)
						firstTime+=p_firstTime;//先发场数
					    hitShootNum+=p_hitShootNum; //投篮命中数
						shootNum+=p_shootNum; //投篮出手数
						threePointNum+=p_threePointNum; //三分命中数
						threeShootNum+=p_threeShootNum; //三分出手数
						freeHitNum+=p_freeHitNum; //罚球命中数
						freeNum+=p_freeNum; //罚球出手数
						rebAttNum+=p_rebAttNum; //进攻篮板数
						rebDefNum+=p_rebDefNum; //防守篮板数
						rebTotalNum+=p_rebTotalNum; //总篮板数
						assistNum+=p_assistNum;//助攻数
						stealNum+=p_stealNum;//抢断数
					    blockNum+=p_blockNum;//盖帽数
					    errorNum+=p_errorNum;//失误数
					    foulNum+=p_foulNum;//犯规数
					    score+=p_score; //个人得分
					    				    
					    //计算比率总和
					    double T=cm.calT(p_time, p_allPlayerTime);//用于计算的数据T
					    shooting+=cm.calRate(p_hitShootNum, p_shootNum);//投篮命中率
					    threeRate+=cm.calRate(p_threePointNum, p_threeShootNum);//三分命中率
					    freeRate+=cm.calRate(p_freeHitNum, p_freeNum);//罚球命中率
					    rate+=cm.calEfficiency(p_rebTotalNum, p_assistNum, p_stealNum, p_blockNum, p_teamErrorNum, p_score, p_hitShootNum, p_threeShootNum, p_freeHitNum, p_teamFreeNum);//效率
					    GMSC+=cm.calGmScEfficiency(p_rebAttNum, p_rebDefNum, p_assistNum, p_stealNum, p_blockNum, p_teamErrorNum, p_foulNum, p_score, p_hitShootNum, p_threeShootNum, p_freeHitNum, p_teamFreeNum);//GmSc效率
					    realHitRate+=cm.calRealHitRate(p_score, p_threeShootNum, p_teamFreeNum);//真实命中率
					    throwRate+=cm.calThrowRate(p_hitShootNum, p_threeShootNum, p_threePointNum);//投篮效率
					    rebRate+=cm.calRebRate(p_rebTotalNum, T, p_teamRebNum, p_oppTeamRebNum);//篮板率
					    attRebRate+=cm.calRebRate(p_rebAttNum, T, p_teamAttRebNum, p_oppTeamAttRebNum);//进攻篮板率
					    defRebRate+=cm.calRebRate(p_rebDefNum, T, p_teamDefRebNum, p_oppTeamDefRebNum);//防守篮板率
					    assistRate+=cm.calAssistRate(p_assistNum, p_teamHitNum, p_hitShootNum, T);//助攻率
					    stealRate+=cm.calStealRate(p_stealNum, p_oppAttNum, T);//抢断率
					    blockRate+=cm.calBlockRate(p_blockNum, p_oppTwoNum, T);//盖帽率
					    errorRate+=cm.calErrorRate(p_teamErrorNum, p_twoNum, p_teamFreeNum);//失误率
					    usedRate+=cm.calUseRate(p_threeShootNum, p_freeNum, p_errorNum, T, p_teamThrowNum, p_teamFreeNum, p_teamErrorNum);//使用率
					    
					    
					}
				}
				
				PlayerInfoVO pi=new PlayerInfoVO(name, team, 1.0*time/pgSize, pgSize,
						firstTime, 1.0*hitShootNum/pgSize, 1.0*shootNum/pgSize,
						1.0*threePointNum/pgSize, 1.0*threeShootNum/pgSize, 1.0*freeHitNum/pgSize,
						1.0*freeNum/pgSize, 1.0*rebAttNum/pgSize, 1.0*rebDefNum/pgSize,
						1.0*rebTotalNum/pgSize, 1.0*assistNum/pgSize, 1.0*stealNum/pgSize,
						1.0*blockNum/pgSize, 1.0*errorNum/pgSize, 1.0*foulNum/pgSize, 1.0*score/pgSize,
						1.0*shooting/pgSize, threeRate/pgSize, freeRate/pgSize, rate/pgSize,
						GMSC/pgSize, realHitRate/pgSize, throwRate/pgSize, rebRate/pgSize,
						attRebRate/pgSize, defRebRate/pgSize, assistRate/pgSize,
						stealRate/pgSize, blockRate/pgSize, errorRate/pgSize,
						usedRate/pgSize);
				
			    avgList.add(pi);
			}//end of for loop;循环依据球员
		}//end of if
	}
	*/
	
	/*
	 * iniData()方法用于初始化数据
	 * 结果存储于ArrayList<PlayerAllGamePO> gameList中
	 */
	public void iniData(){
		
		//从数据层获取数据
		gameList = null;
		
	}
	
	
	
}
