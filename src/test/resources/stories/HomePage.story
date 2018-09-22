Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development
					 
Scenario: User can Create an account.
Given the user on the registration Page
When the user enters contact details- <firstname>, <lastname>,<password>
And select the Gender <Gender>
And enter the Birthdate <Birthdate>
And Clicks the Complete Profile CTA
Then verify that the user can be registered
Examples:
|firstname|lastname|password|Gender|Birthdate|
|test |test|Foxpassword45|Female|01071990|

Scenario: User can able to login to his account.
Given the user on the registration Page
When Clicks Sign In CTA
When the user enters contact details- <Email>,<password>
And Clicks Sign In CTA
Then verify that user can be logged In.
Examples:
|Email|password|
|sravanthip907@gmail.com|Test123|



