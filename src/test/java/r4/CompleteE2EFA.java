package r4;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompleteE2EFA {

	@Test
	public void test1() throws InterruptedException {

		String preciseWindow = "";
		String frontAppHomeWindow = "";
		String frontAppUploadWindow;
		String errMsg = "";
		String patientId = "PRE377431";

		boolean flag = false;
		boolean result = false;
		boolean flag2 = false;

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Actions action = new Actions(driver);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		try {
			driver.get("https://staging-precise.radflow360.com/");

			WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Email']"));
			WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Enter your password']"));
			Username.sendKeys("tbs.chiragk@gmail.com");
			Password.sendKeys("Test@1234");
			WebElement LoginBtn = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
			LoginBtn.click();
			Thread.sleep(10000);

			driver.get("https://staging-precise.radflow360.com/pi/case-update-and-collection");

			// Searching for Patient
			WebElement patientIdField = driver.findElement(By.xpath("(//*[@placeholder='Patient ID'])[1]"));
			patientIdField.sendKeys(patientId);
			WebElement searchBtn = driver.findElement(By.xpath("(//*[@class='btn btn-theme'])[1]"));
			// action.moveToElement(searchBtn).click();
			// searchBtn.click();
			js1.executeScript("arguments[0].click();", searchBtn);
			Thread.sleep(6000);

			WebElement patientIdRecord = driver.findElement(
					By.xpath("(//*[@class='cursor-pointer link-btn' and text() = '" + patientId + "'])[1]"));
			patientIdRecord.click();
			Thread.sleep(5000);
			preciseWindow = driver.getWindowHandle();

			// Sending Email
			WebElement sendEmailIcon = driver.findElement(By.xpath("(//*[contains(@class,'mail-open-file')])[1]"));
			sendEmailIcon.click();
			Thread.sleep(8000);

			WebElement pi_billingDrpDwn = driver
					.findElement(By.xpath("//div[@id='front-email-modal']//select[@class='form-control']"));
			Select selectDrpDwn = new Select(pi_billingDrpDwn);
			selectDrpDwn.selectByVisibleText("PI - Billing");
			WebElement sendTotextBox = driver.findElement(By.xpath("//*[@formcontrolname='attorneyEmail']"));
			
			//Generate RandomMail  -- Starts
			
		    int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 10;
		    Random random = new Random();
		    StringBuilder buffer = new StringBuilder(targetStringLength);
		    for (int i = 0; i < targetStringLength; i++) {
		        int randomLimitedInt = leftLimit + (int) 
		          (random.nextFloat() * (rightLimit - leftLimit + 1));
		        buffer.append((char) randomLimitedInt);
		    }
		    String generatedString = buffer.toString();
			String randomMailGenerated = generatedString+"@gmail.com";
			
			//----------Generate Random Mail ends
			
			
			sendTotextBox.sendKeys(randomMailGenerated);
			WebElement subField = driver.findElement(By.xpath("(//*[@formcontrolname='subject'])[1]"));
			subField.clear();
			subField.sendKeys("TestDemo Rad PSL Tech PSL");
			// driver.findElement(By.xpath("(//*[@formcontrolname='subject'])[1]")).sendKeys("TestDemo
			// {{Patient}}");

			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'editor4')]")));

			WebElement mailBodtTextBox = driver.findElement(By.xpath("//body[contains(@class,'cke_contents_ltr')]"));
			mailBodtTextBox.sendKeys("Test Document Rad PSL Tech PSL");
			driver.switchTo().defaultContent();
			// ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			// List<WebElement> fileUploads =
			// driver.findElements(By.cssSelector("span[class*='drag-drop-box']
			// input[type='file'][name='file']"));
			// ((RemoteWebDriver) driver).findElement(By.cssSelector("div[class='fileupload
			// caseFileupload'] i[class='fa fa-cloud-upload
			// rightUpload']")).sendKeys(System.getProperty("user.dir")+"\\uploadFiles\\demoTestupload\\PRE377431_Tech_PSL.pdf");
			// WebElement inputFile =
			// driver.findElement(By.cssSelector("div[class='fileupload caseFileupload']
			// i[class='fa fa-cloud-upload rightUpload']"));

			// Upload Files to send Mail to Front

			WebElement inputFile = driver
					.findElement(By.xpath("//div[@class='fileupload caseFileupload']//input[@type='file']"));
			/*
			 * LocalFileDetector detector = new LocalFileDetector(); ((RemoteWebElement)
			 * inputFile).setFileDetector(detector); inputFile
			 * .sendKeys(System.getProperty("user.dir") +
			 * "\\uploadFiles\\demoTestupload\\PRE377431_Tech_PSL.pdf"); inputFile
			 * .sendKeys(System.getProperty("user.dir") +
			 * "\\uploadFiles\\demoTestupload\\PRE377431_Tech_Rad.pdf");
			 */
			inputFile
					.sendKeys(System.getProperty("user.dir") + "\\uploadFiles\\demoTestupload\\PRE377431_Tech_PSL.pdf");
			inputFile.sendKeys(System.getProperty("user.dir") + "\\uploadFiles\\demoTestupload\\PRE377431_Rad_PSL.pdf");
			Thread.sleep(2000);
			WebElement submitBtn = driver
					.findElement(By.xpath("//div[@id='front-email-modal']//button[@type='submit']"));
			submitBtn.click();

			// Taost message
			WebElement toastMessage = driver.findElement(By.id("toast-container"));
			boolean isVisible = toastMessage.isDisplayed();
			System.out.println(isVisible);
			Thread.sleep(1000);
			if (isVisible) {
				flag = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
			errMsg = e.getMessage().toString() + "\n";
		}

		try {

			if (flag) {
				driver.switchTo().newWindow(WindowType.TAB);
				frontAppHomeWindow = driver.getWindowHandle();

				driver.get("https://front.com/");
				WebElement frontAppSignInBtn = driver.findElement(By.xpath("(//a[text()='Sign In'])[1]"));
				frontAppSignInBtn.click();
				WebElement frontAppEmailField = driver.findElement(By.cssSelector("#email-login"));
				frontAppEmailField.sendKeys("vikram@technobrains.io");
				WebElement frontAppPassField = driver.findElement(By.cssSelector("#password-login"));
				frontAppPassField.sendKeys("Vikram@123");
				WebElement frontAppLoginSubmitBtn = driver.findElement(By.cssSelector("[type='submit']"));
				frontAppLoginSubmitBtn.click();
				Thread.sleep(5000);
				WebElement Pi_BillingTab = driver.findElement(
						By.xpath("(//div[contains(@class,'tooltipOverflowCondition') and text()='PI - Billing'])[2]"));
				Pi_BillingTab.click();
				Thread.sleep(5000);

				// Selecting the mail from the inbox
				List<WebElement> mailSubjectList = driver
						.findElements(By.xpath("//div[contains(@class,'cellMiddle__StyledSubject')]/span"));
				for (WebElement e : mailSubjectList) {
					String subText = e.getText();
					if (subText.contains("TestDemo")) {
						e.click();
						break;
					}
				}

				Thread.sleep(2000);

				WebElement pluginBtn;

				// Clicking on the Plugin

				pluginBtn = driver
						.findElement(By.xpath("//div[contains(@class,'entryPointSwitcherItem__') and text() = 'D']"));
				pluginBtn.click();
				Thread.sleep(15000); // Need 150000 Seconds
				String frontAppMailPage = driver.getWindowHandle();

				// Clicking on the Send Mail to
				WebElement pluginFrame = driver.findElement(By.xpath("//iframe[@title='Dev ENV Plugin']"));
				driver.switchTo().frame(pluginFrame);
				WebElement senFilesTo360Btn = driver.findElement(By.id("sendlien"));
				senFilesTo360Btn.click();

				Thread.sleep(25000); // Need 250000 Seconds

				Set<String> windowHandles2 = driver.getWindowHandles();
				// String uploadReplyFrontPage;

				// Switching to uploadReplyFrontPage

				for (String singleWindow : windowHandles2) {

					if (!singleWindow.equalsIgnoreCase(frontAppMailPage)
							&& !singleWindow.equalsIgnoreCase(preciseWindow)) {
						frontAppUploadWindow = singleWindow;
						driver.switchTo().window(frontAppUploadWindow);
					}
				}

				List<WebElement> listOfPatientIds = driver
						.findElements(By.xpath("(//div[@class='user-table-block'])[2]//tbody/tr/td[3]/input"));
				List<WebElement> listOfDocTypes = driver
						.findElements(By.xpath("(//div[@class='user-table-block'])[2]//tbody/tr/td[4]/select"));
				List<WebElement> listOfCheckBoxes = driver.findElements(
						By.xpath("(//div[@class='user-table-block'])[2]//tbody/tr/td[1]//input[@type='checkbox']"));

				for (int k = 0; k < listOfPatientIds.size(); k++) {
					String patientIdText = listOfPatientIds.get(k).getAttribute("value");
					Select selectDocType = new Select(listOfDocTypes.get(k));

					WebElement selectedDoc = selectDocType.getFirstSelectedOption();
					String selectedDocText = selectedDoc.getText();
					System.out.println(patientIdText+"   "+ selectedDocText);

					if (patientIdText.trim().equalsIgnoreCase(patientId)
							&& (selectedDocText.trim().equalsIgnoreCase("TECH Patient Signed Lien")
									|| selectedDocText.trim().equalsIgnoreCase("RAD Patient Signed Lien"))) {
						//listOfCheckBoxes.get(k).click();
						System.out.println("Inside CheckBoxes");
						action.moveToElement(listOfCheckBoxes.get(k)).click(listOfCheckBoxes.get(k)).build().perform();
					}
				}

				// *************************
				/*
				WebElement fileNameCheckbox = driver
						.findElement(By.xpath("//input[@class='label-info check-box pointer']"));
				fileNameCheckbox.click();
				*/
				Thread.sleep(2000);

				WebElement uploadAndReplyLiensBtn = driver.findElement(By.cssSelector("#sendliensdemo"));
				action.moveToElement(uploadAndReplyLiensBtn).click().build().perform();
				WebElement successMshToUpload = driver.findElement(By.xpath("//div[@claSS='success-msg']"));
				Thread.sleep(10000);
				boolean succMsgFlag = successMshToUpload.isDisplayed();
				flag2 = true;
				// **************************************
			}

		} catch (Exception e) {

			e.printStackTrace();
			errMsg = errMsg + e.getMessage().toString() + "\n";
		}

		try {

			if (flag2) {
				driver.switchTo().window(preciseWindow);
				driver.get("https://staging-precise.radflow360.com/pi/case-update-and-collection");

				// Deleting the Doc uploaded from Front to Precise
				WebElement patientIdField = driver.findElement(By.xpath("(//*[@placeholder='Patient ID'])[1]"));
				patientIdField.sendKeys(patientId);
				WebElement searchBtn = driver.findElement(By.xpath("(//*[@class='btn btn-theme'])[1]"));
				js1.executeScript("arguments[0].click();", searchBtn);
				// searchBtn.click();
				Thread.sleep(6000);

				WebElement patientIdRecord = driver.findElement(
						By.xpath("(//*[@class='cursor-pointer link-btn' and text() = '" + patientId + "'])[1]"));
				patientIdRecord.click();
				Thread.sleep(5000);

				WebElement docTab = driver
						.findElement(By.xpath("(//li[@class='nav-item']//a[@data-target='#docManager'])[1]"));
				docTab.click();
				Thread.sleep(5000);

				List<WebElement> fileNameListElement = driver.findElements(By.xpath(
						"//span[@class='dx-filemanager-details-item-name']/ancestor::tr[contains(@class,'dx-row dx-data-row')]/td[3]"));
				List<WebElement> checkBoxesListtElement = driver.findElements(By.xpath(
						"//span[@class='dx-filemanager-details-item-name']/ancestor::tr[contains(@class,'dx-row dx-data-row')]/td[1]"));

				boolean isDeleted = false;
				for (int i = 0; i < fileNameListElement.size(); i++) {

					String fileName = fileNameListElement.get(i).getText();
					if (fileName.trim().equalsIgnoreCase("Rad Patient Signed Lien")
							|| fileName.trim().equalsIgnoreCase("TECH Patient Signed Lien")) {
						checkBoxesListtElement.get(i).click();
						isDeleted = true;
						result = true;
					}
				}

				Thread.sleep(1000);
				if (isDeleted) {
					WebElement deleteBtn = driver.findElement(By.xpath("//span[text()='Delete Selected Files']"));
					deleteBtn.click();

					WebElement deleteConfBtn = driver
							.findElement(By.xpath("//div[@id='deleteItemConfirmPopUp']//*[text() = 'Ok']"));
					deleteConfBtn.click();

					// Toast Message
					WebElement toastMessage = driver.findElement(By.id("toast-container"));
					boolean isVisible = toastMessage.isDisplayed();
					System.out.println(isVisible);
				}
				Thread.sleep(1000);

			}
		} catch (Exception e) {

			e.printStackTrace();
			errMsg = errMsg + e.getMessage().toString() + "\n";
		}

		try {

			if (flag) {
				driver.switchTo().window(frontAppHomeWindow);

				//// Now Deleting the Mail from Front App

				WebElement threeDotsMenu = driver.findElement(
						By.xpath("(//div[contains(@class,'messageViewerMore_')]/div/div/div/div)[last()]"));
				threeDotsMenu.click();
				Thread.sleep(2000);
				WebElement DeleteMailBtn = driver
						.findElement(By.xpath("//div[contains(@class,'dropdownItemContent') and text() = 'Delete']"));
				DeleteMailBtn.click();
				Thread.sleep(2000);
//				WebElement deleteConfirmBtn = driver
//						.findElement(By.xpath("//div[contains(@class,'buttonContent_') and text() = 'Delete']"));
				WebElement deleteConfirmBtn = driver
				.findElement(By.xpath("//*[text() = 'Delete conversation']"));

				deleteConfirmBtn.click();

			}

		} catch (Exception e) {

			e.printStackTrace();
			errMsg = errMsg + e.getMessage().toString() + "\n";
		}

		try {
			if (result) {
				Assert.assertTrue(result);
			} else {
				System.out.println("====================================");
				System.out.println(errMsg);
				System.out.println("=======Error Message from Assert.fail()========");
				Assert.fail(errMsg);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
