@SelectMenu
Feature: Select all type of menu
  

  @Valid
  Scenario Outline: As a user I want to use all select type in Select Menu page
    Given User go to <site>
    When User in 'select menu' page
    And User choose select value <selectValue>
    And User choose select one <selectOne>
    And User choose old style select menu <oldStyleSelectMenu>
		And User choose multi select drop down 'all color'
		Then User success input all select menu
    

    Examples: 
      | site  												 | selectValue 				 | selectOne  | oldStyleSelectMenu | 
      | https://demoqa.com/select-menu | Another root option | other 			| Aqua 							 |