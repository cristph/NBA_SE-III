/**
 * @author xinlin
 * 比较界面
 */
package presentation.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import analysis.playeranalysis.PlayerAnalyseController;
import analysis.playeranalysis.PlayerAnalyseInter;
import businesslogicservice.teamblservice.TeamBLService;

public class TeamCom extends NormalFrame {
	JComboBox kind;
	JComboBox player1;
	JComboBox player2;
	JComboBox field;
	JComboBox sea;
	JTextArea area1;
	JTextArea area2;
	public TeamCom() {
		init();
		this.setVisible(true);
		this.setResizable(false);
		
	}
	
	private void init(){
		//分为两个部分
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		//球员
		JPanel ppanel = new JPanel();
		ppanel.setLayout(new BorderLayout());
		//PlayerAnalyseInter pas = new PlayerAnalyseController();
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
		
		//Object[] str = pas.getPlayerNames().toArray();
		Object[] str = {"ggg","no","he","wer"};
		player1 = new JComboBox(str);
		player2 = new JComboBox(str);
		String[] str1 = {"14-15","13-14","12-13","all"};
		String[] str2 = {"得分","篮板","助攻","抢断","盖帽"};
		String[] str3 = {"球员单指标均值对比","球员单指标方差对比","球员多项指标对比"};
		sea = new JComboBox(str1);
		field = new JComboBox(str2);
		kind = new JComboBox(str3);
		GroupLayout layout1 = new GroupLayout(title1);
		title1.setLayout(layout1);
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
		this.add(pane,BorderLayout.CENTER);
		pane.repaint();
	}
	
	public static void main (String[] args){
		new TeamCom();
	}

}
