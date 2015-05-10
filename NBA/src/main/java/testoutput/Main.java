package testoutput;

import data.gamedata.GameData;

public class Main {
	
	public static void main(String[] args){
		Console console=new Console();
		//String []str={"--datasource","D:\\nba"};
		console.execute(System.out, "--datasource C:\\Users\\lenovo\\Desktop\\data".split("\\s"));
		//GameData.setPath("C:\\Users\\lenovo\\Desktop\\data");
		console.execute(System.out, "-player -total -n 50 -filter league.West,age.22<X<=25 -sort point.desc,assist.desc".split("\\s"));
		//"-player -total -n 50 -filter league.West,age.22<X<=25 -sort point.desc,assist.desc".split("\\s")
		//PlayerNormalInfo pni=new PlayerNormalInfo();
	}
}
