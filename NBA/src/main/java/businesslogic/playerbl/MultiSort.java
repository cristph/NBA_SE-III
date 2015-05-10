package businesslogic.playerbl;

import java.lang.reflect.Method;
import java.util.ArrayList;

import businesslogicservice.playerblservice.PlayerBLService;
import test.data.PlayerHighInfo;
import test.data.PlayerNormalInfo;
import value.PlayerStandard;
import value.Value.Age;
import value.Value.League;
import value.Value.Order;
import value.Value.Position;

public class MultiSort {
	
	public void mulNormalSort(ArrayList<PlayerNormalInfo> list,PlayerStandard origin,PlayerStandard des,Order ord){
		int i=0;
		int j=1;
		
		while(i<list.size()){
			
			double vai=(Double)getFieldValueByName(origin.toString(),list.get(i));
			double vaj=(Double)getFieldValueByName(origin.toString(),list.get(j));
			
			if(vai!=vaj){
				
				i++;
				if(j<list.size()-1){
					j++;
				}
				
				if(i==list.size()-1){
					break;
				}
			}else{
				
				while(vai==vaj){
					
					if(j==list.size()-1){
						break;
					}
					
					if(j<list.size()-1){
						j++;
					}
					vaj=(Double)getFieldValueByName(origin.toString(),list.get(j));
				}//vai!=vaj sort (i,j-1)
				
				
				if(j==list.size()-1){
					//System.out.println("Swap "+i+"and "+j);
					sortN(list,ord,des,i,j);
					break;
				}else{
					//System.out.println("Swap "+i+"and "+(j-1));
					sortN(list,ord,des,i,j-1);	
				}
				
				i=j;
				if(j<list.size()-1){
					j++;
				}
				
				if(i==list.size()-1){
					break;
				}
			}
		}//end of while
	}
	
	public void mulHighSort(ArrayList<PlayerHighInfo> list,PlayerStandard origin,PlayerStandard des,Order ord){
		int i=0;
		int j=1;
		
		while(i<list.size()){
			
			double vai=(Double)getFieldValueByName(origin.toString(),list.get(i));
			double vaj=(Double)getFieldValueByName(origin.toString(),list.get(j));
			
			if(vai!=vaj){
				
				i++;
				if(j<list.size()-1){
					j++;
				}
				
				if(i==list.size()-1){
					break;
				}
			}else{
				
				while(vai==vaj){
					
					if(j==list.size()-1){
						break;
					}
					
					if(j<list.size()-1){
						j++;
					}
					vaj=(Double)getFieldValueByName(origin.toString(),list.get(j));
				}//vai!=vaj sort (i,j-1)
				
				
				if(j==list.size()-1){
					//System.out.println("Swap "+i+"and "+j);
					sortH(list,ord,des,i,j);
					break;
				}else{
					//System.out.println("Swap "+i+"and "+(j-1));
					sortH(list,ord,des,i,j-1);
				}
				
				i=j;
				if(j<list.size()-1){
					j++;
				}
				
				if(i==list.size()-1){
					break;
				}
			}
		}//end of while
	}
	
	private Object getFieldValueByName(String fieldName, Object o) {
	       try {
	           String firstLetter = fieldName.substring(0, 1).toUpperCase();    
	           String getter = "get" + firstLetter + fieldName.substring(1);  
	           Method method = o.getClass().getMethod(getter, new Class[] {});
	           Object value = method.invoke(o, new Object[] {});
	           return value;
	       }catch (Exception e) {
	           return null;
	       }   
	}
	
