package seleniumdownoad;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.FluentWait;

public class FileDownload {

	static String downloadPath = System.getProperty("user.dir") + "\\src\\test\\resources\\downloads";
	static String fileName = "jenkins.msi";
	static WebDriver driver;
	static File file = new File(downloadPath, fileName);

	public static void deleteFilesInDirectory(File file) {
		// store all the paths of files and folders present
		// inside directory
		for (File subfile : file.listFiles()) {

			// if it is a subfolder,e.g Rohan and Ritik,
			// recursively call function to empty subfolder
			if (subfile.isDirectory()) {
				deleteFilesInDirectory(subfile);
			}

			// delete files and empty subfolders
			subfile.delete();

		}
		// file.delete(); //-- To delete the Folder
	}

	public static void waitForDownload() {
		FluentWait<File> wait = new FluentWait<File>(file).withTimeout(Duration.ofMinutes(5))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class).withMessage("file is not downloaded");

		boolean isDownloaded = wait.until(f -> f.exists() && f.canRead());

		if (isDownloaded) {
			System.out.println("file is downloaded completely");
		} else {
			System.out.println("file is not downloaded");
		}
	}

	public static void waitForFileDownloaded(String fileName, int timeoutMin) {
		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(timeoutMin))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

		boolean isDownload = wait.until((x) -> {
			File[] files = new File(downloadPath).listFiles();
			for (File file : files) {
				if (file.getName().contains(fileName)) {
					return true;
				}

			}
			return false;

		});

		if (isDownload) {
			System.out.println("file is downloaded completely");
		} else {
			System.out.println("file is not downloaded");
		}
	}

	public static void waitDownloadByLoop(String fileNameSubString, int timeOutSeconds) throws InterruptedException {
		int count = 0;
		boolean b = false;
		OuterLoop:
		while (count < timeOutSeconds) {
			count++;
			Thread.sleep(1000);
/////////////////**********************////////////////////
			File[] files = new File(downloadPath).listFiles();
			
			for (File file : files) {
				System.out.println("Inside loop for: "+count);
				if (file.getName().contains(fileNameSubString)) {
					b = true;
					break OuterLoop;
				}
			}
			
////////////////*******************************/////////////////			
//			File f = new File(downloadPath, fileName);
//			if (f.exists()) {
//				b = true;
//				break;
//			}
		}

		if (b) {
			System.out.println("file is downloaded completely");
		} else {
			System.out.println("file is not downloaded");
		}

	}

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("download.default_directory", downloadPath);
		chromePrefs.put("download.prompt_for_download", false);
		chromePrefs.put("safebrowsing.enabled", true); // this will allow to download without safe browsing
		options.setExperimentalOption("prefs", chromePrefs);
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		// options.addArguments("--safebrowsing-disable-download-protection");
		// options.add_argument("disable-infobars");
		// options.add_argument("--disable-extensions");

		deleteFilesInDirectory(new File(downloadPath));
		driver = new ChromeDriver(options);
		driver.get("https://get.jenkins.io/windows-stable/2.426.1/jenkins.msi");
		Thread.sleep(3000);

		// waitForDownload();
		// waitForFileDownloaded("kin", 5);
		waitDownloadByLoop("msi", 300);

	}

}
