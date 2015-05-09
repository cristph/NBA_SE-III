package testoutput;

public class Main {
	
	public static void main(String[] args){
		Console console=new Console();
		console.execute(System.out, "-player -total -filter position.F -sort rebound.desc".split("\\s"));
	}
}
