package businesslogic.playerbl;

import java.util.ArrayList;

import data.gamedata.GameData;
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

public class PlayerBLController implements PlayerBLService,Runnable{
	
	PlayerCalculate pc;
	
	public PlayerBLController(){
		pc=new PlayerCalculate();
		Thread thread=new Thread(this);
		thread.start();
	}
	
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
		ArrayList<PlayerHotInfo> list=pc.getHotPlayer(field, num);
		return list;
	}
	
	/*
	 * 获取当天热点球员
	 * @param field:排序依据，可取值Field枚举类
	 * @param num:返回球员个数
	 * @return ArrayList<PlayerKingInfo>
	 */
	public ArrayList<PlayerKingInfo> getSeasonKingPlayer(Field field,int num){
		ArrayList<PlayerKingInfo> list=pc.getSeasonKingPlayer(field, num);
		return list;
	}
	
	/*
	 * 获取赛季热点球员
	 * @param field:排序依据，可取值Field枚举类
	 * @param num:返回球员个数
	 * @return ArrayList<PlayerKingInfo>
	 */
	public ArrayList<PlayerKingInfo> getDailyKingPlayer(Field field,int num){
		ArrayList<PlayerKingInfo> list=pc.getDailyKingPlayer(field, num);
		return list;
	}
	
	/*
	 * 获取球员赛季高阶数据
	 * @param ps 排序依据，枚举类
	 * @param order 排序方式（升序/降序）
	 * @param num 返回 球员个数
	 * @return ArrayList<PlayerHighInfo>
	 */
	public ArrayList<PlayerHighInfo> getPlayerHighInfo(PlayerStandard ps,Order order,int num){
		ArrayList<PlayerHighInfo> list=pc.getPlayerHighInfo(ps, order, num);
		return list;
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
		ArrayList<PlayerNormalInfo> list=pc.getPlayerAvgNormalInfo(pos, lea, age, ps, order, num);
		return list;	
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
		ArrayList<PlayerNormalInfo> list=pc.getPlayerTotalNormalInfo(pos, lea, age, ps, order, num);
		return list;
	}
	
	/*
	 * 获取球员基本信息，如身高体重、照片等
	 * @param name:球员名
	 * @return PlayerVO
	 */
	public PlayerVO getPlayerInfo(String name){
		PlayerVO pv=pc.getPlayerInfo(name);
		return pv;
	}

	public PlayerNormalInfo getSinglePlayerNormalInfo(String name) {
		// TODO Auto-generated method stub
		PlayerNormalInfo pni=pc.getSinglePlayerNormalInfo(name);
		return pni;
	}

	public PlayerHighInfo getSinglePlayerHighInfo(String name) {
		// TODO Auto-generated method stub
		PlayerHighInfo phi=pc.getSinglePlayerHighInfo(name);
		return phi;
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(2500);
				if(GameData.getDataChange()){
					System.out.println("data changed!!!!!!!!!!!!!!!!!");
					PlayerCalculate new_pc=new PlayerCalculate();
					new_pc.iniData();
					new_pc.calAllInfo();
					pc=new_pc;
				}else{
					System.out.println("data not changed!!!!!!!!!!!!!!!!!");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}