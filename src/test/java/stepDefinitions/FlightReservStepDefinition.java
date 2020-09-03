package stepDefinitions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.BookingDetailsPage;
import pageObjects.ConfirmationPage;
import pageObjects.FlightsListPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class FlightReservStepDefinition extends Base {
	WebDriver driver;
	HomePage home;
	FlightsListPage flight;
	SignInPage sign;
	ConfirmationPage confirmation;
	BookingDetailsPage bookingDetail;
	
	
	 @Given("^a user navigates to \"([^\"]*)\" home page$")
	    public void a_user_navigates_to_something_home_page(String url) {
		 driver=browserConfiguration(url);
	    }

	    @When("^user enters (.+) and select a departure airport from the suggested airports$")
	    public void user_enters_and_select_a_departure_airport_from_the_suggested_airports(String departureAirport) throws InterruptedException {
	      home = new HomePage(driver);
	      home.selectFlightOption();
	      home.selectDepartureAirport(departureAirport);
	    }
	    
	    @And("^user enters (.+) and select a arrival airport from the suggested airports$")
	    public void user_enters_and_select_a_arrival_airport_from_the_suggested_airports(String arrivalAirport) throws InterruptedException {
	        home.selectArrivalAirport(arrivalAirport);
	    }
	    
	    @And("^user select a future (.+) and (.+) for the current year$")
	    public void user_select_a_future_and_for_the_current_year(String departureMonth, String departureDay) throws InterruptedException {
	       home.selectCalendarDate(departureMonth,departureDay);
	    }
	    
	    @And("^user clicks on search button$")
	    public void user_clicks_on_search_button() {
	    	home.searchBtnClick();
	    }
	    
	    @And("^user selects a flight from the flights list$")
	    public void user_selects_a_flight_from_the_flights_list() {
	      flight= new FlightsListPage(driver);
	      flight.bookNow();
	    }
	    
	    @And("^user selects sign in option$")
	    public void user_selects_sign_in_option() {
	    	sign = new SignInPage(driver);
	    	sign.signInBtn();
	    }
	    
	    @And("^user enters the (.+) and (.+)$")
	    public void user_enters_EmailPwd(String email, String password) {
	        sign.enterEmail(email, password);
	    }
	    
	    @And("^user enters passenger (.+), (.+) and (.+)$")
	    public void user_enters_and(String name, String age, String passport) {
	        sign.enterPassengerData(name, age, passport);
	    }
	    
	    @And("^user clicks on confirm button$")
	    public void user_clicks_on_confirm_button() {
	        sign.confirmBooking();
	    }
	    
	    @And("^user clicks on pay on arrival button and confirm to pay on arrival$")
	    public void user_clicks_on_pay_on_arrival_button_and_confirm_to_pay_on_arrival() throws InterruptedException{
	        confirmation = new ConfirmationPage(driver);
	        confirmation.payOnArrival();
	    }
	    
	    @Then("^the user is redirected to the booking details and the message shown is (.+)$")
	    public void the_user_is_redirected_to_the_booking_details_and_the_message_shown_is(String expectedResult) {
	    	bookingDetail = new BookingDetailsPage(driver);
	    	String actualResult = bookingDetail.getConfirmationMessage();
	    	Assert.assertEquals(actualResult, expectedResult);
	    }
	    
	    @And("^the browser is closed$")
	    public void the_browser_is_closed() {
	    	driver.quit();
	    }
}
