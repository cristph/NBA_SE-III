/**
 * @author xinlin
 * 查询窗口
 */
package presentation.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import presentation.control.ControlService;
import presentation.control.UIControler;


class NbaFrame extends JFrame{
	
	public NbaFrame(){
		init();
		this.setVisible(true);
	}

	private void init() {
		// 初始化查看界面
		this.setTitle("NBA数据库");
		int height = (int) (DataInAll.screenSize.height*0.8);
		int width = (int) (DataInAll.screenSize.width*0.6);
		this.setBounds((DataInAll.screenSize.width-width)/2
				, (DataInAll.screenSize.height-height)/2, width, height);
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		panel.setBorder(BorderFactory.createTitledBorder(border, 
				"    ", TitledBorder.LEFT,TitledBorder.TOP));
		JLabel title = new JLabel("NBA数据库");
		Font font = new Font("TimesRoman",Font.ITALIC,40);
		title.setFont(font);
		panel.add(title);
		this.add(panel,BorderLayout.NORTH);
		
		//声明一个controler作为控制
		ControlService cs = new UIControler();
		
		//选项卡的界面
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("球队查看", new TeamAllPanel(cs));
		tabbedPane.addTab("球队排序", new TeamOrderPanel(cs));
		tabbedPane.addTab("球员查看", new PlayerAllPanel(cs));
		tabbedPane.addTab("前五十球员", new PlayerTopPanel(cs));
		this.add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.setTabComponentAt(0, new JLabel("球队查看"));
		
		//状态栏
		final JLabel stateBar = new JLabel("", SwingConstants.RIGHT);
		stateBar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		//用定时任务来显示当前时间
		new java.util.Timer().scheduleAtFixedRate(
				new TimerTask(){
					DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
					public void run() {
						stateBar.setText("当前时间：" + df.format(new Date()) + "  ");
					}
				}, 0, 1000);
		this.add(stateBar, BorderLayout.SOUTH); //把状态栏添加到窗体的南边
		
		this.addWindowListener(new WindowAdapter(){

		

			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}

			
			
		});
	}
	
	
	public static void main(String[] args){
		NbaFrame f= new NbaFrame();
	}
}

