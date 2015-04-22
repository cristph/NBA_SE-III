package presentation.control;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import presentation.ui.TeamFrame;
import test.data.TeamHotInfo;
import value.Value.Field2;
import businesslogicservice.playerblservice.PlayerBLService;
import businesslogicservice.teamblservice.TeamBLService;

public class HotTeamControl implements HotControl{

	PlayerBLService ps;
	TeamBLService ts;
	String fld;
	public HotTeamControl(PlayerBLService ps, TeamBLService ts) {
		this.ps=ps;
		this.ts=ts;
	}

	public String[] getTitle() {
		String[] title={"得分","篮板","助攻","盖帽","抢断","三分命中", "投篮命中","罚球命中"};
		return title;
	}

	public Object[][] getList(String x) {
		DecimalFormat df=new DecimalFormat(".##");
		//百分数格式化
		NumberFormat fmt = NumberFormat.getPercentInstance();
		fmt.setMaximumFractionDigits(2);//最多两位百分小数，如25.23%
		Field2 field = getF(x);
		ArrayList<TeamHotInfo> info = ts.getHotTeam(field, 5);
		Object[][] t = new Object[info.size()][3];
		for(int i=0;i<info.size();i++){
			TeamHotInfo temp = info.get(i);
			t[i][0] = new JButton(temp.getTeamName());
			t[i][1] = df.format(temp.getValue());
			t[i][2] = temp.getLeague();
			fld = temp.getField();
		}
		return t;
	}

	private Field2 getF(String x) {
		if(x.equals("得分")){
			return Field2.score;
		}
		if(x.equals("篮板")){
			return Field2.rebound;
		}
		if(x.equals("助攻")){
			return Field2.assist;
		}
		if(x.equals("盖帽")){
			return Field2.blockShot;
		}
		if(x.equals("投篮命中")){
			return Field2.shot;
		}
		if(x.equals("三分命中")){
			return Field2.three;
		}
		if(x.equals("罚球命中")){
			return Field2.penalty;
		}
		return Field2.steal;
	}

	public String[] getHead() {
		String[] title={"球员","热门属性","球队","位置"};
		title[1] = fld;
		return title;
	}

	public void findAim(String name) {
		new TeamFrame(name,ps,ts);
		
	}

}
