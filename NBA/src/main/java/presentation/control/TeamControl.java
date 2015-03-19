package presentation.control;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.JButton;

import businesslogic.teambl.TeamController;
import businesslogicservice.teamblservice.TeamBLService;

public class TeamControl implements ControlService,TeamControlService{

	TeamBLService ts;
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
		//HashMap<String,Image> hash = ts.getAllTeam();
		Image a = Toolkit.getDefaultToolkit().createImage("data/teamPng/ATL.png");
		return a;
	}

	public void findAim(String name) {
		//跳转到球队的信息的界面
		
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
			String title1[] = {"球队名","比赛场数"
					,"投篮命中率","投篮出手数","三分命中数"
					, "三分出手数","罚球命中数","罚球出手数"
					,"进攻篮板数","防守篮板数","篮板数"
					,"助攻数","抢断数","盖帽数"
					,"失误数","犯规数","比赛得分"
					,"投篮命中率","三分命中率", "罚球命中率"
					,"胜率","进攻回合","进攻效率"
					,"防守效率","篮板效率","抢断效率","助攻率"};
			return title1;
		}
		String[] order = {"升序","降序"};
		return order;
		
	}


	public String[] firstTitle() {
		// 返回排序的列表的表头
		String title[] = {"球队简称","球队名","比赛场数"
				,"投篮命中率","投篮出手数","三分命中数"
				, "三分出手数","罚球命中数","罚球出手数"
				,"进攻篮板数","防守篮板数","篮板数"
				,"助攻数","抢断数","盖帽数"
				,"失误数","犯规数","比赛得分"
				,"投篮命中率","三分命中率", "罚球命中率"
				,"胜率","进攻回合","进攻效率"
				,"防守效率","篮板效率","抢断效率","助攻率"};
		return title;
	}

	public Object[][] firstObj() {
		// 返回排序的列表	
		Object[][] t =new Object[30][28];
		for(int i=0;i<30;i++){
			t[i][0] = new JButton("f");
		}
		for(int i=0;i<30;i++){
			for(int j=1;j<28;j++){
				t[i][j] = "d";
			}
		}
		
		return t;
	}


	public Object[][] getList(String a, String string, String selectedItem) {
		// 返回排序的列表
		Object[][] t =new Object[30][28];
		for(int i=0;i<30;i++){
			t[i][0] = new JButton("f");
		}
		for(int i=0;i<30;i++){
			for(int j=1;j<28;j++){
				t[i][j] = "de";
			}
		}
		
		return t;
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
