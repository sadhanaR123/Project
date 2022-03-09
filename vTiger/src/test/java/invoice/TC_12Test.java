package invoice;

import java.util.Set;
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
import pomRepo.HomePage1;
import pomRepo.LoginPage;

public class TC_12Test extends BaseClass {
	@Test
	public void MassEdit_MultipleInvoiceDetails()  {
		String testURL = ExcelLib.readStringData("Sheet3", 0, 0);
		String username = ExcelLib.readStringData("Sheet3", 0, 1);
		String password = ExcelLib.readStringData("Sheet3", 0, 2);
		String expectedLoginPageTitle=ExcelLib.readStringData("Sheet3", 0, 3);
		String expectedHomePageTitle=ExcelLib.readStringData("Sheet3", 0, 4);
		String name = ExcelLib.readStringData("Sheet3", 1, 0);
		String expectedUrl=ExcelLib.readStringData("Sheet3", 2, 0);
	//	String expectedHomePageUrl =ExcelLib.readStringData("Sheet3", 3, 0);
		String expectedUrlOrg = ExcelLib.readStringData("Sheet3", 6, 0);
		
		HomePage1 homePage = new HomePage1(driver);
		
		homePage.getSelectCheckBox().click();
		homePage.getSelectCheckBox1().click();
		homePage.getSelectCheckBox2().click();
		
		homePage.getMassedit().click();
		homePage.getSubject().sendKeys(name);
		homePage.getPlus1().click();
		
		String expectedParentPage1 = driver.getWindowHandle();
		Set<String> allWinID1 = driver.getWindowHandles();
		
		for(String s:allWinID1)
		{
			driver.switchTo().window(s);
			String actualUrlOrg = driver.getCurrentUrl();
			if(expectedUrlOrg.equals(actualUrlOrg))
			{
				homePage.getOrganization().click();
				homePage.alert(driver);
		    }
		}
		driver.switchTo().window(expectedParentPage1);
		
		homePage.dropDown();
		
		String expectedParentPage = driver.getWindowHandle();
		Set<String> allWinID = driver.getWindowHandles();
		
		for(String s:allWinID)
		{
			driver.switchTo().window(s);
			String actualUrl = driver.getCurrentUrl();
			if(expectedUrl.equals(actualUrl))
			{
				homePage.getSelect().click();
				homePage.alert(driver);
		    }
		}
		driver.switchTo().window(expectedParentPage);
		homePage.getSave().click();
		
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")));
		
		
	}
	
}
