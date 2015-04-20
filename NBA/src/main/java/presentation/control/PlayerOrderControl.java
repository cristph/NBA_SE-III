package presentation.control;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;

import presentation.ui.PlayerFrame;
import test.data.PlayerHighInfo;
import test.data.PlayerNormalInfo;
import value.PlayerStandard;
import value.Value.*;
import businesslogic.playerbl.PlayerBLController;
import businesslogicservice.playerblservice.PlayerBLService;
import businesslogicservice.teamblservice.TeamBLService;

public class PlayerOrderControl implements ControlService{

	public PlayerBLService ps;
	public TeamBLService ts;
	String title1[] = {"球员","球队","出场"
			,"首发","时间/分钟","得分"
			,"篮板","助攻","防守",
			"盖帽","失误","犯规"
			,"进攻数","抢断数","投篮命中数"
			,"投篮命中率","三分命中率","效率"};
	String title2[] = {"球员","球队","助攻率"
			,"盖帽率","防守篮板率","进攻篮板率"
			,"失误率","使用率","gmsc"
			,"真实命中率","篮板率","投篮效率"
			,"抢断率"};
	String title[] = title1;
	public PlayerOrderControl(PlayerBLService ps2, TeamBLService ts) {
		// TODO Auto-generated constructor stub
		this.ps = ps2;
		this.ts = ts;
	}


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
			String title1[] = {"得分","球员名称","所属球队","参赛场数"
					,"先发场数","篮板数","助攻数","在场时间"
					,"投篮命中率","三分命中率",
					"进攻数","防守数","抢断数","盖帽数"
					,"失误数","犯规数","效率","GmSc"
					,"真实命中率","投篮效率", "篮板率"
					,"进攻篮板率","防守篮板率","助攻率","抢断率"
					,"盖帽率","失误率","使用率"};
			return title1;
		}
		String t[] ={"降序","升序"};
		return t;
		
		
	}


	public String[] firstTitle() {
				
		
		return title;
	}

	public Object[][] firstObj() {
		
		
		return getList("总数据","得分","降序");
	}


	/*
	 * @author:xinlin
	 * 三个String分别是第一项下拉框第二项下拉框第三项下拉框的选项
	 * 见  getOrder
	 */
	
	public Object[][] getList(String kind, String stand, String order) {
		// 返回排序的列表
		Order or = Order.dsec;
		if(order.equals("升序")){
			or = Order.asc;
		}
		PlayerStandard stan = getStan(stand);
		DecimalFormat df=new DecimalFormat(".##");
		//对基本数据进行排序
		if(stan!=null){
		    ArrayList<PlayerNormalInfo> info;
		    if(kind.equals("总数据")){
			    info = ps.getPlayerTotalNormalInfo(Position.All, League.All, Age.All, stan, or, -1);
		    }
		    else{
			    info = ps.getPlayerAvgNormalInfo(Position.All, League.All, Age.All, stan, or, -1);
		    }
		    Object[][] t = new Object[info.size()][18];
		    title = title1;
		    for(int i=0;i<info.size();i++){
			    PlayerNormalInfo temp = info.get(i);
			    t[i][0] = new JButton(temp.getName());
			    t[i][1] = temp.getTeamName();
			    t[i][2] = temp.getNumOfGame();
			    t[i][3] = temp.getStart();
			    t[i][4] = df.format(temp.getMinute());
			    t[i][5] = df.format(temp.getPoint());
			    t[i][6] = df.format(temp.getRebound());
			    t[i][7] = df.format(temp.getAssist());
			    t[i][8] = df.format(temp.getDefend());
			    t[i][9] = df.format(temp.getBlockShot());
			    t[i][10]= df.format(temp.getFault());
			    t[i][11]= df.format(temp.getFoul());
			    t[i][12] =df.format(temp.getOffend());
			    t[i][13] = df.format(temp.getSteal());
			    t[i][14] = df.format(temp.getShot());
			    t[i][15] = df.format(temp.getPenalty());
							
			
		    }
		    return t;
		}
		else{
			stan = getStan1(stand);
			title = title2;
			ArrayList<PlayerHighInfo> info = ps.getPlayerHighInfo(stan, or, -1);
			Object[][] t = new Object[info.size()][13];
			//百分数格式化
			NumberFormat fmt = NumberFormat.getPercentInstance();
			fmt.setMaximumFractionDigits(2);//最多两位百分小数，如25.23%
			for(int i=0;i<info.size();i++){
				PlayerHighInfo temp = info.get(i);
				t[i][0] = new JButton(temp.getName());
				t[i][1] = temp.getTeamName();
				t[i][2] = fmt.format(temp.getAssistEfficient());
				t[i][3] = fmt.format(temp.getBlockShotEfficient());
				t[i][4] = fmt.format(temp.getDefendReboundEfficient());
				t[i][5] = fmt.format(temp.getOffendReboundEfficient());
				t[i][6] = fmt.format(temp.getFaultEfficient());
				t[i][7] = fmt.format(temp.getFrequency());
				t[i][8] = df.format(temp.getGmSc());
				t[i][9] = fmt.format(temp.getRealShot());
				t[i][10]= fmt.format(temp.getReboundEfficient());
				t[i][11]= fmt.format(temp.getShotEfficient());
				t[i][12] =fmt.format(temp.getStealEfficient());
			}
			return t;
		}
	
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
		
		if(stand.equals("投篮命中率")){
			return PlayerStandard.shooting;
		}
		if(stand.equals("三分命中率")){
			return PlayerStandard.threeRate;
		}
		
	   /*	if(stand.equals("罚球命中率")){
			return PlayerStandard.freeRate;
		}*/
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
			return null;
			
	}
	
	private PlayerStandard getStan1(String stand) {
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
			return PlayerStandard.usedRate;
	}
	
	


	public void findAim(String name) {
		//跳转到球员界面
		PlayerFrame frame = new PlayerFrame(name,ps,ts);
		
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
