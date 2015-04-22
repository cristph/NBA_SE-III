package presentation.control;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;

import presentation.ui.PlayerFrame;
import test.data.PlayerHotInfo;
import value.Value.Field;
import businesslogicservice.playerblservice.PlayerBLService;
import businesslogicservice.teamblservice.TeamBLService;

public class GoodPlayerControl implements HotControl{

	PlayerBLService ps;
	TeamBLService ts;
	String fld;
	public GoodPlayerControl(PlayerBLService ps, TeamBLService ts) {
		this.ps=ps;
		this.ts=ts;
	}

	public String[] getTitle() {
		String[] title={"得分","篮板","助攻"};
		return title;
	}

	public Object[][] getList(String x) {
		DecimalFormat df = new DecimalFormat("0.00");
		//百分数格式化
		NumberFormat fmt = NumberFormat.getPercentInstance();
		fmt.setMaximumFractionDigits(2);//最多两位百分小数，如25.23%
		Field field = getF(x);
		ArrayList<PlayerHotInfo> info = ps.getHotPlayer(field, 5);
		Object[][] t = new Object[info.size()][5];
		for(int i=0;i<info.size();i++){
			PlayerHotInfo temp = info.get(i);
			t[i][0] = new JButton(temp.getName());
			t[i][1] = df.format(temp.getValue());
			t[i][2] = temp.getTeamName();
			t[i][3] = temp.getPosition();
			t[i][4] = fmt.format(temp.getUpgradeRate());
			fld = temp.getField();
		}
		return t;
	}

	private Field getF(String x) {
		if(x.equals("得分")){
			return Field.score;
		}
		if(x.equals("篮板")){
			return Field.rebound;
		}
		return Field.assist;
		
		
	}

	public String[] getHead() {
		String[] title={"球员","热门属性","球队","位置","提升率"};
		title[1] = fld;
		return title;
	}

	public void findAim(String name) {
		new PlayerFrame(name,ps,ts);
		
	}

}
