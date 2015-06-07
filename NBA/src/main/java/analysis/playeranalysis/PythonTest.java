/*
 * @author cristph
 * @date 2015-6-7
 */
package analysis.playeranalysis;

public class PythonTest{
	
	public static void main(String args[]){
		
		CMDHandler ch=new CMDHandler();
		String funcPath="D:\\finalProject\\NBA_SE-III\\NBA\\python\\img.py";
		String imgPath="D:\\fig.png";
		String data="";
		int i=0;
		while(i<20){
			double n=30+10*Math.random();
			data+=String.valueOf(n);
			if(i!=19){
				data+=";";
			}
			i++;
		}
		ch.cmdHandler(funcPath, imgPath, data);
	}
}
