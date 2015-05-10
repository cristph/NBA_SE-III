package testoutput;

public class Main {
	
	public static void main(String[] args){
		Console console=new Console();
		console.execute(System.out, args);
		//"-player -total -n 50 -filter league.West,age.22<X<=25 -sort point.desc,assist.desc".split("\\s")
		//PlayerNormalInfo pni=new PlayerNormalInfo();
	}
}
