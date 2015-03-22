package businesslogic.teambl;

import java.util.ArrayList;

import value.TeamStandard;
import value.Value.Order;
import vo.TeamVO;

public class teamsearch {
	public ArrayList<String> sort(ArrayList<TeamVO> v,Order order,TeamStandard stan){
		if(order==Order.UP){
			if(stan==TeamStandard.allpoint){
				upSortforallpoint.quicksort(v); //s=new upSortforallpoint();
				//s.quicksort(v);
			}
			else if(stan==TeamStandard.allpointave){
				upSortforallpointave.quicksort(v); //s=new upSortforallpointave();
				//s.quicksort(v);
			}
			else if(stan==TeamStandard.assistNum){
				upSortforassistnum.quicksort(v); //s=new upSortforassistnum();
				//s.quicksort(v);
			}
            else if(stan==TeamStandard.assistNumave){
            	upSortforassistnumave.quicksort(v); //s=new upSortforallpoint();
				//s.quicksort(v);
			}
            else if(stan==TeamStandard.assistrate){
            	upSortforassistrate.quicksort(v);
			}
            else if(stan==TeamStandard.attackround){
            	upSortforattackround.quicksort(v);
			}
            else if(stan==TeamStandard.attackrate){
            	upSortforattrate.quicksort(v);
			}
            else if(stan==TeamStandard.blockNum){
            	upSortforblocknum.quicksort(v);
			}
            else if(stan==TeamStandard.blockNumave){
            	upSortforblocknumave.quicksort(v);
			}
            else if(stan==TeamStandard.defendrate){
            	upSortfordefrate.quicksort(v);
			}
            else if(stan==TeamStandard.errorNum){
            	upSortforerrornum.quicksort(v);
			}
            else if(stan==TeamStandard.errorNumave){
            	upSortforerrornumave.quicksort(v);
			}
            else if(stan==TeamStandard.foulNum){
            	upSortforfoulnum.quicksort(v);
			}
            else if(stan==TeamStandard.foulNumave){
            	upSortforfoulnumave.quicksort(v);
			}
            else if(stan==TeamStandard.freeHitNum){
            	upSortforfreehitnum.quicksort(v);
			}
            else if(stan==TeamStandard.freeHitNumave){
            	upSortforfreehitnumave.quicksort(v);
			}
            else if(stan==TeamStandard.freehitrate){
            	upSortforfreehitrate.quicksort(v);
			}
            else if(stan==TeamStandard.freeNum){
            	upSortforfreenum.quicksort(v);
			}
            else if(stan==TeamStandard.freeNumave){
            	upSortforfreenumave.quicksort(v);
			}
            else if(stan==TeamStandard.hitShootNum){
            	upSortforhitshootnum.quicksort(v);
			}
            else if(stan==TeamStandard.hitShootNumave){
            	upSortforhitshootnumave.quicksort(v);
			}
            else if(stan==TeamStandard.rebAttNum){
            	upSortforrebattnum.quicksort(v);
			}
            else if(stan==TeamStandard.rebAttNumave){
            	upSortforrebattnumave.quicksort(v);
			}
            else if(stan==TeamStandard.rebattrate){
            	upSortforrebattrate.quicksort(v);
			}
            else if(stan==TeamStandard.rebDefNum){
            	upSortforrebdefnum.quicksort(v);
			}
            else if(stan==TeamStandard.rebDefNumave){
            	upSortforrebdefnumave.quicksort(v);
			}
            else if(stan==TeamStandard.rebdefrate){
            	upSortforrebdefrate.quicksort(v);
			}
            else if(stan==TeamStandard.rebTotalNum){
            	upSortforrebtotalnum.quicksort(v);
			}
            else if(stan==TeamStandard.rebTotalNumave){
            	upSortforrebtotalnumave.quicksort(v);
			}
            else if(stan==TeamStandard.shootNum){
            	upSortforshootnum.quicksort(v);
			}
            else if(stan==TeamStandard.shootNumave){
            	upSortforshootnumave.quicksort(v);
			}
            else if(stan==TeamStandard.shootrate){
            	upSortforshootrate.quicksort(v);
			}
            else if(stan==TeamStandard.stealNum){
            	upSortforstealnum.quicksort(v);
			}
            else if(stan==TeamStandard.stealNumave){
            	upSortforstealnumave.quicksort(v);
			}
            else if(stan==TeamStandard.stealrate){
            	upSortforstealrate.quicksort(v);
			}
            else if(stan==TeamStandard.threePointNum){
            	upSortforthreepointrate.quicksort(v);
			}
            else if(stan==TeamStandard.threePointNumave){
            	upSortforthreepointnumave.quicksort(v);
			}
            else if(stan==TeamStandard.threepointrate){
            	upSortforthreepointrate.quicksort(v);
			}
            else if(stan==TeamStandard.threeShootNum){
            	upSortforthreeshootnum.quicksort(v);
			}
            else if(stan==TeamStandard.threeShootNumave){
            	upSortforthreeshootnumave.quicksort(v);
			}
            else if(stan==TeamStandard.winrate){
            	upSortforwinrate.quicksort(v);
			}
			
		}
		else if(order==Order.DOWN){
			if(stan==TeamStandard.allpoint){
				downSortforallpoint.quicksort(v); //s=new upSortforallpoint();
				//s.quicksort(v);
			}
			else if(stan==TeamStandard.allpointave){
				downSortforallpointave.quicksort(v); //s=new upSortforallpointave();
				//s.quicksort(v);
			}
			else if(stan==TeamStandard.assistNum){
				downSortforassistnum.quicksort(v); //s=new upSortforassistnum();
				//s.quicksort(v);
			}
            else if(stan==TeamStandard.assistNumave){
            	downSortforassistnumave.quicksort(v); //s=new upSortforallpoint();
				//s.quicksort(v);
			}
            else if(stan==TeamStandard.assistrate){
            	downSortforassistrate.quicksort(v);
			}
            else if(stan==TeamStandard.attackround){
            	downSortforattackround.quicksort(v);
			}
            else if(stan==TeamStandard.attackrate){
            	downSortforattrate.quicksort(v);
			}
            else if(stan==TeamStandard.blockNum){
            	downSortforblocknum.quicksort(v);
			}
            else if(stan==TeamStandard.blockNumave){
            	downSortforblocknumave.quicksort(v);
			}
            else if(stan==TeamStandard.defendrate){
            	downSortfordefrate.quicksort(v);
			}
            else if(stan==TeamStandard.errorNum){
            	downSortforerrornum.quicksort(v);
			}
            else if(stan==TeamStandard.errorNumave){
            	downSortforerrornumave.quicksort(v);
			}
            else if(stan==TeamStandard.foulNum){
            	downSortforfoulnum.quicksort(v);
			}
            else if(stan==TeamStandard.foulNumave){
            	downSortforfoulnumave.quicksort(v);
			}
            else if(stan==TeamStandard.freeHitNum){
            	downSortforfreehitnum.quicksort(v);
			}
            else if(stan==TeamStandard.freeHitNumave){
            	downSortforfreehitnumave.quicksort(v);
			}
            else if(stan==TeamStandard.freehitrate){
            	downSortforfreehitrate.quicksort(v);
			}
            else if(stan==TeamStandard.freeNum){
            	downSortforfreenum.quicksort(v);
			}
            else if(stan==TeamStandard.freeNumave){
            	downSortforfreenumave.quicksort(v);
			}
            else if(stan==TeamStandard.hitShootNum){
            	downSortforhitshootnum.quicksort(v);
			}
            else if(stan==TeamStandard.hitShootNumave){
            	downSortforhitshootnumave.quicksort(v);
			}
            else if(stan==TeamStandard.rebAttNum){
            	downSortforrebattnum.quicksort(v);
			}
            else if(stan==TeamStandard.rebAttNumave){
            	downSortforrebattnumave.quicksort(v);
			}
            else if(stan==TeamStandard.rebattrate){
            	downSortforrebattrate.quicksort(v);
			}
            else if(stan==TeamStandard.rebDefNum){
            	downSortforrebdefnum.quicksort(v);
			}
            else if(stan==TeamStandard.rebDefNumave){
            	downSortforrebdefnumave.quicksort(v);
			}
            else if(stan==TeamStandard.rebdefrate){
            	downSortforrebdefrate.quicksort(v);
			}
            else if(stan==TeamStandard.rebTotalNum){
            	downSortforrebtotalnum.quicksort(v);
			}
            else if(stan==TeamStandard.rebTotalNumave){
            	downSortforrebtotalnumave.quicksort(v);
			}
            else if(stan==TeamStandard.shootNum){
            	downSortforshootnum.quicksort(v);
			}
            else if(stan==TeamStandard.shootNumave){
            	downSortforshootnumave.quicksort(v);
			}
            else if(stan==TeamStandard.shootrate){
            	downSortforshootrate.quicksort(v);
			}
            else if(stan==TeamStandard.stealNum){
            	downSortforstealnum.quicksort(v);
			}
            else if(stan==TeamStandard.stealNumave){
            	downSortforstealnumave.quicksort(v);
			}
            else if(stan==TeamStandard.stealrate){
            	downSortforstealrate.quicksort(v);
			}
            else if(stan==TeamStandard.threePointNum){
            	downSortforthreepointrate.quicksort(v);
			}
            else if(stan==TeamStandard.threePointNumave){
            	downSortforthreepointnumave.quicksort(v);
			}
            else if(stan==TeamStandard.threepointrate){
            	downSortforthreepointrate.quicksort(v);
			}
            else if(stan==TeamStandard.threeShootNum){
            	downSortforthreeshootnum.quicksort(v);
			}
            else if(stan==TeamStandard.threeShootNumave){
            	downSortforthreeshootnumave.quicksort(v);
			}
            else if(stan==TeamStandard.winrate){
            	downSortforwinrate.quicksort(v);
			}
			
		}
		ArrayList<String> result=new ArrayList<String>();
		for(int i=0;i<v.size();i++){
			result.add(v.get(i).getShortName());
		}
		return result;
	}

}
