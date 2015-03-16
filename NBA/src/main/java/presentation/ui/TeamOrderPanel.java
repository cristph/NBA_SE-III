package presentation.ui;
/**
 * @author xinlin
 * 球队的排序界面
 */



import java.awt.BorderLayout;

import javax.swing.JPanel;

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
		
		//选项面
		JPanel title = new JPanel();
		
		
	}

}