	public void sortN(ArrayList<PlayerNormalInfo> list,Order order, PlayerStandard ps,int beg,int end){
		if(order==Order.asc){
			if(ps==PlayerStandard.point){
				ScoreUPSort sus=new ScoreUPSort();
				sus.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.rebound){
				RebTotalNumUPSort nts=new RebTotalNumUPSort();
				nts.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.assist){
				AssistNumUPSort ans=new AssistNumUPSort();
				ans.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.steal){
				StealNumUPSort sns=new StealNumUPSort();
				sns.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.blockShot){
				BlockNumUPSort bns=new BlockNumUPSort();
				bns.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.foul){
				FoulNumUPSort fns=new FoulNumUPSort();
				fns.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.fault){
				ErrorNumUPSort ens=new ErrorNumUPSort();
				ens.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.minute){
				TimeUPSort tus=new TimeUPSort();
				tus.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.efficient){
				RateUPSort rus=new RateUPSort();
				rus.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.shooting){
				ShootingUPSort sus=new ShootingUPSort();
				sus.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.threeRate){
				ThreeRateUPSort trs=new ThreeRateUPSort();
				trs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.freeRate){
				FreeRateUPSort frs=new FreeRateUPSort();
				frs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.name){
				NameUPSort nus=new NameUPSort();
				nus.mulSort(list, beg, end);
			}
		}else{
			if(ps==PlayerStandard.point){
				ScoreDSort sus=new ScoreDSort();
				sus.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.rebound){
				RebTotalNumDSort nts=new RebTotalNumDSort();
				nts.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.assist){
				AssistNumDSort ans=new AssistNumDSort();
				ans.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.steal){
				StealNumDSort sns=new StealNumDSort();
				sns.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.blockShot){
				BlockNumDSort bns=new BlockNumDSort();
				bns.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.foul){
				FoulNumDSort fns=new FoulNumDSort();
				fns.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.fault){
				ErrorNumDSort ens=new ErrorNumDSort();
				ens.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.minute){
				TimeDSort tus=new TimeDSort();
				tus.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.efficient){
				RateDSort rus=new RateDSort();
				rus.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.shooting){
				ShootingDSort sus=new ShootingDSort();
				sus.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.threeRate){
				ThreeRateDSort trs=new ThreeRateDSort();
				trs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.freeRate){
				FreeRateDSort frs=new FreeRateDSort();
				frs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.name){
				NameDSort nds=new NameDSort();
				nds.mulSort(list, beg, end);
			}
		}
	}
	
	public void sortH(ArrayList<PlayerHighInfo> list,Order order, PlayerStandard ps,int beg,int end){
		if(order==Order.asc){
			if(ps==PlayerStandard.realShot){
				RealHitRateUPSort rhs=new RealHitRateUPSort();
				rhs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.GmSc){
				GMSCUPSort gs=new GMSCUPSort();
				gs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.shotEfficient){
				ThrowRateUPSort trs=new ThrowRateUPSort();
				trs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.reboundEfficient){
				RebRateUPSort rrs=new RebRateUPSort();
				rrs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.offendReboundEfficient){
				AttRebRateUPSort ars=new AttRebRateUPSort();
				ars.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.defendReboundEfficient){
				DefRebRateUPSort drs=new DefRebRateUPSort();
				drs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.assistEfficient){
				AssistRateUPSort ans=new AssistRateUPSort();
				ans.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.blockShotEfficient){
				BlockRateUPSort brs=new BlockRateUPSort();
				brs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.faultEfficient){
				ErrorRateUPSort ers=new ErrorRateUPSort();
				ers.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.frequency){
				UsedRateUPSort urs=new UsedRateUPSort();
				urs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.name){
				NameHUPSort nhs=new NameHUPSort();
				nhs.mulSort(list, beg, end);
			}
		}else{
			if(ps==PlayerStandard.realShot){
				RealHitRateDSort rhs=new RealHitRateDSort();
				rhs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.GmSc){
				GMSCDSort gs=new GMSCDSort();
				gs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.shotEfficient){
				ThrowRateDSort trs=new ThrowRateDSort();
				trs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.reboundEfficient){
				RebRateDSort rrs=new RebRateDSort();
				rrs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.offendReboundEfficient){
				AttRebRateDSort ars=new AttRebRateDSort();
				ars.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.defendReboundEfficient){
				DefRebRateDSort drs=new DefRebRateDSort();
				drs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.assistEfficient){
				AssistRateDSort ans=new AssistRateDSort();
				ans.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.blockShotEfficient){
				BlockRateDSort brs=new BlockRateDSort();
				brs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.faultEfficient){
				ErrorRateDSort ers=new ErrorRateDSort();
				ers.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.frequency){
				UsedRateDSort urs=new UsedRateDSort();
				urs.mulSort(list, beg, end);
			}else if(ps==PlayerStandard.name){
				NameHDSort nds=new NameHDSort();
				nds.mulSort(list, beg, end);
			}
		}
	}
	
