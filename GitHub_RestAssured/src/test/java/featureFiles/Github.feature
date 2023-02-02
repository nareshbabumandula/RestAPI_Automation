Feature: Validate Github API

@github
Scenario Outline: Validate Github GET API

Given Github API exists
When Github GET API is called for the id <Project>
Then Verify the status code is <statusCode>

Examples: 
|Test case description |Project				      |statusCode|
|Valid id 		   	   |TestProject888  		  |200	     |
|Invalid id 		   |TestProject813	          |400	     |
 

@github123
Scenario Outline: Validate Github POST API

Given Github POST API exists
When Github POST API is called with the name <Project>
Then Verify the status code is <statusCode>

Examples: 
|Project		  |statusCode|
|TestProject253   |201	   |

@github
Scenario Outline: Validate Github DELETE API

Given Github API exists
When Github DELETE API is called for the id <Project>
Then Verify the status code is <statusCode>

Examples: 
|Test case description |Project				      |statusCode|
|Valid id 		   	   |TestProject246  		  |204	     |
|Invalid id 		   |TestProject798			  |400	     |


@dryrun
Scenario Outline: Validate Github PUT API

Given Github API exists
When Github PUT API is called for the id <idValue> and <nameValue>
Then Verify the status code is <statusCode>

Examples: 
|Test case description |idValue				 	  |nameValue 		 |statusCode|
|Valid id 		   	   |TestProject_444  |TestProject_444_Updated	 |200	    |
|Invalid id 		   |TestProject_556|TestProject_555_Updated		 |400	    |









