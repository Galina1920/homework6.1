Feature: Select movie from list

  @Run
  Scenario: Select movie from list
    Given user is at 'https://www.cineplex.md/' page
    And user select 'FILME' category from menu bar
    When user select 'Patrula cățelușilor: Filmul 2D' movie from list
    Then page for specific movie is displayed and have the following specifications
    |specificationTitle | specification|
    |Audio              | Rom          |
    |Durata filmului    | 88 minute    |
    |Data premierei     | 26.08.2021   |
    |Format             | 2D           |
    |Vârsta             | 0+           |