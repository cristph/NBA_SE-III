package presentation.modle;

import javax.swing.table.AbstractTableModel;

public class MyTableModle extends AbstractTableModel{

	/** 标题行 */
	String title[];
	
	
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
