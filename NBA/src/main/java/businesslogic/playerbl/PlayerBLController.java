package businesslogic.playerbl;

import java.util.ArrayList;

import businesslogicservice.playerblservice.PlayerBLService;
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

public class PlayerBLController implements PlayerBLService{
	
	PlayerCalculator pc;
	
	public PlayerBLController(){
		pc=new PlayerCalculator();
	}
	
	/*
	 * old lines
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
				||stan==PlayerStandard.foulNum||stan==PlayerStandard.errorNum||stan==PlayerStandard.time){
			ArrayList<PlayerInfoVO> res=pc.getAvgTopList(order, stan, pos, zone);
			return res;
		}else if(stan==PlayerStandard.rate||stan==PlayerStandard.shooting||stan==PlayerStandard.threeRate
				||stan==PlayerStandard.freeRate||stan==PlayerStandard.doub){
			ArrayList<PlayerInfoVO> res=pc.getTotalTopList(order, stan, pos, zone);
			return res;
		}
		return null;
	}
	*
	*/
	
	
	/*
	 * now begin new lines
	 * @date 2015-4-13
	 */
	
	/*
	 * 获取进步最快球员
	 * @param field:排序依据，可取值Field枚举类
	 * @param num:返回球员个数
	 * @return ArrayList<PlayerHotInfo>
	 */
	public ArrayList<PlayerHotInfo> getHotPlayer(Field field,int num){
		return null;
		
	}
	
	/*
	 * 获取当天热点球员
	 * @param field:排序依据，可取值Field枚举类
	 * @param num:返回球员个数
	 * @return ArrayList<PlayerKingInfo>
	 */
	public ArrayList<PlayerKingInfo> getSeasonKingPlayer(Field field,int num){
		return null;
		
	}
	
	/*
	 * 获取赛季热点球员
	 * @param field:排序依据，可取值Field枚举类
	 * @param num:返回球员个数
	 * @return ArrayList<PlayerKingInfo>
	 */
	public ArrayList<PlayerKingInfo> getDailyKingPlayer(Field field,int num){
		return null;
		
	}
	
	/*
	 * 获取球员赛季高阶数据
	 * @param ps 排序依据，枚举类
	 * @param order 排序方式（升序/降序）
	 * @param num 返回 球员个数
	 * @return ArrayList<PlayerHighInfo>
	 */
	public ArrayList<PlayerHighInfo> getPlayerHighInfo(PlayerStandard ps,Order order,int num){
		return null;
		
	}
	
	/*
	 * 获取球员赛季 平均 基本数据
	 * @param pos 筛选条件：位置
	 * @param lea 筛选条件：赛区
	 * @param age 筛选条件：年龄
	 * @param ps 排序依据，枚举类
	 * @param order 排序方式（升序/降序）
	 * @param num 返回 球员个数
	 * @return ArrayList<PlayerNormalInfo>
	 */
	public ArrayList<PlayerNormalInfo> getPlayerAvgNormalInfo(Position pos,League lea,Age age,
			PlayerStandard ps,Order order,int num){
		return null;
		
	}
	
	/*
	 * 获取球员赛季 总和 基本数据
	 * @param pos 筛选条件：位置
	 * @param lea 筛选条件：赛区
	 * @param age 筛选条件：年龄
	 * @param ps 排序依据，枚举类
	 * @param order 排序方式（升序/降序）
	 * @param num 返回 球员个数
	 * @return ArrayList<PlayerNormalInfo>
	 */
	public ArrayList<PlayerNormalInfo> getPlayerTotalNormalInfo(Position pos,League lea,Age age,
			PlayerStandard ps,Order order,int num){
		return null;
		
	}
	
	/*
	 * 获取球员基本信息，如身高体重、照片等
	 * @param name:球员名
	 * @return PlayerVO
	 */
	public PlayerVO getPlayerInfo(String name){
		return null;
	}

	public PlayerNormalInfo getSinglePlayerNormalInfo(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public PlayerHighInfo getSinglePlayerHighInfo(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}