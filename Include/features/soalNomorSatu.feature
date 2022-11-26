#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@SelectMenu
Feature: Select all type of menu
  I want to use all select type in Select Menu page

  @tag1
  Scenario Outline: Title of your scenario outline
    Given User go to <site>
    When User in 'select menu' page
    And User choose select value <selectValue>
    And User choose select one <selectOne>
    And User choose old style select menu <oldStyleSelectMenu>
		And User choose multi select drop down 'all color'
		Then User success input all select menu
    

    Examples: 
      | site  												 | selectValue 				 | selectOne  | oldStyleSelectMenu | 
      | https://demoqa.com/select-menu | Another root option | other 			| Aqua |