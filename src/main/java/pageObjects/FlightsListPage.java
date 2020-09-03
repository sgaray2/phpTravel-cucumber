package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class FlightsListPage {
WebDriver driver;

	public FlightsListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//elements
By bookBtn = By.xpath("//li[1]//div[1]//div[1]//div[2]//form[1]//div[2]//div[1]//button[1]");

//methods
public void bookNow() {
	//WebElement book= new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(bookBtn));
	driver.findElement(bookBtn).click();
}
}
