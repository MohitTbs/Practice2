package r1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVG {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://13.58.75.61/login");
		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("bhavik");
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("tbs@67789");
		driver.findElement(By.xpath("//button//span[normalize-space(text()) = 'Log In']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[@href='dashboard/MonthlyRecurringRevenue']")).click();
		Thread.sleep(5000);
	
		WebElement graph = driver.findElement(By.xpath("(((//*[name()='svg'])[2]//*[local-name()='g'])[5]//*[local-name()='g'])[1]"));
		
		////div[@class='loader']
		int xAxis =(graph.getSize().getWidth())/2 - graph.getSize().getWidth();
		int yAxis =(graph.getSize().getHeight())/2 - graph.getSize().getHeight()+100;
		
		Actions act = new Actions(driver);
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", graph);
		act.moveToElement(graph).perform();
		act.moveToElement(graph).perform();
		WebElement pointer = driver.findElement(By.xpath("(((//*[name()='svg'])[2]//*[local-name()='g'])[5]//*[local-name()='g'])[2]"));
		for(int j=0;j<=graph.getSize().getWidth();j=j+57)
		{
			
			act.moveToElement(graph, xAxis+j, yAxis).perform();
			//System.out.println(j);
			String text = driver.findElement(By.xpath("//div[contains(@class,'highcharts-label')]/span")).getText();
			System.out.println(text);
		}
		
	}

	
	
}
