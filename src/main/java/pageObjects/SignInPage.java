package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
WebDriver driver;

public SignInPage(WebDriver driver) {
  this.driver=driver;
  PageFactory.initElements(driver, this);
} 

//elements
By signInBtn = By.xpath("//a[@id='signintab']");
By email = By.cssSelector("input[name='username']");
By pwd = By.cssSelector("input[name='password']");
By passengerName = By.cssSelector("input[id='passenger_name_0']");
By passengerAge = By.cssSelector("input[id='passenger_age_0']");
By passengerPassport = By.cssSelector("input[id='passenger_passport_0']");
By confirmBookingBtn = By.cssSelector("button[name='login']");

//methods
public void signInBtn() {
	driver.findElement(signInBtn).click();
}

public void enterEmail(String userEmail, String password) {
	WebElement em = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(email));
	em.sendKeys(userEmail);
	driver.findElement(pwd).sendKeys(password);
}

public void enterPassengerData(String name, String age, String passport) {
	driver.findElement(passengerName).sendKeys(name);
	driver.findElement(passengerAge).sendKeys(age);
	driver.findElement(passengerPassport).sendKeys(passport);
}

public void confirmBooking() {
	driver.findElement(confirmBookingBtn).click();
}
}
