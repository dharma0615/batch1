Feature: Amazon WebPage Testing

  Scenario: Verify "Get to Know Us" links
    Given Login to amazon website "https://www.amazon.in/"
    When Scroll down to bottom of the page
    Then Mandatory links should exists
      | Links        |
      | About Amazon |
      | Careers      |
