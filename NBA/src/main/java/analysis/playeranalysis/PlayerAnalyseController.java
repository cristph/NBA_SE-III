package analysis.playeranalysis;

import java.math.BigDecimal;
import java.util.ArrayList;

import po.PlayerGamePO;
import data.gamedata.GameData;
import data.gamedata.GameDataService;
import test.data.PlayerNormalInfo;
import util.PlayerChoosor;
import util.Selector;
import value.PlayerStandard;
import value.Value.Age;
import value.Value.League;
import value.Value.Order;
import value.Value.Position;
import businesslogic.playerbl.PlayerBLController;
import businesslogicservice.playerblservice.PlayerBLService;

public class PlayerAnalyseController implements PlayerAnalyseInter{
	
	PlayerBLService pbs;
	CMDHandler ch;
	
	public PlayerAnalyseController(){
		pbs=new PlayerBLController();
		ch=new CMDHandler();
	}

	@Override
	public String getSortInfo(Selector sel,String field, String playerName) {
		// TODO Auto-generated method stub
		String txtResult="";
		String data="";
		
		pbs.changeMatchSet(sel);
		
		//所有球员得分
		if(field.equals("得分")){
			ArrayList<PlayerNormalInfo> list=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
					PlayerStandard.score, Order.dsec, 1000);
			for(int i=0;i<list.size();i++){
				PlayerNormalInfo pni=list.get(i);
				double value=pni.getPoint();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data+=String.valueOf(value1);
		        if(i!=list.size()-1){
		        	data+=";";
		        }
				//System.out.println(i + " "+pni.getName()+" "+value1+" "+intime);
				
			}
			//System.out.println("data: "+data);
			
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			String ksResult=psa.KSTest(data);
			if(psa.testKS(ksResult)){
				//do with normal pdf
			}else{
				txtResult="我们做单总体K-S检验，作出假设："+ "\r\n"
						+"	H0:所有球员的场均得分服从正态分布，H1:所有球员的场均得分不服从正态分布"+"\r\n"
						+"而K-S检验结果为："+ksResult+"\r\n"
						+"由于P值小于5%，我们拒绝原假设H0,即认为所有球员的场均得分并不服从正态分布";
			}
			System.out.println(txtResult);
			
		}else if(field.equals("篮板")){
			
			ArrayList<PlayerNormalInfo> list=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
					PlayerStandard.rebTotalNum, Order.dsec, 1000);
			for(int i=0;i<list.size();i++){
				PlayerNormalInfo pni=list.get(i);
				double value=pni.getRebound();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data+=String.valueOf(value1);
		        if(i!=list.size()-1){
		        	data+=";";
		        }
				//System.out.println(i + " "+pni.getName()+" "+value1+" "+intime);
				
			}
			//System.out.println("data: "+data);
			
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			String ksResult=psa.KSTest(data);
			
