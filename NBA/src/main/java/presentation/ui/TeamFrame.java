package presentation.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import po.TeamPO;
import test.data.TeamHighInfo;
import test.data.TeamNormalInfo;
import vo.DateGameVO;
import businesslogicservice.playerblservice.PlayerBLService;
import businesslogicservice.teamblservice.TeamBLService;

public class TeamFrame extends NormalFrame{
	String teamName;
	PlayerBLService ps;
	TeamBLService ts;
	public TeamFrame(String name2, PlayerBLService ps, TeamBLService ts) {
		this.teamName = name2;
		this.ts = ts;
		this.ps = ps;
		init();
		this.setVisible(true);
		this.setResizable(false);
	}
	
	private void init(){
		//基本信息
		JPanel normal = new JPanel();
		normal.setLayout(new BorderLayout());
		TeamPO tvo = ts.getTeamInfo(teamName);
		Image temp = tvo.getTeamPic();
		temp = temp.getScaledInstance(240, 240, Image.SCALE_DEFAULT);
		ImageIcon action = new ImageIcon(temp);
		JLabel omg = new JLabel(action);
		JLabel name = new JLabel("队名");
		JLabel shortName = new JLabel("简称");
		JLabel pos = new JLabel("位置");
		JLabel zone = new JLabel("分区");
		JLabel loc = new JLabel("赛区");
		JLabel main = new JLabel("主场");
		JLabel bir = new JLabel("建队时间");
		JLabel namer = new JLabel(tvo.getTeamName());
		JLabel shortNamer = new JLabel(tvo.getShortName());
		JLabel posr = new JLabel(tvo.getLocation());
		JLabel zoner = new JLabel(tvo.getZone());
		JLabel locr = new JLabel(tvo.getLocation());
		JLabel mainr = new JLabel(tvo.getHome());
		JLabel birr = new JLabel(tvo.getBirthday());
		JPanel label  = new JPanel();
		GroupLayout layout = new GroupLayout(label);
		label.setLayout(layout);
		//水平连续组
		GroupLayout.SequentialGroup hGroup = 
				layout.createSequentialGroup();
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup());
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(name).addComponent(namer).addComponent(shortName).addComponent(shortNamer));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(pos).addComponent(posr).addComponent(main).addComponent(mainr));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(zone).addComponent(zoner).addComponent(loc).addComponent(locr));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(bir).addComponent(birr));
		hGroup.addGap(20);
		//垂直连续组
		GroupLayout.SequentialGroup vGroup = 
				layout.createSequentialGroup();
		vGroup.addGap(5);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(name).addComponent(pos).addComponent(zone).addComponent(bir));
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(namer).addComponent(posr).addComponent(zoner)
				.addComponent(birr));
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(shortName).addComponent(main).addComponent(loc)
				);
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(shortNamer).addComponent(mainr).addComponent(locr)
				);
		vGroup.addGap(20);


		layout.setHorizontalGroup(vGroup);
		layout.setVerticalGroup(hGroup);
		normal.add(omg,BorderLayout.WEST);
		normal.add(label,BorderLayout.CENTER);
		
		//球队信息
		JPanel list = new JPanel();
		list.setLayout(new BorderLayout());
		
		JPanel tab1 = new JPanel();
		JPanel tab2 = new JPanel();

		
		tab1.setLayout(new BorderLayout());
		tab2.setLayout(new BorderLayout());
		
		
		JLabel name1= new JLabel("平均数据");		
		JLabel name2 = new JLabel("高级数据");
		
		
		JTable table1 = new JTable(getObj(1),getTitle(1));
		JTable table2 = new JTable(getObj(2),getTitle(2));

		
		tab1.add(name1,BorderLayout.NORTH);
		tab2.add(name2,BorderLayout.NORTH);

		
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane pane1 = new JScrollPane(table1);
		pane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane pane2 = new JScrollPane(table2);
		pane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
		tab1.add(pane1,BorderLayout.CENTER);
		tab2.add(pane2,BorderLayout.CENTER);

		tab1.setPreferredSize(new Dimension(list.getWidth(), 150));
		tab2.setPreferredSize(new Dimension(list.getWidth(), 150));
		list.add(tab1,BorderLayout.NORTH);
		list.add(tab2,BorderLayout.SOUTH);
		
		//比赛信息
		ArrayList<DateGameVO> date = ts.getRecentGame(teamName);
		GameList game = new GameList(date,ts);
		
		
		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.addTab("球队基本信息",normal);
		tabbedPane.addTab("球队数据",list);
		tabbedPane.add("近期比赛",game);
		this.add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.setTabComponentAt(0, new JLabel("球队基本信息"));
		this.add(tabbedPane,BorderLayout.CENTER);

		
	}

	private Object[][] getObj(int i) {
		DecimalFormat df = new DecimalFormat("0.00");
		//百分数格式化
		NumberFormat fmt = NumberFormat.getPercentInstance();
		fmt.setMaximumFractionDigits(2);//最多两位百分小数，如25.23%
		if(i==1){
			TeamNormalInfo temp = ts.getSingleTeamNormalInfo(teamName);
			System.out.println(teamName+"tea");
			Object[][] t = new Object[1][13];
			t[0][0] = df.format(temp.getPoint());
			t[0][1] = df.format(temp.getNumOfGame());
			t[0][2] = df.format(temp.getRebound());
			t[0][3] = df.format(temp.getAssist());
			t[0][4] = df.format(temp.getBlockShot());
			t[0][5] = df.format(temp.getDefendRebound());
			t[0][6] = df.format(temp.getOffendRebound());
			t[0][7] = df.format(temp.getFault());
			t[0][8] = df.format(temp.getFoul());
			t[0][9]= df.format(temp.getSteal());
			t[0][10]= fmt.format(temp.getShot());
			t[0][11]= fmt.format(temp.getThree());
			t[0][12]= fmt.format(temp.getPenalty());
			return t;
		}
		TeamHighInfo temp = ts.getSingleTeamHighInfo(teamName);
		Object[][] t = new Object[1][8];
		t[0][0] = df.format(temp.getAssistEfficient());
		t[0][1] = df.format(temp.getDefendEfficient());
		t[0][2] = df.format(temp.getDefendReboundEfficient());
		t[0][3] = df.format(temp.getOffendEfficient());
		t[0][4] = df.format(temp.getOffendReboundEfficient());
		t[0][5] = df.format(temp.getOffendRound());
		t[0][6] = df.format(temp.getStealEfficient());
		t[0][7] = fmt.format(temp.getWinRate());
		
		return t;
	}

	private String[] getTitle(int i) {
		String title2[] = {"助攻效率","防守效率"
				,"防守篮板效率","进攻效率","进攻篮板效率"
				, "进攻回合","抢断效率","胜率"
				};
		String title1[] = {"得分","比赛场数","篮板","助攻","盖帽","防守篮板","进攻篮板","失误","犯规","抢断","投篮命中","三分命中","罚球命中"};
		if(i==1){
			return title1;
		}
		return title2;
	}

}

