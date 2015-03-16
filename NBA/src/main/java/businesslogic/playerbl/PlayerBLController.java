package businesslogic.playerbl;

import java.util.ArrayList;

import businesslogicservice.playerblservice.PlayerBLService;
import value.PlayerStandard;
import value.Value.League;
import value.Value.Order;
import value.Value.Position;
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
		return null;
	}

	public ArrayList<PlayerInfoVO> getPlayerAvgInOrder(Order order,
			PlayerStandard stan) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PlayerInfoVO> getPlayerTotalInOrder(Order order,
			PlayerStandard stan) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PlayerInfoVO> getPlayerTop_50(PlayerStandard stan,
			Position pos, League lea, Zone zone) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
