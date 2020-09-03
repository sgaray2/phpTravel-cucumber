package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingDetailsPage {
	WebDriver driver;
	
	public BookingDetailsPage(WebDriver driver) {
		this.driver=driver;
	}

//elements
By confirmationMessage = By.xpath("//h4[contains(text(),'Your booking status is Reserved')]");

//methods
public String getConfirmationMessage() {
	String actualResult = driver.findElement(confirmationMessage).getText();
	return actualResult;
}
}
