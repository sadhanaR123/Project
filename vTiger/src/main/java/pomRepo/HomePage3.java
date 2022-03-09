package pomRepo;

import java.awt.Window;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage3 {
	public HomePage3(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="More")
	private WebElement moveOnMoreButton;

	@FindBy(linkText="Invoice")
	private WebElement clickOnInvoice;
	
	@FindBy(xpath="//img[@title='Create Invoice...']")
	private WebElement createInvoice;
	
	@FindBy(xpath="//input[@name='subject']")
	private WebElement subject;
	
	@FindBy(xpath="(//img[@title='Select'])[3]")
	private WebElement selectPlusOrganization;
	
	@FindBy(xpath="(//img[@title='Select'])[2]")
	private WebElement selectPlusContactName;
	

	@FindBy(linkText="Dipankar Deb")
	private WebElement contactName;
	
	public WebElement getContactName() {
		return contactName;
	}
	public WebElement getOrganization() {
		return organization;
	}
	@FindBy(linkText="Motorola")
	private WebElement organization;
	
	@FindBy(linkText="Vtiger 10 Users Pack")
	private WebElement selectItemName;
	
	@FindBy(linkText ="Sign Out")
	private WebElement signout;

	
	public WebElement getSignout() {
		return signout;
	}
	public WebElement getSelectItemIcon() {
		return selectItemIcon;
	}
	@FindBy(linkText="Patricia Johnson")
	private WebElement selectContactName;
	
	@FindBy(id="searchIcon1")
	private WebElement selectItemIcon;
	
	

	@FindBy(id="qty1")
	private WebElement qty;
	
	@FindBy(xpath="(//input[@type='submit'])[2]")
	private WebElement save;

	@FindBy(linkText="Moto1")
	private WebElement itemProduct;
	
	@FindBy(xpath="//td[@onmouseout=\\\\\\\"fnHideDrop('ondemand_sub');\\\\\\\"]")
	private WebElement adminstrator;
	
	
	public WebElement getAdminstrator() {
		return adminstrator;
	}
	public WebElement getItemProduct() {
		return itemProduct;
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
	public WebElement getSubject() {
		return subject;
	}
	public WebElement getSelectPlusOrganization() {
		return selectPlusOrganization;
	}
	public WebElement getSelectPlusContactName() {
		return selectPlusContactName;
	}
	
	public WebElement getSelectContactName() {
		return selectContactName;
	}
	public WebElement getSelectItemName() {
		return selectItemName;
	}
	public WebElement getQty() {
		return qty;
	}
	public WebElement getSave() {
		return save;
	}
	public void popup(WebDriver driver)  {
		Actions actions = new Actions(driver);
		actions.moveToElement(moveOnMoreButton).perform();


	}
	public void actions(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(adminstrator).perform();
	}
	public void alert(WebDriver driver) {

		Alert prompt = driver.switchTo().alert();
		prompt.accept();

	}
	public void scroll(WebDriver driver) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000);");
	}
	
	

}
