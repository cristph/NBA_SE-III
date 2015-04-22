package businesslogic.playerbl;

import java.util.ArrayList;

import test.data.PlayerHotInfo;
import value.Value.Field;
import businesslogicservice.playerblservice.PlayerBLService;

public class playermain {
	
	PlayerBLService pbs;
	
	public playermain(){
		pbs=new PlayerBLController();
	}
	
	public void test1(){
		long a=System.currentTimeMillis();
		ArrayList<PlayerHotInfo> list=pbs.getHotPlayer(Field.score, 5);
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
		
	}
	
	public static void main(String []args){
		playermain pm=new playermain();
		pm.test1();
	}
}
