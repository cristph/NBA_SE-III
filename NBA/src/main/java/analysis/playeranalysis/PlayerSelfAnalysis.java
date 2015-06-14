package analysis.playeranalysis;

public class PlayerSelfAnalysis {
	
	CMDHandler ch;
	static double p_value=0;
	
	PlayerSelfAnalysis(){
		ch=new CMDHandler();
	}
	
	/*
	 *use python func to test if Normal through K-STest 
	 * 
	 */
	public boolean KSTest(String dataSet){
		boolean result=false;
		
		String funcPath="python//KSTest.py";
		String res=ch.cmdHandler(funcPath, dataSet);
		
		int i=res.lastIndexOf("=")+1;
		int j=res.lastIndexOf(")");
		String p_str=res.substring(i, j);
		p_value=Double.parseDouble(p_str);
		
		if(p_value>=0.05){
			result=true;
		}
		System.out.println(p_value);
		System.out.println(res);
		return result;
	}
	
	
	/*
	 * calculate the interval at a
	 * sample_num>=30,Normal distribution
	 * sample_num<30,t distribution
	 */
	public void intervalEstimation(int sample_num,String dataSet){
		if(sample_num>=30){
			//have a limit of normal
			//a=0.1
			String funcPath="python//intervalEstimation_Z.py";
			String res=ch.cmdHandler(funcPath, dataSet);
			System.out.println(res);
		}else{
			boolean isNormal=KSTest(dataSet);
			if(isNormal){
				//use t distribution
				//a=0.1
				String funcPath="python//intervalEstimation_t.py";
				String res=ch.cmdHandler(funcPath, dataSet);
				System.out.println(res);
			}else{
				//unable to analyse the data
			}
		}
	}
	
	/*
	 * Z test on double sample
	 * 
	 */
	public void doubleSampleZTest(int sample_num1, String dataSet1, 
			int sample_num2, String dataSet2){
		if(sample_num1>=30&&sample_num2>=30){
			String funcPath="python//ZTest.py";
			String res=ch.cmdHandler(funcPath, dataSet1, dataSet2);
			System.out.println(res);
		}else{
			boolean isNormal1=KSTest(dataSet1);
			if(isNormal1){
				boolean isNormal2=KSTest(dataSet2);
				if(isNormal2){
					//both normal distribution
					String funcPath="python//ZTest.py";
					String res=ch.cmdHandler(funcPath, dataSet1, dataSet2);
					System.out.println(res);
				}else{
					//unable to anlyse the data
				}
			}else{
				//unable to anlyse the data
			}
		}
	}
	
	public void doubleSampleFTest(int sample_num1, String dataSet1, 
			int sample_num2, String dataSet2){
		
		boolean isNormal1=KSTest(dataSet1);
		if(isNormal1){
			boolean isNormal2=KSTest(dataSet2);
			if(isNormal2){
				//both normal distribution
				String funcPath = "python//FTest.py";
				String res=ch.cmdHandler(funcPath, dataSet1, dataSet2);
				System.out.println(res);
			}else{
				//unable to anlyse the data
			}
		}else{
			//unable to anlyse the data
		}
	}
}
