@regression
Feature: Login

  Background: 
    Given User is on retail website homepage
    When User click on login link

  @login
  Scenario: Verify user able to login to tek Retail Application
    And User enter email 'sadullah2012@yahoo.com'  and password 'Nisar$123'
    And User click on login button
    Then User should be logged in into Account

  @register
  Scenario Outline: Verify user is able to register with tek retail website
    And User click on create new account link
    And User enter '<name>' and '<email>' and '<password>' and '<confpassword>'
    And User click on singup button
    Then Verify user account is created

    Examples: 
      | name        | email            | password  | confpassword |
      | GuardiansSD | emailme@test.com | Passed123 | Passed$123   |