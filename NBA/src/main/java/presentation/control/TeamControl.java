package presentation.control;

import java.awt.Image;
import java.awt.Toolkit;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;

import presentation.ui.TeamFrame;
import test.data.TeamHighInfo;
import test.data.TeamNormalInfo;
import value.TeamStandard;
import value.Value.Order;
import vo.TeamGameVO;
import vo.TeamVO;
import businesslogic.teambl.TeamController;
import businesslogicservice.playerblservice.PlayerBLService;
import businesslogicservice.teamblservice.TeamBLService;

public class TeamControl implements ControlService,TeamControlService{

	public TeamBLService ts ;
	public PlayerBLService ps;
	HashMap<String,Image> hash;
	String title1[] = {"球队简称","助攻效率","防守效率"
			,"防守篮板效率","进攻效率","进攻篮板效率"
			, "进攻回合","抢断效率","胜率"
			};
	String title2[] = {"球队简称","得分","比赛场数","篮板","助攻","盖帽","防守篮板","进攻篮板","失误","犯规","抢断","投篮命中","三分命中","罚球命中"};
	String title[] = title1;
	public TeamControl(PlayerBLService ps, TeamBLService ts2) {
		// TODO Auto-generated constructor stub
		this.ps = ps;
		this.ts = ts2;
		hash = ts.getAllTeam();
	}

	public String findTeam(int line) {
		// 得到球队的名称在显示层
		Set<String> list = hash.keySet();
		Object[] list1 = list.toArray();
		System.out.print(list1.length);
		return (String)list1[line-1];
	}

	public Image getTeamPic(String name) {
		// 得到图片在显示层
		
		
		return hash.get(name);
	}

	public void findAim(String name) {
		//跳转到球队的信息的界面
		TeamFrame a = new TeamFrame(name,ps,ts);
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
					"得分","进攻篮板数","防守篮板数"
					, "篮板数","助攻","抢断"
					,"盖帽","失误","犯规"
					,"投篮命中率","三分命中率","罚球命中率"
					,"胜率","进攻回合","进攻效率"
					,"防守效率","进攻篮板效率", "防守篮板效率"
					,"抢断效率","助攻效率"};
			return title1;
		}
		String[] order = {"降序","升序"};
		return order;
		
	}


	public String[] firstTitle() {
		// 返回排序的列表的表头
		return title;
	}

	public Object[][] firstObj() {
		return getList("总数据","得分" ,"降序");
	}
	
	/*
	 * (non-Javadoc)
	 * @see presentation.control.ControlService#getList(java.lang.String, java.lang.String, java.lang.String)
	 * 见getorder为类型，标准，排序方式
	 */
	public Object[][] getList(String kind, String stand, String order) {
		// 返回排序的列表
		DecimalFormat df = new DecimalFormat("0.00");
		//百分数格式化
		NumberFormat fmt = NumberFormat.getPercentInstance();
		fmt.setMaximumFractionDigits(2);//最多两位百分小数，如25.23%
		Order or = Order.dsec;
		if(order.equals("升序")){
			or = Order.asc;
		}
		TeamStandard st = getStan(stand);
		
		if(kind.equals("平均数据")){
			st = getStanavg(stand,st);
		}
		if(stIsHigh(st)){
			//查看高阶数据
			title = title1;
			ArrayList<TeamHighInfo> info = ts.getTeamHighInfo(st, or, 30);
			Object[][] t = new Object[info.size()][9];
			for(int i=0;i<info.size();i++){
				TeamHighInfo temp = info.get(i);
				t[i][0] = new JButton(temp.getTeamName());
				t[i][1] = df.format(temp.getAssistEfficient());
				t[i][2] = df.format(temp.getDefendEfficient());
				t[i][3] = df.format(temp.getDefendReboundEfficient());
				t[i][4] = df.format(temp.getOffendEfficient());
				t[i][5] = df.format(temp.getOffendReboundEfficient());
				t[i][6] = df.format(temp.getOffendRound());
				t[i][7] = df.format(temp.getStealEfficient());
				t[i][8] = fmt.format(temp.getWinRate());
				
			}
			return t;
		}
		title = title2;
		ArrayList<TeamNormalInfo> info;
		if(kind.equals("平均数据")){
			//查看平均数据
			info = ts.getTeamavgNormalInfo(st, or, 30);
		}
		else{
			 info = ts.getTeamTotalNormalInfo(st, or, 30);
		}
			/*"球队简称","得分","比赛场数","篮板","助攻","盖帽","防守篮板"
			 * ,"进攻篮板","失误","犯规","抢断","投篮命中","三分命中","罚球命中"*/
			Object[][] t = new Object[info.size()][14];
			for(int i=0;i<info.size();i++){
				TeamNormalInfo temp = info.get(i);
				t[i][0] = new JButton(temp.getTeamName());
				t[i][1] = df.format(temp.getPoint());
				t[i][2] = df.format(temp.getNumOfGame());
				t[i][3] = df.format(temp.getRebound());
				t[i][4] = df.format(temp.getAssist());
				t[i][5] = df.format(temp.getBlockShot());
				t[i][6] = df.format(temp.getDefendRebound());
				t[i][7] = df.format(temp.getOffendRebound());
				t[i][8] = df.format(temp.getFault());
				t[i][9] = df.format(temp.getFoul());
				t[i][10]= df.format(temp.getSteal());
				t[i][11]= fmt.format(temp.getShot());
				t[i][12]= fmt.format(temp.getThree());
				t[i][13]= fmt.format(temp.getPenalty());
			}
			return t;		
		
	}

	private boolean stIsHigh(TeamStandard st) {
		if((st==TeamStandard.assistrate)||(st==TeamStandard.stealrate)||(st==TeamStandard.rebdefrate)
		||(st==TeamStandard.rebattrate)||(st==TeamStandard.defendrate)||(st==TeamStandard.attackrate)
		||(st==TeamStandard.attackround)||(st==TeamStandard.winrate)){
			return true;
		}
		return false;
	}

	private TeamStandard getStanavg(String stand,TeamStandard st) {
		// 平均数据的改变
		if(stand.equals("进攻篮板数")){
			return TeamStandard.rebAttNumave;
		}
		if(stand.equals("防守篮板数")){
			return TeamStandard.rebDefNumave;
		}
		if(stand.equals("篮板数")){
			return TeamStandard.rebTotalNumave;
		}
		if(stand.equals("助攻数")){
			return TeamStandard.assistNumave;
		}
		if(stand.equals("抢断数")){
			return TeamStandard.stealNumave;
		}
		if(stand.equals("盖帽数")){
			return TeamStandard.blockNumave;
		}
		if(stand.equals("失误数")){
			return TeamStandard.errorNumave;
		}
		if(stand.equals("犯规数")){
			return TeamStandard.foulNumave;
		}
		if(stand.equals("比赛得分")){
			return TeamStandard.allpointave;
		}
		return st;
	}

	private TeamStandard getStan(String stand) {
		// 获取stand
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
			return TeamStandard.freehitrate;
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
