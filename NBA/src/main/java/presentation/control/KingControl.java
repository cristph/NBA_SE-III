package presentation.control;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;

import presentation.ui.PlayerFrame;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import value.Value.Field;
import businesslogicservice.playerblservice.PlayerBLService;
import businesslogicservice.teamblservice.TeamBLService;

public class KingControl implements HotControl{

	PlayerBLService ps;
	TeamBLService ts;
	String fld;
	public KingControl(PlayerBLService ps, TeamBLService ts) {
		this.ps=ps;
		this.ts=ts;
	}

	public String[] getTitle() {
		String[] title={"得分","篮板","助攻","盖帽","抢断","三分命中", "投篮命中","罚球命中"};
		return title;
	}

	public Object[][] getList(String x) {
		DecimalFormat df = new DecimalFormat("0.00");
		//百分数格式化
		NumberFormat fmt = NumberFormat.getPercentInstance();
		fmt.setMaximumFractionDigits(2);//最多两位百分小数，如25.23%
		Field field = getF(x);
		ArrayList<PlayerKingInfo> info = ps.getSeasonKingPlayer(field, 5);
		Object[][] t = new Object[info.size()][4];
		for(int i=0;i<info.size();i++){
			PlayerKingInfo temp = info.get(i);
			t[i][0] = new JButton(temp.getName());
			t[i][1] = df.format(temp.getValue());
			t[i][2] = temp.getTeamName();
			t[i][3] = temp.getPosition();
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
		if(x.equals("助攻")){
			return Field.assist;
		}
		if(x.equals("盖帽")){
			return Field.block;
		}
		if(x.equals("投篮命中")){
			return Field.shoot;
		}
		if(x.equals("三分命中")){
			return Field.three;
		}
		if(x.equals("罚球命中")){
			return Field.free;
		}
		return Field.steal;
	}

	public String[] getHead() {
		String[] title={"球员","热门属性","球队","位置"};
		title[1] = fld;
		return title;
	}

	public void findAim(String name) {
		new PlayerFrame(name,ps,ts);
		
	}

}
