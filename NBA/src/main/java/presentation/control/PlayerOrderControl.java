package presentation.control;

import java.awt.Image;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;

import presentation.ui.PlayerFrame;
import value.PlayerStandard;
import value.Value.Order;
import vo.PlayerInfoVO;
import businesslogic.playerbl.PlayerBLController;
import businesslogicservice.playerblservice.PlayerBLService;

public class PlayerOrderControl implements ControlService{

	PlayerBLService ps = new PlayerBLController();
	/*
	 * (non-Javadoc)
	 * @see presentation.control.ControlService#getOrder(int)
	 * int = 1,2,3分别为panel的1 2 3个下拉框
	 * 返回值为下拉框的数组
	 */
	public String[] getOrder(int i) {
		if(i==1){
			String[] m= {"总数据","平均数据"};
			return m;
		}
		if(i==2){
			String title1[] = {"球员名称","所属球队","参赛场数"
					,"先发场数","篮板数","助攻数","在场时间"
					,"投篮命中率","三分命中率","罚球命中率"
					,"进攻数","防守数","抢断数","盖帽数"
					,"失误数","犯规数","得分","效率","GmSc"
					,"真实命中率","投篮效率", "篮板率"
					,"进攻篮板率","防守篮板率","助攻率","抢断率"
					,"盖帽率","失误率","使用率"};
			return title1;
		}
		String t[] ={"升序","降序"};
		return t;
		
		
	}


	public String[] firstTitle() {
		
		String title1[] = {"球员名称","所属球队","参赛场数"
				,"先发场数","篮板数","助攻数","在场时间"
				,"投篮命中率","三分命中率","罚球命中率"
				,"进攻数","防守数","抢断数","盖帽数"
				,"失误数","犯规数","得分","效率","GmSc"
				,"真实命中率","投篮效率", "篮板率"
				,"进攻篮板率","防守篮板率","助攻率","抢断率"
				,"盖帽率","失误率","使用率"};
		return title1;
	}

	public Object[][] firstObj() {
		// 返回排序的列表
		//变为百分数
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(2);//设置保留小数位
		nf.setRoundingMode(RoundingMode.HALF_UP); //设置舍入模式
		
		//
		ArrayList<PlayerInfoVO> info = ps.getPlayerAvgInOrder(Order.DOWN, PlayerStandard.score);
		Object[][] t = new Object[info.size()][29];
		for(int i=0;i<info.size();i++){
			PlayerInfoVO temp = info.get(i);
			t[i][0] = new JButton(temp.getName());
			t[i][1] = temp.getTeam();
			t[i][2] = Integer.toString(temp.getInTime());
			t[i][3] = Integer.toString(temp.getFirstTime());
			t[i][4] = Double.toString(temp.getRebTotalNum());
			t[i][5] = Double.toString(temp.getAssistNum());
			t[i][6] = Double.toString(temp.getTime());
			t[i][7] = nf.format(temp.getShooting());
			t[i][8] = nf.format(temp.getThreeRate());
			t[i][9] = nf.format(temp.getFreeRate());
			t[i][10] =Double.toString(temp.getRebAttNum());
			t[i][11] =Double.toString(temp.getRebDefNum());
			t[i][12] =Double.toString(temp.getStealNum());
			t[i][13] =Double.toString(temp.getBlockNum());
			t[i][14] =Double.toString(temp.getErrorNum());
			t[i][15] =Double.toString(temp.getFoulNum());
			t[i][16] =Double.toString(temp.getScore());
			t[i][17] =Double.toString(temp.getRate());
			t[i][18] =Double.toString(temp.getGMSC());
			t[i][19] =nf.format(temp.getRealHitRate());
			t[i][20] =nf.format(temp.getThrowRate());
			t[i][21] =nf.format(temp.getRebRate());
			t[i][22] =nf.format(temp.getAttRebRate());
			t[i][23] =nf.format(temp.getDefRebRate());
			t[i][24] =nf.format(temp.getAssistRate());
			t[i][25] =nf.format(temp.getStealRate());
			t[i][26] =nf.format(temp.getBlockRate());
			t[i][27] =nf.format(temp.getErrorRate());
			t[i][28] =nf.format(temp.getUsedRate());			
			
		}
		return t;
	}


