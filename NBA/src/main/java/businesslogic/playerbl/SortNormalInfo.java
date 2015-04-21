package businesslogic.playerbl;

import java.util.ArrayList;

import test.data.PlayerNormalInfo;
import value.PlayerStandard;
import value.Value.Order;

public class SortNormalInfo {
	
	public void sort(ArrayList<PlayerNormalInfo> list,Order order, PlayerStandard ps){
		if(order==Order.asc){
			if(ps==PlayerStandard.score){
				ScoreUPSort sus=new ScoreUPSort();
				sus.quicksort(list);
			}else if(ps==PlayerStandard.rebTotalNum){
				RebTotalNumUPSort nts=new RebTotalNumUPSort();
				nts.quicksort(list);
			}else if(ps==PlayerStandard.assistNum){
				AssistNumUPSort ans=new AssistNumUPSort();
				ans.quicksort(list);
			}else if(ps==PlayerStandard.stealNum){
				StealNumUPSort sns=new StealNumUPSort();
				sns.quicksort(list);
			}else if(ps==PlayerStandard.blockNum){
				BlockNumUPSort bns=new BlockNumUPSort();
				bns.quicksort(list);
			}else if(ps==PlayerStandard.foulNum){
				FoulNumUPSort fns=new FoulNumUPSort();
				fns.quicksort(list);
			}else if(ps==PlayerStandard.errorNum){
				ErrorNumUPSort ens=new ErrorNumUPSort();
				ens.quicksort(list);
			}else if(ps==PlayerStandard.time){
				TimeUPSort tus=new TimeUPSort();
				tus.quicksort(list);
			}else if(ps==PlayerStandard.rate){
				RateUPSort rus=new RateUPSort();
				rus.quicksort(list);
			}else if(ps==PlayerStandard.shooting){
				ShootingUPSort sus=new ShootingUPSort();
				sus.quicksort(list);
			}else if(ps==PlayerStandard.threeRate){
				ThreeRateUPSort trs=new ThreeRateUPSort();
				trs.quicksort(list);
			}else if(ps==PlayerStandard.freeRate){
				FreeRateUPSort frs=new FreeRateUPSort();
				frs.quicksort(list);
			}
		}else{
			if(ps==PlayerStandard.score){
				ScoreDSort sus=new ScoreDSort();
				sus.quicksort(list);
			}else if(ps==PlayerStandard.rebTotalNum){
				RebTotalNumDSort nts=new RebTotalNumDSort();
				nts.quicksort(list);
			}else if(ps==PlayerStandard.assistNum){
				AssistNumDSort ans=new AssistNumDSort();
				ans.quicksort(list);
			}else if(ps==PlayerStandard.stealNum){
				StealNumDSort sns=new StealNumDSort();
				sns.quicksort(list);
			}else if(ps==PlayerStandard.blockNum){
				BlockNumDSort bns=new BlockNumDSort();
				bns.quicksort(list);
			}else if(ps==PlayerStandard.foulNum){
				FoulNumDSort fns=new FoulNumDSort();
				fns.quicksort(list);
			}else if(ps==PlayerStandard.errorNum){
				ErrorNumDSort ens=new ErrorNumDSort();
				ens.quicksort(list);
			}else if(ps==PlayerStandard.time){
				TimeDSort tus=new TimeDSort();
				tus.quicksort(list);
			}else if(ps==PlayerStandard.rate){
				RateDSort rus=new RateDSort();
				rus.quicksort(list);
			}else if(ps==PlayerStandard.shooting){
				ShootingDSort sus=new ShootingDSort();
				sus.quicksort(list);
			}else if(ps==PlayerStandard.threeRate){
				ThreeRateDSort trs=new ThreeRateDSort();
				trs.quicksort(list);
			}else if(ps==PlayerStandard.freeRate){
				FreeRateDSort frs=new FreeRateDSort();
				frs.quicksort(list);
			}
		}
	}
}
