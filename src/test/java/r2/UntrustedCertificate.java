package r2;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class UntrustedCertificate {

	public static void main(String[] args) {
// Chrome Browser
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		WebDriver driver = new ChromeDriver(options);
		driver.navigate().to("https://www.cacert.org/");

// Firefox Browser
		FirefoxOptions fo = new FirefoxOptions();
		fo.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		WebDriver driver1 = new FirefoxDriver(fo);
		driver1.get("https://www.cacert.org/");
	}

	
}
