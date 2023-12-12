package terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OpenTermina {

	public static void main(String[] args) {

//		try {
//			String line;
//			Process p = Runtime.getRuntime().exec("tasklist"); // "ps -e" --for mac
//			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			while ((line = input.readLine()) != null) {
//				System.out.println(line); // <-- Parse data here.
////				if(line.contains("notepad++.exe")) {
////					String[] a = line.split(" ");
////					System.out.println(Arrays.toString(a));
////					
////				}
//			}
//			input.close();
//		} catch (Exception err) {
//			err.printStackTrace();
//		}
//	}

		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(
					"cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4724 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
