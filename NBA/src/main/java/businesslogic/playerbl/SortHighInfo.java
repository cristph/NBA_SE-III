package businesslogic.playerbl;

import java.util.ArrayList;

import test.data.PlayerHighInfo;
import value.PlayerStandard;
import value.Value.Order;

public class SortHighInfo {
	
	public void sort(ArrayList<PlayerHighInfo> list,Order order, PlayerStandard ps){
		if(order==Order.asc){
			if(ps==PlayerStandard.realShot){
				RealHitRateUPSort rhs=new RealHitRateUPSort();
				rhs.quicksort(list);
			}else if(ps==PlayerStandard.GmSc){
				GMSCUPSort gs=new GMSCUPSort();
				gs.quicksort(list);
			}else if(ps==PlayerStandard.shotEfficient){
				ThrowRateUPSort trs=new ThrowRateUPSort();
				trs.quicksort(list);
			}else if(ps==PlayerStandard.reboundEfficient){
				RebRateUPSort rrs=new RebRateUPSort();
				rrs.quicksort(list);
			}else if(ps==PlayerStandard.offendReboundEfficient){
				AttRebRateUPSort ars=new AttRebRateUPSort();
				ars.quicksort(list);
			}else if(ps==PlayerStandard.defendReboundEfficient){
				DefRebRateUPSort drs=new DefRebRateUPSort();
				drs.quicksort(list);
			}else if(ps==PlayerStandard.assistEfficient){
				AssistRateUPSort ans=new AssistRateUPSort();
				ans.quicksort(list);
			}else if(ps==PlayerStandard.blockShotEfficient){
				BlockRateUPSort brs=new BlockRateUPSort();
				brs.quicksort(list);
			}else if(ps==PlayerStandard.faultEfficient){
				ErrorRateUPSort ers=new ErrorRateUPSort();
				ers.quicksort(list);
			}else if(ps==PlayerStandard.frequency){
				UsedRateUPSort urs=new UsedRateUPSort();
				urs.quicksort(list);
			}
		}else{
			if(ps==PlayerStandard.realShot){
				RealHitRateDSort rhs=new RealHitRateDSort();
				rhs.quicksort(list);
			}else if(ps==PlayerStandard.GmSc){
				GMSCDSort gs=new GMSCDSort();
				gs.quicksort(list);
			}else if(ps==PlayerStandard.shotEfficient){
				ThrowRateDSort trs=new ThrowRateDSort();
				trs.quicksort(list);
			}else if(ps==PlayerStandard.reboundEfficient){
				RebRateDSort rrs=new RebRateDSort();
				rrs.quicksort(list);
			}else if(ps==PlayerStandard.offendReboundEfficient){
				AttRebRateDSort ars=new AttRebRateDSort();
				ars.quicksort(list);
			}else if(ps==PlayerStandard.defendReboundEfficient){
				DefRebRateDSort drs=new DefRebRateDSort();
				drs.quicksort(list);
			}else if(ps==PlayerStandard.assistEfficient){
				AssistRateDSort ans=new AssistRateDSort();
				ans.quicksort(list);
			}else if(ps==PlayerStandard.blockShotEfficient){
				BlockRateDSort brs=new BlockRateDSort();
				brs.quicksort(list);
			}else if(ps==PlayerStandard.faultEfficient){
				ErrorRateDSort ers=new ErrorRateDSort();
				ers.quicksort(list);
			}else if(ps==PlayerStandard.frequency){
				UsedRateDSort urs=new UsedRateDSort();
				urs.quicksort(list);
			}
		}
	}
}
