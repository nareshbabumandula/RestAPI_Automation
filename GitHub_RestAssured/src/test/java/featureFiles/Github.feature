Feature: Validate Github API

@retrieve
Scenario Outline: Validate Github GET API

Given Github API exists
When Github GET API is called for the id <Project>
Then Verify the status code is "<statusCode>"

Examples: 
|Test case description |Project				      |statusCode|
|Valid id 		   	   |TestProject888  		  |200	     |
|Invalid id 		   |TestProject5537           |404	     |
 

@create
Scenario Outline: Validate Github POST API
Given Github POST API exists
When Github POST API is called with the name <Project>
Then Verify the status code is "<statusCode>"

Examples: 
|Project		  |statusCode|
|TestRepo3570|201|
#|TestRepository142|201|

@delete
Scenario Outline: Validate Github DELETE API

Given Github API exists
When Github DELETE API is called for the id <Project>
Then Verify the status code is "<statusCode>"

Examples: 
|Test case description |Project				      |statusCode|
|Valid id 		   	   |TestRepository141	 		  |204	     |
|Invalid id 		   |TestRepository142			  |204	     |


@update
Scenario Outline: Validate Github PUT API

Given Github API exists
When Github PUT API is called for the id <idValue> and <nameValue>
Then Verify the status code is "<statusCode>"

Examples: 
|Test case description |idValue				 	  |nameValue 		 |statusCode|
|Valid id 		   	   |TestRepository127_Updated |TestRepository127 |200	    |
|Invalid id 		   |TestRepository1254		  |Test_Updated		 |400	    |

@partialupdate
Scenario Outline: Validate Github PATCH API

Given Github API exists
When Github PATCH API is called for the id <idValue> and <description>
Then Verify the status code is "<statusCode>"

Examples: 
|Test case description |idValue				 	  |description 		 		  |statusCode|
|Valid id 		   	   |TestRepository127_Updated |New repository description |200	     |











