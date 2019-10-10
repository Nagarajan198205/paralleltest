package hybridcloud.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	private final WebDriverWait wait;

	@FindBy(how = How.NAME, using = "q")
	public WebElement txtSearch;

	@FindBy(className = "rc")
	private List<WebElement> searchResults;

	@FindBy(id = "foot")
	private WebElement footer;

	public SearchPage(final WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
	}

	public void searchFor(String text) throws InterruptedException {
		this.txtSearch.sendKeys(text);
		this.txtSearch.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("rc")));
	}

	public List<WebElement> getResults() {
		return this.searchResults;
	}
}
