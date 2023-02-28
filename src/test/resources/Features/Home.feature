Feature: Home Page

  Scenario: Verify Success Message
    Given I am on the HomePage
    Then I click on contact form
    And I fill the form and submit
    Then I verify successfull submissiom