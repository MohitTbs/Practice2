package r1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptExecutorDownload {
	public static WebDriver driver;

	public static void main(String[] args) {
		
		//
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		// Reference: https://www.browserstack.com/docs/automate/selenium/test-file-download#File_exists
		Object obj = (jse.executeScript("browserstack_executor: {\"action\": \"getFileProperties\"}"));
		System.out.println(obj);
		String str = obj.toString();
		System.out.println("Sting Value" + str);

		String[] keyValuePairs = str.split(", ");
		String fileName = "";

		for (String pair : keyValuePairs) {
			String[] parts = pair.split("=");
			String key = parts[0];
			String value = parts[1];

			if (key.equals("file_name")) {
				fileName = value;
				break;
			}
		}

		if (fileName.length() > 0) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Frontdesk intake form pdf generated successfully.\"}}");
		} else {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Frontdesk intake form pdf failed to generate.\"}}");
		}
	}

}
