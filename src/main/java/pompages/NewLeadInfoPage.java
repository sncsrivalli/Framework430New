package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLeadInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(name = "Duplicate")
	private WebElement duplicateButton;
	
	public NewLeadInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void clickDuplicateButton() {
		duplicateButton.click();
	}
}

