package presentation.control;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;

import presentation.ui.PlayerFrame;
import test.data.PlayerNormalInfo;
import value.PlayerStandard;
import value.Value.Order;
import value.Value.*;
import vo.PlayerInfoVO;
import businesslogic.playerbl.PlayerBLController;
import businesslogicservice.playerblservice.PlayerBLService;

/**
 * 
 * @author xinlin
 *前五十名排序的模型
 */

public class PlayerTopControl implements ControlService{
	
	PlayerBLService ps = new PlayerBLController();
	/*
	 * (non-Javadoc)
	 * @see presentation.control.ControlService#findAim(java.lang.String)
	 * 进入球员界面
	 */
	public void findAim(String name) {
		new PlayerFrame(name);
	}

	public String[] getOrder(int i) {
		if(i==1){
			String back[] = {"联盟","东部","西部","中区","大西洋区","东南区","西北区","太平洋区","西南区"};
			return back;
		}
		if(i==2){
			String back[] = {"所有位置","前锋","中锋","后卫"};
			return back;
		}
		    String back[] = {"得分","篮板","助攻","盖帽","抢断","犯规","失误","上场时间","效率","投篮命中率","三分命中率"};
		    
		return back;
	}

	public String[] firstTitle() {
		// 表头
		String back[] = {"球员","球队","得分","篮板","助攻","盖帽","抢断","犯规","失误","上场时间","效率","投篮","三分"};
	    
		return back;
	}

	public Object[][] firstObj() {
		// 返回排序的列表
		return getList("联盟","所有位置","得分");
	}

	public Object[][] getList(String zone, String position, String stan) {
		// 返回排序的列表
		Position pos = getPos(position);
		PlayerStandard stan1 = getStan(stan);
		League zo = getZone(zone);
		ArrayList<PlayerNormalInfo> list = ps.getPlayerTotalNormalInfo(pos, zo, Age.All, stan1, Order.dsec, 50);
		Object[][] t = new Object[list.size()][13];
		DecimalFormat df=new DecimalFormat(".##");
		for(int i=0;i<list.size();i++){
			PlayerNormalInfo temp = list.get(i);
			t[i][0] = new JButton(temp.getName());
			t[i][1] = temp.getTeamName();
			t[i][2] = df.format(temp.getPoint());
			t[i][3] = df.format(temp.getRebound());
			t[i][4] = df.format(temp.getAssist());
			t[i][5] = df.format(temp.getBlockShot());
			t[i][6] = df.format(temp.getSteal());
			t[i][7] = df.format(temp.getFoul());
			t[i][8] = df.format(temp.getFault());
			t[i][9] = df.format(temp.getMinute());
			t[i][10] = df.format(temp.getEfficiency());
			t[i][11] = df.format(temp.getPenalty());
			t[i][12] = df.format(temp.getThree());
			
		}
		return t;
				
	}

	private League getZone(String zone) {
		// 得到联盟
		if(zone.equals("联盟")){
			return League.All;
		}
		if(zone.equals("东部")){
			return League.East;
		}
		if(zone.equals("西部")){
			return League.West;
		}
		if(zone.equals("中区")){
			return League.Central;
		}
		if(zone.equals("大西洋区")){
			return League.Atlantic;
		}
		if(zone.equals("东南区")){
			return League.Southeast;
		}
		if(zone.equals("西北区")){
			return League.Northwest;
		}
		if(zone.equals("太平洋区")){
			return League.Pacific;
		}
		
			return League.Southwest;
		
	}

	private PlayerStandard getStan(String stan) {
		// 得到标准
		if(stan.equals("得分")){
			return PlayerStandard.score;
		}
		if(stan.equals("篮板")){
			return PlayerStandard.rebTotalNum;
		}
		if(stan.equals("助攻")){
			return PlayerStandard.assistNum;
		}
		if(stan.equals("得分/篮板/助攻(1:1:1)")){
			return PlayerStandard.par;
		}
		if(stan.equals("盖帽")){
			return PlayerStandard.blockNum;
		}
		
		if(stan.equals("抢断")){
			return PlayerStandard.stealNum;
		}
		if(stan.equals("犯规")){
			return PlayerStandard.foulNum;
		}
		if(stan.equals("失误")){
			return PlayerStandard.errorNum;
		}
		if(stan.equals("上场时间")){
			return PlayerStandard.time;
		}
		if(stan.equals("效率")){
			return PlayerStandard.rate;
		}
		if(stan.equals("投篮")){
			return PlayerStandard.throwRate;
		}
		if(stan.equals("三分")){
			return PlayerStandard.threeRate;
		}
		if(stan.equals("罚球")){
			return PlayerStandard.freeRate;
		}
		return PlayerStandard.doub;
	}

	private Position getPos(String position) {
		// 位置
		if(position.equals("前锋")){
			return Position.F;
		}
		if(position.equals("中锋")){
			return Position.C;
		}
		if(position.equals("后卫")){
		
		    return Position.G;
		}
		return Position.All;
	}

	public String getBoxLabel(int i) {
		// 下拉框标题
		String back = "排序依据";
		if(i==1){
			back = "球员联盟";
		}
		if(i==2){
			back = "位置";
		}
		return back;
	}


}
