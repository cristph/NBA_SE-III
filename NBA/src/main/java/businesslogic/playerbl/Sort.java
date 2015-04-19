package businesslogic.playerbl;

import java.util.ArrayList;

import value.PlayerStandard;
import value.Value.Order;
import vo.PlayerInfoVO;


public class Sort {
	
	public void sort(ArrayList<PlayerInfoVO> list,Order order, PlayerStandard ps){
		if(order==Order.asc){
			if(ps==PlayerStandard.assistNum){
				AssistNumUPSort ans=new AssistNumUPSort();
				ans.quicksort(list);
			}else if(ps==PlayerStandard.assistRate){
				AssistRateUPSort ans=new AssistRateUPSort();
				ans.quicksort(list);
			}else if(ps==PlayerStandard.attRebRate){
				AttRebRateUPSort ars=new AttRebRateUPSort();
				ars.quicksort(list);
			}else if(ps==PlayerStandard.blockNum){
				BlockNumUPSort bns=new BlockNumUPSort();
				bns.quicksort(list);
			}else if(ps==PlayerStandard.blockRate){
				BlockRateUPSort brs=new BlockRateUPSort();
				brs.quicksort(list);
			}else if(ps==PlayerStandard.defRebRate){
				DefRebRateUPSort drs=new DefRebRateUPSort();
				drs.quicksort(list);
			}else if(ps==PlayerStandard.errorNum){
				ErrorNumUPSort ens=new ErrorNumUPSort();
				ens.quicksort(list);
			}else if(ps==PlayerStandard.errorRate){
				ErrorRateUPSort ers=new ErrorRateUPSort();
				ers.quicksort(list);
			}else if(ps==PlayerStandard.firstTime){
				FirstTimeUPSort fts=new FirstTimeUPSort();
				fts.quicksort(list);
			}else if(ps==PlayerStandard.foulNum){
				FoulNumUPSort fns=new FoulNumUPSort();
				fns.quicksort(list);
			}else if(ps==PlayerStandard.freeRate){
				FreeRateUPSort frs=new FreeRateUPSort();
				frs.quicksort(list);
			}else if(ps==PlayerStandard.GMSC){
				GMSCUPSort gs=new GMSCUPSort();
				gs.quicksort(list);
			}else if(ps==PlayerStandard.inTime){
				InTimeUPSort its=new InTimeUPSort();
				its.quicksort(list);
			}else if(ps==PlayerStandard.name){
				NameUPSort nus=new NameUPSort();
				nus.quicksort(list);
			}else if(ps==PlayerStandard.rate){
				RateUPSort rus=new RateUPSort();
				rus.quicksort(list);
			}else if(ps==PlayerStandard.realHitRate){
				RealHitRateUPSort rhs=new RealHitRateUPSort();
				rhs.quicksort(list);
			}else if(ps==PlayerStandard.rebAttNum){
				RebAttNumUPSort rns=new RebAttNumUPSort();
				rns.quicksort(list);
			}else if(ps==PlayerStandard.rebDefNum){
				RebDefNumUPSort rds=new RebDefNumUPSort();
				rds.quicksort(list);
			}else if(ps==PlayerStandard.rebRate){
				RebRateUPSort rrs=new RebRateUPSort();
				rrs.quicksort(list);
			}else if(ps==PlayerStandard.rebTotalNum){
				RebTotalNumUPSort rts=new RebTotalNumUPSort();
				rts.quicksort(list);
			}else if(ps==PlayerStandard.score){
				ScoreUPSort sus=new ScoreUPSort();
				sus.quicksort(list);
			}else if(ps==PlayerStandard.shooting){
				ShootingUPSort sus=new ShootingUPSort();
				sus.quicksort(list);
			}else if(ps==PlayerStandard.stealNum){
				StealNumUPSort sns=new StealNumUPSort();
				sns.quicksort(list);
			}else if(ps==PlayerStandard.stealRate){
				StealRateUPSort srs=new StealRateUPSort();
				srs.quicksort(list);
			}else if(ps==PlayerStandard.team){
				TeamUPSort tus=new TeamUPSort();
				tus.quicksort(list);
			}else if(ps==PlayerStandard.threeRate){
				ThreeRateUPSort trs=new ThreeRateUPSort();
				trs.quicksort(list);
			}else if(ps==PlayerStandard.throwRate){
				ThrowRateUPSort trs=new ThrowRateUPSort();
				trs.quicksort(list);
			}else if(ps==PlayerStandard.time){
				TimeUPSort tus=new TimeUPSort();
				tus.quicksort(list);
			}else if(ps==PlayerStandard.usedRate){
				UsedRateUPSort urs=new UsedRateUPSort();
				urs.quicksort(list);
			}else if(ps==PlayerStandard.doub){
				DoubUPSort dus=new DoubUPSort();
				dus.quicksort(list);
			}else if(ps==PlayerStandard.par){
				ParUPSort pus=new ParUPSort();
				pus.quicksort(list);
			}
		}else{
			if(ps==PlayerStandard.assistNum){
				AssistNumDSort ans=new AssistNumDSort();
				ans.quicksort(list);
			}else if(ps==PlayerStandard.assistRate){
				AssistRateDSort ans=new AssistRateDSort();
				ans.quicksort(list);
			}else if(ps==PlayerStandard.attRebRate){
				AttRebRateDSort ars=new AttRebRateDSort();
				ars.quicksort(list);
			}else if(ps==PlayerStandard.blockNum){
				BlockNumDSort bns=new BlockNumDSort();
				bns.quicksort(list);
			}else if(ps==PlayerStandard.blockRate){
				BlockRateDSort brs=new BlockRateDSort();
				brs.quicksort(list);
			}else if(ps==PlayerStandard.defRebRate){
				DefRebRateDSort drs=new DefRebRateDSort();
				drs.quicksort(list);
			}else if(ps==PlayerStandard.errorNum){
				ErrorNumDSort ens=new ErrorNumDSort();
				ens.quicksort(list);
			}else if(ps==PlayerStandard.errorRate){
				ErrorRateDSort ers=new ErrorRateDSort();
				ers.quicksort(list);
			}else if(ps==PlayerStandard.firstTime){
				FirstTimeDSort fts=new FirstTimeDSort();
				fts.quicksort(list);
			}else if(ps==PlayerStandard.foulNum){
				FoulNumDSort fns=new FoulNumDSort();
				fns.quicksort(list);
			}else if(ps==PlayerStandard.freeRate){
				FreeRateDSort frs=new FreeRateDSort();
				frs.quicksort(list);
			}else if(ps==PlayerStandard.GMSC){
				GMSCDSort gs=new GMSCDSort();
				gs.quicksort(list);
			}else if(ps==PlayerStandard.inTime){
				InTimeDSort its=new InTimeDSort();
				its.quicksort(list);
			}else if(ps==PlayerStandard.name){
				NameDSort nus=new NameDSort();
				nus.quicksort(list);
			}else if(ps==PlayerStandard.rate){
				RateDSort rus=new RateDSort();
				rus.quicksort(list);
			}else if(ps==PlayerStandard.realHitRate){
				RealHitRateDSort rhs=new RealHitRateDSort();
				rhs.quicksort(list);
			}else if(ps==PlayerStandard.rebAttNum){
				RebAttNumDSort rns=new RebAttNumDSort();
				rns.quicksort(list);
			}else if(ps==PlayerStandard.rebDefNum){
				RebDefNumDSort rds=new RebDefNumDSort();
				rds.quicksort(list);
			}else if(ps==PlayerStandard.rebRate){
				RebRateDSort rrs=new RebRateDSort();
				rrs.quicksort(list);
			}else if(ps==PlayerStandard.rebTotalNum){
				RebTotalNumDSort rts=new RebTotalNumDSort();
				rts.quicksort(list);
			}else if(ps==PlayerStandard.score){
				ScoreDSort sus=new ScoreDSort();
				sus.quicksort(list);
			}else if(ps==PlayerStandard.shooting){
				ShootingDSort sus=new ShootingDSort();
				sus.quicksort(list);
			}else if(ps==PlayerStandard.stealNum){
				StealNumDSort sns=new StealNumDSort();
				sns.quicksort(list);
			}else if(ps==PlayerStandard.stealRate){
				StealRateDSort srs=new StealRateDSort();
				srs.quicksort(list);
			}else if(ps==PlayerStandard.team){
				TeamDSort tus=new TeamDSort();
				tus.quicksort(list);
			}else if(ps==PlayerStandard.threeRate){
				ThreeRateDSort trs=new ThreeRateDSort();
				trs.quicksort(list);
			}else if(ps==PlayerStandard.throwRate){
				ThrowRateDSort trs=new ThrowRateDSort();
				trs.quicksort(list);
			}else if(ps==PlayerStandard.time){
				TimeDSort tus=new TimeDSort();
				tus.quicksort(list);
			}else if(ps==PlayerStandard.usedRate){
				UsedRateDSort urs=new UsedRateDSort();
				urs.quicksort(list);
			}else if(ps==PlayerStandard.doub){
				DoubDSort dus=new DoubDSort();
				dus.quicksort(list);
			}else if(ps==PlayerStandard.par){
				ParDSort pus=new ParDSort();
				pus.quicksort(list);
			}
		}
	}
}
