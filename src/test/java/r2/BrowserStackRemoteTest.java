package r2;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//my import below
import org.openqa.selenium.remote.LocalFileDetector;


// BrowserStack Implementation
// Reference Site: https://www.browserstack.com/docs/automate/selenium/select-browsers-and-devices
// https://www.browserstack.com/automate/capabilities
public class BrowserStackRemoteTest {
	public WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@SuppressWarnings("unchecked")
	public void setUp() throws Exception {
		/*
		 * MutableCapabilities capabilities = new MutableCapabilities(); ChromeOptions
		 * options = new ChromeOptions(); options.setExperimentalOption("prefs",
		 * "{\"plugins.always_open_pdf_externally\": true}");
		 * capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		 * HashMap<String, String> bstackOptionsMap = new HashMap<String, String>();
		 * bstackOptionsMap.put("source", "testng:archetype-setup:v1.5");
		 * capabilities.setCapability("bstack:options", bstackOptionsMap); //driver =
		 * new RemoteWebDriver(new URL(
		 * "http://ximoy_I8SPgy:GcrMkuj1k9gMHUudFYeM@hub-cloud.browserstack.com/wd/hub")
		 * , capabilities); driver = new RemoteWebDriver(new URL(
		 * "http://rachitpatel_vfysmR:ZRdcwbsiA6eYqhDjE94J@hub-cloud.browserstack.com/wd/hub"
		 * ), capabilities); driver.manage().window().maximize();
		 */
		MutableCapabilities capabilities = new MutableCapabilities();
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("plugins.always_open_pdf_externally", true);
		options.setExperimentalOption("prefs", prefs);

		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		// other capability declarations
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "latest");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "10");
		capabilities.setCapability("bstack:options", browserstackOptions);
		final String URL = "https://rachitpatel_vfysmRdferregr:ZRdcwrrbssxsiA6erreYgrereqhDjE94J@hub-cloud.browserstack.com/wd/hub";
		driver = new RemoteWebDriver(new URL(URL), capabilities);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}
}
