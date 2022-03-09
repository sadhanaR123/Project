package pomRepo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage1 {
	public HomePage1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="More")
	private WebElement moveOnMoreButton;

	@FindBy(linkText="Invoice")
	private WebElement clickOnInvoice;
	
	@FindBy(linkText="Motorola")
	private WebElement organization;
	

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getMoveOnMoreButton() {
		return moveOnMoreButton;
	}

	public WebElement getClickOnInvoice() {
		return clickOnInvoice;
	}
	@FindBy(xpath="(//input[@name='selected_id'])[1]")
	private WebElement selectCheckBox;

	@FindBy(xpath="(//input[@name='selected_id'])[2]")
	private WebElement selectCheckBox1;

	@FindBy(xpath="(//input[@name='selected_id'])[3]")
	private WebElement selectCheckBox2;

	@FindBy(xpath="//input[@value='Mass Edit']")
	private WebElement massEdit;

	@FindBy(name="subject")
	private WebElement subject;

	@FindBy(xpath="(//img[@title=\"Select\"])[2]")
	private WebElement plus1;

	@FindBy(xpath="//a[text()='X-CEED INC 99']")
	private WebElement select;

	@FindBy(xpath="(//input[@type=\"submit\"])[2]")
	private WebElement save;

	@FindBy(xpath="//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")
	private WebElement adminstrator;
	
	@FindBy(name="invoicestatus")
	private WebElement dropDown;
	

	public WebElement getDropDown() {
		return dropDown;
	}
	@FindBy(linkText ="Sign Out")
	private WebElement signout;

	public WebElement getAdminstrator() {
		return adminstrator;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getPlus1() {
		return plus1;
	}

	public WebElement getSelect() {
		return select;
	}

	public WebElement getMassEdit() {
		return massEdit;
	}

	public WebElement getSubject() {
		return subject;
	}

	public WebElement getMassedit() {
		return massEdit;
	}

	public WebElement getSelectCheckBox() {
		return selectCheckBox;
	}

	public WebElement getSelectCheckBox1() {
		return selectCheckBox1;
	}

	public WebElement getSelectCheckBox2() {
		return selectCheckBox2;
	}


	public void popup(WebDriver driver)  {
		Actions actions = new Actions(driver);
		actions.moveToElement(moveOnMoreButton).perform();


	}
	public void alert(WebDriver driver) {

		Alert prompt = driver.switchTo().alert();
		prompt.accept();

	}
	
	public void actions(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(adminstrator).perform();
	}
	
	public void dropDown() {
		Select select = new Select(dropDown);
		select.selectByVisibleText("Sent");
	}



}
