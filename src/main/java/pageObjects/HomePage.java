package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.Base;

public class HomePage extends Base {
WebDriver driver;

public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

//elements locator
By flightsOption = By.cssSelector("a[data-name='flights']");
By depAirportInput = By.xpath("//div[@id='s2id_location_from']//a[@class='select2-choice']");
By depAirportSelected = By.xpath("//div[contains(text(),'(DAL)')]");
By arrivAirportInput = By.xpath("//div[@id='s2id_location_to']//a");
By arrivAirportSelected = By.xpath("//div[contains(text(),'(LGA)')]");
By calendar = By.id("FlightsDateStart");
By calendarMonths = By.cssSelector("div[class='datepicker -bottom-left- -from-bottom-'] nav[class='datepicker--nav'] div[class='datepicker--nav-title']");
By monthTitle = By.xpath("//div[9]//nav[1]//div[2]");
By nextMonthBtn = By.xpath("//div[9]//nav[1]//div[3]//*[local-name()='svg']");
By cookies = By.cssSelector("button[class='cc-btn cc-dismiss']");
By currentCalendarDays = By.xpath("//div[@class='datepicker--cell datepicker--cell-day']");
By btnSearch = By.xpath("//div[@class='col-lg-1 col-sm-12 col-xs-12']//button[@class='btn-primary btn btn-block'][contains(text(),'Search')]");

//methods
public void selectFlightOption() {
	driver.findElement(cookies).click();
	driver.findElement(flightsOption).click();
}

public void selectDepartureAirport(String departureAirport) throws InterruptedException {
	WebElement da = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(depAirportInput));
	da.click();
	da.sendKeys(departureAirport);
	WebElement das = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(depAirportSelected));
	das.click();
	/*driver.findElement(depAirportInput).click();
	driver.findElement(depAirportInput).sendKeys(departureAirport);
	driver.findElement(depAirportSelected).click();*/
}

public void selectArrivalAirport(String arrivalAirport) throws InterruptedException {
	driver.findElement(arrivAirportInput).click();
	driver.findElement(arrivAirportInput).sendKeys(arrivalAirport);
	//adding an explicit wait for the results
	WebElement selectedAirport = new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfElementLocated(arrivAirportSelected));
	selectedAirport.click();
}

public void selectCalendarDate(String departureMonth, String departureDay) throws InterruptedException {
	driver.findElement(calendar).click();
	
	while(!driver.findElement(monthTitle).getText().contains(departureMonth)) {
		driver.findElement(nextMonthBtn).click();
	}
	
	
	//number of days in current month
			int days= driver.findElements(currentCalendarDays).size();
			for(int i=0; i < days; i++) {
				if(driver.findElements(currentCalendarDays).get(i).getText().equalsIgnoreCase("27")) {
					driver.findElements(currentCalendarDays).get(i).click();
					break;
				}
			}
	}

public void searchBtnClick() {
	driver.findElement(btnSearch).click();
}
}

