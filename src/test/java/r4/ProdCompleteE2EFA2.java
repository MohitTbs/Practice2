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

public class ProdCompleteE2EFA2 {

	@Test
	public void test1() throws InterruptedException {

		String preciseWindow = "";
		String frontAppHomeWindow = "";
		String frontAppUploadWindow;
		String errMsg = "";
		String patientId = "PRE999999999999999";

		boolean flag = false;
		boolean result = false;
		boolean flag2 = false;
		boolean deleteMsgFromFrontApp = false;

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Actions action = new Actions(driver);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		try {
			driver.get("https://precise.radflow360.com/login");

			WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Email']"));
			WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Enter your password']"));
			Username.sendKeys("danny@precisemri.com");
			Password.sendKeys("Dayfall1#");
			WebElement LoginBtn = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
			LoginBtn.click();
			Thread.sleep(10000);

			driver.get("https://precise.radflow360.com/pi/case-update-and-collection");

			// Searching for Patient
			WebElement patientIdField = driver.findElement(By.xpath("(//input[@placeholder='PATIENT ID'])[1]"));
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

			// Generate RandomMail -- Starts

			int leftLimit = 97; // letter 'a'
			int rightLimit = 122; // letter 'z'
			int targetStringLength = 10;
			Random random = new Random();
			StringBuilder buffer = new StringBuilder(targetStringLength);
			for (int i = 0; i < targetStringLength; i++) {
				int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
				buffer.append((char) randomLimitedInt);
			}
			String generatedString = buffer.toString();
			String randomMailGenerated = generatedString + "@gmail.com";

			// ----------Generate Random Mail ends

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
			inputFile.sendKeys(
					System.getProperty("user.dir") + "\\uploadFiles\\demoTestupload\\PRE999999999999999_Tech_PSL.pdf");
			inputFile.sendKeys(
					System.getProperty("user.dir") + "\\uploadFiles\\demoTestupload\\PRE999999999999999_Rad_PSL.pdf");
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

				driver.get("https://front.com/");
				frontAppHomeWindow = driver.getWindowHandle();
				WebElement frontAppSignInBtn = driver.findElement(By.xpath("(//a[text()='Sign In'])[1]"));
				frontAppSignInBtn.click();

				WebElement signInWithGoogleBtn = driver.findElement(By.xpath("//button[text()='Sign in with Google']"));
				signInWithGoogleBtn.click();

				WebElement emailTextBox = driver.findElement(By.xpath("//input[@type='email']"));
				emailTextBox.sendKeys("dev@technobrains.io");

				WebElement nextButton1 = driver.findElement(By.id("identifierNext"));
				nextButton1.click();
				Thread.sleep(6000);

				WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
				passwordField.sendKeys("TechTBS#@^%*&*0147");

				WebElement nextBtn2 = driver.findElement(By.xpath("//span[text() = 'Next']"));
				nextBtn2.click();
				Thread.sleep(10000);

				// Thread.sleep(5000);
				WebElement sharedInboxesLink = driver.findElement(
						By.xpath("(//nav[@aria-label='Workspaces']/div[7]//div[text() = 'Shared inboxes'])[2]"));
				sharedInboxesLink.click();
				Thread.sleep(10000);
				// Thread.sleep(5000);

				// Selecting the mail from the inbox
				List<WebElement> mailSubjectList = driver
						.findElements(By.xpath("//div[contains(@class,'cellMiddle__StyledSubject')]/span"));
				for (WebElement e : mailSubjectList) {
					String subText = e.getText();
					if (subText.contains("TestDemo Rad PSL")) {
						e.click();
						deleteMsgFromFrontApp = true;
						break;
					}
				}

				Thread.sleep(2000);

				WebElement radflow360Plugin;

				// Clicking on the Plugin

				radflow360Plugin = driver
						.findElement(By.xpath("//div[text()='Radflow 360 Plugin']/preceding-sibling::div"));
				radflow360Plugin.click();
				Thread.sleep(30000); // Need 150000 Seconds
				// String frontAppMailPage = driver.getWindowHandle();

				// Clicking on the Send Mail to
				WebElement pluginFrame = driver.findElement(By.xpath("//iframe[@title='Radflow 360 Plugin']"));
				driver.switchTo().frame(pluginFrame);
				WebElement senFilesTo360Btn = driver.findElement(By.id("sendlien"));
				senFilesTo360Btn.click();

				Thread.sleep(30000); // Need 250000 Seconds

				Set<String> windowHandles2 = driver.getWindowHandles();

				// Switching to uploadReplyFrontPage

				for (String singleWindow : windowHandles2) {

					if (!singleWindow.equalsIgnoreCase(frontAppHomeWindow)
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
				List<WebElement> listOfFileName = driver
						.findElements(By.xpath("(//div[@class='user-table-block'])[2]//tbody/tr/td[1]/div/input"));

				for (int i = 0; i < listOfFileName.size(); i++) {
					if (listOfFileName.get(i).getAttribute("value").contains("rad_psl") && listOfFileName.get(i)
							.getAttribute("value").toLowerCase().contains(patientId.toLowerCase())) {
						listOfPatientIds.get(i).clear();
						listOfPatientIds.get(i).sendKeys(patientId);
						Select s1 = new Select(listOfDocTypes.get(i));
						s1.selectByVisibleText("RAD Patient Signed Lien");
					} else if (listOfFileName.get(i).getAttribute("value").contains("tech_psl") && listOfFileName.get(i)
							.getAttribute("value").toLowerCase().contains(patientId.toLowerCase())) {
						listOfPatientIds.get(i).clear();
						listOfPatientIds.get(i).sendKeys(patientId);
						Select s2 = new Select(listOfDocTypes.get(i));
						s2.selectByVisibleText("TECH Patient Signed Lien");
					}
				}

				for (int k = 0; k < listOfPatientIds.size(); k++) {
					String patientIdText = listOfPatientIds.get(k).getAttribute("value");
					Select selectDocType = new Select(listOfDocTypes.get(k));

					WebElement selectedDoc = selectDocType.getFirstSelectedOption();
					String selectedDocText = selectedDoc.getText();
					System.out.println(patientIdText + "   " + selectedDocText);

					if (patientIdText.trim().equalsIgnoreCase(patientId)
							&& (selectedDocText.trim().equalsIgnoreCase("TECH Patient Signed Lien")
									|| selectedDocText.trim().equalsIgnoreCase("RAD Patient Signed Lien"))) {
						// listOfCheckBoxes.get(k).click();
						System.out.println("Inside CheckBoxes");
						action.moveToElement(listOfCheckBoxes.get(k)).click(listOfCheckBoxes.get(k)).build().perform();
					}
				}

				// *************************
				/*
				 * WebElement fileNameCheckbox = driver
				 * .findElement(By.xpath("//input[@class='label-info check-box pointer']"));
				 * fileNameCheckbox.click();
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

			if (flag2) { // flag2
				driver.switchTo().window(preciseWindow);
				driver.get("https://precise.radflow360.com/pi/case-update-and-collection");

				// Deleting the Doc uploaded from Front to Precise
				WebElement patientIdField = driver.findElement(By.xpath("(//input[@placeholder='PATIENT ID'])[1]"));
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
						action.moveToElement(checkBoxesListtElement.get(i)).click().build().perform();
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

			if (flag && deleteMsgFromFrontApp) {
				driver.switchTo().window(frontAppHomeWindow);

				// Deleting the Mail from Front App

				WebElement threeDotsMenu = driver.findElement(
						By.xpath("(//div[contains(@class,'messageViewerMore_')]/div/div/div/div)[last()]"));
				threeDotsMenu.click();
				Thread.sleep(2000);
				WebElement DeleteMailBtn = driver
						.findElement(By.xpath("//div[contains(@class,'dropdownItemContent') and text() = 'Delete']"));
				DeleteMailBtn.click();
				Thread.sleep(2000);
				WebElement deleteConfirmBtn = driver
						.findElement(By.xpath("//div[contains(@class,'buttonContent_') and text() = 'Delete']"));
//				WebElement deleteConfirmBtn = driver
//				.findElement(By.xpath("//*[text() = 'Delete conversation']"));

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
