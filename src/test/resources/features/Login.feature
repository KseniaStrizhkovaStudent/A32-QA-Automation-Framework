Feature: Login feature

  Background:
    Given I open Login Page

  Scenario: Login Success
    When I enter email "ksenia.strigkova@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

  Scenario: Login incorrect password
    When I enter email "ksenia.strigkova@gmail.com"
    And I enter incorrect password "te1t9tudent"
    And I submit
    Then I still Login page

  Scenario: Login Not existing email
    When I enter Not existing email "ksenia22@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I still Login page

  Scenario: Empty Login and Password
    When I enter Empty email " "
    And I enter Empty password " "
    And I submit
    Then I still Login page