/*
 * @author cristph
 * @date 2015-6-7
 */
package analysis.playeranalysis;

public class PythonTest{
	
	public static void main(String args[]){
		PythonTest t=new PythonTest();
		t.test6();
	}
	
	public void test1(){
		CMDHandler ch=new CMDHandler();
		String funcPath="python//img.py";
		String imgPath="AnalysisImage//ss.png";
		String data="";
		String returnPath="AnalysisTxt//return.txt";
		int i=0;
		while(i<20){
			double n=30+10*Math.random();
			data+=String.valueOf(n);
			if(i!=19){
				data+=";";
			}
			i++;
		}
		
		String res=ch.cmdHandler(funcPath, imgPath, data, returnPath);
		System.out.println(res);
	}
	
	public void test2(){
		CMDHandler ch=new CMDHandler();
		String funcPath="python//KSTest.py";
		String imgPath="AnalysisImage//ss.png";
		String data="";
		String returnPath="AnalysisTxt//return.txt";
		
		String res=ch.cmdHandler(funcPath, imgPath, data, returnPath);
		System.out.println(res);
	}
	
	public void test3(){
		PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
		System.out.println(psa.KSTest(""));
	}
	
	public void test4(){
		PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
		psa.intervalEstimation(1000, "");
	}
	
	public void test5(){
		PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
		psa.intervalEstimation(28, "");
	}
	
	public void test6(){
		PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
		psa.doubleSampleZTest(100, "", 100, "");
	}
	
	public void test7(){
		PlayerSelfAnalysis psa=new PlayerSelfAnalysis();
		psa.doubleSampleFTest(100, "", 100, "");
	}
}
