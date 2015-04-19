package presentation.ui;
/**
 * @author xinlin
 * 球队的图片展示界面
 */

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import presentation.control.TeamControlService;

public class TeamAllPanel extends JPanel {

	TeamControlService cs;
	public TeamAllPanel(TeamControlService cs) {
		//得到界面的控制对象
		this.cs = cs;
		init();
	}
	
	/*
	 * 界面的初始化
	 */
	private void init() {
		this.setLayout(new BorderLayout());
		
		//球队分区的名称
		JPanel title = new JPanel();
		Border border = BorderFactory
				.createBevelBorder(BevelBorder.LOWERED);
		title.setBorder(border);
		//this.add(title, BorderLayout.NORTH);
		
		//title的内容
		GroupLayout layout = new GroupLayout(title);
		title.setLayout(layout);
		Font fon = new Font("TimesRoman",Font.BOLD,20);
		JLabel area1 = new JLabel("   东部",JLabel.CENTER);
		area1.setFont(fon);
		JLabel area2 = new JLabel("   西部",JLabel.CENTER);
		area2.setFont(fon);
		JLabel position1 = new JLabel("中区",JLabel.CENTER);
		position1.setFont(fon);
		JLabel position2 = new JLabel("大西洋区",JLabel.CENTER);
		position2.setFont(fon);
		JLabel position3 = new JLabel("东南区",JLabel.CENTER);
		position3.setFont(fon);
		JLabel position4 = new JLabel("西北区",JLabel.CENTER);
		position4.setFont(fon);
		JLabel position5 = new JLabel("太平洋区",JLabel.CENTER);
		position5.setFont(fon);
		JLabel position6 = new JLabel("西南区",JLabel.CENTER);
		position6.setFont(fon);
		
		//创建GroupLayout的水平连续组，，越先加入的ParallelGroup，优先级级别越高。
		GroupLayout.SequentialGroup hGroup = 
				layout.createSequentialGroup();
        hGroup.addGap(20);
        hGroup.addGroup(layout.createParallelGroup()
        		.addComponent(position1));
		hGroup.addGap(75);
		hGroup.addGroup(layout.createParallelGroup()
				.addComponent(area1).addComponent(position2));
		hGroup.addGap(60);
		hGroup.addGroup(layout.createParallelGroup()
                .addComponent(position3));
		hGroup.addGap(75);
		hGroup.addGroup(layout.createParallelGroup()
                .addComponent(position4));
		hGroup.addGap(60);
		hGroup.addGroup(layout.createParallelGroup()
                .addComponent(area2).addComponent(position5));
		hGroup.addGap(60);
		hGroup.addGroup(layout.createParallelGroup()
                .addComponent(position6));
		hGroup.addGap(30);
		layout.setHorizontalGroup(hGroup);
		
		//创建GroupLayout的垂直连续组，，越先加入的ParallelGroup，优先级级别越高。
		GroupLayout.SequentialGroup vGroup = 
				layout.createSequentialGroup();
		vGroup.addGap(5);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(area1).addComponent(area2));
		vGroup.addGap(5);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(position1).addComponent(position2)
				.addComponent(position3).addComponent(position4)
				.addComponent(position5).addComponent(position6));
		vGroup.addGap(5);
		layout.setVerticalGroup(vGroup);
		
		//创建球队的panel
		JPanel team = new JPanel();
		Border border1 = BorderFactory
				.createBevelBorder(BevelBorder.LOWERED);
		team.setBorder(border1);
		this.add(team, BorderLayout.CENTER);
		
		GridLayout layout1 = new GridLayout(5,6,50,5);
		team.setLayout(layout1);
		for(int i=1;i<=6;i++){
			for(int j=1;j<=5;j++){
				//通过动态方法获取队伍的图片
				JPanel test = getPanel(i,j);
				team.add(test);
			}
		}
	}

	private JPanel getPanel(int line, int row) {
		//获取队伍的图片和名称
		JPanel test = new JPanel();
		Border border = BorderFactory
				.createBevelBorder(BevelBorder.LOWERED);
		test.setBorder(border);
		test.setLayout(new BorderLayout());
		final String name = cs.findTeam(line,row);
		Image temp = cs.getTeamPic(name) ;
		JButton button = new JButton(name);
		temp = temp.getScaledInstance(80, 80, temp.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(temp);
		button.setIcon(icon);
		button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//响应事件
				cs.findAim(name);
			}
			
		});
		test.add(button,BorderLayout.CENTER);
		return test;
	}
	

}
