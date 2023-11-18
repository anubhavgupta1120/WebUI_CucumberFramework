Feature: Validate the User Flow

Scenario Outline: Validating user flow by successfully placing the order
Given User is on GreenKart Home Page
When User added products <product_list> with each having quantity <quantity> into the cart
And User select country <country> and perform checkout
Then <message> should be displayed on the Confirmation Page
Examples:
|product_list					|country|message																					 |quantity|
|Cucumber,Carrot,Beans|India	|Thank you, your order has been placed successfully|3				|