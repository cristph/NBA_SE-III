package presentation.ui;
/**
 * @author xinlin
 * 球队的排序界面
 */



import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import presentation.control.ControlService;

public class TeamOrderPanel extends JPanel {
	ControlService cs;

	public TeamOrderPanel(ControlService cs) {
		this.cs = cs;
		init();//初始化界面
		
	}

	private void init() {
		// 初始化界面
		this.setLayout(new BorderLayout());
		
		JPanel title = new JPanel();
		JLabel label = new JLabel("查询依据");
		Font fon = new Font("TimesRoman",Font.BOLD,15);
		label.setFont(fon);
		
		JLabel box1Title = new JLabel("排序类型");
		JLabel box2Title = new JLabel("排序依据");
		
		JComboBox box1 = new JComboBox(cs.getOrder());//总数据还是平均数据
		JComboBox box2 = new JComboBox(cs.getString());//各项排序依据
		
		//升降序
		ButtonGroup group = new ButtonGroup();
		JRadioButton upToDown = new JRadioButton("降序");
		JRadioButton downToUp = new JRadioButton("升序");
		group.add(downToUp);
		group.add(upToDown);
		downToUp.setSelected(true);
		
		//按钮
		JButton sure = new JButton("确认");
		
		GroupLayout layout = new GroupLayout(title);
		//水平连续组
		GroupLayout.SequentialGroup hGroup = 
				layout.createSequentialGroup();
		hGroup.addGap(20);
		hGroup.addGroup(layout.createParallelGroup().addComponent(label));
		hGroup.addGap(30);
		hGroup.addGroup(layout.createParallelGroup().addComponent(box1Title).addComponent(box1));
		hGroup.addGap(30);
		hGroup.addGroup(layout.createParallelGroup().addComponent(box2Title).addComponent(box2));
		hGroup.addGap(30);
		hGroup.addGroup(layout.createParallelGroup().addComponent(upToDown));
		hGroup.addGap(10);
		hGroup.addGroup(layout.createParallelGroup().addComponent(downToUp));
		hGroup.addGap(10);
		hGroup.addGroup(layout.createParallelGroup().addComponent(sure));
		
		//垂直连续组
		GroupLayout.SequentialGroup vGroup = 
				layout.createSequentialGroup();
		vGroup.addGap(5);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(box1Title).addComponent(box2Title));
		vGroup.addGap(5);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(label).addComponent(box1).addComponent(box2)
				.addComponent(downToUp).addComponent(downToUp)
				.addComponent(sure));
		
		layout.setHorizontalGroup(hGroup);
		this.add(title,BorderLayout.NORTH);
		
		
		//监听
		sure.addActionListener(new ActionListener(){

		

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
				
		
	}

}
