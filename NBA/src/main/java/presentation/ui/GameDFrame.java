package presentation.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import po.TeamGamePO;
import businesslogicservice.teamblservice.TeamBLService;

public class GameDFrame extends NormalFrame{
	TeamBLService ts;
	public GameDFrame(String team, String time, String point,TeamBLService ts) {
		this.ts = ts;
		init(team,time,point);
		this.setVisible(true);
		this.setResizable(false);
	}
	private void init(String team, String time,String point) {
		// 比赛详细信息
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		ArrayList<TeamGamePO> list = ts.getGameInfo(time, team);
		JLabel label = new JLabel(point);
		Font font = new Font("TimesRoman",Font.BOLD,30);
		label.setFont(font);
		String[] teams = team.split("-");
		JLabel team1 = new JLabel(teams[0]);
		JLabel team2 = new JLabel(teams[1]);
		team1.setFont(font);
		team2.setFont(font);
		JPanel title = new JPanel();
		title.add(team1);
		title.add(label);
		title.add(team2);
		panel.add(title,BorderLayout.NORTH);
		
		JPanel table = new JPanel();
		table.setLayout(new BorderLayout());
		table.add(create(list.get(0),table),BorderLayout.NORTH);
		table.add(create(list.get(1),table),BorderLayout.SOUTH);
		
	    panel.add(table,BorderLayout.CENTER);
	    
	    this.add(panel,BorderLayout.CENTER);
		
		
	}
	private JScrollPane create(TeamGamePO teamGamePO, JPanel table) {
		//添加信息
		String[] head = getHead();
		Object[][] list = getList(teamGamePO);
		JTable obj = new JTable(list,head);
		JScrollPane pane = new JScrollPane(obj);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane.setPreferredSize(new Dimension(table.getWidth(), 200));
		
		return pane;
	}
	private Object[][] getList(TeamGamePO tp) {
		//百分数格式化
		NumberFormat fmt = NumberFormat.getPercentInstance();
		fmt.setMaximumFractionDigits(2);//最多两位百分小数，如25.23%
		String[] points = new String[4];
		String[] teams = tp.getMatchPair().split("-");
		if(tp.getTeamName().equals(teams[1])){
			String[] temp = tp.getPartScore();
			for(int i=0;i<4;i++){
				String temp1[] = temp[i].split("-");
				points[i] = temp1[0];
			}
		}
		String[] temp = tp.getPartScore();
		for(int i=0;i<4;i++){
			String temp1[] = temp[i].split("-");
			points[i] = temp1[1];
		}
		double shot = (double)tp.getHitShootNum()/(double)tp.getShootNum();
		double three = (double)tp.getThreePointNum()/(double)tp.getThreeShootNum();
		double pen = (double)tp.getFreeHitNum()/(double)tp.getFreeNum();
		Object[][] t = new Object[1][15];
		t[0][0] = tp.getTeamName();
		t[0][1] = tp.getMatchDate();
		t[0][2] = points[0];
		t[0][3] = points[1];
		t[0][4] = points[2];
		t[0][5] = points[3];
		t[0][6] = tp.getRebTotalNum();
		t[0][7] = tp.getAssistNum();
		t[0][8] = tp.getStealNum();
		t[0][9] = tp.getBlockNum();
		t[0][10]= tp.getErrorNum();
		t[0][11]= tp.getFoulNum();
		t[0][12]= fmt.format(shot);
		t[0][13]= fmt.format(three);
		t[0][14]= fmt.format(pen);
		return t;
	}
	private String[] getHead() {
		String[] back = {"球队","比赛日期","一节得分","二节得分","三节得分"
				,"四节得分","篮板","助攻","抢断","盖帽","失误","犯规","投篮命中","三分命中","罚球命中"};
		return back;
	}

}
