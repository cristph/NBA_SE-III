package analysis.teamanalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class pythonTest {
	public void runtimeScriptTest(){
        try {
            Process process = Runtime.getRuntime().exec("cmd /c python python//compare.py 19;2 18;5 A B C");
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            BufferedReader input = new BufferedReader(ir);
            String line;
            while((line = input.readLine()) != null){
            	
                System.out.println(line);
            }
            input.close();
            ir.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args){
		pythonTest p=new pythonTest();
		p.runtimeScriptTest();
	}

}
