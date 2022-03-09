package invoice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import genericLibrary.ExcelLib;
import pomRepo.HomePage;
import pomRepo.HomePage5;
import pomRepo.LoginPage;

public class TC_15Test extends BaseClass {
	@Test
	public void check_cancel_functionality() throws InterruptedException  {
		String testURL = ExcelLib.readStringData("Sheet3", 0, 0);
		String username = ExcelLib.readStringData("Sheet3", 0, 1);
		String password = ExcelLib.readStringData("Sheet3", 0, 2);
		String expectedLoginPageTitle=ExcelLib.readStringData("Sheet3", 0, 3);
		String expectedHomePageTitle=ExcelLib.readStringData("Sheet3", 0, 4);
		String expectedUrl=ExcelLib.readStringData("Sheet3", 5, 0);
		String subject = ExcelLib.readStringData("Sheet3", 4, 0);
		//CharSequence[] qty=ExcelLib.readNumberData("Sheet3", 4, 1);
		String expectedUrlOrg = ExcelLib.readStringData("Sheet3", 6, 0);
		String expectedUrlItem= ExcelLib.readStringData("Sheet3", 7, 0);
		
		HomePage5 homePage = new HomePage5(driver);
		homePage.getCreateInvoice().click();
		homePage.getCancel().click();
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")));
		
}
}
