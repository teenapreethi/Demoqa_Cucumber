Feature: User validate 5 items are added in flipkart

Scenario Outline: User validates the added item
Given the user is in filpkart website
When the user search and adds the "<item1>","<item2>","<item3>","<item4>","<item5>" to the cart
Then the user verified the cart for the added items

Examples:
	|item1|item2|item3|item4|item5|
	|iron Box|iphone 6|Nokia 7|moto G4 plus|OPPO A71|	
	