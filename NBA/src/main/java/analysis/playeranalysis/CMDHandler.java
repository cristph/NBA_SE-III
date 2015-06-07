/*
 * @author cristph
 * @date 2015-6-7
 */
package analysis.playeranalysis;

import java.io.IOException;

public class CMDHandler {
	
	public void cmdHandler(String funcPath, String imgPath, String data){
		String order=null;
		if(isWindowsOS()){
			order="cmd /k start python";
		}else if(isMacOS()){
			order="python";
		}
		
		if(funcPath!=null&&funcPath.length()>1){
			order+=" ";
			order+=funcPath;
		}else{
			return;
		}
		
		if(imgPath!=null&&imgPath.length()>1){
			order+=" ";
			order+=imgPath;
		}else{
			return;
		}
		
		if(data!=null){
			order+=" ";
			order+=data;
		}else{
			return;
		}
		
		Process pro=null;
		try {
			System.out.println(order);
			pro=Runtime.getRuntime().exec(order);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isWindowsOS(){
		String os = System.getProperty("os.name").toLowerCase();
		return (os.indexOf("win") >= 0);
	}
	
	public boolean isMacOS(){
		String os = System.getProperty("os.name").toLowerCase();
		return (os.indexOf("mac") >= 0);
	}
}
