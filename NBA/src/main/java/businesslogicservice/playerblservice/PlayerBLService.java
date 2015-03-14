package businesslogicservice.playerblservice;

import java.util.ArrayList;

import value.PlayerStandard;
import value.Value.League;
import value.Value.Order;
import value.Value.Position;
import value.Value.Type;
import value.Value.Zone;
import vo.PlayerInfoVO;
import vo.PlayerVO;

public interface PlayerBLService {
	
	//得到球员赛季总数据
	public ArrayList<PlayerInfoVO> getPlayerTotalInfo(String name, Type type);
	
	//得到球员赛季平均数据
	public ArrayList<PlayerInfoVO> getPlayerAvgInfo(String name, Type type);
	
	//得到球员排序列表
	public ArrayList<PlayerVO> getPlayerInOrder(Order order,PlayerStandard stan);
	
	//得到球员前50列表
	public ArrayList<PlayerVO> getPlayerTop_50(PlayerStandard stan,Position pos,League lea,Zone zone);
}
