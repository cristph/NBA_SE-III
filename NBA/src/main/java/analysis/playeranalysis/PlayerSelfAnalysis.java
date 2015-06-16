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
	public String KSTest(String dataSet,double mean,double std){
		
		String funcPath="python//KSTest.py";
		String res=ch.cmdHandler(funcPath, dataSet,String.valueOf(mean),String.valueOf(std));
		System.out.println(res);
		int i=res.lastIndexOf("=")+1;
		int j=res.lastIndexOf(")");
		String p_str=res.substring(i, j);
		p_value=Double.parseDouble(p_str);
		//System.out.println("P: "+p_value);
		//System.out.println(res);
		return res;
	}
	
	public boolean testKS(String res){
		boolean result=false;
		
		int i=res.lastIndexOf("=")+1;
		int j=res.lastIndexOf(")");
		String p_str=res.substring(i, j);
		p_value=Double.parseDouble(p_str);
		
		if(p_value>=0.05){
			result=true;
		}
		return result;
	}
	
	
	/*
	 * calculate the interval at a
	 * sample_num>=30,Normal distribution
	 * sample_num<30,t distribution
	 */
	public String intervalEstimation(int sample_num,String dataSet,double credit){
		
		String txtResult="";
		if(sample_num>=30){
			//have a limit of normal
			//a=0.1
			String funcPath="python//intervalEstimation_Z.py";
			String res=ch.cmdHandler(funcPath, dataSet, String.valueOf(credit));
			txtResult+="样本数大于30，我们认为样本均值的抽样分布近似服从于正态分布"+"\r\n"
					+"我们对其进行单总体均值区间估计，得到均值有95%的可信度落在以下区间"+"\r\n";
			txtResult+=res;
			System.out.println(res);
		}else{
			double mea=getMean(dataSet);
			double std=getStd(dataSet);
			String temp=KSTest(dataSet,mea,std);
			boolean isNormal=testKS(temp);
			if(isNormal){
				//use t distribution
				//a=0.1
				String funcPath="python//intervalEstimation_t.py";
				String res=ch.cmdHandler(funcPath, dataSet, String.valueOf(credit));
				txtResult+="样本容量小于30，为了验证总体正态性，我们做单总体K-S检验，作出假设："+ "\r\n"
						+"	H0:该名球员的每场比赛该项指标服从正态分布，H1:该名球员球员的每场比赛该项指标不服从正态分布"+"\r\n"
						+"而K-S检验结果为："+temp+"\r\n"
						+"由于P值大于5%，我们不能拒绝原假设H0,即认为该名球员球员的每场比赛该项指标服从正态分布";
				txtResult+="那么我们对其进行单总体均值区间估计，得到均值有95%的可信度落在以下区间"+"\r\n";
				txtResult+=res;
				System.out.println(res);
			}else{
				//unable to analyse the data
				txtResult+="我们做单总体K-S检验，作出假设："+ "\r\n"
						+"	H0:该名球员的每场比赛该项指标服从正态分布，H1:该名球员球员的每场比赛该项指标不服从正态分布"+"\r\n"
						+"而K-S检验结果为："+temp+"\r\n"
						+"由于P值小于5%，我们拒绝原假设H0,即认为该名球员球员的每场比赛该项指标不服从正态分布"
						+"\r\n"+"那么我们无法完成区间估计";
			}
		}
		
		return txtResult;
	}
	
	/*
	 * Z test on double sample
	 * 
	 */
	public String doubleSampleZTest(int sample_num1, String dataSet1, 
			int sample_num2, String dataSet2){
		String txtResult="";
		
		if(sample_num1>=30&&sample_num2>=30){
			String funcPath="python//ZTest.py";
			String res=ch.cmdHandler(funcPath, dataSet1, dataSet2);
			txtResult+="两个样本容量都大于30，我们直接进行双总体均值检验，作出假设H0：u1-u2>=0"+"\r\n";
			txtResult+="我们构造检验统计量Z"+"\r\n"
					+"通过计算可得到Z值和对应a=0.05分位的-Za的值分别为:"+"\r\n";
			txtResult+=res;
			String temp[]=res.split(" ");
			double a=Double.parseDouble(temp[0]);
			double b=Double.parseDouble(temp[1]);
			System.out.println("a:"+a+"b:"+b);
			if(a<=b){
				txtResult+="\r\n"+"由于Z<=-Za,我们拒绝原假设，即认为总体1指标均值小于总体2指标均值";
			}else{
				txtResult+="\r\n"+"由于Z>-Za,我们不能拒绝原假设，即认为总体1指标均值大于总体2指标均值";
			}
			System.out.println(res);
		}else{
			String temp1=KSTest(dataSet1,getMean(dataSet1),getStd(dataSet1));
			boolean isNormal1=testKS(temp1);
			if(isNormal1){
				String temp2=KSTest(dataSet2,getMean(dataSet2),getStd(dataSet2));
				boolean isNormal2=testKS(temp2);
				if(isNormal2){
					//both normal distribution
					String funcPath="python//ZTest.py";
					String res=ch.cmdHandler(funcPath, dataSet1, dataSet2);
					
					txtResult="样本数小于30，我们对两个总体分别作 单总体K-S检验，作出假设："+ "\r\n"
							+"	H0:该名球员的每场比赛该项指标服从正态分布，H1:该名球员球员的每场比赛该项指标不服从正态分布"+"\r\n"
							+"而两次的K-S检验结果分别为："+temp1+"\r\n"+temp2+"\r\n"
							+"由于P值均大于5%，我们不能拒绝原假设H0,即认为该名球员球员的每场比赛该项指标服从正态分布"+"\r\n"
							+"那么我们可以构造检验统计量Z"+"\r\n"
							+"通过计算可得到Z值和对应a=0.05分位的Za的值分别为:"+"\r\n";
					txtResult+=res;
					String temp[]=res.split(" ");
					double a=Double.parseDouble(temp[0]);
					double b=Double.parseDouble(temp[1]);
					System.out.println("a:"+a+"b:"+b);
					if(a<=b){
						txtResult+="\r\n"+"由于Z<=-Za,我们拒绝原假设，即认为总体1指标均值小于总体2指标均值";
					}else{
						txtResult+="\r\n"+"由于Z>-Za,我们不能拒绝原假设，即认为总体1指标均值大于总体2指标均值";
					}
					
					System.out.println(res);
				}else{
					//unable to anlyse the data
					txtResult="样本数小于30，我们对两个总体分别作 单总体K-S检验，作出假设："+ "\r\n"
							+"	H0:该名球员的每场比赛该项指标服从正态分布，H1:该名球员球员的每场比赛该项指标不服从正态分布"+"\r\n"
							+"而两次的K-S检验结果分别为："+temp1+"\r\n"+temp2+"\r\n"
							+"由于第二次P值小于5%，我们拒绝原假设H0,即认为该名球员球员的每场比赛该项指标不服从正态分布"+"\r\n"
							+"那么我们不可以进行双总体均值差的检验";
				}
			}else{
				//unable to anlyse the data
				txtResult="样本数小于30，我们对两个总体分别作 单总体K-S检验，作出假设："+ "\r\n"
						+"	H0:该名球员的每场比赛该项指标服从正态分布，H1:该名球员球员的每场比赛该项指标不服从正态分布"+"\r\n"
						+"而第一次的K-S检验结果分别为："+temp1+"\r\n"
						+"由于第一次P值小于5%，我们拒绝原假设H0,即认为该名球员球员的每场比赛该项指标不服从正态分布"+"\r\n"
						+"那么我们不可以进行双总体均值差的检验";
			}
		}
		return txtResult;
	}
	
	public String doubleSampleFTest(int sample_num1, String dataSet1, 
			int sample_num2, String dataSet2){
		
		String txtResult="";
		
		String temp1=KSTest(dataSet1,getMean(dataSet1),getStd(dataSet1));
		boolean isNormal1=testKS(temp1);
		if(isNormal1){
			String temp2=KSTest(dataSet2,getMean(dataSet2),getStd(dataSet2));
			boolean isNormal2=testKS(temp2);
			if(isNormal2){
				//both normal distribution
				String funcPath = "python//FTest.py";
				String res=ch.cmdHandler(funcPath, dataSet1, dataSet2);
				txtResult="为了进行双总体方差比检验，要求两个总体都成正态分布"+"\r\n"
						+"那么我们对两个总体分别作 单总体K-S检验，作出假设："+ "\r\n"
						+"	H0:该名球员的每场比赛该项指标服从正态分布"+"\r\n"
						+"而两次的K-S检验结果分别为："+temp1+"\r\n"+temp2+"\r\n"
						+"由于P值均大于5%，我们不能拒绝原假设H0,即认为该名球员球员的每场比赛该项指标服从正态分布"+"\r\n"
						+"那么我们可以做出假设H0:theta1^2<=theta2^2"+"\r\n"
						+"我们可以构造检验统计量F"+"\r\n"
						+"通过计算可得到F值和对应a=0.05分位的Fa的值分别为:"+"\r\n";
				txtResult+=res;
				
				String temp[]=res.split(" ");
				double a=Double.parseDouble(temp[0]);
				double b=Double.parseDouble(temp[1]);
				System.out.println("a:"+a+"b:"+b);
				if(a<b){
					txtResult+="\r\n"+"由于F<Fa,我们不能拒绝原假设，即认为总体1指标方差小于总体2";
				}else{
					txtResult+="\r\n"+"由于F>=Fa,我们拒绝原假设，即认为总体1指标方差大于总体2";
				}
				
				System.out.println(res);
			}else{
				//unable to anlyse the data
				txtResult="我们对两个总体分别作 单总体K-S检验，作出假设："+ "\r\n"
						+"	H0:该名球员的每场比赛该项指标服从正态分布，H1:该名球员球员的每场比赛该项指标不服从正态分布"+"\r\n"
						+"而两次的K-S检验结果分别为："+temp1+"\r\n"+temp2+"\r\n"
						+"由于第二次P值小于于5%，我们拒绝原假设H0,即认为该名球员球员的每场比赛该项指标不服从正态分布"+"\r\n"
						+"那么我们无法进行双总体方差比的检验";
			}
		}else{
			//unable to anlyse the data
			txtResult="我们对两个总体分别作 单总体K-S检验，作出假设："+ "\r\n"
					+"	H0:该名球员的每场比赛该项指标服从正态分布，H1:该名球员球员的每场比赛该项指标不服从正态分布"+"\r\n"
					+"而第一次次的K-S检验结果分别为："+temp1+"\r\n"
					+"由于第一次P值小于于5%，我们拒绝原假设H0,即认为该名球员球员的每场比赛该项指标不服从正态分布"+"\r\n"
					+"那么我们无法进行双总体方差比的检验";
		}
		return txtResult;
	}
	
	public void getTwoBars(String dataSet1,String dataSet2,String name){
		String funcPath = "python//bar.py";
		ch.cmdHandler(funcPath, dataSet1, dataSet2, name);
	}
	
	public void getRedar(String dataSet1,String dataSet2,String name){
		String funcPath = "python//leida.py";
		ch.cmdHandler(funcPath, dataSet1, dataSet2, name);
	}
	
	public void getRedar_1(String dataSet1,String name){
		String funcPath = "python//leida_1.py";
		ch.cmdHandler(funcPath, dataSet1, name);
	}
	
	public double getMean(String data){
		String funcPath = "python//getmean.py";
		double res=Double.parseDouble(ch.cmdHandler(funcPath,data));
		System.out.println("use getMean: "+res);
		return res;
	}
	
	public double getStd(String data){
		String funcPath = "python//getvar.py";
		double res=Double.parseDouble(ch.cmdHandler(funcPath,data));
		System.out.println("use getStd: "+res);
		return res;
	}
	
	public void getSingleBar(String data,String name){
		String funcPath = "python//single_bar.py";
		ch.cmdHandler(funcPath, data, name);
	}
}
