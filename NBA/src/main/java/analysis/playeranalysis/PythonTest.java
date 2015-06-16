/*
 * @author cristph
 * @date 2015-6-7
 */
package analysis.playeranalysis;

public class PythonTest{
	
	public static void main(String args[]){
		PythonTest t=new PythonTest();
		t.test15();
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
	
	public void test8(){
		CMDHandler ch=new CMDHandler();
		CMDHandler ch2=new CMDHandler();
		String funcPath1="python//leida.py";
		String funcPath2="python//bar.py";
		
		ch.cmdHandler(funcPath1);
		ch2.cmdHandler(funcPath2);
	}
	
	public void test9(){
		PlayerAnalyseController pac=new PlayerAnalyseController();
		//pac.getSortInfo("得分", "");
	}
	
	public void test10(){
		PlayerAnalyseController pac=new PlayerAnalyseController();
		//pac.getIntervalInfo("助攻", "Kevin Durant");
	}
	
	public void test11(){
		PlayerAnalyseController pac=new PlayerAnalyseController();
		//pac.getAvgEvolveInfo("助攻", "James Harden");
	}
	
	public void test12(){
		PlayerAnalyseController pac=new PlayerAnalyseController();
		//pac.getVarEvolveInfo("助攻", "James Harden");
	}
	
	public void test13(){
		PlayerAnalyseController pac=new PlayerAnalyseController();
		//pac.getPlayersInfo("得分", "James Harden", "Lebron James");
	}
	
	public void test14(){
		PlayerAnalyseController pac=new PlayerAnalyseController();
		pac.showRedar("Lebron James", "Kevin Durant");
	}
	
	public void test15(){
		PlayerAnalyseController pac=new PlayerAnalyseController();
		pac.showRedar("Lebron James");
	}
}
