package businesslogic.playerbl;

import java.util.ArrayList;

import value.PlayerStandard;
import value.Value.Order;
import value.Value.Zone;
import vo.PlayerInfoVO;
import vo.PlayerVO;

public class palyermain {
	public static void main(String []args){
		//test1();
		test2();
		//test3();
	}
	
	public static void test1(){
		PlayerBLController p=new PlayerBLController();
		PlayerVO po=p.getPlayerTotalInfo("James Harden");
		System.out.println(po.getBirth()+" "+po.getAge()+" "+po.getExp()+" "+po.getHeight()
				+" "+po.getName()+" "+po.getNumber()
				+" "+po.getPosition()+" "+po.getSchool()+" "+po.getTeam()
				+" "+po.getWeight()+" "+po.getAction()+" "+po.getPic());
		
		PlayerInfoVO pvo=po.getAll();
		System.out.println(pvo.getAssistNum()+" "+pvo.getAssistRate()+" "+pvo.getAttRebRate()+" "+pvo.getBlockNum());
	}
	
	public static void test2(){
		PlayerBLController p=new PlayerBLController();
		ArrayList<PlayerInfoVO> lis=p.getPlayerTop_50(Order.DOWN, PlayerStandard.doub, "ALL", Zone.ALL);
		for(int i=0;i<lis.size();i++){
			PlayerInfoVO pp=lis.get(i);
			System.out.println(pp.getDoub()+" "+pp.getName()+" "+pp.getTeam());
		}
	}
	
	public static void test3(){
		PlayerBLController p=new PlayerBLController();
		ArrayList<PlayerInfoVO> lis=p.getPlayerTotalInOrder(Order.DOWN, PlayerStandard.doub);
		for(int i=0;i<lis.size();i++){
			PlayerInfoVO pp=lis.get(i);
			System.out.println(pp.getDoub()+" "+pp.getName()+" "+pp.getTeam());
		}
	}
}
