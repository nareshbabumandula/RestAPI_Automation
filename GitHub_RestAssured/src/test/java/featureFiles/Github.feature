Feature: Validate Github API


@github
Scenario Outline: Validate Github POST API

Given Github POST API exists
When Github POST API is called with the name <nameValue>
#Then Verify the status code is <statusCode>

Examples: 
|nameValue		  |statusCode|
|TestProject222   |201	   |


@trello
Scenario Outline: Validate Trello GET API

Given Trello API exists
When Trello GET API is called for the id <idValue>
Then Verify the status code is <statusCode>

Examples: 
|Test case description |idValue				      |statusCode|
|Valid id 		   	   |639aa49fe472db02c8060012  |200	     |
|Invalid id 		   |639979c943d992026f7f56df00|400	     |


@trello
Scenario Outline: Validate Trello PUT API

Given Trello API exists
When Trello PUT API is called for the id <idValue> and <nameValue>
Then Verify the status code is <statusCode>

Examples: 
|Test case description |idValue				 	  |nameValue 		 |statusCode|
|Valid id 		   	   |639aa49fe472db02c8060012  |sample1 updated   |200	    |
|Invalid id 		   |639979c943d992026f7f56df00|To do name updated|400	    |


@trello
Scenario Outline: Validate Trello DELETE API

Given Trello API exists
When Trello DELETE API is called for the id <idValue>
Then Verify the status code is <statusCode>

Examples: 
|Test case description |idValue				      |statusCode|
|Valid id 		   	   |639aa49fe472db02c8060012  |200	     |
|Invalid id 		   |639979c943d992026f7f56df00|400	     |







