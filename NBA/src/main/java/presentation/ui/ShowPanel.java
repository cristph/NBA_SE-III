package presentation.ui;
/**
 * @author xinlin
 * 用于显示一个列表加上一个单选框
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import presentation.modle.MyTableModle;
import vo.PlayerInfoVO;
import vo.PlayerVO;
import vo.TeamVO;

public class ShowPanel extends JPanel{
	PlayerVO pvo;
	TeamVO tvo;
	int li;
	
	public ShowPanel(PlayerVO pvo) {
		this.pvo = pvo;
		li=0;
		init();
	}

	public ShowPanel(TeamVO tvo, int i) {
		// Team的
		this.tvo = tvo;
		li=1;
		init();
	}

	private void init() {
		this.setLayout(new BorderLayout());
		//  初始化表格
		final JRadioButton all = new JRadioButton("总数据");
		JRadioButton ave = new JRadioButton("平均数据");
		ButtonGroup group = new ButtonGroup();
		group.add(all);
		group.add(ave);
		all.setSelected(true);
		JButton sure = new JButton("确定");
		JPanel title = new JPanel();
		title.add(all);
		title.add(ave);
		title.add(sure);
		this.add(title,BorderLayout.NORTH);
		
		String title1[] = getTitle(li);
	    Object[][] list = changeList("all");
		final MyTableModle modle=new MyTableModle(list,title1);
		final JTable table = new JTable(modle);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane pane = new JScrollPane(table);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//监听
		sure.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(all.isSelected()){
					Object list1[][] = changeList("all");
					modle.upd(list1);
					repaint();
					revalidate();
				}
				else{
					Object list1[][] = changeList("ave");
					modle.upd(list1);
					repaint();
					revalidate();
				}
				
			}
			
		});
		this.add(pane,BorderLayout.CENTER);
	}

	private String[] getTitle(int li2) {
		// 确定表头
		if(li2==0){
			String title1[] = {"球员名称","所属球队","参赛场数"
					,"先发场数","篮板数","助攻数","在场时间"
					,"投篮命中率","三分命中率","罚球命中率"
					,"进攻数","防守数","抢断数","盖帽数"
					,"失误数","犯规数","得分","效率","GmSc"
					,"真实命中率","投篮效率", "篮板率"
					,"进攻篮板率","防守篮板率","助攻率","抢断率"
					,"盖帽率","失误率","使用率"};
			return title1;
		}
		String title1[] = {
				"投篮命中数","投篮出手数","三分命中数"
				, "三分出手数","罚球命中数","罚球出手数"
				,"进攻篮板数","防守篮板数","篮板数"
				,"助攻数","抢断数","盖帽数"
				,"失误数","犯规数","比赛得分"
				,"投篮命中率","三分命中率", "罚球命中率"
				,"胜率","进攻回合","进攻效率"
				,"防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻率"};
		return title1;
	}

	private Object[][] changeList(String aim) {
		//更改内容
		//变为百分数
		if(li==0){//球员的更新
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(2);//设置保留小数位
		nf.setRoundingMode(RoundingMode.HALF_UP); //设置舍入模式
				
		PlayerInfoVO temp;
		Object t[][] = new Object[1][29];
		if(aim.equals("all")){
			temp = pvo.getAll();
			t[0][0] =temp.getName();
			t[0][1] = temp.getTeam();
			t[0][2] = Integer.toString(temp.getInTime());
			t[0][3] = Integer.toString(temp.getFirstTime());
			t[0][4] = Double.toString(temp.getRebTotalNum());
			t[0][5] = Double.toString(temp.getAssistNum());
			t[0][6] = Double.toString(temp.getTime());
			t[0][7] = nf.format(temp.getShooting());
			t[0][8] = nf.format(temp.getThreeRate());
			t[0][9] = nf.format(temp.getFreeRate());
			t[0][10] =Double.toString(temp.getRebAttNum());
			t[0][11] =Double.toString(temp.getRebDefNum());
			t[0][12] =Double.toString(temp.getStealNum());
			t[0][13] =Double.toString(temp.getBlockNum());
			t[0][14] =Double.toString(temp.getErrorNum());
			t[0][15] =Double.toString(temp.getFoulNum());
			t[0][16] =Double.toString(temp.getScore());
			t[0][17] =nf.format(temp.getRate());
			t[0][18] =Double.toString(temp.getGMSC());
			t[0][19] =nf.format(temp.getRealHitRate());
			t[0][20] =nf.format(temp.getThrowRate());
			t[0][21] =nf.format(temp.getRebRate());
			t[0][22] =nf.format(temp.getAttRebRate());
			t[0][23] =nf.format(temp.getDefRebRate());
			t[0][24] =nf.format(temp.getAssistRate());
			t[0][25] =nf.format(temp.getStealRate());
			t[0][26] =nf.format(temp.getBlockRate());
			t[0][27] =nf.format(temp.getErrorRate());
			t[0][28] =nf.format(temp.getUsedRate());
			
		}
		else{
			temp = pvo.getAvg();
			t[0][0] =temp.getName();
			t[0][1] = temp.getTeam();
			t[0][2] = Integer.toString(temp.getInTime());
			t[0][3] = Integer.toString(temp.getFirstTime());
			t[0][4] = Double.toString(temp.getRebTotalNum());
			t[0][5] = Double.toString(temp.getAssistNum());
			t[0][6] = Double.toString(temp.getTime());
			t[0][7] = "无" ;
			t[0][8] = "无" ;
			t[0][9] = "无" ;
			t[0][10] =Double.toString(temp.getRebAttNum());
			t[0][11] =Double.toString(temp.getRebDefNum());
			t[0][12] =Double.toString(temp.getStealNum());
			t[0][13] =Double.toString(temp.getBlockNum());
			t[0][14] =Double.toString(temp.getErrorNum());
			t[0][15] =Double.toString(temp.getFoulNum());
			t[0][16] =Double.toString(temp.getScore());
			t[0][17] ="无" ;
			t[0][18] ="无" ;
			t[0][19] ="无" ;
			t[0][20] ="无" ;
			t[0][21] ="无" ;
			t[0][22] ="无" ;
			t[0][23] ="无" ;
			t[0][24] ="无" ;
			t[0][25] ="无" ;
			t[0][26] ="无" ;
			t[0][27] ="无" ;
			t[0][28] ="无" ;
			
		}
		
		
		return t;
		}
		//球队的信息
		Object[][] t1 = new Object[1][26];
		TeamVO temp = tvo;
		if(aim.equals("all")){
			t1[0][0] = temp.getHitShootNum();
			t1[0][1] = temp.getShootNum();
			t1[0][2] = temp.getThreePointNum();
			t1[0][3] = temp.getThreeShootNum();
			t1[0][4] = temp.getFreeHitNum();
			t1[0][5] = temp.getFreeNum();
			t1[0][6] = temp.getRebAttNum();
			t1[0][7] = temp.getRebDefNum();
			t1[0][8] = temp.getRebTotalNum();
			t1[0][9] = temp.getAssistNum();
			t1[0][10] = temp.getStealNum();
			t1[0][11] = temp.getBlockNum();
			t1[0][12] = temp.getErrorNum();
			t1[0][13] = temp.getFoulNum();
			t1[0][14] = temp.getAllpoint();
			t1[0][15] = temp.getShootrate();
			t1[0][16] = temp.getThreepointrate();
			t1[0][17] = temp.getFreehitrate();
			t1[0][18] = temp.getWinrate();
			t1[0][19] = temp.getAttackround();
			t1[0][20] = temp.getAttackrate();
			t1[0][21] = temp.getDefendrate();
			t1[0][22] = temp.getRebattrate();
			t1[0][23] = temp.getRebdefrate();
			t1[0][24] = temp.getStealrate();
			t1[0][25] = temp.getAssistrate();
		}
		else{
			t1[0][0] = temp.getHitShootNumave();
			t1[0][1] = temp.getShootNumave();
			t1[0][2] = temp.getThreePointNumave();
			t1[0][3] = temp.getThreeShootNumave();
			t1[0][4] = temp.getFreeHitNumave();
			t1[0][5] = temp.getFreeNumave();
			t1[0][6] = temp.getRebAttNumave();
			t1[0][7] = temp.getRebDefNumave();
			t1[0][8] = temp.getRebTotalNumave();
			t1[0][9] = temp.getAssistNumave();
			t1[0][10] = temp.getStealNumave();
			t1[0][11] = temp.getBlockNumave();
			t1[0][12] = temp.getErrorNumave();
			t1[0][13] = temp.getFoulNumave();
			t1[0][14] = temp.getAllpointave();
			t1[0][15] = "无";
			t1[0][16] = "无";
			t1[0][17] ="无";
			t1[0][18] ="无";
			t1[0][19] = "无";
			t1[0][20] = "无";
			t1[0][21] = "无";
			t1[0][22] = "无";
			t1[0][23] = "无";
			t1[0][24] ="无";
			t1[0][25] = "无";
		}
		return t1;
	}
}
	
	