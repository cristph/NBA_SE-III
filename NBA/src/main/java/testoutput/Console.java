package testoutput;

import java.io.PrintStream;
import java.util.ArrayList;

import businesslogic.playerbl.PlayerBLController;
import businesslogicservice.playerblservice.PlayerBLService;
import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;
import value.PlayerStandard;
import value.Value.Age;
import value.Value.Field;
import value.Value.League;
import value.Value.Model;
import value.Value.Order;
import value.Value.Position;
import de.tototec.cmdoption.CmdOption;
import de.tototec.cmdoption.CmdlineParser;

public class Console {
	
	public void execute(PrintStream out,String[] args){
		
		Config config = new Config();
		CmdlineParser parser = new CmdlineParser(config);
		parser.parse(args);
		
		PlayerBLService pbs=new PlayerBLController();
		
		if(config.chosen==Model.PLAYER){//player
			
			if(config.hotField != null){ // -hot
				String field=config.hotField;
				int num=config.n;
				if(num<0){
					num=5;}
				ArrayList<PlayerHotInfo> list=null;
				
				if(field.equals(Field.score)){
					list=pbs.getHotPlayer(Field.score, num);
					for(int i=0;i<list.size();i++){
						out.println(list.get(i).toString());
					}
					
				}else if(field.equals(Field.rebound)){
					list=pbs.getHotPlayer(Field.rebound, num);
					for(int i=0;i<list.size();i++){
						out.println(list.get(i).toString());
					}
					
				}else if(field.equals(Field.assist)){
					list=pbs.getHotPlayer(Field.assist, num);
					for(int i=0;i<list.size();i++){
						out.println(list.get(i).toString());
					}
					
				}
				
			}else if(config.kingField != null) { // -king
				
				String field=config.kingField;
				int num=config.n;
				if(num<0){
					num=5;}
				ArrayList<PlayerKingInfo> list=null;
				
				if(config.isDaily){ // -daily
					if(field.equals(Field.score)){
						list=pbs.getDailyKingPlayer(Field.score, num);
						for(int i=0;i<list.size();i++){
							out.println(list.get(i).toString());
						}
						
					}else if(field.equals(Field.rebound)){
						list=pbs.getDailyKingPlayer(Field.rebound, num);
						for(int i=0;i<list.size();i++){
							out.println(list.get(i).toString());
						}
						
					}else if(field.equals(Field.assist)){
						list=pbs.getDailyKingPlayer(Field.assist, num);
						for(int i=0;i<list.size();i++){
							out.println(list.get(i).toString());
						}
						
					}
					
				}else{ // -season
					
					if(field.equals(Field.score)){
						list=pbs.getSeasonKingPlayer(Field.score, num);
						for(int i=0;i<list.size();i++){
							out.println(list.get(i).toString());
						}
						
					}else if(field.equals(Field.rebound)){
						list=pbs.getSeasonKingPlayer(Field.rebound, num);
						for(int i=0;i<list.size();i++){
							out.println(list.get(i).toString());
						}
						
					}else if(field.equals(Field.assist)){
						list=pbs.getSeasonKingPlayer(Field.assist, num);
						for(int i=0;i<list.size();i++){
							out.println(list.get(i).toString());
						}
						
					}
					
					
				}
			}else if(config.isHigh) { // -high
				
				if(config.sortField == null){
					//config.sortField = "realShot.desc";
					int num=config.n;
					if(num<0){
						num=50;}
					ArrayList<PlayerHighInfo> list=pbs.getPlayerHighInfo(PlayerStandard.realShot, Order.desc, num);
					for(int i=0;i<list.size();i++){
						out.println(list.get(i).toString());
					}
					
				}else{
					int num=config.n;
					if(num<0){
						num=50;}
					ArrayList<PlayerHighInfo> list=null;
					
					String fields[]=config.sortField.split(",");
					PlayerStandard []ps=new PlayerStandard[fields.length];
					Order []order=new Order[fields.length];
					
					for(int i=0;i<fields.length;i++){
						String temp[]=fields[i].split("\\.");
						if(temp[0].equals("realShot")){
							ps[i]=PlayerStandard.realShot;
						}else if(temp[0].equals("GmSc")){
							ps[i]=PlayerStandard.GmSc;
						}else if(temp[0].equals("shotEfficient")){
							ps[i]=PlayerStandard.shotEfficient;
						}else if(temp[0].equals("reboundEfficient")){
							ps[i]=PlayerStandard.reboundEfficient;
						}else if(temp[0].equals("offendReboundEfficient")){
							ps[i]=PlayerStandard.offendReboundEfficient;
						}else if(temp[0].equals("defendReboundEfficient")){
							ps[i]=PlayerStandard.defendReboundEfficient;
						}else if(temp[0].equals("assistEfficient")){
							ps[i]=PlayerStandard.assistEfficient;
						}else if(temp[0].equals("stealEfficient")){
							ps[i]=PlayerStandard.stealEfficient;
						}else if(temp[0].equals("blockShotEfficient")){
							ps[i]=PlayerStandard.blockShotEfficient;
						}else if(temp[0].equals("faultEfficient")){
							ps[i]=PlayerStandard.faultEfficient;
						}else{
							ps[i]=PlayerStandard.frequency;
						}
						
						if(temp[1].equals("desc")){
							order[i]=Order.desc;
						}else{
							order[i]=Order.asc;
						}
					}
					
					list=pbs.getPlayerHighInfoMOrder(ps, order, num);
					for(int i=0;i<list.size();i++){
						out.println(list.get(i).toString());
					}
				}
				
				
			}else{ // -all
				if(config.isAverage){//-all -avg
					if(config.sortField.isEmpty()){
						//config.sortField = "point.desc";
						int num=config.n;
						if(num<0){
							num=50;
						}
						ArrayList<PlayerNormalInfo> list=pbs.getPlayerAvgNormalInfo(Position.All, League.All, 
								Age.All, PlayerStandard.point, Order.desc, num);
						for(int i=0;i<list.size();i++){
							out.println(list.get(i).toString());
						}
						
					}else{
						int num=config.n;
						if(num<0){
							num=50;
						}
						
						Position pos = null;
						League lea = null;
						Age age = null;
						
						String fields[]=config.sortField.split(",");
						PlayerStandard []ps=new PlayerStandard[fields.length];
						Order []order=new Order[fields.length];
						
						String temp[]=config.filterField.split(",");
						for(int i=0;i<temp.length;i++){
							String str[]=temp[i].split("\\.");
							if(str[0].equals("position")){
								if(str[1].equals("F")){
									pos=Position.F;
								}else if(str[1].equals("C")){
									pos=Position.C;
								}else if(str[1].equals("G")){
									pos=Position.G;
								}else if(str[1].equals("All")){
									pos=Position.All;
								}
							}else if(str[0].equals("league")){
								if(str[1].equals("West")){
									lea=League.West;
								}else if(str[1].equals("East")){
									lea=League.East;
								}else if(str[1].equals("All")){
									lea=League.All;
								}
							}else if(str[0].equals("age")){
								if(str[1].equals("<=22")){
									age=Age.lv1;
								}else if(str[1].equals("22<X<=25")){
									age=Age.lv2;
								}else if(str[1].equals("25<X<=30")){
									age=Age.lv3;
								}else if(str[1].equals(">30")){
									age=Age.lv4;
								}else if(str[1].equals("All")){
									age=Age.All;
								}
							}
						}//end for-deal with filter
						if(pos==null){
							pos=Position.All;
						}
						if(lea==null){
							lea=League.All;
						}
						if(age==null){
							age=Age.All;
						}
						
						for(int i=0;i<fields.length;i++){
							String st[]=fields[i].split("\\.");
							if(st[0].equals("point")){
								ps[i]=PlayerStandard.point;
							}else if(st[0].equals("rebound")){
								ps[i]=PlayerStandard.rebound;
							}else if(st[0].equals("assist")){
								ps[i]=PlayerStandard.assist;
							}else if(st[0].equals("blockShot")){
								ps[i]=PlayerStandard.blockShot;
							}else if(st[0].equals("steal")){
								ps[i]=PlayerStandard.steal;
							}else if(st[0].equals("foul")){
								ps[i]=PlayerStandard.foul;
							}else if(st[0].equals("fault")){
								ps[i]=PlayerStandard.fault;
							}else if(st[0].equals("minute")){
								ps[i]=PlayerStandard.minute;
							}else if(st[0].equals("efficient")){
								ps[i]=PlayerStandard.efficient;
							}else if(st[0].equals("shot")){
								ps[i]=PlayerStandard.shot;
							}else if(st[0].equals("three")){
								ps[i]=PlayerStandard.three;
							}else{
								ps[i]=PlayerStandard.penalty;
							}
							
							if(st[1].equals("desc")){
								order[i]=Order.desc;
							}else{
								order[i]=Order.asc;
							}	
						}//end for-deal with ps,order
						
						ArrayList<PlayerNormalInfo> list=pbs.getPlayerAvgNormalInfoMOrder(pos, lea, age, ps, order, num);
						for(int i=0;i<list.size();i++){
							out.println(list.get(i).toString());
						}
					}
				}else{//-all -total
					if(config.sortField.isEmpty()){
						//config.sortField = "point.desc";	
						int num=config.n;
						if(num<0){
							num=50;
						}
						ArrayList<PlayerNormalInfo> list=pbs.getPlayerTotalNormalInfo(Position.All, League.All, 
								Age.All, PlayerStandard.point, Order.desc, num);
						for(int i=0;i<list.size();i++){
							out.println(list.get(i).toString());
						}
					}else{
						int num=config.n;
						if(num<0){
							num=50;
						}
						
						Position pos = null;
						League lea = null;
						Age age = null;
						
						String fields[]=config.sortField.split(",");
						PlayerStandard []ps=new PlayerStandard[fields.length];
						Order []order=new Order[fields.length];
						
						String temp[]=config.filterField.split(",");
						for(int i=0;i<temp.length;i++){
							String str[]=temp[i].split("\\.");
							if(str[0].equals("position")){
								if(str[1].equals("F")){
									pos=Position.F;
								}else if(str[1].equals("C")){
									pos=Position.C;
								}else if(str[1].equals("G")){
									pos=Position.G;
								}else if(str[1].equals("All")){
									pos=Position.All;
								}
							}else if(str[0].equals("league")){
								if(str[1].equals("West")){
									lea=League.West;
								}else if(str[1].equals("East")){
									lea=League.East;
								}else if(str[1].equals("All")){
									lea=League.All;
								}
							}else if(str[0].equals("age")){
								if(str[1].equals("<=22")){
									age=Age.lv1;
								}else if(str[1].equals("22<X<=25")){
									age=Age.lv2;
								}else if(str[1].equals("25<X<=30")){
									age=Age.lv3;
								}else if(str[1].equals(">30")){
									age=Age.lv4;
								}else if(str[1].equals("All")){
									age=Age.All;
								}
							}
						}//end for-deal with filter
						if(pos==null){
							pos=Position.All;
						}
						if(lea==null){
							lea=League.All;
						}
						if(age==null){
							age=Age.All;
						}
						
						for(int i=0;i<fields.length;i++){
							String st[]=fields[i].split("\\.");
							if(st[0].equals("point")){
								ps[i]=PlayerStandard.point;
							}else if(st[0].equals("rebound")){
								ps[i]=PlayerStandard.rebound;
							}else if(st[0].equals("assist")){
								ps[i]=PlayerStandard.assist;
							}else if(st[0].equals("blockShot")){
								ps[i]=PlayerStandard.blockShot;
							}else if(st[0].equals("steal")){
								ps[i]=PlayerStandard.steal;
							}else if(st[0].equals("foul")){
								ps[i]=PlayerStandard.foul;
							}else if(st[0].equals("fault")){
								ps[i]=PlayerStandard.fault;
							}else if(st[0].equals("minute")){
								ps[i]=PlayerStandard.minute;
							}else if(st[0].equals("efficient")){
								ps[i]=PlayerStandard.efficient;
							}else if(st[0].equals("shot")){
								ps[i]=PlayerStandard.shot;
							}else if(st[0].equals("three")){
								ps[i]=PlayerStandard.three;
							}else{
								ps[i]=PlayerStandard.penalty;
							}
							
							if(st[1].equals("desc")){
								order[i]=Order.desc;
							}else{
								order[i]=Order.asc;
							}	
						}//end for-deal with ps,order
						
						//ArrayList<PlayerNormalInfo> list=pbs.getPlayerTotalNormalInfoMOrder(pos, lea, age, ps, order, num);
						ArrayList<PlayerNormalInfo> list=pbs.getPlayerTotalNormalInfo(pos, lea, age, ps[0], order[0], num);
						System.out.println("pos:"+pos.toString());
						System.out.println("lea:"+lea.toString());
						System.out.println("age:"+age.toString());
						System.out.println("ps:"+ps[0]);
						System.out.println("order:"+order[0]);
						System.out.println("num:"+num);
						for(int i=0;i<list.size();i++){
							out.println(list.get(i).toString());
							//System.out.println(list.get(i).toString());
						}
					}
				}
			}
		}else{//team
			
		}
	}
	
