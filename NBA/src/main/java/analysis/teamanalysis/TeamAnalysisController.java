package analysis.teamanalysis;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import po.TeamAllGamePO;
import businesslogic.teambl.TeamController;
import value.Value.Std;
import vo.TeamVO;

public class TeamAnalysisController implements TeamAnaInterface{
	
	String season;
	TeamController tbs;
	public TeamAnalysisController(String season1){
		season=season1;
		tbs=new TeamController(season);
	}
	public String teamCompare(String team1,String team2,Std st){
		tbs.getTeamVO();
		String path="";
		String word="";
		
		
		path="cmd /c python python//compare.py ";
		ArrayList<TeamVO> pvo=tbs.getVO();
		for(TeamVO v:pvo){
			if(v.getShortName().equals(team1)){
				String s="";
				if(st==Std.score){
					s=s+Double.toString(v.getAllpointave());
					s=s+";";
					s=s+Double.toString(v.getPointvar());
				}
				else if(st==Std.rebound){
					s=s+Double.toString(v.getRebTotalNumave());
					s=s+";";
					s=s+Double.toString(v.getReboundvar());
				}
				else if(st==Std.assist){
					s=s+Double.toString(v.getAssistNumave());
					s=s+";";
					s=s+Double.toString(v.getAssistvar());
				}
				else if(st==Std.foul){
					s=s+Double.toString(v.getFoulNumave());
					s=s+";";
					s=s+Double.toString(v.getFoulvar());
				}
				path=path+s;
				path=path+" ";
				break;
			}
			
		}
		for(TeamVO v:pvo){
			if(v.getShortName().equals(team2)){
				String s="";
				if(st==Std.score){
					s=s+Double.toString(v.getAllpointave());
					s=s+";";
					s=s+Double.toString(v.getPointvar());
				}
				else if(st==Std.rebound){
					s=s+Double.toString(v.getRebTotalNumave());
					s=s+";";
					s=s+Double.toString(v.getReboundvar());
				}
				else if(st==Std.assist){
					s=s+Double.toString(v.getAssistNumave());
					s=s+";";
					s=s+Double.toString(v.getAssistvar());
				}
				else if(st==Std.foul){
					s=s+Double.toString(v.getFoulNumave());
					s=s+";";
					s=s+Double.toString(v.getFoulvar());
				}
				path=path+s;
				path=path+" ";
				break;
			}
		}
		path=path+team1;
		path=path+" ";
		path=path+team2;
		path=path+" ";
		if(st==Std.score){
			path=path+"score";
		}
		else if(st==Std.rebound){
			path=path+"rebound";
		}
		else if(st==Std.assist){
			path=path+"assist";
		}
		else if(st==Std.foul){
			path=path+"foul";
		}
		String result="";
		try {
            Process process = Runtime.getRuntime().exec(path);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            BufferedReader input = new BufferedReader(ir);
            String line;
            while((line = input.readLine()) != null){
            	result=result+line;
            	result=result+";";
            }
            input.close();
            ir.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		String[] re=result.split(";");
		if(re[0].equals("good1")){
			word=word+team1+"比"+team2+"水平高,";
		}
		else if(re[0].equals("bad1")){
			word=word+team1+"比"+team2+"水平低,";
		}
		if(re[1].equals("good2")){
			word=word+team1+"比"+team2+"发挥稳定.";
		}
		else if(re[1].equals("bad2")){
			word=word+team2+"比"+team1+"发挥稳定.";
		}
		return word;
	}
	public String oneTeamAna(String team,Std st){
		String word="";
		String path="";
		if(st==Std.score){
			path=path+"cmd /c python python//Chi-squaredtest1.py ";
		}
		else if(st==Std.rebound){
			path=path+"cmd /c python python//Chi-squaredtest2.py ";
		}
		else if(st==Std.assist){
			path=path+"cmd /c python python//Chi-squaredtest3.py ";
		}
		else if(st==Std.foul){
			path=path+"cmd /c python python//Chi-squaredtest4.py ";
		}
		
		tbs.getTeamVO();
		ArrayList<TeamAllGamePO> p=tbs.getPO();
		TeamAllGamePO po=new TeamAllGamePO();
		for(TeamAllGamePO tagp:p){
			if(tagp.getTeamName().equals(team)){
				po=tagp;
				break;
			}
		}
		String s="";
		double mean=0;
		double var=0;
		ArrayList<TeamVO> pvo=tbs.getVO();
		if(st==Std.score){
			for(int i=0;i<po.getGameDataList().size();i++){
				s=s+po.getGameDataList().get(i).getMatchResult().split("-")[0];
				if(i<po.getGameDataList().size()-1){
					s=s+";";
				}
			}
			for(TeamVO v:pvo){
				if(v.getShortName().equals(team)){
					mean=v.getAllpointave();
					var=v.getPointvar();
					break;
				}
			}
			
		}
		else if(st==Std.rebound){
			for(int i=0;i<po.getGameDataList().size();i++){
				s=s+Double.toString(po.getGameDataList().get(i).getRebTotalNum());
				if(i<po.getGameDataList().size()-1){
					s=s+";";
				}
			}
			for(TeamVO v:pvo){
				if(v.getShortName().equals(team)){
					mean=v.getRebTotalNumave();
					var=v.getReboundvar();
					break;
				}
			}
		}
		else if(st==Std.assist){
			for(int i=0;i<po.getGameDataList().size();i++){
				s=s+Double.toString(po.getGameDataList().get(i).getAssistNum());
				//System.out.println(po.getGameDataList().get(i).getAssistNum());
				if(i<po.getGameDataList().size()-1){
					s=s+";";
				}
			}
			for(TeamVO v:pvo){
				if(v.getShortName().equals(team)){
					mean=v.getAssistNumave();
					var=v.getAssistvar();
					break;
				}
			}
		}
		else if(st==Std.foul){
			for(int i=0;i<po.getGameDataList().size();i++){
				s=s+Double.toString(po.getGameDataList().get(i).getFoulNum());
				if(i<po.getGameDataList().size()-1){
					s=s+";";
				}
			}
			for(TeamVO v:pvo){
				if(v.getShortName().equals(team)){
					mean=v.getFoulNumave();
					var=v.getFoulvar();
					break;
				}
			}
		}
		path=path+s;
		String re="";
		try {
            Process process = Runtime.getRuntime().exec(path);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            BufferedReader input = new BufferedReader(ir);
            String line;
            while((line = input.readLine()) != null){
            	//System.out.println(line);
                re=line;
                
            }
            input.close();
            ir.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		if(re.equals("Yes")){
			word="此项数据满足正态分布";
			String path2="cmd /c python python//oneteamnorm.py ";
			path2=path2+Double.toString(mean);
			path2=path2+" ";
			path2=path2+Double.toString(var);
			try {
	            Process process = Runtime.getRuntime().exec(path2);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			String path3="cmd /c python python//oneteambar.py ";
			path3=path3+s;
			try {
	            Process process = Runtime.getRuntime().exec(path3);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		else{
			word="此项数据不满足正态分布";
			String path3="cmd /c python python//oneteambar.py ";
			path3=path3+s;
			try {
	            Process process = Runtime.getRuntime().exec(path3);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		return word;
	}
	public String linregress(Std st){
		tbs.getTeamVO();
		String word="";
		ArrayList<TeamVO> pvo=tbs.getVO();
		String path="cmd /c python python//linregress.py ";
		String s="";
		for(int i=0;i<pvo.size();i++){
			if(pvo.get(i).getWinrate()!=0){
			     s=s+Double.toString(pvo.get(i).getWinrate());
			//System.out.println(pvo.get(i).getWinrate()+pvo.get(i).getShortName());
			     if(i<pvo.size()-1){
				     s=s+";";
			     }
			}
			
		}
		
		String t="";
		if(st==Std.score){
			for(int i=0;i<pvo.size();i++){
				if(pvo.get(i).getAllpointave()!=0){
				     t=t+Double.toString(pvo.get(i).getAllpointave());
				     if(i<pvo.size()-1){
					     t=t+";";
				     }
				}
				
			}
		}
		else if(st==Std.rebound){
			for(int i=0;i<pvo.size();i++){
				if(pvo.get(i).getRebTotalNumave()!=0){
					t=t+Double.toString(pvo.get(i).getRebTotalNumave());
				    if(i<pvo.size()-1){
					    t=t+";";
				    }
				}
				
				
			}
		}
		else if(st==Std.assist){
			for(int i=0;i<pvo.size();i++){
				if(pvo.get(i).getAssistNumave()!=0){
					t=t+Double.toString(pvo.get(i).getAssistNumave());
				    if(i<pvo.size()-1){
					    t=t+";";
				    }
				}
				
				
			}
		}
		else if(st==Std.foul){
			for(int i=0;i<pvo.size();i++){
				if(pvo.get(i).getFoulNumave()!=0){
					t=t+Double.toString(pvo.get(i).getFoulNumave());
				    if(i<pvo.size()-1){
					    t=t+";";
				    }
				}
				
				
			}
		}
		path=path+t;
		path=path+" ";
		path=path+s;
		
		String[] re=new String[3];
		try {
            Process process = Runtime.getRuntime().exec(path);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            BufferedReader input = new BufferedReader(ir);
            String line;int i=0;
            while((line = input.readLine()) != null){
            	//System.out.println("CCCCC");
            	re[i]=line;
            	i++;
                
            }
            input.close();
            ir.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		String stda="";
		if(st==Std.score){
			stda="得分";
		}
		else if(st==Std.rebound){
			stda="篮板";
		}
		else if(st==Std.assist){
			stda="助攻";
		}
		else if(st==Std.foul){
			stda="失误";
		}
		if(re[0].equals("Yes")){
			word="胜率与"+stda+"存在较高线性关系"+"满足y="+re[2]+"+"+re[1]+"x"+"的回归方程";
		}
		else{
			word="胜率与"+stda+"不存在较高线性关系";
		}
		return word;
	}
	public HashMap<String,Image> getAllTeam(){
		return tbs.getAllTeam();
	}
	public void setSeason(String season1){
		season=season1;
		tbs.setSeason(season1);
	}
	public static void main(String[] args){
		TeamAnalysisController t=new TeamAnalysisController("2014-2015");
		String s=t.linregress(Std.score);
		System.out.println(s);
	}

}
