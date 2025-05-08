Feature: Demo Page Testing

  Scenario: User fills in the Text input field and verifies it is filled correctly
    Given user navigates to demo page
    When user fills in the Text input field with "MAPS is boring"
    Then the user verifies text input should contain "MAPS is boring"



  Scenario: Grab the rgb color from "HTML SVG with rect" and populate a variable with the result
    Given user navigates to demo page
    When user get the color from the SVG rectangle
    Then user print the color value

  Scenario: Toggle the CheckBox in the iFrame and confirm it is checked
    Given user navigates to demo page
    When user toggles the checkbox in the iframe
    Then user verifies it should be checked

  Scenario: Change Select Dropdown to "Set to 50%" and Assert the HTML meter changes to what is selected
    Given user navigates to demo page
    When user set the dropdown to "Set to 50%"
    Then the HTML meter should change to "0.5"