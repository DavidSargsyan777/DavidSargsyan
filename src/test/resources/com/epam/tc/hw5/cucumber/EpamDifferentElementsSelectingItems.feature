Feature: Epam select items that will display on log rows

  Scenario: Selecting items on Different Elements page
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    When I click on 'Service' button in Header
    And I click on Different Elements button in Service dropdown
    And I click to select checkbox 'Water' and 'Wind'
    And I click to select radio 'Selen'
    And I click on dropdown to select 'Yellow' color
    Then 'Different Elements' page should be opened
    And 'Water' and 'Wind' checkboxes are selected
    And 'Selen' radio is selected
    And 'Yellow' color is selected
    And Log rows correspond to selected items
