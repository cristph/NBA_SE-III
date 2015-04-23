package businesslogic.playerbl;

import java.util.ArrayList;

import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;
import value.PlayerStandard;
import value.Value.Age;
import value.Value.Field;
import value.Value.League;
import value.Value.Order;
import value.Value.Position;
import vo.PlayerVO;
import businesslogicservice.playerblservice.PlayerBLService;

public class playermain {
	
	PlayerBLService pbs;
	
	public playermain(){
		long a=System.currentTimeMillis();
		pbs=new PlayerBLController();
		long b=System.currentTimeMillis();
		long c=b-a;
		System.out.println("ini time: "+c);
	}
	
	public void test1(){
		long a=System.currentTimeMillis();
		ArrayList<PlayerHotInfo> list=pbs.getHotPlayer(Field.rebound, 5);
		long b=System.currentTimeMillis();
		long c=b-a;
		System.out.println("time: "+c);
		for(int i=0;i<list.size();i++){
			PlayerHotInfo phi=list.get(i);
			System.out.println(phi.getField()+" "+phi.getName()+" "+phi.getPosition()+" "+
					phi.getTeamName()+" "+phi.getUpgradeRate()+" "+phi.getValue());
		}
	}
	
	public void test2(){
		long a=System.currentTimeMillis();
		ArrayList<PlayerKingInfo> list=pbs.getDailyKingPlayer(Field.score, 100);
		long b=System.currentTimeMillis();
		long c=b-a;
		System.out.println("time: "+c);
		for(int i=0;i<list.size();i++){
			PlayerKingInfo pki=list.get(i);
			System.out.println(pki.getField()+" "+pki.getName()+" "+pki.getPosition()
					+" "+pki.getTeamName()+" "+pki.getValue());
		}
	}
	
	public void test3(){
		long a=System.currentTimeMillis();
		ArrayList<PlayerKingInfo> list=pbs.getSeasonKingPlayer(Field.score, 10);
		long b=System.currentTimeMillis();
		long c=b-a;
		System.out.println("time: "+c);
		for(int i=0;i<list.size();i++){
			PlayerKingInfo pki=list.get(i);
			System.out.println(pki.getField()+" "+pki.getName()+" "+pki.getPosition()
					+" "+pki.getTeamName()+" "+pki.getValue());
		}
	}
	
	public void test4(){
		long a=System.currentTimeMillis();
		ArrayList<PlayerHighInfo> list=pbs.getPlayerHighInfo(PlayerStandard.GMSC,Order.dsec,200);
		long b=System.currentTimeMillis();
		long c=b-a;
		System.out.println("time: "+c);
		for(int i=0;i<list.size();i++){
			PlayerHighInfo phi=list.get(i);
			
			System.out.println(phi.getName()+" "+phi.getStealEfficient()+" "+phi.getGmSc());
		}
	}
	
	public void test5(){
		long a=System.currentTimeMillis();
		ArrayList<PlayerNormalInfo> list=pbs.getPlayerTotalNormalInfo(Position.All, League.All, 
				Age.All, PlayerStandard.score, Order.dsec, 100);
		long b=System.currentTimeMillis();
		long c=b-a;
		System.out.println("time: "+c);
		if(list==null){
			System.out.println("nulllist");
		}
		if(list.size()==0){
			System.out.println("zeroSize");
		}
		for(int i=0;i<list.size();i++){
			PlayerNormalInfo pni=list.get(i);
			System.out.println(pni.getName()+" "+pni.getAge()+" "+pni.getTeamName()+" "+pni.getPoint()
					+" "+pni.getStart());
		}
	}
	
	public void test6(){
		long a=System.currentTimeMillis();
		ArrayList<PlayerNormalInfo> list=pbs.getPlayerAvgNormalInfo(Position.F, League.West, 
				Age.lv2, PlayerStandard.score, Order.dsec, 10);
		long b=System.currentTimeMillis();
		long c=b-a;
		System.out.println("time: "+c);
		if(list==null){
			System.out.println("nulllist");
		}
		if(list.size()==0){
			System.out.println("zeroSize");
		}
		for(int i=0;i<list.size();i++){
			PlayerNormalInfo pni=list.get(i);
			System.out.println(pni.getName()+" "+pni.getAge()+" "+pni.getTeamName()+" "+pni.getPoint());
		}
	}
	
	public void test7(){
		long a=System.currentTimeMillis();
		PlayerNormalInfo pni=pbs.getSinglePlayerNormalInfo("Kevin Durant");
		long b=System.currentTimeMillis();
		long c=b-a;
		System.out.println("time: "+c);
		System.out.println(pni.getName()+" "+pni.getAge()+" "+pni.getPoint()+" "+pni.getTeamName());
	}
	
	public void test8(){
		long a=System.currentTimeMillis();
		PlayerHighInfo phi=pbs.getSinglePlayerHighInfo("Kenyon Martin");
		long b=System.currentTimeMillis();
		long c=b-a;
		System.out.println("time: "+c);
		System.out.println(phi.getName()+" "+phi.getAssistEfficient()
				+" "+phi.getBlockShotEfficient()+" "+phi.getGmSc());
	}
	
	public void test9(){
		long a=System.currentTimeMillis();
		PlayerVO pv=pbs.getPlayerInfo("Kevin Durant");
		long b=System.currentTimeMillis();
		long c=b-a;
		System.out.println("time: "+c);
		System.out.println(pv.getName()+" "+pv.getNumber());
	}
	
	public static void main(String []args){
		playermain pm=new playermain();
		pm.test9();
	}
}
