package r3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.Request;
import org.openqa.selenium.devtools.v120.network.model.Response;


public class NetworkLogsDevTools {

	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		String Partialpath = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\";
		FileWriter writer = new FileWriter(new File(Partialpath + "writtenfile.txt"), true);

		StringBuilder sb = new StringBuilder();
		
		

		devTools.addListener(Network.requestWillBeSent(), request -> {

			Request req = request.getRequest();
			// System.out.println("Req: "+req.getUrl());

		});

		// Event will get fired-
		devTools.addListener(Network.responseReceived(), response -> {
			Response res = response.getResponse();
			int status = res.getStatus();
			String url = res.getUrl();
		
			String currentUrl = driver.getCurrentUrl();
			System.out.println("Res: " + status + " " + url);
			
			if(currentUrl.equalsIgnoreCase("https://apps.timeclockwizard.com/"))
			{
			sb.append("Res: " + status + " " + url);
			sb.append("\n");
			}
			
			

		});

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://apps.timeclockwizard.com/Login?subDomain=qcqae");
		driver.findElement(By.cssSelector("#UserName")).sendKeys("sa");
		driver.findElement(By.cssSelector("#Password")).sendKeys("123456");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[value='LogIn']")).click();
	
		Thread.sleep(10000);

		driver.quit();
		System.out.println("driver was quit");
		
		writer.write(sb.toString());
		writer.close();
		System.out.println("File Written");
		
	}

}