	public static void main(String args[]){
		//PlayerNormalInfo pni=new PlayerNormalInfo();
		//pni.setAssist(78);
		//pni.setFoul(8);
		
		MultiSort ms=new MultiSort();
		
		//Object str=ms.getFieldValueByName(PlayerStandard.assist.toString(),pni);
		//System.out.println(str);
		
		/*
		PlayerBLService pbs=new PlayerBLController();
		ArrayList<PlayerNormalInfo> res=pbs.getPlayerTotalNormalInfo(Position.All, League.All, 
				Age.All, PlayerStandard.point, Order.desc, 100);
		
		for(int i=0;i<res.size();i++){
			PlayerNormalInfo pni=res.get(i);
			System.out.println(pni.getName()+" "+pni.getPoint()+" "+pni.getAssist());
		}
		*/
		
		
		ArrayList<PlayerNormalInfo> res=new ArrayList<PlayerNormalInfo>();
		
		for(int i=0;i<30;i++){
			PlayerNormalInfo pni=new PlayerNormalInfo();
			pni.setName(String.valueOf(i));
			pni.setPoint(10+i);
			pni.setAssist(10+i*i);
			res.add(pni);
		}
		
		for(int i=3;i<18;i++){
			PlayerNormalInfo pni=res.get(i);
			pni.setPoint(1999);
			pni.setAssist(1000-100*Math.random());
		}
		
		for(int i=13;i<23;i++){
			PlayerNormalInfo pni=res.get(i);
			pni.setPoint(299);
			pni.setAssist(1000-100*Math.random());
		}
		
		for(int i=0;i<res.size();i++){
			PlayerNormalInfo pni=res.get(i);
			System.out.println(pni.getName()+" "+pni.getPoint()+" "+pni.getAssist());
		}
		
		System.out.println();
		
		SortNormalInfo sni=new SortNormalInfo();
		sni.sort(res, Order.desc, PlayerStandard.point);
		for(int i=0;i<res.size();i++){
			PlayerNormalInfo pni=res.get(i);
			System.out.println(pni.getName()+" "+pni.getPoint()+" "+pni.getAssist());
		}
		
		
		ms.mulNormalSort(res, PlayerStandard.point,PlayerStandard.assist, Order.desc);
		System.out.println();
		for(int i=0;i<res.size();i++){
			PlayerNormalInfo pni=res.get(i);
			System.out.println(pni.getName()+" "+pni.getPoint()+" "+pni.getAssist());
		}
		
		/*
		ArrayList<PlayerHighInfo> res=new ArrayList<PlayerHighInfo>();
		
		for(int i=0;i<30;i++){
			PlayerHighInfo pni=new PlayerHighInfo();
			pni.setName(String.valueOf(i));
			pni.setAssistEfficient(10+i);
			pni.setFaultEfficient(10+i*i);
			res.add(pni);
		}
		
		for(int i=3;i<18;i++){
			PlayerHighInfo pni=res.get(i);
			pni.setAssistEfficient(1999);
			pni.setFaultEfficient(1000-100*Math.random());
		}
		
		for(int i=13;i<23;i++){
			PlayerHighInfo pni=res.get(i);
			pni.setAssistEfficient(299);
			pni.setFaultEfficient(1000-100*Math.random());
		}
		
		for(int i=0;i<res.size();i++){
			PlayerHighInfo pni=res.get(i);
			System.out.println(pni.getName()+" "+pni.getAssistEfficient()+" "+pni.getFaultEfficient());
		}
		
		System.out.println();
		
		SortHighInfo sni=new SortHighInfo();
		sni.sort(res, Order.desc, PlayerStandard.assistEfficient);
		for(int i=0;i<res.size();i++){
			PlayerHighInfo pni=res.get(i);
			System.out.println(pni.getName()+" "+pni.getAssistEfficient()+" "+pni.getFaultEfficient());
		}
		
		
		ms.mulHighSort(res, PlayerStandard.assistEfficient,PlayerStandard.faultEfficient, Order.desc);
		System.out.println();
		for(int i=0;i<res.size();i++){
			PlayerHighInfo pni=res.get(i);
			System.out.println(pni.getName()+" "+pni.getAssistEfficient()+" "+pni.getFaultEfficient());
		}
		*/
	}
	
}
