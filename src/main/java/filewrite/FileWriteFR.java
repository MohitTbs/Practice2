package filewrite;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class FileWriteFR {

	public static void main(String[] args) throws IOException {

		String Partialpath = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\";
		FileWriter writer = new FileWriter(new File(Partialpath+"writtenfile.txt"));
	
		StringBuffer sb = new StringBuffer();
		String testClassName = "r2.LoadTheSite";
		
		int k;
		
		for (k = 1; k <= 10; k++) {
			sb.append("<test name=\"Test" + k + "\" >\r\n" + "		<classes > \r\n"
					+ "			<class name=\""+testClassName+"\" />\r\n" + "		</classes>\r\n" + "</test> ");
			sb.append("\n");
			
		}
		String str = sb.toString();
		writer.write(str);
		
		writer.close();
		System.out.println("File Written");
		
		
		
	}

}
