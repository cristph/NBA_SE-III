package presentation.control;

public interface ControlService {
	
	public void findAim(String name) ;//跳转项

	String[] getOrder(int i);//获取下拉框内容

	String[] firstTitle();//初始化表头

	Object[][] firstObj();//初始化表

	/*
	 * @author:xinlin
	 * 三个String分别是第一项下拉框第二项下拉框第三项下拉框的选项
	 */
	Object[][] getList(String string, String string1, String string2);

	public String getBoxLabel(int i);//得到下拉框的标题

}
