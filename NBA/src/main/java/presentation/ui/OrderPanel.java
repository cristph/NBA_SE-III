package presentation.ui;
/**
 * @author xinlin
 * 球队的排序界面
 */



import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import presentation.control.ControlService;
import presentation.modle.MyTableModle;

public class OrderPanel extends JPanel {
	ControlService cs;
	JComboBox box1;
	JComboBox box2;
	JComboBox box3;

	public OrderPanel(ControlService cs) {
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
		
		JLabel box1Title = new JLabel(cs.getBoxLabel(1));
		JLabel box2Title = new JLabel(cs.getBoxLabel(2));
		JLabel box3Title = new JLabel(cs.getBoxLabel(3));
		
		box1 = new JComboBox(cs.getOrder(1));//第一项下拉框
		box2 = new JComboBox(cs.getOrder(2));//第二项下拉框
		box3 = new JComboBox(cs.getOrder(3));//第二项下拉框
		
		
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
		hGroup.addGroup(layout.createParallelGroup().addComponent(box3Title).addComponent(box3));
		hGroup.addGap(10);
		hGroup.addGroup(layout.createParallelGroup().addComponent(sure));
		//垂直连续组
		GroupLayout.SequentialGroup vGroup = 
				layout.createSequentialGroup();
		vGroup.addGap(5);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(box1Title).addComponent(box2Title).addComponent(box3Title));
		vGroup.addGap(5);
		vGroup.addGroup(layout.createParallelGroup()
				.addComponent(label).addComponent(box1).addComponent(box2)
				.addComponent(box3)
				.addComponent(sure));
		
		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
		this.add(title,BorderLayout.NORTH);
		
		//展示的列表
		final MyTableModle modle=new MyTableModle(cs.firstObj(),cs.firstTitle());
		final JTable table = new JTable(modle);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane pane = new JScrollPane(table);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		table.setDefaultRenderer(JButton.class,new ComboBoxCellRenderer());
		this.add(pane,BorderLayout.CENTER);
		
		//监听
		sure.addActionListener(new ActionListener(){

		

			public void actionPerformed(ActionEvent e) {
				// 点击确认按钮的事件
				
				Object[][] list = cs.getList((String)(box1.getSelectedItem()),(String)box2.getSelectedItem(),(String)box3.getSelectedItem());
				String title[] = cs.firstTitle();
				modle.upd(list,title);
				table.repaint();
			}
			
		});	
		//table的监听
		table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				int row = table.getSelectedRow();
				int line = table.getSelectedColumn();
				if(line==0){
					JButton m = (JButton)table.getValueAt(row,line);
					String name = m.getText();
					cs.findAim(name);
					
				}
			}
			
		});
	}
	

	
}
