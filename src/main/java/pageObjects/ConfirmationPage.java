package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

//elements
By payOnArrivalBtn = By.cssSelector("button[class='btn btn-default arrivalpay']");

//methods
public void payOnArrival() throws InterruptedException {
	driver.findElement(payOnArrivalBtn).click();
	
	//accepting alert
	Thread.sleep(2000);
	Alert payLaterAlert = driver.switchTo().alert();
	payLaterAlert.accept();
}
}
