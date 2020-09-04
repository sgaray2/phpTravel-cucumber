### PHPTravel demo - Automation Project

#### Introduction
PHP Travel is a demo website that offers the possibility to book hotels, flights, trips. This demo allows any beginner in automation to work with dropdowns, inputs, radio button, calendars, alerts and use different element locators.

The test case automated is the following:
E2E test case to search a flight with specific data provided through the feature file, the test case checks that the reservation was succesfully.

*IDE:
Eclipse

*Test automation framework:
Selenium.

*Selenium tool:
Selenium WebDriver.

*Programming language:
Java.

*Type of Framework:
I implemented BDD framework using Cucumber. 
Inside src/test/java I have 3 packages: features, cucumberOptions and stepDefinitions.
*Features: to store the features file, basically the scenarios to test in a natural language. Inside this feature file I provide through a table the data I want to use in my test case.
*CucumberOptions: where I have the testRunner for that particular feature.
*StepDefinitions: where I have defined the methods for every step in the feature file. 

-I also implemented the page object model design pattern, as per Page Object Model, I have maintained a separate class for every webpage. Each webpage has a separate class and these class holds all the elements locators and methods with the actions on this elements.

*Maven:
Using Maven for build, execution, and dependency purpose. I defined a standardized maven project, with to folders: all the tests are kept under src/test/java and all the other remaining files are kept under src/main/java (Base class, element locators (POM classes)).

src/main/java 
*Test Base Class: to initialize the driver, browser configurations. 
*PageObjects: elements locators, one class for every page.

src/test/java: 
Packages: features, cucumberOptions and stepDefinitions.

*Testing Framework:
Using TestNG for Assertions, Grouping, and Parallel execution.

*Version Control:
GIT.
