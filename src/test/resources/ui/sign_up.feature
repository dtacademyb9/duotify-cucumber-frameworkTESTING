@signup
@REGRESSION
Feature: Sign up feature

# Difference between background and @Before hook
#  scope, purpose, place
  Background: Common steps for all scenarios
    Given I click on the sign up link



   @login
  Scenario: Sign up with valid info

    When I fill up the fields with valid info and click sign up
    Then I should be able to sign up

  @valid
  Scenario: Sign up with valid info 2

    When I fill up the fields with valid info and click sign up
    Then I should be able to sign up
