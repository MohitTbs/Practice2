package r1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDownloadShadowDom {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("chrome://downloads/");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement searchBox = (WebElement) jse.executeScript("return document.querySelector(\"downloads-manager\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")");
		
		jse.executeScript("document.querySelector(\"downloads-manager\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#prompt\").remove()");
		//jse.executeScript("arguments[0].setAttribute('value','')", searchBox);
		jse.executeScript("arguments[0].value='NOFUj'", searchBox);
	}

}