	/*
	 * @author:xinlin
	 * 三个String分别是第一项下拉框第二项下拉框第三项下拉框的选项
	 * 见  getOrder
	 */
	public Object[][] getList(String kind, String stand, String order) {
		// 返回排序的列表
		ArrayList<PlayerInfoVO> info;
		Order or = Order.DOWN;
		if(order.equals("升序")){
			or = Order.UP;
		}
		PlayerStandard stan = getStan(stand);
		if(kind.equals("总数据")){
			info = ps.getPlayerTotalInOrder(or, stan);
		}
		else{
			info = ps.getPlayerAvgInOrder(or, stan);
		}
		Object[][] t = new Object[info.size()][29];
		for(int i=0;i<info.size();i++){
			PlayerInfoVO temp = info.get(i);
			t[i][0] = new JButton(temp.getName());
			t[i][1] = temp.getTeam();
			t[i][2] = Integer.toString(temp.getInTime());
			t[i][3] = Integer.toString(temp.getFirstTime());
			t[i][4] = Double.toString(temp.getRebTotalNum());
			t[i][5] = Double.toString(temp.getAssistNum());
			t[i][6] = Double.toString(temp.getTime());
			t[i][7] = temp.getShooting();
			t[i][8] = temp.getThreeRate();
			t[i][9] = temp.getFreeRate();
			t[i][10] =Double.toString(temp.getRebAttNum());
			t[i][11] =Double.toString(temp.getRebDefNum());
			t[i][12] =Double.toString(temp.getStealNum());
			t[i][13] =Double.toString(temp.getBlockNum());
			t[i][14] =Double.toString(temp.getErrorNum());
			t[i][15] =Double.toString(temp.getFoulNum());
			t[i][16] =Double.toString(temp.getScore());
			t[i][17] =Double.toString(temp.getRate());
			t[i][18] =Double.toString(temp.getGMSC());
			t[i][19] =temp.getRealHitRate();
			t[i][20] =temp.getThrowRate();
			t[i][21] =temp.getRebRate();
			t[i][22] =temp.getAttRebRate();
			t[i][23] =temp.getDefRebRate();
			t[i][24] =temp.getAssistRate();
			t[i][25] =temp.getStealRate();
			t[i][26] =temp.getBlockRate();
			t[i][27] =temp.getErrorRate();
			t[i][28] =temp.getUsedRate();		
			
		}
		if(kind.equals("平均数据")){
			for(int i=0;i<info.size();i++){
				t[i][7] = "无";
				t[i][8] = "无";
				t[i][9] = "无";
				t[i][17] ="无";
				t[i][18] ="无";
				t[i][19] ="无";
				t[i][20] ="无";
				t[i][21] ="无";
				t[i][22] ="无";
				t[i][23] ="无";
				t[i][24] ="无";
				t[i][25] ="无";
				t[i][26] ="无";
				t[i][27] ="无";
				t[i][28] ="无";	
			}
		}
		
		return t;
	
	}

	private PlayerStandard getStan(String stand) {
		// 把排序标准变为枚举类
		if(stand.equals("球员名称")){
			return PlayerStandard.name;
		}
		if(stand.equals("所属球队")){
			return PlayerStandard.team;
		}
		if(stand.equals("参赛场数")){
			return PlayerStandard.inTime;
		}
		if(stand.equals("先发场数")){
			return PlayerStandard.firstTime;
		}
		if(stand.equals("篮板数")){
			return PlayerStandard.rebTotalNum;
		}
		if(stand.equals("助攻数")){
			return PlayerStandard.assistNum;
		}
		if(stand.equals("在场时间")){
			return PlayerStandard.time;
		}
		//
		if(stand.equals("投篮命中率")){
			return PlayerStandard.shooting;
		}
		if(stand.equals("三分命中率")){
			return PlayerStandard.threeRate;
		}
		
		if(stand.equals("罚球命中率")){
			return PlayerStandard.freeRate;
		}
		if(stand.equals("进攻数")){
			return PlayerStandard.rebAttNum;
		}
		if(stand.equals("防守数")){
			return PlayerStandard.rebDefNum;
		}
		if(stand.equals("抢断数")){
			return PlayerStandard.stealNum;
		}
		if(stand.equals("盖帽数")){
			return PlayerStandard.blockNum;
		}
		if(stand.equals("失误数")){
			return PlayerStandard.foulNum;
		}
		if(stand.equals("犯规数")){
			return PlayerStandard.errorNum;
		}
		if(stand.equals("得分")){
			return PlayerStandard.score;
		}
		if(stand.equals("效率")){
			return PlayerStandard.rate;
		}
		if(stand.equals("GmSc")){
			return PlayerStandard.GMSC;
		}
		if(stand.equals("真实命中率")){
			return PlayerStandard.realHitRate;
		}
		if(stand.equals("投篮效率")){
			return PlayerStandard.throwRate;
		}
		if(stand.equals("篮板率")){
			return PlayerStandard.rebRate;
		}
		if(stand.equals("进攻篮板率")){
			return PlayerStandard.rebAttNum;
		}
		if(stand.equals("防守篮板率")){
			return PlayerStandard.rebDefNum;
		}
		if(stand.equals("助攻率")){
			return PlayerStandard.assistRate;
		}
		if(stand.equals("抢断率")){
			return PlayerStandard.stealRate;
		}
		if(stand.equals("盖帽率")){
			return PlayerStandard.blockRate;
		}
		if(stand.equals("失误率")){
			return PlayerStandard.errorRate;
		}
			return PlayerStandard.assistNum;
			
	}


	public void findAim(String name) {
		//跳转到球员界面
		PlayerFrame frame = new PlayerFrame(name);
		
	}

	public String getBoxLabel(int i) {
		// 返回下拉框的标题
		String back = "";
		if(i==1){
			back = "排序类型";
			
		}
		if(i==2){
			back = "排序依据";
		}
		
		return back;
	}
	
}