	class Config{
		Model chosen;
		
		@CmdOption(names = { "-player" }, conflictsWith = { "-team" })
		private void setPlayer() {chosen = Model.PLAYER;}
		
		@CmdOption(names = { "-team" }, conflictsWith = { "-player" })
		private void setTeam() {chosen = Model.TEAM;}
		
		@CmdOption(names = { "-avg" }, conflictsWith = { "-total" })
		boolean isAverage = true;
		
		@CmdOption(names = { "-total" }, conflictsWith = { "-avg" })
		private void setTotal() {
			isAverage = false;
		}
		
		@CmdOption(names = { "-all" }, conflictsWith = { "-hot", "-king" })
		boolean isAll = true; // useless

		@CmdOption(names = { "-hot" }, args={"field"}, conflictsWith = { "-avg", "-total", "-filter", "-sort", "-all", "-king" })
		String hotField;
		
		@CmdOption(names = {"-king"}, args={"field"}, conflictsWith = { "-avg", "-total", "-filter", "-sort", "-all", "-hot" })
		String kingField;
		
		@CmdOption(names = {"-daily"}, conflictsWith = {"-season"}, requires = {"-king"})
		boolean isDaily=true;
		
		@CmdOption(names = {"-season"}, conflictsWith = {"-daily"}, requires = {"-king"})
		private void setSeason() {
			isDaily = false;
		}
		
		@CmdOption(names = { "-high" }, conflictsWith = { "-avg", "-total", "-hot", "-all", "-king"})
		boolean isHigh = false;
		
		@CmdOption(names = { "-n" }, args={"number"})
		int n=-1;
		
		@CmdOption(names = { "-sort" }, args={"order"})
		String sortField = "";
		
		@CmdOption(names = { "-filter" }, args={"filter"})
		String filterField = "";
	}
	
	
}
