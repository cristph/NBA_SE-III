package businesslogic.playerbl;

import java.util.ArrayList;

import businesslogicservice.playerblservice.PlayerBLService;
import value.PlayerStandard;
import value.Value.Order;
import value.Value.Zone;
import vo.PlayerInfoVO;
import vo.PlayerVO;

public class PlayerBLController implements PlayerBLService{
	
	PlayerCalculator pc;
	
	public PlayerBLController(){
		pc=new PlayerCalculator();
	}

	public PlayerVO getPlayerTotalInfo(String name) {
		// TODO Auto-generated method stub
		PlayerVO pv=pc.getPlayerInfo(name);
		return pv;
	}
	
	public ArrayList<PlayerInfoVO> getPlayerAvgInOrder(Order order,
			PlayerStandard stan) {
		// TODO Auto-generated method stub
		ArrayList<PlayerInfoVO> res=pc.avgSort(order, stan);
		return res;
	}

	public ArrayList<PlayerInfoVO> getPlayerTotalInOrder(Order order,
			PlayerStandard stan) {
		// TODO Auto-generated method stub
		ArrayList<PlayerInfoVO> res=pc.totalSort(order, stan);
		return res;
	}

	public ArrayList<PlayerInfoVO> getPlayerTop_50(Order order,PlayerStandard stan,
			String pos,Zone zone) {
		// TODO Auto-generated method stub
		if(stan==PlayerStandard.score||stan==PlayerStandard.rebTotalNum||stan==PlayerStandard.assistNum
				||stan==PlayerStandard.par||stan==PlayerStandard.blockNum||stan==PlayerStandard.stealNum
				||stan==PlayerStandard.foulNum||stan==PlayerStandard.errorNum||stan==PlayerStandard.time
				||stan==PlayerStandard.doub){
			ArrayList<PlayerInfoVO> res=pc.getAvgTopList(order, stan, pos, zone);
			return res;
		}else if(stan==PlayerStandard.rate||stan==PlayerStandard.shooting||stan==PlayerStandard.threeRate
				||stan==PlayerStandard.freeRate){
			ArrayList<PlayerInfoVO> res=pc.getTotalTopList(order, stan, pos, zone);
			return res;
		}
		return null;
	}
	
}