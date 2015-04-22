package presentation.control;

public interface HotControl {
	/*@ return: String[]
	 * @ param:
	 * 返回下拉框的内容
	 */
	public String[] getTitle();
	/*
	 * @ return Object[][] 根据查询值返回表格的显示内容
	 * @ param： x:第一个下拉框选择的信息 
	 *
	 */
	public Object[][] getList(String x);
	
	/*
	 * @return: String[] 表头
	 * @param：null
	 * 得到表头
	 */
	public String[] getHead();
	/*
	 * @param:null
	 * 跳转界面
	 */
	public void findAim(String name);

}
