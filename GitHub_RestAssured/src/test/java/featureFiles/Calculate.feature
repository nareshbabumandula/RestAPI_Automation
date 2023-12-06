Feature: Arithmetic Operations

Background:
Given I launch calculator

@addition
Scenario: verify the functionality of addition
When i enter the value of a as 10
And i enter the value of b as 20
Then i perform addition to validate the sum as 40

@datatable
Scenario: verify the functionality of addition
When i have entered numbers into the calculator
|number1|number2|
|10|20|
And I peform addition
Then the result should be 30

@ddt
Scenario Outline: verify the functionality of addition
When i enter the value of a as <a>
And i enter the value of b as <b>
Then i perform addition to validate the sum as <c>
Examples:
|a|b|c|
|10|20|30|
|30|25|55|
|25|35|55|

@arithmetic
Scenario Outline: Arithmetic operations
When I have entered <number1> into the calculator
And I have entered <number2> into the calculator
When I perform <operation>
Then the result should be <result> on the screen
Examples:
|number1|number2|operation|result|
|10|20|addition|30|
|20|5|subtraction|15|
|100|20|multiplication|2000|
|40|20|division|2|
|50|10|modulus|0|

