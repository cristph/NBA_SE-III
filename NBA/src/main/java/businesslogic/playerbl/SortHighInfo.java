package businesslogic.playerbl;

import java.util.ArrayList;

import test.data.PlayerHighInfo;
import value.PlayerStandard;
import value.Value.Order;

public class SortHighInfo {
	
	public void sort(ArrayList<PlayerHighInfo> list,Order order, PlayerStandard ps){
		if(order==Order.asc){
			if(ps==PlayerStandard.realHitRate){
				RealHitRateUPSort rhs=new RealHitRateUPSort();
				rhs.quicksort(list);
			}else if(ps==PlayerStandard.GMSC){
				GMSCUPSort gs=new GMSCUPSort();
				gs.quicksort(list);
			}else if(ps==PlayerStandard.throwRate){
				ThrowRateUPSort trs=new ThrowRateUPSort();
				trs.quicksort(list);
			}else if(ps==PlayerStandard.rebRate){
				RebRateUPSort rrs=new RebRateUPSort();
				rrs.quicksort(list);
			}else if(ps==PlayerStandard.attRebRate){
				AttRebRateUPSort ars=new AttRebRateUPSort();
				ars.quicksort(list);
			}else if(ps==PlayerStandard.defRebRate){
				DefRebRateUPSort drs=new DefRebRateUPSort();
				drs.quicksort(list);
			}else if(ps==PlayerStandard.assistRate){
				AssistRateUPSort ans=new AssistRateUPSort();
				ans.quicksort(list);
			}else if(ps==PlayerStandard.blockRate){
				BlockRateUPSort brs=new BlockRateUPSort();
				brs.quicksort(list);
			}else if(ps==PlayerStandard.errorRate){
				ErrorRateUPSort ers=new ErrorRateUPSort();
				ers.quicksort(list);
			}else if(ps==PlayerStandard.usedRate){
				UsedRateUPSort urs=new UsedRateUPSort();
				urs.quicksort(list);
			}
		}else{
			if(ps==PlayerStandard.realHitRate){
				RealHitRateDSort rhs=new RealHitRateDSort();
				rhs.quicksort(list);
			}else if(ps==PlayerStandard.GMSC){
				GMSCDSort gs=new GMSCDSort();
				gs.quicksort(list);
			}else if(ps==PlayerStandard.throwRate){
				ThrowRateDSort trs=new ThrowRateDSort();
				trs.quicksort(list);
			}else if(ps==PlayerStandard.rebRate){
				RebRateDSort rrs=new RebRateDSort();
				rrs.quicksort(list);
			}else if(ps==PlayerStandard.attRebRate){
				AttRebRateDSort ars=new AttRebRateDSort();
				ars.quicksort(list);
			}else if(ps==PlayerStandard.defRebRate){
				DefRebRateDSort drs=new DefRebRateDSort();
				drs.quicksort(list);
			}else if(ps==PlayerStandard.assistRate){
				AssistRateDSort ans=new AssistRateDSort();
				ans.quicksort(list);
			}else if(ps==PlayerStandard.blockRate){
				BlockRateDSort brs=new BlockRateDSort();
				brs.quicksort(list);
			}else if(ps==PlayerStandard.errorRate){
				ErrorRateDSort ers=new ErrorRateDSort();
				ers.quicksort(list);
			}else if(ps==PlayerStandard.usedRate){
				UsedRateDSort urs=new UsedRateDSort();
				urs.quicksort(list);
			}
		}
	}
}
