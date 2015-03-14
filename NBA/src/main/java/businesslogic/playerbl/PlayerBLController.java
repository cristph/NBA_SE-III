package businesslogic.playerbl;

import java.util.ArrayList;

import businesslogicservice.playerblservice.PlayerBLService;
import value.PlayerStandard;
import value.Value.League;
import value.Value.Order;
import value.Value.Position;
import value.Value.Type;
import value.Value.Zone;
import vo.PlayerInfoVO;
import vo.PlayerVO;

public class PlayerBLController implements PlayerBLService{
	
	PlayerCalculator pc;
	
	public PlayerBLController(){
		pc=new PlayerCalculator();
	}

	public ArrayList<PlayerInfoVO> getPlayerTotalInfo(String name, Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PlayerInfoVO> getPlayerAvgInfo(String name, Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PlayerVO> getPlayerInOrder(Order order, PlayerStandard stan) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PlayerVO> getPlayerTop_50(PlayerStandard stan,
			Position pos, League lea, Zone zone) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
