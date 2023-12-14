Feature: MyConctactForm homepage verification

Background:
Given I access MCF portal

@smoke
Scenario: Verify the functionality of accessing the mycontactform online portal
Then I should see the MCF login page


Scenario: Verify the functionality of SIGN UP
When I click on FREE ACCOUNT SIGNUP! button
And I enter Name in the Name text field
And I enter any valid email address in E-mail Address field
And I enter user name in User Name field
And I enter password in Password field
And re-enter the password in Re-type Password field
And I select the Terms of Service & Privacy Statement checkbox
And I click on Submit button
Then I should see a registration confirmation message


Scenario Outline: Verify the functionality of SIGN UP
When I click on FREE ACCOUNT SIGNUP! button
And I enter Name in the Name text field
And I enter any valid "<email>" address in E-mail Address field
And I enter user name in User Name field
And I enter password in Password field
And re-enter the password in Re-type Password field
And I select the Terms of Service & Privacy Statement checkbox
And I click on Submit button
Then I should see a registration confirmation message
Examples:
|email|
|suma@gmail.com|
|nikhila@yahoomail.com|




