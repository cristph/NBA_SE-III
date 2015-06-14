/*
 * @author cristph
 * @date 2015-6-7
 */
package analysis.playeranalysis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class CMDHandler {
	
	public String cmdHandler(String funcPath, String imgPath, String data, String returnPath){
		String result="";
		String order=null;
		if(isWindowsOS()){
			order="cmd /c python";
		}else if(isMacOS()){
			order="python";
		}
		
		if(funcPath!=null&&funcPath.length()>1){
			order+=" ";
			order+=funcPath;
		}else{
			return "empty func Path";
		}
		
		if(imgPath!=null&&imgPath.length()>1){
			order+=" ";
			order+=imgPath;
		}else{
			return "empty img Path";
		}
		
		if(data!=null){
			order+=" ";
			order+=data;
		}else{
			return "empty data Path";
		}
		
		if(returnPath!=null){
			order+=" ";
			order+=returnPath;
		}else{
			return "empty return Path";
		}
		
		Process pro=null;
		try {
			//System.out.println(order);
			pro=Runtime.getRuntime().exec(order);
			InputStream is=pro.getInputStream();
			BufferedReader buf=new BufferedReader(new InputStreamReader(is));
			
			String line=buf.readLine();
			//System.out.println(line);
			result+=line;
			while((line=buf.readLine())!=null){
				//System.out.println(line);
				result+=" ";
				result+=line;
				//System.out.println("k");
			}
			//pro.destroy();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String cmdHandler(String funcPath, String dataSet){
		String result="";
		String order=null;
		if(isWindowsOS()){
			order="cmd /c python";
		}else if(isMacOS()){
			order="python";
		}
		
		if(funcPath!=null&&funcPath.length()>1){
			order+=" ";
			order+=funcPath;
		}else{
			return "empty func Path";
		}
		
		if(dataSet!=null){
			order+=" ";
			order+=dataSet;
		}else{
			return "empty data Path";
		}
		
		
		Process pro=null;
		try {
			//System.out.println(order);
			pro=Runtime.getRuntime().exec(order);
			InputStream is=pro.getInputStream();
			BufferedReader buf=new BufferedReader(new InputStreamReader(is));
			
			String line=buf.readLine();
			//System.out.println(line);
			result+=line;
			while((line=buf.readLine())!=null){
				//System.out.println(line);
				result+=" ";
				result+=line;
				//System.out.println("k");
			}
			//pro.destroy();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public String cmdHandler(String funcPath, String dataSet1, String dataSet2){
		String result="";
		String order=null;
		if(isWindowsOS()){
			order="cmd /c python";
		}else if(isMacOS()){
			order="python";
		}
		
		if(funcPath!=null&&funcPath.length()>1){
			order+=" ";
			order+=funcPath;
		}else{
			return "empty func Path";
		}
		
		if(dataSet1!=null){
			order+=" ";
			order+=dataSet1;
		}else{
			return "empty data1 Path";
		}
		
		if(dataSet2!=null){
			order+=" ";
			order+=dataSet2;
		}else{
			return "empty data2 Path";
		}
		
		
		Process pro=null;
		try {
			//System.out.println(order);
			pro=Runtime.getRuntime().exec(order);
			InputStream is=pro.getInputStream();
			BufferedReader buf=new BufferedReader(new InputStreamReader(is));
			
			String line=buf.readLine();
			//System.out.println(line);
			result+=line;
			while((line=buf.readLine())!=null){
				//System.out.println(line);
				result+=" ";
				result+=line;
				//System.out.println("k");
			}
			//pro.destroy();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean isWindowsOS(){
		String os = System.getProperty("os.name").toLowerCase();
		return (os.indexOf("win") >= 0);
	}
	
	public boolean isMacOS(){
		String os = System.getProperty("os.name").toLowerCase();
		return (os.indexOf("mac") >= 0);
	}
	
	public String getOutPut(String filePath){
		
		String outPut="";
		try {
			InputStream in = new FileInputStream(filePath);
			InputStreamReader inOne = new InputStreamReader(in);
			BufferedReader inTwo = new BufferedReader(inOne);
			String line=inTwo.readLine();
			outPut+=line;
			while((line=inTwo.readLine())!=null){
				if(line.equals("")){
					outPut+=" ";
				}else{
					outPut+=line;	
				}
			}
			inTwo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outPut;
	}
}
