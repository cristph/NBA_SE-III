package presentation.control;

import java.awt.Image;
import java.awt.Toolkit;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;

import presentation.ui.TeamFrame;
import value.TeamStandard;
import value.Value.Order;
import vo.TeamGameVO;
import vo.TeamVO;
import businesslogic.teambl.TeamController;
import businesslogicservice.teamblservice.TeamBLService;

public class TeamControl implements ControlService,TeamControlService{

	TeamBLService ts = new TeamController();
	HashMap<String,Image> hash = ts.getAllTeam();
	public String findTeam(int line, int row) {
		// 得到球队的名称在显示层
		String[][] list = {{"CHI","BKN","ATL","DEN","GSW","DAL"}
		,{"CLE","BOS","CHA","MIN","LAC","HOU"}
		,{"DET","NYK","MIA","OKC","LAL","MEM"}
		,{"IND","PHI","ORL","POR","PHX","NOP"}
		,{"MIL","TOR","WAS","UTA","SAC","SAS"}};
		return list[row-1][line-1];
	}

	public Image getTeamPic(String name) {
		// 得到图片在显示层
		
		
		return hash.get(name);
	}

	public void findAim(String name) {
		//跳转到球队的信息的界面
		TeamFrame a = new TeamFrame(name);
	}

	/*
	 * (non-Javadoc)
	 * @see presentation.control.ControlService#getOrder(int)
	 * int = 1,2,3分别为panel的1 2 3个下拉框
	 * 返回值为下拉框的数组
	 */
	public String[] getOrder(int i) {
		if(i==1){
			String m[] = {"总数据","平均数据"};
			return m;
		}
		if(i==2){
			String title1[] = {
					"投篮命中数","投篮出手数","三分命中数"
					, "三分出手数","罚球命中数","罚球出手数"
					,"进攻篮板数","防守篮板数","篮板数"
					,"助攻数","抢断数","盖帽数"
					,"失误数","犯规数","比赛得分"
					,"投篮命中率","三分命中率", "罚球命中率"
					,"胜率","进攻回合","进攻效率"
					,"防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻率"};
			return title1;
		}
		if(i==4){
			String title1[] = {
					"投篮命中数","投篮出手数","三分命中数"
					, "三分出手数","罚球命中数","罚球出手数"
					,"进攻篮板数","防守篮板数","篮板数"
					,"助攻数","抢断数","盖帽数"
					,"失误数","犯规数","比赛得分"
					};
			return title1;
		}
		String[] order = {"升序","降序"};
		return order;
		
	}


	public String[] firstTitle() {
		// 返回排序的列表的表头
		String title[] = {"球队简称","球队名","比赛场数"
				,"投篮命中数","投篮出手数","三分命中数"
				, "三分出手数","罚球命中数","罚球出手数"
				,"进攻篮板数","防守篮板数","篮板数"
				,"助攻数","抢断数","盖帽数"
				,"失误数","犯规数","比赛得分"
				,"投篮命中率","三分命中率", "罚球命中率"
				,"胜率","进攻回合","进攻效率"
				,"防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻率"};
		return title;
	}

