@SearchBookAndGetTheInformation
Feature: Search book and get the information of it

  @Valid
  Scenario Outline: As a user I want to Search book and get the information of it
    Given Users go into <site>
		When Users in 'Book Store' page
		And Users search book 'Git Pocket Guide' <book>
		And User click book 'Git Pocket Guide'
		Then User see 'Git Pocket Guide'

    Examples: 
      | site  												 | book 			| 
      | https://demoqa.com/books | Git Pocket Guide | 