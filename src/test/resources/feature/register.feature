
@tag
Feature: checking the functionality of ds-algo portal link
  I want to check all the functions

  @tag1 
  Scenario: openshomePage
    Given The user opens DS Algo portal link
    When The user clicks the "Get Started" button
    Then The user should be redirected to homepage
    
  @tag2
  Scenario Outline: user is getting error message for empyty fields  below username testbox
  	Given The user opens register page
  	When User clicks registerbutton with all fields empty
  	Then <message> errormessage must display for feild <feild>
  		Examples: 
  	  |feild||message|
  		|"username"||"Please fill out this field."|
  
  @tag3
  Scenario Outline: user is getting error message for empyty fields  below password textbox
  	Given The user opens register page
  	When User clicks registerbutton after entering username  <username> with others fields empty
  	Then <message> errormessage must display for feild <feild>
  		Examples:
  		|feild| |username|  |message|
  		|"password"||"Numpy@sdet84_1"|  |"Please fill out this field."|
  		
  @tag4
  Scenario Outline: user is getting error message for empyty fields  below password confirmation textbox
  	Given The user opens register page
  	When User clicks registerbutton after entering username  <username>  and <password> with password confirmation field empty
  	Then <message> errormessage must display for feild <feild>
  		Examples:
  |feild|                   |username|       |password|         |message |
  |"password_confirmation"|    |"Numpy@sdet84_1"|  |"testpassword"|  |"Please fill out this field."|
  		
  @tag5
  Scenario Outline: user is getting error message for invalid username
  	Given The user opens register page
  	When User enters <username> , <password>, <passwordconfirmation> with characters other than letters,digits and "@/./+/-/_"
  	Then <message>  error msg  must display
  		Examples:
  		| username|  |password|  |passwordconfirmation|  | message  |
  		|"&**&**&" |  |"testpassword" |  |"testpassword"|  |"Please enter a valid username"|
  		|"&**&**&" |  |"testpassword1" |  |"testpassword1"|  |"Please enter a valid username"|
  		
  @tag6
  Scenario Outline: user is getting error message for username already exists
  	Given The user opens register page
  	When User enters valid existing <username> with  <password> and <passwordconfirmation>
  	Then <message>  error msg  must display
  		Examples:
  		| username|  |password|  |passwordconfirmation|  | message  |
  		| "Numpy@sdet84_1"|  |"testpassword"|  |"testpassword"|  |"Username already exists"|
  		
  @tag7
  Scenario Outline: user is getting error message for password mismatch
  	Given The user opens register page
  	When User clicks registerbutton after entering valid <username>  and different passwords in <password> and <passwordconfirmation>
  	Then <message>  error msg  must display
  		Examples:
  		| username|  |password|  |passwordconfirmation|  | message  |
  		| "Numpy@sdet84_1"|  |"testpassword"|  |"testpassword1"  | |"password_mismatch:The two password fields didn’t match."|
    
  @tag8
  Scenario Outline: The user is presented with error message for password with characters less than 8
  	Given The user opens register page
  	When The user enters a valid <username> with <password> and <passwordconfirmation> with characters less than 8
  	Then <message>  error msg  must display
  		Examples:
  		| username|  |password|  |passwordconfirmation|  | message  |
  		| "Numpy@sdet84_1"|  |"tes"|  |"tes"  | |"Password should contain at least 8 characters."|
   
    
    