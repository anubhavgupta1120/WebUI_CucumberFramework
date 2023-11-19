Feature: Search and Place the order for Products
@OfferPage
Scenario Outline: Search Experience for product search in both Home and Offers Page
Given User is on GreenKart Home Page
When User searched with Shortname <Shortname> in Home page and extracted actual name of the product
Then User searched with same Shortname <Shortname> in offers page
And Validate product name in Offers page matches with Home page

Examples:
|Shortname|
|Tom			|
|Pot			|

