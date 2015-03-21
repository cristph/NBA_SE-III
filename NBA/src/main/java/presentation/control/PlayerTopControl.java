package presentation.control;

import java.util.ArrayList;

import javax.swing.JButton;

import value.PlayerStandard;
import value.Value.Order;
import value.Value.Zone;
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
		
	}

	public String[] getOrder(int i) {
		if(i==1){
			String back[] = {"联盟","东部","西部","中区","大西洋区","东南区","西北区","太平洋区","西南区"};
			return back;
		}
		if(i==2){
			String back[] = {"前锋","中锋","后卫"};
			return back;
		}
		    String back[] = {"得分","篮板","助攻","得分/篮板/助攻(1:1:1)","盖帽","抢断","犯规","失误","上场时间","效率","投篮","三分","罚球","两双"};
		    
		return back;
	}

	public String[] firstTitle() {
		// 表头
		String back[] = {"姓名","得分","篮板","助攻","三项综合","盖帽","抢断","犯规","失误","上场时间","效率","投篮","三分","罚球","两双"};
	    
		return back;
	}

	public Object[][] firstObj() {
		// 返回排序的列表
		ArrayList<PlayerInfoVO> list = ps.getPlayerTop_50(Order.DOWN, PlayerStandard.score, "ALL", Zone.ALL);
		Object[][] t = new Object[list.size()][15];
		for(int i=0;i<list.size();i++){
			PlayerInfoVO temp = list.get(i);
			t[i][0] = temp.getName();
			t[i][1] = temp.getScore();
			t[i][2] = temp.getRebTotalNum();
			t[i][3] = temp.getAssistNum();
			t[i][4] = temp.getPar();
			t[i][5] = temp.getBlockNum();
			t[i][6] = temp.getStealNum();
			t[i][7] = temp.getFoulNum();
			t[i][8] = temp.getErrorNum();
			t[i][9] = temp.getTime();
			t[i][10] = temp.getRate();
			t[i][11] = temp.getShooting();
			t[i][12] = temp.getThreePointNum();
			t[i][13] = temp.getFreeHitNum();
			t[i][14] = temp.getDoub();
			
		}
		return t;
	}

	public Object[][] getList(String zone, String position, String stan) {
		// 返回排序的列表
		String pos = getPos(position);
		PlayerStandard stan1 = getStan(stan);
		Zone zo = getZone(zone);
		ArrayList<PlayerInfoVO> list = ps.getPlayerTop_50(Order.DOWN, stan1,pos , zo);
		Object[][] t = new Object[list.size()][15];
		for(int i=0;i<list.size();i++){
			PlayerInfoVO temp = list.get(i);
			t[i][0] = temp.getName();
			t[i][1] = temp.getScore();
			t[i][2] = temp.getRebTotalNum();
			t[i][3] = temp.getAssistNum();
			t[i][4] = temp.getPar();
			t[i][5] = temp.getBlockNum();
			t[i][6] = temp.getStealNum();
			t[i][7] = temp.getFoulNum();
			t[i][8] = temp.getErrorNum();
			t[i][9] = temp.getTime();
			t[i][10] = temp.getRate();
			t[i][11] = temp.getShooting();
			t[i][12] = temp.getThreePointNum();
			t[i][13] = temp.getFreeHitNum();
			t[i][14] = temp.getDoub();
			
		}
		return t;
				
	}

	private Zone getZone(String zone) {
		// 得到联盟
		if(zone.equals("联盟")){
			return Zone.ALL;
		}
		if(zone.equals("东部")){
			return Zone.E;
		}
		if(zone.equals("西部")){
			return Zone.W;
		}
		if(zone.equals("中区")){
			return Zone.Central;
		}
		if(zone.equals("大西洋区")){
			return Zone.Atlantic;
		}
		if(zone.equals("东南区")){
			return Zone.Southeast;
		}
		if(zone.equals("西北区")){
			return Zone.Northwest;
		}
		if(zone.equals("太平洋区")){
			return Zone.Pacific;
		}
		
			return Zone.Southwest;
		
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
		if(stan.equals("得分/篮板/助攻(加权比为 1:1:1)")){
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

	private String getPos(String position) {
		// 位置
		if(position.equals("前锋")){
			return "F";
		}
		if(position.equals("中锋")){
			return "C";
		}
		
		return "G";
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
