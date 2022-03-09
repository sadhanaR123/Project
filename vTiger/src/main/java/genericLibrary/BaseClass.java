package genericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pomRepo.HomePage;
import pomRepo.HomePage1;
import pomRepo.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public WebDriverWait explicitWait;
	public HomePage homePage;
	
	String testURL = ExcelLib.readStringData("Sheet3", 0, 0);
	String username = ExcelLib.readStringData("Sheet3", 0, 1);
	String password = ExcelLib.readStringData("Sheet3", 0, 2);
	String expectedLoginPageTitle=ExcelLib.readStringData("Sheet3", 0, 3);
	String expectedHomePageTitle=ExcelLib.readStringData("Sheet3", 0, 4);
	String expectedInvoicePageUrl=ExcelLib.readStringData("Sheet3", 0, 5);
	
	
	@Parameters("browserName")
	@BeforeClass(alwaysRun=true)
	public void beforeClass(@Optional("chrome") String bName) {
		if(bName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();

		}else if(bName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/chromedriver.exe");
			driver =  new FirefoxDriver();

		}else {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		Reporter.log("Browser is launched Succesfully", true);
		driver.manage().window().maximize();
		Reporter.log("Browser is maximized Succesfully", true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver,20);
	}

	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() {
		driver.get(testURL);
		
		Assert.assertEquals(driver.getTitle(),expectedLoginPageTitle,"Login Page is not displayed Succesfully");
		Reporter.log("Login Page is displayed succesfully", true);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LoginToApp(username,password);
		
		explicitWait.until(ExpectedConditions.titleIs(expectedHomePageTitle));
		Assert.assertEquals(driver.getTitle(),expectedHomePageTitle,"Home Page was failed");
		Reporter.log("Succesfully logged in to the application", true);
		
		HomePage homePage = new HomePage(driver);
		homePage.action(driver);
		Actions action = new Actions(driver);
		action.moveToElement(homePage.getMoveOnMoreButton()).perform();
		homePage.getClickOnInvoice().click();
		
		Assert.assertEquals(driver.getCurrentUrl(),expectedInvoicePageUrl,"Invoice Page is not displayed Succesfully");
		Reporter.log("Invoice Page is displayed Succesfully", true);
		
	}
	@AfterMethod (alwaysRun=true)
	public void afterMethod() {
		HomePage1 homePage = new HomePage1(driver);
		Actions actions = new Actions(driver);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")));
		actions.moveToElement(homePage.getAdminstrator()).perform();
		homePage.getSignout().click();
		Assert.assertEquals(driver.getTitle(),expectedLoginPageTitle,"Not logged out succesfully");
		Reporter.log("Succesfully logout", true);
		
		
		
	}
	@AfterClass (alwaysRun=true)
	public void afterClass() {
			driver.close();	
	}


}



