package businesslogic.playerbl;

import java.util.ArrayList;

import po.PlayerAllGamePO;
import po.PlayerGamePO;
import po.PlayerPO;
import test.data.PlayerHighInfo;
import test.data.PlayerNormalInfo;

public class PlayerCalculate {
	
	CalMethod cm;
	ArrayList<PlayerAllGamePO> playerGameList;
	ArrayList<PlayerPO> playerList;
	
	ArrayList<PlayerNormalInfo> tot_NInfoList;
	ArrayList<PlayerNormalInfo> avg_NInfoList;
	
	ArrayList<PlayerHighInfo> HInfoList;
	
	ArrayList<PlayerInfo> playerInfoList;
	
	
	public PlayerCalculate(){
		iniData();
		cm=new CalMethod();
	}
	
	
	/*
	 * 先计算PlayerNormalInfo
	 */
	public void calTotalNormalInfo(){
		tot_NInfoList=new ArrayList<PlayerNormalInfo>();
		
		int playerListSize=playerInfoList.size();
		if(playerListSize>0){//若球员列表不为空
			int age;
			double assist;
			double blockShot;
			double defend;
			double efficiency;
			double fault;
			double foul;
			double minute;
			String name;
			int numOfGame;
			double offend;
			//double penalty;
			double point;
			double rebound;
			//double shot;
			int start;
			double steal;
			String teamName;
			//double three;
			int hitShootNum; //投篮命中数
			int shootNum; //投篮出手数
			int threePointNum; //三分命中数
			int threeShootNum; //三分出手数
			
			for(int i=0;i<playerListSize;i++){//遍历球员
				PlayerInfo pi=playerInfoList.get(i);
				ArrayList<PlayerGamePO> gamelist=pi.getGameDataList();//获取该球员所有比赛列表
				int gameListSize=gamelist.size();
				//initialize values
				age=pi.getAge();
				assist=0;
				blockShot=0;
				defend=0;
				efficiency=0;
				fault=0;
				foul=0;
				minute=0;
				name=pi.getName();
				numOfGame=0;
				offend=0;
				//penalty=0;
				point=0;
				rebound=0;
				//shot=0;
				start=0;
				steal=0;
				teamName=pi.getTeamName();
				//three=0;
				hitShootNum=0; //投篮命中数
				shootNum=0; //投篮出手数
				threePointNum=0; //三分命中数
				threeShootNum=0; //三分出手数
				
				if(gameListSize>0){//若比赛列表不为空
					
					for(int j=0;j<gameListSize;j++){//遍历比赛
						
						PlayerGamePO pgp=gamelist.get(j);
						
						assist+=pgp.getAssistNum();
						blockShot+=pgp.getBlockNum();
						defend+=pgp.getRebDefNum();
						efficiency=efficiency+cm.calEfficiency(pgp.getRebTotalNum(), pgp.getAssistNum(), 
								pgp.getStealNum(), pgp.getBlockNum(), pgp.getErrorNum(), pgp.getScore(), 
								pgp.getHitShootNum(), pgp.getShootNum(), pgp.getFreeHitNum(), pgp.getFreeNum());
						fault+=pgp.getErrorNum();
						foul+=pgp.getFoulNum();
						minute+=pgp.getTime();//单位:秒
						numOfGame=1;
						offend+=pgp.getRebAttNum();
						point+=pgp.getScore();
						rebound+=pgp.getRebTotalNum();
						if(pgp.isFirst()){
							start+=1;
						}
						steal+=pgp.getStealNum();
						hitShootNum+=pgp.getHitShootNum(); //投篮命中数
						shootNum+=pgp.getShootNum(); //投篮出手数
						threePointNum+=pgp.getThreePointNum(); //三分命中数
						threeShootNum+=pgp.getThreeShootNum(); //三分出手数
					}
				}
				
				PlayerNormalInfo pni=new PlayerNormalInfo();
				pni.setAge(age);
				pni.setAssist(assist);
				pni.setBlockShot(blockShot);
				pni.setDefend(defend);
				pni.setEfficiency(efficiency);
				pni.setFault(fault);
				pni.setFoul(foul);
				pni.setMinute(minute/60);
				pni.setName(name);
				pni.setNumOfGame(numOfGame);
				pni.setOffend(offend);
				pni.setPenalty(cm.calRate(hitShootNum, shootNum));
				pni.setPoint(point);
				pni.setRebound(rebound);
				pni.setShot(cm.calRate(hitShootNum, shootNum));
				pni.setStart(start);
				pni.setSteal(steal);
				pni.setTeamName(teamName);
				pni.setThree(cm.calRate(threePointNum, threeShootNum));
				
				tot_NInfoList.add(pni);
			}
		}
		
	}
	
	
	/*
	 * 先计算PlayerNormalInfo
	 */
	public void calAvgNormalInfo(){
		avg_NInfoList=new ArrayList<PlayerNormalInfo>();
		int playerListSize=playerInfoList.size();
		if(playerListSize>0){//若球员列表不为空
			int age;
			double assist;
			double blockShot;
			double defend;
			double efficiency;
			double fault;
			double foul;
			double minute;
			String name;
			int numOfGame;
			double offend;
			//double penalty;
			double point;
			double rebound;
			//double shot;
			int start;
			double steal;
			String teamName;
			//double three;
			int hitShootNum; //投篮命中数
			int shootNum; //投篮出手数
			int threePointNum; //三分命中数
			int threeShootNum; //三分出手数
			
			for(int i=0;i<playerListSize;i++){//遍历球员
				PlayerInfo pi=playerInfoList.get(i);
				ArrayList<PlayerGamePO> gamelist=pi.getGameDataList();//获取该球员所有比赛列表
				int gameListSize=gamelist.size();
				//initialize values
				age=pi.getAge();
				assist=0;
				blockShot=0;
				defend=0;
				efficiency=0;
				fault=0;
				foul=0;
				minute=0;
				name=pi.getName();
				numOfGame=0;
				offend=0;
				//penalty=0;
				point=0;
				rebound=0;
				//shot=0;
				start=0;
				steal=0;
				teamName=pi.getTeamName();
				//three=0;
				hitShootNum=0; //投篮命中数
				shootNum=0; //投篮出手数
				threePointNum=0; //三分命中数
				threeShootNum=0; //三分出手数
				
				if(gameListSize>0){//若比赛列表不为空
					
					for(int j=0;j<gameListSize;j++){//遍历比赛
						
						PlayerGamePO pgp=gamelist.get(j);
						
						assist+=pgp.getAssistNum();
						blockShot+=pgp.getBlockNum();
						defend+=pgp.getRebDefNum();
						efficiency=efficiency+cm.calEfficiency(pgp.getRebTotalNum(), pgp.getAssistNum(), 
								pgp.getStealNum(), pgp.getBlockNum(), pgp.getErrorNum(), pgp.getScore(), 
								pgp.getHitShootNum(), pgp.getShootNum(), pgp.getFreeHitNum(), pgp.getFreeNum());
						fault+=pgp.getErrorNum();
						foul+=pgp.getFoulNum();
						minute+=pgp.getTime();//单位:秒
						numOfGame=1;
						offend+=pgp.getRebAttNum();
						point+=pgp.getScore();
						rebound+=pgp.getRebTotalNum();
						if(pgp.isFirst()){
							start+=1;
						}
						steal+=pgp.getStealNum();
						hitShootNum+=pgp.getHitShootNum(); //投篮命中数
						shootNum+=pgp.getShootNum(); //投篮出手数
						threePointNum+=pgp.getThreePointNum(); //三分命中数
						threeShootNum+=pgp.getThreeShootNum(); //三分出手数
					}
				}
				
				PlayerNormalInfo pni=new PlayerNormalInfo();
				pni.setAge(age);
				pni.setAssist(assist);
				pni.setBlockShot(blockShot);
				pni.setDefend(defend);
				pni.setEfficiency(efficiency);
				pni.setFault(fault);
				pni.setFoul(foul);
				pni.setMinute(minute/60);
				pni.setName(name);
				pni.setNumOfGame(numOfGame);
				pni.setOffend(offend);
				pni.setPenalty(cm.calRate(hitShootNum, shootNum));
				pni.setPoint(point);
				pni.setRebound(rebound);
				pni.setShot(cm.calRate(hitShootNum, shootNum));
				pni.setStart(start);
				pni.setSteal(steal);
				pni.setTeamName(teamName);
				pni.setThree(cm.calRate(threePointNum, threeShootNum));
				
				tot_NInfoList.add(pni);
			}
		}
	}
	
	
	/*
	 * iniData()初始化数据
	 * 匹配基本信息与比赛信息
	 * 结果存储于ArrayList<PlayerAllGamePO> gameList中
	 */
	public void iniData(){
		
		ArrayList<PlayerPO> temp_playerList = null;
		
		int playerListSize=playerGameList.size();
		for(int i=0;i<playerListSize;i++){//对每一个参赛的选手
			
			boolean isExist=false;
			
			PlayerAllGamePO pag=playerGameList.get(i);
			String pagName=pag.getPlayerName();
			String teamName=pag.getTeamName();
			ArrayList<PlayerGamePO> gameDataList=pag.getGameDataList();
			
			for(int j=0;j<temp_playerList.size();j++){//匹配其基本信息
				
				PlayerPO p=temp_playerList.get(j);
				String pName=p.getName();
				if(pagName.equals(pName)){
					String position=p.getPosition();
					int age=Integer.parseInt(p.getAge());
					PlayerInfo pi=new PlayerInfo(pagName, position, age, teamName, gameDataList);
					playerInfoList.add(pi);
					
					temp_playerList.remove(j);
					isExist=true;
					break;
				}
				
			}
			if(!isExist){//若无基本信息与其匹配
				String position=gameDataList.get(0).getPosition();
				PlayerInfo pi=new PlayerInfo(pagName, position, -1, teamName, gameDataList);
				playerInfoList.add(pi);
			}
			
		}
	}
	
}
