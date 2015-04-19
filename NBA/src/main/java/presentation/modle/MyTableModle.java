package presentation.modle;

import javax.swing.table.AbstractTableModel;

public class MyTableModle extends AbstractTableModel{

	/** 标题行 */
	String title[] = {"球队简称","球队名","比赛场数"
			,"投篮命中率","投篮出手数","三分命中数"
			, "三分出手数","罚球命中数","罚球出手数"
			,"进攻篮板数","防守篮板数","篮板数"
			,"助攻数","抢断数","盖帽数"
			,"失误数","犯规数","比赛得分"
			,"投篮命中率","三分命中率", "罚球命中率"
			,"胜率","进攻回合","进攻效率"
			,"防守效率","篮板效率","抢断效率","助攻率"};
	
	
	/** 数据行 */
	private Object[][] list;
	
	public MyTableModle(Object[][] list,String title[]){
		super();
		this.title = title;
		this.list = list;
		
	}
	public int getRowCount() {
		// 得到行
		
		return list.length;
	}

	public int getColumnCount() {
		// 得到列
		return title.length;
	}

	public Object getValueAt(int row, int column) {
		// 返回选中项
		return list[row][column];
	}
	
	 @Override
	public String getColumnName(int c) {
		 //返回标题
		 return title[c];
     }
	 
	 @Override
	public Class<?> getColumnClass(int columnIndex) {
		 System.out.println("gggg"+columnIndex);
		   return list[0][columnIndex].getClass();
      }
	 
	 @Override
	  public boolean isCellEditable(int rowIndex, int columnIndex) {
	   if (columnIndex == 0 ) {
	    return false;
	   }
	   return true;
	  }
	
	public void upd(Object[][] list){
		//更新列表
		this.list = list;
	}

}
