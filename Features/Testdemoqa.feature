Feature: Verifying that user is in DemoQa website

Background: User is in DemoQa Website
Given The user is in DemoQa website

@textbox @regression
Scenario: Validate the DemoQa Website textbox

When The user enters fistname and lastname
Then The user verifies the firstname and lastname 

@radioandcheck @regression
Scenario: Validate the DemoQa Website Checkboxes and RadioButton

When The user selects Marital Status as Single
And The user checks Hobby as Dance and Reading
Then verify the selected Marital Status and Checked Hobby

@dropdown @sanity
Scenario: Validate the DemoQa Website Country as Afghanistan by default

When The user checks the default value for country is Afghanistan
Then The user verifies the default value for country is Afghanistan