	public Object[][] firstObj() {
		
		//变为百分数
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(2);//设置保留小数位
		nf.setRoundingMode(RoundingMode.HALF_UP); //设置舍入模式
		// 返回排序的列表	
		/*Object[][] t =new Object[30][28];
		for(int i=0;i<30;i++){
			t[i][0] = new JButton("f");
		}
		for(int i=0;i<30;i++){
			for(int j=1;j<28;j++){
				t[i][j] = "d";
			}
		}
		
		return t;*/
		ArrayList<String> list = ts.getTeamInOrder(Order.DOWN, TeamStandard.allpoint);

		Object[][] t = new Object[list.size()][29];
 		for(int i=0;i<list.size();i++){
			TeamVO temp = ts.getTeamInfo(list.get(i));
			t[i][0] = new JButton(temp.getShortName());
			t[i][1] = temp.getTeamName();
			t[i][2] = temp.getGamenum();
			t[i][3] = temp.getShootNum();
			t[i][4] = temp.getHitShootNum();
			t[i][5] = temp.getThreePointNum();
			t[i][6] = temp.getThreeShootNum();
			t[i][7] = temp.getFreeHitNum();
			t[i][8] = temp.getFreeNum();
			t[i][9] = temp.getRebAttNum();
			t[i][10] = temp.getRebDefNum();
			t[i][11] = temp.getRebTotalNum();
			t[i][12] = temp.getAssistNum();
			t[i][13] = temp.getStealNum();
			t[i][14] = temp.getBlockNum();
			t[i][15] = temp.getErrorNum();
			t[i][16] = temp.getFoulNum();
			t[i][17] = temp.getAllpoint();
			t[i][18] = temp.getShootrate();
			t[i][19] = temp.getThreepointrate();
			t[i][20] = temp.getFreehitrate();
			t[i][21] = temp.getWinrate();
			t[i][22] = temp.getAttackround();
			t[i][23] = temp.getAttackrate();
			t[i][24] = temp.getDefendrate();
			t[i][25] = temp.getRebattrate();
			t[i][26] = temp.getRebdefrate();
			t[i][27] = temp.getStealrate();
			t[i][28] = temp.getAssistrate();
		}
 		return t;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see presentation.control.ControlService#getList(java.lang.String, java.lang.String, java.lang.String)
	 * 见getorder为类型，标准，排序方式
	 */
	public Object[][] getList(String kind, String stand, String order) {
		// 返回排序的列表
		
		Order or = Order.DOWN;
		if(order.equals("升序")){
			or = Order.UP;
		}
		TeamStandard st = getStan(stand);
		ArrayList<String> list = ts.getTeamInOrder(or, st);
		Object[][] t = new Object[list.size()][29];
		if(kind.equals("总数据")){
			for(int i=0;i<list.size();i++){
				TeamVO temp = ts.getTeamInfo(list.get(i));
				t[i][0] = new JButton(temp.getShortName());
				t[i][1] = temp.getTeamName();
				t[i][2] = temp.getGamenum();
				t[i][3] = temp.getShootNum();
				t[i][4] = temp.getHitShootNum();
				t[i][5] = temp.getThreePointNum();
				t[i][6] = temp.getThreeShootNum();
				t[i][7] = temp.getFreeHitNum();
				t[i][8] = temp.getFreeNum();
				t[i][9] = temp.getRebAttNum();
				t[i][10] = temp.getRebDefNum();
				t[i][11] = temp.getRebTotalNum();
				t[i][12] = temp.getAssistNum();
				t[i][13] = temp.getStealNum();
				t[i][14] = temp.getBlockNum();
				t[i][15] = temp.getErrorNum();
				t[i][16] = temp.getFoulNum();
				t[i][17] = temp.getAllpoint();
				t[i][18] = temp.getShootrate();
				t[i][19] = temp.getThreepointrate();
				t[i][20] = temp.getFreehitrate();
				t[i][21] = temp.getWinrate();
				t[i][22] = temp.getAttackround();
				t[i][23] = temp.getAttackrate();
				t[i][24] = temp.getDefendrate();
				t[i][25] = temp.getRebattrate();
				t[i][26] = temp.getRebdefrate();
				t[i][27] = temp.getStealrate();
				t[i][28] = temp.getAssistrate();
			}
		}
		else{
			for(int i=0;i<list.size();i++){
				TeamVO temp = ts.getTeamInfo(list.get(i));
				t[i][0] = new JButton(temp.getShortName());
				t[i][1] = temp.getTeamName();
				t[i][2] = temp.getGamenum();
				t[i][3] = temp.getShootNumave();
				t[i][4] = temp.getHitShootNumave();
				t[i][5] = temp.getThreePointNumave();
				t[i][6] = temp.getThreeShootNumave();
				t[i][7] = temp.getFreeHitNumave();
				t[i][8] = temp.getFreeNumave();
				t[i][9] = temp.getRebAttNumave();
				t[i][10] = temp.getRebDefNumave();
				t[i][11] = temp.getRebTotalNumave();
				t[i][12] = temp.getAssistNumave();
				t[i][13] = temp.getStealNumave();
				t[i][14] = temp.getBlockNumave();
				t[i][15] = temp.getErrorNumave();
				t[i][16] = temp.getFoulNumave();
				t[i][17] = temp.getAllpointave();
				t[i][18] = "无";
				t[i][19] = "无";
				t[i][20] = "无";
				t[i][21] = "无";
				t[i][22] = "无";
				t[i][23] = "无";
				t[i][24] ="无";
				t[i][25] ="无";
				t[i][26] = "无";
				t[i][27] = "无";
				t[i][28] = "无";
			}
		}
		return t;
		
	}

	private TeamStandard getStan(String stand) {
		// 获取stand

		if(stand.equals("投篮命中数")){
			return TeamStandard.hitShootNum;
		}
		if(stand.equals("投篮出手次数")){
			return TeamStandard.shootNum;
		}
		if(stand.equals("三分命中数")){
			return TeamStandard.threePointNum;
		}
		if(stand.equals("三分出手数")){
			return TeamStandard.threeShootNum;
		}
		if(stand.equals("罚球命中数")){
			return TeamStandard.freeHitNum;
		}
		if(stand.equals("罚球出手数")){
			return TeamStandard.freeNum;
		}
		if(stand.equals("进攻篮板数")){
			return TeamStandard.rebAttNum;
		}
		if(stand.equals("防守篮板数")){
			return TeamStandard.rebDefNum;
		}
		if(stand.equals("篮板数")){
			return TeamStandard.rebTotalNum;
		}
		if(stand.equals("助攻数")){
			return TeamStandard.assistNum;
		}
		if(stand.equals("抢断数")){
			return TeamStandard.stealNum;
		}
		if(stand.equals("盖帽数")){
			return TeamStandard.blockNum;
		}
		if(stand.equals("失误数")){
			return TeamStandard.errorNum;
		}
		if(stand.equals("犯规数")){
			return TeamStandard.foulNum;
		}
		if(stand.equals("比赛得分")){
			return TeamStandard.allpoint;
		}
		if(stand.equals("投篮命中率")){
			return TeamStandard.shootrate;
		}
		if(stand.equals("三分命中率")){
			return TeamStandard.threepointrate;
		}

		if(stand.equals("罚球命中率")){
			return TeamStandard.freeHitNum;
		}
		if(stand.equals("胜率")){
			return TeamStandard.winrate;
		}
		if(stand.equals("进攻回合")){
			return TeamStandard.attackround;
		}
		if(stand.equals("进攻效率")){
			return TeamStandard.attackrate;
		}
		if(stand.equals("防守效率")){
			return TeamStandard.defendrate;
		}
		if(stand.equals("进攻篮板效率")){
			return TeamStandard.rebattrate;
		}
		if(stand.equals("防守篮板效率")){
			return TeamStandard.rebdefrate;
		}
		if(stand.equals("抢断效率")){
			return TeamStandard.stealrate;
		}
		
			return TeamStandard.assistrate;
		
		
	}

	public String getBoxLabel(int i) {
		//得到下拉框的标题
		String x="";
		if(i==1){
			x = "排序类型";
		}
		if(i==2){
			x = "排序依据";
		}
		return x;
	}


}
