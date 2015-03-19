package presentation.control;

import java.awt.Image;

import javax.swing.JButton;

public class PlayerOrderControl implements ControlService{

	/*
	 * (non-Javadoc)
	 * @see presentation.control.ControlService#getOrder(int)
	 * int = 1,2,3分别为panel的1 2 3个下拉框
	 * 返回值为下拉框的数组
	 */
	public String[] getOrder(int i) {
		if(i==1){
			String[] m= {"总数据","平均数据"};
			return m;
		}
		if(i==2){
			String title1[] = {"球员名称","所属球队","参赛场数"
					,"先发场数","篮板数","助攻数","在场时间"
					,"投篮命中率","三分命中率","罚球命中率"
					,"进攻数","防守数","抢断数","盖帽数"
					,"失误数","犯规数","得分","效率","GmSc"
					,"效率值","真实命中率","投篮效率", "篮板率"
					,"进攻篮板率","防守篮板率","助攻率","抢断率"
					,"盖帽率","失误率","使用率"};
			return title1;
		}
		String t[] ={"升序","降序"};
		return t;
		
		
	}


	public String[] firstTitle() {
		
		String title1[] = {"球员名称","所属球队","参赛场数"
				,"先发场数","篮板数","助攻数","在场时间"
				,"投篮命中率","三分命中率","罚球命中率"
				,"进攻数","防守数","抢断数","盖帽数"
				,"失误数","犯规数","得分","效率","GmSc"
				,"效率值","真实命中率","投篮效率", "篮板率"
				,"进攻篮板率","防守篮板率","助攻率","抢断率"
				,"盖帽率","失误率","使用率"};
		return title1;
	}

	public Object[][] firstObj() {
		// 返回排序的列表
		Object[][] t =new Object[30][30];
		for(int i=0;i<30;i++){
			t[i][0] = new JButton("f");
		}
		for(int i=0;i<30;i++){
			for(int j=1;j<28;j++){
				t[i][j] = "de";
			}
		}
		
		return t;
	}


	public Object[][] getList(String a, String string, String selectedItem) {
		// 返回排序的列表
		Object[][] t =new Object[30][30];
		for(int i=0;i<30;i++){
			t[i][0] = new JButton("f");
		}
		for(int i=0;i<30;i++){
			for(int j=1;j<28;j++){
				t[i][j] = "de";
			}
		}
		
		return t;
	
	}

	public void findAim(String name) {
		// TODO Auto-generated method stub
		
	}

	public String getBoxLabel(int i) {
		// 返回下拉框的标题
		String back = "";
		if(i==1){
			back = "排序类型";
			
		}
		if(i==2){
			back = "排序依据";
		}
		
		return back;
	}
	
}
