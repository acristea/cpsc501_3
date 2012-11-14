import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Years {
	public int [] arrayYears;
	public Years() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < 5; i++) {
			arrayYears = new int[5];
			arrayYears[i] = i;	
			System.out.println("Index of " + i + " current value " + arrayYears[i]); 
			System.out.println("Change value to: ");
			String input = in.readLine();
			arrayYears[i] = Integer.parseInt(input); 

		}
	}
}
