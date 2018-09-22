Sample story

Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development
					 
Scenario: user
Given the user on the registration Page
When Clicks Sign In CTA
When the user enters contact details- <Email>,<password>
And Clicks Sign In CTA
And User Selects Navigation Tab <Tab>
And select the shows sub tab <subTab>
Then update the results in Excelsheet <name>

Examples:
|Email|password|Tab|subTab|name|
|sravanthip907@gmail.com|Test123|Shows|FX|FX|
|sravanthip907@gmail.com|Test123|Shows|National Geographic|National Geographic|
|sravanthip907@gmail.com|Test123|Shows|FOX Sports|FOX Sports|
|sravanthip907@gmail.com|Test123|Shows|All Shows|All Shows|