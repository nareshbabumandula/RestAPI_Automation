Feature: Repository Creation

Scenario: Verify the functionality of creating a repository in Github
Given I login into Github portal
When I create a repository on GitHub
Then I can see the project created

@smoke
Scenario Outline: Verify the functionality of creating a repository in Github
Given I login into Github portal
When I create a repository on GitHub with name "<Repo>"
Then I can see the project created with name "<Repo>"
Examples:
|Repo|
|TestRepo125|
|TestRepo126|