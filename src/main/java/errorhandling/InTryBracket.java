package errorhandling;

import java.io.FileWriter;

public class InTryBracket {

	public static void main(String[] args) {
		
		// In Try parenthesis the object should be implementing AutoCloseable

		try(FileWriter writer = new FileWriter("")){
			
			writer.write(0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
