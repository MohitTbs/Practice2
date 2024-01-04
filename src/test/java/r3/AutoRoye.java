package com.browserstack;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutoRoye extends BrowserStackRemoteTest {

	boolean issavesuccess = true;
	String Removefile = "rem";
	@Test
	public void Autoroutetest() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		JavascriptExecutor jse_auto = (JavascriptExecutor) driver;
		jse_auto.executeScript(
				"browserstack_executor: {\"action\": \"annotate\",\"arguments\": {\"data\": \"Verify AutoRoute TestCase\", \"level\": \"info\"}}");
	
		JSONObject executorObject = new JSONObject();
		JSONObject argumentsObject = new JSONObject();

		argumentsObject.put("name", "AutoRoute TestCase");

		executorObject.put("action", "setSessionName");
		executorObject.put("arguments", argumentsObject);
		jse_auto.executeScript(String.format("browserstack_executor: %s", executorObject));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Login login = new Login(driver);
		login.ProductionLoginTest();

		WebElement Autoroutetab = driver.findElement(By.xpath("//a[@href='/auto-route-v2']"));
		Autoroutetab.click();

		WebElement uploadinput = driver.findElement(By.xpath(
				"/html/body/app-root/app-core/div[1]/div/div[2]/app-auto-route-v2/div[1]/div[2]/div/div[1]/span/input"));

		LocalFileDetector detector = new LocalFileDetector();
		((RemoteWebElement) uploadinput).setFileDetector(detector);

		uploadinput.sendKeys(System.getProperty("user.dir") + File.separator + "PROD_ESIGN_PRE00001_PSL.pdf");

		
		int TotalRowCount = 0;

		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//body//app-root//div[@id='loader']//div//div//div[1]")));
		List<WebElement> RowCount = driver
				.findElements(By.xpath("//div[@class='inner-page-body']//table[@class='table table-theme']/tbody/tr"));

		TotalRowCount = RowCount.size();
		System.out.println("TR Contains: " + TotalRowCount);
		
		String barcode_execute_pass = "Pass1";
		String NoBarcode = "No_Test";
		
		String selectedDocType = "DocType";
		String selected_String = "SELECT DOCUMENT FILE TYPE";
		int doc_count = 0;
		
		String patient_id_text = "patientid_1";
		int patient_count = 0;
		
		
		

		for (int i = 1; i <= TotalRowCount; i++) {
			
			
			Select sel = new Select(driver.findElement(By.xpath(
					"/html/body/app-root/app-core/div[1]/div/div[2]/app-auto-route-v2/div[1]/div[2]/div[3]/table/tbody/tr["
							+ i + "]/td[4]/div/div/div/select")));
			selectedDocType = sel.getFirstSelectedOption().getText();

			if (selected_String.contains(selectedDocType)) {
				System.out.println("Selected============" + selectedDocType);

				jse_auto.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Document type Is NOT Auto selected for "
								+ i + "th Row of table!\"}}");

				argumentsObject.put("name", "AutoRoute Doc type not Auto selected");
				executorObject.put("action", "setSessionName");
				executorObject.put("arguments", argumentsObject);
				jse_auto.executeScript(String.format("browserstack_executor: %s", executorObject));
			}

			else {
				doc_count = doc_count + 1;
			}

			WebElement Patientid_input = driver.findElement(By.xpath(
					"/html/body/app-root/app-core/div[1]/div/div[2]/app-auto-route-v2/div[1]/div[2]/div[3]/table/tbody/tr["
							+ i + "]/td[5]/div/div/input"));
			patient_id_text = Patientid_input.getAttribute("value");

			if (patient_id_text.isEmpty()) {
				System.out.println("NO Patient ID text");
				jse_auto.executeScript(
						"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Patient ID Is Empty "
								+ i + "th Row of table!\"}}");
				// ----Change name

				argumentsObject.put("name", "AutoRoute Patient ID Empty");
				executorObject.put("action", "setSessionName");
				executorObject.put("arguments", argumentsObject);
				jse_auto.executeScript(String.format("browserstack_executor: %s", executorObject));

			} else {
				patient_count = patient_count + 1;
			}

		}

		WebElement Check_select_1 = driver.findElement(By.xpath(
				"/html/body/app-root/app-core/div[1]/div/div[2]/app-auto-route-v2/div[1]/div[2]/div[3]/table/tbody/tr[1]/td[1]/div/input"));

		Check_select_1.click();

		driver.findElement(By.xpath(
				"/html/body/app-root/app-core/div[1]/div/div[2]/app-auto-route-v2/div[1]/div[2]/div[2]/div/div[1]/div/button"))
				.click();

		WebElement SaveSuccess = driver
				.findElement(By.xpath("//div[@aria-label='All Files have been attached successfully']"));

		issavesuccess = SaveSuccess.isDisplayed();
		if (issavesuccess = false) {
			jse_auto.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"File not save and attached to patient!\"}}");

		}

		try {
			driver.findElement(By.xpath(
					"/html/body/app-root/app-core/div[1]/div/div[2]/app-auto-route-v2/div[1]/div[2]/div[3]/table/tbody/tr[1]/td[7]/div/a[2]"))
					.click();
			driver.findElement(By.xpath(
					"/html/body/app-root/app-core/div[1]/div/div[2]/app-auto-route-v2/div[1]/div[3]/div/div/div[3]/button[2]"))
					.click();
			Thread.sleep(5000);
		} catch (Exception e) {

			Removefile = "NotRemoved";
			jse_auto.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"File not deleted successfully!\"}}");
		}

		System.out.println("Barcode  check " + barcode_execute_pass);
		System.out.println("Barcode  check " + NoBarcode);
		System.out.println("Document selected count " + doc_count);

		if (issavesuccess = true) {

				JavascriptExecutor jse1 = (JavascriptExecutor)driver;
				
				WebElement Patients_link = driver.findElement(By.xpath("//input[@id='search-text']"));
				
				Patients_link.sendKeys("PRE00001");
				Thread.sleep(5000);
				
				
				WebElement doc_manager = driver.findElement(By.xpath("//a[@tooltip='Open Document Manager']"));
				
				doc_manager.click();
				Thread.sleep(5000);
				
				WebElement documentsManagerOptionsLink = driver.findElement(By.xpath("(//tr[1]//div[contains(@class,'filemanager-file-actions')]//i[@class='dx-icon dx-icon-overflow'])[1]"));
				
				jse1.executeScript("arguments[0].click();", documentsManagerOptionsLink);
				Thread.sleep(2000);
						
				WebElement deleteOptionsLink = driver.findElement(By.xpath("//span[@class='dx-menu-item-text' and text()='Delete']"));
				deleteOptionsLink.click();
				Thread.sleep(2000);
				
				
				WebElement deleteOkBtnLink = driver.findElement(By.xpath("(//div[@id='deleteItemConfirmPopUp']//button[text()='Ok'])[1]"));
				deleteOkBtnLink.click();
				
		}

		WebElement isDeletedMessage = driver
				.findElement(By.xpath("//div[@aria-label='Document deleted successfully']"));

		boolean isTest = isDeletedMessage.isDisplayed();
		if (isTest) {
		
			jse_auto.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Pdf page count is matching with row count, Barcode in file pages are properly visible with id name !! ,Doc Types are selected properly !!, Patient Id is not visible properly.! \"}}");
		}
		else {
			
			argumentsObject.put("name", "AutoRoute Test case Failed, Please Check browserstack logs for more details ");

			executorObject.put("action", "setSessionName");
			executorObject.put("arguments", argumentsObject);
			jse_auto.executeScript(String.format("browserstack_executor: %s", executorObject));

			jse_auto.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Check Respective Failed Test cases shown in below log, related to Pdf page and row count, Barcode, Doc types, Patient Id,File save and remove file..!\"}}");

			System.out.println("AutoRoute test case finished");
		}

	}

}
