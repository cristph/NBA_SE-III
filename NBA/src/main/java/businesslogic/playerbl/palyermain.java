package businesslogic.playerbl;

import java.util.ArrayList;

import value.PlayerStandard;
import value.Value.Order;
import vo.PlayerInfoVO;
import vo.PlayerVO;

public class palyermain {
	public static void main(String []args){
		PlayerBLController p=new PlayerBLController();
		/*
		ArrayList<PlayerInfoVO> list=p.getPlayerAvgInOrder(Order.UP, PlayerStandard.assistNum);
		for(int i=0;i<list.size();i++){
			PlayerInfoVO pp=list.get(i);
			System.out.println(pp.getName()+"  "+pp.getAssistNum());
		}
		*/
		
		PlayerVO po=p.getPlayerTotalInfo("Akkk");
		System.out.println("birth: "+po.getBirth());
	}
}
