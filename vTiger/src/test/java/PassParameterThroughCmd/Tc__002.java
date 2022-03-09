package PassParameterThroughCmd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Tc__002 {
		@Parameters("dataFromXml")
		@Test(groups="smokeTest")
		public void createLoan(@Optional("https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html") String Url) {
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.dell.com/");
			String newUrl = System.getProperty("dataFromXml");
			driver.get(Url);
			System.out.println(System.getProperty("data"));
			driver.quit();
			
		}
}
