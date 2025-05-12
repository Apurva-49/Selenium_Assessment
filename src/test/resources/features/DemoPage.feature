Feature: Demo Page Testing

  Scenario: User fills in the Text input field and verifies it is filled correctly
    Given user navigates to the demo page
    When user fills in the text input field with "MAPS is boring"
    Then user verifies the text input field contains "MAPS is boring"

  Scenario: Grab the rgb color from "HTML SVG with rect" and populate a variable with the result
    Given user navigates to the demo page
    When user retrieves the color from the SVG rectangle
    Then user prints the color value

  Scenario: Toggle the checkBox in the iFrame and confirm it is checked
    Given user navigates to the demo page
    When user toggles the checkbox in the iframe
    Then user verifies the checkbox is checked

  Scenario: Change Select Dropdown to "Set to 50%" and Assert the HTML meter changes to what is selected
    Given user navigates to the demo page
    When user sets the dropdown to "Set to 50%"
    Then user verifies the HTML meter changes to "0.5"