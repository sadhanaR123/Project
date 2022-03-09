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
import pomRepo.HomePage4;
import pomRepo.LoginPage;

public class TC_14Test extends BaseClass {
	@Test
	public void createInvoiceWith_InvalidSalesComission() throws InterruptedException  {
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
		String shippingAdress = ExcelLib.readStringData("Sheet3", 9, 0);
		String billingAdress = ExcelLib.readStringData("Sheet3", 9, 1);
		String customerNo = ExcelLib.readStringData("Sheet3", 9, 2);
		double salesComm =  ExcelLib.readNumberData("Sheet3", 9, 3);
		double qty = ExcelLib.readNumberData("Sheet3", 9, 4);
		
		HomePage4 homePage = new HomePage4(driver);
		
		homePage.getCreateInvoice().click();
		homePage.getSubject().sendKeys(subject);
		
		homePage.getCustNo().sendKeys(customerNo);
		
		homePage.getSalesComm().sendKeys(""+salesComm);
		
		
		homePage.getSelectPlusContactName().click();
		
		String expectedParentPage = driver.getWindowHandle();
		Set<String> allWinID = driver.getWindowHandles();
		
		for(String s:allWinID)
		{
			driver.switchTo().window(s);
			String actualUrl = driver.getCurrentUrl();
			if(expectedUrl.equals(actualUrl))
			{
				explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("Dipankar Deb")));
				homePage.getContactName().click();
				homePage.alert(driver);
		    }
		}
		driver.switchTo().window(expectedParentPage);
		
		homePage.getSelectPlusOrganization().click();
		
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
				
		homePage.scroll(driver);
		homePage.getSelectItemIcon().click();
		
		String expectedParentPage2 = driver.getWindowHandle();
		Set<String> allWinID2 = driver.getWindowHandles();
		
		homePage. getSelectItemIcon().click();
		for(String s:allWinID2)
		{
			driver.switchTo().window(s);
			String actualUrlItem = driver.getCurrentUrl();
			if(expectedUrlItem.equals(actualUrlItem))
			{
				explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("Moto1")));
				homePage.getItemProduct().click();
				
				
		    }
		}
		
		driver.switchTo().window(expectedParentPage2);
		
		
		homePage.getQty().sendKeys(""+qty);
		
		homePage.getSave().click();
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")));
		
		
		
		
	}
}
