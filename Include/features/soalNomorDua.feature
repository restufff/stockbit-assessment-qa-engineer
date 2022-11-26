@SearchBook
Feature: Search Book 

  @Valid
  Scenario Outline: As a user I want to Search Book that are not in the list
    Given Users Go to web <web>
    When User in 'Book Store' page
    And User search book <book>
		Then User see 'No rows found'


    Examples: 
    | web 										 | book 			 |
    | https://demoqa.com/books | qa engineer |