			if(psa.testKS(ksResult)){
				//do with normal pdf
			}else{
				txtResult="我们做单总体K-S检验，作出假设："+ "\r\n"
						+"	H0:所有球员的场均得分服从正态分布，H1:所有球员的场均得分不服从正态分布"+"\r\n"
						+"而K-S检验结果为："+ksResult+"\r\n"
						+"由于P值小于5%，我们拒绝原假设H0,即认为所有球员的场均得分并不服从正态分布";
			}
			System.out.println(txtResult);
			
		}else if(field.equals("助攻")){
			
			ArrayList<PlayerNormalInfo> list=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
					PlayerStandard.assistNum, Order.dsec, 1000);
			for(int i=0;i<list.size();i++){
				PlayerNormalInfo pni=list.get(i);
				double value=pni.getAssist();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data+=String.valueOf(value1);
		        if(i!=list.size()-1){
		        	data+=";";
		        }
				//System.out.println(i + " "+pni.getName()+" "+value1+" "+intime);
				
			}
			//System.out.println("data: "+data);
			
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			String ksResult=psa.KSTest(data);
			if(psa.testKS(ksResult)){
				//do with normal pdf
			}else{
				txtResult="我们做单总体K-S检验，作出假设："+ "\r\n"
						+"	H0:所有球员的场均得分服从正态分布，H1:所有球员的场均得分不服从正态分布"+"\r\n"
						+"而K-S检验结果为："+ksResult+"\r\n"
						+"由于P值小于5%，我们拒绝原假设H0,即认为所有球员的场均得分并不服从正态分布";
			}
			System.out.println(txtResult);
			
		}else if(field.equals("抢断")){
			
			ArrayList<PlayerNormalInfo> list=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
					PlayerStandard.stealNum, Order.dsec, 1000);
			for(int i=0;i<list.size();i++){
				PlayerNormalInfo pni=list.get(i);
				double value=pni.getSteal();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data+=String.valueOf(value1);
		        if(i!=list.size()-1){
		        	data+=";";
		        }
				//System.out.println(i + " "+pni.getName()+" "+value1+" "+intime);
				
			}
			//System.out.println("data: "+data);
			
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			String ksResult=psa.KSTest(data);
			if(psa.testKS(ksResult)){
				//do with normal pdf
			}else{
				txtResult="我们做单总体K-S检验，作出假设："+ "\r\n"
						+"	H0:所有球员的场均得分服从正态分布，H1:所有球员的场均得分不服从正态分布"+"\r\n"
						+"而K-S检验结果为："+ksResult+"\r\n"
						+"由于P值小于5%，我们拒绝原假设H0,即认为所有球员的场均得分并不服从正态分布";
			}
			System.out.println(txtResult);
			
		}else if(field.equals("盖帽")){
			
			ArrayList<PlayerNormalInfo> list=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
					PlayerStandard.blockNum, Order.dsec, 1000);
			for(int i=0;i<list.size();i++){
				PlayerNormalInfo pni=list.get(i);
				double value=pni.getBlockShot();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data+=String.valueOf(value1);
		        if(i!=list.size()-1){
		        	data+=";";
		        }
				//System.out.println(i + " "+pni.getName()+" "+value1+" "+intime);
				
			}
			//System.out.println("data: "+data);
			
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			String ksResult=psa.KSTest(data);
			if(psa.testKS(ksResult)){
				//do with normal pdf
			}else{
				txtResult="我们做单总体K-S检验，作出假设："+ "\r\n"
						+"	H0:所有球员的场均得分服从正态分布，H1:所有球员的场均得分不服从正态分布"+"\r\n"
						+"而K-S检验结果为："+ksResult+"\r\n"
						+"由于P值小于5%，我们拒绝原假设H0,即认为所有球员的场均得分并不服从正态分布";
			}
			System.out.println(txtResult);
			
		}
		
		return txtResult;
	}

	@Override
	public String getIntervalInfo(Selector sel,String field, String playerName,double escredit) {
		// TODO Auto-generated method stub
		GameDataService gds=new GameData();
		String txtResult="";
		
		String data="";
		
		PlayerChoosor pcs=new PlayerChoosor(sel.getSeason(),playerName);
		ArrayList<PlayerGamePO> list=gds.getPlayerGameData_BySeason(pcs);
		
		//所有球员得分
		if(field.equals("得分")){
			for(int i=0;i<list.size();i++){
				PlayerGamePO pgp=list.get(i);
				double value=pgp.getScore();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data+=String.valueOf(value1);
		        if(i!=list.size()-1){
		        	data+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			System.out.println(data);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.intervalEstimation(list.size(), data,escredit);
			System.out.println(txtResult);
			
		}else if(field.equals("篮板")){
			for(int i=0;i<list.size();i++){
				PlayerGamePO pgp=list.get(i);
				double value=pgp.getRebTotalNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data+=String.valueOf(value1);
		        if(i!=list.size()-1){
		        	data+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			System.out.println(data);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.intervalEstimation(list.size(), data,escredit);
			System.out.println(txtResult);
			
		}else if(field.equals("助攻")){
			for(int i=0;i<list.size();i++){
				PlayerGamePO pgp=list.get(i);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data+=String.valueOf(value1);
		        if(i!=list.size()-1){
		        	data+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			System.out.println(data);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.intervalEstimation(list.size(), data,escredit);
			System.out.println(txtResult);
			
		}else if(field.equals("抢断")){
			for(int i=0;i<list.size();i++){
				PlayerGamePO pgp=list.get(i);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data+=String.valueOf(value1);
		        if(i!=list.size()-1){
		        	data+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			System.out.println(data);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.intervalEstimation(list.size(), data,escredit);
			System.out.println(txtResult);
			
		}else if(field.equals("盖帽")){
			
			for(int i=0;i<list.size();i++){
				PlayerGamePO pgp=list.get(i);
				double value=pgp.getBlockNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data+=String.valueOf(value1);
		        if(i!=list.size()-1){
		        	data+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			System.out.println(data);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.intervalEstimation(list.size(), data,escredit);
			System.out.println(txtResult);
			
		}
		return txtResult;
	}

	@Override
	public String getAvgEvolveInfo(String field, String playerName) {
		// TODO Auto-generated method stub
		String txtResult="";
		String data1="";
		String data2="";
		
		GameDataService gds=new GameData();
		
		PlayerChoosor pcs1=new PlayerChoosor("2012-2013",playerName);
		ArrayList<PlayerGamePO> list1=gds.getPlayerGameData_BySeason(pcs1);
		
		PlayerChoosor pcs2=new PlayerChoosor("2012-2013",playerName);
		ArrayList<PlayerGamePO> list2=gds.getPlayerGameData_BySeason(pcs2);
		
		
		if(field.equals("得分")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getScore();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getScore();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleZTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("篮板")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getRebTotalNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getRebTotalNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleZTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("助攻")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleZTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("抢断")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleZTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("盖帽")){
			
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getBlockNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getBlockNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleZTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
		}
		
		return txtResult;
	}

	@Override
	public String getVarEvolveInfo(String field, String playerName) {
		// TODO Auto-generated method stub
		String txtResult="";
		String data1="";
		String data2="";
		
		GameDataService gds=new GameData();
		
		PlayerChoosor pcs1=new PlayerChoosor("2012-2013",playerName);
		ArrayList<PlayerGamePO> list1=gds.getPlayerGameData_BySeason(pcs1);
		
		PlayerChoosor pcs2=new PlayerChoosor("2012-2013",playerName);
		ArrayList<PlayerGamePO> list2=gds.getPlayerGameData_BySeason(pcs2);
		
		
		if(field.equals("得分")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getScore();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getScore();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleFTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("篮板")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getRebTotalNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getRebTotalNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleFTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("助攻")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleFTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("抢断")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleFTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("盖帽")){
			
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getBlockNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getBlockNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleFTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
		}
		
		return txtResult;
	}

	@Override
	public String getPlayersInfo(Selector sel,String field, String playerAName,
			String playerBName) {
		// TODO Auto-generated method stub
		
		String txtResult="";
		String data1="";
		String data2="";
		
		GameDataService gds=new GameData();
		
		PlayerChoosor pcs1=new PlayerChoosor(sel.getSeason(),playerAName);
		ArrayList<PlayerGamePO> list1=gds.getPlayerGameData_BySeason(pcs1);
		
		PlayerChoosor pcs2=new PlayerChoosor(sel.getSeason(),playerBName);
		ArrayList<PlayerGamePO> list2=gds.getPlayerGameData_BySeason(pcs2);
		
		
		if(field.equals("得分")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getScore();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getScore();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			String name=" "+playerAName.replace(' ', '_')
					+" " + playerBName.replace(' ', '_')+" Score_Bar_Sheet"+" score";
			psa.getTwoBars(data1, data2, name);
			//System.out.println(txtResult);
			
		}else if(field.equals("篮板")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getRebTotalNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getRebTotalNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			String name=" "+playerAName.replace(' ', '_')
					+" " + playerBName.replace(' ', '_')+" Rebound_Bar_Sheet"+" rebound";
			psa.getTwoBars(data1, data2, name);
			//System.out.println(txtResult);
			
		}else if(field.equals("助攻")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			String name=" "+playerAName.replace(' ', '_')
					+" " + playerBName.replace(' ', '_')+" Assist_Bar_Sheet"+" assist";
			psa.getTwoBars(data1, data2, name);
			//System.out.println(txtResult);
			
		}else if(field.equals("抢断")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getStealNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			String name=" "+playerAName.replace(' ', '_')
					+" " + playerBName.replace(' ', '_')+" Steal_Bar_Sheet"+" steal";
			psa.getTwoBars(data1, data2, name);
			//System.out.println(txtResult);
			
		}else if(field.equals("盖帽")){
			
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getBlockNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getBlockNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			String name=" "+playerAName.replace(' ', '_')
					+" " + playerBName.replace(' ', '_')+" block_Bar_Sheet"+" block";
			System.out.println(name);
			psa.getTwoBars(data1, data2, name);
			//System.out.println(txtResult);
		}
		
		return txtResult;
	}

	@Override
	public String getPlayersAvgEvolveInfo(String field, String playerAName,
			String playerBName) {
		// TODO Auto-generated method stub
		String txtResult="";
		String data1="";
		String data2="";
		
		GameDataService gds=new GameData();
		
		PlayerChoosor pcs1=new PlayerChoosor("2012-2013",playerAName);
		ArrayList<PlayerGamePO> list1=gds.getPlayerGameData_BySeason(pcs1);
		
		PlayerChoosor pcs2=new PlayerChoosor("2012-2013",playerBName);
		ArrayList<PlayerGamePO> list2=gds.getPlayerGameData_BySeason(pcs2);
		
		
		if(field.equals("得分")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getScore();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getScore();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleZTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("篮板")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getRebTotalNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getRebTotalNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleZTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("助攻")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleZTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("抢断")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleZTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("盖帽")){
			
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getBlockNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getBlockNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleZTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
		}
		
		return txtResult;
	}

	@Override
	public String getPlayersVarEvolveInfo(String field, String playerAName,
			String playerBName) {
		// TODO Auto-generated method stub
		String txtResult="";
		String data1="";
		String data2="";
		
		GameDataService gds=new GameData();
		
		PlayerChoosor pcs1=new PlayerChoosor("2012-2013",playerAName);
		ArrayList<PlayerGamePO> list1=gds.getPlayerGameData_BySeason(pcs1);
		
		PlayerChoosor pcs2=new PlayerChoosor("2012-2013",playerBName);
		ArrayList<PlayerGamePO> list2=gds.getPlayerGameData_BySeason(pcs2);
		
		
		if(field.equals("得分")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getScore();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getScore();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleFTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("篮板")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getRebTotalNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getRebTotalNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleFTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("助攻")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleFTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("抢断")){
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getAssistNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleFTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
			
		}else if(field.equals("盖帽")){
			
			for(int i=0;i<list1.size();i++){
				PlayerGamePO pgp=list1.get(i);
				double value=pgp.getBlockNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data1+=String.valueOf(value1);
		        if(i!=list1.size()-1){
		        	data1+=";";
		        }
				//System.out.println(pgp.getPlayerName()+" "+pgp.getScore()+" "+pgp.getMatchDate());
			}
			
			for(int j=0;j<list2.size();j++){
				PlayerGamePO pgp=list2.get(j);
				double value=pgp.getBlockNum();
				//double intime=pni.getNumOfGame();
				BigDecimal bg = new BigDecimal(value);
		        double value1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		        data2+=String.valueOf(value1);
		        if(j!=list2.size()-1){
		        	data2+=";";
		        }
			}
			
			System.out.println(data1+"\r\n"+data2);
			PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
			txtResult=psa.doubleSampleFTest(list1.size(), data1, list2.size(), data2);
			System.out.println(txtResult);
		}
		
		return txtResult;
	}

	@Override
	public void showRedar(Selector sel,String playerAName, String playerBName) {
		// TODO Auto-generated method stub
		pbs.changeMatchSet(sel);
		ArrayList<PlayerNormalInfo> scorelist=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
				PlayerStandard.score, Order.dsec, 1000);
		ArrayList<PlayerNormalInfo> reblist=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
				PlayerStandard.rebTotalNum, Order.dsec, 1000);
		ArrayList<PlayerNormalInfo> assistlist=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
				PlayerStandard.assistNum, Order.dsec, 1000);
		ArrayList<PlayerNormalInfo> steallist=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
				PlayerStandard.stealNum, Order.dsec, 1000);
		ArrayList<PlayerNormalInfo> blocklist=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
				PlayerStandard.blockNum, Order.dsec, 1000);
		
		
		double max_score=scorelist.get(0).getPoint();
		double max_reb=reblist.get(0).getRebound();
		double max_ass=assistlist.get(0).getAssist();
		double max_steal=steallist.get(0).getSteal();
		double max_block=blocklist.get(0).getBlockShot();
		
		PlayerNormalInfo ainfo=pbs.getSinglePlayerNormalInfo(playerAName);
		
		PlayerNormalInfo binfo=pbs.getSinglePlayerNormalInfo(playerBName);

		double Atemp_score=ainfo.getPoint();
		double Atemp_reb=ainfo.getRebound();
		double Atemp_ass=ainfo.getAssist();
		double Atemp_steal=ainfo.getSteal();
		double Atemp_block=ainfo.getBlockShot();
		
		double Btemp_score=binfo.getPoint();
		double Btemp_reb=binfo.getRebound();
		double Btemp_ass=binfo.getAssist();
		double Btemp_steal=binfo.getSteal();
		double Btemp_block=binfo.getBlockShot();
		
		double a_score=Atemp_score/max_score;
		double b_score=Btemp_score/max_score;
		
		double a_reb=Atemp_reb/max_reb;
		double b_reb=Btemp_reb/max_reb;
		
		double a_ass=Atemp_ass/max_ass;
		double b_ass=Btemp_ass/max_ass;
		
		double a_steal=Atemp_steal/max_steal;
		double b_steal=Btemp_steal/max_steal;
		
		double a_block=Atemp_block/max_block;
		double b_block=Btemp_block/max_block;
		
		String data1=String.valueOf(a_score)+";"+String.valueOf(a_reb)+";"+String.valueOf(a_ass)
				+";"+String.valueOf(a_steal)+";"+String.valueOf(a_block);
		
		String data2=String.valueOf(b_score)+";"+String.valueOf(b_reb)+";"+String.valueOf(b_ass)
				+";"+String.valueOf(b_steal)+";"+String.valueOf(b_block);
		
		String name=" "+playerAName.replace(' ', '_')+" "+playerBName.replace(' ', '_');
		
		PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
		System.out.println(data1);
		System.out.println(data2);
		psa.getRedar(data1, data2, name);
		
	}

	@Override
	public void showRedar(Selector sel,String playerName) {
		// TODO Auto-generated method stub
		pbs.changeMatchSet(sel);
		ArrayList<PlayerNormalInfo> scorelist=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
				PlayerStandard.score, Order.dsec, 1000);
		ArrayList<PlayerNormalInfo> reblist=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
				PlayerStandard.rebTotalNum, Order.dsec, 1000);
		ArrayList<PlayerNormalInfo> assistlist=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
				PlayerStandard.assistNum, Order.dsec, 1000);
		ArrayList<PlayerNormalInfo> steallist=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
				PlayerStandard.stealNum, Order.dsec, 1000);
		ArrayList<PlayerNormalInfo> blocklist=pbs.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, 
				PlayerStandard.blockNum, Order.dsec, 1000);
		
		
		double max_score=scorelist.get(0).getPoint();
		double max_reb=reblist.get(0).getRebound();
		double max_ass=assistlist.get(0).getAssist();
		double max_steal=steallist.get(0).getSteal();
		double max_block=blocklist.get(0).getBlockShot();
		
		PlayerNormalInfo ainfo=pbs.getSinglePlayerNormalInfo(playerName);

		double Atemp_score=ainfo.getPoint();
		double Atemp_reb=ainfo.getRebound();
		double Atemp_ass=ainfo.getAssist();
		double Atemp_steal=ainfo.getSteal();
		double Atemp_block=ainfo.getBlockShot();
		
		double a_score=Atemp_score/max_score;
		double a_reb=Atemp_reb/max_reb;
		double a_ass=Atemp_ass/max_ass;
		double a_steal=Atemp_steal/max_steal;
		double a_block=Atemp_block/max_block;
		
		String data1=String.valueOf(a_score)+";"+String.valueOf(a_reb)+";"+String.valueOf(a_ass)
				+";"+String.valueOf(a_steal)+";"+String.valueOf(a_block);
		
		String name=" "+playerName.replace(' ', '_');
		
		PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
		System.out.println(data1);
		System.out.println(name);
		psa.getRedar_1(data1, name);
	}

	@Override
	public ArrayList<String> getPlayerNames() {
		// TODO Auto-generated method stub
		ArrayList<PlayerNormalInfo> list=pbs.getPlayerAvgNormalInfo(Position.All, 
				League.All, Age.All, PlayerStandard.score, Order.dsec, 1000);
		ArrayList<String> result=new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			result.add(list.get(i).getName());
		}
		return result;
	}
	
}
