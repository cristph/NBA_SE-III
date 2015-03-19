package presentation.control;
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
		}
		    String back[] = {"得分","篮板","助攻","得分/篮板/助攻(1:1:1)","盖帽","抢断","犯规","失误","上场时间","效率","投篮","三分","罚球","两双"};
		    
		return back;
	}

	public String[] firstTitle() {
		// 表头
		String back[] = {"得分","篮板","助攻","得分/篮板/助攻(1:1:1)","盖帽","抢断","犯规","失误","上场时间","效率","投篮","三分","罚球","两双"};
	    
		return back;
	}

	public Object[][] firstObj() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[][] getList(String a, String string, String selectedItem) {
		// TODO Auto-generated method stub
		return null;
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
