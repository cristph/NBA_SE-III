/**
 * @author xinlin
 * 比较界面
 */
package presentation.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import util.Selector;
import value.Value.Std;
import analysis.playeranalysis.PlayerAnalyseController;
import analysis.playeranalysis.PlayerAnalyseInter;
import analysis.teamanalysis.TeamAnaInterface;
import analysis.teamanalysis.TeamAnalysisController;
import businesslogicservice.teamblservice.TeamBLService;

public class TeamCom extends JPanel {
	JComboBox kind;
	JComboBox player1;
	JComboBox player2;
	JComboBox field;
	JComboBox sea;
	JTextArea area1;
	JTextArea area2;
	JComboBox sea2;
	JComboBox team1;
	JComboBox team2;
	JComboBox field2;
	public TeamCom() {
		init();
		this.setVisible(true);
		
	}
	
	private void init(){
		//分为两个部分
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		//球员
		JPanel ppanel = new JPanel();
		ppanel.setLayout(new BorderLayout());
		final PlayerAnalyseInter pas = new PlayerAnalyseController();
		JLabel label1 = new JLabel("<html>球<br>员<br>比<br>较</html>");
		ppanel.add(label1,BorderLayout.WEST);
		Font font = new Font("TimesRoman",Font.ITALIC,20);
		label1.setFont(font);
		JLabel pkind = new JLabel("类型");
		JLabel pname1 = new JLabel("球员名");
		JLabel pname2 = new JLabel("球员名");
		JLabel ptime = new JLabel("赛季");
		JLabel pfield = new JLabel("比较依据");
		JButton butt1 = new JButton("比较");
		
		area1 = new JTextArea();
		area1.setEditable(false);
		ppanel.add(area1,BorderLayout.CENTER);
		JPanel title1 = new JPanel();
		
		Object[] str = pas.getPlayerNames().toArray();
		player1 = new JComboBox(str);
		player2 = new JComboBox(str);
		String[] str1 = {"14-15","13-14","12-13"};
		String[] str2 = {"得分","篮板","助攻","抢断","盖帽"};
		final String[] str3 = {"球员单指标分析","球员单指标均值对比(全赛季)","球员单指标方差对比(全赛季)","球员多项指标对比"};
		sea = new JComboBox(str1);
		field = new JComboBox(str2);
		kind = new JComboBox(str3);
		GroupLayout layout1 = new GroupLayout(title1);
		title1.setLayout(layout1);
		butt1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String n1 = (String)player1.getSelectedItem();
				String n2 = (String)player2.getSelectedItem();
				String se = (String)(sea.getSelectedItem());
				String pa = (String)kind.getSelectedItem();
				String fi = (String)field.getSelectedItem();
				if(pa.equals(str3[2])){
					String m =pas.getPlayersVarEvolveInfo(fi, n1, n2);
					area1.setText(m);
					return;
				}
				
				if(pa.equals(str3[1])){
					String m =pas.getPlayersAvgEvolveInfo(fi, n1, n2);
					area1.setText(m);
					return;
				}
				String temp[] = se.split("-");
				se = "20"+temp[0]+"-"+"20"+temp[1];
				Selector sel = new Selector();
				sel.setKind("A");
				sel.setSeason(se);
				if(pa.equals(str3[0])){
					String m = pas.getPlayersInfo(sel, fi, n1, n2);
					area1.setText(m);
				}
				else{
					pas.showRedar(sel, n1, n2);
				}
				
					

				
			}
			
		});
		//水平连续
		GroupLayout.SequentialGroup hGroup1 = 
				layout1.createSequentialGroup();
		hGroup1.addGap(10);
		hGroup1.addGroup(layout1.createParallelGroup().addComponent(pkind).addComponent(pname1).addComponent(pname2).addComponent(ptime).addComponent(pfield));
		hGroup1.addGap(10);
		hGroup1.addGroup(layout1.createParallelGroup().addComponent(kind).addComponent(player1).addComponent(player2).addComponent(sea).addComponent(field).addComponent(butt1));
		hGroup1.addGap(10);
		//竖直连续
		GroupLayout.SequentialGroup vGroup1 = 
  				layout1.createSequentialGroup();
		vGroup1.addGap(5);
		vGroup1.addGroup(layout1.createParallelGroup().addComponent(pkind).addComponent(kind));
		vGroup1.addGap(5);
		vGroup1.addGroup(layout1.createParallelGroup().addComponent(pname1).addComponent(player1));
		vGroup1.addGap(5);
		vGroup1.addGroup(layout1.createParallelGroup().addComponent(pname2).addComponent(player2));
		vGroup1.addGap(5);
		vGroup1.addGroup(layout1.createParallelGroup().addComponent(ptime).addComponent(sea));
		vGroup1.addGap(5);
		vGroup1.addGroup(layout1.createParallelGroup().addComponent(pfield).addComponent(field));
		vGroup1.addGap(5);
		vGroup1.addGroup(layout1.createParallelGroup().addComponent(butt1));
		vGroup1.addGap(5);
		layout1.setHorizontalGroup(vGroup1);
		layout1.setVerticalGroup(hGroup1);
		
		ppanel.add(title1,BorderLayout.NORTH);
		pane.add(ppanel,BorderLayout.NORTH);
		//球队
		final TeamAnaInterface tai = new TeamAnalysisController("2014-2015");
		JPanel tpanel = new JPanel();
		tpanel.setLayout(new BorderLayout());
		JLabel label2 = new JLabel("<html>球<br>队<br>比<br>较</html>");
		tpanel.add(label2,BorderLayout.WEST);
		label2.setFont(font);
		JLabel tname1 = new JLabel("球队名");
		JLabel tname2 = new JLabel("球队名");
		JLabel ttime = new JLabel("赛季");
		JLabel tfield = new JLabel("比较依据");
		JButton butt2 = new JButton("比较");
		String[] str4 = {"14-15","13-14","12-13"};
		final String[] str5 = {"得分","篮板","助攻","失误"};
		Set<String> list = tai.getAllTeam().keySet();
		Object[] str6 = list.toArray();
		team1 = new JComboBox(str6);
		team2 = new JComboBox(str6);
		sea2 = new JComboBox(str4);
		field2 = new JComboBox(str5);
		area2 = new JTextArea();
		area2.setEditable(false);
		
		butt2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String t1 = (String)team1.getSelectedItem();
				String t2 = (String)team2.getSelectedItem();
				String time = (String)sea2.getSelectedItem();
				String fi = (String)field2.getSelectedItem();
				String temp[] = time.split("-");
				time = "20"+temp[0]+"-"+"20"+temp[1];
				tai.setSeason(time);
				Std sta = Std.score;
				if (fi.equals(str5[0])){
					sta = Std.score;
				}
				if (fi.equals(str5[1])){
					sta = Std.rebound;
				}
				if (fi.equals(str5[2])){
					sta = Std.assist;
				}
				if (fi.equals(str5[3])){
					sta = Std.foul;
				}
				String m = tai.teamCompare(t1, t2, sta);
				System.out.println("ggg"+t1+t2+sta.toString());
				area2.setText(m);
				area2.repaint();
				
			}
			
		});
		tpanel.add(area2,BorderLayout.CENTER);
		JPanel title2 = new JPanel();
		GroupLayout layout2 = new GroupLayout(title2);
		title2.setLayout(layout2);
		//水平连续
		GroupLayout.SequentialGroup hGroup2 = 
						layout2.createSequentialGroup();
		hGroup2.addGap(10);
		hGroup2.addGroup(layout2.createParallelGroup().addComponent(tname1).addComponent(tname2).addComponent(ttime).addComponent(tfield));
		hGroup2.addGap(10);
		hGroup2.addGroup(layout2.createParallelGroup().addComponent(team1).addComponent(team2).addComponent(sea2).addComponent(field2).addComponent(butt2));
		hGroup2.addGap(10);
		GroupLayout.SequentialGroup vGroup2 = 
  				layout2.createSequentialGroup();
		vGroup2.addGap(5);
		vGroup2.addGroup(layout2.createParallelGroup().addComponent(tname1).addComponent(team1));
		vGroup2.addGap(5);
		vGroup2.addGroup(layout2.createParallelGroup().addComponent(tname2).addComponent(team2));
		vGroup2.addGap(5);
		vGroup2.addGroup(layout2.createParallelGroup().addComponent(ttime).addComponent(sea2));
		vGroup2.addGap(5);
		vGroup2.addGroup(layout2.createParallelGroup().addComponent(tfield).addComponent(field2));
		vGroup2.addGap(5);
		vGroup2.addGroup(layout2.createParallelGroup().addComponent(butt2));
		layout2.setHorizontalGroup(vGroup2);
		layout2.setVerticalGroup(hGroup2);
		tpanel.add(title2,BorderLayout.NORTH);
		pane.add(tpanel,BorderLayout.SOUTH);
		//end
		this.add(pane,BorderLayout.CENTER);
		pane.repaint();
	}
	
	public static void main (String[] args){
		new TeamCom();
	}

}
