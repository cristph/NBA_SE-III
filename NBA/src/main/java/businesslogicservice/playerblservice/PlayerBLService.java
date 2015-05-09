package businesslogicservice.playerblservice;

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

public interface PlayerBLService {
	/*
	//得到单个球员的信息
	public PlayerVO getPlayerTotalInfo(String name);
	
	//得到全部球员赛季平均数据排序结果
	public ArrayList<PlayerInfoVO> getPlayerAvgInOrder(Order order,PlayerStandard stan);
	
	//得到全部球员赛季总数据排序结果
	public ArrayList<PlayerInfoVO> getPlayerTotalInOrder(Order order,PlayerStandard stan);
	
	//得到球员前50列表
	public ArrayList<PlayerInfoVO> getPlayerTop_50(Order order,PlayerStandard stan,String position,Zone zone);
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
	public ArrayList<PlayerHotInfo> getHotPlayer(Field field,int num);
	
	
	/*
	 * 获取赛季热点球员
	 * @param field:排序依据，可取值Field枚举类
	 * @param num:返回球员个数
	 * @return ArrayList<PlayerKingInfo>
	 */
	public ArrayList<PlayerKingInfo> getSeasonKingPlayer(Field field,int num);
	
	
	/*
	 * 获取当天热点球员
	 * @param field:排序依据，可取值Field枚举类
	 * @param num:返回球员个数
	 * @return ArrayList<PlayerKingInfo>
	 */
	public ArrayList<PlayerKingInfo> getDailyKingPlayer(Field field,int num);
	
	
	/*
	 * 获取球员赛季高阶数据
	 * @param ps 排序依据，枚举类
	 * @param order 排序方式（升序/降序）
	 * @param num 返回 球员个数
	 * @return ArrayList<PlayerHighInfo>
	 */
	public ArrayList<PlayerHighInfo> getPlayerHighInfo(PlayerStandard ps,Order order,int num);
	
	
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
			PlayerStandard ps,Order order,int num);
	
	
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
			PlayerStandard ps,Order order,int num);
	
	
	/*
	 * 获取球员基本信息，如身高体重、照片等
	 * @param name:球员名
	 * @return PlayerVO
	 */
	public PlayerVO getPlayerInfo(String name);
	
	
	/*
	 * 获取单个球员的基本  比赛数据
	 * 取平均数
	 * @param name:球员名
	 * @return PlayerNormalInfo
	 */
	public PlayerNormalInfo getSinglePlayerNormalInfo(String name);
	
	
	/*
	 * 获取单个球员的高阶  比赛数据
	 * 默认平均数
	 * @param name:球员名
	 * @return PlayerHighInfo
	 */
	public PlayerHighInfo getSinglePlayerHighInfo(String name);
	
	public ArrayList<PlayerHighInfo> getPlayerHighInfoMOrder(PlayerStandard[] ps,Order[] order,int num);
	
	public ArrayList<PlayerNormalInfo> getPlayerAvgNormalInfoMOrder(Position pos,League lea,Age age,
			PlayerStandard[] ps,Order[] order,int num);
	
	public ArrayList<PlayerNormalInfo> getPlayerTotalNormalInfoMOrder(Position pos,League lea,Age age,
			PlayerStandard[] ps,Order[] order,int num);
}
