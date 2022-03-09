package pomRepo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage4 {
	public HomePage4(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='subject']")
	private WebElement subject;
	
	public WebElement getSubject() {
		return subject;
	}
	@FindBy(linkText="More")
	private WebElement moveOnMoreButton;

	@FindBy(linkText="Invoice")
	private WebElement clickOnInvoice;
	
	@FindBy(xpath="//img[@title='Create Invoice...']")
	private WebElement createInvoice;
	
	@FindBy(className="bill_street")
	private WebElement billing;
	
	@FindBy(className="ship_street")
	private WebElement shipping;
	
	@FindBy(linkText ="Sign Out")
	private WebElement signout;
	
	@FindBy(id="customerno")
	private WebElement custNo;
	
	@FindBy(id="salescommission")
	private WebElement salesComm;
	
	@FindBy(linkText="Dipankar Deb")
	private WebElement contactName;
	
	@FindBy(linkText="Motorola")
	private WebElement organization;
	
	@FindBy(xpath="(//img[@title='Select'])[2]")
	private WebElement selectPlusContactName;
	
	@FindBy(id="searchIcon1")
	private WebElement selectItemIcon;
	
	@FindBy(id="qty1")
	private WebElement qty;
	
	@FindBy(xpath="(//input[@type='submit'])[2]")
	private WebElement save;
	
	@FindBy(xpath="//td[@onmouseout=\\\\\\\"fnHideDrop('ondemand_sub');\\\\\\\"]")
	private WebElement adminstrator;
	
	
	public WebElement getAdminstrator() {
		return adminstrator;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getQty() {
		return qty;
	}

	public WebElement getSelectItemIcon() {
		return selectItemIcon;
	}

	public WebElement getSelectPlusContactName() {
		return selectPlusContactName;
	}
	@FindBy(linkText="Moto1")
	private WebElement itemProduct;
	
	@FindBy(xpath="(//img[@title='Select'])[3]")
	private WebElement selectPlusOrganization;

	public WebElement getSelectPlusOrganization() {
		return selectPlusOrganization;
	}

	public WebElement getMoveOnMoreButton() {
		return moveOnMoreButton;
	}

	public WebElement getClickOnInvoice() {
		return clickOnInvoice;
	}

	public WebElement getCreateInvoice() {
		return createInvoice;
	}

	public WebElement getBilling() {
		return billing;
	}

	public WebElement getShipping() {
		return shipping;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getCustNo() {
		return custNo;
	}

	public WebElement getSalesComm() {
		return salesComm;
	}

	public WebElement getContactName() {
		return contactName;
	}

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getItemProduct() {
		return itemProduct;
	}
	
	public void popup(WebDriver driver)  {
		Actions actions = new Actions(driver);
		actions.moveToElement(moveOnMoreButton).perform();


	}
	public void alert(WebDriver driver) {

		Alert prompt = driver.switchTo().alert();
		prompt.accept();

	}
	public void scroll(WebDriver driver) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000);");
	}
	public void scroll1(WebDriver driver) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);");
	}
	public void actions(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(adminstrator).perform();
	}
	
}
