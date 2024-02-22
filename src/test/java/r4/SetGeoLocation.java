package r4;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SetGeoLocation {

	@Test
	public void getGeo() {
		
		ChromeDriver driver = new ChromeDriver();
		
		Map coordinates = Map.of(
                "latitude", 30.3079823,
                "longitude", -97.893803,
                "accuracy", 1
        );
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://oldnavy.gap.com/stores");
		
		
		
	}
}
