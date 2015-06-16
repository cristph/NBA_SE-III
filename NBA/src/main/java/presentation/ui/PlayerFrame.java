package presentation.ui;
/**
 * @author xinlin
 * 根据名称显示球员的Frame
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import presentation.modle.MyTableModle;
import test.data.PlayerHighInfo;
import test.data.PlayerNormalInfo;
import util.Selector;
import value.PlayerStandard;
import value.Value.Age;
import value.Value.League;
import value.Value.Position;
import vo.PlayerVO;
import analysis.playeranalysis.PlayerAnalyseController;
import analysis.playeranalysis.PlayerAnalyseInter;
import businesslogic.playerbl.PlayerBLController;
import businesslogicservice.playerblservice.PlayerBLService;
import businesslogicservice.teamblservice.TeamBLService;

public class PlayerFrame extends NormalFrame{
	String pname;
	PlayerBLService ps;
	TeamBLService ts;
	PlayerAnalyseInter pai = new PlayerAnalyseController();
	JComboBox kind;
	JComboBox box;
	JComboBox sea;
	DoubleField poin;
	JTextArea area;
	public PlayerFrame(String name2, PlayerBLService ps, TeamBLService ts) {
		this.pname = name2;
		this.ts = ts;
		this.ps = ps;
		init();
		this.setVisible(true);
		this.setResizable(false);
	}

	private void init() {
		PlayerVO pvo = ps.getPlayerInfo(pname);
		PlayerNormalInfo i = ps.getSinglePlayerNormalInfo(pname);
		String teamName = i.getTeamName();
		//基本信息
		Image test = pvo.getPic();
		test = test.getScaledInstance(140,120,Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(test);
		Image temp = pvo.getAction();
		temp = temp.getScaledInstance(320,480,Image.SCALE_DEFAULT);
		ImageIcon action = new ImageIcon(temp);
		JLabel img = new JLabel(icon);
		JLabel omg = new JLabel(action);
		JLabel info = new JLabel("基本信息");
		Font font =new  Font("TimesRoman",Font.BOLD,35);
		info.setFont(font);
		JLabel name = new JLabel("姓名");
		JLabel num = new JLabel("号码");
		JLabel pos = new JLabel("位置");
		JLabel hei = new JLabel("身高");
		JLabel wei = new JLabel("体重");
		JLabel bir = new JLabel("生日");
		JLabel age = new JLabel("年龄");
		JLabel exp = new JLabel("球龄");
		JLabel sch = new JLabel("学校");
		JLabel team = new JLabel("队伍");
		JLabel namer = new JLabel(pvo.getName());
		JLabel numr = new JLabel(pvo.getNumber());
		JLabel posr = new JLabel(pvo.getPosition());
		JLabel heir = new JLabel(pvo.getHeight());
		JLabel weir = new JLabel(pvo.getWeight());
		JLabel birr = new JLabel(pvo.getBirth());
		JLabel ager = new JLabel(pvo.getAge());
		JLabel expr = new JLabel(pvo.getExp());
		JLabel schr = new JLabel(pvo.getSchool());
		final JLabel teamr = new JLabel(teamName);
		JButton enter = new JButton("球队信息");
		enter.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//进入球队界面
				new TeamFrame(teamr.getText(),ps,ts);
				
			}
			
		});
		
		
		JPanel label = new JPanel();
		GroupLayout layout = new GroupLayout(label);
		label.setLayout(layout);
		//水平连续组
		GroupLayout.SequentialGroup hGroup = 
				layout.createSequentialGroup();
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(info).addComponent(img));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(name).addComponent(namer).addComponent(team).addComponent(teamr));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(pos).addComponent(posr).addComponent(num).addComponent(numr));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(hei).addComponent(heir).addComponent(wei).addComponent(weir));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(age).addComponent(ager).addComponent(bir).addComponent(birr));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(sch).addComponent(schr).addComponent(exp).addComponent(expr));
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(enter));
		//垂直组
		GroupLayout.SequentialGroup vGroup = 
				layout.createSequentialGroup();
		vGroup.addGap(5);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(info).addComponent(name).addComponent(pos).addComponent(hei).addComponent(age).addComponent(sch).addComponent(enter));
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(namer).addComponent(posr).addComponent(heir)
				.addComponent(ager)
				.addComponent(schr));
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(team).addComponent(num).addComponent(wei)
				.addComponent(bir)
				.addComponent(exp));
		vGroup.addGap(20);
		vGroup.addGroup(layout.createParallelGroup().addComponent(img)
				.addComponent(teamr).addComponent(numr).addComponent(weir)
				.addComponent(birr)
				.addComponent(expr));
		
		
		layout.setHorizontalGroup(vGroup);
		layout.setVerticalGroup(hGroup);
		
		
		//比赛信息
		JPanel list = new JPanel();
		list.setLayout(new BorderLayout());
		
		JPanel tab1 = new JPanel();
		JPanel tab2 = new JPanel();

		
		tab1.setLayout(new BorderLayout());
		tab2.setLayout(new BorderLayout());
		
		
		JLabel name1= new JLabel("平均数据");		
		JLabel name2 = new JLabel("高级数据");
		
		
		JTable table1 = new JTable(getObj(1),getTitle(1));
		JTable table2 = new JTable(getObj(1),getTitle(2));

		
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

	
		//球员分析
		JPanel analy = new JPanel();
		analy.setLayout(new BoxLayout(analy,BoxLayout.Y_AXIS));
		// 单项分析
		JPanel atitle = new JPanel();
		JLabel aname1 = new JLabel("分析类型");
		JLabel aname2 = new JLabel("分析依据");
		JLabel aname3 = new JLabel("赛季");
		JLabel aname4 = new JLabel("置信区间");
		final String[] str1 = {"球员单指标排名分析","球员多指标","球员单指标区间估计 ","球员均值演变分析(全赛季)","球员方差演变分析(全赛季)"};
		kind = new JComboBox(str1);
		String[] str2 = {"得分","篮板","助攻","抢断","盖帽"};
		box = new JComboBox(str2);
		String str3[] = {"14-15","13-14","12-13"};
		sea = new JComboBox(str3);
		poin = new DoubleField("0.95");
	    area = new JTextArea();
	    area.setEditable(false);
	    JButton butt = new JButton("分析");
	    butt.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//改变area
				Font font =new  Font("TimesRoman",Font.BOLD,15);
				if (((String)kind.getSelectedItem()).equals(str1[0])){
					String fi = (String)box.getSelectedItem();
					String n = pname;
					Selector a = new Selector();
					a.setKind("A");
					String m[] = ((String)sea.getSelectedItem()).split("-");
					a.setSeason("20"+m[0]+"-"+"20"+m[1]);
					System.out.println(a.getSeason());
					System.out.println(fi);
					System.out.println(n);
					area.setText(pai.getSortInfo(a,fi,n));
					area.setFont(font);
					area.repaint();
				}
				if (((String)kind.getSelectedItem()).equals(str1[1])){
					String fi = (String)box.getSelectedItem();
					String n = pname;
					area.setText("详情见图，无图则为样本容量过小");
					Selector a = new Selector();
					a.setKind("A");
					String m[] = ((String)sea.getSelectedItem()).split("-");
					a.setSeason("20"+m[0]+"-"+"20"+m[1]);
					pai.showRedar(a,pname);
					area.setFont(font);
					area.repaint();
				}
				if (((String)kind.getSelectedItem()).equals(str1[2])){
					String fi = (String)box.getSelectedItem();
					String n = pname;
					Selector a = new Selector();
					a.setKind("A");
					String m[] = ((String)sea.getSelectedItem()).split("-");
					a.setSeason("20"+m[0]+"-"+"20"+m[1]);
					area.setText(pai.getIntervalInfo(a,fi,n,Double.parseDouble(poin.getText())));
					area.setFont(font);
					area.repaint();
				}
				if (((String)kind.getSelectedItem()).equals(str1[3])){
					String fi = (String)box.getSelectedItem();
					String n = pname;
					area.setText(pai.getAvgEvolveInfo(fi, n));
					area.setFont(font);
					area.repaint();
				}
				if (((String)kind.getSelectedItem()).equals(str1[4])){
					String fi = (String)box.getSelectedItem();
					String n = pname;
					area.setText(pai.getVarEvolveInfo(fi, n));
					area.setFont(font);
					area.repaint();
				}
				
			}
	    	
	    });
	    
	    GroupLayout layout1 = new GroupLayout(atitle);
		atitle.setLayout(layout1);
		//水平连续组
		GroupLayout.SequentialGroup hGroup1 = 
				layout1.createSequentialGroup();
		hGroup1.addGap(10);
		hGroup1.addGroup(layout1.createParallelGroup().addComponent(aname1).addComponent(aname2).addComponent(aname3).addComponent(aname4));
		hGroup1.addGap(10);
		hGroup1.addGroup(layout1.createParallelGroup().addComponent(kind).addComponent(box).addComponent(sea).addComponent(poin).addComponent(butt));
	  //垂直组
	  	GroupLayout.SequentialGroup vGroup1 = 
	  				layout1.createSequentialGroup();
	  	vGroup1.addGap(5);
	  	vGroup1.addGroup(layout1.createParallelGroup().addComponent(aname1).addComponent(kind));
	  	vGroup1.addGap(5);
	  	vGroup1.addGroup(layout1.createParallelGroup().addComponent(aname2).addComponent(box));
	  	vGroup1.addGap(5);
	  	vGroup1.addGroup(layout1.createParallelGroup().addComponent(aname3).addComponent(sea));
	  	vGroup1.addGap(5);
	  	vGroup1.addGroup(layout1.createParallelGroup().addComponent(aname4).addComponent(poin));
		vGroup1.addGap(5);
		vGroup1.addGroup(layout1.createParallelGroup().addComponent(butt));
	  	layout1.setHorizontalGroup(vGroup1);
		layout1.setVerticalGroup(hGroup1);
		analy.add(area,BorderLayout.CENTER);
		analy.add(atitle,BorderLayout.NORTH);
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("球员风采", omg);
		tabbedPane.addTab("球员基本信息",label);
		tabbedPane.addTab("球员数据",list);
		tabbedPane.addTab("球员分析", analy);
		this.add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.setTabComponentAt(0, new JLabel("球员风采"));
		
      
		this.add(tabbedPane,BorderLayout.CENTER);
		
		
		
	}

	private Object[][] getObj(int i) {
		//获取表格数据
		DecimalFormat df = new DecimalFormat("0.00");
		//百分数格式化
		NumberFormat fmt = NumberFormat.getPercentInstance();
		fmt.setMaximumFractionDigits(2);//最多两位百分小数，如25.23%
		if(i==1){
			PlayerNormalInfo temp = ps.getSinglePlayerNormalInfo(pname);
			Object[][] t = new Object[1][18];
			t[0][0] = temp.getName();
		    t[0][1] = temp.getTeamName();
		    t[0][2] = temp.getNumOfGame();
		    t[0][3] = temp.getStart();
		    t[0][4] = df.format(temp.getMinute());
		    t[0][5] = df.format(temp.getPoint());
		    t[0][6] = df.format(temp.getRebound());
		    t[0][7] = df.format(temp.getAssist());
		    t[0][8] = df.format(temp.getDefend());
		    t[0][9] = df.format(temp.getBlockShot());
		    t[0][10]= df.format(temp.getFault());
		    t[0][11]= df.format(temp.getFoul());
		    t[0][12] =df.format(temp.getOffend());
		    t[0][13] = df.format(temp.getSteal());
		    t[0][14] = fmt.format(temp.getShot());
		    t[0][15] = fmt.format(temp.getPenalty());
		    t[0][16] = fmt.format(temp.getThree());
		    t[0][17] = fmt.format(temp.getEfficiency());
		    return t;
		}
		    
		PlayerHighInfo temp = ps.getSinglePlayerHighInfo(pname);
		Object[][] t = new Object[1][13];
		t[0][0] = temp.getName();
		t[0][1] = temp.getTeamName();
		t[0][2] = fmt.format(temp.getAssistEfficient());
		t[0][3] = fmt.format(temp.getBlockShotEfficient());
		t[0][4] = fmt.format(temp.getDefendReboundEfficient());
		t[0][5] = fmt.format(temp.getOffendReboundEfficient());
		t[0][6] = fmt.format(temp.getFaultEfficient());
		t[0][7] = fmt.format(temp.getFrequency());
		t[0][8] = df.format(temp.getGmSc());
		t[0][9] = fmt.format(temp.getRealShot());
		t[0][10]= fmt.format(temp.getReboundEfficient());
		t[0][11]= fmt.format(temp.getShotEfficient());
		t[0][12] =fmt.format(temp.getStealEfficient());
		return t;
	}

	private String[] getTitle(int i) {
		//获取表头
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
		if(i==2){
			return title2;
		}
		return title1;
	}

}
