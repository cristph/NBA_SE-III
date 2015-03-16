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
	
	//得到球员信息
	public ArrayList<PlayerVO> getPlayerTotalInfo(String name, Type type);
	
	//得到全部球员赛季平均数据排序结果
	public ArrayList<PlayerInfoVO> getPlayerAvgInOrder(Order order,PlayerStandard stan);
	
	//得到全部球员赛季总数据排序结果
	public ArrayList<PlayerInfoVO> getPlayerTotalInOrder(Order order,PlayerStandard stan);
	
	//得到球员前50列表
	public ArrayList<PlayerInfoVO> getPlayerTop_50(PlayerStandard stan,Position pos,League lea,Zone zone);
}