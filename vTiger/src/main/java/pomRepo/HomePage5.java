package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage5 {
	public HomePage5(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getSignout() {
		return signout;
	}
	@FindBy(linkText="More")
	private WebElement moveOnMoreButton;

	@FindBy(linkText="Invoice")
	private WebElement clickOnInvoice;
	
	@FindBy(xpath="//img[@title='Create Invoice...']")
	private WebElement createInvoice;
	
	@FindBy(xpath="//input[@class=\"crmbutton small cancel\"][1]")
	private WebElement cancel;
	
	@FindBy(linkText ="Sign Out")
	private WebElement signout;
	
	@FindBy(xpath="//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")
	private WebElement adminstrator;

	public WebElement getMoveOnMoreButton() {
		return moveOnMoreButton;
	}

	public WebElement getAdminstrator() {
		return adminstrator;
	}
	public WebElement getClickOnInvoice() {
		return clickOnInvoice;
	}

	public WebElement getCreateInvoice() {
		return createInvoice;
	}

	public WebElement getCancel() {
		return cancel;
	}
	
	public void popup(WebDriver driver)  {
		Actions actions = new Actions(driver);
		actions.moveToElement(moveOnMoreButton).perform();


	}
	public void actions(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(adminstrator).perform();
	}
	
}
