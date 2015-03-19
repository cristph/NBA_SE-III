package presentation.control;

import javax.swing.JButton;

/**
 * 
 * @author xinlin
 *前五十名排序的模型
 */

public class PlayerTopControl implements ControlService{
	
	/*
	 * (non-Javadoc)
	 * @see presentation.control.ControlService#findAim(java.lang.String)
	 * 进入球员界面
	 */
	public void findAim(String name) {
		
	}

	public String[] getOrder(int i) {
		if(i==1){
			String back[] = {"联盟","东部","西部","中区","大西洋区","东南区","西北区","太平洋区","西南区"};
			return back;
		}
		if(i==2){
			String back[] = {"前锋","中锋","后卫"};
			return back;
		}
		    String back[] = {"得分","篮板","助攻","得分/篮板/助攻(1:1:1)","盖帽","抢断","犯规","失误","上场时间","效率","投篮","三分","罚球","两双"};
		    
		return back;
	}

	public String[] firstTitle() {
		// 表头
		String back[] = {"姓名","得分","篮板","助攻","三项综合","盖帽","抢断","犯规","失误","上场时间","效率","投篮","三分","罚球","两双"};
	    
		return back;
	}

	public Object[][] firstObj() {
		// 返回排序的列表
		Object[][] t =new Object[14][15];
		for(int i=0;i<14;i++){
			t[i][0] = new JButton("f");
		}
		for(int i=0;i<14;i++){
			for(int j=1;j<15;j++){
				t[i][j] = "de";
			}
		}
				
		return t;
	}

	public Object[][] getList(String a, String string, String selectedItem) {
		// 返回排序的列表
		Object[][] t =new Object[14][15];
		for(int i=0;i<14;i++){
			t[i][0] = new JButton("f");
		}
		for(int i=0;i<14;i++){
			for(int j=1;j<15;j++){
				t[i][j] = "de";
			}
		}
				
		return t;
	}

	public String getBoxLabel(int i) {
		// 下拉框标题
		String back = "排序依据";
		if(i==1){
			back = "球员联盟";
		}
		if(i==2){
			back = "位置";
		}
		return back;
	}

}
