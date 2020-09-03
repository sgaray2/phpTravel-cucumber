Feature: flight reservation.
	This feature deals with the flight reservation funcionality.

Scenario Outline: search a flight with the correct information and reach the reservation confirmation page. 
Given a user navigates to "https://www.phptravels.net/home" home page
When user enters <departureAirport> and select a departure airport from the suggested airports
And user enters <arrivalAirport> and select a arrival airport from the suggested airports
And user select a future <departureMonth> and <departureDay> for the current year
And user clicks on search button
And user selects a flight from the flights list
And user selects sign in option
And user enters the <email> and <password>
And user enters passenger <name>, <age> and <passport>
And user clicks on confirm button
And user clicks on pay on arrival button and confirm to pay on arrival
Then the user is redirected to the booking details and the message shown is <SuccessReservMessage> 
And the browser is closed

Examples:
| departureAirport | arrivalAirport | departureMonth | departureDay |        email        | password |      name     | age| passport  | SuccessReservMessage            |
|      Dallas      |    New York    |     October    |      27      | user@phptravels.com | demouser | Sabrina Garay | 31 | FH3344631 | Your booking status is Reserved |
