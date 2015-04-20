/**
 * @author xinlin
 * 用于热点的显示
 * 用tabel来显示 第一列显示为图片
 */
package presentation.ui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import presentation.control.HotControl;
import presentation.modle.MyTableModle;


public class PicPanel extends JPanel {

	HotControl hc;
	JComboBox box;
	public PicPanel(HotControl hpc) {
		this.hc = hpc;
		init();
	}
	private void init() {
		this.setLayout(new BorderLayout());
		
		JPanel title  = new JPanel();
		JLabel label = new JLabel("筛选条件");
		box = new JComboBox(hc.getTitle());
		JButton sure = new JButton("确定");
		
		title.add(label);
		title.add(box);
		title.add(sure);
		
		this.add(title,BorderLayout.NORTH);
		
		//添加表格
		final MyTableModle modle = new MyTableModle(hc.getList((String)(box.getSelectedItem())),hc.getHead());
		final JTable table = new JTable(modle);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane pane = new JScrollPane(table);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		table.setDefaultRenderer(JButton.class,new ComboBoxCellRenderer());
		this.add(pane,BorderLayout.CENTER);
		
		sure.addActionListener(new ActionListener(){

			

			public void actionPerformed(ActionEvent e) {
				// 点击确认按钮的事件
				
				Object[][] list =hc.getList((String)(box.getSelectedItem()));
				modle.upd(list);
				table.repaint();
			}
			
		});	
		
		
	}

}
