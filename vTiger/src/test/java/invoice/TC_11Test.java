package invoice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import genericLibrary.ExcelLib;
import pomRepo.HomePage;
import pomRepo.LoginPage;
/***
 * 
 * @author Arpitha
 *
 */
public class TC_11Test extends BaseClass  {
	@Test
	public void delete_MultipleInvoiceDetails_FromListView() throws InterruptedException {
		
	//	WebDriver driver = new ChromeDriver();
	//	WebDriverWait explicitWait = new WebDriverWait(driver, 15);
		HomePage homePage =new HomePage(driver);
		
		homePage.getSelectCheckBox().click();
		homePage.getSelectCheckBox1().click();
		homePage.getSelectCheckBox2().click();
		
		homePage.getDelete().click();
		
		homePage.alert(driver);
		Thread.sleep(5000);
		
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")));
		
		


		
		
		
	}

}
