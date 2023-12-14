Feature: Basic Contact Form verification

Background:
Given I access MCF portal

@dryrun
Scenario Outline: Verify the functionality of submitting the basic contact form
When I click on Sample Forms tab
And I navigate to Basic Contact Form page from left navigation
And I enter "<name>" in the name text field
And I enter "<email>" in the email address field
And I enter "<message>" in the message description field
And I click on Submit button in basic contact for page
Then I should see the confirmation message
Examples:
|name|email|message|
|suma|suma@gmail.com|test message|
|nikhila|nikhila@yahoomail.com|auto test message|
|john|johnson@hotmail.com|test auto message|

