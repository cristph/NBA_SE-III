package presentation.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import vo.DateGameVO;

public class GameList extends JPanel{
	JScrollPane scroll;
	JPanel panel;
	public GameList(){
		super();
		scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}

	public GameList(ArrayList<DateGameVO> date) {
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		for(int i=0;i<date.size();i++){
			DateGameVO temp = date.get(i);
			panel.add(CreatePanel(temp));
		}
		scroll =new JScrollPane(panel);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.setLayout(new BorderLayout());
		this.add(scroll,BorderLayout.CENTER);
		revalidate();
		this.repaint();
	}

	private JPanel CreatePanel(DateGameVO temp) {
		// 根据temp得到信息
		JLabel team1 = new JLabel(temp);
		return null;
	}

	public void update(ArrayList<DateGameVO> game) {
		//更新下拉菜单
		
	}
	

}
